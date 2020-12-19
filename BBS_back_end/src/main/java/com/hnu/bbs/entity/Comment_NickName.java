package com.hnu.bbs.entity;

import java.util.Date;

public class Comment_NickName {

    private Integer commentId;

    private Integer articleId;

    private String nickName;

    private Date time;

    private String content;

    public Comment_NickName(Comment comment,String nickName){
        this.commentId = comment.getCommentId();
        this.articleId = comment.getArticleId();
        this.nickName = nickName;
        this.time = comment.getTime();
        this.content = comment.getContent();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
