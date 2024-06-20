package cn.shalee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/8 19:55
 * @注释
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work {
    private Integer id;
    private String workName;
    private int subjectId;
    private String addtion;
    private LocalDateTime inintTime;
    private LocalDateTime endTime;
}
