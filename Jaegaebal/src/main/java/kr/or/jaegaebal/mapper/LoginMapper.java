package kr.or.jaegaebal.mapper;

import org.apache.ibatis.annotations.Mapper;
import kr.or.jaegaebal.dto.StaffInfo;

@Mapper
public interface LoginMapper {

	
	
	public StaffInfo staffLogin(String staffNum, String staffPw);
	
}
