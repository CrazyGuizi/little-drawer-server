package com.lidegui.littledrawer.service.impl;

import com.lidegui.littledrawer.bean.News;
import com.lidegui.littledrawer.dao.NewsDao;
import com.lidegui.littledrawer.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: lidegui
 * @Date:Created in 20:09 2019/4/13
 */
@Service("NewsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao mNewsDao;

    @Override
    public News addNews(News news) {
        int insert = mNewsDao.insert(news);
        if (insert > 0) {
            return mNewsDao.findById(news.getId());
        }
        return null;
    }

    @Override
    public int deleteNews(int newsId) {
        int i = mNewsDao.deleteById(newsId);
        if (i > 0) {
            // todo 将该新闻下的评论和其他相关的东西也删掉
        }

        return i;
    }

    @Override
    public News updateNews(News news) {
        int update = mNewsDao.update(news);
        if (update > 0) {
            return mNewsDao.findById(news.getId());
        }
        return null;
    }

    @Override
    public News getNewsById(int id) {
        return mNewsDao.findById(id);
    }

    @Override
    public List<News> getNewsByColumn(String column) {
        return mNewsDao.findByColumn(column);
    }

    @Override
    public List<News> getNewsByUser(int userId) {
        return mNewsDao.findByUserId(userId);
    }

    @Override
    public List<News> getNewsRandom(List<News> newsList) {

        if (newsList != null && newsList.size() > 0) {
            List<News> list = newsList;
            Collections.shuffle(list);
            return list;
        }

        return null;
    }

    @Override
    public List<News> getAllNews() {
        return mNewsDao.findAll();
    }

    @Override
    public List<News> searchNews(String key) {
        return mNewsDao.findByKeyWord(key);
    }

}
