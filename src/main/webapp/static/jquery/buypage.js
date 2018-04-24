$(function() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);

	$(".edit_btn").click(function() {
		//按钮
		var $thisBtn = $(this);
		var button_name = $thisBtn.val();
		var $td = $thisBtn.parent().prev();
		
		if(button_name == "修改"){
			var $price_text = $td.children(".price_text");
			$thisBtn.val("提交");
			$thisBtn.addClass("edit_sub_btn");
			//文本框
			var ori_value = $price_text.text();
			var str_input = '<input class="price_input" type="text" value="' + ori_value + '">';
	
			$td.html(str_input);
		}
		else if(button_name == "提交"){
			var $price_input = $td.children(".price_input");
			
			var value = $price_input.val();
			var value_num = parseFloat(value);
			
			var reg = /^\d+(?=\.{0,1}\d+$|$)/
		    if(!reg.test(value_num)){
		    	return false;
		    }
			$thisBtn.val("修改");
			$thisBtn.removeClass("edit_sub_btn");
			
			var str_text = '<p class="price_text">' + value_num + '</p>';
			var pictureId = $thisBtn.attr("data-picture-id");
			
			$.ajax({
				type : "POST",
				url : projectName + "/picture/updatePrice",
				data : {
					"pictureId" : pictureId,
					"price" : value_num,
				},
				dataType : "JSON",
				success : function(data) {
					$td.html(str_text);
					toastr.success("修改成功");
				},
				error : function() {
					toastr.error("修改失败");
				}
			})
		}
	})
})
