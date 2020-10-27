/*
 * 
 * file : chaeyoung-result.js
 * 작성자 : 김형진
 * detail : 합격자 목록 화면
 * */

$(function() {		
		//공고제목 변경시마다
		$(document).on("change","#jobTitleName",function() {
			$('#jobStage option').remove(); //option을 전부 지운다.
			$('#jobStage').append('<option value=""> :: 단계선택 ::</option>');
			var jobTitleName = $('#jobTitleName').val();
			console.log(jobTitleName);
			var request = $.ajax({
				  url: "/cyStates",
				  method: "POST",
				  data: { jobTitleName : jobTitleName },
				  dataType: "json"
				});
				 
				request.done(function( data ) {
					console.log(data.jobStage);
					if(data != null) {		
						for(var i=0; i<data.jobStage; i++) {
							$('#jobStage').append("<option value="+(i+1)+">"+(i+1)+"단계</option>");
						}	
					}
				});					 
		/* 		request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
				}); */
		})
		//공고 단계 변경시마다
		$(document).on("change","#jobStage",function() {

			if($('#jobStage').val() == '1') {
				var jobNumber = $('#jobTitleName').val();
				var request = $.ajax({
					  url: "/cyDocResult",
					  method: "POST",
					  data: { jobNumber : jobNumber },
					  dataType: "json"
					});
					 
					request.done(function( data ) {
		
					});					 
			/* 		request.fail(function( jqXHR, textStatus ) {
					  alert( "Request failed: " + textStatus );
					}); */
			}
		});
});