package com.testng;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.*;

import java.util.logging.Logger;

/**
 * Created by moooke on 2019/8/28.
 */
@SpringBootTest
@Test(groups = "第一组")
public class TestMain {

    Logger logger = Logger.getLogger("测试类的Log信息.");

    @BeforeGroups
    public void beforeGroup(){
        logger.info("---beforeGroup---在Group的第一个测试方法之前运行");
    }

    @BeforeSuite
    public void beforeSuite(){
        logger.info("---beforeSuite---在Suite之前运行");
    }

    @BeforeClass
    public void beforeClass(){
        logger.info("---beforeClass---在当前Class的第一个测试方法之前运行");
    }

    @BeforeTest
    public void beforeTest(){
        logger.info("---beforeTest---在运行属于<test>标记内的类的任何测试方法之前之前运行");
    }

    @BeforeMethod
    public void beforeMethod(){
        logger.info("---beforeMethod---在每一个测试方法之前运行");
    }

    @Test
    public void simpleCase1(){
        logger.info("simpleCase1 第一个测试用例");
    }

    @Test
    public void simpleCase2(){
        logger.info("simpleCase2 第二个测试用例");
    }

    @Test
    public void simpleCase3(){
        logger.info("simpleCase3 第三个测试用例");
    }

    @AfterMethod
    public void afterMethod(){
        logger.info("---afterMethod---在每一个测试方法之后运行");
    }

    @AfterClass
    public void afterClass(){
        logger.info("---afterClass---在当前Class的最后一个测试方法之后运行");
    }

    @AfterSuite
    public void afterSuite(){
        logger.info("---afterSuite---在Suite之后运行");
    }

    @AfterTest
    public void afterTest(){
        logger.info("---afterTest---在运行属于<test>标记内的类的任何测试方法之前之后运行");
    }

    @AfterGroups
    public void afterGroup(){
        logger.info("---afterGroup---在Group的最后一个测试方法之后运行");
    }
}
