package com.ruida.springbootdemo.utils;

import com.ruida.springbootdemo.enums.ErrorEnum;
import com.ruida.springbootdemo.exception.BaseException;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Chen.J.Y
 * @date 2021/5/24
 */
public class ExcelUtil {

    public static void downloadStaticFile(HttpServletRequest request, HttpServletResponse response, String fileName) {
        if (StringUtils.isBlank(fileName)) {
            throw new BaseException(ErrorEnum.NO_PARAM, "文件名不能为空");
        }
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        InputStream inputStream = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource("static" + File.separator + fileName);
            inputStream = classPathResource.getInputStream();
            try {
                IOUtils.copy(inputStream, response.getOutputStream());
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
