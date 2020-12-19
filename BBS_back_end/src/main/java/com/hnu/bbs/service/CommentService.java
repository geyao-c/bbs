package com.hnu.bbs.service;


import com.hnu.bbs.entity.Comment;
import com.hnu.bbs.entity.Comment_NickName;

import java.util.List;

public interface CommentService {

    /**
     *
     * @param userId 用户ID
     * @param articleId 文章ID
     * @param content 内容
     * @return Boolean
     */
    Boolean addComment(Integer userId,Integer articleId, String content);

    /**
     *
     * @param articleId 文章ID
     * @return List<Comment>
     */
    List<Comment_NickName> queryByArticleId(Integer articleId);


    /**
     *
     * @param userId 用户ID
     * @return List<Comment>
     */
    List<Comment> querytByUserId(Integer userId);

    /**
     *
     * @return List<Comment>
     */
    List<Comment> queryAll();

    /**
     *
     * @param commentID 评论的ID
     * @return Boolean
     */
    Boolean removeCommentByCommentId(Integer commentID);
}
