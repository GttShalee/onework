package cn.shalee.mapper;

import cn.shalee.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 11:24
 * @注释
 */

@Mapper
public interface UserMapper {

    @Select("select * from oneWork.user where username = #{username}")
    User findByUserName(String username);

    @Insert("insert into oneWork.user(username,password,create_time,update_time)" +
            " VALUES(#{username}, #{password},now(),now())")
    void add(String username, String password);

    @Update("update oneWork.user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id = #{id}")
    void update(User user);

    @Update("update oneWork.user set user_pic=#{avatarUrl}, update_time=now() where id=#{id}")
    void updateAvatat(String avatarUrl, Integer id);

    @Update("update oneWork.user set password=#{s},update_time=now() where id=#{id}")
    void updatePwd(String s, Integer id);
}
