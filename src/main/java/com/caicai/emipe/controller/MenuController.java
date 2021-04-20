package com.caicai.emipe.controller;

import com.caicai.emipe.persistence.entity.Menu;
import com.caicai.emipe.service.MenuService;
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
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public List<Menu> list() {
        return menuService.list();
    }
}
