package com.passat.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by moooke on 2019/9/3.
 */
@Test
public class GroovyLoaderTest {

    private static GroovyClassLoader groovyClassLoader = null;

    public static void initGroovyClassLoader() {
        CompilerConfiguration config = new CompilerConfiguration();
        config.setSourceEncoding("UTF-8");
        // 设置该GroovyClassLoader的父ClassLoader为当前线程的加载器(默认)
        groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader(), config);
    }

    /**
     * 通过GroovyClassLoader加载GroovyShellClass1，并反射调用其sayHello(String name, String sex, int age)方法
     *
     */
    public static String invokeSayHello(String name, String sex, int age) {
        String result = "";
        File groovyFile = new File("src/test/java/resources/com/passat/groovy/GroovyShellClass1.groovy");
        if (!groovyFile.exists()) {
            return result;
        }
        try {
            // 获得GroovyShellClass1加载后的class
            Class<?> groovyClass = groovyClassLoader.parseClass(groovyFile);
            // 获得GroovyShellClass1的实例
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
            // 反射调用sayHello方法得到返回值
            Object methodResult = groovyObject.invokeMethod("sayHello", new Object[] {name, sex, age});
            if (methodResult != null) {
                result = methodResult.toString();
            }
        } catch (Exception e) {
            System.out.println("加载groovy类失败");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        initGroovyClassLoader();
        System.out.println(invokeSayHello("张三", "男", 25));
    }

}
