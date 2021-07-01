package com.ruida.springbootdemo.test;

import java.text.DecimalFormat;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-08-13 17:07
 * <p>
 *     0 阿拉伯数字
 *     # 阿拉伯数字不存在就显示为空
 *     . 小数分隔符或货币小数分隔符
 *     , 分组分隔符
 *     E 分割科学计数法中的尾数和指数
 *     % 乘以100并显示为百分数
 *     \2030 乘以1000并显示为千分数
 *     \u00A4 货币记号
 * </p>
 *
 * <p>
 *     1.整数：
 *     若是n个0,就从各位开始向高位填充,如果有值就是原来的值,没有就填充0
 *     若都是#,没有实际意义,不管是几个#都是原来的整数,
 *     0和#配合使用,只能是"##00",不能是"00##",即#在0的前面
 *
 *     2.小数:
 *     可以保留小数点后几位(几个0或者几个#)
 *     若是n个0,就是保留n位小数,小数不足的部分用0填充。如果是n个#,就保留n位小数,小数部分没有就是没有。
 * </p>
 */
public class DecimalFormatTest {
    public static void main(String[] args) {
        double pi = 3.1415926;
        // 取整
        System.out.println(new DecimalFormat("0").format(pi));//3

        //取所有整数部分，不足两位补0
        System.out.println(new DecimalFormat("00").format(pi));//03

        // 保留整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14

        // 取两位整数和三位小数（四舍五入）
        System.out.println(new DecimalFormat("00.000").format(pi));//03.142

        // 取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));//3

        // 以百分比形式展示，并取两位小数
        // %的作用是将原数字乘以100，并在末尾加上"%"
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%

        System.out.println(new DecimalFormat("#.##%").format((float) 2050/3536));

        System.out.println(new DecimalFormat("#.##%").format(0.579));

        // 以千分比的形式展示
        System.out.println(new DecimalFormat("#.##\u2030").format(pi));//3141.59%。

        long c = 299792458;//光速
        // 显示为科学计数法，并保留五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(c));

        // 显示为两位小数的科学计数法，并保留四为小数
        System.out.println(new DecimalFormat("00.####E0").format(c));

        // 每三位以逗号分隔
        System.out.println(new DecimalFormat(",###").format(c));

        // 在格式中嵌入文本
        System.out.println(new DecimalFormat("光速大小为每秒,###米").format(c));

        // '' 的作用是将目标数字加上前缀或者后缀
        System.out.println(new DecimalFormat("'$'#").format(100));

        // - 表示负数，要放在最前面
        System.out.println(new DecimalFormat("-0.00").format(pi));

        // 千分位
        System.out.println(new DecimalFormat("#.##\u2030").format(pi));

        // 分组分割符
        System.out.println(new DecimalFormat(",###").format(898347373));
    }
}
