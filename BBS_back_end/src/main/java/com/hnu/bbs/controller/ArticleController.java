package com.hnu.bbs.controller;

import com.hnu.bbs.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "Article 文章接口")
@RestController
@RequestMapping("/article")
public class ArticleController {


    @Resource
    private ArticleService articleService;



    @ApiOperation(value = "添加文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, dataType = "String")
    })
    @PostMapping(value = "/addArticle")
    public Map addArticle(@RequestParam(value = "userId") Integer userId,
                          @RequestParam(value = "title") String title,
                          @RequestParam(value = "content") String content){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleService.addArticle(userId,title,content) );
        return map;
    }


    @ApiOperation(value = "查询所有文章")
    @GetMapping("queryAll")
    public Map queryAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("articles",articleService.queryAllArticleAndNickName() );
        return map;
    }


    @ApiOperation(value = "根据当前页数，返回指定数量的文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "int")
            })
    @GetMapping("/queryByCurrentPage")
    public Map queryByCurrentPage(@RequestParam(value = "currentPage") Integer currentPage,
                                  @RequestParam(value = "pageSize") Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        map.put("articles",articleService.queryArticleAndNickNameByCurPage(currentPage,pageSize));
        return map;
    }


    @ApiOperation(value = "根据关键字，查询文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyWord", value = "关键字", required = true, dataType = "String")
    })
    @GetMapping("/queryByKeyWord")
    public Map queryByKeyWord(@RequestParam(value = "keyWord") String keyWord){
        Map<String,Object> map = new HashMap<>();
        map.put("articles",articleService.queryByKeyWord(keyWord));
        return map;
    }



    @ApiOperation(value = "查询文章总数")
    @GetMapping("/queryArticlesCount")
    public Map queryArticlesCount(){
        Map<String,Object> map = new HashMap<>();
        map.put("articlesCount",articleService.queryCountOfAll());
        return map;
    }


    @ApiOperation(value = "根据用户ID，查询该用户的所有文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int")
    })
    @GetMapping("/queryAllByUserId")
    public Map queryAllByUserId(@RequestParam("userId") Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("articles",articleService.queryAllArticleByUserId(userId) );
        return map;
    }



    @ApiOperation(value = "根据文章ID，查询指定文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int")
    })
    @GetMapping("/queryByArticleId")
    public Map queryByArticleId(@RequestParam("articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("article",articleService.queryByArticleId(articleId) );
        return map;
    }



    @ApiOperation(value = "根据文章ID，删除指定文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int")
    })
    @PostMapping("/removeByArticleId")
    public Map removeByArticleId(@RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleService.removeByArticleId(articleId) );
        return map;
    }



    @ApiOperation(value = "根据文章ID，修改指定文章内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "newContent", value = "新的文章内容", required = true, dataType = "String")
            })
    @PostMapping("/modifyContent")
    public Map modifyContent(@RequestParam(value = "articleId") Integer articleId,
                             @RequestParam(value = "newContent") String newContent){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleService.modifyContent(articleId,newContent) );
        return map;
    }



    @ApiOperation(value = "根据文章ID，修改指定文章标题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "newTitle", value = "新的文章标题", required = true, dataType = "String")
    })
    @PostMapping("/modifyTitle")
    public Map modifyTitle(@RequestParam(value = "articleId") Integer articleId,
                           @RequestParam(value = "newTitle") String newTitle){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleService.modifyTitle(articleId,newTitle) );
        return map;
    }


    @ApiOperation(value = "根据文章ID，为指定文章点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int")
    })
    @PostMapping("/increaseLikesNum")
    public Map increaseLikesNum(@RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleService.increaseLikesNum(articleId) );
        return map;
    }


    @ApiOperation(value = "根据文章ID，为指定文章取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int")
    })
    @PostMapping("/decreaseLikesNum")
    public Map decreaseLikesNum(@RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleService.decreaseLikesNum(articleId) );
        return map;
    }


    @ApiOperation(value = "根据文章ID，为指定文章点踩")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int")
    })
    @PostMapping("/increaseDislikesNum")
    public Map increaseDislikesNum(@RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleService.increaseDislikesNum(articleId) );
        return map;
    }


    @ApiOperation(value = "根据文章ID，为指定文章取消点踩")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int")
    })
    @PostMapping("/decreaseDislikesNum")
    public Map decreaseDislikesNum(@RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleService.decreaseDislikesNum(articleId) );
        return map;
    }


    @ApiOperation(value = "根据文章ID，修改指定文章的点赞数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "likesNum", value = "新的点赞数", required = true, dataType = "int")
    })
    @PostMapping("/modifyLikesNum")
    public Map modifyLikesNum(@RequestParam(value = "articleId") Integer articleId,
                              @RequestParam(value = "likesNum")  Integer likesNum){
        Map<String,Object> map = new HashMap<>();
        map.put("success",articleService.modifyLikesNum(articleId,likesNum) );
        return map;
    }


    @ApiOperation(value = "根据文章ID，修改指定文章的点踩数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "disLikesNum", value = "新的点踩数", required = true, dataType = "int")
    })
   @PostMapping("/modifyDisLikesNum")
    public Map modifyDisLikesNum(@RequestParam(value = "articleId") Integer articleId,
                                 @RequestParam(value = "disLikesNum") Integer disLikesNum){
       Map<String,Object> map = new HashMap<>();
       map.put("success",articleService.modifyDisLikesNum(articleId,disLikesNum) );
       return map;
   }


}
