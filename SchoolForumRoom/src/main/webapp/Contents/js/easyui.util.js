/**
 * EasyUI配合lingshiframework返回类型帮助
 * author:linghsi
 * date:2018-01-29
 */
var EasyUIUtil = {
    loadForm: function (id, url, params) {
        $.post(url
            , params
            , function (data) {
                if (data.code == 1) {
                    $(id).form('load', data.data);
                }
                else {
                    $.messager.alert(data.msg);
                }
            }, 'json');
    },
    loadTree:function(id,url,params){
        $(id).tree({
            url:url,
            method:'post',
            loadFilter: function(data){
                return data.data;
            }
        })
    },
    getPager: function (id, url, params) {
        if (params == null)
            params = {};
        var pager = $(id).datagrid({
            url: url
            , queryParams: params
            , loadFilter: function (data) {
                if (data.code == 0) {
                    $.messager.alert("错误", data.msg);
                    return null;
                }
                return data.data;
            }
            , onCheckAll: function () {
                $(id).datagrid("unselectAll");
            }
            , onSelect: function (rowIndex, rowData) {
                $(id).datagrid("unselectRow", rowIndex);
            }
        }).datagrid('getPager');
        return pager;
    }
}