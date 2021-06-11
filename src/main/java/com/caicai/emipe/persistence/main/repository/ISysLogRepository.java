package com.caicai.emipe.persistence.main.repository;

import com.caicai.emipe.persistence.main.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author caicai
 * @create 2021/6/9
 */
@Repository
public interface ISysLogRepository extends JpaRepository<SysLog, String> {
}
