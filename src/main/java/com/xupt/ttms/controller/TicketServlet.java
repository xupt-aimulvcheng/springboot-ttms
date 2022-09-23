package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Result;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.pojo.Ticket;
import com.xupt.ttms.service.TicketService;
import com.xupt.ttms.util.ToResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketServlet {
    @Autowired
    private TicketService ticketService;
    @PostMapping("/ticket/insertTicket")
    public Result insertTicket(@RequestBody List<Plan> plans){
        int result = ticketService.insertTicket(plans);
        return ToResult.getResult(result>0?"上线成功":"上线失败");
    }
    @PostMapping("/ticket/deleteTicket")
    public Result deleteTicket(@RequestBody List<Plan> plans){
        int result = ticketService.deleteTicket(plans);
        return ToResult.getResult(result>0?"下线成功":"下线失败");
    }
    @PostMapping("/ticket/getTicketsByPId/{PId}")
    public Result getTicketsByPId(@PathVariable("PId") String PId){
        List<Ticket> tickets = ticketService.getTicketsByPId(PId);
        return ToResult.getResult(tickets);
    }
    @PostMapping("/LockTicket/{pId}")
    public Result LockTicket( @PathVariable("pId") String pId, @RequestBody List<Seat> seat){
        return ToResult.getResult(ticketService.LockTicket(pId,seat)>0?"锁定成功":"锁定失败");
    }

    @PostMapping("/UnLockTicket/{pId}")
    public Result UnLockTicket(@PathVariable("pId") String pId, @RequestBody List<Seat> seat) {
        return ToResult.getResult(ticketService.UnLockTicket(pId, seat) > 0 ? "解除锁定成功" : "抱歉服务器出现问题请刷新页面重试");
    }
}
