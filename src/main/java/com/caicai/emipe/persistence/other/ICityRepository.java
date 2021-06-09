package com.caicai.emipe.persistence.other;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author caicai
 * @create 2021/6/7
 */
@Repository
public interface ICityRepository extends JpaRepository<City, String> {
}
