package com.example.mybatispluswheel.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.example.mybatispluswheel.dao")
public class MybatisPlusConfig {

    /*
    * mybatis正常实现的分页是逻辑分页，即全部查询到内存后返回部分内容，效率低下
    * 为使用物理分页，IPage需注入一个bean拦截器交给springBoot做处理。
    *
    *
    * 对于简单的分页查询，使用MP直接提供的分页方法即可；
    * 对于联表查询等复杂的分页查询，需自定义sql方法进行查询。
    * 自定义的sql方法分页时也会用到这里的拦截配置
    * */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return mybatisPlusInterceptor;
    }
}

/*
* IPage内部原理也是基于拦截器，但是这个拦截的是方法以及方法中的参数，这个也会判断是否是查询操作。如果是查询操作，才会进入分页的处理逻辑。
* 进入分页逻辑处理后，拦截器会通过反射获取该方法的参数进行判断是否存在IPage对象的实现类。如果不存在则不进行分页，存在则将该参数赋值给IPage对象。然后进行拼接sql的处理完成分页操作。
* https://blog.csdn.net/qq_43037478/article/details/116991083
* https://www.cnblogs.com/pxblog/p/13044759.html
*
* mysql的limit为物理分页  https://blog.csdn.net/lvoelife/article/details/81943070
* */
