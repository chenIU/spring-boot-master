package com.ruida.springbootdemo.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 09:12
 */
public class CommonApiTest {

    public static void main(String[] args) {

//        createWorkbook();
//        createSheet();
//        createRowAndCell();
        dateFormat();
    }

    public static void createWorkbook(){
        Workbook wb = new HSSFWorkbook();

        try {
            FileOutputStream fos = new FileOutputStream("E:\\poi\\workbook.xls");
            wb.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createSheet(){
        Workbook wb = new HSSFWorkbook();
        wb.createSheet("第一个sheet");
        wb.createSheet("第二个sheet");

        try {
            FileOutputStream fos = new FileOutputStream("E:\\poi\\sheet.xls");
            wb.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createRowAndCell(){
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("第一个sheet");
        Row row = sheet.createRow(0);

        //单元格的内容可以是double、Date、LocalDateTime、LocalDate、String、boolean、Calendar、RichTextString
        row.createCell(0).setCellValue(1);
        row.createCell(1).setCellValue("这是第一个单元格");
        row.createCell(2).setCellValue(false);

        try {
            FileOutputStream fos = new FileOutputStream("E:\\poi\\RowAndCell.xls");
            wb.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dateFormat(){
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("第一个sheet");
        Row row = sheet.createRow(0);
        CreationHelper creationHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd :hh:mm:ss"));
        Cell cell = row.createCell(0);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);

        try {
            FileOutputStream fos = new FileOutputStream("E:\\poi\\dateFormat.xls");
            wb.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
