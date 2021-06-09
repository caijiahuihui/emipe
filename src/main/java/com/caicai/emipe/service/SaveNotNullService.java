package com.caicai.emipe.service;

import com.caicai.emipe.persistence.main.entity.AliConfig;
import com.caicai.emipe.persistence.main.entity.PayConfigInterface;
import org.springframework.stereotype.Service;

/**
 * @author caicai
 * @create 2021/4/1
 */
@Service
public class SaveNotNullService {

    public <T extends PayConfigInterface> T saveNotNull(T t) {
        PayConfigInterface oldPay = new AliConfig();
        return null;
    }

}
