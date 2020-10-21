/**
 * File : insa.js
 * Author : 이은혜
 * detail : 인사관리 화면 전반 스크립트
 */

	$.fn.addHyphen = function(){
		var hyphenStr = '';
		var len = this.length;
		$(this).each(function(i){
			if(hyphenStr != ''){
				hyphenStr += '-';
			}
			hyphenStr += $(this).val();
		});
		return hyphenStr;
	};
	
	$(document).on('keyup', '.staff_phone_val, .family_phone_val, .human_num, .modifyHaveToWriteVals, .onlyNum' , function(){
		var regexp = /^[0-9]*$/;
		var regexpChange = /[^0-9]/gi;
		var v =  $(this).val();
		if( !regexp.test(v)){
			$(this).val(v.replace(regexpChange,""));
		}
	});
	
    $(document).on("click","#left ul.nav li.parent > a > span.sign", function(){          
        $(this).find('i:first').toggleClass("icon-minus");      
    });	
    
		
	//직원등록 화면에서 가족정보-'인원추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addFamilyInfoBtn', function(){
		var addFamilyInfoBtnTr 		= $('.addFamilyInfoBtnTr').clone();
		$('.addFamilyInfoBtnTr').remove();
		var familyInfoForm 			= $(".familyInfoForm").eq(0).clone();
		familyInfoForm.find('input').val("");
		familyInfoForm.find('textarea').val("");
		$('#isStaffFamilyInfo').append(familyInfoForm);
		$('#isStaffFamilyInfo').append(addFamilyInfoBtnTr);
	});
	
	//사내경력등록 화면에서 사내경력정보-'경력추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addCareerInfoBtn', function(){
		var addCareerInfoBtnTr 		= $('.addCareerInfoBtnTr').clone();
		$('.addCareerInfoBtnTr').remove();
		var careerInfoFromInForm 	= $(".careerInfoFromInForm").eq(0).clone();
		careerInfoFromInForm.find('input').val("");
		careerInfoFromInForm.find('textarea').val("");
		$('#isCareerInfoFromIn').append(careerInfoFromInForm);
		$('#isCareerInfoFromIn').append(addCareerInfoBtnTr);
	});
	
	//사외경력등록 화면에서 -'경력추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addCareerInfoFromOutBtn', function(){
		var addCareerInfoFromOutBtnTr 	= $('.addCareerInfoFromOutBtnTr').clone();
		$('.addCareerInfoFromOutBtnTr').remove();
		var careerInfoFromOutForm 		= $(".careerInfoFromOutForm").eq(0).clone();
		careerInfoFromOutForm.find('input').val("");
		careerInfoFromOutForm.find('textarea').val("");
		$('#isCareerInfoFromOut').append(careerInfoFromOutForm);
		$('#isCareerInfoFromOut').append(addCareerInfoFromOutBtnTr);
	});
	
	//자격정보등록 화면에서-'자격추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addCertificateInfoBtn', function(){
		var addCertificateInfoBtnTr 		= $('.addCertificateInfoBtnTr').clone();
		$('.addCertificateInfoBtnTr').remove();
		var certificateInfoForm 			= $(".certificateInfoForm").eq(0).clone();
		certificateInfoForm.find('input').val("");
		certificateInfoForm.find('textarea').val("");
		$('#isCertificateInfo').append(certificateInfoForm);
		$('#isCertificateInfo').append(addCertificateInfoBtnTr);
	});
	
	//학력등록 화면에서 -'학력추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addEducationInfoBtn', function(){
		var addEducationInfoBtnTr 		= $('.addEducationInfoBtnTr').clone();
		$('.addEducationInfoBtnTr').remove();
		var isEducationInfo 			= $(".isEducationInfo").eq(0).clone();
		isEducationInfo.find('input').val("");
		isEducationInfo.find('textarea').val("");
		$('#isEducationInfo').append(isEducationInfo);
		$('#isEducationInfo').append(addEducationInfoBtnTr);
	});
	
	//발령정보등록 화면에서 -'내용추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addBalryoungInfoBtn', function(){
		var addBalryoungInfoBtnTr 		= $('.addBalryoungInfoBtnTr').clone();
		$('.addBalryoungInfoBtnTr').remove();
		var is_balryoung_info 			= $(".is_balryoung_info").eq(0).clone();
		is_balryoung_info.find('input').val("");
		is_balryoung_info.find('textarea').val("");
		$('#isBalryoungInfo').append(is_balryoung_info);
		$('#isBalryoungInfo').append(addBalryoungInfoBtnTr);
	});
	
	//병역정보등록 화면에서 -'내용추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addMilitaryInfoBtn', function(){
		var addMilitaryInfoBtnTr 		= $('.addMilitaryInfoBtnTr').clone();
		$('.addMilitaryInfoBtnTr').remove();
		var staffMilitaryInfoForm 		= $(".staffMilitaryInfoForm").eq(0).clone();
		staffMilitaryInfoForm.find('input').val("");
		staffMilitaryInfoForm.find('textarea').val("");
		$('#isMilitaryInfo').append(staffMilitaryInfoForm);
		$('#isMilitaryInfo').append(addMilitaryInfoBtnTr);
	});
	
    $(function(){
		/*검색 버튼 클릭시 목록 꼭 선택하게 하기*/
		$('#staffSearchBtn').click(function(){
			var mocroc = $('#mocrocVal').attr("value");
			if(mocroc == null){
				alert("목록을 선택해주세요");
				false;
			}else{
				$('#staffSearchBtn').submit();
			}
		});
		//징계리스트 - 목록 꼭 선택하게 하기
		$('#staffSearchBtn1').click(function(){
			var mocroc = $('#mocrocVal').attr("value");
			if(mocroc == null){
				alert("목록을 선택해주세요");
				false;
			}else if($('#pnshSearchInput').val() == "" || $('#pnshSearchInput').val() == null){
				alert("검색어를 입력해주세요");
				false;
			}else{
				$('#pnshSearchForm').submit();
			}
		});
		
		
		//징계리스트 - 직원 검색 버튼 클릭시
		$('#staffInfoSearchBtn').click(function(){
			if($('#searchStaffInfoVal').val() == null || $('#searchStaffInfoVal').val() == ''){
				alert("검색어를 입력해주세요.");
			}else{
				$('#staffInfoSearchBtn').attr("data-target", "#insertPnshListModal2");
				var sk 	= $('#searchStaff').val();
				var sv	= $('#searchStaffInfoVal').val();
				var request = $.ajax({
					url : "/getStaffInfo",
					method : "POST",
					data : { sk : sk,
							 sv	: sv },
					dataType : "json"
				});	
				request.done(function(data){
					if(data.toString() != null && data.toString() != ''){
						$('#insertStaffInfoTbody').children("tr").remove();
						for(var i=0; i<data.length; i++){
							$('#insertStaffInfoTbody').append("<tr class='insertStaffInfoTr'><td>" + data[i].staffNum + "</td><td>" + data[i].staffName + "</td><td>" + data[i].jojicName + "</td><td>" + data[i].levelName + "</td></tr>");
						}
					}else{
						$('#insertStaffInfoTbody').children("tr").remove();
						$('#insertStaffInfoTbody').append("<tr class='insertStaffInfoTr'><td colspan='4'>검색어에 해당하는 직원 자료가 없습니다.</td></tr>");
					}
				});
				request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
				});					
			}
		});
		
		//징계리스트 - 추가 버튼 클릭시 - 징계명에 옵션값 삽입하기
		$('#insertPnshList').click(function(){
			var str = "";
			var request = $.ajax({
				url : "/getPnshInfo",
				method : "POST",
				data : { str  : str },
				dataType : "json"
			});
			request.done(function(data){
				console.log(data);
				for(var i=0; i<data.length; i++){
					$('.pnshNameSelect').append("<option>"+ data[i].punishmentName +"</option>");					
				}
			});		
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});				
		});
		
		//징계리스트 - 추가 버튼 클릭 - 징계명 클릭시 - 점수 삽입하기
		$(document).on('change', '.pnshNameSelect', function(){
		//$('.pnshNameSelect').change(function(){
			var pnshNameSelect = $(this).val();
			var request = $.ajax({
				url : "/getPnshInfo",
				method : "POST",
				data : { pnshNameSelect  : pnshNameSelect },
				dataType : "json"
			});
			request.done(function(data){
				if(data != null){
					$('input[name=punishmentPoint]').val(data[0].punishmentPoint);
				} else {
					$('input[name=punishmentPoint]').val('');
				}
			});		
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});			
		});
		
    	//징계리스트 - 추가하기 클릭시 - 필수입력값 유효성 검사
    	$(document).on('click', '#insertPnshListBtn', function(){
    		var haveToWriteVals = $('.haveToWriteVals');
    		
    		for(var i=0; i<haveToWriteVals.length; i++){
    			var val = haveToWriteVals[i];
    			
    			if(haveToWriteVals[i].value != null && (haveToWriteVals[i].value) != ''){
    				if($(val).hasClass('invalid')){    					
    					$(val).removeClass('invalid');
    				}
    				val.className += " valid";
    			}else{
    				if($(val).hasClass('valid')){ 
    					$(val).removeClass('valid');
    				}
    				val.className += " invalid";
    			}
    			
    		}
    		if($(haveToWriteVals).hasClass('invalid')){
    			alert("필수 입력값을 입력해주세요.");
    			false;
    		}else{
    			haveToWriteVals.find('.form-control').each(function(){
					$(this).filter("[value='null']").val("");
    			});
    			$('#insertPnshListForm').submit();
    		}
    	});		
		
		//징계리스트 - 검색 후 tr 목록 선택시
		$(document).on('click', '.insertStaffInfoTr', function(){
			var punishmentNum 	= $(this).children('td').eq(0).text();
			var staffNum	 	= $(this).children('td').eq(1).text();
			if(punishmentNum != null){
				$('#insertStaffNum').val(punishmentNum);
			} else {
				$('#insertStaffNum').val('');
			}
			if(staffNum != null){
				$('#insertStaffName').val(staffNum);
			} else {
				$('#insertStaffName').val('');
			}
			var insertPnshListModal2 = document.getElementById('insertPnshListModal2'); //모달 찾기
			$(insertPnshListModal2).modal('hide');										//모달 숨기기
		});

		//징계리스트 - 수정하기 버튼 클릭시
		$('#modifyPunhInfo').click(function(){
			if($('#punishmentStaffNumId').val() == null || $('#punishmentStaffNumId').val() == ''){
				alert("수정할 직원의 정보를 검색해주세요.");
			}else{
				$('#modifyPunhInfo').attr("data-target", "#insertPnshListModal3");
				var str = "";
				var request = $.ajax({
					url : "/getPnshInfo",
					method : "POST",
					data : { str  : str },
					dataType : "json"
				});
				request.done(function(data){
					console.log(data);
					for(var i=0; i<data.length; i++){
						$('.pnshNameSelect').append("<option>"+ data[i].punishmentName +"</option>");					
					}
				});		
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				var punishmentNumId 				= $('#punishmentNumId').val();
				var punishmentStaffNumId 			= $('#punishmentStaffNumId').val();
				var punishmentStaffNameId 			= $('#punishmentStaffNameId').val();
				var punishmentReasonId 				= $('#punishmentReasonId').val();
				var punishmentGivenDateId 			= $('#punishmentGivenDateId').val();
				var punishmentPriceId 				= $('#punishmentPriceId').val();
				var punishmentSalaryAppliedDateId 	= $('#punishmentSalaryAppliedDateId').val();
				var punishmentNotesId 				= $('#punishmentNotesId').val();
				$('#ModifyNumId').val(punishmentNumId);
				$('#ModifyStaffNumId').val(punishmentStaffNumId);
				$('#ModifyStaffNameId').val(punishmentStaffNameId);
				$('#ModifyGivenDateId').val(punishmentGivenDateId);
				$('#ModifySalaryAppliedDateId').val(punishmentGivenDateId);
				$('#ModifyPriceId').val(punishmentPriceId);
				$('#ModifyReasonId').val(punishmentReasonId);
				$('#ModifyNotesId').val(punishmentNotesId);
			}
		});	
		
		//징계리스트 - 모달 - 수정하기 버튼 클릭시(submit)
    	$(document).on('click', '#modifyPnshListModalBtn', function(){
    		var modifyHaveToWriteVals = $('.modifyHaveToWriteVals');
    		
    		for(var i=0; i<modifyHaveToWriteVals.length; i++){
    			var val = modifyHaveToWriteVals[i];
    			
    			if(modifyHaveToWriteVals[i].value != null && (modifyHaveToWriteVals[i].value) != ''){
    				if($(val).hasClass('invalid')){    					
    					$(val).removeClass('invalid');
    				}
    				val.className += " valid";
    			}else{
    				if($(val).hasClass('valid')){ 
    					$(val).removeClass('valid');
    				}
    				val.className += " invalid";
    			}
    			
    		}
    		if($(modifyHaveToWriteVals).hasClass('invalid')){
    			alert("필수 입력값을 입력해주세요.");
    			false;
    		}else{
    			modifyHaveToWriteVals.find('.form-control').each(function(){
					$(this).filter("[value='null']").val("");
    			});
				var request = $.ajax({
					url : "/modifyPnshListInfo",
					method : "POST",
					data : $('#modifyPnshListForm').serialize(),
					dataType : "json"
				});
				request.done(function(data){
					if(data == 1){
						alert("수정되었습니다.");
						window.location.href = "/insa/punishment";
					}else{
						alert("다시 시도해주세요.");
					}
				});		
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus + "수정실패");
				});	
    			//$('#modifyPnshListForm').submit();
    		}
    	});	
    	
    	//삭제하기 버튼 클릭시
    	$('#deletePnshInfoBtn').click(function(){
    		if($('#punishmentStaffNumId').val() == null || $('#punishmentStaffNumId').val() == ''){
				alert("삭제할 직원의 정보를 검색해주세요.");
			}else{
	    		var deleteChecking = confirm("정말로 삭제하시겠습니까?");
	    		if(deleteChecking){
	    			var punishmentNum = $('#punishmentNumId').val();
	    			var request = $.ajax({
						url : "/deletePnshListInfo",
						method : "POST",
						data : { punishmentNum : punishmentNum },
						dataType : "json"
					});
					request.done(function(data){
						if(data == 1){
							alert("삭제되었습니다.");
							window.location.href = "/insa/punishment";
						}else{
							alert("다시 시도해주세요.");
						}
					});		
					request.fail(function( jqXHR, textStatus ) {
						alert( "Request failed: " + textStatus + "삭제실패");
					});	
	    		}
    			
    		}
    	});
		
		//징계리스트 - 직원 리스트 클릭시 오른쪽 상세정보 변경
		$('.pnshListTr').click(function(){
			var punishmentNum 	= $(this).children('td').eq(0).text();
			var staffNum	 	= $(this).children('td').eq(1).text();
			var request = $.ajax({
				url : "/getPnshListInfo",
				method : "POST",
				data : { punishmentNum  : punishmentNum,
						 staffNum		: staffNum		 },
				dataType : "json"
			});
			request.done(function(data){
				if(data.pnshList[0].punishmentNum != null){
					$('input[name=punishment_num]').val(data.pnshList[0].punishmentNum);
				} else {
					$('input[name=punishment_num]').val('');
				}
				if(data.pnshList[0].staffNum != null){
					$('input[name=staff_num]').val(data.pnshList[0].staffNum);
				} else {
					$('input[name=staff_num]').val('');
				}
				if(data.pnshList[0].staffName != null){
					$('input[name=staff_name]').val(data.pnshList[0].staffName);
				} else {
					$('input[name=staff_name]').val('');
				}
				if(data.pnshList[0].punishmentName != null){
					$('input[name=punishment_name]').val(data.pnshList[0].punishmentName);
				} else {
					$('input[name=punishment_name]').val('');
				}
				if(data.pnshList[0].punishmentReason != null){
					$('input[name=punishment_reason]').val(data.pnshList[0].punishmentReason);
				} else {
					$('input[name=punishment_reason]').val('');
				}
				if(data.pnshList[0].punishmentPoint != null){
					$('input[name=punishment_point]').val(data.pnshList[0].punishmentPoint);
				} else {
					$('input[name=punishment_point]').val('');
				}
				if(data.pnshList[0].totalPnsmtPoint != null){
					$('input[name=totalPnsmtPoint]').val(data.pnshList[0].totalPnsmtPoint);
				} else {
					$('input[name=totalPnsmtPoint]').val('');
				}
				if(data.pnshList[0].givenDate != null){
					$('input[name=given_date]').val(data.pnshList[0].givenDate);
				} else {
					$('input[name=given_date]').val('');
				}
				if(data.pnshList[0].punishmentPrice != null){
					$('input[name=punishment_price]').val(data.pnshList[0].punishmentPrice);
				} else {
					$('input[name=punishment_price]').val('');
				}
				if(data.pnshList[0].salaryAppliedDate != null){
					$('input[name=salary_applied_date]').val(data.pnshList[0].salaryAppliedDate);
				} else {
					$('input[name=salary_applied_date]').val('');
				}
				if(data.pnshList[0].punishmentNotes != null){
					$('input[name=punishment_notes]').val(data.pnshList[0].punishmentNotes);
				} else {
					$('input[name=punishment_notes]').val('');
				}
			});		
			request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
			});			
		});
		
		//포상리스트 - 목록 꼭 선택하게 하기 & 검색하기
		$('#staffPrizeSearchBtn1').click(function(){
			var mocrocVal = $('#mocrocVal').attr("value");
			if(mocrocVal == null){
				alert("목록을 선택해주세요");
				false;
			}else if($('#prizeSearchInput').val() == "" || $('#prizeSearchInput').val() == null){
				alert("검색어를 입력해주세요");
				false;
			}else{
				$('#prizeSearchForm').submit();
			}
		});
		
		//포상리스트 - 추가버튼 클릭 - 직원 검색 버튼 클릭시
		$('#staffPrizeInfoSearchBtn').click(function(){
			if($('#searchStaffPrizeInfoVal').val() == null || $('#searchStaffPrizeInfoVal').val() == ''){
				alert("검색어를 입력해주세요.");
			}else{
				$('#staffPrizeInfoSearchBtn').attr("data-target", "#insertPrizeListModal2");
				var sk 	= $('#searchStaffPrize').val();
				var sv	= $('#searchStaffPrizeInfoVal').val();
				var request = $.ajax({
					url : "/getStaffInfo",
					method : "POST",
					data : { sk : sk,
							 sv	: sv },
					dataType : "json"
				});	
				request.done(function(data){
					if(data.toString() != null && data.toString() != ''){
						$('#insertStaffPrizeInfoTbody').children("tr").remove();
						for(var i=0; i<data.length; i++){
							$('#insertStaffPrizeInfoTbody').append("<tr class='insertStaffPrizeInfoTr'><td>" + data[i].staffNum + "</td><td>" + data[i].staffName + "</td><td>" + data[i].jojicName + "</td><td>" + data[i].levelName + "</td></tr>");
						}
					}else{
						$('#insertStaffPrizeInfoTbody').children("tr").remove();
						$('#insertStaffPrizeInfoTbody').append("<tr class='insertStaffPrizeInfoTr'><td colspan='4'>검색어에 해당하는 직원 자료가 없습니다.</td></tr>");
					}
				});
				request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
				});					
			}
		});
		
		//포상리스트 - 추가 버튼 클릭시 - 포상명에 옵션값 삽입하기
		$('#insertPrizeList').click(function(){
			var str = "";
			var request = $.ajax({
				url : "/getPrizeInfo",
				method : "POST",
				data : { str  : str },
				dataType : "json"
			});
			request.done(function(data){
				for(var i=0; i<data.length; i++){
					$('.prizeNameSelect').append("<option>"+ data[i].prizeName +"</option>");					
				}
			});		
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});				
		});
		
		//포상리스트 - 검색 후 tr 목록 선택시
		$(document).on('click', '.insertStaffPrizeInfoTr', function(){
			var prizeNum 		= $(this).children('td').eq(0).text();
			var staffNum	 	= $(this).children('td').eq(1).text();
			if(prizeNum != null){
				$('#insertPrizeStaffNum').val(prizeNum);
			} else {
				$('#insertPrizeStaffNum').val('');
			}
			if(staffNum != null){
				$('#insertPrizeStaffName').val(staffNum);
			} else {
				$('#insertPrizeStaffName').val('');
			}
			var insertPnshListModal2 = document.getElementById('insertPrizeListModal2'); //모달 찾기
			$(insertPrizeListModal2).modal('hide');										//모달 숨기기
		});
		
    	//포상리스트 - 추가하기 클릭시 - 필수입력값 유효성 검사
    	$(document).on('click', '#insertPrizeListBtn', function(){
    		var haveToWriteVals = $('.haveToWriteVals');
    		for(var i=0; i<haveToWriteVals.length; i++){
    			var val = haveToWriteVals[i];
    			
    			if(haveToWriteVals[i].value != null && (haveToWriteVals[i].value) != ''){
    				if($(val).hasClass('invalid')){    					
    					$(val).removeClass('invalid');
    				}
    				val.className += " valid";
    			}else{
    				if($(val).hasClass('valid')){ 
    					$(val).removeClass('valid');
    				}
    				val.className += " invalid";
    			}
    			
    		}
    		if($(haveToWriteVals).hasClass('invalid')){
    			alert("필수 입력값을 입력해주세요.");
    			false;
    		}else{
    			haveToWriteVals.find('.form-control').each(function(){
					$(this).filter("[value='null']").val("");
    			});
    			$('#insertPrizeListForm').submit();
    		}
    	});
    	
		//포상리스트 - 직원 리스트 클릭시 오른쪽 상세정보 변경
		$('.prizeListTr').click(function(){
			var prizeNum 		= $(this).children('td').eq(0).text();
			var staffNum	 	= $(this).children('td').eq(1).text();
			var request = $.ajax({
				url : "/getPrizeListInfo",
				method : "POST",
				data : { prizeNum  	:  prizeNum,
						 staffNum	:  staffNum	 },
				dataType : "json"
			});
			request.done(function(data){
				if(data.prizeList[0].prizeNum != null){
					$('input[name=prize_num]').val(data.prizeList[0].prizeNum);
				} else {
					$('input[name=prize_num]').val('');
				}
				if(data.prizeList[0].staffNum != null){
					$('input[name=staff_num]').val(data.prizeList[0].staffNum);
				} else {
					$('input[name=staff_num]').val('');
				}
				if(data.prizeList[0].staffName != null){
					$('input[name=staff_name]').val(data.prizeList[0].staffName);
				} else {
					$('input[name=staff_name]').val('');
				}
				if(data.prizeList[0].prizeName != null){
					$('input[name=prize_name]').val(data.prizeList[0].prizeName);
				} else {
					$('input[name=prize_name]').val('');
				}
				if(data.prizeList[0].prizeReason != null){
					$('input[name=prize_reason]').val(data.prizeList[0].prizeReason);
				} else {
					$('input[name=prize_reason]').val('');
				}
				if(data.prizeList[0].givenDate != null){
					$('input[name=given_date]').val(data.prizeList[0].givenDate);
				} else {
					$('input[name=given_date]').val('');
				}
				if(data.prizeList[0].prizePrice != null){
					$('input[name=prize_price]').val(data.prizeList[0].prizePrice);
				} else {
					$('input[name=prize_price]').val('');
				}
				if(data.prizeList[0].salaryAppliedDate != null){
					$('input[name=salary_applied_date]').val(data.prizeList[0].salaryAppliedDate);
				} else {
					$('input[name=salary_applied_date]').val('');
				}
				if(data.prizeList[0].prizeNotes != null){
					$('input[name=prize_notes]').val(data.prizeList[0].prizeNotes);
				} else {
					$('input[name=prize_notes]').val('');
				}
			});		
			request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
			});			
		});
		
		//포상리스트 - 모달 - 수정하기 버튼 클릭시(submit)
    	$(document).on('click', '#modifyPrizeListModalBtn', function(){
    		var modifyHaveToWriteVals = $('.modifyHaveToWriteVals');
    		
    		for(var i=0; i<modifyHaveToWriteVals.length; i++){
    			var val = modifyHaveToWriteVals[i];
    			
    			if(modifyHaveToWriteVals[i].value != null && (modifyHaveToWriteVals[i].value) != ''){
    				if($(val).hasClass('invalid')){    					
    					$(val).removeClass('invalid');
    				}
    				val.className += " valid";
    			}else{
    				if($(val).hasClass('valid')){ 
    					$(val).removeClass('valid');
    				}
    				val.className += " invalid";
    			}
    			
    		}
    		if($(modifyHaveToWriteVals).hasClass('invalid')){
    			alert("필수 입력값을 입력해주세요.");
    			false;
    		}else{
    			modifyHaveToWriteVals.find('.form-control').each(function(){
					$(this).filter("[value='null']").val("");
    			});
				var request = $.ajax({
					url : "/modifyPrizeListInfo",
					method : "POST",
					data : $('#modifyPrizeListForm').serialize(),
					dataType : "json"
				});
				request.done(function(data){
					if(data == 1){
						alert("수정되었습니다.");
						window.location.href = "/insa/prize";
					}else{
						alert("다시 시도해주세요.");
					}
				});		
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus + "수정실패");
				});	
    			//$('#modifyPnshListForm').submit();
    		}
    	});	
    	
		//포상리스트 - 수정하기 버튼 클릭시
		$('#modifyPrizeInfo').click(function(){
			if($('#prizeStaffNumId').val() == null || $('#prizeStaffNumId').val() == ''){
				alert("수정할 직원의 정보를 검색해주세요.");
			}else{
				$('#modifyPrizeInfo').attr("data-target", "#insertPrizeListModal3");
				var str = "";
				var request = $.ajax({
					url : "/getPrizeInfo",
					method : "POST",
					data : { str  : str },
					dataType : "json"
				});
				request.done(function(data){
					console.log(data);
					for(var i=0; i<data.length; i++){
						$('.prizeNameSelect').append("<option>"+ data[i].prizeName +"</option>");					
					}
				});		
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				var prizeNumId 					= $('#prizeNumId').val();
				var prizeStaffNumId 			= $('#prizeStaffNumId').val();
				var prizeStaffNameId 			= $('#prizeStaffNameId').val();
				var prizeReasonId 				= $('#prizeReasonId').val();
				var prizeGivenDateId 			= $('#prizeGivenDateId').val();
				var prizePriceId 				= $('#prizePriceId').val();
				var prizeSalaryAppliedDateId 	= $('#prizeSalaryAppliedDateId').val();
				var prizeNotesId 				= $('#prizeNotesId').val();
				$('#ModifyPrizeNumId').val(prizeNumId);
				$('#ModifyStaffNumId').val(prizeStaffNumId);
				$('#ModifyStaffNameId').val(prizeStaffNameId);
				$('#ModifyGivenDateId').val(prizeGivenDateId);
				$('#ModifySalaryAppliedDateId').val(prizeSalaryAppliedDateId);
				$('#ModifyPriceId').val(prizePriceId);
				$('#ModifyReasonId').val(prizeReasonId);
				$('#ModifyNotesId').val(prizeNotesId);
			}
		});
		
    	//포상 관리 - 삭제하기 버튼 클릭시
    	$('#deletePrizeInfoBtn').click(function(){
    		if($('#prizeStaffNumId').val() == null || $('#prizeStaffNumId').val() == ''){
				alert("삭제할 직원의 정보를 검색해주세요.");
			}else{
	    		var deleteChecking = confirm("정말로 삭제하시겠습니까?");
	    		if(deleteChecking){
	    			var prizeNum = $('#prizeNumId').val();
	    			var request = $.ajax({
						url : "/deletePrizeListInfo",
						method : "POST",
						data : { prizeNum : prizeNum },
						dataType : "json"
					});
					request.done(function(data){
						if(data == 1){
							alert("삭제되었습니다.");
							window.location.href = "/insa/prize";
						}else{
							alert("다시 시도해주세요.");
						}
					});		
					request.fail(function( jqXHR, textStatus ) {
						alert( "Request failed: " + textStatus + "삭제실패");
					});	
	    		}
    			
    		}
    	});
		
		//부서 옵션 클릭시 ajax 호출  - 조직도 
		$('#SelectBuseo').change(function(){
			var buseoName = $(this).val();
			console.log(buseoName, "<---클릭한 부서명");
				var request = $.ajax({
			  url: "/getStaffInfoByParentJojicName",
			  method: "POST",
			  data: { buseoName : buseoName },
			  dataType: "json"
			});
				
			request.done(function( data ) {
				$('.pagination').empty();
				$('#t-body').children("tr").remove();
				$('#SelectTeam').children("option").remove();
				$('#SelectTeam').append("<option selected='selected' disabled='disabled'>팀</option>");
				for(var i=0; i<data.jojicTeamName.length; i++){
					if(data.jojicTeamName[i].jojicName != null){
						$('#SelectTeam').append("<option value="+ data.jojicTeamName[i].jojicName + " id='teamName'>" + data.jojicTeamName[i].jojicName + "</option>");
					}else{
						$('#SelectTeam').append("<option value='자료가 없습니다.'" + " id='teamName'>" + data[i].jojicName + "</option>");
					} 
				};
				for(var i=0; i<data.staffInfoByParentJojicName.getStaffInfoList.length; i++){
					var insertVal = data.staffInfoByParentJojicName.getStaffInfoList[i];
					var infoName = [insertVal.staffNum, insertVal.jojicName, insertVal.levelName, insertVal.positionName, insertVal.staffName, insertVal.jaejicStatusName, insertVal.staffEmail, insertVal.staffPhone];
					var appendStr = "";
					for(var n=0; n<infoName.length; n++){
						if(infoName[n] != null){
								if(infoName[n] == '재직중'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-success">재직중</div></td>';
							}else if(infoName[n] == '개발'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-danger">개발</div></td>';
							}else if(infoName[n] == '출장중'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-primary">출장중</div></td>';
							}else if(infoName[n] == '휴가중'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-alternate">휴가중</div></td>';
							}else if(infoName[n] == '퇴사'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-secondary">퇴사</div></td>';
							}else if(infoName[n] == '기타'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-focus">기타</div></td>';
							}else{
								appendStr += '<td>' + infoName[n] + '</td>';
							}
						}else{
							appendStr += '<td>' + "''" + '</td>';
						}
					}
					$('#t-body').append("<tr><td>" + [i+1] + " </td>" + appendStr + "</tr>");
				}
			});
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
		});  
		
		//조직도 - 클릭한 팀명으로 리스트 가지고 오기
		$('.input-jojicStatus').click(function(){
			var teamName = $(this).val();
			console.log(teamName, "<---클릭한 팀명");
			var request = $.ajax({
			  url: "/getStaffInfoByTeamName",
			  method: "POST",
			  data: { teamName : teamName },
			  dataType: "json"
			});
			request.done(function( data ) {
				console.log(data);
				//console.log(data.staffInfoByteamName.getStaffInfoList[0].staffNum);
					$('.pagination').empty();
				$('#t-body').children("tr").remove();
				if(data.staffInfoByteamName != null){
						for(var i=0; i<data.staffInfoByteamName.getStaffInfoList.length; i++){
						var insertVal = data.staffInfoByteamName.getStaffInfoList[i];
						var infoName = [insertVal.staffNum, insertVal.jojicName, insertVal.levelName, insertVal.positionName, insertVal.staffName, insertVal.jaejicStatusName, insertVal.staffEmail, insertVal.staffPhone];
						var appendStr = "";
						for(var n=0; n<infoName.length; n++){
							if(infoName[n] != null){
								if(infoName[n] == '재직중'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-success">재직중</div></td>';
								}else if(infoName[n] == '개발'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-danger">개발</div></td>';
								}else if(infoName[n] == '출장중'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-primary">출장중</div></td>';
								}else if(infoName[n] == '휴가중'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-alternate">휴가중</div></td>';
								}else if(infoName[n] == '퇴사'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-secondary">퇴사</div></td>';
								}else if(infoName[n] == '기타'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-focus">기타</div></td>';
								}else{
									appendStr += '<td>' + infoName[n] + '</td>';
								}
							}else{
								appendStr += '<td>' + "''" + '</td>';
							}
						}
						$('#t-body').append("<tr><td>" + [i+1] + " </td>" + appendStr + "</tr>");
					}
				}
			});
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});			
		});
			
		$('#SelectTeam').change(function(){
				var teamName = $(this).val();
				console.log(teamName, "<---클릭한 팀명");
				var request = $.ajax({
				  url: "/getStaffInfoByTeamName",
				  method: "POST",
				  data: { teamName : teamName },
				  dataType: "json"
				});
				request.done(function( data ) {
				console.log(data);
				//console.log(data.staffInfoByteamName.getStaffInfoList[0].staffNum);
					$('.pagination').empty();
				$('#t-body').children("tr").remove();
				if(data.staffInfoByteamName != null){
						for(var i=0; i<data.staffInfoByteamName.getStaffInfoList.length; i++){
						var insertVal = data.staffInfoByteamName.getStaffInfoList[i];
						var infoName = [insertVal.staffNum, insertVal.jojicName, insertVal.levelName, insertVal.positionName, insertVal.staffName, insertVal.jaejicStatusName, insertVal.staffEmail, insertVal.staffPhone];
						var appendStr = "";
						for(var n=0; n<infoName.length; n++){
							if(infoName[n] != null){
									if(infoName[n] == '재직중'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-success">재직중</div></td>';
								}else if(infoName[n] == '개발'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-danger">개발</div></td>';
								}else if(infoName[n] == '출장중'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-primary">출장중</div></td>';
								}else if(infoName[n] == '휴가중'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-alternate">휴가중</div></td>';
								}else if(infoName[n] == '퇴사'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-secondary">퇴사</div></td>';
								}else if(infoName[n] == '기타'){
									appendStr += '<td><div class="mb-2 mr-2 badge badge-focus">기타</div></td>';
								}else{
									appendStr += '<td>' + infoName[n] + '</td>';
								}
							}else{
								appendStr += '<td>' + "''" + '</td>';
							}
						}
						$('#t-body').append("<tr><td>" + [i+1] + " </td>" + appendStr + "</tr>");
					}
				}
			});
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
		});   	
    	
		/* 검색어 sk클릭시 버튼의 value변경하기 */
		$('#BtnStaffnum').click(function(){
			var BtnStaffnumParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "staff_num");
			BtnStaffnumParentTag.attr('class','dropdown-menu');        
	 	});
		$('#BtnName').click(function(){
			var BtnNameParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "staff_name");
			BtnNameParentTag.attr('class','dropdown-menu');        
	 	});
		$('#BtnEmail').click(function(){
			var BtnEmailParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "staff_email");
			BtnEmailParentTag.attr('class','dropdown-menu');        
	 	});
		$('#BtnPhone').click(function(){
			var BtnPhoneParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "staff_phone");
			BtnPhoneParentTag.attr('class','dropdown-menu');        
	 	});
		$('#BtnPunishmentName').click(function(){
			var BtnPunishmentNameParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "punishment_name");
			BtnPhoneParentTag.attr('class','dropdown-menu');        
		});
		$('#BtnSosoc').click(function(){
			var BtnSosocParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "jojic_name");
			BtnPhoneParentTag.attr('class','dropdown-menu');        
		});
		$('#BtnGivenDate').click(function(){
			var BtnGivenDateParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "given_date");
			$('#pnshSearchInput').attr("type", "date");
			BtnPhoneParentTag.attr('class','dropdown-menu');        
		});
		$('#BtnPrizeStaffNum').click(function(){
			var BtnPrizeStaffNumParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "staff_num");
			$('#prizeSearchInput').attr("type", "text");
			BtnPrizeStaffNumParentTag.attr('class','dropdown-menu');        
		});
		$('#BtnPrizeStaffName').click(function(){
			var BtnPrizeStaffNameParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "staff_name");
			$('#prizeSearchInput').attr("type", "text");
			BtnPrizeStaffNameParentTag.attr('class','dropdown-menu');        
		});
		$('#BtnPrizeGivenDate').click(function(){
			var BtnPrizeGivenDateParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "given_date");
			$('#prizeSearchInput').attr("type", "date");
			BtnPrizeGivenDateParentTag.attr('class','dropdown-menu');        
		});
		$('#BtnPrizeName').click(function(){
			var BtnPrizeNameParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "prize_name");
			$('#prizeSearchInput').attr("type", "text");
			BtnPrizeNameParentTag.attr('class','dropdown-menu');        
		});
		$('#BtnPrizeSosoc').click(function(){
			var BtnPrizeSosocParentTag = $(this).parent();
			$('#mocroc').html($(this).html());
			$('#mocrocVal').attr("value", "jojic_name");
			$('#prizeSearchInput').attr("type", "text");
			BtnPrizeSosocParentTag.attr('class','dropdown-menu');        
		});
		
    	//조직 활성 상태 바꾸기
    	$('.pe-7s-angle-left').click(function(){
    		var jojicName = [];
    		$('input[name="input-checked"]:checked').each(function(){
    			jojicName.push($(this).val());
    		});
    		var request = $.ajax({
    			url: "/changeJojicStatusTo1",
    			method: "POST",
    			data: {  "jojicName"  : jojicName	 },
    			dataType: "json"
    		});
    		request.done(function( data ) {
    			if(data != 0){
    				alert("적용되었습니다.");
    				window.location.href = "/insa/jojicdo";
    			}
    		});
    		request.fail(function( jqXHR, textStatus ) {
    			alert("이동시킬 부서를 체크해주세요.");
    		});
    	});
    	
    	//조직 비활성 상태 바꾸기	
    	$('.pe-7s-angle-right').click(function(){
    		var jojicName = [];
    		$('input[name="input-checked"]:checked').each(function(){
    			jojicName.push($(this).val());
    		});
    		var request = $.ajax({
    			url: "/changeJojicStatusTo0",
    			method: "POST",
    			data: {  "jojicName" : jojicName	},
    			dataType: "json"
    		});
    		request.done(function( data ) {
    			if(data != 0){
    				alert("적용되었습니다.");
    				window.location.href = "/insa/jojicdo";
    			}
    		});
    		request.fail(function( jqXHR, textStatus ) {
    			alert("이동시킬 부서를 체크해주세요.");
    		});
    	});
    	
/*        $("#left ul.nav li.parent.active > a > span.sign").find('i:first').addClass("icon-minus");
        $("#left ul.nav li.current").parents('ul.children').addClass("in");	*/
    	
    	
    	//직원 등록 - 추가 입력 정보
    	$(document).on('click', '#insertAddMoreStaffInfoBtn', function(){
			var staffPhone = $('.staff_phone_val').addHyphen();
			$('#staff_phone_val').attr("value", staffPhone);
			console.log($('#staff_phone_val').attr("name"));
			
			var familyPhone = $('.family_phone_val').addHyphen();
			$('#family_phone_val').attr("value", familyPhone);
			console.log($('#family_phone_val').attr("name"));
			
			var humanNum = $('.human_num').addHyphen();
			$('#humanNum').attr("value", humanNum);
			console.log($('#humanNum').attr("name"));
		
			//사원번호당 추가될 가족정보 테이블 - 한 사람
			var familyInfoTB = $('.familyInfoForm table');
			var careerInfoFromInTB = $('.careerInfoFromInForm table');
			
			//사원번호당 추가될 가족정보
			var familyInfoArray = [];
			var careerInfoFromInArray = [];
			
			//가족정보 추가하기
			for(var i = 0; i<familyInfoTB.length; i++){
				//사원번호당 추가될 가족정보 - 한 사람
				var familySubInfoArray = {};
				//가족정보 입력정보 객체에 담기
				$(familyInfoTB[i]).find('input').each(function(){					
					var attrName = $(this).attr('name');
					var thisValue = $(this).val();
					if($(this).attr('name') == 'staffNum'){
						var staffNum = $('#staffNum').val();
						familySubInfoArray[attrName] = staffNum;
						console.log("$('#staffNum').val() 반복문>>", staffNum);
					}else{
						familySubInfoArray[attrName] = thisValue;
					}
				});
				//한사람 단위로 객체화하여 가족정보 배열에 넣기
				familyInfoArray.push(familySubInfoArray);
			}
			console.log('result>>'+JSON.stringify(familyInfoArray));
    		
			var request = $.ajax({
    			url: "/staffFamilyInfo",
    			method: "POST",
    			traditional : true,
    			data: JSON.stringify(familyInfoArray),
				contentType:'application/json; charset=UTF-8',
				dataType: "json"
    		});
    		request.done(function( data ) {
    			if(data == 1){
    				alert("추가 되었습니다.");
    				window.location.href = "/insa/staffInfoList";
    			}else{
    				alert("다시 시도해주세요.");
    			}
    		});
    		request.fail(function( jqXHR, textStatus ) {
    			alert("가족정보 추가 응답 실패");
    		});
    		//사내경력 추가하기
    		for(var i = 0; i<careerInfoFromInTB.length; i++){
    			//사원번호당 추가될 가족정보 - 한 사람
    			var careerInfoFromInSubArray = {};
    			//가족정보 입력정보 객체에 담기
    			$(careerInfoFromInTB[i]).find('input').each(function(){					
    				var attrName = $(this).attr('name');
    				var thisValue = $(this).val();
    				if($(this).attr('name') == 'staffNum'){
    					var staffNum = $('#staffNum').val();
    					careerInfoFromInSubArray[attrName] = staffNum;
    				}else{
    					careerInfoFromInSubArray[attrName] = thisValue;
    				}
    				
    			});
    			//한사람 단위로 객체화하여 가족정보 배열에 넣기
    			careerInfoFromInArray.push(careerInfoFromInSubArray);
    		}
    		var request = $.ajax({
    			url: "/careerInfoFromIn",
    			method: "POST",
    			traditional : true,
    			data: JSON.stringify(careerInfoFromInArray),
    			contentType:'application/json; charset=UTF-8',
    			dataType: "json"
    		});
    		request.done(function( data ) {
    			if(data == 1){
    				//alert("추가 되었습니다.");
    				//window.location.href = "/";
    			}else{
    				alert("다시 시도해주세요.");
    			}
    		});
    		request.fail(function( jqXHR, textStatus ) {
    			alert("사내경력 추가 응답 실패");
    		});

    	});
    	
    	//직원 등록 - 등록하기 클릭시 - 필수입력값 유효성 검사
    	$(document).on('click', '#insertStaff', function(){
    		var haveToWriteVals = $('.haveToWriteVals');
    		
    		for(var i=0; i<haveToWriteVals.length; i++){
    			var val = haveToWriteVals[i];
    			
    			if(haveToWriteVals[i].value != null && (haveToWriteVals[i].value) != ''){
    				if($(val).hasClass('invalid')){    					
    					$(val).removeClass('invalid');
    				}
    				val.className += " valid";
    			}else{
    				if($(val).hasClass('valid')){ 
    					$(val).removeClass('valid');
    				}
    				val.className += " invalid";
    			}
    			
    		}
    		if($(haveToWriteVals).hasClass('invalid')){
    			alert("필수 입력값을 입력해주세요.");
    			false;
    		}else{
    			haveToWriteVals.find('.form-control').each(function(){
					$(this).filter("[value='null']").val("");
    			});
    			$('#insertform').submit();
    		}
    	});
    	
		//직원리스트 - 부서 클릭시 리스트 변경하기
		$('#StaffListSelectBuseo').change(function(){
			var buseoName = $(this).val();
			console.log(buseoName, "<---클릭한 부서명");
				var request = $.ajax({
			  url: "/getStaffInfoByParentJojicName",
			  method: "POST",
			  data: { buseoName : buseoName },
			  dataType: "json"
			});
				
			request.done(function( data ) {
				$('.pagination').empty();
				$('#StaffList-t-body').children("tr").remove();
				$('#StaffListSelectTeam').children("option").remove();
				$('#StaffListSelectTeam').append("<option selected='selected' disabled='disabled'>팀</option>");
				for(var i=0; i<data.jojicTeamName.length; i++){
					if(data.jojicTeamName[i].jojicName != null){
						$('#StaffListSelectTeam').append("<option value="+ data.jojicTeamName[i].jojicName + " id='teamName'>" + data.jojicTeamName[i].jojicName + "</option>");
					}else{
						$('#StaffListSelectTeam').append("<option value='자료가 없습니다.'" + " id='teamName'>" + data[i].jojicName + "</option>");
					} 
				};
				for(var i=0; i<data.staffInfoByParentJojicName.getStaffInfoList.length; i++){
					var insertVal = data.staffInfoByParentJojicName.getStaffInfoList[i];
					var infoName = [insertVal.staffNum, insertVal.staffName, insertVal.jojicName, insertVal.accessName, insertVal.levelName, insertVal.positionName, insertVal.hobong, insertVal.staffBasicSalary, insertVal.jaejicStatusName, insertVal.employmentStatus, insertVal.companyInDate, insertVal.staffNotes, insertVal.totalPnsmtPoint, insertVal.totalWorkMonths];
					var appendStr = "";
					for(var n=0; n<infoName.length; n++){
						if(infoName[n] != null){
								if(infoName[n] == '재직중'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-success">재직중</div></td>';
							}else if(infoName[n] == '개발'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-danger">개발</div></td>';
							}else if(infoName[n] == '출장중'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-primary">출장중</div></td>';
							}else if(infoName[n] == '휴가중'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-alternate">휴가중</div></td>';
							}else if(infoName[n] == '퇴사'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-secondary">퇴사</div></td>';
							}else if(infoName[n] == '기타'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-focus">기타</div></td>';
							}else{
								appendStr += '<td>' + infoName[n] + '</td>';
							}
						}else{
							appendStr += '<td>' + "''" + '</td>';
						}
					}
					$('#StaffList-t-body').append("<tr><td>" + [i+1] + " </td>" + appendStr + "</tr>");
				}
			});
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
		});
		
		//직원리스트 - 클릭한 팀명으로 리스트 가지고 오기
		$('#StaffListSelectTeam').change(function(){
			var teamName = $(this).val();
			console.log(teamName, "<---클릭한 팀명");
			var request = $.ajax({
			  url: "/getStaffInfoByTeamName",
			  method: "POST",
			  data: { teamName : teamName },
			  dataType: "json"
			});
			request.done(function( data ) {
			console.log(data);
				//console.log(data.staffInfoByteamName.getStaffInfoList[0].staffNum);
				$('.pagination').empty();
				$('#StaffList-t-body').children("tr").remove();
				if(data.staffInfoByteamName != null){
					for(var i=0; i<data.staffInfoByteamName.getStaffInfoList.length; i++){
					var insertVal = data.staffInfoByteamName.getStaffInfoList[i];
					var infoName = [insertVal.staffNum, insertVal.staffName, insertVal.jojicName, insertVal.accessName, insertVal.levelName, insertVal.positionName, insertVal.hobong, insertVal.staffBasicSalary, insertVal.jaejicStatusName, insertVal.employmentStatus, insertVal.companyInDate, insertVal.staffNotes, insertVal.totalPnsmtPoint, insertVal.totalWorkMonths];
					var appendStr = "";
					for(var n=0; n<infoName.length; n++){
						if(infoName[n] != null){
							if(infoName[n] == '재직중'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-success">재직중</div></td>';
							}else if(infoName[n] == '개발'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-danger">개발</div></td>';
							}else if(infoName[n] == '출장중'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-primary">출장중</div></td>';
							}else if(infoName[n] == '휴가중'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-alternate">휴가중</div></td>';
							}else if(infoName[n] == '퇴사'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-secondary">퇴사</div></td>';
							}else if(infoName[n] == '기타'){
								appendStr += '<td><div class="mb-2 mr-2 badge badge-focus">기타</div></td>';
							}else{
								appendStr += '<td>' + infoName[n] + '</td>';
							}
						}else{
							appendStr += '<td>' + "''" + '</td>';
						}
					}
						$('#StaffList-t-body').append("<tr><td>" + [i+1] + " </td>" + appendStr + "</tr>");
					}
				}
			});
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});			
		});
    	
    	//조직도관리 - 부서, 팀 추가 생성하기
    	$('#insertBuseo').click(function(){
    		$('#insertBuseoModal').modal();
    	});
    	$('#insertTeam').click(function(){
    		$('#insertTeamModal').modal();
    	});
    	$('#insertBuseoModalBtn').click(function(){
    		var insertBuseoName = $('#insertBuseoName').val();
    		console.log(insertBuseoName);
    		var request = $.ajax({
    			url: "/insertBuseo",
    			method: "POST",
    			data: { insertBuseoName : insertBuseoName },
    			dataType: "json"
    		});
    		request.done(function( data ) {
    			if(data == 1){
    				alert("생성 되었습니다.");
    				window.location.href = "/insa/jojicdo";
    			}
    		});
    		request.fail(function( jqXHR, textStatus ) {
    			alert("insertBuseoModalBtn 응답 실패");
    		});
    	});
    	
    	$('#insertTeamModalBtn').click(function(){
    		var modalSosocVal 	= $('#modalSosoc').val();
    		var insertTeamName 	= $('#insertTeamName').val();
    		var request = $.ajax({
    			url: "/insertTeam",
    			method: "POST",
    			data: {  modalSosocVal  : modalSosocVal
    					,insertTeamName : insertTeamName},
    			dataType: "json"
    		});
    		request.done(function( data ) {
    			if(data == 1){
    				alert("생성 되었습니다.");
    				window.location.href = "/insa/jojicdo";
    			}
    		});
    		request.fail(function( jqXHR, textStatus ) {
    			alert("insertBuseoModalBtn 응답 실패");
    		});
    	});
    	
    	
    	$(document).on('click', '.haveToWriteVals', function(){
    		var haveToWriteVals = $('.haveToWriteVals');
    		for(var i=0; i<haveToWriteVals.length; i++){
    			var val = haveToWriteVals[i];
    			if($(val).hasClass('invalid')){
    				$(val).removeClass('invalid');
    			}
    		}
    	});
    	
    	$(document).ready('load', '.test', function(){
    		var test = $(this).text();
    		console.log(test);
    		
    		var input1=test.replace("-",''); 
    		var date1 = new Date(input1.substr(0,4),input1.substr(4,2)-1,input1.substr(6,2)); 
    		var date2 = new Date(); 
    		var interval = date2 - date1; 
    		var day = 1000*60*60*24; 
    		var month = day*30; 
    		
    		var gae = parseInt(interval/month);
    		
    		$('.test').parent('td').nextAll('.gae').text(gae);
    		
    	})	
    	
    	//직원리스트  - tr 클릭시 모달창 뜨기
    	$('.staffInfoTr').click(function(){
    		$(this).attr("data-target", "#staffInfoTrModal");
    		var staffNum = $(this).find('#TrStaffNum').text();
    		$('#staffNum').attr("value", staffNum);
    		var request = $.ajax({
    			url: "/getStaffInfoAll",
    			method: "POST",
    			data: {  staffNum : staffNum },
    			dataType: "json"
    		});
    		request.done(function( data ) {
    			if(data != null){
    				for(var infoType in data){
    					console.log("infoType:::",infoType)
						var getList = data[infoType];	
    					if(infoType == 'staffInfoWithOther' || infoType == 'staffBasicInfo'){
    						if(getList != undefined && getList.length > 0){								
    							var getForm;
    							if(infoType == 'staffInfoWithOther'){
    								getForm = $('#isStaffInfoDetail');
    							}else{
    								getForm = $('#isStaffBasicInfoDetail');
    							}    							
								for(var i=0; i < getList.length; i ++){								
									for(var key in getList[i]){										
										getForm.find('input[name="'+key+'"]').val(getList[i][key]);
									}								
								}
							} 
						}else if(infoType == 'staffFamilyInfo'){
							if(getList != undefined && getList.length > 0){
								var getForm;
								getForm = $('#isStaffFamilyInfoDetail');
								for(var i=0; i < getList.length; i ++){
									if(i == 0){
										for(var key in getList[i]){		
											$('.staffFamilyInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
										}
										continue;
									}else{
										var staffFamilyInfoForm 	= $(".staffFamilyInfoForm").eq(0).clone();
										$('#isStaffFamilyInfoDetail').append(staffFamilyInfoForm);
										for(var key in getList[i]){		
											$('.staffFamilyInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
										}
									}
								}
							}
						}else if(infoType == 'careerInfoFromIn'){
							getForm = $('#isCareerInfoFromInDetail');
							for(var i=0; i < getList.length; i ++){
								if(i == 0){
									console.log("i == 0");
									for(var key in getList[i]){		
										$('.isCareerInfoFromInForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
									continue;
								}else{
									console.log("i == 0 else");
									var isCareerInfoFromInForm 	= $(".isCareerInfoFromInForm").eq(0).clone();
									$('#isCareerInfoFromInDetail').append(isCareerInfoFromInForm);
									for(var key in getList[i]){		
										$('.isCareerInfoFromInForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
								}
							}
						}else if(infoType == 'careerInfoFromOut'){
							getForm = $('#isCareerInfoFromOutDetail');
							for(var i=0; i < getList.length; i ++){
								if(i == 0){
									console.log("i == 0");
									for(var key in getList[i]){		
										$('.isCareerInfoFromOutForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
									continue;
								}else{
									console.log("i == 0 else");
									var isCareerInfoFromOutForm 	= $(".isCareerInfoFromOutForm").eq(0).clone();
									$('#isCareerInfoFromOutDetail').append(isCareerInfoFromOutForm);
									for(var key in getList[i]){		
										$('.isCareerInfoFromOutForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
								}
							}
						}else if(infoType == 'certificateInfo'){
							getForm = $('#isCertificateInfoDetail');
							for(var i=0; i < getList.length; i ++){
								if(i == 0){
									console.log("i == 0");
									for(var key in getList[i]){		
										$('.isCertificateInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
									continue;
								}else{
									console.log("i == 0 else");
									var isCertificateInfoForm 	= $(".isCertificateInfoForm").eq(0).clone();
									$('#isCertificateInfoDetail').append(isCertificateInfoForm);
									for(var key in getList[i]){		
										$('.isCertificateInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
								}
							}
						}else if(infoType == 'educationInfo'){
							getForm = $('#isEducationInfoDetail');
							for(var i=0; i < getList.length; i ++){
								if(i == 0){
									console.log("i == 0");
									for(var key in getList[i]){		
										$('.isEducationInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
									continue;
								}else{
									console.log("i == 0 else");
									var isEducationInfoForm 	= $(".isEducationInfoForm").eq(0).clone();
									$('#isEducationInfoDetail').append(isEducationInfoForm);
									for(var key in getList[i]){		
										$('.isEducationInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
								}
							}
						}else if(infoType == 'balryoungInfo'){
							getForm = $('#isBalryoungInfoDetail');
							for(var i=0; i < getList.length; i ++){
								if(i == 0){
									console.log("i == 0");
									for(var key in getList[i]){		
										$('.isBalryoungInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
									continue;
								}else{
									console.log("i == 0 else");
									var isBalryoungInfoForm 	= $(".isBalryoungInfoForm").eq(0).clone();
									$('#isBalryoungInfoDetail').append(isBalryoungInfoForm);
									for(var key in getList[i]){		
										$('.isBalryoungInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
								}
							}
						}else if(infoType == 'militaryInfo'){
							getForm = $('#isMilitaryInfoDetail');
							for(var i=0; i < getList.length; i ++){
								if(i == 0){
									console.log("i == 0");
									for(var key in getList[i]){		
										$('.isMilitaryInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
									continue;
								}else{
									console.log("i == 0 else");
									var isMilitaryInfoForm 	= $(".isMilitaryInfoForm").eq(0).clone();
									$('#isMilitaryInfoDetail').append(isMilitaryInfoForm);
									for(var key in getList[i]){		
										$('.isMilitaryInfoForm').eq(i).find('input[name="'+key+'"]').val(getList[i][key]);
									}
								}
							}
						}
					}
    			}else{
    				alert("검색결과가 없습니다.");
    			}
    		});
    		request.fail(function( jqXHR, textStatus ) {
    			alert("직원정보 가져오기 응답 실패");
    		});
    	});
    	
    	//직원리스트 - 상세보기 모달 - 수정버튼 클릭시
    	$('#modifyStaffInfoDetail').click(function(){
    	});
    	//직원리스트 - 상세보기 모달 - 삭제버튼 클릭시
    	$('#deleteStaffInfoBtnDetail').click(function(){
    	});
    		
    });


