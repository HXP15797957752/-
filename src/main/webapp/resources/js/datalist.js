/**
 * 测试1
 */
// 页面除以10的余数
function demo(n) {
    // 计算0的个数
    var div = n/10;
    var num_0 = div;
    var leavNumb = n%10;
    if(leavNumb == 1){
        var num_1 = div + 1;
    }
    else if (leavNumb == 2){
        var num_2 = div + 1;
    }
    else if (leavNumb == 3){
        var num_3 = div + 1;
    }
    else if (leavNumb == 4){
        var num_4 = div + 1;
    }
    else if (leavNumb == 5){
        var num_5 = div + 1;
    }
    else if (leavNumb == 6){
        var num_6 = div + 1;
    }
    else if (leavNumb == 7){
        var num_7 = div + 1;
    }
    else if (leavNumb == 8){
        var num_8 = div + 1;
    }
    else if (leavNumb == 9){
        var num_9 = div + 1;
    }
    else if (leavNumb == 0){
        num_0 = 1;
        num_1 = 1;
        num_2 = 1;
        num_3 = 1;
        num_4 = 1;
        num_5 = 1;
        num_6 = 1;
        num_7 = 1;
        num_8 = 1;
        num_9 = 1;
    }
    console.log("0:"+num_0 +"  1:"+num_1+"  2:"+num_2 +"  3:"+num_3+"   4:"+num_4 +"  5:"+num_5+"   6:"+num_6 +"  7:"+num_7+"8:"+num_8+"  9:"+num_9);
}