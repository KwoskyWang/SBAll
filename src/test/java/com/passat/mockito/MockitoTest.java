package com.passat.mockito;

import com.bean.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by moooke on 2019/9/3.
 */
public class MockitoTest {

    /**
     * 通过简单的 mock方法模拟List, ArrayList等对象
     */
    @Test
    public void createMockObject() {
        // 使用 mock 静态方法创建 Mock 对象.
        List mockedList = mock(List.class);
        Assert.assertTrue(mockedList instanceof List);

        // mock 方法不仅可以 Mock 接口类, 还可以 Mock 具体的类型.
        // 试了一下并不会产生什么输出, 但是如果不对的话会报错, 例如把 mockedArrayList instanceof List 换成 Map
        ArrayList mockedArrayList = mock(ArrayList.class);
        Assert.assertTrue(mockedArrayList instanceof List);
        Assert.assertTrue(mockedArrayList instanceof ArrayList);
    }


    /**
     * 简单地使用一下断言
     */
    @Test
    public void configMockObject() {
        List mockedList = mock(List.class);

        // 我们定制了当调用 mockedList.add("one") 时, 返回 true
        when(mockedList.add("one")).thenReturn(true);
        // 当调用 mockedList.size() 时, 返回 1
        when(mockedList.size()).thenReturn(1);

        Assert.assertTrue(mockedList.add("one"));
        // 因为我们没有定制 add("two"), 因此返回默认值, 即 false.
        Assert.assertFalse(mockedList.add("two"));
        Assert.assertEquals(mockedList.size(), 1);

        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");
        String result = i.next() + " " + i.next();
        //assert
        Assert.assertEquals("Hello, Mockito!", result);
    }

    /**
     * 几种验证方式
     */
    @Test
    public void testVerify() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        when(mockedList.size()).thenReturn(5);
        Assert.assertEquals(mockedList.size(), 5);
        System.out.println(mockedList.get(1)); //讲道理这里应该打印出来 "two", 但打印的是 null, mock的数据操作都是在沙盒中进行的.

        verify(mockedList, atLeastOnce()).add("one");                               //校验 mockedList.add("one") 至少被调用了 1 次(atLeastOnce)
        verify(mockedList, times(1)).add("two");            //校验 mockedList.add("two") 被调用了 1 次(times(1))
        verify(mockedList, times(3)).add("three times");    //校验 mockedList.add("three times") 被调用了 3 次(times(3))
        verify(mockedList, never()).isEmpty();                                      //校验 mockedList.isEmpty() 从未被调用(never)
    }


    /**
     * 从这个例子可以看出如何使用mock
     */
    @Test
    public void testUser() {
        User user = mock(User.class);

        // 对 user 进行定制.
        when(user.getName()).thenReturn("100");             //这行代码就是, 只要我们调用了 user.getName, 那么返回的就是"100"

//        user.setName("Who am i?");
//        user.setAge(18);                                    //这里我设置了 setAge(18), 但是下面断言会报错, 证明并没有一个实际的对象存在,对象是被mock模拟出来的不可用的.
        when(user.getAge()).thenReturn(18);

        // 进行断言
        Assert.assertEquals(user.getAge(), 18);

        Assert.assertEquals(user.getName(), "100");
    }

}
