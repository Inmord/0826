package com.ssm.controller;

import com.ssm.entity.IUser;
import com.ssm.entity.IWords;
import com.ssm.service.IWordsService;
import com.ssm.utils.CONST;
import com.ssm.utils.Parameters;
import com.ssm.utils.STATIC_CONST;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WordsController {


    @Resource
    private IWordsService iWordsService;
    //-------------------------------留言相关逻辑处理控制器-----------------------------------------

    /**
     * 回复留言
     * @param request
     * @return
     */
    @RequestMapping("/responseSomeone")
    @ResponseBody
    @Transactional
    public String responseSomeone(HttpServletRequest request){
        //当前登录的用户名，回复其他人
        String userName = ((IUser)request.getSession().getAttribute("iUser")).getUserName();
        String wordsId = request.getParameter("wordsid");
        String userNameBefore = iWordsService.selectUserByWordsId(wordsId);
        String value = "@" + userNameBefore + ":" + request.getParameter("v");
        if ("".equals(request.getParameter("v"))){
            return STATIC_CONST.CONST_NO_OK;
        }
        try {
            iWordsService.insertWords(userName,value,STATIC_CONST.CONST_1,STATIC_CONST.CONST_1);
            //向回复表中插入数据
//            iWordsService.insertResponseWords(wordsId,value,userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return STATIC_CONST.CONST_OK;
    }

    /**
     * 跳转至“留言板”页
     * @return
     * @throws Exception
     */
    @RequestMapping("/sh")
    public String word(HttpServletRequest request , Model model
            , @RequestParam(defaultValue = "1") int page) throws Exception {

        List<IWords> list = new ArrayList<IWords>();
        list = iWordsService.findAllWords(page, Parameters.pageSize);
        int wordsCount = iWordsService.selectWordsCount();
        int pageCount = 0;
        if(wordsCount%Parameters.pageSize == 0){
            pageCount = wordsCount/Parameters.pageSize;
        }else {
            pageCount = wordsCount/Parameters.pageSize+1;
        }
//		model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("wordsList",list);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("page",page);

        IUser iUser = (IUser) request.getSession().getAttribute("iUser");
        request.getSession().setAttribute("iUser", iUser);
        request.getSession().setAttribute("userName", iUser.getUserName());
        request.getSession().setAttribute("quitStr", Parameters.quitStr );
        return "word";
    }

    /**
     * 直接留言
     * @param words
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cc",method = RequestMethod.POST)
    public String caicai(HttpServletRequest request
            , HttpServletResponse response
            , @RequestParam("words") String words
            , @RequestParam("look") String look
            ) throws Exception {
        IUser iUser = (IUser) request.getSession().getAttribute("iUser");
        String userName = iUser.getUserName();
        String isResponse = "0";
        iWordsService.insertWords(userName,words,isResponse,look);
        return "redirect:/sh";
    }

    /**
     * 获取留言
     * @return
     * @throws Exception
     */
//	@RequestMapping("/importWordsData")
//	@ResponseBody
//	public List<IWords> importWordsData() throws Exception {
//		List<IWords> list = new ArrayList<IWords>();
//		list = iWordsService.findAllWords(1,10);
//		return list;
//	}

    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page
            , @RequestParam(value = "size",defaultValue = "10") Integer size
            , Map<String,Object> map) {

        int flag = size - page;
        map.put("flag", flag);
        return new ModelAndView(map);
    }

    //========================================================================

}
