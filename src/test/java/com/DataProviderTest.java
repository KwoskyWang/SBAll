package com;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

/**
 * Created by moooke on 2019/8/29.
 */
@SpringBootTest
public class DataProviderTest extends BaseTest{

    @Test(dataProvider = "readTestData")
    public void dataProviderTest(String calDate, String targetId, String expect) {
        System.out.println(calDate);
        System.out.println(targetId);
        System.out.println(expect);
    }
}
