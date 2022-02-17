package com.lanou.springboot02.dao;

import com.lanou.springboot02.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> selectAll();
    List<User>  selectPassword(String username,String password);
}
