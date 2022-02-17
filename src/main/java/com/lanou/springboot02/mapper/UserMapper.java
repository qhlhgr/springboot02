package com.lanou.springboot02.mapper;

import com.lanou.springboot02.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    List<User>  selectPassword(@Param("username") String username,@Param("password") String password);
    User selectOne(@Param("id") Integer id);
    void insert(User user);
    void delete(@Param("id") Integer id);
    void update(User user);
}
