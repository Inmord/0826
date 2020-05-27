package com.ssm.controller;

import com.ssm.entity.IUser;
import com.ssm.utils.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RedirectController {

    //---------------------------------跳转控制器--------------------------------------
    @RequestMapping("happy")
    public String happy(HttpServletRequest request){
        IUser iUser =(IUser) request.getSession().getAttribute("iUser");
        if (iUser != null){
            request.getSession().setAttribute("iUser",iUser);
            request.getSession().setAttribute("userName", iUser.getUserName());
            request.getSession().setAttribute("quitStr",Parameters.quitStr);
        }
        return "happy";
    }

    /**
     * 跳转至个人信息页面
     * @param request
     * @return
     */
    @RequestMapping("/myInfo")
    public String myInfo(HttpServletRequest request){
        IUser iUser =(IUser) request.getSession().getAttribute("iUser");
        if (iUser != null){
            request.getSession().setAttribute("iUser",iUser);
            request.getSession().setAttribute("userName", iUser.getUserName());
            request.getSession().setAttribute("quitStr",Parameters.quitStr);
        }
        return "user";
    }

    /**
     * 跳转至注册页
     * @return
     */
    @RequestMapping("/re")
    public String register(HttpServletRequest request) {
        IUser iUser =(IUser) request.getSession().getAttribute("iUser");
        if (iUser != null){
            request.getSession().setAttribute("iUser",iUser);
            request.getSession().setAttribute("userName", iUser.getUserName());
            request.getSession().setAttribute("quitStr", Parameters.quitStr);
        }
        return "register";
    }

    /**
     * 跳转至“魔塔游戏”页
     * @return
     */
    @RequestMapping("/mota")
    public String mota() {
        return "mota";
    }

    /**
     * 跳转至“足迹”页
     * @return
     */
    @RequestMapping("/zj")
    public String amap() {
        return "amap";
    }

    /**
     * 跳转至“时光影集”页
     * @return
     */
    @RequestMapping("/sg")
    public String time() {
        return "time";
    }

    /**
     * 跳转至“找不同”游戏页
     * @return
     */
    @RequestMapping("/zxt")
    public String zxt() {
        return "zhaoxiangtong";
    }

    /**
     * 跳转至“蜘蛛纸牌”游戏页
     * @return
     */
    @RequestMapping("/zz")
    public String zz() {
        return "zhizhuzhipai";
    }

    /**
     * 跳转至“天天裤跑”游戏页
     * @return
     */
    @RequestMapping("/pk")
    public String pk() {
        return "tiantiankupao";
    }

    /**
     * 跳转至“连连看看”游戏页
     * @return
     */
    @RequestMapping("/llk")
    public String lianliankan() {
        return "lianliankan";
    }

    /**
     * 跳转至“泡泡龙”游戏页
     * @return
     */
    @RequestMapping("/ppl")
    public String paopaolong() {
        return "paopaolong";
    }

    /**
     * 跳转至“射击鸭子”游戏页
     * @return
     */
    @RequestMapping("/sj")
    public String shejiyazi() {
        return "shejiyazi";
    }

    /**
     * 跳转至“种花花”页
     * @return
     */
    @RequestMapping("/zhh")
    public String zhonghuahua() {
        return "zhonghuahua";
    }

}
