package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.User;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Chen.J.Y
 * @date 2021/7/5
 */
public class TestCommonUtil {

    /**
     * common-beanutils 操作对象
     */
    @Test
    @SneakyThrows
    public void convert() {
        User user = new User();
        user.setId(1);
        user.setUsername("张三");

        // 对象转map
        Map<String, String> map = BeanUtils.describe(user);
        System.out.println(map);

        // map转对象
        // BeanUtils.populate();
    }

    /**
     * common-io 文件流处理
     */
    @Test
    @SneakyThrows
    public void readAndWrite() {
        File file = new File("D:\\demo.txt");
        File file2 = new File("D:\\demo2.txt");
        File file3 = new File("D:\\demo3.txt");

        // 读取文件
        List<String> strList = FileUtils.readLines(file, Charset.defaultCharset());
        strList.forEach(System.out::println);

        // 写入文件
        FileUtils.writeLines(file2, strList);

        // 复制文件
        FileUtils.copyFile(file, file3);
    }

    /**
     * common-collections 操作集合
     */
    @Test
    public void operateList(){
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("a", "b", "d");

        // 交集
        System.out.println(CollectionUtils.retainAll(list1, list2));

        // 并集
        System.out.println(CollectionUtils.union(list1, list2));

        // 差集
        System.out.println(CollectionUtils.subtract(list2, list2));
    }
}
