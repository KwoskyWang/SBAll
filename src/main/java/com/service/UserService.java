package com.service;

import com.bean.User;
import com.bean.UserTransfer;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by moooke on 2019/4/23.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserServiceLevelTwo userServiceLevelTwo;
    Logger log = Logger.getLogger("userServiceLevel 的日志");

    /**
     * 根据名字查找用户
     */
    public List<User> selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

    /**
     * 查找所有用户
     */
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    /**
     * 插入两个用户
     */
    public void insertService(String name,int age,double salary) {
        userDao.insertUser(name, age, salary);
    }

    /**
     * 根据id 删除用户
     */
    public void deleteService(int id) {
        userDao.deleteUser(id);
    }

    /**
     * 模拟事务。由于加上了 @Transactional注解，如果转账中途出了意外 SnailClimb 和 Daisy 的钱都不会改变。
     */
    @Transactional
    public void transferMoney(UserTransfer userTransfer) {
        log.info("一通操作,然后把对象交给下一个Service.");
        userServiceLevelTwo.transferMoney(userTransfer);
    }
}
