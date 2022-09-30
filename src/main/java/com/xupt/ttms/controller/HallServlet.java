package com.xupt.ttms.controller;/*
 * @author:ck
 * @param:
 * @date:2022/7/8
 * @description:
 */

import com.github.pagehelper.PageInfo;
import com.xupt.ttms.pojo.Code;
import com.xupt.ttms.pojo.Hall;
import com.xupt.ttms.pojo.Result;
import com.xupt.ttms.service.HallService;
import com.xupt.ttms.util.RedisUtil;
import com.xupt.ttms.util.ToResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class HallServlet {
    @Autowired
    private HallService hallService;
    @Autowired
    private Code code;


    @RequestMapping(value = "/hall/updateHall", method = RequestMethod.POST)
    @ResponseBody
    public String updateHall(@RequestBody Hall hall) {
        int result = hallService.updateHall(hall);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping(value = "/hall/getHallById/{id}", method = RequestMethod.GET)
    public String getHallById(@PathVariable("id") Integer id, Model model) {
        Hall hall = hallService.getHallById(id);
        model.addAttribute("hall", hall);
        return "manager/page/hall/edit";
    }

    @RequestMapping(value = "/hall/getHallByName", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value = "hall_",keyGenerator = "hallKeyGenerator")
    public Result getHallByName(@RequestParam(value = "name", required = false) String name, @RequestParam("page") int pageNum, @RequestParam("limit") int pageSize) {
        PageInfo<Hall> halls;
        if (name != null) {
            halls = hallService.getHallByName(name, pageNum, pageSize);
        } else {
            halls = hallService.getAllHall(pageNum, pageSize);
        }
        Result result = ToResult.getResult(halls);
        return result;
    }

    @RequestMapping(value = "/hall/addHall", method = RequestMethod.POST)
    @ResponseBody
    public String addHall(@RequestBody Hall hall) throws IOException {
        int insert = hallService.insert(hall);
        return (insert >= 1 ? "添加成功" : "添加失败");
    }

    @RequestMapping(value = "/hall/deleteHall/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public Code deleteHall(@PathVariable("ids") String ids) {
        int delete = hallService.deleteHall(ids);
        if (delete >= 1) {
            code.setInfo("删除成功");
        }
        else if (delete == -1){
            code.setInfo("含有演出计划在选中的演出厅演出，无法删除");
        }
        else {
            code.setInfo("删除失败");
        }
        return code;
    }
}