package com.ruida.springbootdemo.test;

import java.util.Scanner;

/**
 * @description: Scanner
 * @author: chenjy
 * @create: 2021-01-04 10:03
 */
public class TestScanner {

    public static void main(String[] args) {
        System.out.println("1.开始 2.结束 (请选择!)");
        Scanner scanner = new Scanner(System.in);
        try {
            int i = scanner.nextInt();
            if(i == 1){
                System.out.println("您选择的是'开始'");
            }else if(i == 2){
                System.out.println("您选择的是'结束'");
            }else {
                System.out.println("非法输入!");
            }
        } catch (Exception e) {
            System.out.println("非法输入!");
        }
    }
}
