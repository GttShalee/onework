package cn.shalee.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 15:26
 * @注释
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Homework {

    //采用分组实现add和update两个封装类传参不冲突
    //完善校验项

    @NotNull(groups = Update.class)
    private Integer id;

    @NotEmpty(groups = {Add.class,Update.class})
    private String homeworkName;
    @NotEmpty(groups = {Add.class,Update.class})
    private String homeworkAlias;
    private Integer createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


    //如果某个没有指定分组，默认为Default分组
    //分组可以继承，当以后参数拥堵时，可以常用继承的方法来简化代码
    public interface Add {

    }

    public interface Update{

    }
}
