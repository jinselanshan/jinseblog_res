/*
===============================================================

Hi! Welcome to my little playground!

My name is Tobias Bogliolo. 'Open source' by default and always 'responsive',
I'm a publicist, visual designer and frontend developer based in Barcelona. 

Here you will find some of my personal experiments. Sometimes usefull,
sometimes simply for fun. You are free to use them for whatever you want 
but I would appreciate an attribution from my work. I hope you enjoy it.

===============================================================
*/

$(document).ready(function(){
	var t;
  // Show contextmenu:
  $(".right-img-click").contextmenu(function(e){
    // Get window size:
	//return false;
	  console.log(e);
	clearTimeout(t);
    var winWidth =$(document).width();
    var winHeight =$(document).height();
    // Get pointer position:
    var posX = e.offsetX;
    var posY = e.offsetY;
    // Get contextmenu size:
    var menuWidth = $(".contextmenu").width();
    var menuHeight = $(".contextmenu").height();
    // Security margin:
    var secMargin = 10;
    // Prevent page overflow:

    // Case 4: default values:
    posLeft = posX + secMargin + 100 + "px";
    posTop = posY + secMargin + 20 + "px";
    // Display contextmenu:
    $(".contextmenu").css({
      "left": posLeft,
      "top": posTop
    }).show();
    t = setTimeout(function(){$(".contextmenu").hide(2000);},3000);// 3秒后执行该方法
    // Prevent browser default contextmenu.
    return false;
  });
  // Hide contextmenu:
  $(document).click(function(){
    $(".contextmenu").hide();
  });
  $(document).contextmenu(function(){
	  if(t != null){	 
		  $(".contextmenu").hide();
	  }
  });
});