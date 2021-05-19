package com.caicai.emipe.persistence.repository.testMapper;

import com.caicai.emipe.persistence.entity.EntityUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author caicai
 * @create 2021/5/18
 */
@Component
@Mapper
public interface EntityUserMapper {
    @Results(id = "entityResult", value = {

    })
    List<EntityUser> query();
}
