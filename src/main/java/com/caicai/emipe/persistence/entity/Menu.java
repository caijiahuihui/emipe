package com.caicai.emipe.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author caicai
 * @create 2021/4/19
 */
@Table(name = "tab_menu")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends BaseEntity {

    private static final long serialVersionUID = -944779614597642189L;

    @Column(name = "icon")
    private String icon;

    @Column(name = "title")
    private String item;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "url")
    private String url;
}
