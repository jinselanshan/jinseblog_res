function check() {
	var fileName = $('.file-caption-name').attr('title');
	var title = $('#title').val();
	// alert(titleName);
	if (typeof (fileName) == "undefined" || fileName.length == 0) {
		toastr.warning('请上传图片');
		return false;
	}
	if (title == "" || title.length == 0) {
		toastr.warning('请填写博客标题');
		return false;
	}
	return true;
}
function checkVideo() {
	var fileName = $('.file-caption-name').attr('title');
	var title = $('#title').val();
	// alert(titleName);
	if (typeof (fileName) == "undefined" || fileName.length == 0) {
		toastr.warning('请上传视频');
		return false;
	}
	if (title == "" || title.length == 0) {
		toastr.warning('请填写博客标题');
		return false;
	}
	return true;
}

function checkArticle() {
	var title = $('#title').val();
	var content = $('#content').val();
	if (title == "" || title.length == 0) {
		toastr.warning('请填写文章标题');
		return false;
	}
	if (content == "" || content.length == 0) {
		toastr.warning('请填写文章内容');
		return false;
	}
	return true;
}
