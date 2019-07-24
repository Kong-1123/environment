package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Kong
 * @createDate: 2019/07/24
 * @description: 所属类别
 */
@Data
@ApiModel("所属类别")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 所属类别
     */
    private String category;

    public Category() {
    }
}