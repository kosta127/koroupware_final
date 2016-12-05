var rss_url = 'http://www.chosun.com/site/data/rss/rss.xml';

$(function(){
	var selectedNews = null;
	var selectedNewsDetail = null;
	var selectedNewsCompany = null;
	var newsCompanyList = null;
	
	getNewsCompanyList();
	
	//뉴스사 목록 가져오기
	function getNewsCompanyList(){
		$.ajax({
			url: '/todaynews/newsCompanyList',
			type: 'post',
			dataType: 'json',
			success: makeNewsCompanyList	
		});
	}
	
	//번호로 뉴스사 가져오기
	function getNewsCompany(newsCompanyNo){
		if(newsCompanyList == null) return;
		for(var i=0; i< newsCompanyList.length; i++){
			if(newsCompanyList[i].news_company_no == newsCompanyNo){
				return newsCompanyList[i];
			}
		}
	}
	
	//뉴스사 목록 만들기
	function makeNewsCompanyList(newsCompanies){
		newsCompanyList = newsCompanies;
		
		var $wrapdiv = $('<div>').attr('id', 'newsCompany_div')
								.addClass('form-group').appendTo('#todaynews_div');
		var $label = $('<label>').attr('for', 'newsCompanyList')
							.text('뉴스사').appendTo($wrapdiv);
		var $selectList = $('<select>').attr('id', 'newsCompanyList')
								.addClass('form-control')
								.appendTo($wrapdiv);
		for(var i=0; i < newsCompanies.length; i++){
			$('<option>').val(newsCompanies[i].news_company_no)
						.text(newsCompanies[i].news_company_name)
						.appendTo($selectList);
		}
		
		$selectList.on('change', function(){
			$('#todaynews_div').find('div.newsdesc').remove();
			var newsComp = getNewsCompany($(this).val());
			selectedNewsCompany = newsComp;
			getNewsList(newsComp.news_company_no, newsComp.news_company_rssurl);
		});
		
		//뉴스사 하나를 기본으로 선택한다
		if(newsCompanyList != null && newsCompanyList.length >= 1){
			selectedNewsCompany = newsCompanyList[0];
			getNewsList(selectedNewsCompany.news_company_no, 
					selectedNewsCompany.news_company_rssurl);
		}
	}
	
	function getNewsList(newsCompanyNo, rssUrl){
		console.log('get news list -> ' + newsCompanyNo )
		var newsListAttr = {
				url: '/todaynews/newsList',
				type: 'post',
				dataType: 'json',
				data: {
					news_company_no : ((newsCompanyNo==null)?-1:newsCompanyNo),
					news_company_rssurl : rssUrl
				},
				success: showNews	
			};		
		$.ajax(newsListAttr);
	}
	
	function showNews(data){
		//뉴스목록만듦
		$.each(data, function(idx, item){
			var category = (item.category==null)?'':item.category;
			var newsHtml = '<div class="newsdesc">';
			newsHtml += '<span class="category">'+category+'</span>';
			newsHtml += '<span class="title">'+item.title+'</span>';
			if(idx==0) newsHtml += '<div class="description">'+item.description+'</div>'; 
			newsHtml += '<span class="link">'+item.link+'</span>';
			newsHtml += '</div>';
			var newsObj = $(newsHtml);
			
			$('#todaynews_div').append(newsObj);
			newsObj.on('click', function(){
				selectedNews = item;
				$.ajax({
					url: '/todaynews/newsRead',
					type: 'post',
					dataType: 'html',
					data: {
						'newsUrl' : item.link,
						'charset' : selectedNewsCompany.news_company_charset
					},
					//async: false,
					success: showNewsDetail
				});
			})
		});
	}
	
	
	
	/************************************************************************************/
	/** News Detail Items */
	/************************************************************************************/
	/* 스크랩 버튼 */
	var $scrapbtn = $('<a>').attr('id', 'clip_btn').addClass('btn btn-default margin_left').text("이 기사를 스크랩");
	/* 스크랩 취소 버튼 */
	var $scrap_cancelbtn = $('<a>').attr('id', 'clip_cancel_btn').addClass('btn btn-danger margin_left').text("스크랩 취소");
	
	function showNewsDetail(data){
		selectedNewsDetail = $(data).find(selectedNewsCompany.news_company_filter_pattern);
		
		console.log(selectedNewsDetail.html());
		
		/** remove things */
		selectedNewsDetail.find('script').remove();
		selectedNewsDetail.find('div.recommend').remove();
		selectedNewsDetail.find('div.article_relation').remove();
		selectedNewsDetail.find('div#articleText table').removeAttr('style');
		selectedNewsDetail.find('div').removeAttr('style');
		selectedNewsDetail.find('img').removeAttr('width').removeAttr('height');
		selectedNewsDetail.find('b:contains("▲")').remove(); //조선뉴스
		
		/** pop up */
		makeNewsView(selectedNews.title, selectedNews.pubDate, 
				selectedNewsDetail, selectedNews.link);
	}
	
	function makeNewsView(title, pubdate, contents, link){
		
		/** start making */
		var $wrapper = $('<div>').attr('id', 'white-popup-block').addClass('zoom-anim-dialog');
		var $title = $('<h1>').addClass('news_title').text(title);
		var $pubdate = $('<span>').addClass('detail_pubdate').text((pubdate==null)?'':pubdate);
		$wrapper.append($('<div>').attr('id', 'detail_top').addClass('pull-right padding_topbottom').append($pubdate));
		$wrapper.append($('<div>').addClass('detail_title padding_bottom').append($title));
		$wrapper.append(contents);
		
		$.magnificPopup.open({
			  items: {
			    src: $wrapper,
			    type: 'inline'
			  },
			  closeOnContentClick: false,
			  /*callbacks: {
				    close: function() {
				    	selectedNews = null;
				    	selectedNewsDetail = null;
				    }
				  },*/
			  mainClass: 'my-mfp-zoom-in'
			}, 0);
		
		//스크랩한 뉴스인지 확인 (링크로 확인)
		$.ajax({
			url: '/todaynews/newsCheck',
			type: 'post',
			dataType: 'text',
			data: {'link': link},
			success: makeScrapBtn
		})
	}
	
	//스크랩 버튼 클릭
	$('body').on('click', '#clip_btn', function(){
		$.ajax({
			url: '/todaynews/newsRegist',
			type: 'post',
			dataType: 'text',
			data: {
				company: selectedNewsCompany.news_company_no,
				title: selectedNews.title,
				link: selectedNews.link,
				description: selectedNewsDetail.html().trim(),
				author: selectedNews.author,
				category: selectedNews.category,
				comments: selectedNews.comments,
				guid: selectedNews.guid,
				pubDate: (selectedNews.pubDate==null)?'':selectedNews.pubDate
			},
			success: changeBtnStatus
		});
	});
	
	//스크랩 취소 버튼 클릭 
	$('body').on('click', '#clip_cancel_btn', function(){
		console.log('clicked');
		console.log(selectedNews)
		
		$.ajax({
			url: '/todaynews/newsDelete',
			type: 'post',
			dataType: 'text',
			data: {
				link: selectedNews.link
			},
			success: changeBtnStatus
		});
	});
	
	// 스크랩 버튼 생성
	function makeScrapBtn(data){
		var $top = $('#detail_top');
		if(data == 'exist'){
			$top.append($scrap_cancelbtn);
		}else{
			$top.append($scrapbtn);
		}
	}
	
	// 스크랩/스크랩취소 버튼을 누르면 성공 여부에 따라 버튼 상태를 바꿈
	function changeBtnStatus(data){
		var $top = $('#detail_top');
		if(data == 'reg_ok'){ //등록 성공
			$top.find('#clip_btn').remove();
			$top.append($scrap_cancelbtn);
		}else if(data == 'del_ok'){ //삭제 성공
			$top.find('#clip_cancel_btn').remove();
			$top.append($scrapbtn);
		}else{ // ???
			alert("뉴스 스크랩 실패! 관리자에게 문의하세요");
		}
	}

	/************************************************************************************/
	/****** 내가 스크랩한 뉴스 ******/
	/************************************************************************************/
	$('#myclip_div').hide(); // 처음엔 내 뉴스 안보이게,
	
	$('#news_tab').find('#news_latest').addClass('active'); //탭
	
	//최신 뉴스 탭 클릭
	$('#news_latest').on('click', function(){
		$('#news_tab li').removeClass('active');
		$(this).addClass('active');
		$('#todaynews_div').show();
		$('#myclip_div').hide();		
	});
	
	//내 스크랩 뉴스 탭 클릭
	$('#news_myclip').on('click', function(){
		$('#news_tab li').removeClass('active');
		$(this).addClass('active');
		$('#todaynews_div').hide();
		$('#myclip_div').show();
		getMyClipList();
	});
	
	//스크랩한 뉴스 목록 가져옴
	function getMyClipList(){
		$.ajax({
			url: '/todaynews/myNewsList',
			type: 'post',
			dataType: 'json',
			success: makeMyClipList
		});
	}
	
	//스크랩한 뉴스 목록 만듦
	function makeMyClipList(data){
		console.log(data);
		var $tbody = $('#myclip_tbody').html('');
		$.each(data, function(idx, item){
			$('<tr>').append($('<td>').text(idx+1))
					.append($('<td>').text((item.category==null)?
							"":item.category))
					.append($('<td>').text(item.title))
					.append($('<td>').text(item.regDate))
					.on('click', function(){
						/** pop up */
						makeNewsView(item.title,
								item.pubDate,
								item.description,
								item.link)
						selectedNews = item;
					})
					.appendTo($tbody);
		});
	}
	
});
