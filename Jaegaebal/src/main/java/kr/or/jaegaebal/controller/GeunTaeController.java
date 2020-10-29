package kr.or.jaegaebal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import kr.or.jaegaebal.dto.Holiday;
import kr.or.jaegaebal.service.GeunTaeService;

@Controller
public class GeunTaeController {
	
	@Autowired private GeunTaeService geunTaeService;
	
	
	
	
	//휴일 리스트
	@RequestMapping(value="/holidayList", method=RequestMethod.GET)
	public String getHdCodeList(Model model) {
		
		 List<Holiday> holiCodeList = geunTaeService.getHolidayList();
		 model.addAttribute("holiCodeList",holiCodeList);
		
		model.addAttribute("title","휴일리스트");
		
		return "geuntae/holidayList";
	}
	
	
	//휴일등록
	@PostMapping("/addHdCode")
	public String addInsaCode(Holiday holiday
			,@RequestParam(value="hdCode",required = false) String hdCode
			,@RequestParam(value="hdName",required = false) String hdName
			,@RequestParam(value="hdStartDay",required = false) String hdStartDay
			,@RequestParam(value="hdEndDay",required = false) String hdEndDay
			,@RequestParam(value="hdContents",required = false) String hdContents
			) {
		
		geunTaeService.addHdCode(holiday);
		return "redirect:/holidayList";
	}
	
			
	
}
