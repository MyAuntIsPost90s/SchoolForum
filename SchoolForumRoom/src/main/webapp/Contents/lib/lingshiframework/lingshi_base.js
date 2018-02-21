/**
 * 设置全局token author:lingshi
 * 
 */
$(function() {
	$.ajaxSetup({
		aysnc : true, // 默认异步加载
		type : "POST", // 默认使用POST方式
		dataType : 'JSON',
		crossDomain: true,
		xhrFields:{withCredentials:true},
		headers : { // 默认添加请求头
			"AppKey" : "LINGSHI8",
			"AccessToken" : LingShiUtil.getCookie('LingShi_Token'),
		},
		complete : function(XMLHttpRequest, textStatus) {
			// 请求完成处理
			if (XMLHttpRequest.responseJSON != null
					&& XMLHttpRequest.responseJSON.msgcode == '0000') {
				window.location.href = '/SchoolForumRoom/login.html'; // token失效，跳转登陆页面
				return;
			}
		}
	});
})

var LingShiUtil = {
	getCookie : function(name) {
		var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
		if (arr = document.cookie.match(reg))
			return unescape(arr[2]);
		else
			return null;
	},
	getParam : function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return r[2];
		return '';
	}
}