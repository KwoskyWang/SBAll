package com.controller;

import com.bean.User;
import com.bean.UserTransfer;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by moooke on 2019/4/23.注意看配置文件信息
 */
//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    public List<User> testQuery() {
        for (User user : userService.selectUserByName("Daisy")) {
            System.out.println("name" + user.getName());
            System.out.println("age" + user.getAge());
            System.out.println("salary" + user.getSalary());
        }
        return userService.selectUserByName("Daisy");
    }

    @RequestMapping("/update")
    public List<User> testUpdate() {
        return userService.updateUserByName("Daisy");
    }

    @RequestMapping("/test")
    public String Test() {
        return "test";
    }

    @GetMapping("/insert")
    public List<User> testInsert(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "age", required = false) int age,
            @RequestParam(value = "salary", required = false) double salary) {
        userService.insertService(name, age, salary);
        return userService.selectAllUser();
    }

    @PostMapping("/transfermoney")
    public List<User> transferMoney(
            @RequestBody UserTransfer user) {
        userService.transferMoney(user);
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete() {
        userService.deleteService(28);
        return "OK";
    }

}
