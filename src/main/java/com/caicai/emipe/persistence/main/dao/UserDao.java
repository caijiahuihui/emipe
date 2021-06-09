package com.caicai.emipe.persistence.main.dao;

import com.caicai.emipe.persistence.main.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author caicai
 * @create 2021/5/17
 */
public interface UserDao {

    int add(User user);

    int delete(String id);

    List<Map<String, Object>> query();

    int update(User user, String id);

    int addByParas(User user);

    Map<String, Object> findByUserNameAndPassWord(String username, String password);

}
