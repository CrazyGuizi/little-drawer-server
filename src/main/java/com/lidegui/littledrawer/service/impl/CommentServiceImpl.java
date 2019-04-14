package com.lidegui.littledrawer.service.impl;

import com.lidegui.littledrawer.bean.Comment;
import com.lidegui.littledrawer.dao.CommentDao;
import com.lidegui.littledrawer.service.CommentService;
import com.lidegui.littledrawer.util.TopicEnum;
import com.lidegui.littledrawer.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 19:33 2019/4/14
 */

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao mCommentDao;


    @Override
    public Comment addComment(Comment comment) {
        if (mCommentDao.insert(comment) > 0) {
            return mCommentDao.findCommentById(comment.getId());
        }

        return null;
    }

    @Override
    public int deleteComment(int commentId) {
        return mCommentDao.updateCommentContent(commentId);
    }

    @Override
    public Comment updateComment(Comment comment) {
        if (mCommentDao.updateComment(comment) > 0) {
            return mCommentDao.findCommentById(comment.getId());
        }
        return null;
    }

    @Override
    public Comment getCommentById(int id) {
        return mCommentDao.findCommentById(id);
    }

    @Override
    public List<Comment> getCommentsByTopic(int topicType, int topicId) {
        List<Comment> list = null;
        TopicEnum topicEnum = Util.getTopic(topicType);
        if (topicEnum != null) {
            switch (topicEnum) {
                case NEWS:
                    list = mCommentDao.findNewsCommentsByNewsId(topicId);
                    break;
                case VIDEO:
                    list = mCommentDao.findVideoCommentsByNewsId(topicId);
                    break;
                case PICTURE:
                    break;
            }
        }

        return list;
    }

    @Override
    public List<Comment> getCommentsByUserId(int userId) {
        return mCommentDao.findCommentsByUserId(userId);
    }

    @Override
    public List<Comment> getAllComments() {
        return mCommentDao.findAllComments();
    }

    @Override
    public List<Comment> searchComments(String key) {
        return null;
    }
}
