package com.lidegui.littledrawer.web;

import com.github.pagehelper.PageHelper;
import com.lidegui.littledrawer.bean.News;
import com.lidegui.littledrawer.dto.BaseResponse;
import com.lidegui.littledrawer.service.NewsService;
import com.lidegui.littledrawer.util.Constant;
import com.lidegui.littledrawer.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Author: lidegui
 * @Date:Created in 20:20 2019/4/13
 */

@RestController
@RequestMapping(Constant.API_NEWS)
public class NewsController {

    @Autowired
    private NewsService mNewsService;

    @RequestMapping(value = Constant.API_NEWS_ADD_NEWS, method = RequestMethod.POST)
    public BaseResponse addNews(@RequestBody News news) {
        news.setDate(Util.getDateNow());
        News addNews = mNewsService.addNews(news);
        if (addNews != null) {
            return BaseResponse.generateSuccess("发表成功", addNews);
        }

        return BaseResponse.generateFail("发表失败");
    }

    @RequestMapping(value = Constant.API_NEWS_DELETE_NEWS_BY_ID, method = RequestMethod.POST)
    public BaseResponse deleteNewsById(@RequestBody Map<String, String> map) {
        String id = map.get("newsId");
        Util.log(id);
        if (!Util.isEmpty(id)) {
            int i = mNewsService.deleteNews(Integer.parseInt(id));
            if (i > 0) {
                return BaseResponse.generateSuccess("删除成功", null);
            }
        }
        return BaseResponse.generateFail("删除失败");
    }

    @RequestMapping(value = Constant.API_NEWS_UPDATE_NEWS_BY_ID, method = RequestMethod.POST)
    public BaseResponse updateNewsById(@RequestBody News news) {
        if (news != null) {
            news.setDate(Util.getDateNow());
        }
        News updateNews = mNewsService.updateNews(news);
        if (updateNews != null) {
            return BaseResponse.generateSuccess("更新成功", updateNews);
        }

        return BaseResponse.generateFail("更新失败");
    }

    @RequestMapping(value = Constant.API_NEWS_GET_NEWS_BY_ID, method = RequestMethod.POST)
    public BaseResponse getNewsById(@RequestBody Map<String, String> map) {
        String id = map.get("newsId");
        if (!Util.isEmpty(id)) {
            News news = mNewsService.getNewsById(Integer.parseInt(id));
            if (news != null) {
                return BaseResponse.generateSuccess("获取成功", news);
            }
        }
        return BaseResponse.generateFail("获取失败");
    }

    @RequestMapping(value = Constant.API_NEWS_GET_NEWS_BY_COLUMN, method = RequestMethod.POST)
    public BaseResponse getNewsByColumn(@RequestBody Map<String, String> map) {
        String col = map.get("column");
        if (!Util.isEmpty(col)) {
            // 分页
            String pageNum = map.get("pageNum");
            String pageSize = map.get("pageSize");
            if (!Util.isEmpty(pageNum) && !Util.isEmpty(pageSize)) {
                PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            }

            List<News> newsList = mNewsService.getNewsByColumn(col);
            if (newsList != null && newsList.size() > 0) {
                return BaseResponse.generateSuccess("获取成功", newsList);
            }
        }

        return BaseResponse.generateFail("获取失败");
    }

    @RequestMapping(value = Constant.API_NEWS_GET_NEWS_BY_USER_ID, method = RequestMethod.POST)
    public BaseResponse getNewsByUserId(@RequestBody Map<String, String> map) {
        String id = map.get("userId");
        if (!Util.isEmpty(id)) {
            List<News> newsList = mNewsService.getNewsByUser(Integer.parseInt(id));
            if (newsList != null && newsList.size() > 0) {
                return BaseResponse.generateSuccess("获取成功", newsList);
            }
        }
        return BaseResponse.generateFail("获取失败");
    }

    @RequestMapping(value = Constant.API_NEWS_GET_NEWS_RANDOM, method = RequestMethod.POST)
    public BaseResponse getNewsRandom(@RequestBody Map<String, String> map) {
        String column = map.get("column");
        String pageNum = map.get("pageNum");
        String pageSize = map.get("pageSize");
        if (!Util.isEmpty(pageNum) && !Util.isEmpty(pageSize)) {
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        }
        List<News> newsList = null;

        if (!Util.isEmpty(column)) {
            newsList = mNewsService.getNewsByColumn(column);
        } else {
            newsList = mNewsService.getAllNews();
        }

        if (newsList != null && newsList.size() > 0) {
            List<News> random = newsList;
            Collections.shuffle(random);
            return BaseResponse.generateSuccess("获取成功", random);
        }


        return BaseResponse.generateFail("获取失败");
    }


    @RequestMapping(value = Constant.API_NEWS_SEARCH_NEWS, method = RequestMethod.POST)
    public BaseResponse searchNews (@RequestBody Map<String, String> map) {
        String key = map.get("keyWord");
        if (!Util.isEmpty(key)) {
            List<News> list = mNewsService.searchNews(key);
            if (list != null && list.size() > 0) {
                return BaseResponse.generateSuccess("搜索成功", list);
            }
        }
        return BaseResponse.generateFail("搜索失败");
    }


}
