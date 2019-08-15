package com.xdmd.environment.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 文件上传工具类
 */
public class FileUploadUtil {

    /**
     * 0 为正确  1未错误
     *
     * @param file        上传的文件
     * @param companyName 公司名
     * @param type        类别
     * @param suffixList  后缀名集合
     * @return
     */
    public static String fileUpload(MultipartFile file, String companyName, String type, List<String> suffixList) throws Exception{
        Logger log = LoggerFactory.getLogger(FileUploadUtil.class);

//        HashMap<String, String> result = new HashMap<>();
//        if (!StringUtils.isNotBlank(file.getOriginalFilename())) {
//            result.put("1","文件不可以为空");
//            return result;
//        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //判断文件的后缀名是否有误
        //Boolean Flag = FileSuffixJudgeUtil.SuffixJudge(originalFilename,suffixList);

        //设置日期格式
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = dateFormat.format(date);

        //文件保存的路径
        String FilePath = "D:/xdmd_environment/" + companyName + "/" + type + "/" + nowTime + "/";

        File dest = new File(FilePath + originalFilename);

        //检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }


        return  FilePath + originalFilename;
    }
}
