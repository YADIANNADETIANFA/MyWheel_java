package com.example.springbootwheel.myWheel;

import com.example.springbootwheel.dao.UserDAO;
import com.example.springbootwheel.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class Wheel_2 {

    @Autowired
    UserDAO userDAO;

    /**
     * mybatis的sql轮子
     * */
    @Test
    public void test1() throws Exception {
        User user = new User();
        user.setName(String.valueOf(Math.random()*10));
        String salt = UUID.randomUUID().toString().substring(0, 5);
        user.setSalt(salt);
        user.setHeadUrl("2333");
        user.setPassword("233");
        user.setQq("898");
        user.setBirth("233");
        user.setSex("F");
        user.setType("23");
        user.setSigned("25");
        int res1 = userDAO.addUser(user);   //返回影响数据条数
        System.out.println(res1);
        if (res1 <= 0) {
            throw new Exception("userDAO.addUser error.");
        }

        System.out.println(userDAO.selectById(44));
        System.out.println(userDAO.selectByName("zk2"));

        System.out.println(userDAO.deleteUser("zk"));   //返回影响数据条数；  模糊查询like

        Map<String, Object> map = new HashMap<>();
        map.put("qq", "233333");
        map.put("id", 50);
        int res2 = userDAO.updateUser(map);
        System.out.println(res2);
        if (res2 <= 0) { //返回影响数据条数
            throw new Exception("userDAO.updateUser error.");
        }

        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 52);
        map2.put("headUrl", "23334");
        System.out.println(userDAO.selectByIdAndUrl(map2)); //动态sql if

        Map<String ,Object> map3 = new HashMap<>();
        List<String> salts = new ArrayList<>();
        salts.add("7c73a");
        salts.add("e22ec");
        salts.add("9a0d9");
        map3.put("salts", salts);
        map3.put("limitFirst", 1);
        map3.put("limitSec", 10);
        System.out.println(userDAO.selectUsersBySalts(map3));   //动态sql foreach
    }

}

/*
* CREATE TABLE `wheel_test_user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '昵称',
  `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(32) NOT NULL DEFAULT '' COMMENT '盐',
  `head_url` varchar(256) NOT NULL DEFAULT '' COMMENT '用户头像',
  `qq` varchar(16) DEFAULT NULL COMMENT '个人qq，用于发送登陆通知等',
  `role` varchar(45) DEFAULT NULL COMMENT 'admin-管理员\nvip-会员\nnormal-普通用户\nlimited-受限用户',
  `permission` varchar(128) DEFAULT NULL COMMENT '权限',
  `birth` varchar(45) DEFAULT NULL COMMENT '用户生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别，F-男，M-女',
  `type` varchar(256) DEFAULT NULL COMMENT '可能喜欢',
  `signed` varchar(256) DEFAULT NULL COMMENT '个性签名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8
* */
