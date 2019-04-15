package com.yuhao.service;

import com.yuhao.model.SysLogBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description：
 * @author：Mr.Yu
 * @date：2019/4/2 15:42
 * @version：V1.0
 */
@Slf4j
@Service
public class SysLogService {

    public boolean save(SysLogBO sysLogBO) {
        // 这里就不做具体实现了
        log.info(sysLogBO.getParams());
        log.info(sysLogBO.toString());
        return true;
    }

}
