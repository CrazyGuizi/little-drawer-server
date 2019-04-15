package com.lidegui.littledrawer.service.impl;

import com.lidegui.littledrawer.bean.Video;
import com.lidegui.littledrawer.dao.VideoDao;
import com.lidegui.littledrawer.service.VideoService;
import com.lidegui.littledrawer.util.VideoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 21:19 2019/4/13
 */
@Service("VideoService")
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao mVideoDao;

    @Override
    public Video addVideo(Video video) {
        if (mVideoDao.insert(video) > 0) {
            return mVideoDao.findById(video.getId());
        }
        return null;
    }

    @Override
    public int deleteVideo(int videoId) {
        return mVideoDao.deleteById(videoId);
    }

    @Override
    public Video updateVideo(Video video) {
        if (mVideoDao.updateVideo(video) > 0) {
            mVideoDao.findById(video.getId());
        }

        return null;
    }

    @Override
    public Video getVideoById(int videoId) {
        return mVideoDao.findById(videoId);
    }

    @Override
    public List<Video> getAllVideos() {
        return mVideoDao.findAll();
    }

    @Override
    public List<Video> getVideosByTypeIndex(int typeIndex) {
        return mVideoDao.findByTypeIndex(typeIndex);
    }

    @Override
    public List<Video> getVideosByTypeName(String typeName) {
        return mVideoDao.findByTypeName(typeName);
    }

    @Override
    public List<Video> getVideosByUserId(int userId) {
        return mVideoDao.findByUserId(userId);
    }
}
