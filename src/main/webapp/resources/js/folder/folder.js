$(document).ready(function(){
    /*文件夹操作*/
    var menu = new BootstrapMenu('.folderdiv', {//初始化插件
        //fetchElementData获取元数据
        fetchElementData:function($rowElem){
            var data = $rowElem;
            return data;    //return的目的是给下面的onClick传递参数
        },

        /*BootstrapMenu的构造函数第一个参数接收一个字符串格式的元素选择器，第二个参数是一个options参数对象。
         options对象必须至少有一个actions数组，数组中包含右键菜单的action。*/
        actions: [{
            name: '重命名',
            onClick: function(obj) {
                obj.children(".foldername").removeAttr("readonly");//去除input元素的readonly属性
                obj.children(".foldername").css({"border":"1px solid #082c05"});
            }
        }, {
            name: '删除',
            onClick: function(obj) {
                obj.remove();
            }
        }]
    });

    /*创建文件夹事件*/
    $(".create").click(function () {
        var $elements = $('.folderdiv');
        var len = $elements.length;
        if(len!="20") {
            $(".folderdiv:last").after("<div class='folderdiv'>" +
                "<div class='folder'>" +
                "<div class='front'></div>" +
                "<div class='back'></div>" +
                "</div>" +
                "<input type='text' class='foldername'  placeholder='新建文件夹' readonly='readonly' >" +
                "</div>"
            );
        }else{
            alert("文件夹超过20个，添加失败！")
        }
    });

    /*文件操作*/
    var menufile = new BootstrapMenu('.folderfilediv', {//初始化插件
        //fetchElementData获取元数据
        fetchElementData:function($rowElem){
            var data = $rowElem;
            return data;    //return的目的是给下面的onClick传递参数
        },

        /*BootstrapMenu的构造函数第一个参数接收一个字符串格式的元素选择器，第二个参数是一个options参数对象。
         options对象必须至少有一个actions数组，数组中包含右键菜单的action。*/
        actions: [{
            name: '重命名',
            onClick: function() {

            }
        }, {
            name: '移动',
            onClick: function(obj) {

            }
        },{
            name: '删除',
            onClick: function(obj) {

            }
        },{
            name: '下载',
            onClick: function(obj) {

            }
        }]
    });
});