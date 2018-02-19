$(function() {

	//isSelf();
	isFollowing();
	function isSelf() {
		if ($('#currentUserId').val() == $('#userId').val()) {
			$('#followingBtn').hide();
		}
	}

	$("#followingBtn").click(function() {
		var value = $("#followingBtn").text();
		var user_id = $('#currentUserId').val();
		var following_id = $("#userId").val();

		if (value === "已关注") {
			$.ajax({
				type : "POST",
				url : "user/deleteFollowing",
				data : {
					"userId" : user_id,
					"followingId" : following_id,
				},
				dataType : "JSON",
				success : function(data) {
					//去取消关注
					if(data == 1){
						$("#followingBtn").text("关注");
					}
				},
				error : function() {
					alert("Error");
				}
			})
		} else if (value === "关注") {
			$.ajax({
				type : "POST",
				url : "user/saveFollowing",
				data : {
					"userId" : user_id,
					"followingId" : following_id,
				},
				dataType : "JSON",
				success : function(data) {
					//去取消关注
					if(data == 1){
						$("#followingBtn").text("已关注");
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
			url : "user/isFollowing",
			data : {
				"followingId" : following_id,
			},
			dataType : "JSON",
			success : function(data) {
				if (data == 1) {
					$("#followingBtn").text("已关注");
				} else if (data == 0) {
					$("#followingBtn").text("关注");
				}
			},
			error : function() {
				alert("Error");
			}
		})
	}
})
