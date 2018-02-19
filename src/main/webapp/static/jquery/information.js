function Bind(str) {
	alert($("#province").html());
	$("#province").val(str);
}

function ProviceBind(provinceId) {
	if (provinceId == "") {
		return;
	}
	// 清空下拉数据
	$("#province").html("");
	var str = "<option>请选择</option>";
	$("#province").append(str);
	$.ajax({
		type : "POST",
		url : "home/getAddress",
		data : {
			"parentId" : "",
			"myColums" : "province"
		},
		dataType : "JSON",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				var $option = $("<option value=" + item.id + ">" + item.myTexts
						+ "</option>");
		        if (provinceId == item.id) {
		        	$option.attr("selected", "selected");
		        }
		        // 将数据添加到省份这个下拉框里面
				$("#province").append($option);
			})
			
		},
		error : function() {
			alert("Error");
		}
	});
}
function cityBind(cityId) {

	var provice = $("#province").val();

	// 判断省份这个下拉框选中的值是否为空
	if (provice == "" || province == '请选择') {
		return;
	}
	$("#city").html("");
	var str = "<option>请选择</option>";
	$("#city").append(str);
	$("#village").html("");
	$("#village").append(str);
	$.ajax({
		type : "POST",
		url : "home/getAddress",
		data : {
			"parentId" : provice,
			"myColums" : "city"
		},
		dataType : "JSON",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				var $option = $("<option value=" + item.id + ">" + item.myTexts
						+ "</option>");
		        if (cityId == item.id) {
		        	$option.attr("selected", "selected");
		        }
		        // 将数据添加到省份这个下拉框里面
				$("#city").append($option);
			})
			
		},
		error : function() {
			$("#city").append(str);
		}
	});
}
function villageBind(villageId) {

	var city = $("#city").val();
	// 判断市这个下拉框选中的值是否为空
	if (city == "" || city == '请选择') {
		return;
	}
	$("#village").html("");
	var str = "<option>请选择</option>";
	$("#village").append(str);
	// 将市的ID拿到数据库进行查询，查询出他的下级进行绑定
	$.ajax({
		type : "POST",
		url : "home/getAddress",
		data : {
			"parentId" : city,
			"myColums" : "village"
		},
		dataType : "JSON",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				var $option = $("<option value=" + item.id + ">" + item.myTexts
						+ "</option>");
		        if (villageId == item.id) {
		        	$option.attr("selected", "selected");
		        }
		        // 将数据添加到省份这个下拉框里面
				$("#village").append($option);
			})
		},
		error : function() {
			$("#village").append(str);
		}
	});
	// $.post("/Home/GetAddress", { parentiD: provice, MyColums: "village"
	// },
	// function (data) {
	// $.each(data, function (i, item) {
	// str += "<option value=" + item.Id + ">" + item.MyTexts + "</option>";
	// })
	// $("#village").append(str);
	// })
}
