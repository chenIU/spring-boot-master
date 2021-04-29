package com.ruida.springbootdemo.controller.upload;

import com.ruida.springbootdemo.entity.result.CommonResult;
import com.ruida.springbootdemo.config.ImageConfig;
import com.ruida.springbootdemo.constant.SystemConstant;
import com.ruida.springbootdemo.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

@RestController
@RequestMapping("/upload/")
@Slf4j
public class UploadController {

    @Resource
    ImageConfig imageConfig;

    /**
     * 上传图片
     * @param file
     * @return
     */
    @PostMapping("uploadImg")
    public CommonResult uploadImg(@RequestParam("file")MultipartFile file) {
        CommonResult result = new CommonResult();
        String fileType = getFileSuffix(file.getOriginalFilename());
        if (StringUtils.equals("jpg", fileType)
                || StringUtils.equals("png", fileType)
                || StringUtils.equals("jpeg", fileType)
                || StringUtils.equals("bmp", fileType)) {
            String name = String.format(SystemConstant.IMG_NAME, file.getOriginalFilename());
            try {
                String path = imageConfig.getImgPath() + imageConfig.getSubPath() + "/";
                file.transferTo(new File(path + name));
            } catch (Exception e) {
                throw new BaseException("500", "图片上传失败");
            }
        } else {
            throw new BaseException("500", "图片格式不正确");
        }
        return result;
    }

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public String getFileSuffix(String fileName){
        if(StringUtils.isEmpty(fileName)){
            return "none";
        }
        int lastIndex = fileName.lastIndexOf(".");
        return fileName.substring(lastIndex + 1);
    }
}
