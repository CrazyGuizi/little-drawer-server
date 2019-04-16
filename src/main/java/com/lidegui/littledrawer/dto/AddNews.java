package com.lidegui.littledrawer.dto;

import com.lidegui.littledrawer.bean.News;
import com.lidegui.littledrawer.bean.Picture;
import com.lidegui.littledrawer.bean.User;

import java.util.Date;
import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 18:19 2019/4/16
 */
public class AddNews {

    private int id;
    private String title;
    // 类别
    private String column;
    private Date date;
    private String content;
    // 展示新闻时的一个tag，1展示一张封面，2为0张，3为3张
    private int style;

    private User author;

    // 新闻封面图片
    private List<Picture> coverPictures;

    public News getNews() {
        News news = new News();
        news.setTitle(this.title);
        news.setColumn(this.column);
        news.setContent(this.content);
        news.setStyle(this.style);
        news.setAuthor(this.author);
        return news;
    }

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Picture> getCoverPictures() {
        return coverPictures;
    }

    public void setCoverPictures(List<Picture> coverPictures) {
        this.coverPictures = coverPictures;
    }
}
