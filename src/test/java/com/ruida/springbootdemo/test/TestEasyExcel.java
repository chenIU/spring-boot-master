package com.ruida.springbootdemo.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.ruida.springbootdemo.entity.ExcelData;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenjy
 * @date 2021/3/6
 */
public class TestEasyExcel {

    public static void main(String[] args) {
        List<ExcelData> list = parseData();
        EasyExcel.write("G:\\mock\\学生信息表_副本.xlsx")
                .head(ExcelData.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("sheet1")
                .doWrite(list);
    }

    public static List<ExcelData> parseData(){
        List<ExcelData> list = new LinkedList<>();
        EasyExcel.read("G:\\mock\\学生信息表.xlsx")
                .sheet()
                .head(ExcelData.class)
                .registerReadListener(new AnalysisEventListener<ExcelData>() {

                    @Override
                    public void invoke(ExcelData excelData, AnalysisContext analysisContext) {
                        list.add(excelData);
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                        System.out.println("数据读取完毕...");
                    }
                }).doRead();
        return list;
    }
}
