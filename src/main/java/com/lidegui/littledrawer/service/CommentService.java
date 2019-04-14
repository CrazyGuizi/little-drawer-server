package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.Comment;
import com.lidegui.littledrawer.util.TopicEnum;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 19:22 2019/4/14
 */
public interface CommentService {

    public Comment addComment(Comment comment);

    /**
     * 字面上虽然是删除，但实际是将评论的内容更新为“该评论已删除”
     * @param commentId
     * @return
     */
    public int deleteComment(int commentId);

    public Comment updateComment(Comment comment);

    public Comment getCommentById(int id);

    /**
     * 获取不同主题的评论，如新闻主题为0
     * @param topicType
     * @param topicId
     * @return
     */
    public List<Comment> getCommentsByTopic(int topicType, int topicId);

    public List<Comment> getCommentsByUserId(int userId);

    public List<Comment> getAllComments();

    public List<Comment> searchComments(String key);
}
