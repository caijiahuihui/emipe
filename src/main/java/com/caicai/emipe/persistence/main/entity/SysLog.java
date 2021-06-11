package com.caicai.emipe.persistence.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Syslog实体类
 *
 * @author caicai
 * @create 2021/6/9
 */
@Data
@Entity
@Table(name = "sys_log")
@AllArgsConstructor
@NoArgsConstructor
public class SysLog extends BaseEntity {

    private static final long serialVersionUID = 4192458699746968728L;

    @Column(name = "username")
    private String username;

    @Column(name = "clazz")
    private String clazz;

    @Column(name = "method")
    private String method;

    @Column(name = "args")
    private String args;

    @Column(name = "exception")
    private String exception;


}
