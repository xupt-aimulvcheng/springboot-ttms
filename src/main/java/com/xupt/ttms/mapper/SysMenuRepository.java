package com.xupt.ttms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xupt.ttms.pojo.SysMenu;
import com.xupt.ttms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
@Mapper
public interface SysMenuRepository extends BaseMapper<User> {
    @Select("select * from  ttms.system_menu where STATUS = 1  ORDER BY  sort")
    List<SysMenu> findAllByStatusOrderBySort(boolean b);
}
