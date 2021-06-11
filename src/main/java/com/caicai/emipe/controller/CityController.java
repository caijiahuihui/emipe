package com.caicai.emipe.controller;

import com.caicai.emipe.aop.Log;
import com.caicai.emipe.persistence.other.City;
import com.caicai.emipe.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caicai
 * @create 2021/6/7
 */
@RestController
@RequestMapping("city")
@Log
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("find")
    @Log
    public Page<City> findCityPage(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                   @RequestParam(value = "page") int page) {
        return cityService.findCity(page, size);
    }

}
