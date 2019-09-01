package com.dependson;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

/**
 * Created by moooke on 2019/8/29.
 */
@SpringBootTest
public class DependsOn {

    @Test
    public void serverStartedOk() {
        int i = 1/0;
    }

    @Test(dependsOnMethods = { "serverStartedOk" })
    public void method1() {}

}
