package com.xdmd.environment.uploadmanagement.uploadutil;

import java.util.ArrayList;

/**
 * 判断文件的后缀名
 */
public class FileSuffixJudge {

    public static Boolean suffixJudge(String FileName) {
        Boolean flag = false;
        ArrayList<String> Suffixs = new ArrayList<>();
        Suffixs.add(".doc");
        Suffixs.add(".docx");
        Suffixs.add(".xls");
        Suffixs.add(".xlsx");
        Suffixs.add(".ppt");
        Suffixs.add(".pptx");
        Suffixs.add(".jpg");
        Suffixs.add(".jpeg");
        Suffixs.add(".png");
        Suffixs.add(".pdf");
        Suffixs.add(".rar");
        Suffixs.add(".zip");
        Suffixs.add(".7z");

        //获取文件的后缀名
        String suffixName = FileName.substring(FileName.lastIndexOf("."));
        for (String suffix : Suffixs) {
            if (suffixName.equalsIgnoreCase(suffix)) {
                flag = true;
            }
        }
        return flag;
    }
}
