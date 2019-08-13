package com.xdmd.environment.uploadmanagement.controller;

import com.xdmd.environment.uploadmanagement.mapper.UploadMapper;
import com.xdmd.environment.uploadmanagement.pojo.FileUpload;
import com.xdmd.environment.uploadmanagement.uploadutil.FileSuffixJudge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author: Kong
 * @createDate: 2019/07/31
 * @description: 文件上传
 */
@Controller
public class FileUploadController {
    @Autowired
    UploadMapper uploadMapper;
    FileUpload fileUpload;
    /**
     * 获取file.html页面
     * @return
     */
    @RequestMapping("file")
    public String file(){
        return "/file";
    }

    /**
     * 实现单文件上传
     * */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "上传文件不可为空";
        }

        // 获取文件名拼接当前系统时间作为新文件名
        String nowtime =  new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());
        StringBuilder pinjiefileName=new StringBuilder(nowtime).append(file.getOriginalFilename());
        String fileName =pinjiefileName.toString();

        //获取文件上传绝对路径
        StringBuilder initPath = new StringBuilder("D:/xdmd/subject-1/");
        String filePath=initPath.append(fileName).toString();
        System.out.println("文件路径-->"+filePath);
        File dest = new File(filePath);

        //获取文件类型
        String contentType = file.getContentType();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
        //判断上传文件类型是否符合要求
        Boolean typeIsOK= FileSuffixJudge.suffixJudge(file.getOriginalFilename());
        if (typeIsOK==false){
            return "上传的文件类型不符合要求";
        }
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            //保存文件
            file.transferTo(dest);
            // 获取文件大小
            File file1 = new File(filePath);
            String fileSize = String.valueOf(file1.length());
            System.out.println(fileName+"的文件大小-->"+fileSize);
            //封装到uploadfile
            fileUpload.setUploadFilePath(String.valueOf(dest));
            fileUpload.setFileSize(fileSize);
            fileUpload.setUploadFileName(fileName);
            fileUpload.setUploadFileType(contentType);
            fileUpload.setUploadSuffixName(suffixName);
            fileUpload.setCreateAuthor("创建者");
            Integer affectNo=uploadMapper.insertUpload(fileUpload);
            return "上传成功";
        } catch (Exception e) {
             e.printStackTrace();
        }
        return "上传失败";
    }
}
