package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.mapper.InsaMapper;


/**
 * 담당자 : 이은혜
 * @author ECS
 *
 */
@Service
@Transactional
public class InsaService {
	
	@Autowired
	private InsaMapper insaMapper;
	
	//회사 정보 목록
	public List<Company> getCompanyInfo(){
		List<Company> companyList = insaMapper.getCompanyInfo();
		
		return companyList;
	}
}
