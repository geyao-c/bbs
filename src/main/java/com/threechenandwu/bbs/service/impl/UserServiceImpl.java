package com.threechenandwu.bbs.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.threechenandwu.bbs.mapper.UserMapper;
import com.threechenandwu.bbs.pojo.User;
import com.threechenandwu.bbs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> queryAllUser() {
        List<User> userList = userMapper.queryAllUser();
        logger.info("[UserServiceImpl][queryAllUser] response: {}", JSON.toJSONString(userList));
        return userList;
    }
}
