package com.example.mybatispluswheel.dao;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatispluswheel.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    //如果不想限制任何条件，也可直接不使用Wrapper条件构造器
    @Select("select * from `wheel_test_user`")
    List<User> selectSelfByAnnoWithoutWrapper();
    List<User> selectSelfByXmlWithoutWrapper();

    //亦可不使用Wrapper条件构造器，自定义条件参数，同下


    //自定义分页，且使用Wrapper条件构造器，可适用于联表查询等复杂分页情况
    IPage<User> selectSelfPageWithWrapper(Page<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    //亦可自定义条件参数
    //需注意的是若map为首个唯一参数，可不指定@Param("map")；否则必须指定，不然无法识别
    /*
    * todo: Encountered unexpected token: "signed" "SIGNED" 这个警告貌似是关键字与mysql重复了，后续可测试处理一下
    *  https://blog.csdn.net/mashangzhifu/article/details/118928664
    * */
    IPage<User> selectSelfPageWithoutWrapper(Page<User> page, @Param("map") Map<String, Object> map);
}
