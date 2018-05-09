$(function() {
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 

	isSelf();
	function isSelf() {
		if ($('#currentUserId').val() != $('#userId').val()
				&& $('#currentUserId').val() != $('#commentUserId').val()) {
			$('#deleteComment').hide();
		}
	}
	
	$(".removeBtn").click(function() {
		var commentId = $(this).attr("data-comment-id");
		var blogId = $('#blogId').val();
		var $divComment = $(this).closest('.comment-show-con');
		if (commentId != null && commentId != '') {
			$.ajax({
				url : "deleteComment",
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify({
					'commentId' : commentId,
					'blogId' : blogId,
				}),
				success : function(data) {
					$divComment.hide();
					/*$(".comment-show").load(location.href + " .comment-show");*/
				},
				error : function() {
					alert("Error");
				}
			});
		}
	})
})
