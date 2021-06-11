package com.caicai.emipe.persistence.main.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @author caicai
 * @create 2021/4/19
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -9081757049416428194L;

    /**
     * 排序属性枚举
     */
    @AllArgsConstructor
    @Getter
    public enum SortProperties {
        CREATE_DATE("createDate");

        private String remark;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid-id")
    @GenericGenerator(
            name = "uuid-id",
            strategy = "com.caicai.emipe.util.GeneratorUtil")
    @Column(name = "id")
    protected String id;

    @Column(name = "create_date")
    @Temporal(TIMESTAMP)
    protected Date createDate = new Date();
}
