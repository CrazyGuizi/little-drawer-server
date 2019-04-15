package com.lidegui.littledrawer.service.impl;

import com.lidegui.littledrawer.bean.Picture;
import com.lidegui.littledrawer.dao.CollectionDao;
import com.lidegui.littledrawer.dao.LikeDao;
import com.lidegui.littledrawer.dao.PictureDao;
import com.lidegui.littledrawer.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 18:30 2019/4/15
 */

@Service("PictureService")
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao mPictureDao;

    @Autowired
    private LikeDao mLikeDao;

    @Autowired
    private CollectionDao mCollectionDao;

    @Override
    public Picture addPicture(Picture picture) {
        if (mPictureDao.insert(picture) > 0) {
            return mPictureDao.findById(picture.getId());
        }

        return null;
    }

    @Override
    public int deletePicture(int pictureId) {
        return mPictureDao.deleteById(pictureId);
    }

    @Override
    public Picture updatePicture(Picture picture) {
        if (mPictureDao.updatePicture(picture) > 0) {
            return mPictureDao.findById(picture.getId());
        }
        return null;
    }

    @Override
    public Picture getPictureById(int pictureId) {
        return mPictureDao.findById(pictureId);
    }

    @Override
    public List<Picture> getPicturesByUserId(int userId) {
        return mPictureDao.findByUserId(userId);
    }

    @Override
    public List<Picture> getFunnyPictures() {
        return mPictureDao.findFunnyPictures();
    }

    @Override
    public List<Picture> getAllPictures() {
        return mPictureDao.findAll();
    }
}
