package com.ruida.springbootdemo.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-09 17:22
 */
public class ExceptionTest {
    public static void main(String[] args) {
        /**
         * ArithmeticException
         */
        //System.out.println(1/0);

        /**
         * NullPointerException
         */
        //String str = null;
        //System.out.println(str.length());

        /**
         * ClassCastException
         */

        /**
         * ArrayIndexOutOfBoundsException
         */

        /**
         * FileNotFoundException
         */

        /**
         * NoSuchMethodException
         */

        /**
         * IOException
         */

        /**
         * SQLException
         */

        /**
         * EOFException
         */

        /**
         * NumberFormatException
         */

        ExceptionTest et = new ExceptionTest();
        et.divide();
    }

    public void divide(){
        try {
            System.out.println(1/0);
        }catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getSuppressed());
            System.out.println(JSONObject.toJSONString(e.getSuppressed()));
            System.out.println(JSONObject.toJSONString(e.getStackTrace()));
        }
    }
}
