$(function() {
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 


	isSelf();
	function isSelf() {
		if ($('#currentUserId').val() == $('#userId').val()) {
			$('#deleteBtn').attr("type","button");
			$('#deleteBtn').show();
		}
	}

/*	$("#deleteBtn").click(function() {
		var blogId = $('#blogId').val();

		if (blogId != null ) {
			$.ajax({
				type : "POST",
				url : projectName + "/user/deleteBlog",
				data : {
					"blogId" : blogId,
				},
				dataType : "JSON",
				success : function(data) {
					// 去取消关注
					if(data == "success" ){
						alert("删除成功");
			            window.location.href = projectName + "/myPhotoes";
					}
				},
				error : function() {
					alert("Error");
				}
			})
		} 
	})*/

})
