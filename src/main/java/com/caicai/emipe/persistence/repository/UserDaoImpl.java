package com.caicai.emipe.persistence.repository;

import com.caicai.emipe.persistence.entity.User;
import com.caicai.emipe.persistence.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * @author caicai
 * @create 2021/5/17
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(User user) {
        String sql = "insert into emipe_user values(:id,:name,:passWord)";
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        return npjt.update(sql, new BeanPropertySqlParameterSource(user));
    }

    @Override
    public int addByParas(User user) {
        String sql = "insert into emipe_user values (?,?,?)";
        Object[] args = {user.getId(), user.getName(), user.getPassWord()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return jdbcTemplate.update(sql, args, types);
    }

    @Override
    public int delete(String id) {
        String sql = "delete from emipe_user where id = ?";
        Object[] args = {id};
        int[] types = {Types.VARCHAR};
        return jdbcTemplate.update(sql, args, types);
    }

    @Override
    public List<Map<String, Object>> query() {
        String sql = "select * from emipe_user";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public int update(User user, String id) {
        String sql = "update emipe_user set name = ? , password = ? where id = ?";
        Object[] args = {user.getName(), user.getPassWord(), id};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return jdbcTemplate.update(sql, args, types);
    }

    @Override
    public Map<String, Object> findByUserNameAndPassWord(String username, String password) {
        String sql = "select name,password from emipe_user where name = '" + username + "' and password = '" + password + "'";
        Map<String, Object> map = jdbcTemplate.queryForList(sql).get(0);
        return map;
    }
}
