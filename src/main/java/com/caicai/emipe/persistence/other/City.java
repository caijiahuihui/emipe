package com.caicai.emipe.persistence.other;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author caicai
 * @create 2021/6/7
 */
@Data
@Table(name = "cnarea_level_1")
@Entity
public class City implements Serializable {

    private static final long serialVersionUID = 921500963943309099L;
    
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "level")
    @Type(type = "java.lang.Integer")
    private Integer level;

    @Column(name = "parent_code")
    private Long parentCode;

    @Column(name = "area_code")
    private Long areaCode;

    @Column(name = "zip_code")
    private Integer zipCode;

    @Basic
    @Column(name = "city_code", columnDefinition = "char(6) comment `城市编码`")
    @Type(type = "java.lang.String")
    private String cityCode;

    @Column(name = "`name`")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "merger_name")
    private String mergerName;

    @Column(name = "pinyin")
    private String pinyin;

    @Column(name = "lng")
    private BigDecimal lng;

    @Column(name = "lat")
    private BigDecimal lat;
}
