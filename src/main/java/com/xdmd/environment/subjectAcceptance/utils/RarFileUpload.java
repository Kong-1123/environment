package com.xdmd.environment.subjectAcceptance.utils;

import com.xdmd.environment.subjectAcceptance.controller.AcceptApplyController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RarFileUpload {

    public static HashMap<String, String> rarFileUpload(MultipartFile file, String companyName, String type) {
        Logger log = LoggerFactory.getLogger(AcceptApplyController.class);

        HashMap<String, String> result = new HashMap<>();
//        if (file.isEmpty()) {
//            result.put("1", "文件不可以为空");
//            return result;
//        }
        if (!StringUtils.isNotBlank(file.getOriginalFilename())) {
            result.put("1","文件不可以为空");
            return result;
        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //判断文件的后缀名是否有误
        ArrayList<String> suffixs = new ArrayList<>();
        suffixs.add(".rar");
        suffixs.add(".zip");
        suffixs.add(".7Z");

        //获取文件的后缀名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));

        String reusltFlag = "错误";
        for (String suffix : suffixs) {
            if (suffix.equalsIgnoreCase(suffixName)) {
                reusltFlag = "正确";
            }
        }
        if(reusltFlag.equals("错误")){
            result.put("1","请上传正确的文件格式");
            return result;
        }

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = dateFormat.format(date);

        //文件保存的路径
        String FilePath = "D://xdmd_environment//Extranet//" + companyName + "//" + type + "//"+nowTime+"//";

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
            result.put("1", "文件上传失败");
            return result;
        }
        result.put("0", FilePath + originalFilename);
        return result;
    }
}
