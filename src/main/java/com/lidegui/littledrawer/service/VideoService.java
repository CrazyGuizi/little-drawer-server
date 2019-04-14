package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.Video;

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

    public List<Video> getVideosByType(String type);

    public List<Video> getVideosByUserId(int userId);
}
