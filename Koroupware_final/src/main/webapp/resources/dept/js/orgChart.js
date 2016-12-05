$(function(){
	var $orgChartModelList;
	var $deptCollapse;
	var $myModal;
	var $myModalLabel;
	var $modalBody;
	
	function showOrgChartEmpModelDetailEvent(data){
		var html = "";
		
		$.each(data, function(index, e){
			if(e.classification == "myEmp"){
				$myModalLabel.html("<span>" + e.dept_name + " - " + e.emp_name +
						e.office_name + " (" + e.position_name + ")<span>");
						
				var imgTag = toSmallImgLink(e.emp_img);
				
				html += "<div>"
	 			html += "<img src='" + imgTag + "'/><br>";
				html += "<span>아이디 : " + e.emp_id + "</span><br>";
				html += "<span>이메일 : " + e.emp_email + "</span><br>";
				html += "<span>주소 : " + e.emp_address + "</span><br>";
				html += "<span>담당업무 : " + e.dept_work + "</span><br>";
				html += "</div>";
			}else if(e.classification == "superiorEmp"){
	 			html += "<div>";
				html += "<span>직속상관 : <a><span class='hidden'>" + e.emp_no + "</span>" + 
							e.dept_name + " - " + e.emp_name + e.office_name +
							" (" + e.position_name + ")</a></span><br>";
				html += "</div>";
	 		}else if(e.classification == "reporterEmp"){
	 			html += "<div>";
	 			html += "<span>직접보고자 : <a><span class='hidden'>" + e.emp_no + "</span>" +
	 						e.dept_name + " - " + e.emp_name + e.office_name +
	 						" (" + e.position_name + ")</a></span><br>";
				html += "</div>";
	 		}
		});

		$modalBody.html(html);
		$modalBody.find("a").on("click", orgChartClickEvent);
	}

	function orgChartClickEvent(){
		var empNo = $(this).find("span").html();
		
		$.ajax({
			url : "Read/" + empNo,
			type : "POST",
			dataType : "json",
			success : showOrgChartEmpModelDetailEvent
		});
	}

	$(function(){
		$orgChartModelList = $("div#orgChartModelList");
		$deptCollapse = $orgChartModelList.find(".panel-collapse");
		$myModal = $("div#myModal");
		$myModalLabel = $myModal.find("h4#myModalLabel");
		$modalBody = $myModal.find("div#modalBody");
		
		$.each($deptCollapse, function(index, item){
			$(this).find("a").on("click", orgChartClickEvent);
		});
	});

	$("#orgChartListSort").on("click", function(){
		$("#orgChartListSection").removeClass("hidden");
		$("#orgChartTreeSection").addClass("hidden");
	});

	$("#orgChartTreeSort").on("click", function(){
		$("#orgChartListSection").addClass("hidden");
		$("#orgChartTreeSection").removeClass("hidden");
	});

	function toSmallImgLink(emp_img){
		var head = emp_img.substring(0, emp_img.indexOf('.'));
		var pattern = emp_img.substring(emp_img.indexOf('.'));
			
		return "empImg?fileName=" + head + "_small" + pattern;
	}

	$.get('ReadTree', function(data){
		var jsonData = getTreeModel( data, 1, {
		    id: "emp_no",
		    parentId: "emp_superior"
		});
		
		$(".horizontalTreeTop").zooTree(jsonData, {
		    forceCreate: true,
		    render: function(data) {
		   		var imgTag = toSmallImgLink(data.emp_img);

		    	var $div = $("<a href='#myModal' data-toggle='modal'>")
		    		.append("<img src='"+ imgTag +"'/><br/>")
	    			.append(data.dept_name + " ")
	    			.append(data.emp_name + " ")
	    			.append(data.office_name)
	    			.append("<span class='hidden'>" + data.emp_no + "</span>")
	    			.on("click", orgChartClickEvent);
	    
	    		return $div;
		    }
		});
	});
});