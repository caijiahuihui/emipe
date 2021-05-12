package com.caicai.emipe.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
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

    /**
     * 静态工厂方法的好处：
     * 1.单例模式(懒汉模式，饿汉模式等)
     * 2.静态工厂方法拥有名字，方法名字可读性更强例如，getInstanceByString(),getInstanceByIcon().....;
     * 3.可以返回该类的子类（策略模式，根据不同的场景返回对应的对象）
     * 4.
     *
     * @param icon
     * @param item
     * @param parentId
     * @param url
     * @return
     */
    // 静态工厂方法
    public static Menu getInstance(String icon, String item, String parentId, String url) {
        return new Menu(icon, item, parentId, url);
    }

    // 有含义的静态构造方法
    public static Menu getMenuInstanceByIconAndItem(String icon, String item) {
        return new Menu(icon, item, null, null);
    }
}
