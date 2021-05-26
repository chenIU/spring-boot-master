package com.ruida.springbootdemo.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-07-30 16:34
 */
public class ApacheStringUtilsTest {
    public static void main(String[] args) {
        // 1、判断与验证
        /**
         * 1.1 Empty和Blank
         * 区别：Empty只有null或者空串，才返回true；Blank则会包含所有的空白字符（包括空格、tab、换行、回车等）
         */
        System.out.println(StringUtils.isEmpty(null));//true
        System.out.println(StringUtils.isEmpty(""));//true
        System.out.println(StringUtils.isEmpty(" "));//false
        System.out.println(StringUtils.isEmpty("\n"));//false
        System.out.println(StringUtils.isEmpty("\r"));//false
        System.out.println(StringUtils.isEmpty("\t"));//false
        System.out.println(StringUtils.isBlank(" "));//true
        System.out.println(StringUtils.isBlank(""));//true
        System.out.println(StringUtils.isBlank("\n"));//true
        System.out.println(StringUtils.isBlank("\t"));//true
        System.out.println(StringUtils.isBlank("\r"));//true

        /**
         * 1.2 比较字符串
         * equals、equalsIgnoreCase、compareTo、compareIgnoreCase 同JDK
         */

        /**
         * 1.3 检验字符串
         */
        System.out.println(StringUtils.isAllUpperCase("HELLO")); // isAllUpperCase：是否全为大写英文字母
        System.out.println(StringUtils.isAllLowerCase("hello")); // isAllLowerCase：是否全文小写英文字母
        System.out.println(StringUtils.isNumeric("110")); // isNumeric：是否全为数字
        System.out.println(StringUtils.isWhitespace("   ")); // isWhiteSpace：是否只包含空白字符

        /**
         * 1.4 包含字符串
         * contains 同JDK
         * containsIgnoreCase：忽略大小写
         * containsWhiteSpace：是否包含空白字符
         * containsOnly：只包含指定字符
         * containsAny：批量判断只包含一个
         * containsNone：批量判断不包含任何一个
         */

        /**
         * 1.5 起止字符判定
         */
        System.out.println(StringUtils.startsWith("startsWith","start")); // startsWith：以xxx开头 --> endsWith
        System.out.println(StringUtils.startsWithIgnoreCase("startsWith","STARTS")); // startsWithIgnoreCase：忽略大小写的判断以xxx开头 --> endsWithIgnoreCase

        // 2、处理字符串
        /**
         * 2.1 移除空白字符串
         * apache.common.lang3提供了两类方法，strip和trim
         * trim与jdk差异不大，主要增加了对null的处理
         * strip则做了很多增强，通过重载方法实现了很多其他功能，建议在开发中使用strip方法
         */
        //System.out.println(StringUtils.stripToEmpty("   ")); // stripToEmpty：将空白转换为空串
        System.out.println(StringUtils.stripToNull("   ")); // stripToNull：将空白转换为null
        System.out.println(StringUtils.strip("hello","o")); // 去除指定字符串

        /**
         * 2.2 去除换行
         */
        //System.out.println("hello world");
        System.out.println(StringUtils.chomp("hello world \n","\n")); // chomp：去除换行符

        /**
         * 2.3 去除间隔符
         * 去除末尾末尾一个字符，常见场景是通过循环使用间隔符拼装的数据，去除间隔符
         * 注意：使用时需要保证最后一位一定是间隔符，否则可能破坏正常的数据
         */
        System.out.println(StringUtils.chop("1,2,3,"));

        /**
         * 2.4 去除非数字
         */
        System.out.println(StringUtils.getDigits("100abc"));

        // 3、查找字符串
        /**
         * 3.1 查找字符串
         * indexOf、lastIndexOf 同jdk
         * 扩展：
         * indexOfIgnoreCase 忽略大小写
         * ordinalIndexOf 返回第n次匹配的索引数
         * indexOfAnyBut 返回不再索引范围内的第一个索引位置
         */

        // 4、编辑字符串
        /**
         * 4.1 分隔字符串 split
         */

        /**
         * 4.2 合并字符串
         * jdk中使用concat方法，StringUtils中使用join方法
         */

        /**
         * 4.3 截取字符串
         * 相关方法有多个，substring和truncate基本用法同jdk，内部处理异常
         */

        /**
         * 4.4 替换字符串
         * jdk中使用replace，StringUtils使用同样的名字，扩展实现了忽略大小写，只替换一次，指定最大替换次数等
         */
        System.out.println(StringUtils.replace("hello hello world","hello","world"));
        System.out.println(StringUtils.replaceIgnoreCase("hello hello world","HELLO","world")); // 忽略大小写
        System.out.println(StringUtils.replaceOnce("hello hello world","hello","world")); // 只替换一次
        System.out.println(StringUtils.replace("hello hello hello world","hello","world",2)); // 指定替换次数

        /**
         * 4.5 移除字符串
         * remove：移除字符串
         * removeIgnoreCase：忽略大小写
         * removeStart：从指定开始位置移除
         * removeEnd：从指定结束位置移除
         * removeStartIgnoreCase：指定位置且忽略大小写
         * removeEndIgnoreCase
         */

        /**
         * 4.6 覆盖部分字符串
         * 重要
         */
        System.out.println(StringUtils.overlay("17600738747","****",3,7));

        /**
         * 4.7 生成字符串（重复）
         */
        System.out.println(StringUtils.repeat("a",3));
        System.out.println(StringUtils.repeat("a",",",3)); //指定间隔符

        /**
         * 4.8 前缀和后缀
         * 如果只有两个参数，则是无条件添加；超过两个参数的情况，是在不匹配prefixes任何情况下才追加（没搞懂?）
         */
        System.out.println(StringUtils.prependIfMissing("hello","test-")); // 无条件增加前缀
        //System.out.println(StringUtils.prependIfMissing("hello","test-","000"));
        System.out.println(StringUtils.appendIfMissing("hello","-test")); // 追加后缀

        // 5、字符串转换
        /**
         * 5.1 大小写转换
         */
        System.out.println(StringUtils.upperCase("hello")); // 转化成大写
        System.out.println(StringUtils.lowerCase("HELLO")); // 转换成小写
        System.out.println(StringUtils.capitalize("hello")); // 首字母大写
        System.out.println(StringUtils.uncapitalize("HELLO")); // 首字母小写
        System.out.println(StringUtils.swapCase("hELlO"));

        /**
         * 5.2 字符串缩略
         */
        System.out.println(StringUtils.abbreviate("abcdefg",4));

        /**
         * 5.3 字符串补齐
         * center
         * leftPad
         * rightPad
         */
        System.out.println(StringUtils.center("100",10,'a'));
        System.out.println(StringUtils.leftPad("100",10,'0'));
        System.out.println(StringUtils.rightPad("100",10,'0'));

        /**
         * 5.4 旋转字符串
         * rotate
         * reverse
         */

        /**
         * 5.5 编码转换
         */
        String str = "中国";
        //System.out.println(StringUtils.toEncodedString(str.getBytes(), Charset.forName("GB2312")));
        //toCodePoints 转换unicode位码

        // 6、其他
        System.out.println(StringUtils.countMatches("hello",'l')); // 计算匹配的次数
        System.out.println(StringUtils.getCommonPrefix("abcdef","abcxyz")); // 截取相同前缀
        System.out.println(StringUtils.indexOfDifference("abcdef","abcxyz")); // 返回字符差异的索引位置
    }

    /**
     * StringUtils.isEmpty()和StringUtils.isBlank()的区别
     */
    @Test
    public void difference(){
        //StringUtils.isEmpty(String str) 判断字符串是否为空，判断的标准是str==null 或 str.length==0
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(StringUtils.isEmpty("dd"));

        //StringUtils.isBlank(String str) 判断某字符串是否为空或长度为0或由空白符(whitespace) 构成
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank("dd"));
    }
}