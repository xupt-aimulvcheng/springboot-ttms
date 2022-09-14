package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.VideoMapper;
import com.xupt.ttms.pojo.Video;
import com.xupt.ttms.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    /**
     * 根据id返回预告片
     *
     * @param id
     * @return
     */
    @Override
    public Video getVideoByPrimaryKey(Integer id) {
        return this.videoMapper.getVideoByPrimaryKey(id);
    }

    @Override
    public int insertVideo(Video video) {
        return this.videoMapper.insertVideo(video);
    }

    @Override
    public int updateVideo(Video video) {
        return this.videoMapper.updateVideo(video);
    }

    @Override
    public int updateVideoDesc(Integer id, String desc) {
        return this.videoMapper.updateVideoDesc(id, desc);
    }

    @Override
    public List<Video> getVideoByMId(Integer mId, Integer id) {
        return this.videoMapper.getVideoByMId(mId, id);
    }

    @Override
    public List<Video> getVideoById(Integer id) {
        return this.videoMapper.getVideoById(id);
    }

    /**
     * 根据预告片id将该预告片放在集合最前面
     *
     * @param list
     * @param id
     * @return
     */
    @Override
    public List<Video> moveVideos(List<Video> list, Integer id) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        Collections.swap(list, 0, index);
        return list;
    }
}
