package com.ruida.springbootdemo.controller.excel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-21 13:39
 */
@RestController
@RequestMapping("/excel/")
@Slf4j
public class ExcelController {

    /*@ResponseBody
    @RequestMapping(value = "template",method = RequestMethod.GET)
    public CommonResult getApplicationTemplate(HttpServletRequest req, HttpServletResponse res) {
        try {
            //获取要下载的模板名称
            String fileName = "StudentTemplate.xlsx";
            //设置要下载的文件的名称
            res.setHeader("Content-disposition", "attachment;fileName=" + fileName);
            //通知客服文件的MIME类型
            //res.setContentType("application/vnd.ms-excel;charset=UTF-8");
            res.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");
            //获取文件的路径
            String filePath = getClass().getResource("/templates/" + fileName).getPath();
            FileInputStream input = new FileInputStream(filePath);
            OutputStream out = res.getOutputStream();
            byte[] b = new byte[2048];
            int len;
            while ((len = input.read(b)) != -1) {
                out.write(b, 0, len);
            }
            //修正 Excel在“xxx.xlsx”中发现不可读取的内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
            res.setHeader("Content-Length", String.valueOf(input.getChannel().size()));
            input.close();
            return CommonResult.OK("应用导入模板下载完成");
        } catch (Exception ex) {
            log.error("getApplicationTemplate :", ex);
            return CommonResult.OK("应用导入模板下载失败！");
        }
    }*/

    @RequestMapping(value = "/downloadTemplate", method = RequestMethod.GET)
    public void downloadExample(HttpServletResponse response) {
        // 获取固定Excel文件作为输入流 (参数为配置的模板路径)
        InputStream in = this.getClass().getResourceAsStream("/static/StudentTemplate.xlsx");
        OutputStream toClient = null;
        byte[] buffer;
        try {
            // 获取导出文件的字节数组
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer1)) != -1) {
                outStream.write(buffer1, 0, len);
            }
            in.close();
            buffer = outStream.toByteArray();

            // 导出Excel
            if (null != buffer && buffer.length > 0) {
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Disposition",
                        "attachment;filename=" + new String(("模板.xlsx").getBytes("GBK"), "ISO8859_1"));
                response.addHeader("Content-Length", "" + buffer.length);
                toClient = response.getOutputStream();
                response.setContentType("application/octet-stream");
                toClient.write(buffer);
                toClient.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (toClient != null) {
                try {
                    toClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
