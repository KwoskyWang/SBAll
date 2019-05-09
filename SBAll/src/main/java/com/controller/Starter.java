package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by moooke on 2019/4/23.
 */
@RestController
@RequestMapping("/a")
public class Starter {

    @RequestMapping("/hello")
    public String hello(){
        return "My Hello";
    }
}
