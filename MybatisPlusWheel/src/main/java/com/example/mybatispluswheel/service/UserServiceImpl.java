package com.example.mybatispluswheel.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatispluswheel.dao.UserDAO;
import com.example.mybatispluswheel.model.User;
import org.springframework.stereotype.Service;

//Service接口实现类，实现自定义的接口IUserService之前，需要继承IService的实现类ServiceImpl
@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements IUserService {
}
