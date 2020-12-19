package com.hnu.bbs.service;

import com.hnu.bbs.entity.Attention;
import com.hnu.bbs.entity.User;

import java.util.List;

public interface AttentionService {
    /**
     *
     * @param authorId 被关注者(作者)ID
     * @param userId 用户ID
     * @return Boolean
     */
    Boolean addAttention(Integer authorId,Integer userId);

    /**
     *
     * @param authorId 被关注者(作者)ID
     * @param userId 用户ID
     * @return Boolean
     */
    Boolean queryAttetionOrNot(Integer authorId,Integer userId);

    /**
     *
     * @param userId 用户ID
     * @return List<User> 该用户所关注的所有用户名
     */
    List<Integer> queryAllByUserId(int userId);

    /**
     *
     * @param authorId 被关注者（作者）ID
     * @return List<User>
     */
    List<User> queryAllByAuthorId(int authorId);

    /**
     *
     * @param userId 用户ID
     * @param authorId 作者ID
     * @return Boolean
     */
    Boolean deleteByUserIdAndAuthorId(int userId,int authorId);

    /**
     *
     * @return List<Attention>
     */
    List<Attention> queryAll();
}
