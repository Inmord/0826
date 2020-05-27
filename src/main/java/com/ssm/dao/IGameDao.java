package com.ssm.dao;

import com.ssm.entity.IGames;

import java.util.List;

public interface IGameDao {

    Integer getFlowerValue(String gameName);

    void addFlowerValue(Integer flowerValue,String gameName);

    List<IGames> selectUserName(String gameName);

    void insertUserName(String userName,String gameName,String createDate);

    String selectVersion(String userName,String gameName);

    void updateVersion(String userName,String gameName);

    void setGameVersionZero(String gameName,String createDate);
}
