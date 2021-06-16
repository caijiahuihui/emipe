package com.caicai.emipe.controller;

import com.caicai.emipe.exception.ControllerException;
import com.caicai.emipe.persistence.main.entity.User;
import com.caicai.emipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author caicai
 * @create 2021/6/16
 */
@Controller
@RequestMapping("url")
public class UrlController {

    @Autowired
    private UserService userService;

    // 访问地址
    @GetMapping("index")
    public String guideIndex(Model model) {
        // 类似一个map，将数据绑定在view层
        model.addAttribute("name", "caicaicai");
        // 表明返回的template是index.html
        return "index";
    }

    @GetMapping("oneBean")
    public String getOneBean(Model model, @RequestParam(name = "id") String id) throws ControllerException {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "oneBean";
    }

    @GetMapping("list")
    public String list(Model model) {
        List<User> list = userService.list();
        model.addAttribute("list", list);
        return "list";
    }


}
