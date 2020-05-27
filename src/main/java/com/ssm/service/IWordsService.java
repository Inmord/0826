package com.ssm.service;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.IWords;
import tk.mybatis.mapper.common.base.BaseSelectMapper;

public interface IWordsService {
	void insertWords(String userName,String words,String isResponse,String look) throws Exception;

	void insertResponseWords(String wordsId,String value,String userName);

	ArrayList<IWords> findAllWords(int page, int pageSize) throws Exception;

	int selectWordsCount() throws Exception;

	String selectUserByWordsId(String wordsId);
}
