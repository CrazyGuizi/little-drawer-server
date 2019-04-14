package com.lidegui.littledrawer.service.impl;

import com.alibaba.fastjson.JSON;
import com.lidegui.littledrawer.bean.Reply;
import com.lidegui.littledrawer.dao.ReplyDao;
import com.lidegui.littledrawer.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 20:21 2019/4/14
 */
@Service("ReplyService")
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao mReplyDao;

    @Override
    public Reply addReply(Reply reply) {
        System.out.println("插入前" + reply.getId());
        if (mReplyDao.insert(reply) > 0) {
            return mReplyDao.findReplyById(reply.getId());
        }
        return null;
    }

    @Override
    public int deleteReply(int replyId) {
        return mReplyDao.updateReplyContent(replyId);
    }

    @Override
    public List<Reply> getReplysByCommentId(int commentId) {
        return mReplyDao.findReplysByCommentId(commentId);
    }
}
