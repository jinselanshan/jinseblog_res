$(function() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);

	$(".edit_btn").click(function() {
		//按钮
		var $thisBtn = $(this);
		var button_name = $thisBtn.val();
		if(button_name == "修改"){
			$thisBtn.val("提交");
			$thisBtn.addClass("edit_sub_btn");
			//文本框
			var ori_value = $('#price_text').val();
			var str_input = '<input id="price_text" type="text" class="str_input" value="' + ori_value + '">';
			var $td = $thisBtn.parent().prev();
			$td.html(str_input);
		}
		else if(button_name == "提交"){
			var value = $('#price_text').val();
			var value_num = parseInt(value);
			var reg = /^\d+(?=\.{0,1}\d+$|$)/
		    if(!reg.test(value_num)){
		    	return false;
		    }
			$thisBtn.val("修改");
			$thisBtn.removeClass("edit_sub_btn");
			
			var str_text = '<p id="price_text">' + value_num + '</p>';
			var $td = $thisBtn.parent().prev();
			$td.html(str_text);
			toastr.success("修改成功");
		}
		
	})

		
		
		
		
       /* if (value === "关注") {
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
		}*/

})
