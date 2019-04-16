package com.lidegui.littledrawer.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lidegui.littledrawer.bean.Video;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 * @Author: lidegui
 * @Date:Created in 11:06 2019/4/13
 */
public class Util {

    private static boolean isDebug = true;

    public static void log(Object o) {
        if (isDebug) {
            System.out.println(o);
        }
    }

    public static Date getDateNow() {
        return new Timestamp(new Date().getTime());
    }

    public static long getTimestampNow() {
        return new Timestamp(new Date().getTime()).getTime();
    }

    public static boolean isEmpty(String s) {
        if (s == null) {
            return true;
        }

        if ("".equals(s.replaceAll(" ", ""))) {
            return true;
        }

        return false;
    }

    public static String getIconRandom() {
        return Constant.USER_DEFAULT_ICON[new Random().nextInt(Constant.USER_DEFAULT_ICON.length)];
    }

    public static TopicEnum getTopic(int index) {
        TopicEnum topicEnum = null;
        switch (index) {
            case 0:
                topicEnum = TopicEnum.NEWS;
                break;
            case 1:
                topicEnum = TopicEnum.VIDEO;
                break;
            case 2:
                topicEnum = TopicEnum.PICTURE;
                break;
        }

        return topicEnum;
    }

    public static VideoType getVideoType(int index) {
        VideoType type = null;
        if (index == VideoType.FUNNY.typeIndex) {
            type = VideoType.FUNNY;
        } else if (index == VideoType.GAME.typeIndex) {
            type = VideoType.GAME;
        } else if (index == VideoType.LIFE.typeIndex) {
            type = VideoType.LIFE;
        } else if (index == VideoType.FILM.typeIndex) {
            type = VideoType.FILM;
        } else if (index == VideoType.SCIENCE.typeIndex) {
            type = VideoType.SCIENCE;
        } else if (index == VideoType.OTHER.typeIndex) {
            type = VideoType.OTHER;
        }

        return type;
    }

    public static VideoType getVideoType(String typeName) {
        VideoType type = null;

        if (VideoType.FUNNY.typeName.equals(typeName)) {
            type = VideoType.FUNNY;
        } else if (VideoType.GAME.typeName.equals(typeName)) {
            type = VideoType.GAME;
        } else if (VideoType.LIFE.typeName.equals(typeName)) {
            type = VideoType.LIFE;
        } else if (VideoType.FILM.typeName.equals(typeName)) {
            type = VideoType.FILM;
        } else if (VideoType.SCIENCE.typeName.equals(typeName)) {
            type = VideoType.SCIENCE;
        } else if (VideoType.OTHER.typeName.equals(typeName)) {
            type = VideoType.OTHER;
        }

        return type;
    }

    public static NewsColumn getNewsColumn(String colName) {
        NewsColumn column = null;

        if (NewsColumn.SOCIAL.columnName.equals(colName)) {
            column = NewsColumn.SOCIAL;
        } else if (NewsColumn.SCIENCE.columnName.equals(colName)) {
            column = NewsColumn.SCIENCE;
        } else if (NewsColumn.LIFE.columnName.equals(colName)) {
            column = NewsColumn.LIFE;
        } else if (NewsColumn.ENTERTAINMENT.columnName.equals(colName)) {
            column = NewsColumn.ENTERTAINMENT;
        } else if (NewsColumn.AGRICULTURAL.columnName.equals(colName)) {
            column = NewsColumn.AGRICULTURAL;
        }else if (NewsColumn.INTERNATIONAL.columnName.equals(colName)) {
            column = NewsColumn.INTERNATIONAL;
        } else if (NewsColumn.SPORTS.columnName.equals(colName)) {
            column = NewsColumn.SPORTS;
        }

        return column;
    }


    /**
     * 保存文件到该项目的resource/static目录下
     * @param file 视频或图片
     * @return
     */
    public static com.lidegui.littledrawer.bean.File saveFileToServe(MultipartFile file){
        if (file != null && !file.isEmpty()) {
            File resourcePath = null;
            String url = Constant.LOCALHOST;
            try {
                // 目前只存储图片和视频
                if (file.getContentType().startsWith("image")) {
                    resourcePath = ResourceUtils.getFile(Constant.RESOURCE_IMAGE_PATH);
                    url = url + "/image";
                } else if (file.getContentType().startsWith("video")){
                    resourcePath = ResourceUtils.getFile(Constant.RESOURCE_VIDEO_PATH);
                    url = url + "/video";
                } else {
                    return null;
                }

                if (!resourcePath.exists()) {
                    resourcePath.mkdir();
                }

                // 以当前时间重命名保存到服务器
                String saveServeName = "" + Util.getTimestampNow();
                String fileType = file.getContentType();
                String type = "." + fileType.split("/")[fileType.split("/").length - 1];
                String savePath = resourcePath.getAbsolutePath() + File.separator + saveServeName + type;
                file.transferTo(new File(savePath));

                // 存储到数据库的文件
                String mime = file.getContentType();
                String name = file.getOriginalFilename();
                url = url + "/" + saveServeName + type;
                com.lidegui.littledrawer.bean.File saveSqlFile = new com.lidegui.littledrawer.bean.File();
                saveSqlFile.setName(name);
                saveSqlFile.setMime(mime);
                saveSqlFile.setPath(url);
                saveSqlFile.setDate(Util.getDateNow());

                return saveSqlFile;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static String getToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("X-token");
        if ("null".equals(token) || "undefine".equals(token)) {
            return null;
        }

        return token;
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getDateNow());
        System.out.println("路径");
        File file = ResourceUtils.getFile("classpath:static");
        System.out.println(file.getAbsolutePath());
        for (File f : file.listFiles()) {
            System.out.println(f.getAbsolutePath());
        }
    }

}
