package cn.shalee.service.impl;

import cn.shalee.mapper.UserMapper;
import cn.shalee.pojo.User;
import cn.shalee.service.UserService;
import cn.shalee.utils.Md5Utils;
import cn.shalee.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 11:23
 * @注释
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatat(avatarUrl,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(Md5Utils.MD5Upper(newPwd),id);
    }

    @Override
    public void register(String username, String password) {
        //加密密码(md5)
        String md5Upper = Md5Utils.MD5Upper(password);
        //添加
        userMapper.add(username,md5Upper);
    }

}
