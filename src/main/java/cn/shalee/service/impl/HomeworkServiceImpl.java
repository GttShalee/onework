package cn.shalee.service.impl;

import cn.shalee.mapper.HomeworkMapper;
import cn.shalee.pojo.Homework;
import cn.shalee.service.HomeworkService;
import cn.shalee.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 15:34
 * @注释
 */

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkMapper homeworkMapper;
    @Override
    public void add(Homework homework) {

        //补充属性值
        homework.setCreateTime(LocalDateTime.now());
        homework.setUpdateTime(LocalDateTime.now());

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        homework.setCreateUser(id);

        homeworkMapper.add(homework);
    }

    @Override
    public Homework findByHomeworkName(Homework homework) {
        return homeworkMapper.findByHomeworkName(homework);
    }

    @Override
    public List<Homework> list() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        return homeworkMapper.list(userId);
    }

    @Override
    public Homework findById(Integer id) {
        return homeworkMapper.findById(id);
    }

    @Override
    public void update(Homework homework) {
        homework.setUpdateTime(LocalDateTime.now());
        homeworkMapper.update(homework);
    }

    @Override
    public void deleteById(Integer id) {
        homeworkMapper.deleteById(id);
    }
}
