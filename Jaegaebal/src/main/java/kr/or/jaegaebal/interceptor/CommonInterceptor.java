package kr.or.jaegaebal.interceptor;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.or.jaegaebal.dto.Menu;
import kr.or.jaegaebal.service.MenuService;

@Component
public class CommonInterceptor implements HandlerInterceptor{
	
	@Autowired
	private MenuService menuService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// controller 진행 전
		HttpSession session = request.getSession();
		//if(session.getAttribute("FIRSTMENU") == null && session.getAttribute("SECONDMENU") == null && session.getAttribute("THIRDMENU") == null && session.getAttribute("FOURTHMENU") == null) {
			List<Map<Menu, Object>> menuList = menuService.menuFirstList();
			session.setAttribute("FIRSTMENU", menuList);
			menuList = menuService.menuSecondList();
			session.setAttribute("SECONDMENU", menuList);
			menuList = menuService.menuThirdList();
			session.setAttribute("THIRDMENU", menuList);
			menuList = menuService.menuFourthList();
			session.setAttribute("FOURTHMENU", menuList);
		//}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// controller 진행 후
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
