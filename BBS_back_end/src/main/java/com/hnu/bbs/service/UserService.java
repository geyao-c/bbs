package com.hnu.bbs.service;

import com.hnu.bbs.entity.Article;
import com.hnu.bbs.entity.User;

import java.util.List;

public interface UserService {

    /**
     *
     * @param userName 用户名
     * @param userPassword 用户密码
     * @return int 0：成功     1：用户名已存在    2：创建失败
     */
    int addUserSimply(String userName, String userPassword );

    /**
     *
     * @param userName 用户名
     * @param userPassword 用户密码
     * @return Boolean
     */
    Boolean vertifyLogin(String userName,String userPassword);

    /**
     *
     * @param articlesList 需要查询用户的文章
     * @return  List<User>
     */
    List<User> queryByArticlesList(List<Article> articlesList);


    /**
     *
     * @param userName 用户名
     * @return String
     */
    String queryPasswordByUserName(String userName);

    /**
     *
     * @return List<User>
     */
    List<User> queryAll();

    /**
     *
     * @return Integer
     */
    Integer queryCountOfAll();

    /**
     *
     * @param curPage 当前页
     * @param pageSize 页大小
     * @return   List<Article>
     */
    List<User> queryByCurPage(Integer curPage, Integer pageSize);

    /**
     *
     * @param userId 用户ID
     * @return User
     */
    User queryUserById(Integer userId);

    /**
     *
     * @param userName 用户名
     * @return User
     */
    User queryUserByUserName(String userName);

    /**
     *
     * @param userId 用户ID
     * @param newGender 用户性别
     * @param newSelfInfo 用户简介
     * @param newFace 用户头像
     * @param newNickName 昵称
     * @return Boolean
     */
    Boolean modifyUserInformationById(
            Integer userId,
            Integer newGender,
            String newSelfInfo,
            String newFace,
            String newNickName
    );

    /**
     *
     * @param userId 需要修改密码的用户ID
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return Boolean
     */
    Boolean modifyPassword(Integer userId,String oldPassword,String newPassword);

    /**
     *
     * @param userId 需要修改昵称的用户ID
     * @param newNickName 新昵称
     * @return Boolean
     */
    Boolean modifyNickName(Integer userId,String newNickName);

    /**
     *
     * @param userId 需要修改性别的用户ID
     * @param newGender 新的性别
     * @return Boolean
     */
    Boolean modifyGender(Integer userId,int newGender);

    /**、
     *
     * @param userId 需要修改自我介绍的用户ID
     * @param newSelfInfo 新的自我介绍
     * @return Boolean
     */
    Boolean modifySelfInfo(Integer userId, String newSelfInfo);

    /**
     *
     * @param userId 需要修改粉丝数的用户ID
     * @param newFansNum 新的粉丝数
     * @return Boolean
     */
    Boolean modifyFansNum(Integer userId,Integer newFansNum);

    /**
     *
     * @param userId 需要修改头像的用户ID
     * @param newUserFace 新的头像的地址
     * @return Boolean
     */
    Boolean modifyUserFace(Integer userId, String newUserFace);

    /**
     *
     * @param userId 需要删除的用户ID
     * @return Boolean
     */
    Boolean removeUserById(Integer userId);
}
