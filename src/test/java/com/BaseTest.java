package com;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Method;

/**
 * Created by moooke on 2019/8/29.
 */
@ContextConfiguration
public class BaseTest extends AbstractTestNGSpringContextTests {

    @DataProvider(name = "readTestData")
    public Object[][] testData(Method testMethod) {

        if (testMethod.getName().equals("testChooseShift")) {
            return new Object[][]{new Object[]{135001}};
        }

        String className = testMethod.getDeclaringClass().getSimpleName();

        JSONObject paramJson = readParam(className);
        JSONArray paramArr = paramJson.getJSONArray("data");

        Object[][] param = new Object[paramArr.size()][];
        for (int i = 0; i < paramArr.size(); i++) {
            JSONArray childArr = paramArr.getJSONArray(i);
            param[i] = new Object[childArr.size()];
            for (int j = 0; j < childArr.size(); j++) {
                param[i][j] = childArr.get(j).toString();
            }
        }

        return param;
    }

    /**
     *
     * @param className
     * @return
     */
    public JSONObject readParam(String className) {
        String paramText = this.readParamFile(className);

        JSONObject paramJson = null;

        try {
            paramJson = (JSONObject) JSONObject.parse(paramText);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return paramJson;
    }

    /**
     *
     * @param fileName
     * @return
     */
    public String readParamFile(String fileName) {

        String fileUrl = String.join("/", "param", fileName + ".json");

        return this.readFile(fileUrl);
    }

    /**
     *
     * @param fileUrl
     * @return
     */
    public String readFile(String fileUrl) {
        InputStream fi = null;
        BufferedReader bo = null;
        try {
            fi = this.getClass().getClassLoader().getResourceAsStream(fileUrl);
            bo = new BufferedReader(new InputStreamReader(fi, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder stB = new StringBuilder();
        try {
            String lineRead = "";
            while ((lineRead = bo.readLine()) != null) {
                stB.append(lineRead);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fi.close();
                bo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stB.toString();
    }
}
