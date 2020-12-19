package com.hnu.bbs.service.impl;

import com.hnu.bbs.dao.ArticleMapper;
import com.hnu.bbs.dao.UserMapper;
import com.hnu.bbs.entity.Article;
import com.hnu.bbs.entity.Article_NickName;
import com.hnu.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;
    /**
     *
     * @param userId 创建文章的用户ID
     * @param title 标题
     * @param content 内容
     * @return Boolean
     */
    @Override
    public Boolean addArticle(Integer userId, String title, String content) {
        if(userId == null || title == null || content == null) return false;
        Article article = new Article();
        article.setUserId(userId);
        article.setContent(content);
        article.setTitle(title);
        article.setLikesNum(0);
        article.setDislikesNum(0);
        article.setCreateTime(new Date());
        if( articleMapper.insert(article) == 1) return true;
        else return false;
    }


    /**
     *
     * @return List<Article>
     */
    @Override
    public List<Article> queryAllArticle() {
        return articleMapper.selectAll();
    }

    /**
     *
     * @return List<Article_NickName>
     */
    @Override
    public List<Article_NickName> queryAllArticleAndNickName() {
        List<Article_NickName> article_nickNamesList = new ArrayList<>();
        for(Article article:queryAllArticle()){
            article_nickNamesList.add(new Article_NickName(article, userMapper.selectUserById(article.getUserId()).getNickName() ));
        }
        return article_nickNamesList;
    }


    /**
     *
     * @param curPage 当前页
     * @return List<Article>
     */
    @Override
    public List<Article> queryByCurPage(Integer curPage,Integer pageSize) {
        Map<String,Object> data = new HashMap<>();
        data.put("currIndex",(curPage-1)*pageSize);
        data.put("pageSize",pageSize);
        return articleMapper.selectByCurrentPage(data);
    }

    /**
     *
     * @param curPage 当前页
     * @param pageSize 页大小
     * @return List<Article_NickName>
     */
    @Override
    public List<Article_NickName> queryArticleAndNickNameByCurPage(Integer curPage, Integer pageSize) {
        List<Article_NickName> article_nickNamesList = new ArrayList<>();
        for(Article article:queryByCurPage(curPage,pageSize)){
            article_nickNamesList.add(new Article_NickName(article, userMapper.selectUserById(article.getUserId()).getNickName() ));
        }
        return article_nickNamesList;
    }

    /**
     *
     * @param keyWord 关键字
     * @return List<Article>
     */
    @Override
    public List<Article_NickName> queryByKeyWord(String keyWord) {

        List<Article_NickName> article_nickNameList = new ArrayList<>();
        for(Article article : articleMapper.selectByKeyWord(keyWord)){
            article_nickNameList.add(new Article_NickName(article,userMapper.selectUserById(article.getUserId()).getNickName()));
        }

        return article_nickNameList;
    }


    /**
     *
     * @param userId 用户ID
     * @return List<Article>
     */
    @Override
    public List<Article> queryAllArticleByUserId(int userId) {

        return articleMapper.selectAllByUserId(userId);
    }


    /**
     *
     * @param articleId 文章ID
     * @return Article
     */
    @Override
    public Article queryByArticleId(Integer articleId) {
        return articleMapper.selectByArticleId(articleId);
    }


    /**
     *
     * @return Integer
     */
    @Override
    public Integer queryCountOfAll() {
        return articleMapper.selectCountOfAll();
    }


    /**
     *
     * @param articleId 需要删除的文章的ID
     * @return Boolean
     */
    @Override
    public Boolean removeByArticleId(Integer articleId) {
        return articleMapper.deleteByArticleId(articleId) == 1;
    }

    /**
     *
     * @param articleId 需要修改内容的文章的ID
     * @param newContent 新的内容
     * @return Boolean
     */
    @Override
    public Boolean modifyContent(Integer articleId, String newContent) {
        Article article = new Article();
        article.setArticleId(articleId);
        article.setContent(newContent);
        return articleMapper.updateContent(article) == 1;
    }

    /**
     *
     * @param articleId 需要修改标题的文章ID
     * @param newTitle 新的标题
     * @return Boolean
     */
    @Override
    public Boolean modifyTitle(Integer articleId, String newTitle) {
        Article article = new Article();
        article.setArticleId(articleId);
        article.setTitle(newTitle);
        return articleMapper.updateTitle(article) == 1;
    }

    /**
     *
     * @param articleId 需要点赞的文章ID
     * @return Boolean
     */
    @Override
    public Boolean increaseLikesNum(Integer articleId) {
        Article article = articleMapper.selectByArticleId(articleId);
        article.setLikesNum(article.getLikesNum() + 1);
        return articleMapper.updateLikesNum(article) == 1;
    }

    /**
     *
     * @param articleId 需要取消点赞的文章ID
     * @return Boolean
     */
    @Override
    public Boolean decreaseLikesNum(Integer articleId) {
        Article article = articleMapper.selectByArticleId(articleId);
        article.setLikesNum(article.getLikesNum() - 1);
        return articleMapper.updateLikesNum(article) == 1;
    }

    /**
     *
     * @param articleId  需要点踩的文章ID
     * @return Boolean
     */
    @Override
    public Boolean increaseDislikesNum(Integer articleId) {
        Article article = articleMapper.selectByArticleId(articleId);
        article.setDislikesNum(article.getDislikesNum() + 1);
        return articleMapper.updateDisLikesNum(article) == 1;
    }

    /**
     *
     * @param articleId 需要取消踩的文章ID
     * @return Boolean
     */
    @Override
    public Boolean decreaseDislikesNum(Integer articleId) {
        Article article = articleMapper.selectByArticleId(articleId);
        article.setDislikesNum(article.getDislikesNum() - 1);
        return articleMapper.updateDisLikesNum(article) == 1;
    }

    /**
     *
     * @param articleId 需要修改点赞数的文章ID
     * @param likesNumm 新的点赞数
     * @return Boolean
     */
    @Override
    public Boolean modifyLikesNum(Integer articleId, Integer likesNumm) {
        Article article = articleMapper.selectByArticleId(articleId);
        article.setLikesNum(likesNumm);
        return articleMapper.updateLikesNum(article) == 1;
    }

    /**
     *
     * @param articleId 需要修改点踩数的文章ID
     * @param disLikesNum 新的点踩数
     * @return Boolean
     */
    @Override
    public Boolean modifyDisLikesNum(Integer articleId, Integer disLikesNum) {
        Article article = articleMapper.selectByArticleId(articleId);
        article.setDislikesNum(disLikesNum);
        return articleMapper.updateDisLikesNum(article) == 1;
    }
}
