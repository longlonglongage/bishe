package com.ming.hospital.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName(value = "DEPT")
public class Dept {
    private Long deid;

    private Integer degrade;

    private String dename;

}