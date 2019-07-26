package com.xdmd.environment.company.mapper;

import com.xdmd.environment.common.MyBaseMapper;
import com.xdmd.environment.company.Pojo.ShiroCompany;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CompanyMapper extends MyBaseMapper<ShiroCompany> {
    //根据公司名获取公司id,判断该公司是否已经存在
    @Select("select company_name from shiro_company_name where company_name = #{companyName}")
    String queryCompanyName(@Param("companyName") String companyName);

    @Insert("insert into shiro_company_role(cid,rid) values(#{id},1)")
    int addCompanyAndRole(@Param("id") Integer id);

    @Select("select name from shiro_company where name = #{name}")
    String queryNameExist(@Param("name") String name);

    @Select("select password from shiro_company where name = #{name}")
    String queryPassword(@Param("name") String name);

    @Insert("insert into shiro_company_name(company_name) values (#{companyName})")
    int addCompanyName(@Param("companyName") String companyName);

    @Select("select id from shiro_company_name where company_name = #{companyName}")
    int queryCompanyId(@Param("companyName") String companyName);

    @Select("select company_id from shiro_company where name = #{name}")
    int queryCompanyIdByname(@Param("name") String name);

    @Select("select company_name from shiro_company_name where id = #{cid}")
    String queryCompanyNameByCid(@Param("cid") int cid);

    @Select("select username from shiro_company where name = #{name}")
    String queryLoginUsernameByname(@Param("name") String name);

    @Select("select id from shiro_company where name = #{name}")
    int queryUserIdByName(@Param("name") String name);
}
