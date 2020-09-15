package kr.or.jaegaebal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.Menu;

/**
 * 담당자 : 이요셉
 * @author ECS
 *
 */
@Mapper
public interface MenuMapper {
	//첫번째 메뉴 조회
	public List<Map<Menu, Object>> menuFirstList();
	
	//두번째 메뉴 조회
	public List<Map<Menu, Object>> menuSecondList();
	
	//세번째 메뉴 조회
	public List<Map<Menu, Object>> menuThirdList();
	
	//네번째 메뉴 조회
	public List<Map<Menu, Object>> menuFourthList();
}
