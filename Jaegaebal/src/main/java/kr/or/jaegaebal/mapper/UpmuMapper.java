package kr.or.jaegaebal.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.Upmu;

/**
 * 담당자 : 장현지
 * @author ECS
 *
 */
@Mapper
public interface UpmuMapper {
	
	//업무관리 - 나의업무목록
	public List<Upmu> myTesk();

	//업무관리 - 사원목록
	public List<StaffInfo> staffTask();
}
