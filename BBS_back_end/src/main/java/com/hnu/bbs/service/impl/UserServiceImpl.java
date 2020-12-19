package com.hnu.bbs.service.impl;

import com.hnu.bbs.dao.UserMapper;
import com.hnu.bbs.entity.Article;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    /**
     *
     * @param userName 用户名
     * @param userPassword 用户密码
     * @return @return int 0：成功     1：用户名已存在    2：创建失败
     */
    @Override
    public int addUserSimply(String userName,String userPassword) {
        if(userMapper.selectUserByUserName(userName) != null) return 1;
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserFace("http://207.148.112.5/images/1.jpg");
        user.setUserGender(0);
        user.setNickName("未命名");
        user.setUserFans(0);
        user.setUserSelfinfo("此人很懒，什么都没留下.");
        if(userMapper.insert(user) == 1) return 0;
        else return 2;
    }

    /**
     *
     * @param userName 用户名
     * @param userPassword 用户密码
     * @return Boolean
     */
    @Override
    public Boolean vertifyLogin(String userName, String userPassword) {
        userMapper.selectPasswordByUserName(userName);
        return userMapper.selectUserByUserName(userName).getUserPassword().equals(userPassword);
    }


    /**
     *
     * @param articlesList 需要查询用户的文章
     * @return List<User>
     */
    @Override
    public List<User> queryByArticlesList(List<Article> articlesList) {
        List<User> usersList = new ArrayList<>();
        for(Article article : articlesList){
            usersList.add(userMapper.selectUserById(article.getUserId()));
        }
        return usersList;
    }


    /**
     *
     * @param userId 用户ID
     * @param newGender 用户性别
     * @param newSelfInfo 用户简介
     * @param newFace 用户头像
     * @param newNickName 昵称
     * @return Boolean
     */
    @Override
    public Boolean modifyUserInformationById(Integer userId,
                                             Integer newGender,
                                             String newSelfInfo,
                                             String newFace,
                                             String newNickName) {
        if(newGender != 0 && newGender != 1) return false;
        User user = userMapper.selectUserById(userId);
        user.setUserGender(newGender);
        user.setUserSelfinfo(newSelfInfo);
        user.setUserFace(newFace);
        user.setNickName(newNickName);
        try{
            if(userMapper.updateUserInformation(user) == 1) return true;
            else return false;
        }catch (Exception e){
            return false;
        }
    }


    /**
     *
     * @param userName 用户名
     * @return String
     */
    @Override
    public String queryPasswordByUserName(String userName) {
        return userMapper.selectPasswordByUserName(userName);
    }

    /**
     *
     * @return List<User>
     */
    @Override
    public List<User> queryAll() {
        return userMapper.selectAll();
    }


    /**
     *
     * @return Integer
     */
    @Override
    public Integer queryCountOfAll() {
        return userMapper.selectCountOfAll();
    }


    /**
     *
     * @param curPage 当前页
     * @param pageSize 页大小
     * @return List<User>
     */
    @Override
    public List<User> queryByCurPage(Integer curPage, Integer pageSize) {
        Map<String,Object> data = new HashMap<>();
        data.put("currIndex",(curPage-1)*pageSize);
        data.put("pageSize",pageSize);
        return userMapper.selectByCurPageAndPageSize(data);
    }


    /**
     *
     * @param userId 用户ID
     * @return User
     */
    @Override
    public User queryUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }


    /**
     *
     * @param userName 用户名
     * @return User
     */
    @Override
    public User queryUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }


    /**
     *
     * @param userId 用户ID
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return Boolean
     */
    @Override
    public Boolean modifyPassword(Integer userId, String oldPassword, String newPassword) {
        User user = userMapper.selectUserById(userId);
        if( !user.getUserPassword().equals(oldPassword) )return false;
        user.setUserPassword(newPassword);
        return userMapper.updatePassword(user) == 1;
    }


    /**
     * \
     * @param userId 需要修改昵称的用户ID
     * @return Boolean
     */
    @Override
    public Boolean modifyNickName(Integer userId,String newNickName) {
        User user = new User();
        user.setUserId(userId);
        user.setNickName(newNickName);
        return userMapper.updateNickName(user) == 1;
    }

    /**
     *
     * @param userId 需要修改性别的用户ID
     * @param newGender 新的性别
     * @return Boolean
     */
    @Override
    public Boolean modifyGender(Integer userId, int newGender) {
        User user = new User();
        user.setUserId(userId);
        user.setUserGender(newGender);
        return userMapper.updateGender(user) == 1;
    }

    /**
     *
     * @param userId 需要修改自我介绍的用户ID
     * @param newSelfInfo 新的自我介绍
     * @return Boolean
     */
    @Override
    public Boolean modifySelfInfo(Integer userId, String newSelfInfo) {
        User user = new User();
        user.setUserId(userId);
        user.setUserSelfinfo(newSelfInfo);
        return userMapper.updateSelfInfo(user) == 1;
    }

    /**
     *
     * @param userId 需要修改粉丝数的用户ID
     * @param newFansNum 新的粉丝数
     * @return Boolean
     */
    @Override
    public Boolean modifyFansNum(Integer userId, Integer newFansNum) {
        User user = new User();
        user.setUserId(userId);
        user.setUserFans(newFansNum);
        return userMapper.updateFansNum(user) == 1;
    }

    /**
     *
     * @param userId 需要修改头像的用户ID
     * @param newUserFace 新的头像的地址
     * @return Boolean
     */
    @Override
    public Boolean modifyUserFace(Integer userId, String newUserFace) {
        User user = new User();
        user.setUserId(userId);
        user.setUserFace(newUserFace);
        return userMapper.updateUserFace(user) == 1;

    }

    /**
     *
     * @param userId 需要删除的用户ID
     * @return Boolean
     */
    @Override
    public Boolean removeUserById(Integer userId) {
        try{
            return userMapper.deleteUserById(userId) == 1;
        }catch (Exception e){
            return false;
        }
    }


}
