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
        					var jobNumber = $("#login input[name='jobNumber']").val();
        					if(data == 0){
        						alert('지원가능한 이메일 입니다.');
        						//히든 input 박스에 중복확인 통과한 이메일값을 담는다.
        						console.log(jobNumber);
        						appEmailCheck.val(appEmail.val());
        					}else{
        						var result = confirm('이미 지원하신 이메일입니다. 수정화면으로 이동 하시겠습니까?');
        						
        						if(result) {
        							
        							location.href="/appResumeForm?jobNumber="+jobNumber;
        						}
        					}
        	                //히든 input박스에 값 넣어주기.중복검사 했는지 안했는지 확인하기 위함.
        					emailCheckResult.val(data);	
        					
        					console.log(data, '이메일 중복검사 결과');
        					//이 값을 이용하면 회원가입 버튼을 눌렀을 때 중복확인을 끝낸 이메일로 지원을 시도하는지 안하는지 알 수 있음. 
        					console.log(appEmailCheck.val(),'이메일');
        				});
        				 
        				request.fail(function( jqXHR, textStatus ) {
        				  alert( "Request failed: " + textStatus );
        				});
            	});;
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