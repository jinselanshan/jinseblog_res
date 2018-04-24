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
	
	ifCanBuy();
	function ifCanBuy() {
		var blogId = $("#blogId").val();
		
		$.ajax({
			type : "POST",
			url : projectName + "/picture/ifcanBuy",
			data : {
				"blogId" : blogId,
			},
			dataType : "JSON",
			success : function(data) {
				$('#buyBtn').attr("type","button");
				$('#buyBtn').show();
			},
			error : function() {
			}
		})
	}
})
