package com.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.IUserDao;
import com.ssm.entity.IUser;
import com.ssm.service.IUserService;

@Service("IUserService")
public class IUserServiceIml implements IUserService{

	@Resource
	private IUserDao iUserDao;
	
	/**
	 * 查询用户
	 */
	@Override
	public IUser selectUser(String userName,String passWord) throws Exception {
		try {
            return iUserDao.selectUser(userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public void insertUser(String userName, String passWord) throws Exception {
		try {
            iUserDao.insertUser(userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public int selectUserCount(String userName) throws Exception {
		return iUserDao.selectUserCount(userName);
	}
}
