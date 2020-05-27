package com.ssm.filter;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssm.entity.IUser;
import com.ssm.utils.Parameters;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 在业务处理器处理请求之前被调用
	 * - 如果返回false
	 * 从当前的拦截器往回执行所有拦截器的afterCompletion()方法，再退出拦截器链
	 * - 如果返回true
	 * 执行下一个拦截器，知道所有的拦截器都执行完毕
	 * 再执行被拦截的Controller
	 * 然后进入拦截器链，
	 * 从最后一个拦截器往回执行所有的postHandel()方法
	 * 接着再从最后一个拦截器往回执行所有的afterCompletion()方法
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		//不需要拦截的请求路径
		String[] noNeedAuthPage = new String[]{
//				Parameters._basePath +"/zj",//足迹
//				Parameters._basePath +"/sg",//时光
//				Parameters._basePath +"/zhh",
//				Parameters._basePath +"/zxt",
//				Parameters._basePath +"/zz",
//				Parameters._basePath +"/pk",
//				Parameters._basePath +"/llk",
//				Parameters._basePath +"/ppl",
//				Parameters._basePath +"/sj",
				Parameters._basePath +"/login",
				Parameters._basePath +"/check",
				Parameters._basePath +"/re",
				Parameters._basePath +"/join",
				Parameters._basePath +"/logout",
				Parameters._basePath +"/index",
				Parameters._basePath +"/0826",
				Parameters._basePath +"/myInfo",
				Parameters._basePath +"/[object%20Object]",
				Parameters._basePath +"/",
				Parameters._basePath +"/getWords",
//				Parameters._basePath +"/importWordsData",
//				Parameters._basePath +"/admin",
//				Parameters._basePath +"/sh"
		};
		String uri_1 = request.getRequestURI();
		//拦截不在上面的名单中的uri
		if (!Arrays.asList(noNeedAuthPage).contains(uri_1)) {
			IUser iUser = (IUser) session.getAttribute("iUser");
			if (null == iUser) {
				String uri = (String)request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
				request.getSession().setAttribute("uri",uri);
				response.sendRedirect(Parameters._basePath +"/login");
				return false;
			}
		}
		return true;
	}

	/**
	 * 在业务处理器处理请求执行完成后，生成视图之前执行的动作
	 * 可在 modelAndView 中加入数据，比如当前的时间
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等
	 * 当有拦截器抛出异常时，会从当前拦截器往回执行所有的拦截器的afterCompletion()方法
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
