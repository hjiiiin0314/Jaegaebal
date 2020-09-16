/**
 * 
 */

$(function(){
	var pathName = $(location).attr('pathname');
	$('.app-sidebar').find('a').each(function(){
		if($(this).attr('href') == pathName){
			$(this).addClass('mm-active');
			$(this).parents('.third_menu_li').addClass('mm-active');
			$(this).parents('.second_menu_li').addClass('mm-active');
			$(this).parents('.first_menu_li').addClass('mm-active');
		}
	});
	
	$('.second_menu_li').children('ul').each(function(){
		if($(this).children('li').length == 0){
			$(this).prev('a').children('i').eq(1).remove();
			$(this).remove();
		}
	});
	
	$('.third_menu_li').children('ul').each(function(){
		if($(this).children('li').length == 0){
			$(this).prev('a').children('i').eq(1).remove();
			$(this).remove();
		}
	});
});