package com.hnu.bbs.service;

import com.hnu.bbs.entity.Article;
import com.hnu.bbs.entity.Article_NickName;

import java.util.List;

public interface ArticleService {

    /**
     *
     * @param userId 创建文章的用户ID
     * @param title 标题
     * @param content 内容
     * @return Boolean
     */
    Boolean addArticle(Integer userId,String title,String content);


    /**
     *
     * @return List<Article>
     */
    List<Article> queryAllArticle();


    /**
     *
     * @return List<Article_NickName>
     */
    List<Article_NickName> queryAllArticleAndNickName();


    /**
     *
     * @param curPage 当前页
     * @param pageSize 页大小
     * @return   List<Article>
     */
    List<Article> queryByCurPage(Integer curPage,Integer pageSize);


    /**
     *
     * @param curPage 当前页
     * @param pageSize 页大小
     * @return List<Article_NickName>
     */
    List<Article_NickName> queryArticleAndNickNameByCurPage(Integer curPage,Integer pageSize);


    /**
     *
     * @param keyWord 关键字
     * @return List<Article_NickName>
     */
    List<Article_NickName> queryByKeyWord(String keyWord);


    /**
     *
     * @param userId 用户ID
     * @return List<Article>
     */
    List<Article> queryAllArticleByUserId(int userId);

    /**
     *
     * @param articleId 文章ID
     * @return Article
     */
    Article queryByArticleId(Integer articleId);


    /**
     *
     * @return Integer
     */
    Integer queryCountOfAll();


    /**
     *
     * @param articleId 需要删除的文章的ID
     * @return Boolean
     */
    Boolean removeByArticleId(Integer articleId);

    /**
     *
     * @param articleId 需要修改内容的文章的ID
     * @param newContent 新的内容
     * @return Boolean
     */
    Boolean modifyContent(Integer articleId,String newContent);

    /**
     *
     * @param articleId 需要修改标题的文章ID
     * @param newTitle 新的标题
     * @return Boolean
     */
    Boolean modifyTitle(Integer articleId,String newTitle);

    /**
     *
     * @param articleId 需要点赞的文章ID
     * @return Boolean
     */
    Boolean increaseLikesNum(Integer articleId);

    /**
     *
     * @param articleId 需要取消点赞的文章ID
     * @return Boolean
     */
    Boolean decreaseLikesNum(Integer articleId);

    /**
     *
     * @param articleId  需要点踩的文章ID
     * @return Boolean
     */
    Boolean increaseDislikesNum(Integer articleId);

    /**
     *
     * @param articleId 需要取消踩的文章ID
     * @return Boolean
     */
    Boolean decreaseDislikesNum(Integer articleId);

    /**
     *
     * @param articleId 需要修改点赞数的文章ID
     * @param likesNumm 新的点赞数
     * @return Boolean
     */
    Boolean modifyLikesNum(Integer articleId,Integer likesNumm);

    /**
     *
     * @param articleId 需要修改点踩数的文章ID
     * @param disLikesNum 新的点踩数
     * @return Boolean
     */
    Boolean modifyDisLikesNum(Integer articleId,Integer disLikesNum);


}

