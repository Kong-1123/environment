package com.xdmd.environment.subjectAcceptance.exception;

/**
 * Mysql中语句错误
 * @Author ZhangYuDeLong
 * @Date 2019.7.16
 */
public class MysqlErrorException extends Exception {
    public MysqlErrorException() {

    }
    public MysqlErrorException(String errorMsg) {
        super(errorMsg);
    }
}
