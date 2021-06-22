package com.caicai.emipe.persistence.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author caicai
 * @create 2021/5/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emipe_user")
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 8032571108109321776L;
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String passWord;
}
