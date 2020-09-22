package kr.or.jaegaebal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.Code;
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
	public int getStaffInfoListCount(Map<String, Object> map);
	
	//부서명 가지고 오기
	public List<Map<Jojic, Object>> getJojicInfo();
	
	//팀명 가지고 오기
	public List<Jojic> getTeamName(String buseoName);
	
	//부서별 직원 목록
	public List<Map<String, Object>> getStaffInfoByParentJojicName(Map<String, Object> parameterMap);
	//부서별 직원 목록의 전체 행 갯수
	public int getStaffInfoListCountByBuseoName(String buseoName);
	
	//팀별 직원 목록
	public List<Map<String, Object>> getStaffInfoByTeamName(Map<String, Object> parameterMap);
	//팀별 직원 목록의 전체 행 갯수
	public int getStaffInfoListCountByTeamName(String teamName);
	
	//조직테이블 인포 다 가져오기
	public List<Jojic> getJojicInfoAll();
	
	//권한 레벨, 명 가져오기 
	public List<Code> getAccessInfo();
	
	//직급 코드, 명 가져오기
	public List<Code> getLevelInfo();
	
	//직책 코드, 명 가져오기
	public List<Code> getPositionInfo();
	
	//소속 코드, 명 가져오기
	public List<Code> getJojicInfo1();
	
	//사번 생성 후 가져오기
	public String makeStaffNum();
}
