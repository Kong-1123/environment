package com.xdmd.environment.common;

import com.xdmd.environment.company.exception.FileSuffixJudgeException;
import com.xdmd.environment.company.exception.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

        HashMap<String, String> result = new HashMap<>();
//        if (!StringUtils.isNotBlank(file.getOriginalFilename())) {
//            result.put("1","文件不可以为空");
//            return result;
//        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //判断文件的后缀名是否有误
        Boolean Flag = FileSuffixJudgeUtil.SuffixJudge(originalFilename,suffixList);

        if(Flag == false){
            throw new FileSuffixJudgeException("请上传正确的文件格式");
        }

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = dateFormat.format(date);

        //文件保存的路径
        String FilePath = "D://xdmd_environment//Extranet//" + companyName + "//" + type + "//" + nowTime + "//";

        File dest = new File(FilePath + originalFilename);

        //检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            //文件上传
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("AcceptApplyController -- AddAcceptApply 中 FileUpload 文件上传失败");
            throw new FileUploadException("文件上传失败");
        }

        return  FilePath + originalFilename;
    }
}
