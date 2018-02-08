var UserModel={
    loadMe:function(){  //加载我的信息
        $.post(Config.UrlHead+'/Users/NowUser'
            ,function(data){
                if(data.code!=1){
                    layer.msg(data.msg);
                    return;
                }
                var model=data.data;
                $('#header-realname').html(model.realname);
                $('#header-headimgurl').attr('src',model.headimgurl==''?Config.UrlHead +'/Contents/images/dfthead.png':Config.UrlHead + model.headimgurl);
                layui.use('element', function(){
                    var element = layui.element;
                });
            },'json');
    }
}