$(function() {
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 


	isSelf();
	isFollowing();
	function isSelf() {
		if ($('#currentUserId').val() != $('#userId').val()) {
			$('#followingBtn').attr("type","button");
			$('#followingBtn').show();
		}
	}

	$("#followingBtn").click(function() {
		var value = $("#followingBtn").val();
		var user_id = $('#currentUserId').val();
		var following_id = $("#userId").val();

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
					if(data == 1){
						$("#followingBtn").val("关注");
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
					if(data == 1){
						$("#followingBtn").val("已关注");
					}
				},
				error : function() {
					alert("Error");
				}
			})
		}
	})
	function isFollowing() {

		var following_id = $("#userId").val();

		$.ajax({
			type : "POST",
			url : projectName + "/user/isFollowing",
			data : {
				"followingId" : following_id,
			},
			dataType : "JSON",
			success : function(data) {
				if (data == 1) {
					$("#followingBtn").val("已关注");
				} else if (data == 0) {
					$("#followingBtn").val("关注");
				}
			},
			error : function() {
				alert("Error");
			}
		})
	}
})
