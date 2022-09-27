package com.xupt.ttms.controller;
/*
 * @author:ck
 * @param:
 * @date:2022/8/1
 * @description:
 */

import com.github.pagehelper.PageInfo;
import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Result;
import com.xupt.ttms.service.PlanService;
import com.xupt.ttms.util.RedisUtil;
import com.xupt.ttms.util.ToResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@Controller
@WebServlet("/planServlet")
public class PlanServlet {
    @Autowired
    private PlanService planService;
    @Autowired
    private RedisTemplate redisTemplate;
    private String keys = "plan_";

    @RequestMapping(value = "/plan/getAllPlan", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value = "plan_",keyGenerator = "planKeyGenerator")
    public Result getAllPlan(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize, @RequestParam("id") int id,
                             @RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "status", required = false) String status) {
        PageInfo<Plan> plans = planService.getAllPlansBymID(String.valueOf(id), pageNum, pageSize, startDate, endDate, name,status);
        Result result = ToResult.getResult(plans);
        return result;
    }

    @RequestMapping(value = "/movie/getPlanById/{id}", method = RequestMethod.GET)
    @Cacheable(value = "plan_",keyGenerator = "planKeyGenerator")
    public String getPlanById(@PathVariable("id") Integer id, Model model) {
        Plan plan = planService.getPlanByID(id);
        model.addAttribute("plan", plan);
        return "manager/page/plan/edit";
    }

    @RequestMapping(value = "/plan/updatePlan", method = RequestMethod.POST)
    @ResponseBody
    public String updatePlan(@RequestBody Plan plan) {
        plan.setEndDate(planService.getEndTime(String.valueOf(plan.getmId()), plan.getStartDate()));
        plan.sethId(planService.getHallIDByName(plan.gethName()));
        int result = planService.updatePlan(plan);
        if (result > 0) {
            RedisUtil.deleteCaChe(keys,redisTemplate);
        }
        return (result > 0 ? "修改成功" : "修改失败");
    }

    @RequestMapping(value = "/plan/delete/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public String deletePlan(@PathVariable String ids) {
        int result =planService.deletePlan(ids);
        if (result > 0) {
            RedisUtil.deleteCaChe(keys,redisTemplate);
        }
        return result <= 0 ? "删除失败" : "删除成功";
    }


    @RequestMapping(value = "/plan/addPlan", method = RequestMethod.POST)
    @ResponseBody
    public String addPlan(@RequestBody Plan plan) {
        //在已有的时间内
        if (planService.belongCalendar(plan.getStartDate(), String.valueOf(plan.getmId()), plan.gethName())) {
            return "抱歉，设置的时间已有演出计划,请输入正确的数据";
        }
        if (planService.getHallIDByName(plan.gethName()) == null)
            return "抱歉，无该演出厅,请输入正确的数据";
        if (!planService.getPlanByName(plan.getpName()).isEmpty())
            return "抱歉，该演出计划已存在,请输入正确的数据";
        plan.setEndDate(planService.getEndTime(String.valueOf(plan.getmId()), plan.getStartDate()));
        plan.sethId(planService.getHallIDByName(plan.gethName()));
        System.out.println(plan);
        int result = planService.updatePlan(plan);
        if (result > 0) {
            RedisUtil.deleteCaChe(keys,redisTemplate);
        }
        return (result > 0 ? "添加成功" : "添加失败");
    }

    @GetMapping("/plan/getPlanByMIdAndTime/{MId}")
    @ResponseBody
    @Cacheable(value = "plan_",keyGenerator = "planKeyGenerator")
    public Result getPlanByMIdAndTime(@PathVariable("MId") String MId,@RequestParam(value = "Time",required = false) Integer Time){
        List<Plan> plans = planService.getPlanByMIdAndTime(MId,Time);
        return ToResult.getResult(plans);
    }
    @PostMapping("/plan/getPlanByPId/{PId}")
    @ResponseBody
    @Cacheable(value = "plan_",keyGenerator = "planKeyGenerator")
    public Result getPlanByPId(@PathVariable("PId") String PId){
        Plan plan = planService.getPlanByPId(PId);
        return ToResult.getResult(plan);
    }
}
