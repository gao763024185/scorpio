
 $("#nav ul li").click(function () {
     var _index = $(this).index();
     $(this).find('a').addClass('active1').parent().siblings('li').find('a').removeClass('active1');
     $('.listmenu').eq(_index).show().siblings('.libiao').hide();
     document.getElementById('defaultShow').display="true";
 });
