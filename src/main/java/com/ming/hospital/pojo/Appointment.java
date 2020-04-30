package com.ming.hospital.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "APPOINTMENT")
public class Appointment {

    @ApiModelProperty(name = "aid",value = "委任id")
    private Long aid;

    @ApiModelProperty(name = "uid",value = "用户id")
    private Long uid;

    @ApiModelProperty(name = "visittime",value = "访问时间")
    private String visittime;

    @ApiModelProperty(name = "did",value = "主键id")
    private Long did;

    @ApiModelProperty(name = "name",value = "名字")
    private String name;

    @ApiModelProperty(name = "idcast",value = "主键id")
    private String idcast;

    @ApiModelProperty(name = "aphone",value = "手机")
    private String aphone;

    @ApiModelProperty(name = "createtime",value = "创建时间")
    private Date createtime;

    @ApiModelProperty(name = "updatetime",value = "更新时间")
    private Date updatetime;

}