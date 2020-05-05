package com.ming.hospital.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ming.hospital.pojo.Dept;
import com.ming.hospital.pojo.Hospital;
import lombok.Data;

@Data
public class DoctorVo {
    @TableId
    private Long did;

    private String surgeryweek;

    private String hospitalName;

    private Long hid;

    private String dept;

    private String dname;

    private String gender;

    private Float score;

    private String grade;

    private String skill;

    private String description;

    private String image;

}