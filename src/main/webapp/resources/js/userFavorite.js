//-----------------------------
// 易捷
//-----------------------------
/**
 * 新建收藏夹
 */
function newFile() {
    if ($("#favorite:visible").length != 0) {
        return;
    }
    var input = "<input type='text' class='form-control ' value='新建收藏夹' name='favoriteName'>";
    var fa_check = "<button class='btn btn-white btn-icon btn-icon-standalone btn-sm' onclick='createFavorite();'><i class='fa fa-check'></i></button>";
    var fa_remove = "<button class='btn btn-white btn-icon btn-icon-standalone btn-sm' onclick='newFileOver();'><i class='fa fa-remove'></i></button>";

    $(".favoriteTable tbody").prepend(
        $("<tr id='favorite'>").append($("<td>"))
            .append($("<td>").html(input))
            .append($("<td>").html(fa_check + fa_remove))
            .append($("<td>")));
    $("#favorite input[name=favoriteName]").get(0).select();
}

function newFileOver() {
    $('#favorite').remove();
    console.log($("#favorite"));
}

//-----------------------------
//
//-----------------------------
$(function () {
    initClick();

    // Edit Modal
    $('.gallery-env a[data-action="edit"]').on('click', function (ev) {
        ev.preventDefault();
        $("#gallery-image-modal").modal('show');
    });
    //Delete
    $('.gallery-env a[data-action="trash_favoriteSpectrum"]').on('click', function (ev) {
        if (hasSpectrum()) {
            ev.preventDefault();
            $("#trash_favoriteSpectrum_modal").modal('show');
        } else {
            ev.preventDefault();
            $("#trash_favoriteSpectrum_modal_prompt").modal('show');
        }
    });

    $("#select-all").on('change', function (ev) {
        var is_checked = $(this).is(':checked');
        $(".favoriteTable tbody input[type='checkbox']").prop('checked', is_checked).trigger('change');
    });

    /* 设置监听器 */


    //新建收藏夹
    $("#create").on("click", newFile);


    //利用路径切换收藏夹
    $("#up").on("click", switchFavoriteWithUp);

    //修改
    $("#modify").on("click", modifySpectrum);

    //显示检索modal
    $("#search").on("click", search);


    /**
     * 与收藏夹相关的若干事件
     * 由于每次更新收藏夹，有许多事件都需要重新装配,所以特地抽出
     */
    onFavoriteEvent();
});

var favoriteIDList = new Array();
var favoriteNameList = new Array();
var FILE_SEPARATOR = "\\";
var oldFavoriteName = "";
var oldFavoriteCreateTime = "";

function initClick() {
    // Delete 收藏夹
    $('.gallery-env a[data-action="trash_favorite"]').on('click', function (ev) {
        ev.preventDefault();
        $("#trash_favorite_modal").modal('show');
    });
    //Delete 收藏夹的光谱
    $('.gallery-env a[data-action="trash_spectrum"]').on('click', function (ev) {
        ev.preventDefault();
        $("#trash_spectrum_modal").modal('show');
    });
    var $chcks = $(".directory tbody input[type='checkbox']");
    // Row Highlighting
    $chcks.each(function (i, el) {
        var $tr = $(el).closest('tr');
        $(this).on('change', function (ev) {
            $tr[$(this).is(':checked') ? 'addClass' : 'removeClass']('highlighted');
        });
    });
};

/**
 * 由于favorite中的元素每次变动后，
 * 事件都需要重新绑定，所以特地抽出
 */
function onFavoriteEvent() {


    //为收藏夹<tr>设置显示工具监听器
    $(".favorite").off("mouseenter").off("mouseleave").on("mouseenter", function () {
        $('td ul', $(this)).show();
    }).on("mouseleave", function () {
        $('td ul', $(this)).hide();
    })

    //重命名
    $(".favoriteTool a.rename").off("click").on("click", function (event) {
        /* 与重命名相关的DOM操作 */
        var $tr = $(this).closest("tr");
        var $td1 = $tr.find("td:eq(1)");
        var $td2 = $tr.find("td:eq(2)");
        oldFavoriteName = $tr.find("td:eq(1)>a").text().trim(); //旧收藏夹名称
        oldFavoriteCreateTime = $tr.find("td:eq(3)").text();
        $td1.replaceWith("<td><input type='text' class='form-control ' value='" + oldFavoriteName + "' name='favoriteName'></td>");
        $td2.replaceWith("<td>\
                            <button class='btn btn-white btn-icon btn-icon-standalone btn-sm' onclick='renameFavorite(this);'>\
                                <i class='fa-check'></i>\
                            </button>\
                            <button class='btn btn-white btn-icon btn-icon-standalone btn-sm' onclick='newFileOverX(this);'>\
                                <i class='fa-remove'></i>\
                            </button>\
                        </td>");
        $tr.find("input[name=favoriteName]").select();
        return false;
    });


    //查看光谱信息
    $(".spectrumTool a.look").off("click").on("click", showSpectrumDetail);
    $(".spectrum .speName").off("click").on("click", showSpectrumDetail);

    //使用光谱
    $(".spectrumTool a.open").off("click").on("click", function (event) {
        console.log("trigger open event");
        return false;
    });

    //删除光谱
    $(".deleteSpectrum").off("click").on("click", deleteSpectrum);

    //删除收藏夹
    $(".deleteFavorite").off("click").on("click", deleteFavorite);

}

/**
 * 收藏夹重命名
 */
function renameFavorite(self) {
    /* 构造参数 */
    var parentID = getCurFavoriteID();
    var oldPath = "";
    if (parentID) {
        oldPath = getCurPath() + FILE_SEPARATOR + oldFavoriteName;
    } else {
        oldPath = oldFavoriteName;
    }
    var $tr = $(self).parent.closest("tr");
    var favoriteID = $tr.attr("data-favoriteID");
    var newFavoriteName = $tr.find("input[name=favoriteName]").prop("value");

    $(".form-control").val(newFavoriteName);
}

function newFileOverX(self) {
    $tr = $(self).closest("tr");
    var $td1 = $tr.find("td:eq(1)");
    var $td2 = $tr.find("td:eq(2)");
    var favoriteID = $tr.attr("data-favoriteId");
    $td1.replaceWith("<td class='favoriteName' data-favoriteID='" + favoriteID + "'><i class='fa-folder-o'></i><a>&nbsp;&nbsp;" + oldFavoriteName + "</a></td>");
    $td2.replaceWith("<td class='favoriteTool'>\
                        <ul class='album-options list-unstyled list-inline hover' style='display:none'>\
                            <li>\
                                <a class='rename' href='#'> \
                                    <i class='fa-edit'></i>重命名\
                                </a>\
                            </li>\
                            <li>\
                                <a class='deleteFavorite' href='#'>\
                                    <i class='fa-trash'></i>删除\
                                </a>\
                            </li>\
                        </ul>\
                    </td>");
    onFavoriteEvent();
}

function switchFavoriteWithUp(event) {
    /* 获取并拼接参数*/
    var data = null;
    var tempFavoriteIDList = favoriteIDList;
    var tempFavoriteNameList = favoriteNameList;
    if (favoriteIDList.length <= 1) {
        data = "async=1";
    } else {
        data = "async=1&curFavoriteID=" + favoriteIDList[favoriteIDList.length - 2];
    }

    favoriteIDList.pop(); //用于构造路径
    favoriteNameList.pop(); //用于构造路径

    /* 发送ajax请求 */
    var url = "query/queryUserFavorite";
    $.get(url, data, function (jsonData) {
        var webData = new WebData(jsonData);
        if (!webData.isError()) {
            var favoriteList = jsonData.data.favoriteList;
            var spectrumList = jsonData.data.spectrumList;
            /* 删除收藏夹tbody */
            removeFavorite();

            /* 更新路径 */
            removePath();

            /* 构造收藏夹tbody */
            displayFavoriteTable(favoriteList, spectrumList);
            onFavoriteEvent();
        } else {
            alert(jsonData);
            favoriteIDList = tempFavorieIDList;
            favoriteNameList = tempFavoriteNameList
        }
    });
}

function modifySpectrum(event) {
    /* 收集参数 */
    var $modal = $("#modal_spectrumDetail");
    var speName = $modal.find("#speName").prop("value");
    var description = $modal.find("#description").prop("value");
    var speID = $modal.attr("data-speID");
    var paramArr = [];

    /* 参数验证 */
    var regExp = /[\\/:*?"<>|$]/;
    if (regExp.test(speName)) {
        alert("请光谱名称勿包含下列字符\\ / : * ? \" < > | $");
        return false;
    }
    if (speName.length < 1 || speName.length > 16) {
        alert("请光谱名称保证在1至16个字符之间");
        return false;
    }
    if (description.length >= 256) {
        alert("请保证光谱描述在256个字符之内");
        return false;
    }
    if (isRepeatOnSpectrum(speName)) {//光谱名称是否重名
        alert("光谱名称在当前目录下重名");
        return false;
    }

    /* 封装表单 */
    paramArr.push("spectrum.speName=" + speName);
    paramArr.push("spectrum.description=" + description);
    paramArr.push("spectrum.speID=" + speID);
    paramArr.push("favorite.favoriteID=" + getCurFavoriteID());
    var url = "spectrum/modifySpectrum";

    /* 发送请求 */
    $.post(url, paramArr.join("&"), function (jsonData) {
        alert(jsonData.msg);
        var webData = new WebData(jsonData);
        if (!webData.isError()) { //更新DOM
            $("tr.spectrum[data-speID=" + speID + "]").find(".speName>a").html("&nbsp;&nbsp;" + speName);
        }
    }, "json");
}


function displayFavoriteTable(favoriteList, spectrumList) {
    /* 插入favoriteList */
    var fragment = document.createDocumentFragment();
    $(favoriteList).each(function (index, favorite) {
        $(fragment).append(getFavoriteItem(favorite));
    });

    /* 插入spectrumList */
    $(spectrumList).each(function (index, spectrum) {
        $(fragment).append(getSpectrumItem(spectrum));
    });
    $(".favoriteTable tbody").append(fragment);
}

function download() {
    if (!hasChecked()) {
        alert("请选中若干光谱项");
        return;
    }
    if ($("tr.favorite input:checked").length > 0) {
        alert("请勿选中收藏夹");
        return;
    }
    /* 构造参数字符串 */
    var queryArr = [];
    $(".favoriteTable tbody input:checked").each(function (i, v) {
        queryArr.push("speID=" + $(v).val());
    });
    toLocation("spectrum/downloadSpectrum?" + queryArr.join("&"));
}

function upload() {
    toLocation("view?v=uploadSpectrum");//上传页面
}

function submit() {
    if (!hasChecked()) {
        alert("请选中若干光谱项");
        return;
    }
    if ($("tr.favorite input:checked").length > 0) {
        alert("请勿选中收藏夹");
        return;
    }
    if (!confirm("确认提交")) {
        return;
    }
    /* 收集参数 */
    var paramArr = [];
    $(".spectrum input:checked").each(function (index, item) {
        paramArr.push("speID=" + item.getAttribute("value"));
    });
    var url = "spectrum/submitSpectrum";
    /* 发送ajax请求 */
    $.post(url, paramArr.join("&"), function (jsonData) {
        alert(jsonData.msg);
    }, "json")
}

/**
 * 显示光谱信息
 */
function showSpectrumDetail(event) {
    /* 构造参数 */
    var speID = $(this).closest("tr").attr("data-speId");
    var paramArr = [];
    paramArr.push("async=1");
    paramArr.push("speID=" + speID);
    var url = "query/querySpectrumDetail";

    /* 发送ajax请求 */
    $.get(url, paramArr.join("&"), function (jsonData) {
        var webData = new WebData(jsonData);
        if (webData.isError()) {
            alert(jsonData.msg);
            return false;
        }
        var spectrum = jsonData.data;
        var $modal = $("#modal_spectrumDetail");

        /* 设置数据及样式 */
        setSpectrumDetailModal($modal, spectrum);

        /* 显示modal */
        jQuery($modal).modal('show', {backdrop: 'fade'});
    }, "json");
    return false;
}

function setSpectrumDetailModal($modal, spectrum) {
    /* 设置数据 */
    $modal.attr("data-speID", spectrum.speID);
    $modal.find("#useSpectrum").attr("href", "view?v=spectrumAnalyze&speID=" + spectrum.speID);
    $modal.find("#spectrumReport").attr("href", "query/querySpectrumDetail?speID=" + spectrum.speID);
    $modal.find("#speName").prop("value", spectrum.speName);
    $modal.find("#speType").prop("value", spectrum.speType.speType);

    if (spectrum.standard) {
        $modal.find("#isStandard").prop("checked", true);
    } else {
        $modal.find("#noStandard").prop("checked", true);
    }
    $modal.find("#saveTime").prop("value", spectrum.saveTime);
    $modal.find("#description").prop("value", spectrum.description);
    $modal.find("#detectedObject").prop("value", spectrum.detected.cnName + " ; " + spectrum.detected.enName);
    var spectrumContentArr = [];
    for (var i = 0; i < spectrum.spectrumContents.length; i++) {
        console.log(spectrum.spectrumContents[i])
        spectrumContentArr.push(spectrum.spectrumContents[i].content.cnName);
    }
    $modal.find("#spectrumContent").prop("value", spectrumContentArr.join(" ; "));
    $modal.find("#resolutionRate").prop("value", spectrum.resolutionRate);

    var peaks = $modal.find("#peaks");
    peaks.val(spectrum.peaks);

    /* 设置样式 */
    if (spectrum.standard) { //光谱名称和光谱描述不可改变
        $modal.find("#speName").attr("disabled", "disabled");
        $modal.find("#description").attr("disabled", "disabled");
        $modal.find("#modify").attr("disabled", "disabled");
    } else {
        $modal.find("#speName").removeAttr("disabled");
        $modal.find("#description").removeAttr("disabled");
        $modal.find("#modify").removeAttr("disabled");
    }
}

function search(event) {
    var $modal = $("#modal_search");
    jQuery($modal).modal('show', {backdrop: 'fade'});
}

function searchSpectrum(event) {
    /* 收集参数 */
    var $modal = $("#modal_search");
    var paramArr = [];
    paramArr.push("speName=" + $modal.find("input[name=speName]").prop("value"));
    paramArr.push("favoriteName=" + $modal.find("input[name=favoriteName]").prop("value"));
    paramArr.push("startDate=" + $modal.find("input[name=startDate]").prop("value"));
    paramArr.push("endDate=" + $modal.find("input[name=endDate]").prop("value"));
    var url = "query/queryFavoriteContentPlus";

    /* 发送ajax请求 */
    $.get(url, paramArr.join("&"), function (jsonData) {
        var webData = new WebData(jsonData);
        if (webData.isError()) {
            alert(jsonData.msg);
            return;
        }
        var spectrumList = jsonData.data;
        var fragment = document.createDocumentFragment();
        $(spectrumList).each(function (index, spectrum) {
            $(fragment).append(getSpectrumItem(spectrum));
        });
        removeFavorite();
        $(".favoriteTable tbody").append(fragment);
        onFavoriteEvent();
        if (spectrumList.length == 0) {
            alert("检索结果为空");
            return;
        }
    }, "json");
}

/**
 * 删除单个
 */
function deleteSpectrum(event) {
    if (!confirm("确认删除")) {
        return false;
    }
    /* 构造参数字符串 */
    var favoriteID = getCurFavoriteID();
    var $tr = $(this).closest("tr");
    var speID = $tr.attr("data-speID");
    var data = "async=1&spectrum.speID=" + speID + "&favorite.favoriteID=" + favoriteID; //置一个空的favoriteID，防止服务端抛NPE
    var url = "spectrum/deleteSpectrum";

    /* 发送ajax请求 */
    $.post(url, data, function (jsonData) {
        var webData = new WebData(jsonData);
        alert(jsonData.msg);
        if (!webData.isError()) {
            $tr.remove();
        }
    }, "json");
    return false;
}

/**
 * 删除单个收藏夹
 */
function deleteFavorite(event) {
    if (!confirm("确认删除")) {
        return false;
    }
    /* 构造参数字符串 */
    var $tr = $(this).closest("tr");
    var favoriteID = $tr.attr("data-favoriteID");
    var data = "async=1&favorite.favoriteID=" + favoriteID;
    var url = "spectrum/deleteFavorite";

    /* 发送ajax请求 */
    $.post(url, data, function (jsonData) {
        var webData = new WebData(jsonData);
        alert(jsonData.msg);
        if (!webData.isError()) {
            $tr.remove();
        }
    }, "json");
    return false;
}

/**
 * 批量删除光谱和收藏夹
 */
function deleteSpectrumAndFavorite(event) {
    if (!hasChecked()) {
        alert("请选中若干选项");
        return;
    }
    if (!confirm("确认删除")) {
        return false;
    }
    /* 构造参数字符串 */
    var favoriteIDArr = [];
    $("tr.favorite input:checked").each(function (index, item) {
        favoriteIDArr.push("favoriteID=" + $(item).val());
    });
    var spectrumIDArr = [];
    $("tr.spectrum input:checked").each(function (index, item) {
        spectrumIDArr.push("speID=" + $(item).val());
    });
    var paramArr = [];
    paramArr.push("async=1");
    var favoriteID = getCurFavoriteID();
    if (favoriteID) {
        paramArr.push("favorite.favoriteID=" + getCurFavoriteID());
    }
    paramArr.push(favoriteIDArr.join("&"));
    paramArr.push(spectrumIDArr.join("&"));

    var url = "spectrum/deleteSpectrumsAndFavorites";
    /* 发送ajax请求 */
    $.post(url, paramArr.join("&"), function (jsonData) {
        var webData = new WebData(jsonData);
        alert(jsonData.msg);
        if (!webData.isError()) {
            $("tr.favorite input:checked").closest("tr").remove();
            $("tr.spectrum input:checked").closest("tr").remove();
        }
        ;
    }, "json");
}

/**
 * 获取当前显示的收藏夹ID
 */
function getCurFavoriteID() {
    console.log(favoriteIDList);
    if (favoriteIDList.length == 0) {
        return null;
    } else {
        return favoriteIDList[favoriteIDList.length - 1];
    }
}

function getCurPath() {
    return favoriteNameList.join(FILE_SEPARATOR);
}

/**
 * 判断是否有选中项
 */
function hasChecked() {
    if ($(".favoriteTable tbody input:checked").length > 0) {
        return true;
    } else {
        return false;
    }
}

/**
 * 根据favoriteIDList、favoriteNameList构造路径，用于进入某一收藏夹
 */
function addPath() {
    var length = $("#path li:gt(1)").removeClass("active").length;
    if (length == favoriteIDList.length - 1) {
        var favoriteID = favoriteIDList[length]; //新加入的收藏夹ID
        var favoriteName = favoriteNameList[length]; //新加入的收藏夹名称
        $("#path").append("<li class='active favorite' data-favoriteID='" + favoriteID + "'><a href='javascript:void(0)'>" + favoriteName + "</a></li>");
    }
}

/**
 * 根据favoriteIDList、favoriteNameList构造路径，用于返回某一收藏夹
 */
function removePath() {
    console.log(favoriteIDList);
    if (favoriteIDList.length < 0) {
        $("#path li:eq(2)").remove();
    } else {
        $("#path li:gt(" + (favoriteIDList.length + 1) + ")").remove();
    }
}



/**
 * 创建收藏夹
 */
function createFavorite(event) {

    /* 获取参数 */
    var parentID = getCurFavoriteID();
    var favoriteName = $("#favorite input[name=favoriteName]").prop("value").trim();  //去除首端和尾段的空格
    if (!checkFavoriteName(favoriteName)) {
        alert("收藏夹名称不符合要求:长度在1~16个字符之间,不能包含 \\ / : * ? \" < > | $");
        return false;
    }
    if (isRepeatOnFavorite(favoriteName)) {
        alert("收藏夹名称重复");
        return false;
    }

    /* 构造参数 */
    var paramArr = [];
    paramArr.push("async=1");
    if (parentID) {
        paramArr.push("favorite.parentID=" + parentID);
        paramArr.push("favorite.path=" + getCurPath() + FILE_SEPARATOR + favoriteName);
    } else {
        paramArr.push("favorite.path=" + favoriteName);
    }
    paramArr.push("favorite.favoriteName=" + favoriteName);

    var url = "user/createFavorite";
    /* 发送ajax请求 */
    $.post(url, paramArr.join("&"), function (jsonData) {
        var webData = new WebData(jsonData);
        if (webData.isError()) {
            alert(jsonData.msg);
            return;
        }
        /* 插入数据 */
        var favorite = jsonData.data;
        $(".favoriteTable tbody").prepend(getFavoriteItem(favorite));

        onFavoriteEvent();
    }, "json");
    newFileOver();
}

function getSpectrumItem(spectrum) {
    return "<tr class='spectrum' data-speID=" + spectrum.speID + " style='cursor:pointer'>\
                <td><input type='checkbox' class='cbr' name='speID' value='" + spectrum.speID + "'></td>\
                <td class='speName'><i class='fa-file-text'></i><a>&nbsp;&nbsp;" + spectrum.speName + "</a></td>\
                <td class='spectrumTool'>\
                    <ul class='album-options list-unstyled list-inline' style='display: none'>\
                        <li>\
                            <a class='look' href='#'>\
                                <i class='fa-edit'></i>信息\
                            </a>\
                        </li>\
                        <li>\
                            <a class='open' href='#'>\
                                <i class='fa-edit'></i>使用\
                            </a>\
                        </li>\
                        <li>\
                            <a class='deleteSpectrum' href='#'>\
                                <i class='fa-trash'></i>删除\
                            </a>\
                        </li>\
                    </ul>\
                </td>\
                <td>" + spectrum.saveTime + "</td>\
            </tr>";
}

function getFavoriteItem(favorite, favoriteName, favoriteCreateTime) {
    if (!favorite) { //null或者undefined
        return "";
    }
    if (typeof favorite == "object") {
        return "<tr class='favorite' data-favoriteId='" + favorite.favoriteID + "' style='cursor:pointer'>\
                    <td><input type='checkbox' class='cbr' name='favoriteID' value='" + favorite.favoriteID + "'></td>\
                    <td class='favoriteName' data-favoriteID='" + favorite.favoriteID + "'><i class='fa-folder-o'></i><a>&nbsp;&nbsp;" + favorite.favoriteName + "</a></td>\
                    <td class='favoriteTool'>\
                        <ul class='album-options list-unstyled list-inline hover' style='display:none'>\
                            <li>\
                                <a class='rename' href='#'> \
                                    <i class='fa-edit'></i>重命名\
                                </a>\
                            </li>\
                            <li>\
                                <a class='deleteFavorite' href='#'>\
                                    <i class='fa-trash'></i>删除\
                                </a>\
                            </li>\
                        </ul>\
                    </td>\
                    <td>" + favorite.createTime + "</td>\
                </tr>";
    } else {
        var favoriteID = favorite;
        return "<tr class='favorite' data-favoriteId='" + favoriteID + "' style='cursor:pointer'>\
                    <td><input type='checkbox' class='cbr' name='favoriteID' value='" + favoriteID + "'></td>\
                    <td class='favoriteName' data-favoriteID='" + favoriteID + "'><i class='fa-folder-o'></i><a>&nbsp;&nbsp;" + favoriteName + "</a></td>\
                    <td class='favoriteTool'>\
                        <ul class='album-options list-unstyled list-inline hover' style='display:none'>\
                            <li>\
                                <a class='rename' href='#'> \
                                    <i class='fa-edit'></i>重命名\
                                </a>\
                            </li>\
                            <li>\
                                <a class='deleteFavorite' href='#'>\
                                    <i class='fa-trash'></i>删除\
                                </a>\
                            </li>\
                        </ul>\
                    </td>\
                    <td>" + favoriteCreateTime + "</td>\
                </tr>"
    }
}

function checkFavoriteName(favoriteName) {
    if (!favoriteName) { //非空
        return false;
    }
    /* 长度验证 */
    if (favoriteName.length < 1 || favoriteName.length > 16) {
        return false;
    }
    /* 特殊字符验证 */
    var regExp = /[\\/:*?"<>|$]/;
    if (regExp.test(favoriteName)) {
        return false;
    }
    return true;
}

/**
 * 前端验证收藏夹名称是否重名
 */
function isRepeatOnFavorite(favoriteName) {
    var isRepeat = false;
    $(".favoriteName").each(function (index, item) {
        if ($(item).find("a").text().trim() == favoriteName) {
            isRepeat = true;
            return;
        }
    });
    return isRepeat;
}

/**
 * 前端验证光谱名称是否重名
 */
function isRepeatOnSpectrum(spectrumName) {
    var isRepeat = false;
    $(".spectrum .speName>a").each(function (index, item) {
        if ($(item).text().trim() == spectrumName) {
            isRepeat = true;
            return;
        }
    });
    return isRepeat;
}

/**
 * 移除收藏夹
 */
function removeFavorite() {
    document.querySelector(".favoriteTable tbody").innerHTML = "";
}

/**
 * 禁用超链接
 */
function disableLink($link) {
    console.log("disable " + $link);
    $link.removeAttr("href");
    $link.attr("disables", true);
}

/**
 * 启用超链接
 */
function enableLink($link) {
    console.log("enable " + $link);
    $link.attr("disables", false);
}

/**
 * 判断$link是否被禁用
 */
function isDisable($link) {
    return $link.attr("disables");
}
