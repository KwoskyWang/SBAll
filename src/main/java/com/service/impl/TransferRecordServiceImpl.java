package com.service.impl;

import com.bean.UserTransfer;
import com.service.TransferRecordService;
import org.springframework.stereotype.Service;

/**
 * Created by moooke on 2019/9/3.
 */
@Service
public class TransferRecordServiceImpl implements TransferRecordService {

    public void transferRecord(UserTransfer userTransfer){
        System.out.println("转账人:"+userTransfer.getName());
        System.out.println("收款人:"+userTransfer.getReceiver());
        System.out.println("转账金额:"+userTransfer.getSalary());
    }
}
