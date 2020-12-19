package com.hnu.bbs.entity;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userGender;

    private Integer userFans;

    private String userSelfinfo;

    private String userFace;

    private Integer userConcern;

    private String nickName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getUserFans() {
        return userFans;
    }

    public void setUserFans(Integer userFans) {
        this.userFans = userFans;
    }

    public String getUserSelfinfo() {
        return userSelfinfo;
    }

    public void setUserSelfinfo(String userSelfinfo) {
        this.userSelfinfo = userSelfinfo == null ? null : userSelfinfo.trim();
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace == null ? null : userFace.trim();
    }

    public Integer getUserConcern() {
        return userConcern;
    }

    public void setUserConcern(Integer userConcern) {
        this.userConcern = userConcern;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }
}