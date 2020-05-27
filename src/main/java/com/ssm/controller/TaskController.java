package com.ssm.controller;

import com.ssm.service.IGameService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Component
public class TaskController {

    @Resource
    private IGameService iGameService;

    //0 0 7,14 1/1 * ?    每天7、14点执行0 0 7,14 * * ?
    @Scheduled(cron = "0 0 7,14 * * ?")
    public void setGameVersionZero(){
        //将浇水次数设为0
        iGameService.setGameVersionZero("zhonghuahua");
    }
}
