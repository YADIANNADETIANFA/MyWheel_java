package com.example.springbootwheel.dao;

import com.example.springbootwheel.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface UserDAO {
    int addUser(User user);
    User selectById(@Param("id") int id);
    User selectByName(@Param("name") String name);
    User selectByIdAndUrl(Map<String, Object> map);
    int deleteUser(@Param("name") String name);
    int updateUser(Map<String, Object> map);
    List<User> selectUsersBySalts(Map<String, Object> map);
}
