package com.ming.hospital.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName(value = "DOCTOR")
public class Doctor {
    private String surgeryweek;

    private Hospital hospital;

    private Long hid;

    private Dept dept;

    private Long deid;

    private Long did;

    private String dname;

    private String gender;

    private Float score;

    private Integer grade;

    private String skill;

    private String description;

    private String image;

}