package com.example.mybatispluswheel;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatispluswheel.dao.UserDAO;
import com.example.mybatispluswheel.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class TestUserDAO {

    @Autowired
    private UserDAO userDAO;

    //查询所有
    @Test
    public void testFindAll() {
        List<User> users = userDAO.selectList(null);
        users.forEach(user -> System.out.println("user = " + user));
    }

    //查询一个
    @Test
    public void testFindOne() {
        User user = userDAO.selectById(50);
        System.out.println("user = " + user);
    }

    //条件查询
    @Test
    public void testFind() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("password", "234"); //设置等值查询
        //queryWrapper.lt("password", "233"); //设置小于查询
        //queryWrapper.le("password", "233"); //设置小于等于查询
        //gt：大于     ge：大于等于
        List<User> users = userDAO.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    //模糊查询
    @Test
    public void testFindAll2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("qq", "33");
        /*
        * like  %？%
        * likeLeft  %？
        * likeRight ？%
        * */
        List<User> users = userDAO.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    //添加
    @Test
    public void testSave() {
        User user = new User();
        String salt = UUID.randomUUID().toString().substring(0, 5);
        user.setName(String.valueOf(Math.random()*10))
                .setSalt(salt)
                .setHeadUrl("886")
                .setPassword("233")
                .setQq("898")
                .setBirth("233")
                .setSex("F")
                .setType("23")
                .setSigned("25");
        userDAO.insert(user);
    }

    //修改    基于id修改      仅update相关字段，原其他字段不变
    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(52);
        user.setPassword("7777777777");
        userDAO.updateById(user);
    }

    //修改    基于条件修改      仅update相关字段，原其他字段不变
    @Test
    public void testUpdateByCondition() {
        User user = new User();
        user.setPassword("updateWrapper");
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        //首个参数为前置条件（即mybatis动态sql中的if），可随意设置，举例：updateWrapper.eq(age != 18, "qq", "898");即表示当age不等于18时，才去做qq的修改
        updateWrapper.eq(true, "qq", "898");
        userDAO.update(user, updateWrapper);
    }

    //删除    基于id删除
    @Test
    public void testDeleteById() {
        userDAO.deleteById(61);
    }

    //删除    基于条件删除
    @Test
    public void testDeleteByCondition() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("salt", "b699f");
        userDAO.delete(queryWrapper);
    }

    //带条件分页查询   需使用MybatisPlusConfig的拦截器配置
    @Test
    public void testFindAllPage() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("qq", "898");
        //参数一：当前页，默认值为1     参数二：每页显示记录数，默认值10
        IPage<User> page = new Page<>(1, 2);
        page = userDAO.selectPage(page, queryWrapper);  //若非条件查询分页，直接第二个参数为null即可
        System.out.println("总数量： " + page.getTotal());
        page.getRecords().forEach(user -> System.out.println("user = " + user));
    }

    //使用自定义的sql
    //参考：https://www.cnblogs.com/zimug/p/13277392.html
    @Test
    public void testSelfBy() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("password", "updateWrapper");   //若不想限制任何条件，这里注释掉
        List<User> res1 = userDAO.selectSelfByAnnoWithWrapper(queryWrapper);    //如果不想限制任何条件，不可传参为null，需传一个空的queryWrapper
        System.out.println(res1);

        List<User> res2 = userDAO.selectSelfByXmlWithWrapper(queryWrapper);    //如果不想限制任何条件，不可传参为null，需传一个空的queryWrapper
        System.out.println(res2);
    }
}

















