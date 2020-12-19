package com.hnu.bbs.service;

import com.hnu.bbs.entity.Administrator;

import java.util.List;

public interface AdministratorService {

    /**
     * 查询所有 administrator
     * @return  List<Administrator>
     */
    List<Administrator> queryAll();

    /**
     *
     * @param loginName 账号
     * @param password 密码
     * @return  Boolean
     */
    Boolean verifyLogin(String loginName,String password);

    /**
     *
     * @param administrator 需要添加的管理员
     * @return Boolean
     */
    Boolean addAdministrator(Administrator administrator);

    /**
     *
     * @param id 根据id删除指定的管理员
     * @return Boolean
     */
    Boolean removeById(Integer id);

    /**
     *
     * @param loginName 登陆账号
     * @return Administrator
     */
    Administrator queryByLoginName(String loginName);

    /**
     *
     * @param loginName 登陆账号
     * @param oldLoginPassword 旧密码
     * @param loginPasswd 新密码
     * @return Boolean
     */
    Boolean modifyPassword(String loginName,String oldLoginPassword, String loginPasswd);

    /**
     *
     * @param loginame login name
     * @return String
     */
    String queryPasswdByLoginName(String loginame);

    /**
     *
     * @param loginName 用户名
     * @param loginPasswd 密码
     * @return Boolean
     */
    Boolean login(String loginName,String loginPasswd);
}
