var seckill={
 url:{

 },
 executeSeckill:function (){
     var seckillcookie=$.cookie("seckill");
     //不存在cookie 弹出登陆手机
     console.info("验证手机号");
     if(!seckillcookie){
         $("#login").modal('show');
     }


 }
 }

