$(function() {
	isSelf();
	function isSelf() {
		if ($('#currentUserId').val() != $('#userId').val() && $('#currentUserId').val() != $('#commentUserId').val()) {
			$('#deleteComment').hide();
		}
	}
})
