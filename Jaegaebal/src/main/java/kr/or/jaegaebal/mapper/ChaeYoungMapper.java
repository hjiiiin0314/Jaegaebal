package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.ChaeYoungCode;

/**
 * 담당자 : 김형진
 * @author ECS
 *
 */
@Mapper
public interface ChaeYoungMapper {

	//지원분야코드 가져오기
	public List<ChaeYoungCode> getFieldeCode();
}
