package cn.shalee.service;

import cn.shalee.pojo.User;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 11:23
 * @注释
 */
public interface UserService {

    //注册用户
    void register(String username, String password);
    //根据用户名查询用户
    User findByUserName(String username);
    void update(User user);

    //更新头像
    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}
