package com.ruida.springbootdemo.utils.excel;

import com.ruida.springbootdemo.constant.SystemConstant;
import com.ruida.springbootdemo.utils.ValidateMT;
import com.ruida.springbootdemo.utils.excel.processor.TypeProcessor;
import com.ruida.springbootdemo.utils.excel.processor.TypeProcessorFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 10:16
 */
public class ExcelHelper<T> {

    Class<T> clazz;

    public ExcelHelper(Class<T> clazz){
        this.clazz = clazz;
    }

    public Workbook generateWorkbook(List<T> list) throws Exception {
        Workbook wb = new XSSFWorkbook();

        XSSFCellStyle cellStyle = ((XSSFWorkbook) wb).createCellStyle();
        cellStyle.setBottomBorderColor(HSSFColor.HSSFColorPredefined.RED.getIndex());

        Sheet sheet = wb.createSheet("Sheet1");
//        sheet.setDefaultColumnWidth(15);

        //设置字体
        XSSFFont font = ((XSSFWorkbook) wb).createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("宋体");
        font.setItalic(true);
        font.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());

        //设置样式
        cellStyle.setFont(font);

        List<FieldBean<T>> fieldBeanList = getFieldBeanList();
//        FieldBean fieldBean = fieldBeanList.get(0);

        Map<Integer,Integer> columnWidth = new HashMap<>();

        CellStyle style = getTitleCellStyle(wb);

        Row titleRow = sheet.createRow(0);
        for (int i = 0; i < fieldBeanList.size(); i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(fieldBeanList.get(i).getTitle());
            //记录表头宽度
            columnWidth.put(i,cell.getStringCellValue().getBytes().length * 256 + 200);
        }

        for (int i = 0; i < list.size(); i++) {
            T rowData = list.get(i);
            Row row = sheet.createRow(i + 1);

            int cellIndex = 0;
            for(FieldBean fieldBean : fieldBeanList){
                Object value = fieldBean.getInvoke(rowData);

                String valueString = ValidateMT.isNull(value) ? "" : value.toString();
                Cell cell = row.createCell(cellIndex++);
                cell.setCellStyle(style);
                cell.setCellValue(valueString);
                int length = cell.getStringCellValue().getBytes().length * 256 + 200;
                if(length > 15000){
                    length = 15000;
                }
                columnWidth.put(cellIndex - 1,Math.max(length,columnWidth.get(cellIndex - 1)));
            }
        }

        //列宽度自适应
        for (int i = 0; i < fieldBeanList.size(); i++) {
            sheet.setColumnWidth(i,columnWidth.get(i));
        }
        return wb;
    }

    private List<FieldBean<T>> getFieldBeanList() throws Exception {
        Class clazz = this.clazz;
        List<Field> fieldList = new ArrayList<>();
        while(clazz != null){
            Field[] fields = clazz.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            clazz = clazz.getSuperclass();
        }

        List<FieldBean<T>> list = new ArrayList<>();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            ExcelAnnotation excelAnnotation = field.getAnnotation(ExcelAnnotation.class);
            if(excelAnnotation != null){

                String title = excelAnnotation.title();
                boolean require = excelAnnotation.require();
                int scale = excelAnnotation.scale();
                String dateFormat = excelAnnotation.dateFormat();
                int order = excelAnnotation.order();

                if(StringUtils.isBlank(title)){
                    continue;
                }

                String fieldName = field.getName();
                String setMethodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);

                Method setMethod;
                Method getMethod;

                if(fieldName.startsWith("is")){
                    try {
                        String isSetMethodName = "set" + fieldName.substring(2,3).toUpperCase() + fieldName.substring(3);
                        String isGetMethodName = "is"  + fieldName.substring(2,3).toUpperCase() + fieldName.substring(3);
                        setMethod = this.clazz.getMethod(isSetMethodName, new Class[]{field.getType()});
                        getMethod = this.clazz.getMethod(isGetMethodName);
                    }catch (Exception e){
                        setMethod = this.clazz.getMethod(setMethodName,new Class[]{field.getType()});
                        getMethod = this.clazz.getMethod(getMethodName);
                    }
                }else {
                    setMethod = this.clazz.getMethod(setMethodName,new Class[]{field.getType()});
                    getMethod = this.clazz.getMethod(getMethodName);
                }

                if(setMethod == null){
                    throw new Exception(fieldName + "无set方法");
                }

                Type[] setParameters = setMethod.getGenericParameterTypes();
                String paramString = setParameters[0].toString();

                TypeProcessor typeProcessor = TypeProcessorFactory.getInstance().getProcessor(paramString,scale,dateFormat);
                if(typeProcessor == null){
                    throw new Exception(paramString + "没有定义对应的类型处理器");
                }

                FieldBean<T> fieldBean = new FieldBean<>();
                fieldBean.setSetMethod(setMethod);
                fieldBean.setGetMethod(getMethod);
                fieldBean.setTitle(title);
                fieldBean.setRequire(require);
                fieldBean.setOrder(order);
                fieldBean.setTypeProcessor(typeProcessor);
                list.add(fieldBean);
            }
        }
        Collections.sort(list);
        return list;
    }

    private CellStyle getTitleCellStyle(Workbook wb){
        CellStyle cellStyle = wb.createCellStyle();

        //设置边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);

        //设置字体
        Font font = wb.createFont();
        font.setFontName(SystemConstant.DEFAULT_FONT_NAME);
        cellStyle.setFont(font);

        return cellStyle;
    }
}
