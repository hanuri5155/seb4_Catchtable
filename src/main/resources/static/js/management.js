$(".button-collapse").sideNav();

$(".collapsible").collapsible();

$("select").material_select();

$(document).ready(function() {
    if ($("#successMessage").length) {
        alert("등록이 완료 되었습니다");
    }
});