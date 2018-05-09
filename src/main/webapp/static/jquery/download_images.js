$(function() {
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 

	$(".downloadImg").click(function() {
		var $odownLoad = $(this).parent(".downloadHref");
		var url = $(this).attr("data-url");
		oDownLoad(url,$odownLoad);
	})

	
	//判断浏览器类型
	function myBrowser() {
		var userAgent = navigator.userAgent; // 取得浏览器的userAgent字符串
		var isOpera = userAgent.indexOf("Opera") > -1;
		if (isOpera) {
			return "Opera"
		}
		; // 判断是否Opera浏览器
		if (userAgent.indexOf("Firefox") > -1) {
			return "FF";
		} // 判断是否Firefox浏览器
		if (userAgent.indexOf("Chrome") > -1) {
			return "Chrome";
		}
		if (userAgent.indexOf("Safari") > -1) {
			return "Safari";
		} // 判断是否Safari浏览器
		if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1
				&& !isOpera) {
			return "IE";
		}
		; // 判断是否IE浏览器
		if (userAgent.indexOf("Trident") > -1) {
			return "Edge";
		} // 判断是否Edge浏览器
	}

	function SaveAs5(imgURL) {
		var oPop = window
				.open(imgURL, "", "width=1, height=1, top=5000, left=5000");
		for (; oPop.document.readyState != "complete";) {
			if (oPop.document.readyState == "complete")
				break;
		}
		oPop.document.execCommand("SaveAs");
		oPop.close();
	}

	function oDownLoad(url,odownLoad) {
		myBrowser();
		if (myBrowser() === "IE" || myBrowser() === "Edge") {
			// IE
			odownLoad.href = "#";
			var oImg = document.createElement("img");
			oImg.src = url;
			oImg.id = "downImg";
			var odown = document.getElementById("down");
			odown.appendChild(oImg);
			SaveAs5(document.getElementById('downImg').src)
		} else {
			// !IE
			odownLoad.href = url;
			odownLoad.download = "";
		}
	}
	

})
