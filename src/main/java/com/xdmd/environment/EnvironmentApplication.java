package com.xdmd.environment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @description: 启动类
 * @author: Kong
 * @date: 2019/7/18
*/
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.xdmd.environment.*.mapper"})
public class EnvironmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnvironmentApplication.class, args);
    }

}
