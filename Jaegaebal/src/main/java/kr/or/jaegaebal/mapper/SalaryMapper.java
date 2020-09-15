package kr.or.jaegaebal.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.SalaryInfo;

/**
 * 담당자 : 이요셉
 * @author ECS
 *
 */
@Mapper
public interface SalaryMapper {
	public SalaryInfo salaryInfo(String dataNum);
}
