package com.xupt.ttms.service.impl;/*
 * @author:ck
 * @param:
 * @date:2022/8/1
 * @description:
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.ttms.mapper.PlanMapper;
import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.service.PlanService;
import com.xupt.ttms.util.TypeCasting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;
    /*{
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        planMapper = sqlSession.getMapper(PlanMapper.class);
    }*/

    /**
     * 根据电影时长和起始时间获取终止时长
     *
     * @param mId
     * @param startTime
     * @return
     */
    public String getEndTime(String mId, String startTime) {
        LocalDateTime localDateTime = TypeCasting.formatStringToLocalDateTime(startTime);
        int length = planMapper.getMovieTimeBymID(mId);
        LocalDateTime endTime = localDateTime.plusMinutes(length);
        return TypeCasting.formatLocalDateTimeStringSe(endTime);
    }

    /**
     * 获取某个时间段内的所有时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public List<String> getAllTime(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<String> allTime = new ArrayList();
        try {
            // 起始日期
            Date d1 = sdf.parse(startDate);
            // 结束日期
            Date d2 = sdf.parse(endDate);
            Date tmp = d1;
            Calendar dd = Calendar.getInstance();
            dd.setTime(d1);
            // 打印2018年2月25日到2018年3月5日的日期
            while (tmp.getTime() < d2.getTime()) {
                tmp = dd.getTime();
                // 天数加上1
                dd.add(Calendar.SECOND, 1);
                //将Calendar转化为Date
                Date date = dd.getTime();
                Instant instant = date.toInstant();
                ZoneId zoneId = ZoneId.systemDefault();
                //将Date转化为LocalDateTime
                LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
                String localDateTimeStr = TypeCasting.formatLocalDateTimeStringSe(localDateTime);
                allTime.add(localDateTimeStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return allTime;
        }
    }

    @Override
    public Plan getPlanByID(Integer id) {
        return planMapper.getPlanByID(id);
    }

    /*public List<String> getAllStartTimeByhNamed(String name) {
        planMapper.getPlanByName()
    }*/

    /**
     * 判断一个时间段的集合是否在规定的时间段
     *
     * @param startDate 起始时间
     * @param mId 添加或修改的电影id
     * @param hName 演出计划要放映的位置
     * @return 不在返回false，在返回true
     */
    public boolean belongCalendar(String startDate, String mId,String hName) {
        boolean flag = false;
        String endDate = getEndTime(mId,startDate);
        List<String> now = getAllTime(startDate, endDate);//获取所有起始时间到终止时间的时间戳
        List<Plan> plans = getPlanByhName(hName);//根据演出计划获取所有演出计划（主要是获取该演出厅播放的所有的演出计划时间来进行比较）
        for (int i = 0; i < now.size(); i++) {
            for (int j = 0; j < plans.size(); j++) {
                Date beginTime = TypeCasting.StringToDate(plans.get(j).getStartDate());
                Date endTime = TypeCasting.StringToDate(plans.get(j).getEndDate());
                String str = now.get(i);
                Date nowTime = TypeCasting.StringToDate(str);
                Calendar date = Calendar.getInstance();
                date.setTime(nowTime);
                Calendar begin = Calendar.getInstance();
                begin.setTime(beginTime);
                Calendar end = Calendar.getInstance();
                end.setTime(endTime);
                if (date.after(begin) && date.before(end)) { //在中间
                    flag = true;
                }
            }
        }
        return flag;
    }

    public Integer getHallIDByName(String name) {
        return planMapper.getHallIDByName(name).getId();
    }

    public int getMovieIDByName(String name) {
        return planMapper.getMovieIDByName(name);
    }


    public List<Plan> getPlanByName(String pName) {
        return planMapper.getPlanByName(pName);
    }

    @Override
    public List<Plan> getPlanByhName(String hName) {
        return planMapper.getPlanByhName(hName);
    }

    @Override
    public int deletePlan(String ids) {
        return planMapper.deletePlan(ids);
    }

    public int insertPlan(Plan plan) {
        return planMapper.insert(plan);
    }

    public int updatePlan(Plan plan) {
        return planMapper.updatePlan(plan, plan.getId());
    }

    public int deletePlanByIds(String ids) {
        return planMapper.deletePlanByIds(ids);
    }

    public PageInfo<Plan> getAllPlansBymID(String mId, int pageNum, int PageSize, String startDate, String endDate, String pName) {
        Page<Plan> Movies = PageHelper.startPage(pageNum, PageSize);
        List<Plan> plans = planMapper.getAllPlansBymID(mId, startDate, endDate, pName);
        for (int i = 0; i < plans.size(); i++) {
            Plan plan = plans.get(i);
            plan.setEndDate(getEndTime(mId, plan.getStartDate()));
            plan.setStartDate(/*TypeCasting.formatStringToString(*/plan.getStartDate());
        }
        PageInfo<Plan> planInfo = new PageInfo(plans, 5);
        return planInfo;
    }
}
