package com.xdmd.environment.common;

import org.springframework.stereotype.Component;
import java.util.HashMap;


@Component
public class ResultMap extends HashMap<String, Object> {
    public ResultMap() {
    }

    public ResultMap success() {
        this.put("resultFlag", "0");
        return this;
    }

    public ResultMap fail() {
        this.put("resultFlag", "1");
        return this;
    }

    public ResultMap message(Object message) {
        this.put("data", message);
        return this;
    }
}