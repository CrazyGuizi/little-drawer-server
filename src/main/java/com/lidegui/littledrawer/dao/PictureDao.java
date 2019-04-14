package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 10:42 2019/4/14
 */
public interface PictureDao {

    public List<Picture> findPictureByTopic(@Param("topic_type") int topicType, @Param("topic_id") int topicId);
    public List<String> findPictureUrlsByTopicId(int topicId);
    public List<String> findVideoUrlsByTopicId(int topicId);
}
