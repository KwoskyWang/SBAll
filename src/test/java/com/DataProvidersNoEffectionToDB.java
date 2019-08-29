package com;

import com.bean.UserTransfer;
import com.service.UserService;
import com.service.UserServiceLevelTwo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * Created by moooke on 2019/8/29.
 * BaseTestNoEffectionToDB 继承于 AbstractTransactionalTestNGSpringContextTests
 * 继承 AbstractTransactionalTestNGSpringContextTests 的测试用例会对数据库操作自动回滚,不会影响数据库数据.
 *
 */
@SpringBootTest
public class DataProvidersNoEffectionToDB extends BaseTestNoEffectionToDB {

    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceLevelTwo userServiceLevelTwo;

    /**
     * 创建一个数据供应模块,手动注入数据
     * 我们也可以通过配置文件, 参数化地来管理测试数据用例
     * @return
     */
    @DataProvider(name = "转账")
    public Object[][] uTProvider(){
        UserTransfer transfer = new UserTransfer();
        transfer.setName("binbin");
        transfer.setReceiver("haijin");
        transfer.setSalary(1000);
        return new Object[][]{
                new Object[]{ transfer }
        };
    }

    /**
     *
     * @param transfer
     * 这里是不能够去 new一个Service出来的
     * 因为 @autowire跟XML方式注入类似，是Ioc容器负责创建新的实例.
     * 如果我们自己去 new 一个对象, 新对象的依赖变量都是没有注入的.
     */
    @Test(dataProvider = "转账")
    public void TransferTest(UserTransfer transfer){
        System.out.println(transfer);
//        UserService userService = new UserService();
        userService.transferMoney(transfer);
    }
}
