package com.caicai.emipe.persistence.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author caicai
 * @create 2021/5/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emipe_user")
@Entity
public class User {
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String passWord;
}
