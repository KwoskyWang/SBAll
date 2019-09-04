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
public class GroovyTest {

    @Test
    // 调用evaluate方法直接执行一段Groovy
    public static void testGroovy1() throws CompilationFailedException, IOException {
        GroovyShell groovyShell = new GroovyShell();
        groovyShell.evaluate("println 'My First Groovy shell.'");
    }

    @Test
    // 调用GroovyShellTest1
    public static void testGroovy2() throws CompilationFailedException, IOException {
        GroovyShell groovyShell = new GroovyShell();
        Object result = groovyShell.evaluate(new File("src/test/java/resources/com/passat/groovy/groovyShellTest1.groovy"));
        System.out.println(result.toString());
    }


    @Test
    // 调用GroovyShellTest2
    public static void testGroovy3() throws CompilationFailedException, IOException {
        // 调用带参数的groovy shell时，使用bind绑定数据
        Binding binding = new Binding();
        binding.setProperty("name", "Google!");

        GroovyShell groovyShell = new GroovyShell(binding);
        Object result = groovyShell.evaluate(new File("src/test/java/resources/com/passat/groovy/GroovyShellTest2.groovy"));
        System.out.println(result.toString());
    }


    @Test
    public void groovyEngine() throws IOException, ResourceException, ScriptException {

        // GroovyScriptEngine的根路径，如果参数是字符串数组，说明有多个根路径
        GroovyScriptEngine engine = new GroovyScriptEngine("src/test/java/resources/com/passat/groovy/");
        //GroovyScriptEngine engine = new GroovyScriptEngine(new String[] {"src/main/java/com/juxinli/groovy/shell/"});

        Binding binding = new Binding();

        Object result1 = engine.run("groovyDataTest1.groovy", binding);
        System.out.println(result1);
        binding.setVariable("num", result1);
        Object result2 = engine.run("groovyDataTest2.groovy", binding);
        System.out.println(result2);
        binding.setVariable("num", result2);
        Object result3 = engine.run("groovyDataTest3.groovy", binding);
        System.out.println(result3);

    }



}
