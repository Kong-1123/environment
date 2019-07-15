package com.xdmd.environment.common;

import org.springframework.stereotype.Component;
import java.util.HashMap;

/**
 *
 * @Author ZhangYuDeLong
 * @Description 接口返回对象
 * @Date 2019.7.15
 */
@Component
public class ResultMap extends HashMap<String, Object> {
    public ResultMap() {
    }

    public ResultMap success() {
        this.put("resultFlag ", "0");
        return this;
    }

    public ResultMap fail() {
        this.put("resultFlag ", "1");
        return this;
    }

    public ResultMap message(Object message) {
        this.put("data", message);
        return this;
    }
}