<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>登录页</title>

	<link href="resources/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
	<link href="resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
	<link href="resources/plugins/checkbix/css/checkbix.min.css" rel="stylesheet"/>
	<link href="resources/css/login.css" rel="stylesheet"/>
	<link href="resources/css/animate.css" rel="stylesheet"/>
</head>
<body>
<div  id="login-window" class="container">
	<form action="" method="get">

	<div class="input-group m-b-20 row">

			<span class="input-group-addon">
				<i class="zmdi zmdi-account"></i>
			</span>

		<transition
				name="fade"
				enter-active-class="animated swing"
				leave-active-class="animated swing "
		>
			<div class="fg-line col-xs-8" v-show="isShow">
				<input  id="username" type="text" class="form-control" name="username" placeholder="帐号" required autofocus value="${requestScope.username}">
			</div>
		</transition>

	</div>
	<div class="input-group m-b-20 row">

		<span class="input-group-addon">
			<i class="zmdi zmdi-male"></i>
		</span>
		<transition
				name="fade"
				enter-active-class="animated swing"
				leave-active-class="animated swing "
		>
			<div class="fg-line  col-xs-8" v-show="isShow">
				<input id="password" type="password" class="form-control" name="password" placeholder="密码" required value="${requestScope.password}">
			</div>
		</transition>
	</div>


	<div class="clearfix row">
	</div>
	<div class="checkbox row">
		<div class="col-md-9" v-show="isShow">
			<input id="rememberMe" type="checkbox" class="checkbix" data-text="自动登录" name="rememberMe" >
		</div>
		<div class="col-md-1" v-show="isShow">
			<button type="button" class="btn btn-default register" data-text="注册" name="register" onclick="window.open('register.jsp')">
				<!--<a href="register.html">注册</a>-->
				注册
			</button>
		</div>
		<div class="col-md-1" v-show="isShow">
			<button type="button" class="btn btn-default forgetPassword" data-text="忘记密码" name="forgetPassword" data-toggle="modal" data-target="#forgPass">
				忘记密码
			</button>
		</div>
	</div>
	<a @click="loginBtnClick" id="login-bt" href="javascript:;" class="waves-effect waves-button waves-float"><i class="zmdi zmdi-arrow-forward"></i></a>
	</form>
</div>

<!-- 忘记密码 -->
<div class="modal fade" id="forgPass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">找回密码</h4>
			</div>
			<div class="modal-body">
				<button type="button" class="btn btn-default">发送短信，找回密码</button>
				<button type="button" class="btn btn-default">发送email，找回密码</button>
				<button type="button" class="btn btn-default">通过密保问题，找回密码</button>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<script src="resources/plugins/jquery.1.12.4.min.js"></script>
<script src="resources/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="resources/plugins/waves-0.7.5/waves.min.js"></script>
<script src="resources/plugins/checkbix/js/checkbix.min.js"></script>
<script src="resources/js/vue.js"></script>
<script src="resources/js/login.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
<script type="text/javascript">

    Checkbix.init();

</script>

</body>
</html>