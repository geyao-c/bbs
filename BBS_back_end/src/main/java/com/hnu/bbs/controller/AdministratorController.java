package com.hnu.bbs.controller;

import com.hnu.bbs.service.AdministratorService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "Administrator 管理员接口")
@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Resource
    private AdministratorService administratorService;


    @ApiOperation(value = "查询所有administrator")
    @GetMapping("/queryAll")
    public Map queryAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("administrators",administratorService.queryAll());
        return map;
    }

    @ApiOperation(value = "根据用户账号查询密码")
    @ApiImplicitParam(name = "loginName",value = "用户名", required = true)
    @GetMapping("/queryPasswordByLoginName")
    public Map queryById(@RequestParam(value = "loginName") String loginName){
        Map<String,Object> map = new HashMap<>();
        map.put("password",administratorService.queryPasswdByLoginName(loginName));
        return map;
    }


    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "loginPassword", value = "密码", required = true, dataType = "String")
    })
    @GetMapping("/login")
    public Map login(@RequestParam("loginName") String loginName,
                     @RequestParam("loginPassword") String loginPassword){
        Map<String,Object> map = new HashMap<>();
        map.put("success",administratorService.login(loginName,loginPassword) );
        return map;
    }

    @ApiOperation(value = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "oldLoginPassword", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newLoginPassword", value = "密码", required = true, dataType = "String")
    })
    @PostMapping("modifyPassword")
    public Map modifymodifyPasswordPasswd(@RequestParam("loginName") String loginName,
                            @RequestParam(value = "oldLoginPassword" ) String oldLoginPassword,
                            @RequestParam("newLoginPassword") String newLoginPassword){
        Map<String,Object> map = new HashMap<>();
        map.put("success",administratorService.modifyPassword(loginName,oldLoginPassword,newLoginPassword));
        return map;
    }

}
