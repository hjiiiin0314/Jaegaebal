package kr.or.jaegaebal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.dto.Jojic;


/**
 * 담당자 : 이은혜
 * @author ECS
 *
 */
@Mapper
public interface InsaMapper {

	//회사 정보 조회
	public Company getCompanyInfo();
	
	//일반 직원일때 직원 목록
	public List<Map<String, Object>> getStaffInfo(Map<String, Object> parameterMap);
	
	//일반 직원일때 직원 목록의 전체 행 갯수
	public int getStaffInfoListCount();
	
	//부서명 가지고 오기
	public List<Map<Jojic, Object>> getJojicInfo();
	
	//팀명 가지고 오기
	public List<Jojic> getTeamName(String buseoName);
}
