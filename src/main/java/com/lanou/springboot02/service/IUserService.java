package com.lanou.springboot02.service;

import com.lanou.springboot02.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> selectAll();
    List<User>  selectPassword(String username,String password);
    User selectOne(Integer id);
    void insert(User user);
    void delete(Integer id);
    void update(User user);
}
