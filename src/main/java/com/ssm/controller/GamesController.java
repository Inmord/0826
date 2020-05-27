package com.ssm.controller;

import com.ssm.Pojo.ResponseData;
import com.ssm.entity.IGames;
import com.ssm.entity.IUser;
import com.ssm.service.IGameService;
import com.ssm.utils.CONST;
import com.ssm.utils.STATIC_CONST;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GamesController {

    @Resource
    private IGameService iGameService;

    String GAMENAME_ZHH = "zhonghuahua";
    int MAX_VERSION = 5;

    /**
     * 花增加成长值
     * @param request
     * @return
     */
    @RequestMapping("/addFlowerValue")
    @ResponseBody
    public ResponseData addFlowerValue(HttpServletRequest request){
        //获取成长值
        int growthValue = Integer.parseInt(request.getParameter("growthValue"));
        String userName = ((IUser)request.getSession().getAttribute("iUser")).getUserName();

        //浇水、校验成长值及次数限制
        if (growthValue == (iGameService.getFlowerValue(GAMENAME_ZHH))
                && (Integer.parseInt(iGameService.selectVersion(userName,GAMENAME_ZHH)))<MAX_VERSION){
            //前端后端校验成功
            growthValue = growthValue + 10;
            iGameService.addFlowerValue(growthValue,GAMENAME_ZHH);
            //浇水次数+1
            iGameService.updateVersion(userName,GAMENAME_ZHH);
        }else {
            ResponseData responseData = new ResponseData("403",new ArrayList<IGames>());
            responseData.setMessage(STATIC_CONST.CONST_NO_OK);
            return responseData;
        }
        ResponseData responseData = new ResponseData("200",new ArrayList<IGames>());
        responseData.setMessage(STATIC_CONST.CONST_OK);
        return responseData;
    }

    /**
     * 获取花的最新成长值
     * @return
     */
    @RequestMapping("/getFlowerValue")
    @ResponseBody
    public ResponseData getFlowerValue(HttpServletRequest request){
        //判断是否为新用户
        String userName = ((IUser)request.getSession().getAttribute("iUser")).getUserName();
        List<IGames> userNameList = iGameService.selectUserName(GAMENAME_ZHH);
        //获取游戏表中的用户名判断是否存在
        for (int i = 0 ;i < userNameList.size() ; i++){
            if (userName.equals(userNameList.get(i).getUserName())){//一旦比对成功则用户已存在，立即终止循环判断
                break;
            }else {
                if (i == (userNameList.size()-1)){
                    //全部遍历完仍不存在
                    //新增一个玩家
                    iGameService.insertUserName(userName,GAMENAME_ZHH);
                }
            }
        }

        //获取成长值
        List list = new ArrayList();
        int flowerValue = iGameService.getFlowerValue(GAMENAME_ZHH);
        list.add(flowerValue);

        //判断花长了多大
        int index = 0;
        if (flowerValue<100){
            list.add(index);
        }else if (flowerValue >=100 && flowerValue <500){
            index = 1;
            list.add(index);
        }else if (flowerValue >=500 && flowerValue < 1000){
            index = 2;
            list.add(index);
        }else {
            index = 3;
            list.add(index);
        }
        ResponseData responseData = new ResponseData("200",list);
        responseData.setMessage("调用成功");
        return responseData;
    }

}
