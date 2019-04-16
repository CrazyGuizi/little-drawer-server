package com.lidegui.littledrawer.web;

import com.lidegui.littledrawer.bean.Picture;
import com.lidegui.littledrawer.dto.BaseResponse;
import com.lidegui.littledrawer.service.PictureService;
import com.lidegui.littledrawer.util.Constant;
import com.lidegui.littledrawer.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author: lidegui
 * @Date:Created in 18:34 2019/4/15
 */

@RestController
@RequestMapping(Constant.API_PICTURE)
public class PictureController {

    @Autowired
    private PictureService mPictureService;


    @RequestMapping(value = Constant.API_PICTURE_ADD_PICTURE, method = RequestMethod.POST)
    public BaseResponse addPicture(@RequestBody Picture picture) {
        if (picture != null) {
            if (picture.getId()> 0) {
                // 如果图片已经存在，则更新图片信息
                Picture pictureById = mPictureService.getPictureById(picture.getId());
                if (pictureById != null) {
                    if (pictureById.getDate() != null) {
                        picture.setDate(pictureById.getDate());
                    } else {
                        picture.setDate(Util.getDateNow());
                    }
                    pictureById = mPictureService.updatePicture(picture);
                    // 更新成功
                    if (pictureById != null) {
                        return BaseResponse.generateSuccess("添加成功", pictureById);
                    } else {
                        return BaseResponse.generateFail("添加失败");
                    }
                }
            }
            picture.setDate(Util.getDateNow());
            Picture addPicture = mPictureService.addPicture(picture);
            if (addPicture != null) {
                return BaseResponse.generateSuccess("添加成功", addPicture);
            }

        }
        return BaseResponse.generateFail("添加失败");
    }

    @RequestMapping(value = Constant.API_PICTURE_DELETE_PICTURE, method = RequestMethod.POST)
    public BaseResponse deletePicture(@RequestBody Map<String, Integer> map) {
        int id = map.get("pictureId");
        if (id > 0) {
            int i = mPictureService.deletePicture(id);
            if (i > 0) {
                return BaseResponse.generateSuccess("删除成功", null);
            }
        }

        return BaseResponse.generateFail("删除失败");
    }


    @RequestMapping(value = Constant.API_PICTURE_GET_PICTURE_BY_ID, method = RequestMethod.POST)
    public BaseResponse getPictureById(@RequestBody Map<String, String> map) {
        String id = map.get("pictureId");
        if (!Util.isEmpty(id)) {
            Picture picture = mPictureService.getPictureById(Integer.parseInt(id));
            if (picture != null) {
                return BaseResponse.generateSuccess("获取成功", picture);
            }
        }

        return BaseResponse.generateFail("获取失败");
    }

    @RequestMapping(value = Constant.API_PICTURE_GET_FUNNY_PICTURES_RANDOM, method = RequestMethod.POST)
    public BaseResponse getFunnyPicturesRandom(@RequestBody Map<String, String> map,
                                               HttpServletRequest request) {
        // 分页
        String pageNum = map.get("pageNum");
        String pageSize = map.get("pageSize");
//        if (!Util.isEmpty(pageNum) && !Util.isEmpty(pageSize)) {
//            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
//        }

        List<Picture> funnyPictures = mPictureService.getFunnyPictures();

        if (funnyPictures != null && funnyPictures.size() > 0) {
            int end = 0;
            if (!Util.isEmpty(pageSize)) {
                end = Integer.parseInt(pageSize);

                if (end > funnyPictures.size()) {
                    end = funnyPictures.size();
                }
            } else {
                end = funnyPictures.size();
            }

            List<Picture> random = funnyPictures;
            Collections.shuffle(random);

            return BaseResponse.generateSuccess("获取成功", random.subList(0, end));
        }


        return BaseResponse.generateFail("获取失败");
    }

    @RequestMapping(value = Constant.API_PICTURE_GET_PICTURES_BY_USER_ID, method = RequestMethod.POST)
    public BaseResponse getPicturesByUserId(@RequestBody Map<String, String> map) {
        String id = map.get("userId");
        if (!Util.isEmpty(id)) {
            List<Picture> pictures = mPictureService.getPicturesByUserId(Integer.parseInt(id));
            if (pictures != null && pictures.size() > 0) {
                return BaseResponse.generateSuccess("获取成功", pictures);
            } else {
                return BaseResponse.generateFail("你还没有发表过图片哟~");
            }
        }
        return BaseResponse.generateFail("获取失败");
    }

}
