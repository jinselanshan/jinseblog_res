$(function() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);

	$(".btn-following").click(function() {
		var $thisBtn = $(this);
		var value = $thisBtn.val();
		var user_id = $('#currentUserId').val();
		var following_id = $thisBtn.attr("data-user-id");

		if (value === "已关注") {
			$.ajax({
				type : "POST",
				url : projectName + "/user/deleteFollowing",
				data : {
					"userId" : user_id,
					"followingId" : following_id,
				},
				dataType : "JSON",
				success : function(data) {
					// 去取消关注
					if (data == 1) {
						$thisBtn.val("关注");
					}
				},
				error : function() {
					alert("Error");
				}
			})
		} else if (value === "关注") {
			$.ajax({
				type : "POST",
				url : projectName + "/user/saveFollowing",
				data : {
					"userId" : user_id,
					"followingId" : following_id,
				},
				dataType : "JSON",
				success : function(data) {
					// 去取消关注
					if (data == 1) {
						$thisBtn.val("已关注");
					}
				},
				error : function() {
					alert("Error");
				}
			})
		}
	})

})
