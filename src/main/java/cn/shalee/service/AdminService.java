package cn.shalee.service;

import cn.shalee.dao.AdminDao;
import cn.shalee.pojo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/8 14:54
 * @注释
 */
@Service
public class AdminService {
    @Resource
    private AdminDao adminDao;

    public List<Admin> getAdmin() {
        return adminDao.selectAll();
    }

//    public List<Admin> findBySearch(Params params) {
//        return adminDao.findBySearch(params);
//    }
}
