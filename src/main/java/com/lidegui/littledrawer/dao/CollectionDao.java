package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.Collection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 17:26 2019/4/15
 */
public interface CollectionDao {
    public int insert(Collection collection);
    public int deleteById(int collectionId);
    public int updateCollection(Collection like);
    public Collection findById(int collectionId);
    public List<Collection> findByUserId(int userId);
    public Collection findUserCollectionStatus(@Param("topicType")int topicType,
                                   @Param("topicId") int topicId,
                                   @Param("userId") int userId);
    public int findVideoCollectionCountByTopicId(int topicId);
    public int findPictureCollectionCountByTopicId(int topicId);
    public List<Collection> findAll();
}
