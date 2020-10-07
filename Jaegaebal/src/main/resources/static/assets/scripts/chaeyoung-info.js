/**
 * 
 * file : chaeyoung-info.js
 * 작성자 : 김형진
 * detail : 지원자 인적사항
 */


//유효성검사


	$(function() {
		//지원 취소 확인 메시지창
		function message(){
			var hiddenPw = $('.hiddenPw').val();
			const swalWithBootstrapButtons = Swal.mixin({
				  customClass: {
				    confirmButton: 'btn btn-success',
				    cancelButton: 'btn btn-danger'
				  },
				  buttonsStyling: false
				})

				swalWithBootstrapButtons.fire({
				  title: '정말로 지원을 포기하시겠습니까?',
				  text: "작성한 데이터는 전부 삭제됩니다.",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonText: '네 포기하겠습니다.',
				  cancelButtonText: '아니오!',
				  reverseButtons: true
				}).then((result) => {
				  if (result.isConfirmed) {
					  pwCheck(hiddenPw)

				  }
				})
		}
		//비밀번호 체크
    	function pwCheck(pw){
    		var appEmail = $(".appEmail").text();
    		
    		(async () => {

    			const { value: password } = await Swal.fire({
    			  title: '비밀번호를 입력해 주세요.',
    			  input: 'password',
    			  inputPlaceholder: 'Enter your password',
    			  inputAttributes: {
    			    maxlength: 10,
    			    autocapitalize: 'off',
    			    autocorrect: 'off'
    			  }
    			})

    			if (password) {
    			  if(pw == password) {

    				  await Swal.fire(
    					'Deleted!',
    					'지원이 취소되었습니다.',
    					'success'
    					)      				

    					location.href="/deleteApplicant?appEmail="+ appEmail;
    			  }else {
    				  await Swal.fire(
    				    	      'fail',
    				    	      '비밀번호가 틀렸습니다',
    				    	      'error')
    				  return false;
    			  }          			
    			}           			
    		})()
    	}
		//지원취소하기
		$('.appDelete').click(function() {
			
			message();
			

		})
		//내국인일 시 국적작성 x 외국인일시 국적작성 o
		$('input[name=staffNationality]').click(function() {
			 if($("input[name=staffNationality]:checked").val() == "내국인"){
		         $("input:text[name=staffCountry]").attr("disabled",true);
		         $("input:text[name=staffCountry]").val('대한민국');
		 
		     }else if($("input[name=staffNationality]:checked").val() == "외국인"){
		    	 $("input:text[name=staffCountry]").val('');
		         $("input:text[name=staffCountry]").attr("disabled",false);

		     }
		});
		
		//경력사항없음 클릭시.
		$('.careerInfoCheck').on("click",function() {
			if($('.careerInfoCheck').is(":checked") == true) {
				$('.careerInfoTable input').attr('disabled', true);
				$('.careerInfoTable textarea').attr('disabled', true);
				$('.careerInfoTable input').val('');
			}else {
				$('.careerInfoTable input').attr('disabled', false);
				$('.careerInfoTable textarea').attr('disabled', false);
			}
		})
		
		//자격증정보없음 클릭시.
		$('.certificateInfoCheck').on("click", function() {
			if($('.certificateInfoCheck').is(":checked") == true) {
				$('.certificateInfoTable input').attr('disabled', true);
				$('.certificateInfoTable input').val('');
			}else {
				$('.certificateInfoTable input').attr('disabled', false);
			}
		})
		
		$('.addTest').on("click",function() {

		});
		//입력된 첫번째 문자를 대문자로 변경함수
		function capitalize(str) {
			return str.charAt(0).toUpperCase() + str.slice(1);
		}

/*		//사외경력등록 화면에서 가족정보-'경력추가' 버튼 클릭시 / 입력칸 추가 생성
		$(document).on('click', '.addCareerInfoFromOutBtn', function(){
			var aa = $('.careerInfo').eq(0).clone();
			$('#isCareerInfoFromOut').append(aa);
			var addCareerInfoFromOutBtnTr 		= $('.addCareerInfoFromOutBtnTr').clone();
			$('.addCareerInfoFromOutBtnTr').remove();
			var is_career_info_from_out 	= $(".is_career_info_from_out").eq(0).clone();
			is_career_info_from_out.find('input').val("");
			is_career_info_from_out.find('textarea').val("");
			$('#isCareerInfoFromOut').append(is_career_info_from_out);
			$('#isCareerInfoFromOut').append(addCareerInfoFromOutBtnTr);
		});*/
		
		//지원서 작성 등록
		$('#InfoStorage').click(function() {
			
			// *************** 영어이름 첫글자 대문자로 변경 start 
			var lastName = $('.last-name').val();
			var firstName = $('.first-name').val();
			var staffEngName = '';
			
			if(lastName != '' && lastName != undefined) {
				staffEngName = capitalize(lastName);
			}
			if(firstName != '' && firstName != undefined) {
				staffEngName += capitalize(firstName);
			}
			$('input[name=staffEngName]').val(staffEngName);
			// *************** 영어이름 첫글자 대문자로 변경 end 
			var jumin1 = $('input[name=humanNum1]').val();
			var jumin2 = $('input[name=humanNum2]').val();
			var jumin = jumin1+'-'+jumin2;
			$('input[name=humanNum]').val(jumin);
			//유효성검사를 위해 form을 배열에 담는다.
			var form = [];
			for(var i=0; i<$('.formCheck form').length; i++) {
				form.push($('.formCheck form').eq(i));
			}
			//주민등록번호 정규식
			function humanNum(jumin) {
				var num = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$/;

				return num.test(jumin);
			}
        	//핸드폰 번호 정규식
        	function isCellPhone(p) {

        		p = p.split('-').join('');

        		var regPhone = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
        		return regPhone.test(p);

        		}
		
			var classStr = ''; //form 클래스명 전부
			for(var n=0; n<form.length; n++) {
				var className = form[n][0].className;
				
				for(var i=0; i<$('.'+className+' .form-control').length; i++) {
					var Info = $('.'+className+' .form-control').eq(i).val();
					
					if(Info == '' || Info == undefined) {
							
						if(className == 'basicInfo') {
							alert('인적사항을 입력해 주세요');
							return false;							
						}else if(className == 'careerInfo'){
							if($('.careerInfoCheck').is(":checked") == true) continue; //경력사항없음 체크박스가 체크 되어 있을 시 건너뛴다.
							alert('경력 정보를 입력해 주세요');
							return false;
						}else if(className == 'certificateInfo') {
							if($('.certificateInfoCheck').is(":checked") == true) continue; //자격증정보없음 체크박스가 체크 되어 있을 시 건너뛴다.
							alert('자격증정보를 입력해 주세요');
							return false;
						}else if(className == 'educationInfo') {
							alert('학력정보를 입력해 주세요');
							return false;
						}else if(className == 'militaryInfo') {
							alert('병역정보를 입력해 주세요');
							return false;
						}
					}
				}
				if(n<form.length) classStr += '.'+className+', ';
				if(n+1 == form.length) classStr += '.'+className;				
			}
			if(!humanNum($('input[name=humanNum]').val())) {
				alert('올바른 주민등록번호를 입력해 주세요'); 
				return false;
			}else if(!isCellPhone($('input[name=staffPhone]').val())) {
				alert('올바른 핸드폰번호를 입력해 주세요');
				return false;
			}else {
					
		
				
				var request = $.ajax({
  				  url: "/addInfo", //컨트롤러 맵핑
  				  method: "POST",
  				  data: $(classStr).serialize(),
  				  dataType: "json" // json방식으로 값 전달
  				});
  				 
  				request.done(function( data ) {
  					if(data != 0) {
  						alert('정상적으로 지원이 완료되었습니다.');
  						location.href="/cyboardList"
  					}
  				});
  				 
  				request.fail(function( jqXHR, textStatus ) {
  				  alert( "Request failed: " + textStatus );
  				});
			}

			
		});
	});