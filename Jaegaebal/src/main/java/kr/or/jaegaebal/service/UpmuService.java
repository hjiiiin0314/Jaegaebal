package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.StaffInfo;
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
	
	//기안하기 - 결재라인 - 조직도 - 사원
		public List<StaffInfo> getStaff(){
			List<StaffInfo> staff = upmumapper.getStaff();
			return staff;
		}
		
		//기안하기 - 결재라인 - 조직도
		public List<Jojic> getJojic(){
			List<Jojic> jojic = upmumapper.getJojic();
			return jojic;
		}
	
	//기안하기-문서유형 option값	
	public List<UpmuDocument> getDocCate(){
		  List<UpmuDocument> docCate = upmumapper.getDocCate();
		return docCate;
		
	}
	
}
