$(function() {
	$("input#printButton").on('click', function() {
		var nowDate = new Date();
		$("#printable").print({
			// Use Global styles
			globalStyles : true,
			// Add link with attrbute media=print
			mediaPrint : true,
			// Custom stylesheet
			stylesheet : "http://fonts.googleapis.com/css?family=Inconsolata",
			// Print in a hidden iframe
			iframe : true,
			// Don't print this
			noPrintSelector : ".avoid-this",
			// Add this at top
			prepend : "인쇄 미리보기",
			// Add this on bottom
			append : new Date() + "<br>KoroupWare에서 출력하였습니다."
		});
	});
});