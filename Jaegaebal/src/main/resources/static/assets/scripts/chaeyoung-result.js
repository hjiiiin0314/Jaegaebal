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
			$('.apptbody').children().remove();
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
			$('.apptbody').children().remove();
			if($('#jobStage').val() == '1') {
				var jobNumber = $('#jobTitleName').val();
				var request = $.ajax({
					  url: "/cyDocResult",
					  method: "POST",
					  data: { jobNumber : jobNumber },
					  dataType: "json"
					});
					 
					request.done(function( data ) {
						console.log(data);
						for(var i=0; i<data.length; i++) {
							$('.apptbody').append(
									'<tr class="text-center">'+
									'<td><strong>'+ (i+1) +'</strong></td>'+
									'<td>'+data[i].appNumCode +'</td>' +
									'<td>'+data[i].appName +'</td>' +
									'<td>'+data[i].humanNum +'</td>' +
									'<td>'+data[i].staffGender +'</td>' +
									'<td>'+data[i].docResultScore +'</td>' +
									'<td>'+data[i].docResult +'<input type="hidden" value='+data[i].docResult +'></td>' +
									'<td>'+data[i].regStaffName +'</td>' +
									'<td>'+data[i].docRegDate +'</td>' +
									'<td class="text-center"><button type="button" class="mb-2 mr-2 btn-transition btn btn-outline-info appScoring">점수부여</button></td>' +
									'<td class="text-center"><button type="button" class="mb-2 mr-2 btn-transition btn btn-outline-danger appTransferred">데이터이관</button></td>' +
									'</tr>');
							
						}
					});					 
			/* 		request.fail(function( jqXHR, textStatus ) {
					  alert( "Request failed: " + textStatus );
					}); */
			}
		});
		
		//1차합격자 다음 단계 점수 부여
		$(document).on("click",".appScoring",function() {
			console.log($(this).parent().parent().children().eq(1).text());
		});
		
		//최종합격자 데이터 이관
		$(document).on("click",".appTransferred",function() {
			console.log($(this).parent().parent().children().eq(6).children().val());
			var docResult = $(this).parent().parent().children().eq(6).children().val();
			if(docResult != '최종합격') {
				alert('최종합격자만 가능합니다.');
			}
		});
});