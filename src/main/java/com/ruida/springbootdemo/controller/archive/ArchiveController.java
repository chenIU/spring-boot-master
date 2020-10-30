package com.ruida.springbootdemo.controller.archive;

import com.ruida.springbootdemo.entity.result.CommonResult;
import com.ruida.springbootdemo.entity.request.ArchiveInfoRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-29 15:07
 */
@RestController
@RequestMapping("/archive/")
public class ArchiveController {

    @PostMapping("createArchive")
    public CommonResult createArchive(@RequestBody @Validated ArchiveInfoRequest request){
        return new CommonResult();
    }
}
