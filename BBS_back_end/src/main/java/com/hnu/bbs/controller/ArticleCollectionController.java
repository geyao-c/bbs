package com.hnu.bbs.controller;

import com.hnu.bbs.service.ArticleCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "ArticleCollection 收藏文章接口")
@RestController
@RequestMapping("/collection")
public class ArticleCollectionController {

    @Resource
    private ArticleCollectionService articleCollectionService;


    @ApiOperation(value = "添加收藏文章记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int"),
    })
    @PostMapping("/addArticleCollection")
    public Map addArticleCollection(@RequestParam(value = "userId") Integer userId,
                                    @RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleCollectionService.addArticleCollection(userId,articleId));
        return map;
    }


    @ApiOperation(value = "查看是否有收藏关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int"),
    })
    @GetMapping("/queryCollectOrNot")
    public Map queryCollectOrNot(@RequestParam(value = "userId") Integer userId,
                                    @RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("collect",articleCollectionService.queryCollectOrNot(userId,articleId));
        return map;
    }

    @ApiOperation(value = "删除收藏文章记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int"),
    })
    @PostMapping("/removeArticleCollection")
    public Map removeArticleCollection(@RequestParam(value = "userId") Integer userId,
                                       @RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleCollectionService.removeArticleCollection(userId,articleId));
        return map;
    }



    @ApiOperation(value = "根据用户ID，查询该用户收藏的所有文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
    })
    @GetMapping("/queryArticleCollectionByUserId")
    public Map queryArticleCollectionByUserId(@RequestParam(value = "userId") Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("collections",articleCollectionService.queryArticleCollectionByUserId(userId));
        return map;
    }



    @ApiOperation(value = "查询所有被收藏文章记录")
    @GetMapping("/queryAllArticleCollection")
    public Map queryAllArticleCollection(){
        Map<String,Object> map = new HashMap<>();
        map.put("collections",articleCollectionService.queryAllArticleCollection());
        return map;
    }


}
