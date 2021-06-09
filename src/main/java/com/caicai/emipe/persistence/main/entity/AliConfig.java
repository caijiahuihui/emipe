package com.caicai.emipe.persistence.main.entity;

import lombok.*;

/**
 * @author caicai
 * @create 2021/4/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AliConfig implements PayConfigInterface {

    private String accountNo;

    private String key;

    private String companyName;
}
