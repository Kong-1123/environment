package com.xdmd.environment.company.Pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;


@Data
public class Time {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Date time;

    public Time(Integer id, Date time) {
        this.id = id;
        this.time = time;
    }

    public Time() {
    }
}
