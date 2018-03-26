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
		var $count=$("a[name=blogId]").length;// 每滚动一次获取当前ul中的li数量
		$winH=$(window).height();
		$scrollTop=$(window).scrollTop();
		$nodeH=$('.ck').offset().top;
		console.log($nodeH);
		console.log($scrollTop);
		console.log($winH);
		/*setTimeout(function(){
			$(".ck").html("<img src='/jinseblog/static/img/loading.gif'>")//延迟一秒钟后将加载按钮改成gif加载样式
		},1000);*/
		if($winH+$scrollTop>$nodeH && isbool == true){/* 往下滚动后当加载按钮出现在视窗范围时执行ajax请求（ajax请求附带执行函数） */
			isbool=false;
			var type = $('#type').val();
			var userId = $('#currentUserId').val();
			$.ajax({
				url : projectName + "/indexPhoto/loadingMore",
				type:"POST",
				dataType:"JSON",
				data : {
					"start" :$count,// 将每次滚动获取的li数量传到后台
					"length" : 10,// 每次加载个数
					"type" : type,
					"userId" : userId
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
				if(blog.likeif != null){
					likeif = '<a width="20" id="likeBtn" align="right" class="img-circle heart heartAnimation"  data-like="like"'+
						'rel="like" data-blog-id="'+blog.blogId+'"></a>'
				}
				else{
					likeif = '<a width="20" id="likeBtn" align="right" class="img-circle heart"   data-like="dislike"'+
					'rel="unlike" data-blog-id="'+blog.blogId+'"></a>'
				}
				var str = '<div class="card mb-4 panel-body panel">'+
				'<a  name="blogId" href="/blog/'  + blog.blogId + '">'+
				'<input type="hidden" id="type" name="type" value="'+ blog.picture.type +'">'+
				'<img src="' + blog.picture.url + '" alt="Cinque Terre" class="img center-block indexImg" /></a><br/>'+
				'<div class="card-body">'+
					'<div class="text-left">'+
						'<a href="/otherPhotoes/' + blog.user.userId + '"><img src="' + blog.user.avatarUrl + '" alt="140x140" width="50"height="50" class="img-circle" /></a> <a href="/otherPhotoes/' + blog.user.userId +'">'+ blog.user.username + '</a></div>'+
					'<div class="text-right">'+
						'<a href="/blog/' + blog.blogId + '"  class="">评论(' + blog.commentNumber + ')</a>'+
						likeif +  '<span class="likeNumber" id="likeNumber" data-blog-id=" '+blog.blogId +'">'+blog.likeNumber + '</span></div>'+
                    '<h4 class="card-title" >'+blog.title+'</h4>'+
					'<p class="card-text">'+blog.description+'</p></div><div class="card-footer text-muted">'
				var tag = '';
				if(blog.tagList!=null &&blog.tagList.length >0){
					for(var j=0;j<blog.tagList.length;j++){
						tag = tag + '<a href="#"><span class="label label-default">'+blog.tagList[j].tagName+'</span></a>'
					}
				}
				
				str =str + tag + '<time>'+blog.createAt+'</time></div></div>'
				$("#blogLi").append(str);
				isbool=true;
		}
		},0001)// 因为太快完成所以加延迟显示加载效果
	}
	
})