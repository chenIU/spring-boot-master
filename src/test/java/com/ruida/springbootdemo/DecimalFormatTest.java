package com.ruida.springbootdemo;

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
        double pi = 3.1415926;//pai
        // 取整
        System.out.println(new DecimalFormat("0").format(pi));

        // 保留整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));

        // 取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));

        // 以百分比形式展示，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(pi));

        // 以千分比的形式展示
        System.out.println(new DecimalFormat("#.##\u2030").format(pi));

        long c = 299792458;//光速
        // 显示为科学计数法，并保留五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(c));

        // 显示为两位小数的科学计数法，并保留四为小数
        System.out.println(new DecimalFormat("00.####E0").format(c));

        // 每三位以逗号分隔
        System.out.println(new DecimalFormat(",###").format(c));

        // 在格式中嵌入文本
        System.out.println(new DecimalFormat("光速大小为每秒,###米").format(c));
    }
}
