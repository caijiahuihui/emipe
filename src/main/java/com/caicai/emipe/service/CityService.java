package com.caicai.emipe.service;

import com.caicai.emipe.persistence.other.City;
import com.caicai.emipe.persistence.other.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Cacheable(key = "cities")
    public List<City> findAllCities() {
        List<City> result = cityRepository.findAll(Sort.by("id"));
        return result;
    }

    @CachePut(key = "cities")
    public List<City> addCity(City city) {
        Integer max = cityRepository.findAll(Sort.by("id")).get(0).getId();
        city.setId(max + 1);
        cityRepository.save(city);
        return findAllCities();
    }

}
