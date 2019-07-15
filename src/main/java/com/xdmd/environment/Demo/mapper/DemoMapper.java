package com.xdmd.environment.Demo.mapper;

import com.xdmd.environment.Demo.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface DemoMapper {
    @Select("select * from user where id = 1")
    User query();
}
