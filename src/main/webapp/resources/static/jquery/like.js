<script>
    /* @author:Romey
     * ��̬����
     * ��Ч������css3����������������ݣ��磺IE10���µİ汾��
    */
    $(function(){
        $("#icon-like").click(function(){
            var icon_like = $("#icon-like");
            var text_box = $("#add-num");
            if(like_img.attr("src") == ("icon-like.jpg")){
                $(this).html("<img src='icon-like-no.jpg' id='like-img' class='animation' />");
                like_txt.removeClass("hover");
                text_box.show().html("<em class='add-animation'>-1</em>");
                $(".add-animation").removeClass("hover");
                like_txt.text(num)
            }else{
                $(this).html("<img src='icon-like.jpg' id='like-img' class='animation' />");
                like_txt.addClass("hover");
                text_box.show().html("<em class='add-animation'>+1</em>");
                $(".add-animation").addClass("hover");
                like_txt.text(num)
            }
        });
    })
</script>