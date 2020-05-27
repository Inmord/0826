package com.ssm.service;

import com.ssm.entity.IUser;

public interface IUserService {
	IUser selectUser(String userName,String passWord) throws Exception;

	int selectUserCount(String userName) throws Exception;

	void insertUser(String userName,String passWord) throws Exception;
}
