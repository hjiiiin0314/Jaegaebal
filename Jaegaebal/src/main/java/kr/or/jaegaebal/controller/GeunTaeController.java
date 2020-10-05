package kr.or.jaegaebal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.jaegaebal.dto.Holiday;
import kr.or.jaegaebal.service.GeunTaeService;

@Controller
public class GeunTaeController {
	
	@Autowired private GeunTaeService geunTaeService;
	
	@RequestMapping(value="/holidayList", method=RequestMethod.GET)
	public String getEmpCodeList(Model model) {
		
		 List<Holiday> holiCodeList = geunTaeService.getHolidayList();
		 System.out.println("holiCodeList -> " + holiCodeList);
		 model.addAttribute("holiCodeList",holiCodeList);
		
		model.addAttribute("title","휴일리스트");
		
		return "geuntae/holidayList";
	}
	
	@GetMapping("/addHdCode")
	public String addHdCode(Model model) {
		model.addAttribute("title","휴일코드 추가");
		return "GeunTae/addHdCode";
	}
	
	
}
