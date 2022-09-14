package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Result;
import com.xupt.ttms.util.ToResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TicketServlet {
    @PostMapping("/ticket/insertTicket")
    public Result insertTicket(@RequestBody List<Plan> plans){
        log.info(plans.toString());
        return ToResult.getResult("111");
    }
}
