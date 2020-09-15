package kr.or.jaegaebal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.SalaryInfo;
import kr.or.jaegaebal.mapper.SalaryMapper;

/**
 * 담당자 : 이요셉
 * @author ECS
 *
 */
@Service
public class SalaryService {
	@Autowired
	private SalaryMapper salaryMapper;
	
	public SalaryInfo salaryInfo(String dataNum) {
		SalaryInfo salaryInfo = salaryMapper.salaryInfo(dataNum);
		return salaryInfo;
	}
}
