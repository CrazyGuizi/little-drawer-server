package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.Video;
import com.lidegui.littledrawer.util.VideoType;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 21:16 2019/4/13
 */
public interface VideoService {

    public Video addVideo(Video video);

    public int deleteVideo(int videoId);

    public Video updateVideo(Video video);

    public Video getVideoById(int videoId);

    public List<Video> getAllVideos();

    public List<Video> getVideosByTypeIndex(int typeIndex);

    public List<Video> getVideosByTypeName(String typeName);

    public List<Video> getVideosByUserId(int userId);
}
