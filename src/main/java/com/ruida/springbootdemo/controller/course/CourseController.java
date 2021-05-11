package com.ruida.springbootdemo.controller.course;

import com.ruida.springbootdemo.entity.result.CommonResult;
import com.ruida.springbootdemo.mapper.CourseDao;
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
    CourseDao courseDao;

    @RequestMapping(value = "/getCourseInfo",method = RequestMethod.GET)
    public String getCourseInfo(){
        return "hello course controller";
    }

    @RequestMapping(value = "saveCourse",method = RequestMethod.POST)
    public CommonResult saveCourse(@RequestBody Course course){
        CommonResult result = null;
        Course c = courseDao.save(course);
        if (c != null) {
            result = CommonResult.build(ErrorEnum.OK);
        }else {
            result =  CommonResult.build(ErrorEnum.ERROR);
        }
        return result;
    }

    @RequestMapping(value = "queryById/{id}",method = RequestMethod.GET)
    public CommonResult queryById(@PathVariable("id") Integer id){
        CommonResult result;
        Course course = courseDao.selectById(id);
        if (course != null) {
            result = CommonResult.build(ErrorEnum.OK.getErrorCode(),ErrorEnum.OK.getErrorMsg());
        }else {
            result = CommonResult.build(ErrorEnum.NO_DATA);
        }
        return result;
    }

}
