package com.xupt.ttms.mapper;

import com.xupt.ttms.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface VideoMapper {
    Video getVideoByPrimaryKey(@Param("id") Integer id);

    int updateVideo(@Param("video") Video video);

    int insertVideo(@Param("video") Video video);

    int updateVideoDesc(@Param("id") Integer id, @Param("desc") String desc);

    List<Video> getVideoByMId(@Param("mId") Integer mId, @Param("id") Integer id);

    List<Video> getVideoById(Integer id);
}
