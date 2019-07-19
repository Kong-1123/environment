package com.xdmd.environment.subjectAcceptance.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class UploadFile {
    //主键Id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer id;

    //上传文件表Id
    private  Integer uploadSurfaceId;

    //上传文件地址
    private  String uploadFileAddress;

    //上传文件名
    private  String uploadFileName;

    //日期文件名
    private  String dateFileName;

    //上传文件类型
    private  String uploadFileType;

    //上传文件后缀名
    private  String uploadSuffixName;

    //文件大小
    private  String fileSize;

    private String createAuthor;

    private Date createTime;

    public UploadFile(Integer id, Integer uploadSurfaceId, String uploadFileAddress, String uploadFileName, String dateFileName, String uploadFileType, String uploadSuffixName, String fileSize, String createAuthor, Date createTime) {
        this.id = id;
        this.uploadSurfaceId = uploadSurfaceId;
        this.uploadFileAddress = uploadFileAddress;
        this.uploadFileName = uploadFileName;
        this.dateFileName = dateFileName;
        this.uploadFileType = uploadFileType;
        this.uploadSuffixName = uploadSuffixName;
        this.fileSize = fileSize;
        this.createAuthor = createAuthor;
        this.createTime = createTime;
    }

    public UploadFile() {
    }
}
