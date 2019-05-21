package com.gfc.parser;

/**
 * @ClassName: ArgNotAllowedException
 * @Description:
 * @CreatedBy: xiaoguo
 * @CreatedAt: 2019/5/20 20:27
 **/
public class ArgNotAllowedException extends Exception {
//    public ArgNotAllowedException() {
//    }
    public ArgNotAllowedException(String notAllowedArg) {
        System.out.println(notAllowedArg + " not allowed!");
    }

}
