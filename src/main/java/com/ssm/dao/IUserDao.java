package com.ssm.dao;


import java.util.List;

import com.ssm.entity.IUser;

public interface IUserDao {
    IUser selectUser(String userName,String passWord) throws Exception;

    void insertUser(String userName,String passWord) throws Exception;

    int selectUserCount(String userName);

//    List<IUser> findUserById();
}
