package com.example.mybatispluswheel.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.mybatispluswheel.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//使用mybatis-plus Mapper CRUD接口
public interface UserDAO extends BaseMapper<User> {

    //我们也可以自定义sql进行查询

    //方式一：用注解，使用Wrapper条件构造器
    //注意，表用要指定为数据库的具体表名wheel_test_user
    @Select("select * from `wheel_test_user` ${ew.customSqlSegment}")
    List<User> selectSelfByAnnoWithWrapper(@Param(Constants.WRAPPER) Wrapper wrapper);

    //方式二，用xml，使用Wrapper条件构造器
    //记得在application.yml中配置路径：mybatis-plus
    List<User> selectSelfByXmlWithWrapper(@Param(Constants.WRAPPER) Wrapper wrapper);
}
