package com.xdmd.environment.user.Pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class User {
    @Range(min = 2,max = 5,message = "长度有问题")
    private Integer id;
    private String username;
    private String password;

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
