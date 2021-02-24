package com.ruida.springbootdemo.controller.user;

import com.github.pagehelper.PageInfo;
import com.overmind.logging.TimeLog;
import com.ruida.springbootdemo.config.MultiDataSource;
import com.ruida.springbootdemo.controller.BaseController;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.entity.result.CommonResult;
import com.ruida.springbootdemo.entity.result.ListResult;
import com.ruida.springbootdemo.entity.result.MapResult;
import com.ruida.springbootdemo.entity.result.PojoResult;
import com.ruida.springbootdemo.enums.ErrorEnum;
import com.ruida.springbootdemo.exception.BizException;
import com.ruida.springbootdemo.mapper.UserMapper;
import com.ruida.springbootdemo.service.UserService;
import com.ruida.springbootdemo.service.impl.UserServiceImpl;
import com.ruida.springbootdemo.utils.SpringUtil;
import com.ruida.springbootdemo.utils.excel.ExcelHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 用户请求控制器
 * @author: chenjy
 * @create: 2020-03-27 11:13
 */
@RestController()
@RequestMapping("/user/")
@Slf4j
public class UserController extends BaseController {

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static final String CHARSET = "UTF-8";

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private MultiDataSource dataSource;

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @Resource
    UserMapper userMapper;

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
    public MapResult<String,String> login(String username, String password) {
        return userService.login(username,password);
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

    @RequestMapping(value = "queryUserById/{userId}",method = RequestMethod.GET)
    public PojoResult queryUserById(@PathVariable String userId){
        if(log.isInfoEnabled()){
            log.info("用户id为：{}的请求进入",userId);
        }
        PojoResult result = new PojoResult();
        result.setContent(userService.queryUserById(userId));
        result.setErrorMsg("查询成功");
        return result;
    }

    @GetMapping("exception")
    public CommonResult exception() {
        throw new BizException("E_100500", "手机号码绑定失败", 500);
    }

    @GetMapping("getUserInfo")
    public User getUserInfo(){
        User user = new User();
        user.setUsername("jack");
        return user;
       /* Student stu = null;
        int i = 1/0;
        if(null==stu){
            throw new BizException("E10001","实体对象为空",401);
        }else {
            return stu;
        }*/
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
    public CommonResult getUserById(@PathVariable("id") Integer id){
        CommonResult result = new CommonResult();
        User user = userService.selectUserById(id);
        if(user != null){
            result.setSuccess(true);
            result.setErrorMsg("查询成功");
        }else {
            result.setSuccess(false);
            result.setErrorMsg("查询失败");
        }
        return result;
    }

    @RequestMapping(value = "getUserByAware",method = RequestMethod.GET)
    public User getUserByAware(@RequestParam("id")Integer id){
        UserService userService = SpringUtil.getBean(UserServiceImpl.class);
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
    public CommonResult addUser(@RequestBody @Validated User user){
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
        user.setUsername("chenjy");
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

    @RequestMapping(value = "getUserError",method = RequestMethod.GET)
    public CommonResult getUserError(){
        return CommonResult.error("1001","根据用户id查询失败");
    }

    @RequestMapping(value = "getUserOK",method = RequestMethod.GET)
    public CommonResult getUserOK(){
        return CommonResult.OK();
    }

    @RequestMapping(value = "testMapResult",method = RequestMethod.GET)
    public PojoResult<User> testMapResult(){
        throw new BizException("500","出现异常了...");
        //return  new MapResult();
    }

    @GetMapping("session")
    public CommonResult test(HttpServletRequest request,HttpServletResponse response){
        request.getSession().setAttribute("username","chenjy");
        return new CommonResult();
    }

    @GetMapping("getName")
    public String getName() {
        return messageSource.getMessage("user.name", null, LocaleContextHolder.getLocale());
    }

    @RequestMapping(value = "insertNameAndAge",method = RequestMethod.GET)
    public CommonResult insertNameAndAge(@RequestParam String username,@RequestParam Integer age){
        CommonResult result = new CommonResult();
        Integer count = userService.insertNameAndAge(username,age);
        if(count > 0){
            result.setSuccess(true);
            result.setErrorMsg("插入成功");
        }else {
            result.setSuccess(false);
            result.setErrorMsg("插入失败");
        }
        return result;
    }

    @RequestMapping(value = "getAllUsers",method = RequestMethod.GET)
    @TimeLog
    public ListResult getAllUsers(@RequestParam(required = false) String orderBy){
        ListResult<User> result = new ListResult<>();
        List<User> users = userService.selectAllUsers(orderBy);
        result.setSuccess(true);
        result.setErrorMsg("插入成功");
        result.setContent(users);
        return result;
    }

    @RequestMapping(value = "exportUser",method = RequestMethod.GET)
    public void exportUser(@RequestParam(required = false) String orderBy,HttpServletResponse response) throws Exception {
        List<User> userList = userService.selectAllUsers(orderBy);
        ExcelHelper<User> excelHelper = new ExcelHelper<>(User.class);
        Workbook workbook = excelHelper.generateWorkbook(userList);
        download(response,workbook,"学生信息");
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    @TimeLog
    public String test(String id,String name){
        log.info("===============id:{}",id);
        log.info("===============name:{}",name);
        return id + "," + name;
    }

    @RequestMapping(value = "produces",produces = "text/plain;charset=utf-8",method = RequestMethod.GET)
    @TimeLog
    public String produces(){
        return "陈俭银";
    }

    @GetMapping("selectByIdList")
    public ListResult<User> selectByIdList(String ids){
        ListResult<User> result = new ListResult<>();
        List<String> idList = Arrays.asList(ids.split(","));
        //如果参数类型时List,则在使用时,Collection属性必须要指定为list
        List<User> list = userMapper.selectByIdList(idList);
        result.setContent(list);
        return result;
    }

    @GetMapping("selectByIdArray")
    public ListResult<User> selectByIdArray(String ids){
        ListResult<User> result = new ListResult<>();
        //如果参数类型时Array,则在使用时,Collection属性必须要指定为array
        List<User> list = userMapper.selectByIdArray(ids.split(","));
        result.setContent(list);
        return result;
    }

    @GetMapping("selectByMultiArgs1")
    public ListResult<User> selectByMultiArgs1(Integer deptId,String ids){
        ListResult<User> result = new ListResult<>();
        //当查询的参数有多个时,有两种方式可以实现，一种是使用@Param("xxx")进行参数绑定，另一种可以通过Map来传参数。

        //第一种方式，@Param进行参数绑定
        List<User> list = userMapper.selectMultiArgs1(deptId,ids.split(","));
        result.setContent(list);
        return result;
    }

    @GetMapping("selectByMultiArgs2")
    public ListResult<User> selectByMultiArgs2(Integer deptId,String ids){
        ListResult<User> result = new ListResult<>();
        //当查询的参数有多个时,有两种方式可以实现，一种是使用@Param("xxx")进行参数绑定，另一种可以通过Map来传参数。

        //第二种方式，Map进行参数绑定
        Map<String,Object> map = new HashMap();
        map.put("deptId",deptId);
        map.put("ids",ids.split(","));
        List<User> list = userMapper.selectMultiArgs2(map);
        result.setContent(list);
        return result;
    }

    @GetMapping("aaa")
    public void aaa(){
        //模拟数据
        String str = "abc";
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
        this.download(this.getResponse(),in,"测试.txt");
    }

    @PostMapping("saveList")
    public CommonResult saveList(@RequestBody List<String> list){
        System.out.println(list.toString());
        return new CommonResult();
    }
}
