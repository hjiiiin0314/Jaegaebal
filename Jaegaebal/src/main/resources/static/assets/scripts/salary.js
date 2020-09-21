/**
 * File : salary.js
 * Author : LYS
 * detail : 급여관리 화면 전반 스크립트
 */

$(function(){
	//사원 검색 기능
	$('#search_submit').click(function(){
		var searchCate = $('[name=searchCate]').val();
		var searchText = $('[name=searchText]').val();
		var searchLevel = $('[name=searchLevel]').val();
		var searchJojic = $('[name=searchJojic]').val();
		var ajaxArray = new Array();
		ajaxArray.push(searchCate);
		ajaxArray.push(searchText);
		ajaxArray.push(searchLevel);
		ajaxArray.push(searchJojic);
		var request = $.ajax({
			url : "/salary/salary_search",
			method : "POST",
			data : { "ajaxArray[]" : ajaxArray },
			dataType : "json"
		});
		
		request.done(function(data){
			$('.emp-table').children('tbody').children('tr').remove();
			for(var i=0;i<data.length;i++){
				$('.emp-table').children('tbody').append('<tr><td>'+data[i].staffNum+'</td><td>'+data[i].staffName+'</td><td>'+data[i].levelName+'</td><td>'+data[i].jojicName+'</td></tr>');
			}
		});
		
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
	});
	
	$('[name=searchCate]').change(function(){
		if($(this).val() == 1){
			$('[name=searchText]').removeClass('search-none');
			if(!$('[name=searchLevel]').hasClass('search-none')){
				$('[name=searchLevel]').addClass('search-none');
			}
			if(!$('[name=searchJojic]').hasClass('search-none')){
				$('[name=searchJojic]').addClass('search-none');
			}
		} else if($(this).val() == 2){
			$('[name=searchText]').removeClass('search-none');
			if(!$('[name=searchLevel]').hasClass('search-none')){
				$('[name=searchLevel]').addClass('search-none');
			}
			if(!$('[name=searchJojic]').hasClass('search-none')){
				$('[name=searchJojic]').addClass('search-none');
			}
		} else if($(this).val() == 3){
			$('[name=searchLevel]').removeClass('search-none');
			if(!$('[name=searchText]').hasClass('search-none')){
				$('[name=searchText]').addClass('search-none');
			}
			if(!$('[name=searchJojic]').hasClass('search-none')){
				$('[name=searchJojic]').addClass('search-none');
			}
		} else {
			$('[name=searchJojic]').removeClass('search-none');
			if(!$('[name=searchText]').hasClass('search-none')){
				$('[name=searchText]').addClass('search-none');
			}
			if(!$('[name=searchLevel]').hasClass('search-none')){
				$('[name=searchLevel]').addClass('search-none');
			}
		}
		
	});
	
	//사원 정보 클릭시 ajax통신을 통한 급여정보 조회
	$('.emp-table').children('tbody').children('tr').click(function(){
		var dataEmp = $(this).children('td').eq(0).text();
		var request = $.ajax({
			url : "/salary/salary_info",
			method : "POST",
			data : { dataEmp : dataEmp },
			dataType : "json"
		});
		
		request.done(function(data){
			if(data.dataNum != null){
				$('input[name=dataNum]').val(data.dataNum);
			} else {
				$('input[name=dataNum]').val('');
			}
			
			if(data.humanNum != null){
				$('input[name=human_num]').val(data.humanNum);
			} else {
				$('input[name=human_num]').val('');
			}
			
			if(data.companyInDate != null){
				$('input[name=company_in_date]').val(data.companyInDate);
			} else {
				$('input[name=company_in_date]').val('');
			}
			
			if(data.companyOutDate != null){
				$('input[name=company_out_date]').val(data.companyOutDate);
			} else {
				$('input[name=company_out_date]').val('');
			}
			
			if(data.dataInsu != null){
				$('select[name=dataInsu]').children('option').each(function(){
					if($(this).attr('value') == data.dataInsu){
						$(this).prop('selected', 'true');
					}
				});
			}
			
			if(data.staffNationality != null){
				$('input[name=staff_nationality]').val(data.staffNationality);
			} else {
				$('input[name=staff_nationality]').val('');
			}
			
			if(data.dataResi != null){
				$('select[name=dataResi]').children('option').each(function(){
					if($(this).val() == data.dataResi){
						$(this).prop('selected', true);
					}
				});
			}
			
			if(data.staffCountry != null){
				$('input[name=staff_country]').val(data.staffCountry);
			} else {
				$('input[name=staff_country]').val('');
			}
			
			if(data.dataPro != null){
				if(data.dataPro == 1){
					$('input[name=dataPro]').prop('checked', true);
				} else {
					$('input[name=dataPro]').prop('checked', false);
				}
			}
			
			if(data.dataBank != null){
				$('input[name=dataBank]').val(data.dataBank);
			} else {
				$('input[name=dataBank]').val('');
			}
			
			if(data.dataAccount != null){
				$('input[name=dataAccount]').val(data.dataAccount);
			} else {
				$('input[name=dataAccount]').val('');
			}
			
			if(data.dataHost != null){
				$('input[name=dataHost]').val(data.dataHost);
			} else {
				$('input[name=dataHost]').val('');
			}
			
			if(data.dataScrib != null){
				$('input[name=dataScrib]').val(data.dataScrib);
			} else {
				$('input[name=dataScrib]').val('');
			}
			
			if(data.staffPhone != null){
				$('input[name=staff_phone]').val(data.staffPhone);
			} else {
				$('input[name=staff_phone]').val('');
			}
			
			if(data.staffEmail != null){
				$('input[name=staff_email]').val(data.staffEmail);
			} else {
				$('input[name=staff_email]').val('');
			}
			
			if(data.dataBatePer != null){
				$('input[name=dataBatePer]').val(data.dataBatePer);
			} else {
				$('input[name=dataBatePer]').val('');
			}
			
			if(data.dataBateDate1 != null){
				$('input[name=dataBateDate1]').val(data.dataBateDate1);
			} else {
				$('input[name=dataBateDate1]').val('');
			}
			
			if(data.dataBateDate2 != null){
				$('input[name=dataBateDate2]').val(data.dataBateDate2);
			} else {
				$('input[name=dataBateDate2]').val('');
			}
			
			if(data.dataBate != null){
				if(data.dataBate == 1){
					$('input[name=dataBate]').prop('checked', true);
					$('input[name=dataBatePer]').prop('readonly', false);
					$('input[name=dataBateDate1]').prop('readonly', false);
					$('input[name=dataBateDate2]').prop('readonly', false);
				} else {
					$('input[name=dataBate]').prop('checked', false);
					$('input[name=dataBatePer]').prop('readonly', true);
					$('input[name=dataBateDate1]').prop('readonly', true);
					$('input[name=dataBateDate2]').prop('readonly', true);
					$('input[name=dataBatePer]').val('');
					$('input[name=dataBateDate1]').val('');
					$('input[name=dataBateDate2]').val('');
				}
			}
			
			if(data.dataExpenDate1 != null){
				$('input[name=dataExpenDate1]').val(data.dataExpenDate1);
			} else {
				$('input[name=dataExpenDate1]').val('');
			}
			
			if(data.dataExpenDate2 != null){
				$('input[name=dataExpenDate2]').val(data.dataExpenDate2);
			} else {
				$('input[name=dataExpenDate2]').val('');
			}
			
			if(data.dataExpen != null){
				$('select[name=dataExpen]').children('option').each(function(){
					if($(this).val() == data.dataExpen){
						$(this).prop('selected', true);
						if($(this).val() == 1){
							$('input[name=dataExpenDate1]').prop('readonly', false);
							$('input[name=dataExpenDate2]').prop('readonly', false);
						} else {
							$('input[name=dataExpenDate1]').prop('readonly', true);
							$('input[name=dataExpenDate2]').prop('readonly', true);
							$('input[name=dataExpenDate1]').val('');
	  						$('input[name=dataExpenDate2]').val('');
						}
					}
				});
			}
			
			if(data.dataTax != null){
				$('input[name=dataTax]').val(data.dataTax);
			} else {
				$('input[name=dataTax]').val('');
			}
			
			if(data.dataTaxDate1 != null){
				$('input[name=dataTaxDate1]').val(data.dataTaxDate1);
			} else {
				$('input[name=dataTaxDate1]').val('');
			}
			
			if(data.dataTaxDate2 != null){
				$('input[name=dataTaxDate2]').val(data.dataTaxDate2);
			} else {
				$('input[name=dataTaxDate2]').val('');
			}
			
			if(data.dataTaxdepart != null){
				if(data.dataTaxdepart == 1){
					$('input[name=dataTaxdepart]').prop('checked', true);
					$('input[name=dataTax]').prop('readonly', false);
					$('input[name=dataTaxDate1]').prop('readonly', false);
					$('input[name=dataTaxDate2]').prop('readonly', false);
				} else {
					$('input[name=dataTaxdepart]').prop('checked', false);
					$('input[name=dataTax]').prop('readonly', true);
					$('input[name=dataTaxDate1]').prop('readonly', true);
					$('input[name=dataTaxDate2]').prop('readonly', true);
					$('input[name=dataTax]').val('');
					$('input[name=dataTaxDate1]').val('');
					$('input[name=dataTaxDate2]').val('');
				}
			}
		});
		
		request.fail(function( jqXHR, textStatus ) {
		  alert( "Request failed: " + textStatus );
		});
	});
	
	//체크박스 클릭 시 연관 입력폼 활성화,비활성화
	$('input[name=dataBate]').click(function(){
		if($(this).prop('checked')){
			$('input[name=dataBatePer]').prop('readonly', false);
			$('input[name=dataBateDate1]').prop('readonly', false);
			$('input[name=dataBateDate2]').prop('readonly', false);
		} else {
			$('input[name=dataBatePer]').prop('readonly', true);
			$('input[name=dataBateDate1]').prop('readonly', true);
			$('input[name=dataBateDate2]').prop('readonly', true);
			$('input[name=dataBatePer]').val('');
			$('input[name=dataBateDate1]').val('');
			$('input[name=dataBateDate2]').val('');
		}
	});
	
	$('select[name=dataExpen]').change(function(){
		if($(this).val() == 1){
			$('input[name=dataExpenDate1]').prop('readonly', false);
			$('input[name=dataExpenDate2]').prop('readonly', false);
		} else {
			$('input[name=dataExpenDate1]').prop('readonly', true);
			$('input[name=dataExpenDate2]').prop('readonly', true);
			$('input[name=dataExpenDate1]').val('');
			$('input[name=dataExpenDate2]').val('');
		}
	});
	
	$('input[name=dataTaxdepart]').click(function(){
		if($(this).prop('checked')){
			$('input[name=dataTax]').prop('readonly', false);
			$('input[name=dataTaxDate1]').prop('readonly', false);
			$('input[name=dataTaxDate2]').prop('readonly', false);
		} else {
			$('input[name=dataTax]').prop('readonly', true);
			$('input[name=dataTaxDate1]').prop('readonly', true);
			$('input[name=dataTaxDate2]').prop('readonly', true);
			$('input[name=dataTax]').val('');
			$('input[name=dataTaxDate1]').val('');
			$('input[name=dataTaxDate2]').val('');
		}
	});
	
	//급여상세정보 저장 전 재확인 메세지
	function updateCheck(form){
		var result = confirm('급여상세정보를 저장하시겠습니까?');
		if(!result){
			return false;
		}
	}
});