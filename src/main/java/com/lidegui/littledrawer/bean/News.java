package com.lidegui.littledrawer.bean;

import java.util.Date;
import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 14:31 2019/4/13
 */
public class News {
    private int id;
    private String title;
    // 类别
    private String column;
    private Date date;
    private String content;
    // 展示新闻时的一个tag，1展示一张封面，2为0张，3为3张
    private int style;
    // 封面图片
    private List<String> picUrls;
    private User author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
