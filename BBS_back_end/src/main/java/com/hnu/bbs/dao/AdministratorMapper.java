package com.hnu.bbs.dao;


import com.hnu.bbs.entity.Administrator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorMapper {

    int insert(Administrator administrator);

    int deleteById(Integer id);

    List<Administrator> selectAll();

    Administrator selectByLoginName(String loginName);

    int updatePasswdByName(Administrator administrator);


}