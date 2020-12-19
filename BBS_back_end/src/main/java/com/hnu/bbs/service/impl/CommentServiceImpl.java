package com.hnu.bbs.service.impl;

import com.hnu.bbs.dao.CommentMapper;
import com.hnu.bbs.dao.UserMapper;
import com.hnu.bbs.entity.Comment;
import com.hnu.bbs.entity.Comment_NickName;
import com.hnu.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param userId 评论的用户ID
     * @param articleId 文章ID
     * @param content 评论内容
     * @return Boolean
     */
    @Override
    public Boolean addComment(Integer userId, Integer articleId,String content) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setArticleId(articleId);
        comment.setContent(content);
        comment.setTime(new Date());
        if(commentMapper.insert(comment) == 1) return true;
        else return false;
    }

    /**
     *
     * @param articleId 文章ID
     * @return List<Comment>
     */
    @Override
    public List<Comment_NickName> queryByArticleId(Integer articleId) {
        List<Comment_NickName> list = new ArrayList<>();
        List<Comment> comments = commentMapper.selectByArticleId(articleId);
        for(Comment comment : comments){
            list.add(new Comment_NickName(comment,userMapper.selectUserById(comment.getUserId()).getNickName()));
        }
        return list;
    }

    /**
     *
     * @param userId 用户ID
     * @return List<Comment>
     */
    @Override
    public List<Comment> querytByUserId(Integer userId) {
        return commentMapper.selectByUserId(userId);
    }

    /**
     *
     * @return List<Comment>
     */
    @Override
    public List<Comment> queryAll() {
        return commentMapper.selectAll();
    }

    /**
     *
     * @param commentID 评论的ID
     * @return Boolean
     */
    @Override
    public Boolean removeCommentByCommentId(Integer commentID) {
        if(commentMapper.deleteCommentByCommentId(commentID) == 1) return true;
        else return false;
    }
}
