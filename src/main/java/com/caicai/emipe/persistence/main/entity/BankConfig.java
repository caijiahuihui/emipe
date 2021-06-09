package com.caicai.emipe.persistence.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author caicai
 * @create 2021/4/1
 */
@Data
@AllArgsConstructor
public class BankConfig implements PayConfigInterface {
    private String bankNo;

    private String accountName;

    private String linkKey;
}
