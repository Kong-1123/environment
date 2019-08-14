package com.xdmd.environment.uploadmanagement.mapper;

import com.xdmd.environment.uploadmanagement.pojo.UploadFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: Kong
 * @createDate: 2019/07/31
 * @description: 保存文件到数据库
 */
@Mapper
@Repository
public interface UploadMapper {
    /**
     *
     * @param uploadFile
     * @return
     */
    @Select(value = "INSERT INTO upload_file (upload_file_path,upload_file_name, upload_file_type,upload_suffix_name,file_size,create_time,create_author)\n" +
            "VALUES(" +
            "#{uploadFilePath},"+
            "#{uploadFileName},"+
            "#{uploadFileType},"+
            "#{uploadSuffixName},"+
            "#{fileSize},"+
            "NOW(),"+
            "#{createAuthor})")
    Integer insertUpload(UploadFile uploadFile);

    /**
     * 根据文件名查询文件路径
     * @param id
     * @return
     */
    @Select(value = "select upload_file_path,upload_file_name from upload_file where id= #{id}")
    UploadFile getFilePath(int id);

}
