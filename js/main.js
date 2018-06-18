
$(document).ready(function(){

	prepareIcon();
	
});

$(window).resize(function() { 
	
	prepareIcon();

});
function prepareIcon(){

	var width = $(".social-icon").width();
	$(".social-icon").css("height",width+"px");
	$(".social-icon").css("font-size",0.5*width+"px");
	$(".social-icon").css("line-height",width+"px");
	
}

