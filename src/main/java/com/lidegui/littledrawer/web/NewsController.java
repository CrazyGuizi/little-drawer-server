package com.lidegui.littledrawer.web;

import com.github.pagehelper.PageHelper;
import com.lidegui.littledrawer.bean.News;
import com.lidegui.littledrawer.bean.Picture;
import com.lidegui.littledrawer.dto.AddNews;
import com.lidegui.littledrawer.dto.BaseResponse;
import com.lidegui.littledrawer.service.NewsService;
import com.lidegui.littledrawer.service.PictureService;
import com.lidegui.littledrawer.util.Constant;
import com.lidegui.littledrawer.util.TopicEnum;
import com.lidegui.littledrawer.util.Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private PictureService mPictureService;

    @RequestMapping(value = Constant.API_NEWS_ADD_NEWS, method = RequestMethod.POST)
    public BaseResponse addNews(@RequestBody AddNews addNews) {
        if (addNews != null) {
            News news = addNews.getNews();
            // 主键自增长
            news.setId(0);
            news.setDate(Util.getDateNow());
            news = mNewsService.addNews(news);
            if (news != null) {
                // 新闻是否有封面，有的话则更新封面图片的topicId，确保该新闻能查找到对应的图片
                List<Picture> pictureList = addNews.getCoverPictures();
                if (pictureList != null && pictureList.size() > 0) {
                    for (Picture picture : pictureList) {
                        picture.setTopicType(TopicEnum.NEWS.topicType);
                        picture.setTopicId(news.getId());
                        mPictureService.updatePicture(picture);
                    }
                }
            } else {
                return BaseResponse.generateFail("发表失败");
            }

            return BaseResponse.generateSuccess("发表成功", news);
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
            // 根据类别取新闻
            if (Util.getNewsColumn(column) != null ) {
                newsList = mNewsService.getNewsByColumn(column);
            } else if ("推荐".equals(column) || "头条".equals(column)){
                // 如果是推荐和头条则从全部新闻中取出
                newsList = mNewsService.getAllNews();
            } else {
                // 平台没有该类新闻
                return BaseResponse.generateFail("平台没有该类新闻");
            }
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
