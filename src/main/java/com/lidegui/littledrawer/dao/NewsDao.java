package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.News;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 19:44 2019/4/13
 */
public interface NewsDao {

    public int insert(News news);

    public int deleteById(int id);

    /**
     * 根据关键字删除记录
     * @param word 内容或标题的关键字
     * @return
     */
    public int deleteByKeyWord(String word);

    public int update(News news);

    public News findById(int id);

    /**
     * 根据类别查找记录
     * @param column 新闻的类别（而不是数据库的列）
     * @return
     */
    public List<News> findByColumn(String column);

    /**
     * 根据作者id查找
     * @param id
     * @return
     */
    public List<News> findByUserId(int id);

    public List<News> findByKeyWord(String key);

    public List<News> findAll();
}
