package com.xupt.ttms.mapper;

import com.xupt.ttms.pojo.Hall;
import com.xupt.ttms.pojo.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface PlanMapper {
    int deletePlanByIds(@Param("ids") String ids);

    int updatePlan(@Param("plan") Plan plan, @Param("ids") int id);

    int insert(@Param("plan") Plan plan);

    List<Plan> getAllPlansBymID(@Param("mId") String mId, @Param("startDate") String startDate, @Param("endDate") String endDate,@Param("pName") String pName,@Param("status") String status);

    int getMovieTimeBymID(@Param("mId") String mId);

    Hall getHallIDByName(@Param("name") String name);

    int getMovieIDByName(@Param("name") String name);


    List<Plan> getPlanByName(@Param("name") String pName);

    int deletePlan(@Param("ids") String ids);

    List<Plan> getPlanByhName(@Param("hName") String hName);

    Plan getPlanByID(@Param("id") Integer id);

    int onlinePlan(@Param("plans") List<Plan> plans);

    int offline(@Param("plans") List<Plan> plans);

    int getAllByHId(@Param("hId") String hId);

    List<Plan> getPlanByMIdAndTime(@Param("mId") String mId,@Param("time") String Time,@Param("nextTime") String nextTime);
}