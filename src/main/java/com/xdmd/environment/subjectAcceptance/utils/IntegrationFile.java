package com.xdmd.environment.subjectAcceptance.utils;

import com.xdmd.environment.subjectAcceptance.pojo.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把上传文件的属性存储起来 保存到数据中
 */
public class IntegrationFile {

    public static UploadFile IntegrationFile(MultipartFile file, Integer id, String fileurl, String FileType, String createname) {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setUploadSurfaceId(id);
        uploadFile.setUploadFileAddress(fileurl);
        //获取文件名
        String filename = file.getOriginalFilename();
        uploadFile.setUploadFileName(filename);

        //获取日期文件名
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        String dataFileName = format + filename;
        uploadFile.setDateFileName(dataFileName);

        //获取文件后缀名
        String substring = filename.substring(filename.lastIndexOf(".") + 1);
        uploadFile.setUploadSuffixName(substring);

        uploadFile.setUploadFileType(FileType);

        //获取文件的大小
        File file1 = new File(fileurl);
        long length = file1.length();
        String valueOf = String.valueOf(length);
        uploadFile.setFileSize(valueOf);

        //创建人的名字
        uploadFile.setCreateAuthor(createname);

        //获取当前创建的时间
        uploadFile.setCreateTime(date);

        return uploadFile;
    }

    //文件在进行更新的时候 进行的操作
    public static UploadFile IntegrationFile(MultipartFile file, Integer id, String fileurl, String FileType, String createname, Integer fileId) {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setUploadSurfaceId(id);
        uploadFile.setUploadFileAddress(fileurl);
        //获取文件名
        String filename = file.getOriginalFilename();
        uploadFile.setUploadFileName(filename);

        //获取日期文件名
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        String dataFileName = format + filename;
        uploadFile.setDateFileName(dataFileName);

        //获取文件后缀名
        String substring = filename.substring(filename.lastIndexOf(".") + 1);
        uploadFile.setUploadSuffixName(substring);

        uploadFile.setUploadFileType(FileType);

        //获取文件的大小
        File file1 = new File(fileurl);
        long length = file1.length();
        String valueOf = String.valueOf(length);
        uploadFile.setFileSize(valueOf);

        //创建人的名字
        uploadFile.setCreateAuthor(createname);

        //获取当前创建的时间
        uploadFile.setCreateTime(date);
        uploadFile.setId(fileId);

        return uploadFile;
    }
}
