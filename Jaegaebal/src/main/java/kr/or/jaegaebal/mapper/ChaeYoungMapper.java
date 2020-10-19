package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.ChaeYoungApplicant;
import kr.or.jaegaebal.dto.ChaeYoungBoard;
import kr.or.jaegaebal.dto.ChaeYoungCareerInfo;
import kr.or.jaegaebal.dto.ChaeYoungInfo;
import kr.or.jaegaebal.dto.Jojic;

/**
 * 담당자 : 김형진
 * @author ECS
 *
 */
@Mapper
public interface ChaeYoungMapper {

	//지원부서코드 가져오기
	public List<Jojic> getJojicCode();
	
	//게시글 등록
	public int addCYBoardPost(ChaeYoungBoard ChaeYoungBoard);
	
	//게시글 수정
	public int updateCYPost(ChaeYoungBoard ChaeYoungBoard);
	
	//게시글 삭제
	public int deleteCYPost(String jobNumber);
	
	//게시글 리스트
	public List<ChaeYoungBoard> cyBoardList();
	
	//작성된 게시글 화면에 뿌려주기(메서드오버로딩)
	public ChaeYoungBoard cyBoardList(String jobNumber);
	
	//이메일 중복체크
	public ChaeYoungApplicant emailCheck(String appEmail);
	
	//지원자 목록 가져오기
	public List<ChaeYoungApplicant> appManagement();
	
	//지원자 특정인원 가져오기
	public ChaeYoungApplicant appManagement(ChaeYoungApplicant chaeYoungApplicant);
	
	//지원자 이메일 등록
	public int addApplicant(ChaeYoungApplicant chaeYoungApplicant);
	
	//지원자 이메일 등록과 동시에 지원자코드 생성
	public int addAppNumCode(ChaeYoungApplicant chaeYoungApplicant);
	
	//지원자 정보 삭제
	public int deleteApplicant(String appEmail);
	
	//지원자 상태정보 수정
	public int appFinalStateUpdate(String appEmail);
	
	/*************************** 지원자 이력서작성 Start ****************************/
	
	//지원자 인적사항
	public int addBasicInfo(ChaeYoungInfo chaeYoungInfo);
	//지원자 경력사항
	public int addCareerInfo(ChaeYoungCareerInfo chaeYoungCareerInfo);
	//지원자 자격증사항
	public int addCertificateInfo(ChaeYoungInfo chaeYoungInfo);
	//지원자 학력사항
	public int addEducationInfo(ChaeYoungInfo chaeYoungInfo);
	//지원자 병역사항
	public int addMilitaryInfo(ChaeYoungInfo chaeYoungInfo);
	
	/*************************** 지원자 이력서작성 End ******************************/
}
