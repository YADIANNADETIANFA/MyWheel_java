package com.example.mybatispluswheel.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@TableName(value="wheel_test_user") //映射数据库表名   否则默认将类名映射数据库表名
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
    * value：指定实体类中与表中对应的主键字段；   type指定主键类型
    * AUTO:数据库ID自增
    * INPUT:insert前自行set主键值
    * */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;     //自增id

    @TableField(value = "name") //映射数据库表的字段名
    private String name;    //昵称

    @TableField(value = "password")
    private String password;    //密码

    @TableField(value = "salt")
    private String salt;    //盐

    @TableField(value = "head_url")
    private String headUrl; //头像

    @TableField(value = "qq")
    private String qq;  //qq

    @TableField(value = "role")
    private String role;    //身份角色

    @TableField(value = "permission")
    private String permission;  //权限

    @TableField(value = "birth")
    private String birth;   //生日

    @TableField(value = "sex")
    private String sex; //性别    F：男     M：女

    @TableField(value = "type")
    private String type;    //可能喜欢

    @TableField(value = "signed")
    private String signed;    //签名

    @TableField(exist = false)  //不映射数据库表中任何字段
    private String aaa;
}
