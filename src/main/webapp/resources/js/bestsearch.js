/**
 * Created by 零 on 2018/8/11.
 */



window.onload=function() {

    $("#bestSearchSubmmit").on ('click',function () {
        alert('提交成功');
        console.log($("#mask,#maskTop").html())
        alert('提交成功2');
        $("#popWinClose").click();
    });
}