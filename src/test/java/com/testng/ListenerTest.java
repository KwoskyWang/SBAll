package com.testng;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by moooke on 2019/9/1.
 */
public class ListenerTest extends TestListenerAdapter {

    private static Logger logger = Logger.getLogger(">-------来自监听器的消息-------<");

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        logger.info(tr.getName() + " Failure");
        takeScreenShot(tr);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        logger.info(tr.getName() + " Skipped");
        takeScreenShot(tr);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        logger.info(tr.getName() + " Success");
        takeScreenShot(tr);
    }

    @Override
    public void onTestStart(ITestResult tr) {
        super.onTestStart(tr);
        logger.info(tr.getName() + " Start");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);

    }

    /**
     * 自动截图，保存图片到本地以及html结果文件中
     *
     * @param tr
     */
    private void takeScreenShot(ITestResult tr) {
        //如果是测试APP内容, 可以在这里实现截图代码
        System.out.println(">------在这里实现方法:"+ tr.getName() +"的截图代码------<");
    }
}
