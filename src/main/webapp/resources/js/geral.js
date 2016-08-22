$(document).ready(function(){

		
	$("#buttonSlide").click(function(){
		
		$("#slideMenu").animate({
		    opacity: 1,
		    height: "toggle"
		}, 700);
		
		$("#logo").css("display","none");
		$("#buttonSlide").css("display","none");
		
	});
	
	$("#buttonClose").click(function(){
		
		$("#buttonSlide").animate({
		    opacity: 1,
		    height: "toggle"
		}, 250);
		
		$("#slideMenu").animate({
		    opacity: 1,
		    height: "toggle"
		}, 1);
		
	});
});

function slideLogin(){
		
	$("#painelCentral").animate({
	    height: "toggle"
	}, 500);
	
	$("#buttonLogar").css("display","none");
}
