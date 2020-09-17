/**
 * 
 */

$(function(){
	/*현재 메뉴 경로와 같은 a태그를 찾아 a태그와 상위 객체를 활성화시키는 스크립트*/
	var pathName = $(location).attr('pathname');
	$('.app-sidebar').find('a').each(function(){
		if($(this).attr('href') == pathName){
			$(this).addClass('mm-active');
			$(this).parents('.third_menu_li').addClass('mm-active');
			$(this).parents('.second_menu_li').addClass('mm-active');
			$(this).parents('.first_menu_li').addClass('mm-active');
		}
	});
	
	/*두번째 메뉴중 하위메뉴가 없는 메뉴의 하위 개체 삭제*/
	$('.second_menu_li').children('ul').each(function(){
		if($(this).children('li').length == 0){
			$(this).prev('a').children('i').eq(1).remove();
			$(this).remove();
		}
	});
	
	/*세번째 메뉴중 하위메뉴가 없는 메뉴의 하위 개체 삭제*/
	$('.third_menu_li').children('ul').each(function(){
		if($(this).children('li').length == 0){
			$(this).prev('a').children('i').eq(1).remove();
			$(this).remove();
		}
	});
});