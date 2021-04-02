package com.caicai.emipe.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author caicai
 * @create 2021/4/1
 */
@Data
@AllArgsConstructor
public class WechatConfig implements PayConfigInterface {

    private String accountNo;

    private String key;
}
