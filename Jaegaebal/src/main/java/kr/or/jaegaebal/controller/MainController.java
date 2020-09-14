package kr.or.jaegaebal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 메인화면
 * @author ECS
 *
 */
@Controller
public class MainController {
	@GetMapping("/")
	public String main() {
		
		return "main/index";
	}
	
	//로그인 화면
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "로그인화면");
		return "main/login";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/login";
	}
	
}
