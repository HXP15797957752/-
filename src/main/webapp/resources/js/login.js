$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 输入框获取焦点后出现下划线
	$('.form-control').focus(function() {
		$(this).parent().addClass('fg-toggled');
	}).blur(function() {
		$(this).parent().removeClass('fg-toggled');
	});
});
Checkbix.init();
$(function() {
	// 点击登录按钮
	$('#login-bt');
	// 回车事件
	$('#username, #password').keypress(function (event) {
		if (13 == event.keyCode) {
			alert("enter...press");
			login();
		}
	});
});

var baseUrl = "http://127.0.0.1:8080/IntelligentSystem";
var loginApp=new Vue({
    el:'#login-window',
    data: {
        isShow: true
    },
    methods:{
        loginBtnClick:function () {
            this.isShow=!this.isShow;
            // login 逻辑
            login(baseUrl);
            
        },
        registBtnClick:function(){
    		regist(baseUrl);
    	}
    }
});
// 登录
function login(loginUrl) {
	$.ajax({
		url: loginUrl + "/user",
		type: 'POST',
		data: {
			username: $('#username').val(),
			password: $('#password').val(),
			rememberMe: $('#rememberMe').is(':checked'),
			//backurl: backUrl,
			method: "ajaxLogin"
		},
		beforeSend: function() {

		},
		success: function(json){
			var resObj = eval('(' + json + ')');
			if (resObj.code == 1) {
				location.href = loginUrl + resObj.data;
			} else {
				
				if (10101 == resObj.code) {
					$('#username').focus();
				}
				if (10102 == resObj.code) {
					$('#password').focus();
				}
			}
		},
		error: function(error){
			console.log(error);
		}
	});
}
//注册
function regist(url) {
	var bool = $('#sex1').is(':checked');
	var sex = 1;
	if (bool == true){
		sex = 1;
	}else{
		sex = 0;
	}
	$.ajax({
		url: url + "/user",
		type: 'POST',
		data: {
			userNo: $('#userNo').val(),
			password: $('#password').val(),
			phoneNumber: $('#phoneNumber').val(),
			'sex':sex,
			IDCard:$('#IDCard').val(),
			question:$('#question').val(),
			answer:$('#answer').val(),
			method: "ajaxRegist"
		},
		beforeSend: function() {
			
		},
		success: function(json){
			var resObj = eval('(' + json + ')');
			
			if (resObj.code == 1) {
				alert(resObj.data + "注册成功!");
				location.href = url + resObj.backurl;
			}
			//错误消息暂时不接受
		},
		error: function(error){
			console.log(error);
		}
	});
}