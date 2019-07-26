package com.xdmd.environment.company.exception;

/**
 * 文件上传失败
 */
public class FileUploadException extends Exception{
    public FileUploadException() {

    }
    public FileUploadException(String errorMsg) {
        super(errorMsg);
    }
}
