package com.caicai.emipe.persistence.main.repository;

import com.caicai.emipe.persistence.main.entity.ScoreFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author caicai
 * @create 2021/3/15
 */
@Repository
public interface ScoreFlowRepository extends JpaRepository<ScoreFlow, String>, JpaSpecificationExecutor<ScoreFlow> {
}
