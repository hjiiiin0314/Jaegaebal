/**
 * 
 */

$(function(){
	var pathName = $(location).attr('pathname');
	console.log(pathName);
	
	$('.app-sidebar').find('a').each(function(){
		if($(this).attr('href') == pathName){
			$(this).addClass('mm-active');
			$(this).parents('.second_menu_li').addClass('mm-active');
			$(this).parents('.first_menu_li').addClass('mm-active');
		}
	})
});