package com.ming.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * 分页对象
 *
 * @author Haotian
 * @version 1.0.0
 * @date 2020/5/5 0:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryPageBean implements Serializable {
    private static final long serialVersionUID = 1104113460789764801L;

    /**
     * 页码
     */
    private Integer currentPage;

    /**
     * 每页记录数
     */
    private Integer pageSize;

    /**
     * 查询条件
     */
    private String queryString;
}