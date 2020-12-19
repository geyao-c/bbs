package com.hnu.bbs.service.impl;

import com.hnu.bbs.entity.Administrator;
import com.hnu.bbs.dao.AdministratorMapper;
import com.hnu.bbs.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;


    /**
     *
     * @return List<Administrator>
     */
    @Override
    public List<Administrator> queryAll() {

            return administratorMapper.selectAll();
    }


    /**
     *
     * @param loginName 账号
     * @param password 密码
     * @return Boolean
     */
    @Override
    public Boolean verifyLogin(String loginName, String password) {
        return administratorMapper.selectByLoginName(loginName).getLoginPasswd().equals(password);
    }


    /**
     *
     * @param administrator 需要添加的管理员
     * @return Boolean
     */
    @Override
    public Boolean addAdministrator(Administrator administrator) {
        try{
            if(administratorMapper.insert(administrator) == 1) return true;
            else return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


    /**
     *
     * @param id 根据id删除指定的管理员
     * @return Boolean
     */
    @Override
    public Boolean removeById(Integer id) {
        try{
            if(administratorMapper.deleteById(id) == 1) return true;
            else return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param loginName 登陆账号
     * @return Administrator
     */
    @Override
    public Administrator queryByLoginName(String loginName) {
        return administratorMapper.selectByLoginName(loginName);
    }

    /**
     *
     * @param loginName 登陆账号
     * @param oldLoginPassword 旧密码
     * @param newLoginPassword 新密码
     * @return Boolean
     */
    @Override
    public Boolean modifyPassword(String loginName,String oldLoginPassword, String newLoginPassword) {
        if( !administratorMapper.selectByLoginName(loginName).getLoginPasswd().equals(oldLoginPassword) ) return false;
        try {
            Administrator administrator = administratorMapper.selectByLoginName(loginName);
            if (administratorMapper.updatePasswdByName(administrator) == 1) return true;
            else return false;
        }catch (Exception e){
            return false;
        }

    }

    /**
     *
     * @param loginame login name
     * @return String
     */
    @Override
    public String queryPasswdByLoginName(String loginame) {
        try {
            return administratorMapper.selectByLoginName(loginame).getLoginPasswd();
        }catch (Exception e){
            return null;
        }
    }

    /**
     *
     * @param loginName 用户名
     * @param loginPasswd 密码
     * @return Boolean
     */
    @Override
    public Boolean login(String loginName, String loginPasswd) {
        try{
            if(administratorMapper.selectByLoginName(loginName).getLoginPasswd().equals(loginPasswd) ) return true;
        else return false;}
        catch (Exception e){
            return false;
        }
    }


}
