package com.hnu.bbs.service;


import com.hnu.bbs.entity.Article_NickName;

import java.util.List;

public interface ArticleCollectionService {
    /**
     *
     * @param userId 用户ID
     * @param articleId  文章ID
     * @return Boolean
     */
    Boolean addArticleCollection(Integer userId,Integer articleId);

    /**
     *
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return Boolean
     */
    Boolean queryCollectOrNot(Integer userId,Integer articleId);

    /**
     *
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return Boolean
     */
    Boolean removeArticleCollection(Integer userId,Integer articleId);

    /**
     *
     * @param userId 用户ID
     * @return List<Article_NickName>
     */
    List<Article_NickName> queryArticleCollectionByUserId(Integer userId);

    /**
     *
     * @return List<Article_NickName>
     */
    List<Article_NickName> queryAllArticleCollection();
}
