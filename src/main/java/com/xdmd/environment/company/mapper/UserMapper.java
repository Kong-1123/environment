package com.xdmd.environment.company.mapper;

import com.xdmd.environment.company.Pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from shiro_user where username = #{username} and password = #{password}")
    User queryUser(@Param("username") String username, @Param("password") String password);

    //根据用户名获取权限
    @Select("select name from shiro_permission where pid in (" +
            "select pid from shiro_permission_role where rid = (" +
            "select rid from shiro_user_role where uid = (" +
            "SELECT uid FROM shiro_user where username = #{username})))")
    List<String> getPermission(@Param("username") String username);
}
