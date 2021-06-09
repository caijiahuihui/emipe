package com.caicai.emipe.service;

import com.caicai.emipe.persistence.main.dao.UserDao;
import com.caicai.emipe.persistence.main.entity.User;
import com.caicai.emipe.persistence.main.mapper.UserMapper;
import com.caicai.emipe.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author caicai
 * @create 2021/5/17
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    public User addUser(String name, String password) {
        User user = new User(BaseUtil.getUUIDStr(), name, password);
        userDao.add(user);
        return user;
    }

    public User otherAdd(String name, String password) {
        User user = new User(BaseUtil.getUUIDStr(), name, password);
        userDao.addByParas(user);
        return user;
    }

    public int update(String name, String passWord, String id) {
        User user = new User(id, name, passWord);
        return userDao.update(user, user.getId());
    }

    public int delete(String id) {
        return userDao.delete(id);
    }

    public Map<String, Object> findByUsernameAndPassword(String username, String password) {
        return userDao.findByUserNameAndPassWord(username, password);
    }

    public List<User> find() {
        return userMapper.query();
    }


}
