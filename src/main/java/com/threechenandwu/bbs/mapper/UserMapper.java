package com.threechenandwu.bbs.mapper;

import com.threechenandwu.bbs.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryAllUser();
}
