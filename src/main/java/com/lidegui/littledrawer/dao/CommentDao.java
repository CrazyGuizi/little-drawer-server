package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.Comment;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 18:46 2019/4/14
 */
public interface CommentDao {

    public int insert(Comment comment);

    public int deleteById(int commentId);

    public int updateComment(Comment comment);

    public int updateCommentContent(int commentId);

    public Comment findCommentById(int commentId);

    public List<Comment> findNewsCommentsByNewsId(int newsId);

    public List<Comment> findVideoCommentsByNewsId(int videoId);

    public List<Comment> findAllComments();

    public List<Comment> findCommentsByUserId(int userId);
    
}
