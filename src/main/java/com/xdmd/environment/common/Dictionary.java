package com.xdmd.environment.common;

import java.io.Serializable;

/**
 * @author: Kong
 * @createDate: 2019/7/18
 * @description: 字典类
 */
public class Dictionary implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 分类
     */
    private String classification;

    /**
     * 内容
     */
    private String content;

    /**
     * 分类id
     */
    private Integer classificationId;

    /**
     * 内容id
     */
    private Integer contentId;

    /**
     * 启用（0:逻辑删除 1：启用）
     */
    private Integer state;

    public Dictionary() {
    }
}
