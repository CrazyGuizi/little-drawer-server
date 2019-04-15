package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 10:42 2019/4/14
 */
public interface PictureDao {

    public int insert(Picture picture);
    public int deleteById(int pictureId);
    public int updatePicture(Picture picture);
    public Picture findById(int pictureId);
    public List<Picture> findByUserId(int userId);
    public List<Picture> findPicturesByTopic(@Param("topic_type") int topicType, @Param("topic_id") int topicId);
    public List<String> findNewsPictureUrlsByTopicId(int topicId);
    public String findVideoPosterUrlByTopicId(int topicId);
    public List<Picture> findFunnyPictures();
    public List<Picture> findAll();
}
