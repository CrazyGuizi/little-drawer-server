package com.lidegui.littledrawer.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lidegui.littledrawer.bean.Comment;
import com.lidegui.littledrawer.bean.Reply;
import com.lidegui.littledrawer.dto.BaseResponse;
import com.lidegui.littledrawer.service.CommentService;
import com.lidegui.littledrawer.service.ReplyService;
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
@RequestMapping("api/common")
public class CommonController {

    @Autowired
    private CommentService mCommentService;

    @Autowired
    private ReplyService mReplyService;

/**************************************评论相关******************************************/
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public BaseResponse addComment (@RequestBody Comment comment) {
        if (comment != null) {
            comment.setDate(Util.getDateNow());
            Comment addComment = mCommentService.addComment(comment);
            if (addComment != null) {
                return BaseResponse.generateSuccess("评论成功", addComment);
            }

        }
        return BaseResponse.generateFail("评论失败");
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
    public BaseResponse deleteComment (@RequestBody Map<String, String> map) {
        String id = map.get("commentId");
        if (!Util.isEmpty(id)) {
            if (mCommentService.deleteComment(Integer.parseInt(id)) > 0) {
                return BaseResponse.generateSuccess("删除成功", null);
            }
        }

        return BaseResponse.generateFail("删除失败");
    }

     @RequestMapping(value = "/getCommentsByTopic", method = RequestMethod.POST)
    public BaseResponse getCommentsByTopic (@RequestBody Map<String, String> map) {
        String id = map.get("topicId");
        String type = map.get("topicType");
        if (!Util.isEmpty(id) && !Util.isEmpty(type)) {
            List<Comment> comments = mCommentService.getCommentsByTopic(Integer.parseInt(type), Integer.parseInt(id));

            if (comments != null && comments.size() > 0) {
                return BaseResponse.generateSuccess("获取评论成功", comments);
            }
        }

        return BaseResponse.generateFail("获取评论失败");
    }
/**************************************回复相关******************************************/
    @RequestMapping(value = "/addReply", method = RequestMethod.POST)
    public BaseResponse addReply (@RequestBody Reply reply) {
        if (reply != null) {
            reply.setDate(Util.getDateNow());
            Reply addReply = mReplyService.addReply(reply);
            if (addReply != null) {
                return BaseResponse.generateSuccess("回复成功", addReply);
            }

        }
        return BaseResponse.generateFail("回复失败");
    }

    @RequestMapping(value = "/deleteReply", method = RequestMethod.POST)
    public BaseResponse deleteReply (@RequestBody Map<String, String> map) {
        String id = map.get("replyId");
        if (!Util.isEmpty(id)) {
            if (mReplyService.deleteReply(Integer.parseInt(id)) > 0) {
                return BaseResponse.generateSuccess("删除成功", null);
            }
        }

        return BaseResponse.generateFail("删除失败");
    }

     @RequestMapping(value = "/getReplysByCommentId", method = RequestMethod.POST)
    public BaseResponse getReplysByCommentId (@RequestBody Map<String, String> map) {
        String id = map.get("commentId");
        if (!Util.isEmpty(id)) {
            List<Reply> replyList = mReplyService.getReplysByCommentId(Integer.parseInt(id));

            if (replyList != null && replyList.size() > 0) {
                return BaseResponse.generateSuccess("获取回复成功", replyList);
            }
        }

        return BaseResponse.generateFail("获取回复失败");
    }


}
