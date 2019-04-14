package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.Video;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 21:13 2019/4/13
 */
public interface VideoDao {

    public int insert(Video video);

    public int deleteById(int videoId);

    public int updateVideo(Video video);

    public Video findById(int videoId);

    public List<Video> findAll();

    public List<Video> findByType(String type);

    public List<Video> findByUserId(int userId);
}
