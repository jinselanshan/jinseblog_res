 $(function(){
        //让当前表单调用validate方法，实现表单验证功能
        $("#information_table").validate({
            //debug:true, //调试模式，即使验证成功也不会跳转到目标页面
            rules:{     //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
            	username:{
                    required:true,  //必填。如果验证方法不需要参数，则配置为true
                    rangelength:[3,18]
                },
               
            },
            messages: {
                username: {
                  required: "请输入用户名",
                  rangelength: "用户名的长度为3到18个字符"
                },
            }
       })
});
