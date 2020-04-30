package com.ming.hospital.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "HOSPITAL")
public class Hospital {
    private Long hid;

    private String hname;

    private String hphone;

    private String address;

    private Float score;

    private String grade;

    private String description;

    private Integer insurance;

    private String image;

    private Integer times;

    private List<Doctor> doctorList;
}