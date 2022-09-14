package com.xupt.ttms.service;

import com.github.pagehelper.PageInfo;
import com.xupt.ttms.pojo.Hall;

public interface HallService {
    public int insert(Hall hall);

    public PageInfo<Hall> getHallByName(String name, int pageNum, int PageSize);

    public Hall getHallById(int id);

    public int updateHall(Hall hall);

    public int deleteHall(String ids);

    PageInfo<Hall> getAllHall(int parseInt, int parseInt1);

}
