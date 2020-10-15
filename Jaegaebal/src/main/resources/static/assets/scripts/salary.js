/**
 * File : salary.js
 * Author : LYS
 * detail : 급여관리 화면 전반 스크립트
 */

$(function(){
	//salary_info.html
	//사원 가장 첫 데이터가 자동으로 선택되므로 파란색 처리
	$('.emp-info-table').children('tbody').children('tr').eq(0).addClass('emp-table-on');
	
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
			$('.emp-table').children('tbody').children('input').remove();
			for(var i=0;i<data.length;i++){
				$('.emp-table').children('tbody').append('<tr><input type="hidden" name="monthNum" value="'+data[i].dataNum+'"><td>'+data[i].staffNum+'</td><td>'+data[i].staffName+'</td><td>'+data[i].levelName+'</td><td>'+data[i].jojicName+'</td></tr>');
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
	$(document).on('click', '.emp-info-table tbody tr', function(){
		$('.emp-info-table').children('tbody').children('tr').removeClass('emp-table-on');
		$(this).addClass('emp-table-on');
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
	
	//salary_month.html
	//사원 가장 첫 데이터가 자동으로 선택되므로 파란색 처리
	$('.emp-month-table').children('tbody').children('tr').eq(0).addClass('emp-table-on');
	
	//월별급여화면에서 사원 정보 클릭시 ajax통신을 통한 월별급여 조회
	$(document).on('click', '.emp-month-table tbody tr', function(){
		$('.emp-month-table').children('tbody').children('tr').removeClass('emp-table-on');
		$(this).addClass('emp-table-on');
		var dataNum = $(this).children('input[name=monthNum]').val();
		$('input[name=searchNum]').val(dataNum);
		var searchYear = $('select[name=searchYear]').val();
		var request = $.ajax({
			url : "/salary/salary_month",
			method : "POST",
			data : { dataNum : dataNum ,
				searchYear : searchYear},
			dataType : "json"
		});
		
		request.done(function(data){
			$('.month-table').children('tbody').children('tr').remove();
			for(var i=0;i<data.length;i++){
				$('.month-table').children('tbody').append('<tr><td class="fixed_left">'+data[i].cate+'</td><td>'+data[i].plus+'</td><td>'+data[i].M1+'</td><td>'+data[i].M2+'</td><td>'+data[i].M3+'</td><td>'+data[i].M4+'</td><td>'+data[i].M5+'</td><td>'+data[i].M6+'</td><td>'+data[i].M7+'</td><td>'+data[i].M8+'</td><td>'+data[i].M9+'</td><td>'+data[i].M10+'</td><td>'+data[i].M11+'</td><td>'+data[i].M12+'</td></tr>');
			}
			
		});
		
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
	});
	
	//월별급여화면에서 연도 선택시 ajax통신을 통한 월별급여 조회
	$('select[name=searchYear]').change(function(){
		var dataNum = $('input[name=searchNum]').val();
		var searchYear = $('select[name=searchYear]').val();
		var request = $.ajax({
			url : "/salary/salary_month",
			method : "POST",
			data : { dataNum : dataNum ,
				searchYear : searchYear },
			dataType : "json"
		});
		
		request.done(function(data){
			$('.month-table').children('tbody').children('tr').remove();
			for(var i=0;i<data.length;i++){
				$('.month-table').children('tbody').append('<tr><td class="fixed_left">'+data[i].cate+'</td><td>'+data[i].plus+'</td><td>'+data[i].M1+'</td><td>'+data[i].M2+'</td><td>'+data[i].M3+'</td><td>'+data[i].M4+'</td><td>'+data[i].M5+'</td><td>'+data[i].M6+'</td><td>'+data[i].M7+'</td><td>'+data[i].M8+'</td><td>'+data[i].M9+'</td><td>'+data[i].M10+'</td><td>'+data[i].M11+'</td><td>'+data[i].M12+'</td></tr>');
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
			$('input[name=dataBatePer]').val('0');
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
			$('input[name=dataTax]').val('0');
			$('input[name=dataTaxDate1]').val('');
			$('input[name=dataTaxDate2]').val('');
		}
	});
	
	$('input[name=dataTax').keyup(function(){
		if($(this).val() == null || $(this).val() == ''){
			$(this).val(0);
		}
	});
	
	$('input[name=dataBatePer').keyup(function(){
		if($(this).val() == null || $(this).val() == ''){
			$(this).val(0);
		}
	});
	
	//급여상세정보 저장 전 재확인 메세지
	function updateCheck(form){
		var result = confirm('급여상세정보를 저장하시겠습니까?');
		if(!result){
			return false;
		}
	}
	
	//salary_record.html
	//사원 가장 첫 데이터가 자동으로 선택되므로 파란색 처리
	$('.emp-record-table').children('tbody').children('tr').eq(0).addClass('emp-table-on');
	
	$( "#datepicker" ).datepicker({
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        showMonthAfterYear: true,
        yearRange: 'c-99:c+99',
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        dateFormat: 'yy-mm',
        onClose: function(dateText, inst) { 
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
           	//날짜 선택 시 날짜 선택 ajax이벤트 발동
            schData(month, year);
        },
        beforeShow : function(input, inst) {
            if ((datestr = $(this).val()).length > 0) {
                actDate = datestr.split('-');
                year = actDate[0];
                month = actDate[1]-1;
                $(this).datepicker('option', 'defaultDate', new Date(year, month));
                $(this).datepicker('setDate', new Date(year, month));
            }
        }
    });
	
	//필터에서 년월이 선택되었을 시 ajax 통신
	function schData(month, year){
		month = numFormat(Number(month)+1);
		var dataNum = $('input[name=searchNum]').val();
		var searchDate = year+"-"+month;
		$('input[name=dateValue]').val(searchDate);
		var request = $.ajax({
			url : "/salary/search_data",
			method : "POST",
			data : { dataNum : dataNum ,
				searchDate : searchDate },
			dataType : "Json"
		});
		
		request.done(function(data){
			$('input[name=dataNum]').val(data.dataNum);
			$('input[name=dataNormal]').val(data.dataNormal);
			$('input[name=dataBonus]').val(data.dataBonus);
			$('input[name=dataMalus]').val(data.dataMalus);
			$('input[name=dataAnn]').val(data.dataAnn);
			$('input[name=dataVehicle]').val(data.dataVehicle);
			$('input[name=dataMeal]').val(data.dataMeal);
			$('input[name=dataOvertime]').val(data.dataOvertime);
			$('input[name=dataNight]').val(data.dataNight);
			$('input[name=dataHoli]').val(data.dataHoli);
			$('input[name=dataGukmin]').val(data.dataGukmin);
			$('input[name=dataGeongang]').val(data.dataGeongang);
			$('input[name=dataKhoyong]').val(data.dataKhoyong);
			$('input[name=dataJanggi]').val(data.dataJanggi);
			$('input[name=dataSanjae]').val(data.dataSanjae);
			$('input[name=dataSchexpan]').val(data.dataSchexpan);
			$('input[name=dataIncome]').val(data.dataIncome);
			$('input[name=dataLoincome]').val(data.dataLoincome);
			$('input[name=sqlKey]').val(data.sqlKey);
			//데이터가 있어서 upd처리 시 월별 데이터에 저장된 항목과 값들이 저장됨 ins면 항목테이블의 항목들을 물러오는 ajax를 실행하여 값을 출력
			if(data.sqlKey == "upd"){
				if(data.dataAddpay != null){
					var addpay = data.dataAddpay.split('&');
					var pricepay = data.dataPricepay.split('&');
					$('.pay-table').children('tbody').children('tr').remove();
					for(var i in addpay) {
						$('.pay-table').children('tbody').append('<tr><td><input class="border-none" type="text" name="payName" value="'+addpay[i]+'" readonly></td><td><input class="form-control number-form" type="number" name="payPrice" value="'+pricepay[i]+'"></td></tr>');
					}
				} else {
					$('.pay-table').children('tbody').children('tr').remove();
				}
				
				if(data.dataAdddeduct != null){
					var adddeduct = data.dataAdddeduct.split('&');
					var pricededuct = data.dataPricededuct.split('&');
					$('.deduct-table').children('tbody').children('tr').remove();
					for(var i in adddeduct) {
						$('.deduct-table').children('tbody').append('<tr><td><input class="border-none" type="text" name="deductName" value="'+adddeduct[i]+'" readonly></td><td><input class="form-control number-form" type="number" name="deductPrice" value="'+pricededuct[i]+'"></td></tr>');
					}
				} else {
					$('.deduct-table').children('tbody').children('tr').remove();
				}
			} else if(data.sqlKey == "ins"){
				insAjax();
			}
		});
		
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
	}
	
	function insAjax(){
		var request = $.ajax({
			url : "/salary/insert_data",
			method : "POST",
			data : { },
			dataType : "Json"
		});
		
		request.done(function(data){
			$('.pay-table').children('tbody').children('tr').remove();
			for(var i=0;i<data[0].length;i++) {
				$('.pay-table').children('tbody').append('<tr><td><input class="border-none" type="text" name="payName" value="'+data[0][i].payName+'" readonly></td><td><input class="form-control number-form" type="number" name="payPrice" value="0"></td></tr>');
			}
			
			$('.deduct-table').children('tbody').children('tr').remove();
			for(var j=0;j<data[1].length;j++) {
				$('.deduct-table').children('tbody').append('<tr><td><input class="border-none" type="text" name="deductName" value="'+data[1][j].deductName+'" readonly></td><td><input class="form-control number-form" type="number" name="deductPrice" value="0"></td></tr>');
			}
		});
		
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
	}
	//급상여입력화면에서 사원 정보 클릭시 ajax통신을 통한 사원급여 존재여부 조회
	$(document).on('click', '.emp-record-table tbody tr', function(){
		//클릭한 사원 파란색 유지
		$('.emp-record-table').children('tbody').children('tr').removeClass('emp-table-on');
		$(this).addClass('emp-table-on');
		var dataNum = $(this).children('input[name=monthNum]').val();
		$('input[name=searchNum]').val(dataNum);
		$('input[name=dataData]').val(dataNum);
		var searchDate = $('#datepicker').val();
		var request = $.ajax({
			url : "/salary/search_data",
			method : "POST",
			data : { dataNum : dataNum ,
				searchDate : searchDate },
			dataType : "Json"
		});
		
		request.done(function(data){
			$('input[name=dataNum]').val(data.dataNum);
			$('input[name=dataNormal]').val(data.dataNormal);
			$('input[name=dataBonus]').val(data.dataBonus);
			$('input[name=dataMalus]').val(data.dataMalus);
			$('input[name=dataAnn]').val(data.dataAnn);
			$('input[name=dataVehicle]').val(data.dataVehicle);
			$('input[name=dataMeal]').val(data.dataMeal);
			$('input[name=dataOvertime]').val(data.dataOvertime);
			$('input[name=dataNight]').val(data.dataNight);
			$('input[name=dataHoli]').val(data.dataHoli);
			$('input[name=dataGukmin]').val(data.dataGukmin);
			$('input[name=dataGeongang]').val(data.dataGeongang);
			$('input[name=dataKhoyong]').val(data.dataKhoyong);
			$('input[name=dataJanggi]').val(data.dataJanggi);
			$('input[name=dataSanjae]').val(data.dataSanjae);
			$('input[name=dataSchexpan]').val(data.dataSchexpan);
			$('input[name=dataIncome]').val(data.dataIncome);
			$('input[name=dataLoincome]').val(data.dataLoincome);
			$('input[name=sqlKey]').val(data.sqlKey);
			//데이터가 있어서 upd처리 시 월별 데이터에 저장된 항목과 값들이 저장됨 ins면 항목테이블의 항목들을 물러오는 ajax를 실행하여 값을 출력
			if(data.sqlKey == "upd"){
				if(data.dataAddpay != null){
					var addpay = data.dataAddpay.split('&');
					var pricepay = data.dataPricepay.split('&');
					$('.pay-table').children('tbody').children('tr').remove();
					for(var i in addpay) {
						$('.pay-table').children('tbody').append('<tr><td><input class="border-none" type="text" name="payName" value="'+addpay[i]+'" readonly></td><td><input class="form-control number-form" type="number" name="payPrice" value="'+pricepay[i]+'"></td></tr>');
					}
				} else {
					$('.pay-table').children('tbody').children('tr').remove();
				}
				
				if(data.dataAdddeduct != null){
					var adddeduct = data.dataAdddeduct.split('&');
					var pricededuct = data.dataPricededuct.split('&');
					$('.deduct-table').children('tbody').children('tr').remove();
					for(var i in adddeduct) {
						$('.deduct-table').children('tbody').append('<tr><td><input class="border-none" type="text" name="deductName" value="'+adddeduct[i]+'" readonly></td><td><input class="form-control number-form" type="number" name="deductPrice" value="'+pricededuct[i]+'"></td></tr>');
					}
				} else {
					$('.deduct-table').children('tbody').children('tr').remove();
				}
			} else if(data.sqlKey == "ins"){
				insAjax();
			}
		});
		
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
	});
	
	//월 1자리 일 시 앞에 0 붙임
	function numFormat(variable) { 
		variable = Number(variable).toString(); 
		if(Number(variable) < 10 && variable.length == 1) 
			variable = "0" + variable; return variable; 
	}
	
	//number-form 클래스가 있는 input들 공백으로 만들면 자동으로 0생성
	$('.number-form').keyup(function(){
		if($(this).val() == null || $(this).val() == ''){
			$(this).val(0);
		}
	});
});