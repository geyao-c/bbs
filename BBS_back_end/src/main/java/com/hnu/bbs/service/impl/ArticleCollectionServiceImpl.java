package com.hnu.bbs.service.impl;

import com.hnu.bbs.dao.ArticleCollectionMapper;
import com.hnu.bbs.dao.ArticleMapper;
import com.hnu.bbs.dao.UserMapper;
import com.hnu.bbs.entity.Article;
import com.hnu.bbs.entity.ArticleCollection;
import com.hnu.bbs.entity.Article_NickName;
import com.hnu.bbs.service.ArticleCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ArticleCollectionServiceImpl implements ArticleCollectionService {

    @Autowired
    private ArticleCollectionMapper articleCollectionMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;
    /**
     *
     * @param userId 用户ID
     * @param articleId  文章ID
     * @return Boolean
     */
    @Override
    public Boolean addArticleCollection(Integer userId, Integer articleId) {
        ArticleCollection articleCollection = new ArticleCollection();
        articleCollection.setUserId(userId);
        articleCollection.setArticleId(articleId);
        if( articleCollectionMapper.insert(articleCollection) == 1 ) return true;
        else return false;
    }

    /**
     *
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return Boolean
     */
    @Override
    public Boolean queryCollectOrNot(Integer userId, Integer articleId) {
        List<Integer> articleIds = articleCollectionMapper.selectByUserId(userId);
        for(Integer i : articleIds){
            if(i == articleId) return true;
        }
        return false;
    }

    /**
     *
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return Boolean
     */
    @Override
    public Boolean removeArticleCollection(Integer userId, Integer articleId) {
        ArticleCollection articleCollection = new ArticleCollection();
        articleCollection.setArticleId(articleId);
        articleCollection.setUserId(userId);
        if( articleCollectionMapper.deleteByArticleCollection(articleCollection) == 1 ) return true;
        else return false;
    }

    /**
     *
     * @param userId 用户ID
     * @return List<Article_NickName>
     */
    @Override
    public List<Article_NickName> queryArticleCollectionByUserId(Integer userId) {
        List<Integer> articleIdList = articleCollectionMapper.selectByUserId(userId);
        List<Article_NickName> articlesList = new ArrayList<>();
        for( Integer articleId : articleIdList){
            Article article = articleMapper.selectByArticleId(articleId);
            articlesList.add(new Article_NickName(article,userMapper.selectUserById(article.getUserId()).getNickName()) );
        }
        return articlesList;
    }

    /**
     *
     * @return List<Article_NickName>
     */
    @Override
    public List<Article_NickName> queryAllArticleCollection() {
        List<Integer> articleIdList = articleCollectionMapper.selectAll();
        List<Article_NickName> articlesList = new LinkedList<>();
        for( Integer articleId : articleIdList){
            Article article = articleMapper.selectByArticleId(articleId);
            articlesList.add(new Article_NickName(article,userMapper.selectUserById(article.getUserId()).getNickName()) );
        }
        return articlesList;
    }
}
