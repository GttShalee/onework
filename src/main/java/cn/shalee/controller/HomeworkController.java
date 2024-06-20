package cn.shalee.controller;

import cn.shalee.pojo.Homework;
import cn.shalee.pojo.Result;
import cn.shalee.service.HomeworkService;
import cn.shalee.utils.ThreadLocalUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 15:34
 * @注释
 */
@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @PostMapping
    public Result add(@RequestBody @Validated(Homework.Add.class) Homework homework) {

        homeworkService.add(homework);
        return Result.success();
    }

    @GetMapping
    public Result list() {
        List<Homework> list = homeworkService.list();
        return Result.success(list);
    }

    @GetMapping("/detail")
    public Result detail(Integer id) {
        Homework work = homeworkService.findById(id);
        return Result.success(work);
    }

    @PutMapping()
    public Result update(@RequestBody @Validated(Homework.Update.class) Homework homework) {

        homeworkService.update(homework);
        return Result.success("更新成功");
    }

    @DeleteMapping
    public Result deleteById(Integer id) {
        homeworkService.deleteById(id);
        return Result.success("删除成功");
    }
}
