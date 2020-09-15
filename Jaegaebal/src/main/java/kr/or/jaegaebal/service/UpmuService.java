package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.UpmuDocument;
import kr.or.jaegaebal.mapper.UpmuMapper;

/**
 * 담당자 : 노종석,장현지
 * @author ECS
 *
 */
@Service
public class UpmuService {

	@Autowired private UpmuMapper upmumapper;
	
	//기안하기-문서유형 option값	
	public List<UpmuDocument> getDocCate(){
		  List<UpmuDocument> docCate = upmumapper.getDocCate();
		return docCate;
		
	}
	
}
