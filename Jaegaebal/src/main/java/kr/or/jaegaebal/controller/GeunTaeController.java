package kr.or.jaegaebal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
	@PostMapping(value="/addHdCode",produces = "application/json")
	   @ResponseBody
	   public List<Map<String, Object>> addHdCode(){
	      List<Map<String, Object>> addHdCode = geunTaeService.addHdCode();
	      return addHdCode;
	   }
	
	
			
	
			//휴일코드 수정
			@GetMapping("/updateHdCode")
			public String updateHdCode(Model model
					,@RequestParam(value="hdCode",required=false) String hdCode
					) {
				Holiday holi = geunTaeService.getHdCode(hdCode);
				
				model.addAttribute("geunTaeService",holi);
				model.addAttribute("title","수정화면");
				
					return "geuntae/updateHdCode";
			}
			@PostMapping("/updateHdCode")
			public String updateHdCode(Holiday holiday) {
				geunTaeService.updateHdCode(holiday);
				return "redirect:/holidayList";
			}
	
}
