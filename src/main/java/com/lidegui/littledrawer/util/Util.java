package com.lidegui.littledrawer.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 * @Author: lidegui
 * @Date:Created in 11:06 2019/4/13
 */
public class Util {

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

    public static void main(String[] args) {
        System.out.println(getDateNow());
    }

}
