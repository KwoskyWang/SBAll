package spring_demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by moooke on 2020/4/18.
 */
@Service
public class AsyncService { //批量新增操作

    @Async
    public void batchAdd() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("批量保存数据中...."+this.toString() ); }
}
