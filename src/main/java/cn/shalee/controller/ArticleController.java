package cn.shalee.controller;

import cn.shalee.pojo.Article;
import cn.shalee.pojo.PageBean;
import cn.shalee.pojo.Result;
import cn.shalee.service.ArticleService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 17:16
 * @注释
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @PostMapping()
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            Integer score,
            Integer rate,
            @RequestParam(required = false) Integer homeworkId,
            @RequestParam(required = false) String state
            ) {
        PageBean<Article> pb = articleService.list(pageNum, pageSize, homeworkId, state, score, rate);
        return Result.success(pb);
    }

    @DeleteMapping
    public Result delete(Integer id) throws IOException {
        articleService.delete(id);
        return Result.success("删除成功");

    }

    @PutMapping
    public Result homeworkScore(Integer score, Integer id) {
        articleService.score(score,id);
        return Result.success("评分成功");
    }

}
