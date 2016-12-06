$(function() {
	$("#printButton").on('click', function() {
		console.log('hoho')
		var nowDate = new Date();
		$("#contents").print({ //#printable
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
			append : "<div><br>" + nowDate + "<br>KoroupWare에서 출력하였습니다. 무단 배포및 무단 도용을 금지합니다.</div>"
		});
	});
});