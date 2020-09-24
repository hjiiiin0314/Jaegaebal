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
    	
    	$('#insertStaff').click(function(){
    		console.log("클릭");
    		var haveToWriteVals = document.getElementsByClassName('haveToWriteVals');
/*    		haveToWriteVals.each(function(index, item){
    			$(this).addClass('valid');
    			console.log("1");
    		});*/
    		for(var i=0; i<haveToWriteVals.length; i++){
    			var val = haveToWriteVals[i];
    			console.log("haveToWriteVals[i]", haveToWriteVals[i]);
    			if(haveToWriteVals[i].value != null && (haveToWriteVals[i].value) != ''){
    				//haveToWriteVals[i].addClass('valid');
    				console.log(">>>>>", i);
    				 val.className += " valid";
    				//$('input[name=staff_name]').addClass('valid');
    				//$('input[name=staff_basic_salary]').addClass('invalid');
    			}else{
    				//$(this).addClass('invalid');
    				val.className += " invalid";
    				console.log("공백아님");
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
    })();*/
		
/*
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
			
	        $("#left ul.nav li.parent.active > a > span.sign").find('i:first').addClass("icon-minus");
	        $("#left ul.nav li.current").parents('ul.children').addClass("in");			

		});
		
		
		
		
		
		
		
	});*/