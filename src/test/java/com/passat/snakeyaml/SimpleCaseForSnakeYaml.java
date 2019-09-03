package com.passat.snakeyaml;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.util.List;

/**
 * Created by moooke on 2019/9/2.
 * SnakeYaml 是生成和解析YAML的第三方工具
 * 这里会写到几个简单集成到 passat的用法.
 *
 *  具体的内容可以参考以下链接:
 *  YAML: https://www.jianshu.com/p/97222440cd08
 *  SnakeYaml: https://www.jianshu.com/p/d8136c913e52
 */
@Test
public class SimpleCaseForSnakeYaml {

    /**
     * 通过 Yaml对象的load方法解析 yaml字符串
     */
    @Test
    public void simpleCase(){
    String yamlStr = "key: hello yaml";
    Yaml yaml = new Yaml();
    Object ret = yaml.load(yamlStr);
    System.out.println(ret);                            //返回解析之后的对象
    System.out.println(ret.getClass().getSimpleName()); //查看ret的类型,会发现是一个 LinkedHashMap
    }

    /**
     * 看一下简单的yaml,配置一个List打印
     */
    @Test
    public void testType() throws Exception {
        Yaml yaml = new Yaml();
        List<String> ret = (List<String>)yaml.load(this.getClass().getClassLoader()
                .getResourceAsStream("test.yaml"));
        System.out.println(ret);
    }


    /**
     * 通过yaml配置一个我们已经写好的对象类型
     */
    @Test
    public void testAddress() throws Exception {
        Yaml yaml = new Yaml();
        Address ret = yaml.loadAs(this.getClass().getClassLoader()
                .getResourceAsStream("address.yaml"), Address.class);
        System.out.println(ret);
        Assert.assertNotNull(ret);
        Assert.assertEquals("MI", ret.getState());
    }


    /**
     * 通过yaml强制转换创建一个person类
     */
    @Test
    public void testPerson() throws Exception {
        Yaml yaml = new Yaml();
        Person ret = (Person) yaml.load(this.getClass().getClassLoader()
                .getResourceAsStream("person.yaml"));
        System.out.println(ret);
        Assert.assertNotNull(ret);
    }

    /**
     * 通过创建Yaml对象的时候,传入了一个new Constructor(Person.class)指定对象,省去在yaml文件中进行配置
     * 通过更改配置文件自动识别参数类型
     */
    @Test
    public void testPerson2() throws Exception {
        Yaml yaml = new Yaml(new Constructor(Person2.class));
        Person2 ret = (Person2) yaml.load(this.getClass().getClassLoader()
                .getResourceAsStream("person2.yaml"));
        System.out.println(ret);
        Assert.assertNotNull(ret);
    }

}
