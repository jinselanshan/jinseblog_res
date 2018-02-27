$(function() {
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 

	$(".fileinput-upload").on('click', function() {
		alert("sc");
		var fileObj = $("#file-video")[0].files[0]; // js 获取文件对象
        if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
            alert("请选择视频");
            return;
        }
        var formFile = new FormData();
        //formFile.append("action", "UploadVMKImagePath");  
        formFile.append("file-video", fileObj); //加入文件对象
        $.ajax({
            url: projectName +"/uploadVedioUrl",
            data: formFile,
            type: "Post",
            dataType: "json",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (data) {
                alert("上传完成!");
            },
        	error : function() {
				alert("Error");
			}
        })
	});
})
