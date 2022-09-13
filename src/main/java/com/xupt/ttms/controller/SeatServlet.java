package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SeatServlet {
    @Autowired
    private SeatService seatService;

    @RequestMapping(value = "/seat/getSeats", method = RequestMethod.POST)
    @ResponseBody
    public List<Seat> getSeats(@RequestParam("id") Integer id) {
        return seatService.getSeatList(id);
    }

    @GetMapping("/seat/ToSeat/{id}")
    public String ToSeat(@PathVariable("id") Integer id, Model model){
        model.addAttribute("id",id);
        return "manager/page/seat/seat_index";
    }

    @RequestMapping(value = "/seat/updateSeats", method = RequestMethod.POST)
    @ResponseBody
    public String updateSeats(@RequestBody List<Seat> seats) {
        try {
            int i = seatService.updateSeats(seats);
            return "修改成功";
        } catch(Exception e) {
            return "修改失败";
        }
    }
}
