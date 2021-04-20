package com.caicai.emipe.persistence.repository;

import com.caicai.emipe.persistence.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author caicai
 * @create 2021/4/19
 */
@Repository
public interface IMenuRepository extends JpaRepository<Menu, String> {
    
}
