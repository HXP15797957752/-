var count = 0;
var this_url = "";
var data = "";
var click = device.mobile() ? 'touchstart' : 'click';
//创建Base64对象
var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9+/=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/rn/g,"n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}}
document.write("<script language=javascript src='resources/plugins/ajaxfileupload.js'></script>");
document.write("<script language=javascript src='resources/plugins/jquery.form.js'></script>");
// 加密
//var encodedString = Base64.encode(string);
//console.log(encodedString); // 输出: "SGVsbG8gV29ybGQh"
$(function () {
    // 侧边栏操作按钮
    $(document).on(click, '#guide', function () {
        $(this).toggleClass('toggled');
        $('#sidebar').toggleClass('toggled');
    });
    // 侧边栏二级菜单
    $(document).on('click', '.sub-menu a', function () {
        $(this).next().slideToggle(200);
        $(this).parent().toggleClass('toggled');
    });
    // 个人资料
    $(document).on('click', '.s-profile a', function () {
        $(this).next().slideToggle(200);
        $(this).parent().toggleClass('toggled');
    });
    // Waves初始化
    Waves.displayEffect();
    // 滚动条初始化
    $('#sidebar').mCustomScrollbar({
        theme: 'minimal-dark',
        scrollInertia: 100,
        axis: 'yx',
        mouseWheel: {
            enable: true,
            axis: 'y',
            preventDefault: true
        }
    });
    // 切换系统
    $('.switch-systems').click(function () {
        var systemid = $(this).attr('systemid');
        var systemname = $(this).attr('systemname');
        var systemtitle = $(this).attr('systemtitle');
        $('.system_menus').hide(0, function () {
            $('.system_' + systemid).show();
        });
        $('body').attr("id", systemname);
        $('#system_title').text(systemtitle);
        $.cookie('zheng-upms-systemid', systemid);
        $.cookie('zheng-upms-systemname', systemname);
        $.cookie('zheng-upms-systemtitle', systemtitle);
    });
    // 显示cookie菜单
    var systemid = $.cookie('zheng-upms-systemid') || 1;
    var systemname = $.cookie('zheng-upms-systemname') || 'zheng-upms-server';
    var systemtitle = $.cookie('zheng-upms-systemtitle') || '大数据智能猪舍管理';
    $('.system_menus').hide(0, function () {
        $('.system_' + systemid).show();
    });
    $('body').attr('id', systemname);
    $('#system_title').text(systemtitle);
});
// iframe高度自适应
function changeFrameHeight(ifm) {
    ifm.height = document.documentElement.clientHeight - 100;
}
function resizeFrameHeight() {
    $('.tab_iframe').css('height', document.documentElement.clientHeight - 100);
    $('md-tab-content').css('left', '0');
}
window.onresize = function () {
    resizeFrameHeight();
    initScrollShow();
    initScrollState();
}



// 选项卡对象
var Tab = {
    addTab: function (title, url ,jsonUrl) {
        var index = url.replace(/\./g, '_').replace(/\//g, '_').replace(/:/g, '_').replace(/\?/g, '_').replace(/,/g, '_').replace(/=/g, '_').replace(/&/g, '_');
        $('#jsonUrl').val(jsonUrl);
        // resources/data/equiOperCont.json
        // var pageIndex = jsonUrl.lastIndexOf("\/");
        // var pageUrl = jsonUrl.substring(pageIndex+1,jsonUrl.length);
        // pageUrl = pageUrl.replace('\.json','\.html');
        //console.log($('#tab_' + index));
         if (true) {
            // 添加选项卡
            $('.content_tab li').removeClass('cur');
            var tab = '<li id="tab_' + url + '" data-index="' + index + '" class="cur"><a class="waves-effect waves-light">' + title + '</a></li>';//<i class="zmdi zmdi-close"></i><
            $('.content_tab>ul').append(tab);
            // 添加iframe
            $('.iframe').removeClass('cur');
            var iframe = '<div id="iframe_' + index + '" class="iframe cur"><iframe class="tab_iframe" src="' + url + '" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe></div>';
            $('.content_main').append(iframe);
            initScrollShow();
            $('.content_tab>ul').animate({scrollLeft: document.getElementById('tabs').scrollWidth - document.getElementById('tabs').clientWidth}, 200, function () {
                initScrollState();
            });
        }
        // 关闭侧边栏
        $('#guide').trigger(click);
    },
    closeTab: function ($item) {
        var closeable = $item.data('closeable');
        if (closeable != false) {
            // 如果当前时激活状态则关闭后激活左边选项卡
            if ($item.hasClass('cur')) {
            	alert("dasd");
                $item.prev().trigger('click');
            }
            // 关闭当前选项卡
            var index = $item.data('index');
            $('#iframe_' + index).remove();
            $item.remove();
        }
        // initScrollShow();
    }
}

// 添加标签背景色
function add_bacColor(jsonUrl) {
    this_url = jsonUrl;
    var index = jsonUrl.lastIndexOf('\/');
    var item = jsonUrl.substring(index+1,jsonUrl.length-5);
    var use_item = document.getElementById(item).style.backgroundColor = "#27986f";
    var use_item = document.getElementById(item).style.opacity = "0.8";
    var use_item = document.getElementById(item).style.color = "black";
    var $item = $('.main-menu .waves-effect');

    $item.not($(document.getElementById(item))).css('background','white');
    // color: #989898;
    $item.not($(document.getElementById(item))).css('color','#989898');
    //usage:
    readTextFile(this_url, function(text){
        data = JSON.parse(text);
        console.log(data);
    });
//高级
    // 出现冒泡事件，先要取消冒泡，防止click执行两次
    $('.add').off('click').on('click',function () {
            if(count < (Object.keys(data[0][0])).length) {
                // console.log(count+"  "+this_url);
                // console.log(data[0][0]);
                var property = (Object.keys(data[0][0]))[count];// 数据表名
                var CN_property = (data[0][0][property]);// 标题
                $('.plus_input').append('<input type="text" class="form-control p_input p_add" id="p_input_'+count+'" placeholder="'+CN_property+'"  name='+ property+'>');

            }else {
                    alert("已经没有查询的条件！")
            }
            count ++;

    });

}

function delete_add() {
    // console.log("fresh");
    $('.p_add').remove();
    data = "";
    count = 0;
}



function initScrollShow() {
    // if (document.getElementById('tabs').scrollWidth > document.getElementById('tabs').clientWidth) {
    //     $('.content_tab').addClass('scroll');
    // } else {
    //     $('.content_tab').removeClass('scroll');
    // }
}
function initScrollState() {
    // if ($('.content_tab>ul').scrollLeft() == 0) {
    //     $('.tab_left>a').removeClass('active');
    // } else {
    //     $('.tab_left>a').addClass('active');
    // }
    // if (($('.content_tab>ul').scrollLeft() + document.getElementById('tabs').clientWidth) >= document.getElementById('tabs').scrollWidth) {
    //     $('.tab_right>a').removeClass('active');
    // } else {
    //     $('.tab_right>a').addClass('active');
    // }
}

function fullPage() {

    if ($.util.supportsFullScreen) {
        if ($.util.isFullScreen()) {
            $.util.cancelFullScreen();
        } else {
            $.util.requestFullScreen();
        }
    } else {
        alert("当前浏览器不支持全屏 API，请更换至最新的 Chrome/Firefox/Safari 浏览器或通过 F11 快捷键进行操作。");
    }
}
// 搜素
function searchAction() {
    //alert("hh");
    $.confirm({
        type: 'dark',
        animationSpeed: 300,
        title: '高级搜索',
        content: $('#createsearchDialog').html(),
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button',
                action: function () {
                	
                }
            },
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
}

// 搜素
function DataAnalysis() {
    //alert("hh");
    $.confirm({
        type: 'dark',
        animationSpeed: 300,
        title: '数据分析',
        content: $('#createanalysisDialog').html(),
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button',
                action: function () {
                    $.alert('确认');
                }
            },
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
}

// 信息录入
function MessageImport() {
    $.confirm({
        type: 'dark',
        animationSpeed: 300,
        title: '信息录入',
        content: $('#createimportDialog').html(),
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button',
                action: function () {
                    var formVal = '';//传至后台
                    var formName = '';
                    for (var j = document.getElementsByClassName('rl_data').length/2 ;j<document.getElementsByClassName('rl_data').length;j++){
                    	formVal += document.getElementsByClassName('rl_data')[j].value+",";
                    	if(document.getElementsByClassName('rl_data')[j].value == "" || document.getElementsByClassName('rl_data')[j].value == null){
                     		alert("请输入所有数据")
                     		return;
                     	}
                        formName += document.getElementsByClassName('rl_data')[j].name+',';         
                    }
                    var str = this_url.split('/');
                    var strClass = str[2].split('.');
                    var className = strClass[0];
                    var classService = className+'Service';
                    classService = classService.charAt(0).toUpperCase() + classService.slice(1);
                    var classMethod = className + 'Insert';
                    var relect = classService +':'+classMethod;
                    var encodedString = Base64.encode(relect);
                    var urlPath = '/IntelligentSystem/api/'+ encodedString;
                    $.ajax({
                        url : urlPath ,
                        type:"POST",
                        data : {
                            formVal : formVal,
                        	formName : formName,
                        	className : className
                        },
                        dataType : "json", 
                        success : function(result) {
                            alert(result[0].data);
                        },
                        error:function () {
                        	alert("插入失败");
                        }
                    });
                }
            },
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
}

function random(lower, upper) {
    return Math.floor(Math.random() * (upper - lower)) + lower;
}
// 可视化
function view() {
    $.confirm({
        type: 'dark',
        animationSpeed: 300,
        title: '数据可视化',
        content: '	',
        buttons: {
            confirm: {
                text: '保存',
                btnClass: 'waves-effect waves-button',
                action: function () {
                    $.alert('保存');
                }
            },
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
    loadView2();
}
//search
$(function () {
    $("#open").click(function () {
        $("#myModal").modal('show');
        loadView2();
    });
    $("#submit").click(function () {
        alert("信息已");
        $("#myModal").modal('hide');
    });
    $("#toggle").click(function () {
        $("#myModal").modal('toggle');
    });
    $(".wenduyibiaopan").click(function () {
        $("#myModa2").modal('show');
        loadQView();
    });
    $("#open-search").click(function () {
        $("#myModa-search").modal('show');
    });
    $("#submit-search").click(function () { 
  	    var formVal = '';//传至后台
        var formName = '';
        for (var j = 1; j<document.getElementsByClassName('p_input').length;j++){
        	formVal += document.getElementsByClassName('p_input')[j].value+",";
            formName += document.getElementsByClassName('p_input')[j].name+',';
        }
        var str = this_url.split('/');
        var strClass = str[2].split('.');
        var className = strClass[0];
        var classService = className+'Service';
        classService = classService.charAt(0).toUpperCase() + classService.slice(1);
        var classMethod = className + 'Select';
        var relect = classService +':'+classMethod;
        var encodedString = Base64.encode(relect);
        var urlPath = '/IntelligentSystem/api/'+ encodedString;
        $.ajax({
            url : urlPath ,
            type:"POST",
            data : {
                formVal : formVal,
            	formName : formName,
            	className : className
            },
            dataType : "json", 
            success : function(result) {
                alert(result[0].data);
            },
            error:function () {
            	alert("查询失败");
            }
        });  
        window.close();
    });
    $("#toggle-search").click(function () {
    	alert("dasdas");
        $("#myModal").modal('toggle');
    });
    $(".wenduyibiaopan").click(function () {
        $("#myModa2").modal('show');
        loadQView();
    });
    $("#submit2").click(function () {
        alert("信息已经");
        $("#myModal").modal('hide');
    });
});

// 信息设置
function MessageSetting() {
    //alert("hh");
    $.confirm({
        type: 'dark',
        animationSpeed: 300,
        title: '信息设置',
        content: $('#createsettingDialog').html(),
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button',
                action: function () {
                    var formVal = '';
                    var formName = '';
                    for (var k = document.getElementsByClassName('sz_data').length/2 ;k<document.getElementsByClassName('sz_data').length;k++){
                    	formVal += document.getElementsByClassName('sz_data')[k].value+",";
                    	 if(document.getElementsByClassName('sz_data')[k].value==""||document.getElementsByClassName('sz_data')[k].value==null){
                     		alert("请输入所有数据")
                     		return;
                     	}
                        formName += document.getElementsByClassName('sz_data')[k].name+',';   
                    }
                    var str = this_url.split('/');
                    var strClass = str[2].split('.');
                    var className = strClass[0];
                    var classService = className+'Service';
                    classService = classService.charAt(0).toUpperCase() + classService.slice(1);
                    var classMethod = className + 'Update';
                    var relect = classService +':'+classMethod;
                    var encodedString = Base64.encode(relect);
                    var urlPath = '/IntelligentSystem/api/'+ encodedString;
                    $.ajax({
                        url : urlPath ,
                        type:"POST",
                        data : {
                            formVal : formVal,
                        	formName : formName,
                        	className : className
                        },
                        dataType : "json", 
                        success : function(result) {
                            alert(result[0].data);
                        },
                        error:function () {
                        	alert("插入失败");
                        }
                    });
                }
            },
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
}
// 导入导出
function ImportExport() {
    //alert("hh");
    $.confirm({
        type: 'dark',
        animationSpeed: 300,
        title: '导入导出',
        content: $('#createexportDialog').html(),
        buttons: {
        	confirm1: {
                text: '导出excel',
                btnClass: 'icon icon-star',
                action: function () {            	
                	var str = this_url.split('/');
            	    var strClass = str[2].split('.');
            	    var className = strClass[0];
            	    var classService = className+'Service';
            	    classService = classService.charAt(0).toUpperCase() + classService.slice(1);
            	    var classMethod = className + 'DownloadExcel';
            	    var relect = classService +':'+classMethod;
            	    var encodedString = Base64.encode(relect);
            	    var urlPath = '/IntelligentSystem/api/'+ encodedString;  
                	var link= $('<a href="'+urlPath+'" target="_blank"></a>');
                	link.get(0).click();
                }
            },
            confirm2: {
                text: '导出pdf',
                btnClass: 'icon icon-star',
                action: function () {
                	var str = this_url.split('/');
            	    var strClass = str[2].split('.');
            	    var className = strClass[0];
            	    var classService = className+'Service';
            	    classService = classService.charAt(0).toUpperCase() + classService.slice(1);
            	    var classMethod = className + 'DownloadPDF';
            	    var relect = classService +':'+classMethod;
            	    var encodedString = Base64.encode(relect);
            	    var urlPath = '/IntelligentSystem/api/'+ encodedString;  
                	var link= $('<a href="'+urlPath+'" target="_blank"></a>');
                	link.get(0).click();
                }
            },
        	 confirm3: {
                 text: '确认',
                 btnClass: 'waves-effect waves-button',
                 action: function () {
                	var str = this_url.split('/');
            	    var strClass = str[2].split('.');
            	    var className = strClass[0];
            	    var classService = className+'Service';
            	    classService = classService.charAt(0).toUpperCase() + classService.slice(1);
            	    var classMethod = className + 'Upload';
            	    var relect = classService +':'+classMethod;
            	    var encodedString = Base64.encode(relect);
            	    var urlPath = '/IntelligentSystem/api/'+ encodedString;
            	    $("#myform").attr('action', urlPath);    //通过jquery为action属性赋值
                    $("#myform").submit();    //提交ID为myform的表单
                 }
             },
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
}
/*function ajaxFileUpload(urlPath) {
	
    $.ajaxFileUpload
    (
        {
            url: urlPath, //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'file1', //文件上传域的ID
            dataType: 'json', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {

                if (typeof (data.error) != 'undefined') {
                    if (data.error != '') {
                        alert('error');
                    } else {
                        alert('success');
                    }
                }
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert('error');
            }
        }
    )
    return false;
}*/
$(function () {
    MessagePlugin.init({
        elem: "#message",
        msgData:
            [
            {text: "来自猪场摄像头1号的消息", id: 1, readStatus: 0},
            {text: "来自猪场摄像头2的消息", id: 2, readStatus: 0},
            {text: "来自猪场温度传感器1号的消息", id: 3, readStatus: 0},
            {text: "来自猪场湿度传感器2号的消息", id: 4, readStatus: 0}
            ],
        msgUnReadData: 99,
        noticeUnReadData: 99,
        msgClick: function (obj) {
            //alert("湿度传感器1号高于阀值上限0.1度，请注意！");
            var r = confirm("湿度传感器1号高于阀值上限0.1度，请注意！是否启动相应设备工作来调整环境?")
            if (r == true) {
                alert("OK！");
            }
            else {
                alert("已取消");
            }
        },
        noticeClick: function (obj) {
            alert("您的编号为1111的猪死了");
        },
        allRead: function (obj) {
            alert("全部已读");
        },
        getNodeHtml: function (obj, node) {
            if (obj.readStatus == 1) {
                node.isRead = true;
            } else {
                node.isRead = false;
            }
            var html = "<p>" + obj.text + "</p>";

            node.html = html;

            return node;
        }
    });
});
function readTextFile(file, callback) {
    var rawFile = new XMLHttpRequest();
    rawFile.overrideMimeType("application/json");
    rawFile.open("GET", file, true);
    rawFile.onreadystatechange = function() {
        if (rawFile.readyState === 4 && rawFile.status == "200") {
            callback(rawFile.responseText);
            }
        }
    rawFile.send(null);
    }

$(function () {
    var block_2 = document.getElementById('block2');
    var block_3 = document.getElementById('block3');
    var block3_2 = document.getElementById('block3_2');
    var block_4 = document.getElementById('block4');
    var block4_2 = document.getElementById('block4_2');
    var note_hide = document.getElementById('note_hide');
    var node_show = document.getElementById('node_show');
    var message_hide = document.getElementById('message_hide');
    var message_show = document.getElementById('message_show');
    var message_p = document.getElementById('message_p');
    var cutlery_hide = document.getElementById('cutlery_hide');
    var cutlery_p = document.getElementById('cutlery_p');
    var cog = document.getElementsByClassName('fa-cog')[0];
    var refresh = document.getElementsByClassName('fa-refresh')[0];


   block_2.onmouseover = function (e) {
       console.log(e);
       note_hide.style.display = "";
       node_show.style.left = "87px";
       node_show.style.top = "243px";
   }
   block_2.onmouseout = function (e) {

       node_show.style.left = "84px";
       node_show.style.top = "246px";
       note_hide.style.display = "none";
   }
   block_3.onmouseover = function (e) {
       message_hide.style.display = "";
       message_p.style.paddingTop = "14px";
   }
   block_3.onmouseout = function (e) {
       message_hide.style.display = "none";
       message_p.style.paddingTop = "79px";
   }
   block3_2.onmouseover = function (e) {
       cutlery_hide.style.display = "";
       cutlery_p.style.paddingTop = "14px";
   }
   block3_2.onmouseout = function (e) {
       cutlery_hide.style.display = "none";
       cutlery_p.style.paddingTop = "79px";
   }
   block_4.onmouseover = function (e) {
       cog.className = 'fa fa-cog fa-spin fa-5x fa-fw' ;
   }
   block_4.onmouseout = function (e) {
       cog.className = 'fa fa-cog  fa-5x fa-fw';
   }
   block4_2.onmouseover = function (e) {
       refresh.className = 'fa fa-refresh fa-spin fa-5x fa-fw';
   }
   block4_2.onmouseout = function (e) {
       refresh.className = 'fa fa-refresh  fa-5x fa-fw';
   }
})
