package com.xdmd.environment.company.Pojo;

import lombok.Data;

@Data
public class JwtInformation {
    //用户真实姓名
    private String username;

    //用户id
    private Integer uid;

    //公司名
    private String companyName;

    //公司id
    private Integer cid;

    public JwtInformation(String username, Integer uid, String companyName, Integer cid) {
        this.username = username;
        this.uid = uid;
        this.companyName = companyName;
        this.cid = cid;
    }

    public JwtInformation() {
    }
}
