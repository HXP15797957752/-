$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 数据表格动态高度
	$(window).resize(function () {
		$('#table').bootstrapTable('resetView', {
			height: getHeight()
		});
	});
	// 设置input特效
	$(document).on('focus', 'input[type="text"]', function() {
		$(this).parent().find('label').addClass('active');
	}).on('blur', 'input[type="text"]', function() {
		if ($(this).val() == '') {
			$(this).parent().find('label').removeClass('active');
		}
	});
	// select2初始化
	$('select').select2();
});
// 动态高度
function getHeight() {
	return $(window).height() -200;
}
// 数据表格展开内容
function detailFormatter(index, row) {
	var html = [];
	$.each(row, function (key, value) {
		html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	});
	return html.join('');
}
// 初始化input特效
function initMaterialInput() {
	$('form input[type="text"]').each(function () {
		if ($(this).val() != '') {
			$(this).parent().find('label').addClass('active');
		}
	});
}
//获取用户信息
function sessionUser(baseUrl){
	$.ajax({
		url: baseUrl + "/user",
		type: 'POST',
		data: {
			method: "sessionUser"
		},
		beforeSend: function() {

		},
		success: function(json){
			var resObj = eval('(' + json + ')');
			var myDate = new Date(resObj.createDate.time);
			var list = document.getElementsByClassName("user");
			for (i = 0;i < list.length;i++){
				if ($(list[i]).attr('name') == 'createDate'){
					$(list[i]).html(myDate.Format("yyyy-MM-dd HH:mm:ss"));
					$(list[i]).val(myDate.Format("yyyy-MM-dd HH:mm:ss"));
				}else if($(list[i]).attr('name') == 'userNo'){
					$(list[i]).html(resObj.userNo);
					$(list[i]).val(resObj.userNo);
				}else if($(list[i]).attr('name') == 'trueName'){
					$(list[i]).html(resObj.trueName);
					$(list[i]).val(resObj.trueName);
				}else if($(list[i]).attr('name') == 'sex'){
					if (resObj.sex == '1')
						$(list[i]).html("男");
					else
						$(list[i]).html("女");
					
				}else if($(list[i]).attr('name') == 'IDCard'){
					$(list[i]).html("身份证号:" + resObj.IDCard);
					$(list[i]).val(resObj.IDCard);
				}else if($(list[i]).attr('name') == 'phoneNumber'){
					$(list[i]).html("手机号码:" + resObj.phoneNumber);
					$(list[i]).val(resObj.phoneNumber);
				}else if($(list[i]).attr('name') == 'email'){
					$(list[i]).html("邮箱地址:" + resObj.email);
					$(list[i]).val(resObj.email);
				}else if($(list[i]).attr('name') == 'personalProfile'){
					$(list[i]).html(resObj.personalProfile);
					$(list[i]).val(resObj.personalProfile);
				}else if($(list[i]).attr('name') == 'question'){
					$(list[i]).val(resObj.question);
				}else if($(list[i]).attr('name') == 'answer'){
					$(list[i]).val(resObj.answer);
				}
				
				
			}
		},
		error: function(error){
			console.log(error);
		}
	});
}
// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
// 例子： 
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 

Date.prototype.Format = function(fmt){
	var o = {
		 "M+": this.getMonth()+1,
		 "d+": this.getDate(),
		 "H+": this.getHours(),
		 "m+": this.getMinutes(),
		 "s+": this.getSeconds(),
		 "S+": this.getMilliseconds()
	};

	//因位date.getFullYear()出来的结果是number类型的,所以为了让结果变成字符串型，下面有两种方法：

	

	if(/(y+)/.test(fmt)){
		//第一种：利用字符串连接符“+”给date.getFullYear()+""，加一个空字符串便可以将number类型转换成字符串。

		fmt=fmt.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length));
	}
	for(var k in o){
		if (new RegExp("(" + k +")").test(fmt)){

			//第二种：使用String()类型进行强制数据类型转换String(date.getFullYear())，这种更容易理解。

			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(String(o[k]).length)));
		}
	}	
	return fmt;
}



