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
			login();
		}
	});
});

var baseUrl = "http://localhost:8080/IntelligentSystem";
var loginApp=new Vue({
    el:'#login-window',
    data: {
        isShow: true
    },
    methods:{
        loginBtnClick:function () {
            this.isShow=!this.isShow;
            // login 逻辑
            login();
            
        },
        registBtnClick:function(){
    		regist();
    	}
    }
});
// 登录
function login() {
	$.ajax({
		url: baseUrl + "/user",
		type: 'POST',
		data: {
			username: $('#username').val(),
			password: $('#password').val(),
			rememberMe: $('#rememberMe').is(':checked'),
			method: "ajaxLogin"
		},
		beforeSend: function() {

		},
		success: function(json){
			var resObj = eval('(' + json + ')');
			if (resObj.code == 0) {
				location.href = baseUrl + resObj.data;
			} else {
				
				if (10100 == resObj.code) {
					$('#username').focus();
				}
				if (10101 == resObj.code) {
					$('#password').focus();
				}
				if (10102 == resObj.code) {
					alert('您当前处于未审核状态');
				}else if (10103 == resObj.code) {
					alert('您当前未通过审核');
				}
			}
		},
		error: function(error){
			console.log(error);
		}
	});
};

//注册
function regist() {
	var bool = $('#sex1').is(':checked');
	var sex = 1;
	if (bool == true){
		sex = 1;
	}else{
		sex = 0;
	}
	$.ajax({
		url: baseUrl + "/user",
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
				alert(resObj.data + ":注册成功!");
				location.href = baseUrl + resObj.backurl;
			}
			// 错误消息暂时不接受
		},
		error: function(error){
			console.log(error);
		}
	});
	
}
