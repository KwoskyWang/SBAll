package com;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by moooke on 2019/9/1.
 */
public class MyRetry implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
