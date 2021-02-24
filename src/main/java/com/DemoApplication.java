package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

@EnableCaching //开启缓存注解
@SpringBootApplication
// 此注解表示动态扫描DAO接口所在包，实际上不加下面这条语句也可以找到
@MapperScan(basePackages = {"com.dao"})
//@ComponentScan(basePackages = {"com.service","com.service.impl"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
