package com.example.springbootwheel.myWheel;

import com.alibaba.fastjson.JSON;
import com.example.springbootwheel.model.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 常用转换轮子
 * */
@SpringBootTest
public class Wheel_3 {

    @Test
    public void test() {

        //base64编码
        String code = "23333";
        System.out.println(Base64.getUrlEncoder().encodeToString(code.getBytes(StandardCharsets.UTF_8)));

        //base64解码
        String deCode = "12312312123123121231231212312312"; //32位
        byte[] bytes = Base64.getUrlDecoder().decode(deCode);
        String res = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(res);

        //转String，转换失败不会报错
        System.out.println(Wheel_3.toStr(2333, "theDefVal"));

        //转char，失败不报错
        System.out.println(Wheel_3.toChar(3, 'd'));

        //转int，失败不报错
        System.out.println(Wheel_3.toInteger("456", 233));

        //转数组，失败不报错
        Integer[] res2 = Wheel_3.toIntArray(",", "2,3,3,3,3,3");
        for (Integer temp : res2) {
            System.out.println(temp);
        }

        //对象转Json
        User user = new User();
        user.setName("2333");
        String res3 = Wheel_3.toJsonByFastJson(user);
        System.out.println(res3);

        //Json转对象
        User userRes = Wheel_3.toObjectByFastJson(res3, User.class);
        System.out.println(userRes);
    }

    public static String toStr(Object value, String defaultVal) {
        if (null == value) {
            return defaultVal;
        }
        if (value instanceof String) {
            return (String) value;
        }
        return value.toString();
    }

    public static Character toChar(Object value, Character defaultVal) {
        if (null == value)  {
            return defaultVal;
        }
        if (value instanceof Character) {
            return (Character) value;
        }
        final String valueStr = toStr(value, null);
        return StringUtils.isBlank(valueStr) ? defaultVal: valueStr.charAt(0);
    }

    public static Integer toInteger(Object value, Integer defaultVal) {
        if (null == value) {
            return defaultVal;
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isBlank(valueStr)) {
            return defaultVal;
        }
        try {
            return Integer.parseInt(valueStr.trim());
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    public static Integer[] toIntArray(String split, String str) {
        if (StringUtils.isBlank(str)) {
            return new Integer[] {};
        }
        String[] arr = str.split(split);    //分隔符
        final Integer[] ints = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            final Integer v = Wheel_3.toInteger(arr[i], 0);
            ints[i] = v;
        }
        return ints;
    }

    public static <T> T toObjectByFastJson(String json, Class<T> objectType) {
        return JSON.parseObject(json, objectType);
    }

    public static <T> String toJsonByFastJson(T object) {
        return JSON.toJSONString(object);
    }
}
