package com.caicai.emipe.service;

import com.caicai.emipe.persistence.other.City;
import com.caicai.emipe.persistence.other.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author caicai
 * @create 2021/6/7
 */
@Service
public class CityService {
    @Autowired
    private ICityRepository cityRepository;

    public Page<City> findCity(int page, int size) {
        PageRequest of = PageRequest.of(page, size, Sort.by("name"));
        Page<City> result = cityRepository.findAll(of);
        return result;
    }

}
