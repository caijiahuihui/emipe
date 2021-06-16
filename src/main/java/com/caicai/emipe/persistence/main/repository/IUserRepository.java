package com.caicai.emipe.persistence.main.repository;

import com.caicai.emipe.persistence.main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author caicai
 * @create 2021/6/16
 */
@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    
}
