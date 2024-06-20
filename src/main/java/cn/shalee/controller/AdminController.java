package cn.shalee.controller;

import cn.shalee.pojo.Result;
import cn.shalee.pojo.Admin;
import cn.shalee.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/8 14:06
 * @注释
 */

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @GetMapping("/getAdmin")
    public Result getAdmin() {
        List<Admin> list = adminService.getAdmin();
        return Result.success(list);
    }
//    @GetMapping("/search")
//    public Result findBySearch(Params params){
//        List<Admin> list = adminService.findBySearch(params);
//        return Result.success(list);
//    }
}
