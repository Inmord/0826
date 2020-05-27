package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.ssm.Pojo.ResponseData;
import com.ssm.entity.IGames;
import com.ssm.entity.IWords;
import com.ssm.service.IGameService;
import com.ssm.service.IWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.service.IUserService;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetParameterController {

	@Autowired
	private IWordsService iWordsService;

	@Autowired
	private IGameService iGameService;

	/**
	 * 手动设置0
	 */
	@RequestMapping("/setZero")
	@ResponseBody
	@Transactional
	public ResponseData setGameVersionZero(HttpServletRequest request){
//		String s1 = request.getRemoteHost();
//		String s2 = request.getRemoteAddr();
		String ip = getIpAddr(request);
		//将浇水次数设为0
		iGameService.setGameVersionZero("zhonghuahua");
		return new ResponseData("200","调用成功,您的ip:"+ip,new ArrayList<IGames>());
	}

	@RequestMapping("/getMessage")
	@ResponseBody
	public String getMessage(@RequestParam String mes) {
		if("ok".equals(mes)) {
			return "SUCCESS";
		}
		return "";
	}

	@RequestMapping("/getWords")
	@ResponseBody
	public ResponseData getWords() throws Exception {//无需登录，测试接口开放

		List list = iWordsService.findAllWords(1,10);

		ResponseData responseData = new ResponseData("200",list);
		responseData.setMessage("调用成功");
		return responseData;
	}

	/**
	 * @Description: 获取客户端IP地址
	 */
	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if(ip.equals("127.0.0.1")){
				//根据网卡取本机配置的IP
				InetAddress inet=null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ip= inet.getHostAddress();
			}
		}
		// 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if(ip != null && ip.length() > 15){
			if(ip.indexOf(",")>0){
				ip = ip.substring(0,ip.indexOf(","));
			}
		}
		return ip;
	}

}
