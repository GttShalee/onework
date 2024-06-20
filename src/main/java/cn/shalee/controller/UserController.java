package cn.shalee.controller;

import cn.shalee.pojo.Result;
import cn.shalee.pojo.User;
import cn.shalee.service.UserService;
import cn.shalee.utils.JwtUtil;
import cn.shalee.utils.Md5Utils;
import cn.shalee.utils.ThreadLocalUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import java.util.HashMap;
import java.util.Map;


@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{2,10}$") String username, @Pattern(regexp = "^\\S{6,16}$") String password) {
        //查询用户 //校验请求信息
        User u = userService.findByUserName(username);

//    if (username != null && username.length() >= 2 && username.length() <= 10
//        && password != null && password.length() >= 6 && password.length() <= 20){

        if (u == null) {
            //用户名没有占用
            //注册用户
            userService.register(username, password);
            return Result.success();
        } else {
            //占用
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{2,10}$") String username, @Pattern(regexp = "^\\S{6,16}$") String password) {

        User u = userService.findByUserName(username);
        if (u == null) {
            return Result.error("用户不存在");
        }

        //判断密码是否正确
        if (Md5Utils.MD5Upper(password).equals(u.getPassword())) {
            //密码正确  //生成token
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());
            String genToken = JwtUtil.genToken(claims);

            return Result.success(genToken);
        }

        return Result.error("密码错误");
    }


    @GetMapping("/userInfo")
    public Result userInfor(/*@RequestHeader(name = "Student") String token*/) {

       /* Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");*/

        Map<String, Object> map  = ThreadLocalUtil.get();
        String username = (String) map.get("username");

        User user = userService.findByUserName(username);
        return Result.success(user);
    }


    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        if (avatarUrl == "") {
            return Result.error("不能为空");
        }
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params) {
        //校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要的参数");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        //原密码是否正确
        User loginUser = userService.findByUserName(username);
        if(!loginUser.getPassword().equals(Md5Utils.MD5Upper(oldPwd))) {
            return Result.error("原密码错误");
        }

        if(! rePwd.equals(newPwd)) {
            return Result.error("两次填写的密码不一致");
        }

        userService.updatePwd(newPwd);
        return Result.success();

    }

}
