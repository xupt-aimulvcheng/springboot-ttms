package com.xupt.ttms.service;

import com.xupt.ttms.pojo.Movie;
import com.xupt.ttms.pojo.MyLike;

import java.util.List;

public interface MyLikeService {
    List<Movie> GetAllLikeByUserName(String username);

    MyLike getLikeByUserNameAndMId(Integer mId, String username);

    int insertByUsername(Integer mID, String username);

    int deleteByUsername(Integer mID, String username);
}
