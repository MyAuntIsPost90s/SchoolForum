//我的信息加载器
var UserModel={
    loadUser:function (id) {
        var user=null;
        $.ajaxSetup({async:false});
        $.post(Config.UrlHead+'/Users/Single'
            ,{id:id}
            ,function(data){
                if(data.code!=1){
                    layer.msg(data.msg);
                    return;
                }
                user=data.data;
            },'json');
        $.ajaxSetup({async:true});
        return user;
    },
    loadMe:function(){  //加载我的信息
        var user=null;
        $.ajaxSetup({async:false});
        $.post(Config.UrlHead+'/Users/NowUser'
            ,function(data){
                if(data.code!=1){
                    layer.msg(data.msg);
                    return;
                }
                var model=data.data;
                $('#header-realname').html(model.realname);
                $('#header-headimgurl').attr('src',model.headimgurl==''?Config.UrlHead +'/Contents/images/dfthead.png':Config.UrlHead + model.headimgurl);
                $('#me-home').attr('href',$('#me-home').attr('href').replace('$id',model.userid));
                layui.use('element', function(){
                    var element = layui.element;
                });
                user=model;
            },'json');
        $.ajaxSetup({async:true});
        return user;
    }
}

//列表加载器
var ListModel={
    initList:function(params){
        if(params.url==null||params.listId==null||params.tempStr==null)
            return;
        if(params.postData.rows==null||params.postData.page==null)
            return;

        $.post(params.url
            ,params.postData
            ,function (data) {
                if(data.code!=1){
                    layer.msg(data.msg);
                    return;
                }
                //填充页面
                layui.laytpl(params.tempStr).render(data.data,function(html){
                    $('#'+params.listId).html(html);
                });
                if(params.pageId==null)
                    return;
                //使用分页器
                var laypage = layui.laypage;
                laypage.render({
                    elem: params.pageId
                    ,limit: params.postData.rows
                    ,count: data.data.total //数据总数
                    ,jump: function(obj, first) {
                        params.pageId=null;
                        if(!first) {
                            params.postData.page=obj.curr;
                            ListModel.initList(params);
                        }
                    }
                });
            },'json');
    }
}

var EditModel={
    build:function(id,option){
        var layedit = layui.layedit;
        layedit.set({
            uploadImage: {
                url: Config.UrlHead+'/LayEditImgUpload' //接口url
                , type: 'post' //默认post
            }
        });
        return layedit.build(id,option); //建立编辑器
    },
    setContent:function(tag,val){   //设置值
        try {
            var layedit = layui.layedit;
            layedit.setContent(tag, val);
        }catch (err){
            //不做处理
        }
    },
    getContent:function(tag){   //获取值
        var layedit = layui.layedit;
        return layedit.getContent(tag);
    }
}