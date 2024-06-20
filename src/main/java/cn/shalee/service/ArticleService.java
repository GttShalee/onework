package cn.shalee.service;

import cn.shalee.pojo.Article;
import cn.shalee.pojo.PageBean;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 17:17
 * @注释
 */
@Service
public interface ArticleService {

    //新增文章
    void add(Article article);

    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer homeworkId, String state, Integer score, Integer rate);

    //删除文章
    void delete(Integer id);

    //作业评分
    void score(Integer score, Integer id);
}
