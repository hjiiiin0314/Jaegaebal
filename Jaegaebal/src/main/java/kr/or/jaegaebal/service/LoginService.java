package kr.or.jaegaebal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.mapper.LoginMapper;


@Service
@Transactional
public class LoginService {
	
	@Autowired private LoginMapper loginMapper;
	
	//로그인
	public StaffInfo login(String staffNum, String staffPw) {
		return loginMapper.login(staffNum, staffPw);
	}
}
