package com.hnu.bbs.controller;

import com.hnu.bbs.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "User 用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @ApiOperation(value = "根据用户名、用户密码,注册用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userPassword", value = "用户密码", required = true, dataType = "String")
    })
    @PostMapping("/addUser")
    public Map addUser(@RequestParam(value = "userName")String userName ,
                       @RequestParam(value = "userPassword" )String userPassword ){
        Map<String,Object> map = new HashMap<>();
        map.put( "status", userService.addUserSimply(userName,userPassword) );
        return map;
    }


    @ApiOperation(value = "根据用户名、密码验证登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userPassword", value = "用户密码", required = true, dataType = "String")
    })
    @PostMapping("/verifyLogin")
    public Map verifyLogin(@RequestParam(value = "userName")String userName ,
                           @RequestParam(value = "userPassword" )String userPassword){
        Map<String,Object> map = new HashMap<>();
        map.put( "success", userService.vertifyLogin(userName,userPassword) );
        return map;
    }


    @ApiOperation(value = "根据用户名查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String")
    })
    @GetMapping("/queryUserByUserName")
    public Map queryUserByUserName(@RequestParam(value = "userName") String userName){
        Map<String,Object> map = new HashMap<>();
        map.put("user",userService.queryUserByUserName(userName));
        return map;
    }


    @ApiOperation(value = "根据当前页数，返回pageSize个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "int")
    })
    @GetMapping("/queryByCurrentPage")
    public Map queryByCurrentPage(@RequestParam(value = "currentPage") Integer currentPage,
                                  @RequestParam(value = "pageSize") Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        map.put("users",userService.queryByCurPage(currentPage,pageSize));
        return map;
    }



    @ApiOperation(value = "根据用户名查询用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String")
    })
    @GetMapping("/queryPasswordByUserName")
    public Map queryPasswordByUserName(@RequestParam(value = "userName") String userName){
        Map<String,Object> map = new HashMap<>();
        map.put("password",userService.queryPasswordByUserName(userName));
        return map;
    }


    @ApiOperation(value = "查询用户总数")
    @GetMapping("/queryUsersCount")
    public Map queryUsersCount(){
        Map<String,Object> map = new HashMap<>();
        map.put("usersCount",userService.queryCountOfAll());
        return map;
    }


    @ApiOperation(value = "查询所有用户记录")
    @GetMapping("/queryAll")
    public Map queryAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("users",userService.queryAll());
        return map;
    }



    @ApiOperation(value = "根据用户ID查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int")
    })
    @GetMapping("/queryUserById")
    public Map queryUserById(@RequestParam(value = "userId") Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("user",userService.queryUserById(userId));
        return map;
    }

    @ApiOperation(value = "根据用户ID，修改指定用户的个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "需要修改信息的用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "newGender", value = "新的用户性别", required = true, dataType = "int"),
            @ApiImplicitParam(name = "newSelfInfo", value = "新个人简介", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newFace", value = "新头像地址", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newNickName", value = "新昵称", required = true, dataType = "String")
    })
    @PostMapping("/modifyUserInformationById")
    public Map modifyUserInformationById(@RequestParam(value = "userId") Integer userId,
                                         @RequestParam(value = "newGender") Integer newGender,
                                         @RequestParam(value = "newSelfInfo") String newSelfInfo,
                                         @RequestParam(value = "newFace") String newFace,
                                         @RequestParam(value = "newNickName") String newNickName){
        Map<String,Object> map = new HashMap<>();
        map.put("success",userService.modifyUserInformationById(userId,newGender,newSelfInfo,newFace,newNickName));
        return map;
    }


    @ApiOperation(value = "根据用户ID、旧密码、新密码,修改用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    @PostMapping("/modifyPassword")
    public Map modifyPassword(@RequestParam(value = "userId") Integer userId,
                              @RequestParam(value = "oldPassword" )String oldPassword,
                              @RequestParam(value = "newPassword") String newPassword){
        Map<String,Object> map = new HashMap<>();
        map.put("success",userService.modifyPassword(userId,oldPassword,newPassword));
        return map;
    }


    @ApiOperation(value = "根据用户ID修改用户昵称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "newNickName", value = "新昵称", required = true, dataType = "String")
    })
    @PostMapping("/modifyNickName")
    public Map modifyNickName(@RequestParam(value = "userId") Integer userId,
                              @RequestParam(value = "newNickName") String newNickName){
        Map<String,Object> map = new HashMap<>();
        map.put("success",userService.modifyNickName(userId,newNickName));
        return map;
    }



    @ApiOperation(value = "根据用户ID修改用户性别")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "newGender", value = "新性别（0：女，1：男）", required = true, dataType = "int")
    })
    @PostMapping("/modifyGender")
    public Map modifyGender(@RequestParam(value = "userId") Integer userId,
                            @RequestParam(value = "newGender") Integer newGender){
        Map<String,Object> map = new HashMap<>();
        map.put("success",userService.modifyGender(userId,newGender));
        return map;
    }



    @ApiOperation(value = "根据用户ID修改用户简介")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "newSelfInfo", value = "简介", required = true, dataType = "String")
    })
    @PostMapping("/modifySelfInfo")
    public Map modifySelfInfo(@RequestParam(value = "userId") Integer userId,
                              @RequestParam(value = "newSelfInfo") String newSelfInfo){
        Map<String,Object> map = new HashMap<>();
        map.put("success",userService.modifySelfInfo(userId,newSelfInfo));
        return map;
    }



    @ApiOperation(value = "根据用户ID修改用户粉丝数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "newFansNum", value = "新的粉丝数", required = true, dataType = "int")
    })
    @PostMapping("/modifyFansNum")
    public Map modifyFansNum(@RequestParam(value = "userId") Integer userId,
                             @RequestParam(value = "newFansNum") Integer newFansNum){
        Map<String,Object> map = new HashMap<>();
        map.put("success",userService.modifyFansNum(userId,newFansNum));
        return map;
    }


    @ApiOperation(value = "根据用户ID修改用户头像地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "newUserFace", value = "新的头像地址", required = true, dataType = "String")
    })
    @PostMapping("/modifyUserFace")
    public Map modifyUserFace(@RequestParam(value = "userId") Integer userId,
                              @RequestParam(value = "newUserFace") String newUserFace){
        Map<String,Object> map = new HashMap<>();
        map.put("success",userService.modifyUserFace(userId,newUserFace));
        return map;
    }


    @ApiOperation(value = "根据用户ID,删除指定用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int")
    })
    @PostMapping("/removeUserById")
    public Map removeUserById(@RequestParam(value = "userId") Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("success",userService.removeUserById(userId));
        return map;
    }
}
