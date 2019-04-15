package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.Like;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 8:55 2019/4/15
 */
public interface LikeDao {

    public int insert(Like like);
    public int deleteById(int likeId);
    public int updateLike(Like like);
    public int updateLikeStatus(@Param("likeId") int likeId, @Param("status") int status);
    public Like findById(int likeId);
    public List<Like> findByUserId(int userId);
    public Like findUserLikeStatus(@Param("topicType")int topicType,
                                   @Param("topicId") int topicId,
                                   @Param("userId") int userId);
    public int findVideoLikeCountByTopicId(int topicId);
    public int findPictureLikeCountByTopicId(int topicId);
    public List<Like> findAll();

}
