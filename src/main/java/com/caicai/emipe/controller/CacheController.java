package com.caicai.emipe.controller;

import com.caicai.emipe.persistence.main.entity.User;
import com.caicai.emipe.persistence.other.City;
import com.caicai.emipe.service.CityService;
import com.caicai.emipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 使用缓存的Cache
 * 1.org.springframework.boot:spring-boot-starter-cache
 * 2.在Spring Boot入口类中加入@EnableCaching注解开启缓存功能
 * 3.Service层加上@CacheConfig(cacheNames = "XXX")注解，查询方法@Cacheable，更新方法@CachePut，删除方法@CacheEvict
 * 4.下载redis并运行
 * 5.org.springframework.boot:spring-boot-starter-data-redis
 * 6.配置文件
 *
 * @author caicai
 * @create 2021/6/17
 */
@RestController
@RequestMapping("cache")
public class CacheController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @GetMapping("findUserById")
    public User findUserById(@RequestParam(name = "id") String id) {
        return userService.findById(id);
    }

    @PostMapping("deleteById")
    public void deleteById(@RequestParam(name = "id") String id) {
        userService.deleteById(id);
    }

    @PostMapping("updatePassword")
    public User updatePassword(@ModelAttribute User user) {
        return userService.updatePassword(user);
    }

    @GetMapping("findAllCities")
    public List<City> findAllCities() {
        return cityService.findAllCities();
    }
}
