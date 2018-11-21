function addLoadEvent(func){
    var oldonload = window.onload;
    if(typeof window.onload != 'function'){
        window.onload = func();
    }else{
        window.onload = function(){
            oldonload();
            func();
        }
    }
}
function table_onclick() {
    var thistable = document.getElementById("table");
    //var thistr = $('#table tr');
    thistable.onclick = function () {
        $.confirm({
            type: 'dark',
            animationSpeed: 300,
            title: '折线图',
            content: $('#createDialog').html(),
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
}
addLoadEvent(table_onclick);