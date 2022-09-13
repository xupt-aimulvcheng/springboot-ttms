package com.xupt.ttms.service;

import com.xupt.ttms.pojo.Video;

import java.util.List;

public interface VideoService {
    Video getVideoByPrimaryKey(Integer id);

    int insertVideo(Video video);


    int updateVideo(Video video);

    int updateVideoDesc(Integer id, String desc);

    List<Video> getVideoByMId(Integer mId, Integer id);

    List<Video> getVideoById(Integer id);

    List<Video> moveVideos(List<Video> list, Integer id);

}
