package cn.shalee.mapper;

import cn.shalee.pojo.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 17:18
 * @注释
 */
@Mapper
public interface ArticleMapper {

    //新增文章
    @Insert("INSERT INTO oneWork.article(title,content,cover_img,state,homework_id,create_user,create_time,update_time) " +
            " VALUES(#{title},#{content},#{coverImg},#{state},#{homeworkId},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);

    //分页查询实用xml映射
    List<Article> list(Integer userId, Integer homeworkId, String state);

    @Delete("delete from oneWork.article where id=#{id}")
    void delete(Integer id);


    @Update("update oneWork.article set score=#{score} where id=#{id}")
    void score(Integer score, Integer id);
}
