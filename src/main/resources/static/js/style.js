$(function(){
    /*登陆表单事件*/
    $('.username').on('focus',function(){
        $('.span_username').css("color","#337ab7");
    }).on('blur',function(){
        $('.span_username').css("color","#cccccc");
    });
     $('.password').on('focus',function(){
        $('.span_password').css("color","#337ab7");
    }).on('blur',function(){
         $('.span_password').css("color","#cccccc");
    });


})