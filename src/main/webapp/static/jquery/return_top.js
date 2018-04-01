$(function() {
	window.onload = function() {
		var topbtn =$('#btn_return_top');
		var timer = null; // 获取屏幕的高度
		var pagelookheight = document.documentElement.clientHeight;

		window.onscroll = function() {
			// 滚动超出高度，显示按钮，否则隐藏
			var backtop = document.body.scrollTop; // 滚动超过一频 应该显示
			if (backtop >= pagelookheight) {
				topbtn.attr("display","block");
			} // 不显示<br> else{
			topbtn.attr("display","none");
		}
	}
	$('#btn_return_top').click(function() {
		setTimeout(function(){
			var backtop = document.body.scrollTop; // 速度操作 减速
			var speedtop = backtop / 5;
			document.body.scrollTop = backtop - speedtop; // 高度不断减少
			if (backtop == 0) { // 滑动到顶端
				clearInterval(timer); // 清除计时器
			}
		}, 300);
	})
})
