package kr.or.jaegaebal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.CareerInfoFromIn;
import kr.or.jaegaebal.dto.CareerInfoFromOut;
import kr.or.jaegaebal.dto.CertificateInfo;
import kr.or.jaegaebal.dto.Code;
import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.dto.EducationInfo;
import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.MilitaryInfo;
import kr.or.jaegaebal.dto.Prize;
import kr.or.jaegaebal.dto.Punishment;
import kr.or.jaegaebal.dto.StaffBalryoungInfo;
import kr.or.jaegaebal.dto.StaffBasicInfo;
import kr.or.jaegaebal.dto.StaffFamilyInfo;
import kr.or.jaegaebal.dto.StaffInfo;


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
	public List<StaffInfo> getStaffInfo(Map<String, Object> parameterMap);
	//일반 직원일때 직원 목록의 전체 행 갯수
	public int getStaffInfoListCount(Map<String, Object> map);
	
	//직원 리스트 & 검색조건 & 페이징
	public List<Map<String, Object>> getStaffInfoAll(Map<String, Object> parameterMap);
	//직원 리스트 & 검색조건 & 페이징 의 전체 행 갯수
	public int getStaffInfoAllCount(Map<String, Object> map);
	
	//직원 기본 정보 가져오기 with 소속명,직책명,권한명,직급명,재직상태
	public List<StaffInfo> getStaffInfoWithOther(String staffNum);
	//직원 인적사항 가져오기
	public List<StaffBasicInfo> getStaffBasicInfo(String staffNum);
	//직원 가족정보 가져오기
	public List<StaffFamilyInfo> getStaffFamilyInfo(String staffNum);
	//직원 사내경력 가져오기
	public List<CareerInfoFromIn> getCareerInfoFromIn(String staffNum);
	//직원 사외경력 가져오기
	public List<CareerInfoFromOut> getCareerInfoFromOut(String staffNum);
	//직원 자격정보 가져오기
	public List<CertificateInfo> getCertificateInfo(String staffNum);
	//직원 학력정보 가져오기
	public List<EducationInfo> getEducationInfo(String staffNum);
	//직원 발령정보 가져오기
	public List<StaffBalryoungInfo> getBalryoungInfo(String staffNum);
	//직원 병역정보 가져오기
	public List<MilitaryInfo> getMilitaryInfo(String staffNum);
	
	//직원 병역정보 삭제하기 
	public int deleteMilitaryInfoByStaffNum(String staffNum);
	//직원 발령정보 삭제하기 
	public int deleteBalryoungInfoByStaffNum(String staffNum);
	//직원 학력정보 삭제하기 
	public int deleteEducationInfoByStaffNum(String staffNum);
	//직원 자격정보 삭제하기 
	public int deleteCertificateInfoByStaffNum(String staffNum);
	//직원 사외경력 삭제하기 
	public int deleteCareerInfoFromOutByStaffNum(String staffNum);
	//직원 사내경력 삭제하기 
	public int deleteCareerInfoFromInByStaffNum(String staffNum);
	//직원 가족정보 삭제하기 
	public int deleteStaffFamilyInfoByStaffNum(String staffNum);
	//직원 인적사항 삭제하기 
	public int deleteStaffBasicInfoByStaffNum(String staffNum);
	//직원 삭제하기 
	public int deleteStaffInfoByStaffNum(String staffNum);
	
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
	
	//조직도 - 부서 추가 생성하기
	public int insertBuseoName(String insertBuseoName);
	//조직도 - 팀 추가 생성하기
	public int insertTeamName(String modalSosocVal, String insertTeamName);
	//조직 활성상태로 수정하기
	public int changeJojicStatus1(List<String> jojicName);
	//조직 비활성 상태로 수정하기
	public int changeJojicStatus0(List<String> jojicName);
	
	//권한 레벨, 명 가져오기 
	public List<Code> getAccessInfo();
	//직급 코드, 명 가져오기
	public List<Code> getLevelInfo();
	//직책 코드, 명 가져오기
	public List<Code> getPositionInfo();
	//소속 코드, 명 가져오기
	public List<Code> getJojicInfo1();
	
	//사번 생성 후 가져오기
	//public String makeStaffNum();
	
	//회원가입(필수 정보 입력)
	public int insertToIsStaffInfo(StaffInfo staffInfo);
	//회원가입 이후 생성된 사번 가지고 오기
	public String getStaffNum(StaffInfo staffInfo);
	//추가 정보 입력시 정보가져오기
	public StaffInfo getInsertStaffInfo(String staffNum);
	//직원 등록 - 인적사항 insert
	public int insertStaffBasicInfo(StaffBasicInfo staffBasicInfo);
	//직원 등록 - 가족정보 insert
	public int insertStaffFamilyInfo(StaffFamilyInfo staffFamilyInfo);
	//직원 등록 - 사내 경력 정보 insert
	public int insertStaffCareerInfoFromIn(CareerInfoFromIn careerInfoFromIn);
	//직원 등록 - 사외 경력 정보 insert
	public int insertStaffCareerInfoFromOut(CareerInfoFromOut careerInfoFromOut);
	//직원 등록 - 자격증 경력 정보 insert
	public int insertStaffCertificateInfo(CertificateInfo certificateInfo);
	//직원 등록 - 학력 정보 insert
	public int insertStaffEducationInfo(EducationInfo educationInfo);
	//직원 등록 - 병역 정보 insert
	public int insertStaffMilitaryInfo(MilitaryInfo militaryInfo);
	//직원 등록 - 급여기본 정보 insert
	public int insertStaffSalaryInfo(StaffInfo staffInfo);

	//징계 리스트
	public List<Map<String, Object>> getPnshList(Map<String, Object> parameterMap);
	//징계 리스트의 전체 행 갯수
	public int getPnshListCount(Map<String, Object> map);
	//징계리스트 - 징계리스트 추가 - 징계명 클릭시  / 징계 정보 가져오기 
	public List<Punishment> getPnshInfo();
	//징계리스트 - 추가 버튼 클릭 - 징계명 클릭시 - 점수 삽입하기
	public List<Punishment> getPnshInfo(String pnshNameSelect);
	//징계리스트 추가하기
	public int insertPnshList(Punishment insertPnshListInfo);
	//징계리스트 수정하기
	public int modifyPnshListInfo(Punishment modifyPnshListInfo);	
	//징계리스트 삭제하기
	public int deletePnshListInfo(String punishmentNum);
	
	//포상 리스트
	public List<Map<String, Object>> getPrizeList(Map<String, Object> parameterMap);
	//포상 리스트의 전체 행 갯수
	public int getPrizeListCount(Map<String, Object> map);
	//포상리스트 - 포상리스트 추가 - 포상명 클릭시  / 징계 정보 가져오기 
	public List<Prize> getPrizeInfo();
	//포상리스트 - 추가 버튼 클릭 - 포상명 클릭시 - 점수 삽입하기
	public List<Prize> getPrizeInfo(String prizeNameSelect);
	//포상리스트 추가하기
	public int insertPrizeList(Prize insertPrizeListInfo);
	//포상리스트 수정하기
	public int modifyPrizeListInfo(Prize modifyPrizeListInfo);	
	//포상리스트 삭제하기
	public int deletePrizeInfo(String prizeNum);
}
