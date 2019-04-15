package com.lidegui.littledrawer.service.impl;

import com.lidegui.littledrawer.bean.Like;
import com.lidegui.littledrawer.dao.LikeDao;
import com.lidegui.littledrawer.service.LikeService;
import com.lidegui.littledrawer.util.TopicEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 9:39 2019/4/15
 */

@Service("LikeService")
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDao mLikeDao;

    @Override
    public Like addLike(Like like) {
        if (mLikeDao.insert(like) > 0) {
            return mLikeDao.findById(like.getId());
        }
        return null;
    }

    @Override
    public int deleteLike(int likeId) {
        return mLikeDao.deleteById(likeId);
    }

    @Override
    public Like updateLike(Like like) {
        if (mLikeDao.updateLike(like) > 0) {
            return mLikeDao.findById(like.getId());
        }
        return null;
    }

    @Override
    public Like changeLikeStatus(Like like) {
        if (mLikeDao.updateLikeStatus(like.getId(), like.getStatus()) > 0) {
            return mLikeDao.findById(like.getId());
        }

        return null;
    }

    @Override
    public Like getLikeById(int likeId) {
        return mLikeDao.findById(likeId);
    }

    @Override
    public List<Like> getLikesByUserId(int userId) {
        return mLikeDao.findByUserId(userId);
    }

    @Override
    public Like findUserLikeStatus(int topicType, int topicId, int userId) {
        return mLikeDao.findUserLikeStatus(topicType, topicId, userId);
    }

    @Override
    public int findLikeCountByTopicId(int topicType, int topicId) {

        int count = 0;

        if (topicType == TopicEnum.NEWS.topicType) {

        } else if (topicType == TopicEnum.VIDEO.topicType) {
            count = mLikeDao.findVideoLikeCountByTopicId(topicId);
        } else if (topicType == TopicEnum.PICTURE.topicType) {
            count = mLikeDao.findPictureLikeCountByTopicId(topicId);
        }

        return count;
    }

    @Override
    public List<Like> getAllLikes() {
        return mLikeDao.findAll();
    }
}
