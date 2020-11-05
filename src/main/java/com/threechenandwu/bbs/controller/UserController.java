package com.threechenandwu.bbs.controller;

import com.threechenandwu.bbs.pojo.User;
import com.threechenandwu.bbs.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/queryAllUser")
    List<User> queryAllUser() {
        List<User> userList = userService.queryAllUser();
        return userList;
    }
}
