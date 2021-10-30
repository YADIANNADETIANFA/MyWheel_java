package com.example.mybatispluswheel;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatispluswheel.model.User;
import com.example.mybatispluswheel.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserServiceImpl userService;

    //查询所有
    @Test
    public void testFindAll() {
        List<User> users2 = userService.list(null);
        users2.forEach(user -> System.out.println("user = " + user));
    }

    //条件查询
    @Test
    public void testFind() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("password", "updateWrapper"); //设置等值查询
        //queryWrapper.lt("password", "233"); //设置小于查询
        //queryWrapper.le("password", "233"); //设置小于等于查询
        //gt：大于     ge：大于等于
        List<User> users = userService.list(queryWrapper);
        users.forEach(System.out::println);
    }

    //其他的方法，看文档随便用
}

/*
* 配置方式：
* https://blog.csdn.net/qq_45315910/article/details/100186149
* https://www.hangge.com/blog/cache/detail_2916.html
* */
