package com.hnu.bbs.service.impl;

import com.hnu.bbs.dao.AttentionMapper;
import com.hnu.bbs.dao.UserMapper;
import com.hnu.bbs.entity.Attention;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private AttentionMapper attentionMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param authorId 被关注者(作者)ID
     * @param userId 用户ID
     * @return Boolean
     */
    @Override
    public Boolean addAttention(Integer authorId, Integer userId) {
        Attention attention = new Attention();
        attention.setAuthorId(authorId);
        attention.setUserId(userId);
        User author = userMapper.selectUserById(authorId);
        author.setUserFans(author.getUserFans()==null? 1:author.getUserFans()+1);
        userMapper.updateFansNum(author);
        if( attentionMapper.insert(attention) == 1) return true;
        else return false;
    }

    /**
     *
     * @param authorId 被关注者(作者)ID
     * @param userId 用户ID
     * @return Boolean
     */
    @Override
    public Boolean queryAttetionOrNot(Integer authorId, Integer userId) {
        List<Integer> authorsList = queryAllByUserId(userId);
        for(Integer id : authorsList){
            if(id == authorId)
                return true;
        }
        return false;
    }

    /**
     *
     * @param userId 用户ID
     * @return List<User>
     */
    @Override
    public List<Integer> queryAllByUserId(int userId) {

        return attentionMapper.selectAllByUserId(userId);
    }

    /**
     *
     * @param authorId 被关注者（作者）ID
     * @return List<User>
     */
    @Override
    public List<User> queryAllByAuthorId(int authorId) {
        List<User> usersList = new ArrayList<>();
        for( Integer id : attentionMapper.selectAllByUserId(authorId) )
            usersList.add(userMapper.selectUserById(id));
        return usersList;
    }

    /**
     *
     * @param userId 用户ID
     * @param authorId 作者ID
     * @return Boolean
     */
    @Override
    public Boolean deleteByUserIdAndAuthorId(int userId, int authorId) {
        Attention attention = new Attention();
        attention.setAuthorId(authorId);
        attention.setUserId(userId);
        User author = userMapper.selectUserById(authorId);
        author.setUserFans(author.getUserFans() - 1);
        userMapper.updateFansNum(author);
        if( attentionMapper.deleteByUserIdAndAuthorId(attention) == 1) return true;
        else return false;
    }

    /**
     *
     * @return List<Attention>
     */
    @Override
    public List<Attention> queryAll() {
        return attentionMapper.selectAll();
    }
}
