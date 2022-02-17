package com.lanou.springboot02.dao;

import com.lanou.springboot02.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> selectAll() {
        RowMapper rowMapper = new BeanPropertyRowMapper(User.class);
        String sql = "select * from user";
        List userList = jdbcTemplate.query(sql, rowMapper);
        return userList;
    }

    @Override
    public List<User> selectPassword(String username, String password) {
        RowMapper rowMapper = new BeanPropertyRowMapper(User.class);
        String sql = "select * from user where username=? and password=?";
        List<User> userList = jdbcTemplate.query(sql,rowMapper,username,password);
        return userList;
    }
}
