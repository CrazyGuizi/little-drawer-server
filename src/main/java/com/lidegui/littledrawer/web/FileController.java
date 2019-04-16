package com.lidegui.littledrawer.web;

import com.alibaba.fastjson.JSON;
import com.lidegui.littledrawer.bean.File;
import com.lidegui.littledrawer.bean.Picture;
import com.lidegui.littledrawer.bean.User;
import com.lidegui.littledrawer.bean.Video;
import com.lidegui.littledrawer.dto.BaseResponse;
import com.lidegui.littledrawer.service.FileService;
import com.lidegui.littledrawer.service.PictureService;
import com.lidegui.littledrawer.service.UserService;
import com.lidegui.littledrawer.service.VideoService;
import com.lidegui.littledrawer.util.Constant;
import com.lidegui.littledrawer.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: lidegui
 * @Date:Created in 11:02 2019/4/16
 */

@Controller
@RequestMapping(Constant.API_RESOURCE)
public class FileController {

    @Autowired
    private FileService mFileService;

    @Autowired
    private UserService mUserService;

    @Autowired
    private PictureService mPictureService;

    @Autowired
    private VideoService mVideoService;


    @RequestMapping(Constant.API_RESOURCE_UPLOAD_PICTURE)
    @ResponseBody
    public BaseResponse uploadPicture(@RequestParam(value = "file")MultipartFile file) {
        User author = mUserService.findUserByToken(Util.getToken());
        if (author != null) {
            File sqlFile = Util.saveFileToServe(file);
            if (sqlFile != null && sqlFile.getMime().startsWith("image")) {
                sqlFile = mFileService.addFile(sqlFile);
                if (sqlFile != null) {
                    Picture picture = new Picture();
                    picture.setTitle(sqlFile.getName());
                    picture.setUrl(sqlFile.getPath());
                    picture.setAuthor(author);
                    picture.setDate(sqlFile.getDate());
                    Picture addPicture = mPictureService.addPicture(picture);
                    if (addPicture != null) {
                        sqlFile.setMediaId(addPicture.getId());
                        if (mFileService.updateFile(sqlFile) != null) {
                            return BaseResponse.generateSuccess("上传成功", addPicture);
                        }
                    }
                }
            }

            return BaseResponse.generateFail("上传失败");
        } else {
            throw new IllegalArgumentException("身份信息已过期，请重新登录");
        }

//        return BaseResponse.generateFail("身份信息已过期，请重新登录");
    }

    @RequestMapping(Constant.API_RESOURCE_UPLOAD_VIDEO)
    @ResponseBody
    public BaseResponse uploadVideo(@RequestParam(value = "file")MultipartFile file) {
        User author = mUserService.findUserByToken(Util.getToken());
        if (author != null) {
            File sqlFile = Util.saveFileToServe(file);
            if (sqlFile != null && sqlFile.getMime().startsWith("video")) {
                sqlFile = mFileService.addFile(sqlFile);
                if (sqlFile != null) {
                    return BaseResponse.generateSuccess("上传成功", sqlFile);
                }
            }

            return BaseResponse.generateFail("上传失败");
        } else {
            throw new IllegalArgumentException("身份信息已过期，请重新登录");
        }
    }
}
