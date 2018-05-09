$(function() {
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 


	isSelf();
	function isSelf() {
		if ($('#currentUserId').val() != $('#userId').val()) {
			$('#deleteSpan').hide();
			$('#downloadSpan').hide();
		}
	}

	ifCanBuy();
	function ifCanBuy() {
/*		if ($('#currentUserId').val() == $('#userId').val()) {
			$('#deleteSpan').hide();
		}*/
		var blogId = $("#blogId").val();
		
		$.ajax({
			type : "POST",
			url : projectName + "/picture/ifCanBuy/" + blogId,
			/*data : {
				"blogId" : blogId,
			},*/
			dataType : "JSON",
			success : function(data) {
				if(data == 1){
					$('#buySpan').hide();
				}
			},
			error : function() {
			}
		})
	}
})
