package com.hnu.bbs.controller;

import com.hnu.bbs.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "Comment 评论接口")
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;


    @ApiOperation(value = "添加新的评论记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "content", value = "评论内容", required = true, dataType = "String")
    })
    @PostMapping("/addComment")
    public Map addComment(@RequestParam(value = "userId") Integer userId,
                          @RequestParam(value = "articleId") Integer articleId,
                          @RequestParam(value = "content") String content){
        Map<String,Object> map = new HashMap<>();
        map.put("success",commentService.addComment(userId,articleId,content));
        return map;
    }



    @ApiOperation(value = "根据文章ID，查询指定文章的所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int")
    })
    @GetMapping("/queryByArticleId")
    public Map queryByArticleId(@RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("comments",commentService.queryByArticleId(articleId));
        return map;
    }



    @ApiOperation(value = "根据用户ID，查询该用户的所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int")
    })
    @GetMapping("/querytByUserId")
    public Map querytByUserId(@RequestParam(value = "userId") Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("comments",commentService.querytByUserId(userId));
        return map;
    }


    @ApiOperation(value = "查询所有评论")
    @GetMapping("/queryAll")
    public Map queryAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("comments",commentService.queryAll());
        return map;
    }


    @ApiOperation(value = "根据评论ID，删除指定的评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentID", value = "评论ID", required = true, dataType = "int")
    })
    @PostMapping("/removeCommentByCommentId")
    public Map removeCommentByCommentId(@RequestParam(value = "commentID") Integer commentID){
        Map<String,Object> map = new HashMap<>();
        map.put("success",commentService.removeCommentByCommentId(commentID));
        return map;
    }

}
