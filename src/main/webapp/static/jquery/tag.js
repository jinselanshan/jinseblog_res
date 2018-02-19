$(function() {
	// 绑定事件
	$(".tagku").click(function(e) {
		var tagName = $(this).text();
		addTag(tagName);
	})

	function addTag(tagName) {
		// 清空下拉数据
		var tagsNow = $('#tag').val();
		$("#tag").val(tagsNow + tagName + ' ');
		var strs = new Array(); // 定义一数组
		strs = tagsNow.trim().split(" "); // 字符分割
		for (var i = 0; i < strs.length; i++) {
			if (strs[i] == tagName) {
				tagsNow = tagsNow.replace(tagName + ' ', '');
				$("#tag").val(tagsNow);
			}
		}
		var finalStr = $("#tag").val();
	}
})
