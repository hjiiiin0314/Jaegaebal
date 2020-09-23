package kr.or.jaegaebal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.jaegaebal.dto.CheckInOut;
import kr.or.jaegaebal.service.CheckInOutService;




@Controller
public class CheckInOutController {
	
	@Autowired private CheckInOutService checkInOutService;
	
	//고용형태코드리스트
		/* @GetMapping("/getInsaCodeList") */
		@RequestMapping(value="/getCheckInOutList", method=RequestMethod.GET)
		public String getCheckInOutList(Model model) {
			
			 List<CheckInOut> ckInOutList = checkInOutService.getCheckInOutList();
			 System.out.println("ckInOutList -> " + ckInOutList);
			 model.addAttribute("ckInOutList",ckInOutList);
			
			model.addAttribute("title","코드리스트");
			
			return "Upmu/checkInOutList";
		}
	
}
