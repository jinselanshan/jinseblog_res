$(function(){
	/*
	 * 当页面滚动会无限加载数据展示到页面。当鼠标放置上去会变色。当底部加载更多按钮出现时，通过 ajax 发送请求获取数据，append
	 * 到容器里。事件绑定使用代理方式。
	 */

	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	var isbool=true;//触发开关，防止多次调用事件
	var p=0,t=0;
	$(window).on("scroll",function(mousev){
		 
		p = $(this).scrollTop(); 
		if(t>=p){//上滚  
            return;  
        } 
		ajax();
	})
	$('.ck').on("click",function(){
		ajax();
	})
	function ajax(){
		var $count
		if($("a[name=blogId]")!=null){
			$count=$("a[name=blogId]").length;// 每滚动一次获取当前ul中的li数量
		}else{
			$count = 0;
		}
		
		$winH=$(window).height();
		$scrollTop=$(window).scrollTop();
		$nodeH=$('.ck').offset().top;
		console.log($nodeH);
		console.log($scrollTop);
		console.log($winH);
		
		if($winH+$scrollTop>$nodeH && isbool == true){/* 往下滚动后当加载按钮出现在视窗范围时执行ajax请求（ajax请求附带执行函数） */
			isbool=false;
			var type = $('#type').val();
			var userId = $('#currentUserId').val();
			var ownerId = $('#userId').val();
			var title = null;
			var tag = null;
			if($('#searchContent') != null && "" !=$('#searchContent').text()){
				title = $('#searchContent').text();
				ownerId = null;
				userId = null;
			}
			if($('#tag') != null&& "" !=$('#tag').text()){
				tag = $('#tag').text();
				ownerId = null;
				userId = null;
			}
			$.ajax({
				url : projectName + "/otherPhotoes/loadingMore",
				type:"POST",
				dataType:"JSON",
				data : {
					"start" : $count,// 将每次滚动获取的li数量传到后台
					"length" : 9,// 每次加载个数
					"type" : type,
					"userId" : userId,
					"ownerId" : ownerId,
					"title" : title,
					"tag" : tag
				},
				success:function(data){// 后台传回数据是json对象格式,用.方法调用
					if(data == null || data.length == 0){
						$(".ck").html("已全部加载");
						return false;
					}else{
						onsucess(data);
					}
				},
				error:function(){
					toastr.warning("error");
				}
			})
		}
	}
	function onsucess(data){
		
		setTimeout(function(){
		    if(data.length === 0){
				$(".ck").html("已全部加载");
				return;
			}
			$(".ck").html("加载更多");
			//$(".ck").data("loading",false)// 加载完成后将状态锁置为false，让下次点击可加载
			// console.log($(".ck").data())
			for(var i=0;i<data.length;i++){
				var blog = data[i];
				var likeif ='';
				var str = '<li class="masonry-item grid"><figure class="effect-sarah" id="figure_div"><img height="200" width="200"'+
						  'src="'+ blog.picture.url+ '?imageView2/1/w/400/h/250/format/jpg/q/90|imageslim" alt="" />'+
						  '<figcaption><h2><span>'+ blog.title +'</span>'+
						  '</h2><p><span class="post-title">' + blog.description+ '</span>'+
						  '</p><p><span>' + blog.likeNumber  + '喜欢</span></p>'+
						  '<a name="blogId" href="/jinseblog/blog/'+ + blog.blogId +'"></a></figcaption></figure></li>';
	
				$("#picul").append(str);
				isbool=true;
		}
		},0001)// 因为太快完成所以加延迟显示加载效果
	}
	
})