package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.pojo.TicketParam;
import com.xupt.ttms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 完成页面跳转
 */
@Controller
public class PageJump {
    @Autowired
    private PlanService planService;
    @GetMapping("/")
    public String toLogin(){
        return "index";
    }
    @GetMapping("/user/index")
    public String toUserIndex(){
        return "user/index";
    }
    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }
    @GetMapping("/forget-pw")
    public String toForgetPw(){
        return "forget-pw";
    }
    @GetMapping("/manage/index")
    public String toManagerIndex(){
        return "manager/index";
    }
    @GetMapping("/hall/index")
    public String t(){
        return "manager/page/hall/index";
    }
    @GetMapping("/hall/add")
    public String d(){
        return "manager/page/hall/add";
    }
    @GetMapping("/movie/index")
    public String m(){
        return "manager/page/movie/index";
    }
    @GetMapping("/movie/add")
    public String l(){
        return "manager/page/movie/add";
    }
    @GetMapping("/plan/add")
    public String a(){
        return "manager/page/plan/add";
    }
    @GetMapping("/plan/index")
    public String e(){
        return "manager/page/plan/index";
    }
    @GetMapping("/plan/plan_index")
    public String o(){
        return "manager/page/plan/plan_index";
    }
    @GetMapping("/sales/index")
    public String i(){
        return "manager/page/sales/index";
    }
    @GetMapping("/seat/index")
    public String g(){
        return "manager/page/seat/index";
    }
    @GetMapping("/ToMoviePlan/{mid}")
    public String p(Model model, @PathVariable("mid") Integer mid){
        model.addAttribute("MId",mid);
        return "user/movie_plan";
    }
    @GetMapping("/butTicket/{pId}")
    public String l(Model model,@PathVariable("pId") Integer pId){
        model.addAttribute("pId",pId);
        return "user/form-step";
    }
}
