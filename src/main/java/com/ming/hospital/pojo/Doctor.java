package com.ming.hospital.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName(value = "DOCTOR")
public class Doctor {
    @TableId
    private Long did;

    private String surgeryweek;

    private Hospital hospital;


    private Long hid;

    private Dept dept;

    private Long deid;


    private String dname;

    private String gender;

    private Float score;

    private String grade;

    private String skill;

    private String description;

    private String image;

}