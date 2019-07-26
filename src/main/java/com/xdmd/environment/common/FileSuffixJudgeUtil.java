package com.xdmd.environment.common;

import java.util.List;

/**
 * 判断上传文件的后缀名是否正确
 *
 * @Author ZhangYuDeLong
 * @Date 2019.7.16
 */
public class FileSuffixJudgeUtil {

    public static Boolean SuffixJudge(String FileName, List<String> suffixList) {

        Boolean flag = false;

        String suffixName = FileName.substring(FileName.lastIndexOf("."));

        for (String suffix : suffixList) {
            if (suffix.equalsIgnoreCase(suffixName)) {
                flag = true;
            }
        }
        return flag;
    }
}