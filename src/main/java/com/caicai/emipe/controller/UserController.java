package com.caicai.emipe.controller;

import com.caicai.emipe.aop.Log;
import com.caicai.emipe.config.JwtConfig;
import com.caicai.emipe.exception.ControllerException;
import com.caicai.emipe.persistence.main.entity.User;
import com.caicai.emipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author caicai
 * @create 2021/5/17
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private JwtConfig jwtConfig;

    @RequestMapping("add")
    public User addUser(@RequestParam(name = "name") String name, @RequestParam(name = "passWord") String passWord) {
        return userService.addUser(name, passWord);
    }

    @Log
    @RequestMapping("login")
    public Map<String, Object> login(@RequestParam(name = "name") String name, @RequestParam(name = "passWord") String passWord) {
        Map<String, Object> map = userService.findByUsernameAndPassword(name, passWord);
        if (null == map) {
            throw new ControllerException("501", "用户名或密码错误");
        }
        String subject = (String) map.get("name");
        String token = jwtConfig.generateToken(subject);
        map.put("token", token);
        return map;
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

