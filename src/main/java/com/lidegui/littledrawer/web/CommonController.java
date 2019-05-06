package com.lidegui.littledrawer.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lidegui.littledrawer.bean.*;
import com.lidegui.littledrawer.dto.BaseResponse;
import com.lidegui.littledrawer.interceptor.LogInterceptor;
import com.lidegui.littledrawer.service.*;
import com.lidegui.littledrawer.util.Constant;
import com.lidegui.littledrawer.util.ReportTopic;
import com.lidegui.littledrawer.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: lidegui
 * @Date:Created in 20:13 2019/4/14
 */

@RestController
@RequestMapping(Constant.API_COMMON)
public class CommonController {

    @Autowired
    private CommentService mCommentService;

    @Autowired
    private ReplyService mReplyService;

    @Autowired
    private LikeService mLikeService;

    @Autowired
    private CollectionService mCollectionService;

    @Autowired
    private ReportService mReportService;

    @Autowired
    private NewsService mNewsService;

    /**************************************评论相关******************************************/
    @RequestMapping(value = Constant.API_COMMON_ADD_COMMENT, method = RequestMethod.POST)
    public BaseResponse addComment(@RequestBody Comment comment) {
        if (comment != null) {
            comment.setDate(Util.getDateNow());
            Comment addComment = mCommentService.addComment(comment);
            if (addComment != null) {
                return BaseResponse.generateSuccess("评论成功", addComment);
            }

        }
        return BaseResponse.generateFail("评论失败");
    }

    @RequestMapping(value = Constant.API_COMMON_DELETE_COMMENT, method = RequestMethod.POST)
    public BaseResponse deleteComment(@RequestBody Map<String, String> map) {
        String id = map.get("commentId");
        if (!Util.isEmpty(id)) {
            if (mCommentService.deleteComment(Integer.parseInt(id)) > 0) {
                return BaseResponse.generateSuccess("删除成功", null);
            }
        }

        return BaseResponse.generateFail("删除失败");
    }

    @RequestMapping(value = Constant.API_COMMON_GET_COMMENTS_BY_TOPIC,
            method = RequestMethod.POST)
    public BaseResponse getCommentsByTopic(@RequestBody Map<String, String> map) {
        String id = map.get("topicId");
        String type = map.get("topicType");
        if (!Util.isEmpty(id) && !Util.isEmpty(type)) {
            List<Comment> comments = mCommentService.getCommentsByTopic(Integer.parseInt(type), Integer.parseInt(id));

            if (comments != null && comments.size() > 0) {
                BaseResponse success = BaseResponse.generateSuccess("获取评论成功", comments);
                Util.getRequest().setAttribute(LogInterceptor.LOG_RETURN, JSON.toJSONString(success));
                return success;
            } else {
                return BaseResponse.generateFail("暂无评论");
            }
        }

        return BaseResponse.generateFail("获取评论失败");
    }

    /**************************************回复相关******************************************/
    @RequestMapping(value = Constant.API_COMMON_ADD_REPLY, method = RequestMethod.POST)
    public BaseResponse addReply(@RequestBody Reply reply) {
        if (reply != null) {
            reply.setDate(Util.getDateNow());
            Reply addReply = mReplyService.addReply(reply);
            if (addReply != null) {
                return BaseResponse.generateSuccess("回复成功", addReply);
            }

        }
        return BaseResponse.generateFail("回复失败");
    }

    @RequestMapping(value = Constant.API_COMMON_DELETE_REPLY, method = RequestMethod.POST)
    public BaseResponse deleteReply(@RequestBody Map<String, String> map) {
        String id = map.get("replyId");
        if (!Util.isEmpty(id)) {
            if (mReplyService.deleteReply(Integer.parseInt(id)) > 0) {
                return BaseResponse.generateSuccess("删除成功", null);
            }
        }

        return BaseResponse.generateFail("删除失败");
    }

    @RequestMapping(value = Constant.API_COMMON_GET_REPLYS_BY_COMMENT_ID,
            method = RequestMethod.POST)
    public BaseResponse getReplysByCommentId(@RequestBody Map<String, String> map) {
        String id = map.get("commentId");
        if (!Util.isEmpty(id)) {
            List<Reply> replyList = mReplyService.getReplysByCommentId(Integer.parseInt(id));

            if (replyList != null && replyList.size() > 0) {
                return BaseResponse.generateSuccess("获取回复成功", replyList);
            }
        }

        return BaseResponse.generateFail("获取回复失败");
    }


    /**************************************点赞相关******************************************/

    @RequestMapping(value = Constant.API_COMMON_ADD_LIKE, method = RequestMethod.POST)
    public BaseResponse addLike(@RequestBody Like like) {
        if (like != null) {
            like.setDate(Util.getDateNow());
            Like addLike = mLikeService.addLike(like);
            if (addLike != null) {
                return BaseResponse.generateSuccess("点赞成功", addLike);
            }

        }
        return BaseResponse.generateFail("点赞失败");
    }

    @RequestMapping(value = Constant.API_COMMON_SET_LIKE_STATUS, method = RequestMethod.POST)
    public BaseResponse setLikeStatus(@RequestBody Like like) {
        if (like != null) {
            if (like.getId() <= 0) {
                // 用户第一次点赞
                like.setDate(Util.getDateNow());
                like.setStatus(1);
                Like addLike = mLikeService.addLike(like);
                if (addLike != null) {
                    return BaseResponse.generateSuccess("点赞状态更改成功", addLike);
                }
            } else {
                Like likeStatus = mLikeService.changeLikeStatus(like);
                if (likeStatus != null) {
                    return BaseResponse.generateSuccess("点赞状态更改成功", likeStatus);
                }
            }
        }

        return BaseResponse.generateFail("点赞失败");
    }

    @RequestMapping(value = Constant.API_COMMON_GET_LIKE_STATUS, method = RequestMethod.POST)
    public BaseResponse getLikeStatus(@RequestBody Map<String, Integer> map) {
        int topicType = map.get("topicType");
        int topicId = map.get("topicId");
        int userId = map.get("userId");

        if (!map.containsKey("topicType") || !map.containsKey("topicId") ||
                !map.containsKey("userId")) {
            return BaseResponse.generateFail("请求参数有误");
        }

        if (topicId != 0 && topicId != 0 && userId != 0) {
            Like likeStatus = mLikeService.findUserLikeStatus(topicType, topicId, userId);
            if (likeStatus != null) {
                return BaseResponse.generateSuccess("获取成功", likeStatus);
            } else {
                return BaseResponse.generateFail("用户还没有点赞");
            }
        }

        return BaseResponse.generateFail("获取失败");
    }


    /**************************************收藏相关******************************************/

    @RequestMapping(value = Constant.API_COMMON_ADD_COLLECTION, method = RequestMethod.POST)
    public BaseResponse addCollection(@RequestBody Collection collection) {
        if (collection != null) {
            collection.setDate(Util.getDateNow());
            Collection addCollection = mCollectionService.addCollection(collection);
            if (addCollection != null) {
                return BaseResponse.generateSuccess("收藏成功", addCollection);
            }

        }
        return BaseResponse.generateFail("收藏失败");
    }

    @RequestMapping(value = Constant.API_COMMON_CANCEL_COLLECTION, method = RequestMethod.POST)
    public BaseResponse cancelCollection(@RequestBody Map<String, Integer> map) {

        if (map.containsKey("collectionId")) {
            int id = map.get("collectionId");
            int i = mCollectionService.deleteCollection(id);
            if (i > 0) {
                return BaseResponse.generateSuccess("取消收藏成功", null);
            }
        } else if (map.containsKey("topicType") && map.containsKey("topicId") &&
                map.containsKey("userId")) {
            int topicType = map.get("topicType");
            int topicId = map.get("topicId");
            int userId = map.get("userId");
            if (mCollectionService.deleteCollection(topicType, topicId, userId) > 0) {
                return BaseResponse.generateSuccess("取消收藏成功", null);
            }
        }


        return BaseResponse.generateFail("取消收藏失败");
    }

    @RequestMapping(value = Constant.API_COMMON_GET_COLLECTION_STATUS, method = RequestMethod.POST)
    public BaseResponse getCollectionStatus(@RequestBody Map<String, Integer> map) {

        int topicType = map.get("topicType");
        int topicId = map.get("topicId");
        int userId = map.get("userId");

        if (!map.containsKey("topicType") || !map.containsKey("topicId") ||
                !map.containsKey("userId")) {
            return BaseResponse.generateFail("请求参数有误");
        }

        if (topicId != 0 && topicId != 0 && userId != 0) {
            Collection status = mCollectionService.findUserCollectionStatus(topicType, topicId, userId);
            if (status != null) {
                return BaseResponse.generateSuccess("获取成功", status);
            } else {
                return BaseResponse.generateFail("你还没有收藏");
            }
        }

        return BaseResponse.generateFail("获取失败");
    }


    /**************************************举报相关******************************************/

    @RequestMapping(value = Constant.API_COMMON_ADD_REPORT, method = RequestMethod.POST)
    public BaseResponse addReport(@RequestBody Report report) {
        if (report != null) {

            Report r = mReportService.getReportByTopicIdAndReporter(report.getTopicId(),
                    report.getReporter().getId());
            // 同一个人对同一个东西重复举报
            if (r != null) {
                return BaseResponse.generateSuccess("举报成功", r);
            } else {
                if (Util.isEmpty(report.getReason())) {
                    report.setReason("含有敏感内容");
                }
                report.setDate(Util.getDateNow());
                Report addReport = mReportService.addReport(report);
                if (addReport != null) {
                    return BaseResponse.generateSuccess("举报成功", addReport);
                }
            }
        }
        return BaseResponse.generateFail("举报失败");
    }

    @RequestMapping(value = Constant.API_COMMON_DELETE_REPORT, method = RequestMethod.POST)
    public BaseResponse deleteReport(@RequestBody Map<String, Integer> map) {
        if (map.containsKey("reportId")) {
            int reportId = map.get("reportId");
            if (mReportService.deleteReport(reportId) > 0) {
                return BaseResponse.generateSuccess("删除成功", null);
            }
        }

        return BaseResponse.generateFail("删除失败");
    }

    @RequestMapping(value = Constant.API_COMMON_GET_ALL_REPORTS, method = RequestMethod.POST)
    public BaseResponse getAllReports() {
        List<Report> allReports = mReportService.getAllReports();
        if (allReports != null && !allReports.isEmpty()) {
            return BaseResponse.generateSuccess("获取成功", allReports);
        }

        return BaseResponse.generateFail("获取失败");
    }

    @RequestMapping(value = Constant.API_COMMON_GET_REPORTS_BY_TOPIC, method = RequestMethod.POST)
    public BaseResponse getReportsByTopic(@RequestBody Map<String, String> map) {
        if (map.containsKey("topicName")) {
            String topicName = map.get("topicName");
            if (Util.isContainReportTopic(topicName)) {
                List<Report> reports = mReportService.getReportsByTopic(topicName);
                if (reports != null && !reports.isEmpty()) {
                    return BaseResponse.generateSuccess("获取成功", reports);
                }
            }
        }

        return BaseResponse.generateFail("获取失败");
    }

    @RequestMapping(value = Constant.API_COMMON_ACCEPT_REPORT, method = RequestMethod.POST)
    public BaseResponse acceptReport(@RequestBody Map<String, String> map) {
        if (map.containsKey("topicName") && map.containsKey("topicId")) {
            String topicName = map.get("topicName");
            int topicId = Integer.parseInt(map.get("topicId"));

            // 举报新闻
            if (ReportTopic.NEWS.topicName.equals(topicName)) {
                News news = mNewsService.getNewsById(topicId);
                if (news != null) {
                    news.setContent("新闻含有敏感内容，不给予展示");
                }
                News updateNews = mNewsService.updateNews(news);
                if (updateNews != null) {
                    Report report = mReportService.getReportByTopicNameAndTopicId(topicId, topicName);
                    mReportService.deleteReport(report.getId());
                    return BaseResponse.generateSuccess("处理成功,该新闻内容不展示");
                }
            } else if (ReportTopic.COMMENT.topicName.equals(topicName)) {
                // 举报评论
                Comment comment = mCommentService.getCommentById(topicId);
                if (comment != null) {
                    if (mCommentService.deleteComment(comment.getId()) > 0) {
                        Report report = mReportService.getReportByTopicNameAndTopicId(topicId, topicName);
                        mReportService.deleteReport(report.getId());
                        return BaseResponse.generateSuccess("处理成功，该评论已删除", null);
                    }
                }
            } else if (ReportTopic.REPLY.topicName.equals(topicName)) {
                // 举报回复
                Reply reply = mReplyService.getReplyById(topicId);
                if (reply != null) {
                    if (mReplyService.deleteReply(reply.getId()) > 0) {
                        Report report = mReportService.getReportByTopicNameAndTopicId(topicId, topicName);
                        mReportService.deleteReport(report.getId());
                        return BaseResponse.generateSuccess("处理成功，该回复已删除");
                    }
                }
            }
        }

        return BaseResponse.generateFail("操作失败");
    }
}
