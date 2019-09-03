package com.service;

import com.bean.UserTransfer;
import org.springframework.stereotype.Service;

/**
 * Created by moooke on 2019/9/3.
 */
@Service
public interface TransferRecordService {

    public void transferRecord(UserTransfer userTransfer);
}
