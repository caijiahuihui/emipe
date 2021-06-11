package com.caicai.emipe.controller;

import com.caicai.emipe.aop.Log;
import com.caicai.emipe.persistence.main.entity.Menu;
import com.caicai.emipe.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author caicai
 * @create 2021/4/19
 */
@RequestMapping("/menu")
@RestController
@Slf4j
@Log
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("/list")
    public List<Menu> list() {
        return menuService.list();
    }

    @GetMapping("mainTest")
    public void mainTest() {
        Menu menu = Menu.getInstance("icon", "item", "parentId", "url");
        Menu testMenu = Menu.getMenuInstanceByIconAndItem("otherIcon", "otherItem");
        log.info(menu.toString());
        log.info(testMenu.toString());
    }

    @GetMapping("/oneMenu")
    public Menu findOneMenu() {
        return Menu.getInstance("sss", "item", "parentId", "url");
    }
}
