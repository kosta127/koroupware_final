$(function(){
	// CKEDITOR 사용 세팅
	CKEDITOR.replace('doc_contents');	
})

$(document).ready(
		function() { 
			var template = Handlebars.compile($("#template").html());

			$(".fileDrop").on("dragenter dragover", function(event) {
				event.preventDefault();
			});

			$(".fileDrop").on("drop", function(event) {
				event.preventDefault();

				var files = event.originalEvent.dataTransfer.files;

				var file = files[0];

				var formData = new FormData();

				formData.append("file", file);

				$.ajax({
					url : '/uploadAjax',
					data : formData,
					dataType : 'text',
					processData : false,
					contentType : false,
					type : 'POST',
					success : function(data) {
						console.log(data);
						var fileInfo = getFileInfo(data);

						var html = template(fileInfo);

						$(".uploadedList").append(html);
					}
				});
			});

			$("#registerForm").submit(
					function(event) {
						event.preventDefault();

						var that = $(this);

						var str = "";
						$(".uploadedList .delbtn").each(
								function(index) {
									str += "<input type='hidden' name='files["
											+ index + "]' value='"
											+ $(this).attr("href") + "'> ";
								});

						that.append(str);

						that.get(0).submit();
					});

			$(".uploadedList").on("click", ".delbtn", function(event) {
				event.preventDefault();
				var that = $(this);
				var fileName = $(this).attr("href");

				$.ajax({
					url : "/deleteFile",
					type : "post",
					data : {
						fileName : fileName
					},
					dataType : "text",
					success : function(result) {
						if (result == 'deleted') {
							that.parent("div").parent("li").remove();

						}
					}
				});

			});

		});

function fn_back() {
	history.back(-1);
}