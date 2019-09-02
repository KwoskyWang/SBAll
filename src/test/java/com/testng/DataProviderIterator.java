package com.testng;

import com.bean.UserTransfer;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by moooke on 2019/8/30.
 * 这是普通的 DataProvider的迭代使用方式
 */
@SpringBootTest
public class DataProviderIterator {

    // 返回Iterator<Object[]>
    @DataProvider(name = "iterator")
    public Iterator<Object[]> dp1() {
        List<Object> item = new ArrayList<Object>();

        // 添加第一个用户
        UserTransfer user1 = new UserTransfer();
        user1.setName("haijin");
        user1.setReceiver("binbin");
        user1.setSalary(500);
        item.add(user1);

        // 添加第二个用户
        UserTransfer user2 = new UserTransfer();
        user2.setName("binbin");
        user2.setReceiver("haijin");
        user2.setSalary(500);
        item.add(user2);

        List<Object[]> users = new ArrayList<Object[]>();

        for (Object u : item) {
            //做一个形式转换
            users.add(new Object[] { u });
        }
        return users.iterator();

    }

    @Test(dataProvider = "iterator")
    public void testProvider(UserTransfer user) {
        System.out.println("Transfer Name is: "+ user.getName() +"\n"+"Receiver is: " + user.getReceiver() +"\n"+"Money is: " + user.getSalary());

    }

}
