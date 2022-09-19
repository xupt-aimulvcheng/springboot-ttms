package com.xupt.ttms.service;

import com.github.pagehelper.PageInfo;
import com.xupt.ttms.pojo.Plan;

import java.math.BigDecimal;
import java.util.List;

public interface PlanService {
    PageInfo<Plan> getAllPlansBymID(String mId, int parseInt, int parseInt1, String startDate,String endDate, String pName,String status);
    public String getEndTime(String mId, String startTime);
    public int insertPlan(Plan plan);
    public int updatePlan(Plan plan);
    public int deletePlanByIds(String ids);
    public Integer getHallIDByName(String name);
    public int getMovieIDByName(String name);
    List<Plan> getPlanByName(String pName);
    List<Plan> getPlanByhName(String hName);
    boolean belongCalendar(String startDate, String mId,String hName);

    int deletePlan(String ids);

    List<String> getAllTime(String startDate, String endDate);

    Plan getPlanByID(Integer id);

    List<Plan> getPlanByMIdAndTime(String mId, Integer time);
}
