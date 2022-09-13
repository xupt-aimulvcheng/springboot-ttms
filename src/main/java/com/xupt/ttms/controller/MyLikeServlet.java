package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.Movie;
import com.xupt.ttms.pojo.MyLike;
import com.xupt.ttms.pojo.Result;
import com.xupt.ttms.service.MyLikeService;
import com.xupt.ttms.util.ToResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyLikeServlet {
    @Autowired
    private MyLikeService myLikeService;

    @PostMapping("/MyLike/GetAllLikeByUserName")
    @ResponseBody
    public Result GetAllLikeByUserName(@RequestBody String username) {
        List<Movie> list = myLikeService.GetAllLikeByUserName(username);
        return ToResult.getResult(list);
    }

    @PostMapping("/MyLike/getLikeByUserNameAndMId")
    @ResponseBody
    public Result getLikeByUserNameAndMId(@RequestParam("mId") Integer mId, @RequestParam("username") String username) {
        MyLike myLike = myLikeService.getLikeByUserNameAndMId(mId, username);
        return ToResult.getResult(myLike == null ? "未收藏" : "已收藏");
    }

    @PostMapping("/MyLike/insertByusername/{mId}")
    @ResponseBody
    public Result insertByUsername(@PathVariable("mId") Integer mID,@RequestParam("username") String username){
        return ToResult.getResult(myLikeService.insertByUsername(mID,username)>=1?"收藏成功":"收藏失败");
    }

    @PostMapping("/MyLike/deleteByusername/{mId}")
    @ResponseBody
    public Result deleteByUsername(@PathVariable("mId") Integer mID, @RequestParam("username") String username) {
        return ToResult.getResult(myLikeService.deleteByUsername(mID, username) >= 1 ? "取消收藏成功" : "取消收藏失败");
    }
}