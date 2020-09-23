/**
 * File : chaeyoungBoard.js
 * Author : KHJ
 * detail : 채용공고 리스트 화면 js
 */


            var x = document.getElementById("login");
            var y = document.getElementById("register");
            var z = document.getElementById("btn");
            
            
            function login(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }

            function register(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
            }
            
            $(function() {
            	
            	function pwCheck(pw){
            		var appEmail = $("#login input[name='appEmail']").val();
            		
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
            				  location.href="/appResumeForm?appEmail="+appEmail; 
            			  }else {
            				  alert('비밀번호가 일치하지 않습니다.');
            				  return ;
            			  }          			
            			}           			
            		})()
            	}

            	$('.applicantBtn').click(function() {

    	            var checkBtn = $(this);


    	            // checkBtn.parent() : checkBtn의 부모는 <td>이다.
    	            // checkBtn.parent().parent() : <td>의 부모이므로 <tr>이다.
    	            var tr = checkBtn.parent().parent();
    	            var td = tr.children();
    	            var appNumber = td.eq(0).text(); //공고번호
    	            var jobJojicName = td.eq(1).text(); //지원부서
    	            var jobTitle = td.eq(2).text(); //공고제목
    	            var deadLine = td.eq(3).text(); //마감일
    	            
					$("#login input[name='jobNumber']").val(appNumber); //지원하기 작성할 때 컨트롤러로 보낼 값
					
    	            $('#jobJojicName').text(jobJojicName); //지원부서
      				$('#jobTitle').text(jobTitle.trim()); //공고제목
    	            
 					if(new Date(deadLine) < new Date()) {
 						alert('지원이 마감되었습니다.');
 						return false;
 					}
 					
 					var Dday = new Date(deadLine);    // D-day(deadLine)를 셋팅한다.
 					var now = new Date();                    // 현재(오늘) 날짜를 받아온다.
 					 
 					var gap = now.getTime() - Dday.getTime();    // 현재 날짜에서 D-day의 차이를 구한다.
 					var result = Math.floor(gap / (1000 * 60 * 60 * 24)) * -1;  

      				$('#deadLineDay').text('D-'+result);
            	})
            	
            	//이메일 정규 표현식
            	function email_check( email ) {
    
   					var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    				return (email != '' && email != 'undefined' && regex.test(email));
	
				}
            	//핸드폰 번호 정규식
            	function isCellPhone(p) {

            		p = p.split('-').join('');

            		var regPhone = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
            		return regPhone.test(p);

            		}
            	
        		//핸드폰번호 하이픈생성
        		$(document).on("keyup", ".phoneNumber", function() { 
        			
        			$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); 
        			
        		});
            	//이메일 중복검사 클릭시
            	$('#emailCheck').click(function() {
        			var appEmail = $('.appInsertForm input[name="appEmail"]');
        			if(appEmail.val() == ''){
        				alert('이메일을 입력해주세요.');
        			
        				return false;
        			}else if(!email_check(appEmail.val())) {
        				alert('올바른 이메일을 입력해 주세요.');
        				
        				return false;
        			}
        			
        			var request = $.ajax({
        				  url: "emailCheck", //컨트롤러 맵핑
        				  method: "POST",
        				  data: { appEmail : appEmail.val() },
        				  dataType: "json" // json방식으로 값 전달
        				});
        				 
        				request.done(function( data ) {
        					//히든 inputBox 중복검사여부를 담는다.
        					var emailCheckResult = $('#emailCheckResult');
        					var appEmailCheck = $('#appEmailCheck');
        					var appEmail = $("#login input[name='appEmail']").val();
        					var hiddenPassward = $('#hiddenPassward');
        					var pw = data.appPassward;
        					var result = 1;

        					if(data.appEmail != null){
        						var question = confirm('이미 지원하신 이메일입니다. 수정화면으로 이동 하시겠습니까?');
        						if(question) {
        							pwCheck(pw);    							
        						}
        					}else{
        						alert('지원가능한 이메일 입니다.');
        						//히든 input 박스에 중복확인 통과한 이메일값을 담는다.
        						appEmailCheck.val(appEmail);
        						result = 0;
        					}
        	                //히든 input박스에 값 넣어주기.중복검사 했는지 안했는지 확인하기 위함.
        					emailCheckResult.val(result);	
        					
        					console.log(result, '이메일 중복검사 결과');
        					//이 값을 이용하면 회원가입 버튼을 눌렀을 때 중복확인을 끝낸 이메일로 지원을 시도하는지 안하는지 알 수 있음. 
        					console.log(appEmailCheck.val(),'이메일');
        				});
        				 
        				request.fail(function( jqXHR, textStatus ) {
        				  alert( "Request failed: " + textStatus );
        				});
            	});;
            	
            	//자신의 이력서 조회시 
            	$('.app_resumeBtn').click(function() {
            		var appEmail = $('.app_resume input[name="appEmail"]'); //입력된 이메일
            		var appPw = $('.app_resume input[name="appPassward"]');
            		if(appEmail.val() == ''){
            			alert('이메일을 입력해주세요.');
            			appEmail.focus();
            			return false;
            		}else if(!email_check(appEmail.val())) {
            			alert('올바른 이메일을 입력해 주세요.');
            			appEmail.focus();
            			return false;
            		}else if(appPw.val() == '') {
            			alert('비밀번호를 입력해 주세요.');
            			appPw.focus();
            			return false;
            		}
            		
            		var request = $.ajax({
            			url: "emailCheck", //컨트롤러 맵핑
            			method: "POST",
            			data: { appEmail : appEmail.val() },
            			dataType: "json" // json방식으로 값 전달
            		});
            		
            		request.done(function( data ) {
            			//히든 inputBox 중복검사여부를 담는다.
            			
            			var pw = data.appPassward;
            			var email = data.appEmail;
            			if(email != null){
            				if(appEmail.val() == email && appPw.val() == pw) {
            					if(confirm('수정화면으로 이동합니다')) {
            						location.href="/appResumeForm?appEmail="+appEmail.val(); 
            					}
            				}else {
            					alert('비밀번호가 일치하지 않습니다.');
            				}
            			}else{
            				alert('조회된 정보가 없습니다.');

            			}
            		});
            		
            		request.fail(function( jqXHR, textStatus ) {
            			alert( "Request failed: " + textStatus );
            		});
            	});
            	//이력서 작성전 지원자정보 입력 유효성검사
            	$('#appBtn').click(function() {
            		var appEmail = $('.appInsertForm input[name="appEmail"]');
            		var appPassward = $('.appInsertForm input[name="appPassward"]');
            		var appName = $('.appInsertForm input[name="appName"]');
            		var appPhone = $('.appInsertForm input[name="appPhone"]');
					var emailCheckResult = $('#emailCheckResult');
					var appEmailCheck = $('#appEmailCheck');
            		

            		if(appEmail.val() == '') {
            			alert('이메일을 입력해 주세요');
            			appEmail.focus();
            			return false;	
            		}else if(appPassward.val() == '') {
            			alert('비밀번호를 입력해 주세요');
            			appPassward.focus();
            			return false;     	
            		}else if(appName.val() == '') {
            			alert('이름을 입력해 주세요');
            			appName.focus();
            			return false;	
            		}else if(appPhone.val() == '') {
            			alert('핸드폰번호를 입력해 주세요');
            			appPhone.focus();
            			return false;
            		}else if(!isCellPhone(appPhone.val())) {
            			alert('올바른 핸드폰번호를 입력해 주세요');
            			appPhone.focus();
            			return false;
            		}else if(appEmail.val() != appEmailCheck.val() || emailCheckResult.val() != 0) {
            			alert('이메일 중복검사를 해주세요');
            			appEmail.focus();
            			return false;	
            		}
            		
            		
            		if(confirm('이력서작성 화면으로 이동합니다')) {            			
            			$('.appInsertForm').submit();
            		}
            	});
            });
