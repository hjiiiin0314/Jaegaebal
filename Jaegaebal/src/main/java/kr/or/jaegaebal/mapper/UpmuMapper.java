package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.UpmuDocument;

/**
 * 담당자 : 노종석,이은혜
 * @author ECS
 *
 */
@Mapper
public interface UpmuMapper {

	//기안하기 - 문서유형
	public List<UpmuDocument> getDocCate();
}
