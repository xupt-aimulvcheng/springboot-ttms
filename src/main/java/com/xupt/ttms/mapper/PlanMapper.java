package com.xupt.ttms.mapper;

import com.xupt.ttms.pojo.Hall;
import com.xupt.ttms.pojo.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PlanMapper {
    int deletePlanByIds(@Param("ids") String ids);

    int updatePlan(Plan plan, @Param("ids") int id);

    int insert(@Param("plan") Plan plan);

    List<Plan> getAllPlansBymID(@Param("mId") String mId, @Param("startDate") String startDate, @Param("endDate") String endDate,@Param("pName") String pName);

    int getMovieTimeBymID(@Param("mId") String mId);

    Hall getHallIDByName(@Param("name") String name);

    int getMovieIDByName(@Param("name") String name);

    Double getPriceBymId(@Param("mId") Integer mId);

    List<Plan> getPlanByName(@Param("name") String pName);

    int deletePlan(@Param("ids") String ids);

    List<Plan> getPlanByhName(@Param("hName") String hName);

    Plan getPlanByID(@Param("id") Integer id);
}