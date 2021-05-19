package com.caicai.emipe.persistence.repository.mapper;

import com.caicai.emipe.persistence.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author caicai
 * @create 2021/5/18
 */
@Component
@Mapper
public interface UserMapper {
    @Insert("insert into emipe_user values (#{id},#{name},#{passWord})")
    int add(User user);

    @Update("update emipe_user set name=#{name}, pass_word=#{passWord} where id=#{id}")
    int update(User user);

    @Delete("delete from emipe_user where id = #{id}")
    int deleteById(String id);

    @Select("select id,name,password as passWord from emipe_user")
    List<User> query();
}
