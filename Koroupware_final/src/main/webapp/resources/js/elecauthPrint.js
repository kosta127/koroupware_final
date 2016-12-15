$(function() {
	$("#printButton").on('click', function() {
		console.log('hoho')
		var nowDate = new Date();
		$("#contents").print({ //#printable
			globalStyles : true, // Use Global styles
			mediaPrint : true, // Add link with attrbute media=print
			stylesheet : "http://fonts.googleapis.com/css?family=Inconsolata", // Custom stylesheet
			iframe : true, // Print in a hidden iframe
			noPrintSelector : ".avoid-this", // Don't print this
			prepend : "인쇄 미리보기", // Add this at top
			append : "<div><br>" + nowDate +  // Add this on bottom
				"<br>KoroupWare에서 출력하였습니다. 무단 배포및 무단 도용을 금지합니다.</div>" 
		});
	});
});

