package com.xdmd.environment.subjectAcceptance.mapper;

import com.xdmd.environment.common.MyBaseMapper;
import com.xdmd.environment.subjectAcceptance.pojo.UploadFile;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AcceptApplyFileUploadMapper extends MyBaseMapper<UploadFile> {
    @Select("select id,upload_file_address from upload_file where upload_surface_id = #{id} and upload_file_type = #{acceptApplyFile}")
    UploadFile queryFileUrl(@Param("id") Integer id, @Param("acceptApplyFile") String acceptApplyFile);
}
