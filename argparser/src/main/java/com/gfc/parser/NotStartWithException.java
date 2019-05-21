package com.gfc.parser;

/**
 * @ClassName: NotStartWithException
 * @Description:
 * @CreatedBy: xiaoguo
 * @CreatedAt: 2019/5/20 20:45
 **/
public class NotStartWithException extends Exception {
    public NotStartWithException(String arg) {
        System.out.println(arg + " should be start with \'-\'");
    }
}
