package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.Like;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 9:39 2019/4/15
 */
public interface LikeService {

    public Like addLike(Like like);

    public int deleteLike(int likeId);

    public Like updateLike(Like like);

    public Like changeLikeStatus(Like like);

    public Like getLikeById(int likeId);

    public List<Like> getLikesByUserId(int userId);

    public Like findUserLikeStatus(int topicType, int topicId, int userId);

    public int findLikeCountByTopicId(int topicType, int topicId);

    public List<Like> getAllLikes();

}
