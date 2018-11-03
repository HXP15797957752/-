<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>大数据智能猪舍系统</title>

    <!-- css文件-->
    <link href="resources/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="resources/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="resources/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
    <link href="resources/css/admin.css" rel="stylesheet"/>
    <link href="resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="resources/css/zui.css" rel="stylesheet"/>
    <link href="resources/css/zui.lite.css" rel="stylesheet"/>
    <link href="resources/css/zui-theme.css" rel="stylesheet"/>
    <link href="resources/lib/chosen/chosen.css" rel="stylesheet"/>
    <link href="resources/css/main_index.css" rel="stylesheet"/>
    <link href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/message.css">
    <style>
        /** skins **/
        #zheng-upms-server #header {background: #29A176;}
        #zheng-upms-server .content_tab{background: #29A176;}
        #zheng-upms-server .s-profile>a{background: url(./resources/images/zheng-upms.png) left top no-repeat;}

        #zheng-cms-admin #header {background: #455EC5;}
        #zheng-cms-admin .content_tab{background: #455EC5;}
        #zheng-cms-admin .s-profile>a{background: url(./resources/images/zheng-cms.png) left top no-repeat;}

        #zheng-pay-admin #header {background: #F06292;}
        #zheng-pay-admin .content_tab{background: #F06292;}
        #zheng-pay-admin .s-profile>a{background: url(./resources/images/zheng-pay.png) left top no-repeat;}

        #zheng-ucenter-home #header {background: #6539B4;}
        #zheng-ucenter-home .content_tab{background: #6539B4;}
        #zheng-ucenter-home .s-profile>a{background: url(./resources/images/zheng-ucenter.png) left top no-repeat;}

        #zheng-oss-web #header {background: #0B8DE5;}
        #zheng-oss-web .content_tab{background: #0B8DE5;}
        #zheng-oss-web .s-profile>a{background: url(./resources/images/zheng-oss.png) left top no-repeat;}



    </style>

    <!-- js文件-->
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/message.js"></script>
    <script src="resources/plugins/jquery.1.12.4.min.js"></script>
    <script src="resources/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
    <script src="resources/plugins/waves-0.7.5/waves.min.js"></script>
    <script src="resources/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="resources/plugins/BootstrapMenu.min.js"></script>
    <script src="resources/plugins/device.min.js"></script>
    <script src="resources/plugins/fullPage/jquery.fullPage.min.js"></script>
    <script src="resources/plugins/fullPage/jquery.jdirk.min.js"></script>
    <script src="resources/plugins/jquery.cookie.js"></script>
    <script src="resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
    <script src="resources/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="resources/plugins/jquery-confirm/jquery-confirm.min.js"></script>
    <script src="resources/plugins/select2/js/select2.min.js"></script>
    <script src="resources/js/zui.js"></script>
    <script src="resources/js/zui.lite.js"></script>
    <script src="resources/lib/chosen/chosen.min.js"></script>
    <script src="resources/js/common.js"></script>
    <!--echarts-->
    <script src="resources/js/echarts.min.js"></script>
    <!-- yourself js-->
    <script src="resources/js/admin.js"></script>

</head>
<body>
<header id="header">
    <ul id="menu">
        <li id="guide" class="line-trigger">
            <div class="line-wrap">
                <div class="line top"></div>
                <div class="line center"></div>
                <div class="line bottom"></div>
            </div>
        </li>
        <li id="logo" class="hidden-xs">
            <a href="index.html">
                <img src="resources/images/zzx.png"/>
            </a>
            <span id="lsy_title" style="color: #fff; height:33px; line-height: 33px; font-size: 16px;">生猪健康养殖系统</span>
        </li>
        <li class="pull-right">
            <ul class="hi-menu">
                <a class="waves-effect waves-button" href="javascript:;" id="open-search" style="color: whitesmoke;"><i class="glyphicon glyphicon-zoom-in"></i> 高级搜索</a>
                <a class="waves-effect waves-button" href="javascript:;" onclick="MessageImport()" style="color: whitesmoke;"><i class="glyphicon glyphicon-floppy-open"></i> 信息录入</a>
                <a class="waves-effect waves-button" href="javascript:;" onclick="ImportExport()" style="color: whitesmoke;"><i class="glyphicon glyphicon-sort"></i> 导入导出</a>
                <a class="waves-effect waves-button" href="javascript:;" onclick="MessageSetting()" style="color: whitesmoke;"><i class="glyphicon glyphicon-pencil"></i> 信息设置</a>
                <div id="message"></div>
                <li class="dropdown">
                    <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                        <i class="him-icon zmdi zmdi-more-vert"></i>
                    </a>
                    <ul class="dropdown-menu dm-icon pull-right">
                        <li class="hidden-xs">
                            <a class="waves-effect" data-ma-action="fullscreen" href="javascript:fullPage();"><i class="zmdi zmdi-fullscreen"></i> 全屏模式</a>
                        </li>
                        <li>
                            <a class="waves-effect" data-ma-action="clear-localstorage" href="javascript:;"><i class="zmdi zmdi-delete"></i> 清除缓存</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-face"></i> 隐私管理</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-settings"></i> 系统设置</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-run"></i> 退出登录</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>

</header>
<!--高级搜索-->
<div class="modal fade" id="myModa-search" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" style=" width:680px; height: 70%;">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">高级搜索</h4>
            </div>
            <div class="modal-body" style="width:680px; height: 420px ;overflow:auto">
                    <div class="plus_input" id="plus_input" >
                        <input type="text" class="form-control p_input " id="p_input" placeholder="点击加号添加搜索条件" disabled><div><i class="glyphicon glyphicon-plus add" id="add"></i></div>
                    </div>

                    <span style="float: right; margin: 33px;font-size: 20px;color: #29a176;font-family: 'Microsoft Yahei';" ><i class="icon icon-paint-brush"></i>请输入搜索条件</span>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary" id="submit-search" type="button">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->

</div>



<!--信息录入-->
<div id="createimportDialog" class="crudDialog" hidden>
    <div class="input-control" >
        <input type="text" class="form-control" placeholder="设备ID">
    </div>
    <div class="input-control">
        <input  type="text" class="form-control" placeholder="传感器设备名称">
    </div>
    <div class="input-control">
        <input type="text" class="form-control" placeholder="猪舍ID" >
    </div>
    <div class="input-control">
        <input type="text" class="form-control" placeholder="猪栏ID" >
    </div>
    <div class="input-control">
        <input type="text" class="form-control" placeholder="采集时间间隔">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox">是否自动处理异常
        </label>
    </div>
</div>


<!--导入导出-->
<div id="createexportDialog" class="crudDialog" hidden>
    <h3>导入</h3>
    <input type="file">

    <hr>
    <h3>导出</h3>
    <span>导出当前文件为：</span><br>
    <button class="btn " type="button"><i class="icon icon-star"></i> excel格式</button>
    <button class="btn " type="button"><i class="icon icon-star"></i> pdf格式</button>
</div>
<!--信息设置-->
<div id="createsettingDialog" class="crudDialog" hidden>
</div>


<section id="main">
    <!-- 左侧导航区 -->
    <aside id="sidebar">
        <!-- 个人资料区 -->
        <div class="s-profile">
            <a class="waves-effect waves-light" href="javascript:;">
                <div class="sp-pic">
                    <img src="resources/images/avatar.jpg"/>
                </div>
                <div class="sp-info">
                    <span id="userNo" class = "user" name="userNo"></span>
                    <i class="zmdi zmdi-caret-down"></i>
                </div>
            </a>
            <ul class="main-menu">
                <li>
                    <a class="waves-effect" href="javascript:Tab.addTab('个人资料','persData.html');"><i class="zmdi zmdi-account"></i> 个人资料</a>
                </li>
            </ul>
        </div>
        <!-- /个人资料区 -->
        <!-- 菜单区 -->
        <ul class="main-menu">
            <li>
                <a class="waves-effect" href="index.jsp"><i class="zmdi zmdi-home"></i> 首页</a>
            </li>
            <!-- <li class="sub-menu system_menus system_1 0">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts-list"></i> 设备管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/equiOperCont.json');delete_add();Tab.addTab('设备运行控制', 'dataList.html','resources/data/equiOperCont.json');" data-url="resources/data/equiOperCont.json" id="equiOperCont">设备运行控制</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/sensMana.json');delete_add();Tab.addTab('传感器管理', 'dataList.html','resources/data/sensMana.json');" data-url='resources/data/sensMana.json' id="sensMana">传感器管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/enviContEquiMana.json');delete_add();Tab.addTab('环控设备管理', 'dataList.html','resources/data/enviContEquiMana.json');" data-url='resources/data/enviContEquiMana.json' id="enviContEquiMana">环控设备控制</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/deviExceInfoChec.json');delete_add();Tab.addTab('设备异常信息查看', 'dataList.html','resources/data/deviExceInfoChec.json');" data-url='resources/data/deviExceInfoChec.json' id="deviExceInfoChec">设备异常信息查看</a></li>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 3">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts"></i> 猪只管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/stanSett.json');delete_add();Tab.addTab('生长情况标准设置', 'dataList.html','resources/data/stanSett.json');" data-url='resources/data/stanSett.json' id="stanSett">生长情况标准设置</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/equiOperCont.json');delete_add();Tab.addTab('生长情况统计', 'dataList.html');" >生长情况统计</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/suspIllnStat.json');delete_add();Tab.addTab('疑似生病统计', 'dataList.html');">疑似生病统计</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/pigElimMana.json');delete_add();Tab.addTab('猪只淘汰管理', 'dataList.html','pigElimMana');">猪只淘汰管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/feedMana.json');delete_add();Tab.addTab('饲喂管理', 'dataList.html','resources/data/feedMana.json');" data-url='resources/data/feedMana.json' id="feedMana">饲喂管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/formColl.json');delete_add();Tab.addTab('配方搭配', 'dataList.html','resources/data/formColl.json');" data-url='resources/data/formColl.json' id="formColl">配方搭配</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/feedRegu.json');delete_add();Tab.addTab('饲喂调控', 'dataList.html','resources/data/feedRegu.json');" data-url='resources/data/feedRegu.json' id="feedRegu">饲喂调控</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/feedStat.json');delete_add();Tab.addTab('饲喂统计', 'dataList.html','resources/data/feedStat.json');" data-url='resources/data/feedStat.json' id="feedStat">饲喂统计</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/pigInfoMana.json');delete_add();Tab.addTab('猪只信息管理', 'dataList.html','resources/data/pigInfoMana.json');" data-url='resources/data/pigInfoMana.json' id="pigInfoMana">猪只信息管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/pigSafeMana.json');delete_add();Tab.addTab('猪只安全管理', 'dataList.html','resources/data/pigSafeMana.json');" data-url='resources/data/pigSafeMana.json' id="pigSafeMana">猪只安全管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/vaccSett.json');delete_add();Tab.addTab('疫苗接种设置', 'dataList.html','resources/data/vaccSett.json');" data-url='resources/data/vaccSett.json' id="vaccSett">疫苗接种设置</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/vaccMana.json');delete_add();Tab.addTab('疫苗接种管理', 'dataList.html','resources/data/vaccMana.json');" data-url='resources/data/vaccMana.json' id="vaccMana">疫苗接种管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/diseMana.json');delete_add();Tab.addTab('疾病管理', 'dataList.html','resources/data/diseMana.json');" data-url='resources/data/diseMana.json' id="diseMana">疾病管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/destMana.json');delete_add();Tab.addTab('销毁管理', 'dataList.html','resources/data/destMana.json');" data-url='resources/data/destMana.json' id="destMana">销毁管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/migrMana.json');delete_add();Tab.addTab('移栏管理', 'dataList.html','resources/data/migrMana.json');" data-url='resources/data/migrMana.json' id="migrMana">移栏管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/entrMana.json');delete_add();Tab.addTab('入栏管理', 'dataList.html','resources/data/entrMana.json');" data-url='resources/data/entrMana.json' id="entrMana">入栏管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/coluMana.json');delete_add();Tab.addTab('出栏管理', 'dataList.html','resources/data/coluMana.json');" data-url='resources/data/coluMana.json' id="coluMana">出栏管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/hurdMana.json');delete_add();Tab.addTab('转栏管理', 'dataList.html','resources/data/hurdMana.json');" data-url='resources/data/hurdMana.json' id="hurdMana">转栏管理</a></li>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 6">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-lock-outline"></i> 维护与安全管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/rzgl.json');Tab.addTab('日志管理', 'dataList.html','/IntelligentSystem/api/TG9nTWFuYWdlOnF1ZXJ5TGlzdA==');" id="rzgl">日志管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/qxgl.json');delete_add();Tab.addTab('权限管理', 'rightMana.html','resources/data/rightMana.json');"  id="rig" >权限管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/sjk.json');delete_add();Tab.addTab('数据库备份与恢复', 'dataBase.html','resources/data/dataBase.json');" data-url='resources/data/dataBase.json' id="dataBase">数据库备份与恢复</a></li>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 7">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-more"></i> 库存管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/formColl1.json');delete_add();Tab.addTab('入库管理', 'dataList.html','resources/data/formColl.json');" data-url='resources/data/formColl.json' id="formColl1">入库管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/formColl2.json');delete_add();Tab.addTab('出库管理', 'dataList.html','resources/data/formColl.json');" data-url='resources/data/formColl.json' id="formColl2">出库管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/formColl3.json');delete_add();Tab.addTab('查看入库单分析报告', 'dataList.html','resources/data/formColl.json');" data-url='resources/data/formColl.json' id="formColl3">查看入库单分析报告</a></li>
                </ul>
            </li>
            <li>
                <a class="waves-effect" href="javascript:add_bacColor('resources/data/algoMana.json');delete_add();Tab.addTab('算法管理', 'algoMana.html');" id="algoMana"><i class="glyphicon glyphicon-book"></i> 算法管理</a>
            </li>
            <li class="sub-menu system_menus system_1 7">
                <a class="waves-effect" href="javascript:;"><i class="glyphicon glyphicon-user"></i> 用户管理</a>
                <ul>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/userAudiActiDiag.json');Tab.addTab('用户审核', 'dataList.html', '/IntelligentSystem/api/VXNlclNlcnZpY2U6bG9hZFVzZXJzQXVkaXQ=');"  id="userAudiActiDiag">用户审核</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/userCanc.json');delete_add();Tab.addTab('用户注销', 'dataList.html', 'resources/data/userCanc.json');" data-url='resources/data/userCanc.json' id="userCanc">用户注销</a></li>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 8">
                <a class="waves-effect" href="javascript:add_bacColor('resources/data/consSett.json');delete_add();Tab.addTab('养护结算', 'dataList.html','resources/data/consSett.json');" data-url='resources/data/consSett.json' id="consSett"><i class="fa fa-hand-lizard-o" ></i> 养护结算</a>
            </li>
            <li class="sub-menu system_menus system_1 9">
                <a class="waves-effect" href="javascript:;" ><i class="fa fa-child" aria-hidden="true"></i>母猪管理</a>
                <ul>

                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/sowBree.json');delete_add();Tab.addTab('母猪配种管理', 'dataList.html','resources/data/sowBree.json');" data-url='resources/data/sowBree.json' id="sowBree">母猪配种管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/weanCont.json');delete_add();Tab.addTab('母猪断奶管理', 'dataList.html','resources/data/weanCont.json');" data-url='resources/data/weanCont.json' id="weanCont">母猪断奶管理</a></li>
                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/sowsDeli.json');delete_add();Tab.addTab('母猪分娩管理', 'dataList.html','resources/data/sowsDeli.json');" data-url='resources/data/sowsDeli.json' id="sowsDeli">母猪分娩管理</a></li>

                </ul>
            </li> -->
            <!-- 根据权限循环显示不同角色的不同菜单 -->
            <c:forEach items="${menuList}" var="menu">
	            <li class="sub-menu system_menus system_1 9">	                
	                <a class="waves-effect" href="javascript:;"><i class="${menu.label }"></i> ${menu.menuName }</a>	                
	                <ul>
	                <c:forEach items="${menu.menuItemList}" var="menuItem">
	                    <li><a class="waves-effect" href="javascript:add_bacColor('resources/data/${menuItem.labelId }.json');Tab.addTab('${menuItem.itemName }', '${menuItem.targetPage }', '${menuItem.serviceURL }');"  id="${menuItem.labelId }">${menuItem.itemName }</a></li>
	                </c:forEach>
	                </ul>	                
	            </li>
            </c:forEach>
            
            <li>
                <div class="upms-version">
                    &copy; lsy V1.0.0
                </div>
            </li>
        </ul>
        <!-- /菜单区 -->
    </aside>
    <!-- /左侧导航区 -->
    <section id="content">

        <div class="content_main">
            <div id="iframe_home" class="iframe cur">
                <div class="block_main">
                    <div class="block_1">
                        <div class="color"></div>
                        <div class="block_pic">
                            <i class="fa fa-user-o fa-5x" aria-hidden="true"></i>
                            <p>个人信息</p>
                        </div>
                        <div class="block_production">
                            <span>欢迎您,<span class="user" name="trueName"></span></span>
                             <h5>姓名：<span class="user" name="trueName"></span></h5> 
                             <h6>员工号：<span class="user" name="userNo"></span></h6>
                        </div>
                    </div>
                    <!--第二块-->
                    <a href="#" style="text-decoration: none;color: whitesmoke"  class="block_2" id="block_2">
                    <div class="block2" id="block2">
                        <div class="note_hide"><i class="fa fa-sticky-note fa-5x " aria-hidden="true"  id="note_hide" style="display: none"></i></div>
                        <i class="fa fa-sticky-note fa-5x node_show" aria-hidden="true" id="node_show"></i>

                        <P>生长情况统计</P>
                    </div>
                    </a>
                    <!--第三块-->
                    <div class="block_3">

                        <a href="#" style="text-decoration: none;color: whitesmoke">
                            <div class="block_3_1 block3" id="block3">
                            <div class="message_hide"><i class="fa fa-search fa-5x " aria-hidden="true"  id="message_hide" style="display: none"></i></div>
                            <i class="fa fa-search fa-5x message_show" aria-hidden="true" id="message_show"></i>
                                <p id="message_p">异常信息查看</p>
                        </div>
                        </a>

                        <a href="#" style="text-decoration: none;color: whitesmoke">
                            <div class="block_3_2" id="block3_2">
                            <div class="cutlery_hide"><i class="fa fa-cutlery fa-5x " aria-hidden="true"  id="cutlery_hide" style="display: none"></i></div>
                                <i class="fa fa-cutlery fa-5x cutlery_show" aria-hidden="true"></i>
                                <p id="cutlery_p">饲喂管控</p>
                        </div>
                        </a>

                    </div>
                    <!--第四块-->
                    <div class="block_4">
                        <a href="#" style="text-decoration: none;color: whitesmoke">
                            <div class="block_4_1" id="block4">
                            <i class="fa fa-cog  fa-5x fa-fw"></i>
                            <!--<span class="sr-only">Loading...</span>-->
                                <p>传感器控制</p>
                        </div>
                        </a>
                        <a href="#" style="text-decoration: none;color: whitesmoke">
                            <div class="block_4_2" id="block4_2">

                            <i class="fa fa-refresh fa-5x fa-fw"></i>
                                <p>环控设备管理</p>
                            <span class="sr-only">Loading...</span>
                        </div>
                        </a>
                    </div>

                </div>

            </div>
        </div>


    </section>

</section>
<input type="hidden" id="jsonUrl" hidden/>
<script type="text/javascript">

var baseUrl = "http://localhost:8080/IntelligentSystem";
var islogin = sessionUser(baseUrl);
$("#userNo").html("未登录");

</script>
</body>
</html>