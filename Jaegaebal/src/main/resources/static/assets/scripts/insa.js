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
	
	$(document).on('keyup', '.staff_phone_val, .family_phone_val, .human_num', function(){
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
		var is_staff_family_info 	= $(".is_staff_family_info").eq(0).clone();
		is_staff_family_info.find('input').val("");
		is_staff_family_info.find('textarea').val("");
		$('#isStaffFamilyInfo').append(is_staff_family_info);
		$('#isStaffFamilyInfo').append(addFamilyInfoBtnTr);
	});
	
	//사내경력등록 화면에서 가족정보-'경력추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addCareerInfoBtn', function(){
		var addCareerInfoBtnTr 		= $('.addCareerInfoBtnTr').clone();
		$('.addCareerInfoBtnTr').remove();
		var is_career_info_from_in 	= $(".is_career_info_from_in").eq(0).clone();
		is_career_info_from_in.find('input').val("");
		is_career_info_from_in.find('textarea').val("");
		$('#isCareerInfoFromIn').append(is_career_info_from_in);
		$('#isCareerInfoFromIn').append(addCareerInfoBtnTr);
	});
	
	//사외경력등록 화면에서 가족정보-'경력추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addCareerInfoFromOutBtn', function(){
		var addCareerInfoFromOutBtnTr 		= $('.addCareerInfoFromOutBtnTr').clone();
		$('.addCareerInfoFromOutBtnTr').remove();
		var is_career_info_from_out 	= $(".is_career_info_from_out").eq(0).clone();
		is_career_info_from_out.find('input').val("");
		is_career_info_from_out.find('textarea').val("");
		$('#isCareerInfoFromOut').append(is_career_info_from_out);
		$('#isCareerInfoFromOut').append(addCareerInfoFromOutBtnTr);
	});
	
	//자격정보등록 화면에서 가족정보-'자격추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addCertificateInfoBtn', function(){
		var addCertificateInfoBtnTr 		= $('.addCertificateInfoBtnTr').clone();
		$('.addCertificateInfoBtnTr').remove();
		var is_certificate_info 	= $(".is_certificate_info").eq(0).clone();
		is_certificate_info.find('input').val("");
		is_certificate_info.find('textarea').val("");
		$('#isCertificateInfo').append(is_certificate_info);
		$('#isCertificateInfo').append(addCertificateInfoBtnTr);
	});
	
	//학력등록 화면에서 가족정보-'학력추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addEducationInfoBtn', function(){
		var addEducationInfoBtnTr 		= $('.addEducationInfoBtnTr').clone();
		$('.addEducationInfoBtnTr').remove();
		var is_education_info 	= $(".is_education_info").eq(0).clone();
		is_education_info.find('input').val("");
		is_education_info.find('textarea').val("");
		$('#isEducationInfo').append(is_education_info);
		$('#isEducationInfo').append(addEducationInfoBtnTr);
	});
	
	//발령정보등록 화면에서 가족정보-'내용추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addBalryoungInfoBtn', function(){
		var addBalryoungInfoBtnTr 		= $('.addBalryoungInfoBtnTr').clone();
		$('.addBalryoungInfoBtnTr').remove();
		var is_balryoung_info 			= $(".is_balryoung_info").eq(0).clone();
		is_balryoung_info.find('input').val("");
		is_balryoung_info.find('textarea').val("");
		$('#isBalryoungInfo').append(is_balryoung_info);
		$('#isBalryoungInfo').append(addBalryoungInfoBtnTr);
	});
	
	//병역정보등록 화면에서 가족정보-'내용추가' 버튼 클릭시 / 입력칸 추가 생성
	$(document).on('click', '.addMilitaryInfoBtn', function(){
		var addMilitaryInfoBtnTr 		= $('.addMilitaryInfoBtnTr').clone();
		$('.addMilitaryInfoBtnTr').remove();
		var is_military_info 			= $(".is_military_info").eq(0).clone();
		is_military_info.find('input').val("");
		is_military_info.find('textarea').val("");
		$('#isMilitaryInfo').append(is_military_info);
		$('#isMilitaryInfo').append(addMilitaryInfoBtnTr);
	});
	
    $(function(){
    	
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
			
			$('#insertform').submit();
    	});
    	
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
    			//폼 전체값 읽어와서 객체에 넣기
    			
/*    			var insertStaffVals = $('#insertform');
    			//테이블
    			var staffInfo				= $('#staffInfo');
    			var isStaffBasicInfo		= $('.is_staff_basic_info');
    			var isStaffFamilyInfo 		= $('.is_staff_family_info');
    			var isCareerInfoFromIn		= $('.is_career_info_from_in');
    			var isCareerInfoFromOut		= $('.is_career_info_from_out');
    			var isCertificateInfo		= $('.is_certificate_info');
    			var isEducationInfo			= $('.is_education_info');
    			var isBalryoungInfo			= $('.is_balryoung_info'); 
    			var isMilitaryInfo			= $('.is_military_info'); 
    			
    			var staffInfoVal			= [];
    			
    			staffInfo.find('.haveToWriteVals').each(function(){
    				console.log("$(this).val()", $(this).val());
   				if(staffInfo.find('.staffInfoNotes').val() == null || staffInfo.find('.staffInfoNotes').val() == ''){
    					staffInfoVal.push($(this).text(""));
    				}else{
    					staffInfoVal.push($(this).val());
    				}
    				staffInfoVal.push($(this).val());
    				
    			});
    			staffInfoVal.push(staffInfo.find('.staffInfoNotes').val());
    			console.log("staffInfoVal", staffInfoVal);
    			
        		var request = $.ajax({
        			url: "/insertStaffInfoAll",
        			method: "POST",
        			data: {  staffInfoVal : staffInfoVal	},
        			dataType: "json"
        		});
        		request.done(function( data ) {
        			if(data == null){
        				
        				alert("ajax호출 성공");
        			}
        		});
        		request.fail(function( jqXHR, textStatus ) {
        			alert("/insertStaffInfoAll 응답 실패");
        		});*/
/*    			var staffInfoNotes			= staffInfo.children('input[name="notes"]').val();
    			var isStaffBasicInfoNotes	= isStaffBasicInfo.children('input[name="notes"]').val();
    			var isStaffFamilyInfoNotes	= isStaffFamilyInfo.children('input[name="notes"]').val();
    			var isCareerInfoFromInNotes	= isCareerInfoFromIn.children('input[name="notes"]').val();
    			var isCareerInfoFromOutNotes= isCareerInfoFromOut.children('input[name="notes"]').val();
    			var isCertificateInfoNotes	= isCertificateInfo.children('input[name="notes"]').val();
    			var isEducationInfoNotes	= isEducationInfo.children('input[name="notes"]').val();
    			var isBalryoungInfoNotes	= isBalryoungInfo.children('input[name="notes"]').val();
    			var isMilitaryInfoNotes		= isMilitaryInfo.children('input[name="notes"]').val();*/

    			//console.log("tbIsStaffFamilyInfo>>", tbIsStaffFamilyInfo);
    			
    			//console.log("insertStaffVals>>>>", insertStaffVals, "<<<<<");
    			//$('#insertform').submit();

    		}
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
    });


	//value값 유효성 검사
/*    (function() {
        'use strict';
        window.addEventListener('load', function() {
            var forms = document.getElementsByClassName('needs-validation');
            var validation = Array.prototype.filter.call(forms, function(form) {
            	for(var i=0; i<form.length; i++){
            			console.log(form[i], "공백");
            	}
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
    
	$(function(){
		
		//직원 등록하기 버튼 클릭시
		$('#insertStaff').click(function(){
			alert("d11adfa");
			var staffPhone = $('.staff_phone_val').addHyphen();
			$('#staff_phone_val').attr("name", staffPhone);
			console.log($('#staff_phone_val').attr("name"));
			
			var familyPhone = $('.family_phone_val').addHyphen();
			$('#family_phone_val').attr("name", familyPhone);
			
			var familyPhone = $('.human_num').addHyphen();
			$('#human_num_val').attr("name", familyPhone);
			
			var formsNum = $('.forms').length;
			var formsVal = $('.forms').val();
			var str = $('[name=project_start_date]').val();
			var val = $('[name=project_start_date]').val();
			
		

		});
		
		
		
		
		
		
		
	});*/