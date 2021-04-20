package com.caicai.emipe.service;

import com.caicai.emipe.persistence.entity.BaseEntity;
import com.caicai.emipe.persistence.entity.Menu;
import com.caicai.emipe.persistence.repository.IMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caicai
 * @create 2021/4/19
 */
@Service
public class MenuService {
    @Autowired
    private IMenuRepository menuRepository;

    public List<Menu> list() {
        return menuRepository.findAll(Sort.by(BaseEntity.SortProperties.CREATE_DATE.getRemark()));
    }
}
