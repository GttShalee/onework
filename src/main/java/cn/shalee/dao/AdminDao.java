package cn.shalee.dao;

import cn.shalee.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/8 14:55
 * @注释
 */
@Repository
public interface AdminDao extends Mapper<Admin> {
    List<Admin> getAdmin();
//    List<Admin> findBySearch(@Param("params") Params params);

}
