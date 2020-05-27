package com.ssm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssm.entity.IWords;
import tk.mybatis.mapper.common.BaseMapper;

public interface IWordsDao extends BaseMapper {
	ArrayList<IWords> findAllWords() throws Exception;

	void insertWords(String userName ,String words,String isResponse,String look,String createDate) throws Exception;

	void insertResponseWords(String userName,String value,String look,String createDate);

	int selectWordsCount() throws Exception;

	String selectUserByWordsId(String wordsId);
}
