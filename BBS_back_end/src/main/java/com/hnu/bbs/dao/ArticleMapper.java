package com.hnu.bbs.dao;


import com.hnu.bbs.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleMapper {

    int insert(Article article);

    Article selectByArticleId(Integer articleId);

    List<Article> selectAllByUserId(Integer userId);

    List<Article> selectAll();

    int deleteByArticleId(Integer articleId);

    int updateContent(Article article);

    int updateLikesNum(Article article);

    int updateDisLikesNum(Article article);

    int updateTitle(Article article);

    List<Article> selectByCurrentPage(Map<String,Object> data);

    Integer selectCountOfAll();

    List<Article> selectByKeyWord(String keyWord);
}