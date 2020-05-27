package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.github.pagehelper.PageInfo;
import com.ssm.service.IUserService;
import com.ssm.service.IWordsService;
import com.ssm.utils.CONST;
import com.ssm.utils.NullValue;
import com.ssm.utils.Parameters;
import com.ssm.utils.STATIC_CONST;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.ssm.entity.IUser;
import com.ssm.entity.IWords;

@Controller
public class UserController {

	/**
	 * 注入实现类
	 */
	@Resource
	private IUserService iUserService;

	//-------------------------------用户相关逻辑处理控制器-----------------------------------------
	/**
	 * 检测注册用户合法性
	 * @param userInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/isExist",method = RequestMethod.POST)
	@ResponseBody
	public String isExist(@RequestParam String userInfo,HttpServletRequest request) {
		String msg = "";
		userInfo = request.getParameter("userInfo");
		if(userInfo!=null) {
			if (!("admin".equals(userInfo))) {
				msg = "ok";
			}else {
				msg = "用户名已存在，请重新输入！";
			}
		}
		return msg;
	}

	/**
	 * 注册用户,检测注册用户合法性
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/join")
	@Transactional
	public String insertUser(HttpServletRequest request) throws Exception {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		int count = iUserService.selectUserCount(userName);
		if (count == 0 && !("").equals(userName) && !("").equals(passWord) && userName.length()>4 && passWord.length()>6){
			iUserService.insertUser(userName, passWord);
		}else {
			return STATIC_CONST.CONST_NO_OK;
		}
		return STATIC_CONST.CONST_OK;
	}

	/**
	 * 注册用户,检测注册用户合法性
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/join1")
	public String insertUser(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord) throws Exception {
		int count = iUserService.selectUserCount(userName);
		if (count == 0){
			iUserService.insertUser(userName, passWord);
		}else {
			return STATIC_CONST.CONST_NO_OK;
		}
		return STATIC_CONST.CONST_OK;
	}

	/**
	 * 跳转登录界面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		IUser iUser =(IUser) request.getSession().getAttribute("iUser");
		if (iUser != null){
			request.getSession().setAttribute("iUser",iUser);
			request.getSession().setAttribute("userName", iUser.getUserName());
			request.getSession().setAttribute("quitStr",Parameters.quitStr);
			return "redirect:/";
		}else {
			request.getSession().setAttribute("iUser", null);
			request.getSession().setAttribute("userName", "");
			request.getSession().setAttribute("quitStr","");
			return "login";
		}
	}

	/**
	 * 退出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().setAttribute("iUser", null);
		request.getSession().setAttribute("userName", "");
		request.getSession().setAttribute("quitStr","");
		request.getSession().setAttribute("uri","/");
		return "redirect:/";
	}
	
	/**
	 * 登录控制器
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/check",method = RequestMethod.POST)
	public String check(HttpServletRequest httpServletRequest,@RequestParam String userName,@RequestParam String passWord) throws Exception {
		//获取被拦截的uri
		String uri = (String)httpServletRequest.getSession().getAttribute("uri");
//		String uri_1 = uri.substring(5);
		IUser iUser = iUserService.selectUser(userName, passWord);
		try {
            if (iUser != null) {
            	//查询到用户
            	httpServletRequest.getSession().setAttribute("iUser", iUser);
            	httpServletRequest.getSession().setAttribute("userName", iUser.getUserName());
            	httpServletRequest.getSession().setAttribute("quitStr", Parameters.quitStr );
            	if(null == uri){
            		uri = "/";
				}
            	return "redirect:"+uri;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/login";
	}
	
	/**
	 * 跳转至首页
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		IUser iUser =(IUser) request.getSession().getAttribute("iUser");
		if (iUser != null){
			request.getSession().setAttribute("iUser",iUser);
			request.getSession().setAttribute("userName", iUser.getUserName());
			request.getSession().setAttribute("quitStr",Parameters.quitStr);
		}else {
			request.getSession().setAttribute("iUser", null);
			request.getSession().setAttribute("userName", "");
			request.getSession().setAttribute("quitStr","");
		}
		return "index";
	}
	
}
