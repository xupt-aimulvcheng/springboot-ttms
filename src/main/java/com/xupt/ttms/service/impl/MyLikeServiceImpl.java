package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.MyLikeMapper;
import com.xupt.ttms.pojo.Movie;
import com.xupt.ttms.pojo.MyLike;
import com.xupt.ttms.service.MyLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyLikeServiceImpl implements MyLikeService {
    @Autowired
    private MyLikeMapper myLikeMapper;
    @Override
    public List<Movie> GetAllLikeByUserName(String username) {
        return myLikeMapper.GetAllLikeByUserName(username);
    }

    @Override
    public MyLike getLikeByUserNameAndMId(Integer mId, String username) {
        return myLikeMapper.getLikeByUserNameAndMId(mId, username);
    }

    @Override
    public int insertByUsername(Integer mID, String username) {
        return myLikeMapper.insertByUsername(mID, username);
    }

    @Override
    public int deleteByUsername(Integer mID, String username) {
        return myLikeMapper.deleteByUsername(mID, username);
    }

}
