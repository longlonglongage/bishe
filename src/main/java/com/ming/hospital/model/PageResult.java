package com.ming.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回对象
 *
 * @author Haotian
 * @version 1.0.0
 * @date 2020/5/5 0:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResult implements Serializable {
    private static final long serialVersionUID = 3829443707933619143L;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页结果
     */
    private List rows;
}