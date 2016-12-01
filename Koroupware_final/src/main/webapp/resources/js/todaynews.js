// mbc : "http://imnews.imbc.com/rss/news/news_00.xml" utf-8
// sbs : "http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=all" utf-8
//조선뉴스 : "http://www.chosun.com/site/data/rss/rss.xml" euc-kr
//노컷뉴스 : "http://rss.nocutnews.co.kr/nocutnews.xml" utf-8
//동아뉴스 : "http://rss.donga.com/total.xml"

var rss_url = 'http://rss.donga.com/total.xml';

$(function(){
	$.ajax({
		url: '/todaynews/newsList',
		type: 'post',
		dataType: 'json',
		data : {rssUrl : rss_url},
		success: showNews	
	});
	
	var selectedNews = null;
	var selectedNewsDetail = null;
	
	function showNews(data){
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
					data: {'newsUrl' : item.link},
					//async: false,
					success: showNewsDetail
				});
			})
		});
	}	
	
	
	/** News Detail Items */
	/* 스크랩 버튼 */
	var $scrapbtn = $('<a>').attr('id', 'clip_btn').addClass('btn btn-default margin_left').text("이 기사를 스크랩");
	/* 스크랩 취소 버튼 */
	var $scrap_cancelbtn = $('<a>').attr('id', 'clip_cancel_btn').addClass('btn btn-danger margin_left').text("스크랩 취소");
	
	function showNewsDetail(data){
		selectedNewsDetail = $(data).find('div .article_txt'); //동아뉴스
		
		/** remove things */
		selectedNewsDetail.find('script').remove();
		selectedNewsDetail.find('div.recommend').remove();
		selectedNewsDetail.find('div.article_relation').remove();
		
		/** pop up */
		makeNewsView(selectedNews.title, selectedNews.pubDate, 
				selectedNewsDetail, selectedNews.link);
	}
	
	function makeNewsView(title, pubdate, contents, link){
		
		/** start making */
		var $wrapper = $('<div>').attr('id', 'white-popup-block').addClass('zoom-anim-dialog');
		var $title = $('<h1>').addClass('news_title').text(title);
		var $pubdate = $('<span>').addClass('detail_pubdate').text(pubdate);
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
				title: selectedNews.title,
				link: selectedNews.link,
				description: selectedNewsDetail.html().trim(),
				author: selectedNews.author,
				category: selectedNews.category,
				comments: selectedNews.comments,
				guid: selectedNews.guid,
				pubDate: selectedNews.pubDate
			},
			success: changeBtnStatus
		});
	});
	
	//스크랩 취소 버튼 클릭 
	$('body').on('click', '#clip_cancel_btn', function(){
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

	/****** 내가 스크랩한 뉴스 ******/
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
		var $tbody = $('#myclip_tbody')
		$.each(data, function(idx, item){
			$('<tr>').append($('<td>').text(idx+1))
					.append($('<td>').text((item.news_clipping_category==null)?
							"":item.news_clipping_category))
					.append($('<td>').text(item.news_clipping_title))
					.append($('<td>').text(item.news_clipping_regdate))
					.on('click', function(){
						/** pop up */
						makeNewsView(item.news_clipping_title,
								item.news_clipping_date,
								item.news_clipping_contents,
								item.news_clipping_link)
					})
					.appendTo($tbody);
		});
	}
	
});
