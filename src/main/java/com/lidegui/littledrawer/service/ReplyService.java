package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.Reply;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 20:20 2019/4/14
 */
public interface ReplyService {

    public Reply addReply(Reply reply);

    public int deleteReply(int replyId);

    public Reply getReplyById(int replyId);

    public List<Reply> getReplysByCommentId(int commentId);
}
