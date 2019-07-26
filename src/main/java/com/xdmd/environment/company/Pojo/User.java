package com.xdmd.environment.company.Pojo;

import lombok.Data;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;

    public User(Integer uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
