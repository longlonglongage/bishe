package com.ming.hospital.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "USER")
public class User {
    private Long uid;

    private String user;

    private String pwd;

    private String name;

    private String gender;

    private String email;

    private String phone;

    private Date createtime;

    private Date updatetime;

    private String code;

    private Integer state;
}