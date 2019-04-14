package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.Reply;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 19:18 2019/4/14
 */
public interface ReplyDao {

    public int insert(Reply reply);

    public int deleteById(int replyId);

    public int updateReply(Reply reply);

    public int updateReplyContent(int replyId);

    public Reply findReplyById(int replyId);

    public List<Reply> findAllReplys();

    public List<Reply> findReplysByUserId(int userId);

    public List<Reply> findReplysByCommentId(int commentId);
}
