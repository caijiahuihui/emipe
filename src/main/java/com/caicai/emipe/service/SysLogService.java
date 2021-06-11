package com.caicai.emipe.service;

import com.caicai.emipe.persistence.main.entity.SysLog;
import com.caicai.emipe.persistence.main.repository.ISysLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caicai
 * @create 2021/6/9
 */
@Service
public class SysLogService {
    @Autowired
    private ISysLogRepository sysLogRepository;

    public SysLog save(SysLog log) {
        return sysLogRepository.save(log);
    }
}
