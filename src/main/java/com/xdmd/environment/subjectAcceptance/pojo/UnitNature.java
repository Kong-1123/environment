package com.xdmd.environment.subjectAcceptance.pojo;

import lombok.Data;

@Data
public class UnitNature {
    private Integer id;
    private String content;

    public UnitNature(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public UnitNature() {
    }
}
