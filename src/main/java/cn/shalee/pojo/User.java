package cn.shalee.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.alibaba.druid.pool.ha.selector.StickyDataSourceHolder;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/8 14:17
 * @注释
 */
@Table(name = "user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull
    private Integer id;
    private String username;
    @JsonIgnore    //不传递密码给json
    private String password;

    @NotEmpty
    @Pattern(regexp = "^\\S{2,10}$")
    private String nickname;

    @NotEmpty
    @Email
    private String email;
    private String userPic;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
