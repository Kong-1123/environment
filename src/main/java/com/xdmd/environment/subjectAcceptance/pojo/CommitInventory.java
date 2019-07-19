package com.xdmd.environment.subjectAcceptance.pojo;

import lombok.Data;

@Data
public class CommitInventory {
    private Integer id;
    private String content;

    public CommitInventory(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public CommitInventory() {
    }
}
