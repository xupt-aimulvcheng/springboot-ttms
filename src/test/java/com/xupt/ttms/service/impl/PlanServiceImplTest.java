package com.xupt.ttms.service.impl;

import com.xupt.ttms.TtmsApplication;
import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TtmsApplication.class)
public class PlanServiceImplTest {
@Resource
private PlanService planService;
    @Test
    public void getPlanByMIdAndTime() {
        List<Plan> plan = planService.getPlanByMIdAndTime(String.valueOf(3), 0);
        for (Plan plan1 : plan) {
            log.info(String.valueOf(plan1));
        }
    }

    @Test
    public void getEndTime() {
        System.out.println(planService.getEndTime(String.valueOf(4),"2022-09-19 16:10:00"));
    }
}