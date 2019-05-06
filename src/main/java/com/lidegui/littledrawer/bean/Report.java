package com.lidegui.littledrawer.bean;

import java.util.Date;

/**
 * @Author: lidegui
 * @Date:Created in 19:09 2019/5/6
 */
public class Report {
    private int id;
    private String reason;
    private Date date;
    private String topicName;
    private int topicId;
    private User reporter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }
}
