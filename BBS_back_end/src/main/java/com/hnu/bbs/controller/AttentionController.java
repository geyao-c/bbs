package com.hnu.bbs.controller;

import com.hnu.bbs.service.AttentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "Attention 关注接口")
@RestController
@RequestMapping("/attention")
public class AttentionController {

    @Resource
    private AttentionService attentionService;


    @ApiOperation(value = "根据关注者ID，被关注者ID，添加新的关注记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorId", value = "被关注者ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "userId", value = "关注者ID", required = true, dataType = "int")
    })
    @PostMapping("/addAttention")
    public Map addAttention(@RequestParam(value = "authorId") Integer authorId,
                            @RequestParam(value = "userId") Integer userId){
        Map<String, Object> map = new HashMap<>();
        map.put("success",attentionService.addAttention(authorId,userId));
        return map;
    }


    @ApiOperation(value = "根据关注者ID，被关注者ID，添加新的关注记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorId", value = "被关注者ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "userId", value = "关注者ID", required = true, dataType = "int")
    })
    @GetMapping("/queryAttetionOrNot")
    public Map queryAttetionOrNot(@RequestParam(value = "authorId") Integer authorId,
                            @RequestParam(value = "userId") Integer userId){
        Map<String, Object> map = new HashMap<>();
        map.put("attention",attentionService.queryAttetionOrNot(authorId,userId));
        return map;
    }



    @ApiOperation(value = "根据用户ID，查询该用户关注了的所有用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int")
    })
    @GetMapping("/queryAllByUserId")
    public Map queryAllByUserId(@RequestParam(value = "userId") Integer userId){
        Map<String, Object> map = new HashMap<>();
        map.put("success",attentionService.queryAllByUserId(userId));
        return map;
    }



    @ApiOperation(value = "根据用户ID，查询关注了该用户的所有用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorId", value = "用户ID", required = true, dataType = "int")
    })
    @GetMapping("/queryAllByAuthorId")
    public Map queryAllByAuthorId(@RequestParam(value = "authorId") Integer authorId){
        Map<String, Object> map = new HashMap<>();
        map.put("success",attentionService.queryAllByAuthorId(authorId));
        return map;
    }



    @ApiOperation(value = "根据关注者ID，被关注者ID，删除指定的关注记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "关注者ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "authorId", value = "被关注者ID", required = true, dataType = "int")
    })
    @PostMapping("/deleteByUserIdAndAuthorId")
    public Map deleteByUserIdAndAuthorId(@RequestParam(value = "userId") Integer userId,
                                         @RequestParam(value = "authorId") Integer authorId){
        Map<String, Object> map = new HashMap<>();
        map.put("success",attentionService.deleteByUserIdAndAuthorId(userId,authorId));
        return map;
    }


    @ApiOperation(value = "查询所有关注记录")
    @GetMapping("/queryAll")
    public Map queryAll(){
        Map<String, Object> map = new HashMap<>();
        map.put("success",attentionService.queryAll());
        return map;
    }
}
