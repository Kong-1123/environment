package com.xdmd.environment.common;

import java.util.ArrayList;

/**
 * 判断上传文件的后缀名是否正确
 * @Author ZhangYuDeLong
 * @Date 2019.7.16
 */
public class FileSuffixJudge {

    public static String SuffixJudge(String FileName) {

        String result = "错误";

        ArrayList<String> Suffixs = new ArrayList<>();
        Suffixs.add(".doc");
        Suffixs.add(".docx");
        Suffixs.add(".xls");
        Suffixs.add(".xlsx");
        Suffixs.add(".ppt");
        Suffixs.add(".pptx");
        Suffixs.add(".JPG");
        Suffixs.add(".JPEG");
        Suffixs.add(".PNG");

        //获取文件的后缀名
        String suffixName = FileName.substring(FileName.lastIndexOf("."));
        for (String suffix : Suffixs) {
            if (suffixName.equalsIgnoreCase(suffix)) {
                result = "正确";
            }
        }
        return result;
    }
}