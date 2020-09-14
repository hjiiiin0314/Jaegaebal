package kr.or.jaegaebal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 담당자 : 노종석 , 장현지
 * @author ECS
 *
 */
@Controller
public class UpmuController {

	@GetMapping("/checkInOut")
	public String checkInOut() {
		return "upmu/checkInOut";
	}

}
