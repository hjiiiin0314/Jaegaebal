/**
 * 인터넷 익스플로러 감지 후 화면 강제이동 JS
 */
var agent = navigator.userAgent.toLowerCase();

if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
	location.href = "error/ie_block"
}