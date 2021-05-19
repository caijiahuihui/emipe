package com.caicai.emipe.controller;

import com.caicai.emipe.persistence.entity.User;
import com.caicai.emipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author caicai
 * @create 2021/5/17
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public User addUser(@RequestParam(name = "name") String name, @RequestParam(name = "passWord") String passWord) {
        return userService.addUser(name, passWord);
    }

    @RequestMapping("otherAdd")
    public User otherAdd(@RequestParam(name = "name") String name, @RequestParam(name = "passWord") String passWord) {
        return userService.otherAdd(name, passWord);
    }

    @RequestMapping("update")
    public int update(@RequestParam(name = "name") String name, @RequestParam(name = "passWord") String passWord, @RequestParam(name = "id") String id) {
        return userService.update(name, passWord, id);
    }

    @RequestMapping("delete")
    public int delete(@RequestParam(name = "id") String id) {
        return userService.delete(id);
    }

    @GetMapping("find")
    public List<User> find() {
        return userService.find();
    }
}

