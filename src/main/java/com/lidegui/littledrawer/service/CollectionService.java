package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.Collection;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 17:37 2019/4/15
 */
public interface CollectionService {


    public Collection addCollection(Collection collection);

    public int deleteCollection(int collectionId);

    public Collection updateCollection(Collection collection);

    public Collection getCollectionById(int collectionId);

    public List<Collection> getCollectionsByUserId(int userId);

    public Collection findUserCollectionStatus(int topicType, int topicId, int userId);

    public int findCollectionCountByTopicId(int topicType, int topicId);

    public List<Collection> getAllLikes();
}
