package cn.shalee.service.impl;

import cn.shalee.mapper.ArticleMapper;
import cn.shalee.pojo.Article;
import cn.shalee.pojo.PageBean;
import cn.shalee.service.ArticleService;
import cn.shalee.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 17:18
 * @注释
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        //设置id
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);

        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer homeworkId, String state, Integer score, Integer rate) {

        PageBean<Article> pb = new PageBean<>();

        //开启分页查询  PageHelper
        PageHelper.startPage(pageNum,pageSize);

        //调用mapper类
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");

        List<Article> as =  articleMapper.list(userId,homeworkId,state);

        //page中提供了方法，可以获取pageHelper分页查询后，得到的结果和数据， 否则由多态不能实用父类方法
        Page<Article> p = (Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());

        return pb;
    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }

    @Override
    public void score(Integer score, Integer id) {
        articleMapper.score(score,id);
    }

}
