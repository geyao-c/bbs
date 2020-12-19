package com.hnu.bbs.dao;


import com.hnu.bbs.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    int insert(User user);

    String selectPasswordByUserName(String UserName);

    List<User> selectAll();

    List<User> selectByCurPageAndPageSize(Map<String,Object> data);

    Integer selectCountOfAll();

    int updateUserInformation(User user);

    int updatePassword(User user);

    int updateNickName(User user);

    int updateGender(User user);

    int updateSelfInfo(User user);

    int updateFansNum(User user);

    int updateUserFace(User user);

    User selectUserById(Integer userId);

    User selectUserByUserName(String userName);

    int deleteUserById(Integer userId);
}