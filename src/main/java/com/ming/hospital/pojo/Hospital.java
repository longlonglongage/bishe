package com.ming.hospital.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "HOSPITAL")
public class Hospital {
    @ApiModelProperty(name = "hid",value = "医院概况")
    @TableId
    private Long hid;

    @ApiModelProperty(name = "hname",value = "医院名称")
    private String hname;

    @ApiModelProperty(name = "hphone",value = "医院电话")
    private String hphone;

    @ApiModelProperty(name = "address",value = "医院概况")
    private String address;

    @ApiModelProperty(name = "score",value = "医院评分")
    private Float score;

    @ApiModelProperty(name = "grade",value = "医院等级")
    private String grade;

    @ApiModelProperty(name = "description",value = "医院概况")
    private String description;

    @ApiModelProperty(name = "insurance",value = "保险费")
    private Integer insurance;

    @ApiModelProperty(name = "image",value = "医院图片")
    private String image;

    @ApiModelProperty(name = "times",value = "累计服务次数")
    private Integer times;

    @ApiModelProperty(name = "doctorList",value = "医院概况")
    private List<Doctor> doctorList;
}