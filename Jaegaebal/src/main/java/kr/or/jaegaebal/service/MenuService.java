package kr.or.jaegaebal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.Menu;
import kr.or.jaegaebal.mapper.MenuMapper;

/**
 * 담당자 : 이요셉
 * @author ECS
 *
 */
@Service
public class MenuService {
	@Autowired
	private MenuMapper menuMapper;
	
	public List<Map<Menu, Object>> menuFirstList() {
		List<Map<Menu, Object>> menuList = menuMapper.menuFirstList();
		return menuList;
	}
	
	public List<Map<Menu, Object>> menuSecondList() {
		List<Map<Menu, Object>> menuList = menuMapper.menuSecondList();
		return menuList;
	}
	
	public List<Map<Menu, Object>> menuThirdList() {
		List<Map<Menu, Object>> menuList = menuMapper.menuThirdList();
		return menuList;
	}
	
	public List<Map<Menu, Object>> menuFourthList() {
		List<Map<Menu, Object>> menuList = menuMapper.menuFourthList();
		return menuList;
	}
}
