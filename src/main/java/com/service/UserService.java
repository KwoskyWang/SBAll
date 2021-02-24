package com.service;

import com.bean.User;
import com.bean.UserTransfer;
import com.dao.UserDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by moooke on 2019/4/23.
 */
@Service
@PropertySource(value = {"classpath:application.yml"})
public class UserService {

    @Value("#{${product}}")
    private Map<Long,String> envMap;

    @Autowired
    private Environment env;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserServiceLevelTwo userServiceLevelTwo;

    @Autowired
    private TransferRecordService transferRecordService;

    Logger log = Logger.getLogger("userServiceLevel 的日志");
    org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 根据名字查找用户
     * cacheNames: 缓存名字, 可以设置多个缓存,每个名字对应一个缓存
     * key: 缓存容器中的key值, 返回值是value值
     * 如果有多个缓存, 通过 #root.cache[0].name 来找到key值.
     */
//    @Cacheable(cacheNames = "selectUserByName")
    public List<User> selectUserByName(String name) {

        //测试从配置文件取值
        System.out.println(envMap.get(1L));
        System.out.println(env.getProperty("db.header.erp"));
        System.out.println(env.getProperty("db.header.peanut"));
        System.out.println(env.getProperty("db.postscript"));
        return userDao.findUserByName(name);
    }

//    @CachePut(cacheNames = "selectUserByName")
    public List<User> updateUserByName(String name) {
        return userDao.updateUserByName(name);
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
    public void insertService(String name, int age, double salary) {
        userDao.insertUser(name, age, salary);
    }

    /**
     * 根据id 删除用户
     */
    public void deleteService(int id) {
        userDao.deleteUser(id);
    }

    /**
     * 模拟事务。由于加上了 @Transactional注解，如果转账中途出了意外 Transfer 和 Receiver 的钱都不会改变。
     */
    @Transactional
    public String transferMoney(UserTransfer userTransfer) {
        log.info("一通操作,然后把对象交给下一个Service.");
        userServiceLevelTwo.transferMoney(userTransfer);
        transferRecordService.transferRecord(userTransfer);
        return "转账成功";
    }
}
