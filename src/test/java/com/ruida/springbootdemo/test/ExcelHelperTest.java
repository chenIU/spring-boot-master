package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.model.Book;
import com.ruida.springbootdemo.utils.excel.ExcelHelper;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 14:02
 */
public class ExcelHelperTest {
    public static void main(String[] args) throws Exception {
        List<Book> bookList = Lists.newArrayList(
                new Book(1L,"三国演义是一本很不错的书是三国爱好者的必读书籍","罗贯中"),
                new Book(3L,"水浒传","施耐庵"),
                new Book(2L,"西游记","吴承恩"),
                new Book(4L,"红楼梦","曹雪芹")
        );

        ExcelHelper<Book> excelHelper = new ExcelHelper<>(Book.class);
        Workbook wb = excelHelper.generateWorkbook(bookList);

        FileOutputStream fos = new FileOutputStream("E:\\poi\\bookList.xlsx");
        wb.write(fos);
        fos.flush();
        fos.close();
    }
}
