package com.caicai.emipe.persistence.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author caicai
 * @create 2021/5/18
 */
@Data
public class EntityUser {

    private String id;

    private Date createDate;

    private Date modifiedDate;

    private String name;

    private String password;

    private boolean isShow;

    private boolean status;

    private boolean auth;

    private int record;

    private boolean isLock;

    private String userAuthId;

    private String idCard;

    private int level;

    private Date lastLoginTime;

    private String statusChannel;

    private String headPortrait;

    private String payPassWord;

    private boolean isRead;
}
