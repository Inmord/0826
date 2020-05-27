package com.ssm.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import com.ssm.dao.IWordsDao;
import com.ssm.entity.IWords;
import com.ssm.service.IWordsService;

@Service("IWordsService")
public class IWordsServiceIml implements IWordsService{

	@Resource
	private IWordsDao iWordsDao;
	
	/**
	 * 查询用户
	 */
	@Override
	public void insertWords(String userName,String words,String isResponse,String look) throws Exception {
		// TODO Auto-generated method stub
		//判断是否登录
		//插入数据库
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createDate = df.format(new Date());
		iWordsDao.insertWords(userName,words,isResponse,look,createDate);
	}
	
	/**
	 * 查询所有留言
	 */
	@Override
	public ArrayList<IWords> findAllWords(int page , int pageSize) throws Exception {
		PageHelper.startPage(page, pageSize);
		return iWordsDao.findAllWords();
	}

	/**
	 * 查询留言数量
	 * @return
	 * @throws Exception
	 */
	@Override
	public int selectWordsCount() throws Exception {
		return iWordsDao.selectWordsCount();
	}

	/**
	 * 留言回复
	 * @param userName
	 * @param value
	 */
	@Override
	public void insertResponseWords(String wordsId,String value,String userName) {
		//插入数据库
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createDate = df.format(new Date());
		iWordsDao.insertResponseWords(wordsId,value,userName,createDate);
	}

	@Override
	public String selectUserByWordsId(String wordsId) {
		return iWordsDao.selectUserByWordsId(wordsId);
	}
}
