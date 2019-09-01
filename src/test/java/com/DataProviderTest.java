package com;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

/**
 * 这个是用来测试把测试数据通过配置文件管理的类.
 * Created by moooke on 2019/8/29.
 *
 * 可以实现参数的迭代输入
 */
@SpringBootTest
public class DataProviderTest extends BaseTest{

    @Test(dataProvider = "readTestData")
    public void dataProviderTest(String calDate, String targetId, String expect) {
        System.out.println(calDate);
        System.out.println(targetId);
        System.out.println(expect);
    }


    /**
     * invocationCount 为执行次数, invocationTimeOut 为总的耗时超时时间设置,超过设置的时间抛出中断异常.
     * 这两个参数可以用作性能测试的通过指标来设置
     * @param calDate
     * @param targetId
     * @param expect
     */
    @Test(dataProvider = "readTestData", invocationCount = 2, invocationTimeOut = 2000)
    public void dataProviderMultiPool(String calDate, String targetId, String expect) {
        Long id = Thread.currentThread().getId();
        System.out.println(calDate + ", ThreadNum="+ id);
        System.out.println(targetId + ", ThreadNum="+ id);
        System.out.println(expect + ", ThreadNum="+ id);
    }


}
