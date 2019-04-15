package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.Picture;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 18:26 2019/4/15
 */
public interface PictureService {

    public Picture addPicture(Picture picture);

    public int deletePicture(int pictureId);

    public Picture updatePicture(Picture picture);

    public Picture getPictureById(int pictureId);

    public List<Picture> getPicturesByUserId(int userId);

    public List<Picture> getFunnyPictures();

    public List<Picture> getAllPictures();
}
