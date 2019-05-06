package com.lidegui.littledrawer.util;

public enum ReportTopic {
    NEWS("新闻"),
    VIDEO("视频"),
    PICTURE("图片"),
    COMMENT("评论"),
    REPLY("回复");

    public String topicName;

    ReportTopic(String topicName) {
        this.topicName = topicName;
    }
}
