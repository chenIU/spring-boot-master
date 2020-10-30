package com.ruida.springbootdemo.controller.student;

import com.alibaba.fastjson.JSON;
import com.ruida.springbootdemo.entity.Student;
import com.ruida.springbootdemo.entity.result.CommonResult;
import com.ruida.springbootdemo.entity.result.MapResult;
import com.ruida.springbootdemo.entity.result.PojoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/redis/")
public class StudentController {

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("save")
    public CommonResult save(@RequestBody Student student){
        CommonResult result = new CommonResult();
        redisTemplate.opsForValue().set("student", JSON.toJSONString(student));
        if(redisTemplate.hasKey("student")){
            result.setSuccess(true);
            result.setErrorMsg("插入成功!");
        }else {
            result.setSuccess(false);
            result.setErrorMsg("插入失败!");
        }
        return result;
    }

    @GetMapping("/get/{id}")
    public PojoResult<Student> get(@PathVariable("id") String id){
        PojoResult<Student> result = new PojoResult<>();
        Student student = (Student) redisTemplate.opsForValue().get(id);
        if(student != null){
            result.setContent(student);
            result.setSuccess(true);
            result.setErrorMsg("查询成功!");
        }else {
            result.setSuccess(false);
            result.setErrorMsg("key不存在!");
        }
        return result;
    }

    @DeleteMapping("delete/{id}")
    public CommonResult delete(@PathVariable("id") String id){
        CommonResult result = new CommonResult();
        boolean flag = redisTemplate.delete(id);
        if(flag){
            result.setSuccess(true);
            result.setErrorMsg("删除成功!");
        }else {
            result.setSuccess(false);
            result.setErrorMsg("删除失败!");
        }
        return result;
    }

    @GetMapping("/str")
    public MapResult string(){
        MapResult result = new MapResult();
        String str = "hello world";
        redisTemplate.opsForValue().set("str",str);
        result.add("str",redisTemplate.opsForValue().get("str"));
        result.setSuccess(true);
        result.setErrorMsg("操作成功");
        return result;
    }

    @GetMapping("/list")
    public MapResult list(){
        MapResult result = new MapResult();
        ListOperations<String,String> list = redisTemplate.opsForList();
        list.leftPush("list","hello");
        list.leftPush("list","hello");
        list.leftPush("list","world");
        list.leftPush("list","world");
        list.leftPush("list","java");
        list.leftPush("list","java");
        result.add("list",redisTemplate.opsForList().range("list",0,-1));
        result.setSuccess(true);
        result.setErrorMsg("操作成功");
        return result;
    }

    @GetMapping("/set")
    public MapResult set(){
        MapResult result = new MapResult();
        SetOperations<String,String> set = redisTemplate.opsForSet();
        set.add("set","hello");
        set.add("set","hello");
        set.add("set","world");
        set.add("set","world");
        set.add("set","java");
        set.add("set","java");
        result.add("set",redisTemplate.opsForSet().members("set"));
        result.setSuccess(true);
        result.setErrorMsg("操作成功");
        return result;
    }

    @GetMapping("/zset")
    public MapResult zset(){
        MapResult result = new MapResult();
        ZSetOperations<String,String> zset = redisTemplate.opsForZSet();
        zset.add("zset","hello",3);
        zset.add("zset","world",1);
        zset.add("zset","java",2);
        result.add("zset",redisTemplate.opsForZSet().range("zset",0,-1));
        result.setSuccess(true);
        result.setErrorMsg("操作成功");
        return result;
    }

    @GetMapping("/hash")
    public MapResult hash(){
        MapResult result = new MapResult();
        HashOperations hash = redisTemplate.opsForHash();
        hash.put("hash","key","value");
        result.add("hash",redisTemplate.opsForHash().get("hash","key"));
        result.setSuccess(true);
        result.setErrorMsg("操作成功");
        return result;
    }
}
