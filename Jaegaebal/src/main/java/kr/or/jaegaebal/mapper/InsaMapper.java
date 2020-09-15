package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.Company;

/**
 * 담당자 : 이은혜
 * @author ECS
 *
 */
@Mapper
public interface InsaMapper {

	//회사 정보 조회
	public List<Company> getCompanyInfo();
}
