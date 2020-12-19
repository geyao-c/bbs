package com.hnu.bbs.entity;

import java.util.Date;

public class Article_NickName {

    private Integer articleId;

    private Integer userId;

    private Date createTime;

    private Integer likesNum;

    private Integer dislikesNum;

    private String title;

    private String nickName;

    public Article_NickName(Article article,String nickName){
        this.articleId = article.getArticleId();
        this.userId = article.getUserId();
        this.createTime = article.getCreateTime();
        this.likesNum = article.getLikesNum();
        this.dislikesNum = article.getDislikesNum();
        this.title = article.getTitle();
        this.nickName = nickName;
    }


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(Integer likesNum) {
        this.likesNum = likesNum;
    }

    public Integer getDislikesNum() {
        return dislikesNum;
    }

    public void setDislikesNum(Integer dislikesNum) {
        this.dislikesNum = dislikesNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
