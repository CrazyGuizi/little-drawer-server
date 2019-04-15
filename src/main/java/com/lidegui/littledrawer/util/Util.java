package com.lidegui.littledrawer.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lidegui.littledrawer.bean.Video;

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

    public static void main(String[] args) {
        System.out.println(getDateNow());
    }

}
