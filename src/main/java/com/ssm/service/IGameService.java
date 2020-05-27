package com.ssm.service;

import com.ssm.entity.IGames;

import java.util.List;

public interface IGameService {
    Integer getFlowerValue(String gameName);

    void addFlowerValue(Integer growthValue,String gameName);

    List<IGames> selectUserName(String gameName);

    void insertUserName(String userName,String gameName);

    String selectVersion(String userName,String gameName);

    void updateVersion(String userName,String gameName);

    void setGameVersionZero(String gameName);
}
