package com.xdmd.environment.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 分页类
 */
@Component
@Data
public class PageBean<T> implements Serializable {
    private List<JSONObject> data;//当前页列表
    private int count;//总记录数

    public PageBean(List<JSONObject> data, int count) {
        this.data = data;
        this.count = count;
    }

    public PageBean() {
    }
}
