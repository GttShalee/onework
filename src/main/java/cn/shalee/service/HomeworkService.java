package cn.shalee.service;

import cn.shalee.pojo.Homework;

import java.util.List;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 15:34
 * @注释
 */
public interface HomeworkService {

    //新增分类
    void add(Homework homework);

    Homework findByHomeworkName(Homework homework);

    //列表查询
    List<Homework> list();

    //根据ID查询信息
    Homework findById(Integer id);

    //修改作业内容和分类
    void update(Homework homework);

    void deleteById(Integer id);
}
