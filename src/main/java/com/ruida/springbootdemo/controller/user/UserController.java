package com.ruida.springbootdemo.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ruida.springbootdemo.bean.CommonResult;
import com.ruida.springbootdemo.config.MultiDataSource;
import com.ruida.springbootdemo.entity.Student;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.enums.ErrorEnum;
import com.ruida.springbootdemo.exception.BizException;
import com.ruida.springbootdemo.service.IUserService;
import com.ruida.springbootdemo.service.impl.UserService;
import com.ruida.springbootdemo.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 用户请求控制器
 * @author: chenjy
 * @create: 2020-03-27 11:13
 */
@RestController()
@RequestMapping("/user/")
@Slf4j
public class UserController {

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static final String CHARSET = "UTF-8";

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private MultiDataSource dataSource;

    @Autowired
    IUserService userService;

    @GetMapping("use")
    public void useThrealLocal(Integer integer, HttpServletRequest request) throws InterruptedException {
        threadLocal.set(integer);
        log.info("修改threadLocal成员变量" + integer);
        Thread.sleep(5000);
        log.info("输出成员变量" + threadLocal.get());
    }

    @RequestMapping(value = "wechat", method = RequestMethod.GET)
    public void wechat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=" + CHARSET);
        response.getWriter().write("中国");
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping(value = "request")
    public void request(HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream in = request.getInputStream();
            byte b[] = new byte[1024];
            int len = 0;
            int tmp;
            while ((tmp = in.read()) != -1) {
                b[len] = (byte) tmp;
                len++;
            }
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(new String(b));
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("auth")
    public void auth(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getServletPath());
        System.out.println(request.getRequestURL());
        System.out.println(request.getHeader("auth"));
        response.setContentType("text/html;charset=UTF-8");
    }

    @PostMapping("login")
    public Map<String, Object> login() {
        Map<String, Object> map = new HashMap();
        map.put("errorCode", 200);
        map.put("errorMsg", "登录成功");
        return map;
    }

    @RequestMapping(value = "updateUserInfo", method = RequestMethod.PUT)
    public Map<String, Object> updateUserInfo(@RequestParam(name = "userName", required = false) String userName,
                                              @RequestParam(name = "password", required = false) String password) {
        System.out.println("userName="+userName+",password="+password);
        Map<String, Object> map = new HashMap();
        map.put("errorCode", 200);
        map.put("errorMsg", "修改成功");
        return map;
    }

    @GetMapping("exception")
    public JSONObject exception() {
        throw new BizException("E_100500", "手机号码绑定失败", 500);
    }

    @GetMapping("getStudentInfo")
    public Student getStudentInfo(){
        Student stu = null;
        int i = 1/0;
        if(null==stu){
            throw new BizException("E10001","实体对象为空",401);
        }else {
            return stu;
        }
    }

    @PostMapping("submitForm")
    public void submitForm(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        System.out.println(username);
    }

   /* @GetMapping("getUserById/{id}")
    public CommonResult getUserById(@PathVariable("id") Integer id){
        CommonResult result = new CommonResult();
        User user = userService.selectUserById(id);
        result.setContent(user);
        result.setErrorCode(SystemConstant.SUCCESS_CODE);
        result.setErrorMsg(SystemConstant.SUCCESS_MSG);
        return result;
    }*/

    @GetMapping("getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.selectUserById(id);
    }

    @RequestMapping(value = "getUserByAware",method = RequestMethod.GET)
    public User getUserByAware(@RequestParam("id")Integer id){
        IUserService userService = SpringUtil.getBean(UserService.class);
        return userService.selectUserById(id);
    }

    /**
     * 分页查询下用户
     * @param pageNum 页码
     * @param pageSize 页的大小
     * @return
     */
    @RequestMapping(value = "queryUserListForPage",method = RequestMethod.GET)
    public PageInfo<User> queryUserListForPage(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        if(pageNum<=0){
            throw new BizException(ErrorEnum.E_2001);
        }
        return userService.selectAllUserListForPage(pageNum,pageSize);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping("addUser")
    public CommonResult addUser(@RequestBody User user){
        log.info(user.toString());
        if(userService.insertUser(user)>0){
            return new CommonResult(ErrorEnum.OK);
        }else {
            return new CommonResult(ErrorEnum.ERROR);
        }
    }

    /**
     * 通过用户id查询部门id
     * @param id
     * @return
     */
    @GetMapping("/queryDeptId/{id}")
    public CommonResult queryDeptById(@PathVariable("id")Integer id){
        Map<String,Object> map = userService.selectDeptById(id);

       /* if(!CollectionUtils.isEmpty(map)){
            return new CommonResult(map.get("deptId"),ErrorEnum.OK.getErrorCode(),ErrorEnum.OK.getErrorMsg());
        }else {
            return new CommonResult(ErrorEnum.ERROR);
        }*/

        System.out.println("deptId=="+map.get("deptId")+",roleId=="+map.get("roleId"));

        return new CommonResult(ErrorEnum.OK);
    }

    /**
     * 测试JsonIgnoreProperties注解，返回的实体类中去掉某些字段
     * @return
     */
    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public User getUser(){
        User user =  new User();
        user.setName("chenjy");
        user.setAge(27);
        user.setDeptId(1);
        user.setId(100);
        return user;
    }

    @GetMapping("countUser")
    public void countUser(){
        Integer count = userService.countUser();
        log.info("============"+count);
        //log.info(map.get("total").getClass().toString());
    }

}
