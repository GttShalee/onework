package cn.shalee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 20:08
 * @注释
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private Long total;   //总条数
    private List<T> items;  //当前页数据集合
}
