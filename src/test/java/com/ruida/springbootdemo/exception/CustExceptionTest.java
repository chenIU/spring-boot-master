package com.ruida.springbootdemo.exception;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 16:08
 */
public class CustExceptionTest {
    public static void main(String[] args) {
        throw new CustException("500","出现异常啦...");
    }
}
