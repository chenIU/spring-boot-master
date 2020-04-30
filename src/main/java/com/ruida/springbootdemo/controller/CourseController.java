package com.ruida.springbootdemo.controller;

import com.ruida.springbootdemo.bean.CommonResult;
import com.ruida.springbootdemo.dao.ICourseDao;
import com.ruida.springbootdemo.entity.Course;
import com.ruida.springbootdemo.enums.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-04-27 14:33
 */
@RestController
@RequestMapping("")
@Slf4j
public class CourseController {

    @Autowired
    ICourseDao courseDao;

    @RequestMapping(value = "/getCourseInfo",method = RequestMethod.GET)
    public String getCourseInfo(){
        return "hello course controller";
    }

    @RequestMapping(value = "saveCourse",method = RequestMethod.POST)
    public CommonResult saveCourse(@RequestBody Course course){
        CommonResult result = null;
        Course c = courseDao.save(course);
        if (c != null) {
            result = new CommonResult(ErrorEnum.OK);
        }else {
            result =  new CommonResult(ErrorEnum.ERROR);
        }
        return result;
    }

    @RequestMapping(value = "queryById/{id}",method = RequestMethod.GET)
    public CommonResult queryById(@PathVariable("id") Integer id){
        CommonResult result;
        Course course = courseDao.selectById(id);
        if (course != null) {
            result = new CommonResult(course,ErrorEnum.OK.getErrorCode(),ErrorEnum.OK.getErrorMsg());
        }else {
            result = new CommonResult(ErrorEnum.NO_DATA);
        }
        return result;
    }

}
