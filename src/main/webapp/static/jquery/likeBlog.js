$(function() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);

	// isLiked();
	function isLiked() {
		var blogId = $(this).attr("data-blog-id");
		if (blogId != null) {
			$.ajax({
				type : "POST",
				url : projectName + "/user/isLike",
				data : {
					"blogId" : blogId,
				},
				dataType : "JSON",
				success : function(data) {
					//
					if (data == "success") {
						alert("已喜欢");
						$(this).style.color = "Red";
					} else {
						alert("未喜欢");
					}
				},
				error : function() {
					alert("Error");
				}
			})
		}
	}

	$(".heart").click(
			function() {
				var rel = $(this).attr("rel");
				var blogId = $(this).attr("data-blog-id");
				var $span = $(this).parent().find("span");
				var likeNumber = parseInt($span.text());// 1
			    var $a = $(this);
				// alert($(this));
				if (rel == "unlike") {
					$a.addClass("heartAnimation").attr("rel","like");
					likeNumber = likeNumber + 1;
					$span.text(likeNumber);
					// 增加喜歡
					$.ajax({
						type : "POST",
						url : projectName + "/user/saveLike",
						data : {
							"blogId" : blogId,
						},
						dataType : "JSON",
						success : function(data) {
							if (data == 1) {
								//alert("like success");
								
								// $(this)[0].src = "img/icon-like.jpg";
								// $(this).attr('src','img/icon-like.jpg');
								// alert($(this).attr('src'));
							} else {
								alert("like error");
							}
						},
						error : function() {
							alert("Error");
						}
					})
				} else {
					$a.removeClass("heartAnimation").attr("rel", "unlike");
					if(likeNumber > 0){
						likeNumber = likeNumber - 1;
					}
					$span.text(likeNumber);
					// 取消喜歡
					$.ajax({
						type : "POST",
						url : projectName + "/user/deleteLike",
						data : {
							"blogId" : blogId,
						},
						dataType : "JSON",
						success : function(data) {
							if (data == 1) {
								//alert("dislike success");
								
								// $(this)[0].src =
								// "/jinseblog/img/icon-like-no.jpg";
								// $(this).attr('src','img/icon-like-no.jpg');
								// $(".img-circle").load(location.href + "
								// .img-circle");
							} else {
								alert("dislike error");
							}
						},
						error : function() {
							alert("Error");
						}
					})
				}
			})
})
