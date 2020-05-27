package com.ssm.service.impl;

import com.ssm.dao.IGameDao;
import com.ssm.entity.IGames;
import com.ssm.service.IGameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("IGameService")
public class IGameServiceIml implements IGameService {

    @Resource
    private IGameDao iGameDao;

    @Override
    public Integer getFlowerValue(String gameName) {
        return iGameDao.getFlowerValue(gameName);
    }

    @Override
    public void addFlowerValue(Integer growthValue,String gameName) {
        iGameDao.addFlowerValue(growthValue,gameName);
    }

    @Override
    public List<IGames> selectUserName(String gameName) {
        return iGameDao.selectUserName(gameName);
    }

    @Override
    public void insertUserName(String userName, String gameName) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String createDate = df.format(new Date());
        iGameDao.insertUserName(userName,gameName,createDate);
    }

    @Override
    public String selectVersion(String userName, String gameName) {
        return iGameDao.selectVersion(userName,gameName);
    }

    @Override
    public void updateVersion(String userName, String gameName) {
        iGameDao.updateVersion(userName,gameName);
    }

    @Override
    public void setGameVersionZero(String gameName) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String createDate = df.format(new Date());
        iGameDao.setGameVersionZero(gameName,createDate);
    }
}
