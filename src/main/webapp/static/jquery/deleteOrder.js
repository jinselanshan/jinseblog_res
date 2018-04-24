$(function() {
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 


	$(".deleteOrder").click(function() {
		var orderType = $("#orderType").val();
		var orderId =  $(this).attr("data-order-id");
		var $table = $(this).parent().parent().parent().parent(".picture_table");
		$.ajax({
			type : "POST",
			url : projectName + "/order/deleteOrderInfor/" + orderType + "/" + orderId,
		
			dataType : "JSON",
			success : function(data) {
				toastr.success("删除订单成功success");
				$table.fadeOut("slow");
			},
			error : function() {
			}
		})
	})
})
