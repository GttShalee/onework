package cn.shalee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/8 15:59
 * @注释
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private String name;
    private String password;
    private String work;
}
