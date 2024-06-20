package cn.shalee.mapper;

import cn.shalee.pojo.Homework;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 15:35
 * @注释
 */
@Mapper
public interface HomeworkMapper {

    @Insert("insert into oneWork.homework(homework_name, homework_alias, create_user, create_time, update_time)" +
            "value (#{homeworkName},#{homeworkAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Homework homework);

    @Select("select * from oneWork.homework where homework_name = #{homeworkName}")
    Homework findByHomeworkName(Homework homework);

    //查询所有的作业
    @Select("select * from oneWork.homework where create_user = 1;")
    List<Homework> list(Integer userId);

    @Select("select * from oneWork.homework where id = #{id}")
    Homework findById(Integer id);

    //更新
    @Update("update oneWork.homework set homework_name=#{homeworkName}, homework_alias=#{homeworkAlias}, update_time=#{updateTime} where id=#{id}")
    void update(Homework homework);

    @Delete("delete from oneWork.homework where id=#{id}")
    void deleteById(Integer id);
}
