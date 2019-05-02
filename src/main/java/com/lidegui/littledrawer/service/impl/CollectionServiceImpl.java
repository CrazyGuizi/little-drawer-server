package com.lidegui.littledrawer.service.impl;

import com.lidegui.littledrawer.bean.Collection;
import com.lidegui.littledrawer.dao.CollectionDao;
import com.lidegui.littledrawer.service.CollectionService;
import com.lidegui.littledrawer.util.TopicEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 17:40 2019/4/15
 */

@Service("CollectionService")
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionDao mCollectionDao;


    @Override
    public Collection addCollection(Collection collection) {
        if (mCollectionDao.insert(collection) > 0) {
            return mCollectionDao.findById(collection.getId());
        }

        return null;
    }

    @Override
    public int deleteCollection(int collectionId) {
        return mCollectionDao.deleteById(collectionId);
    }

    @Override
    public int deleteCollection(int topicType, int topicId, int userId) {
        return mCollectionDao.deleteByTopic(topicType, topicId, userId);
    }

    @Override
    public Collection updateCollection(Collection collection) {
        if (mCollectionDao.updateCollection(collection) > 0) {
            return mCollectionDao.findById(collection.getId());
        }

        return null;
    }

    @Override
    public Collection getCollectionById(int collectionId) {
        return mCollectionDao.findById(collectionId);
    }

    @Override
    public List<Collection> getCollectionsByUserId(int userId) {
        return mCollectionDao.findByUserId(userId);
    }

    @Override
    public Collection findUserCollectionStatus(int topicType, int topicId, int userId) {
        return mCollectionDao.findUserCollectionStatus(topicType, topicId, userId);
    }

    @Override
    public int findCollectionCountByTopicId(int topicType, int topicId) {
        int count = 0;
        if (topicType == TopicEnum.NEWS.topicType) {

        } else if (topicType == TopicEnum.VIDEO.topicType) {
            count = mCollectionDao.findVideoCollectionCountByTopicId(topicId);
        } else if (topicType == TopicEnum.PICTURE.topicType) {
            count = mCollectionDao.findPictureCollectionCountByTopicId(topicId);
        }

        return count;
    }

    @Override
    public List<Collection> getAllLikes() {
        return mCollectionDao.findAll();
    }
}
