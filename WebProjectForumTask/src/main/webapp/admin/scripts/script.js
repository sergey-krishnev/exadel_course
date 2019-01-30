$(document).ready(function () {
    var pathname = window.location.pathname;
    pathname = pathname.replace("/admin/","");
    var Pathname = pathname.charAt(0).toUpperCase() + pathname.slice(1);
    var idNav = "#" + pathname + "NavItem";
    $(idNav).addClass("active");
    $(".Pathname").text(Pathname);
});