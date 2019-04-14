package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.News;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 20:02 2019/4/13
 */
public interface NewsService {

    public News addNews(News news);

    public int deleteNews(int newsId);

    public News updateNews(News news);

    public News getNewsById(int id);

    public List<News> getNewsByColumn(String column);

    public List<News> getNewsByUser(int userId);

    public List<News> getNewsRandom(List<News> newsList);

    public List<News> getAllNews();

    public List<News> searchNews(String key);

}
