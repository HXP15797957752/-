<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人资料</title>
    <link rel="shortcut icon" href="resources/images/favicon.png">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/xenon-core.css">
    <link rel="stylesheet" href="resources/css/xenon-forms.css">
    <link rel="stylesheet" href="resources/css/xenon-components.css">
    <link rel="stylesheet" href="resources/css/xenon-skins.css">
    <link rel="stylesheet" href="resources/css/custom.css">
    <!--fonts-->
    <link rel="stylesheet" href="resources/fonts/arimo/css/arimo.css">
    <link rel="stylesheet" href="resources/fonts/linecons/css/linecons.css">
    <link rel="stylesheet" href="resources/fonts/font-awesome-4.7.0/css/font-awesome.css">
    <script src="resources/js/jquery-1.11.1.min.js"></script>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="page-title">
<div class="title-env">
    <h1 class="title">查看个人信息</h1>
    <p class="description">用户可以在此页面上，查看个人信息（用户近期动态显示）</p>
</div>
</div>
<section class="profile-env">

<div class="row">
    <div class="col-sm-3">
        <!-- User Info Sidebar -->
            <div class="user-info-sidebar">
                <a href="#" class="user-img">
                    <img src="resources/images/avatar.jpg" alt="user-img" class="img-cirlce img-responsive img-thumbnail" />
                </a>
                <a href="#" class="user-name">
                        <c:choose>
                            <c:when test="${empty sessionScope.user.trueName}">未知</c:when>
                            <c:otherwise>sessionScope.user.trueName</c:otherwise>
                        </c:choose>
                    <span class="user-status is-online"></span>
                </a><br />
                <span class="user-title">
									性别：<c:choose>
									   <c:when test="${sessionScope.user.sex eq 1}">男</c:when>
									   <c:otherwise>女</c:otherwise>
									</c:choose>
								</span>
                <span class="user-title" id="birthday">
                                    <!-- pattern="yyyy-MM-dd HH:mm:ss" -->
									<fmt:formatDate value="${user.createDate}" pattern="yyyy-MM-dd"/>
								</span>

                <hr />
                <ul class="list-unstyled user-info-list" id="personAddress">
                    <li>
                        <i class="fa-home"></i> 江西省
                    </li>
                    <li>
                        <i class="fa-home"></i> 南昌市
                    </li>
                    <li>
                        <i class="fa-home"></i> 青山湖区
                    </li>
                    <li>
                        <i class="fa-home"></i> 江西农业大学
                    </li>
                </ul>
                <hr />
            </div>
        </div>
        <div class="col-sm-9">
            <!-- User timeline stories -->
            <section class="user-timeline-stories">

                <!-- Timeline Story Type: Status -->
                <article class="timeline-story">

                    <!-- User info -->
                    <header>
                        <div class="user-details">
                            <h5>身份证号：${sessionScope.user.IDCard}</h5>
                            <hr />
                            <h5>手机号码：${sessionScope.user.phoneNumber}</h5>
                            <hr />
                            <h5>邮箱地址：${sessionScope.user.email}</h5>
                            <hr />
                            <h5>工作单位：江西省南昌市江西农业大学</h5>
                            <hr />
                            <h5>角色权限：普通用户</h5>
                            <hr />

                        </div>
                        <div class="form-group-separator"></div>
                        <div class="form-group">
                            <a type="button" class="btn btn-info btn-single pull-right" id="updatamibao" data-action="trash" style="margin-left: 5px;color: whitesmoke">修改密保</a>
                            <a type="button" class="btn btn-info btn-single pull-right" id="updata" data-action="trash" style="margin-left: 5px;color: whitesmoke">修改密码</a>
                            <a type="button" class="btn btn-info btn-single pull-right" id="updataInfo" data-action="trash" style="color: whitesmoke">修改信息</a>

                        </div>
                    </header>
                </article>
            </section>

        </div>
    </div>
</section>
<!--底栏注释-->
<footer class="main-footer sticky footer-type-1">
    <div class="footer-inner">
        <!-- Add your copyright text here -->
        <div class="footer-text">
            &copy; 2017-2018 <strong>蓝点工作室</strong> 江西农业大学
            <a href="#" target="_blank">大数据智能猪舍</a>
            - 开发团队:
            <a href="#" target="_blank">蓝点工作室</a>
        </div>
    </div>
</footer>


<!-- Bottom Scripts -->
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/TweenMax.min.js"></script>
<script src="resources/js/resizeable.js"></script>
<script src="resources/js/xenon-api.js"></script>
<script src="resources/js/xenon-toggles.js"></script>
<!-- Imported scripts on this page -->
<script src="resources/js/xenon-widgets.js"></script>
<script src="resources/js/toastr/toastr.min.js"></script>
<!-- JavaScripts initializations and stuff -->
<script src="resources/js/xenon-custom.js"></script>
<script type="text/javascript">
    // Sample Javascript code for this page
    jQuery(document).ready(function($) {

        // Delete Modal-1
        $("#updata").on('click', function() {
            $("#gallery-image-delete-modal1").modal('show');
        });

    });

    // Sample Javascript code for this page
    jQuery(document).ready(function($) {

        // Delete Modal-1
        $("#updataInfo").on('click', function() {
            $("#gallery-image-delete-modal2").modal('show');
        });

    });

    // Sample Javascript code for this page
    jQuery(document).ready(function($) {

        // Delete Modal-1
        $("#updatamibao").on('click', function() {
            $("#gallery-image-delete-modal").modal('show');
        });

    });
</script>

<!-- Gallery Delete Image (Confirm)-->
<div class="modal fade" id="gallery-image-delete-modal1" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改密码</h4>
            </div>
            <form class="form-horizontal">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="field-1">原密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="field-1" placeholder="Placeholder">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="field-1">新密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="field-1" placeholder="Placeholder">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="field-1">确定密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="field-1" placeholder="Placeholder">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">确定</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">退出</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Gallery Delete Image (Confirm)-->
<div class="modal fade" id="gallery-image-delete-modal2" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改密码</h4>
            </div>
            <form class="form-horizontal">
                <div class="modal-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="field-1">手机号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="field-1" value="15797957730">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="field-1">工作地址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="field-1" value="江西省南昌市江西农业大学">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <p>

                                    <label class="radio-inline">
                                        <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" checked="checked"> 男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 女
                                    </label>
                                </p>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">出生日期</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control datepicker" data-start-date="-2d" data-end-date="+1w" value="1997-03-30">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="field-1">个人地址</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="field-1">省：</label>
                            <div class="col-sm-9">
                                <select id="s_province" class="form-control" name="s_province"></select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="field-1">市：</label>
                            <div class="col-sm-9">
                                <select id="s_city" class="form-control" name="s_city"></select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="field-1">区：</label>
                            <div class="col-sm-9">
                                <select id="s_county" class="form-control" name="s_county"></select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="field-1">详细信息</label>
                            <div class="col-sm-9">
                                <input type="email" class="form-control" id="inputemail" value="江西省南昌市青山湖区江西农业大学" name="email">
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-white" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">退出</button>
                        </div>
                    </form>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Gallery Delete Image (Confirm)-->
<div class="modal fade" id="gallery-image-delete-modal" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改密保</h4>
            </div>
            <form class="form-horizontal">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="field-1">密保问题</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="s2example-1">
                                <option>Uzbekistan</option>
                                <option>Vietnam</option>
                                <option>Yemen</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="field-1">原密保答案</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="field-1" placeholder="Placeholder">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="field-1">新密保答案</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="field-1" placeholder="Placeholder">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">确定</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">退出</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script class="resources library" src="../assets/js/area.js" type="text/javascript"></script>
<script type="text/javascript">
    _init_area();
</script>
<script type="text/javascript">
    var Gid = document.getElementById;

    var showArea = function() {

        Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" +

            Gid('s_city').value + " - 县/区" +

            Gid('s_county').value + "</h3>"

    }

    Gid('s_county').setAttribute('onchange', 'showArea()');
</script>

</body>
</html>