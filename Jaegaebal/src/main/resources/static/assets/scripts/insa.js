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
	
	$(function(){
		
		$('#insertStaff').click(function(){
			var staffPhone = $('.staff_phone_val').addHyphen();
			$('#staff_phone_val').attr("name", staffPhone);
			console.log($('#staff_phone_val').attr("name"));
			
			var familyPhone = $('.family_phone_val').addHyphen();
			$('#family_phone_val').attr("name", familyPhone);
			console.log($('#family_phone_val').attr("name"));
			
			var familyPhone = $('.human_num').addHyphen();
			$('#human_num_val').attr("name", familyPhone);
			console.log($('#human_num_val').attr("name"));
			
			var formsNum = $('.forms').length;
			var formsVal = $('.forms').val();
			var str = $('[name=project_start_date]').val();
			var val = $('[name=project_start_date]').val();
			console.log(formsNum, "<<<<<<<<formsNum");
			console.log(str, "<<<<<<<str<<<<<<");
/*			for(var i=0; i<formsNum; i++){
				if(){
					
				}
			}*/

		});


        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
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
		

		
		
		
		
		
		
		
		
	});