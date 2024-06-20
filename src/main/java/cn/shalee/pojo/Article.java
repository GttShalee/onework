package cn.shalee.pojo;

import cn.shalee.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 17:09
 * @注释
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,100}$")
    private String title;
    @NotEmpty
    private String content;
    private String coverImg;
    @State
    private String state;
    @NotNull
    private Integer homeworkId;
    private Integer createUser;
    private Integer rate;
    private Integer score;
    private LocalDateTime createTime;
    private LocalDateTime UpdateTime;

}
