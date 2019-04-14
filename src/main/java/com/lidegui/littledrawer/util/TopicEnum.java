package com.lidegui.littledrawer.util;

public enum TopicEnum {
    NEWS(0, "新闻"),
    VIDEO(1,"视频"),
    PICTURE(2, "图片");

    int topicType;
    String topicName;

    TopicEnum(int topicType, String topicName) {
        this.topicType = topicType;
        this.topicName = topicName;
    }
}
