var seckill={
 url:{
    getExposeUrl:function(seckillId){
        return "http://127.0.0.1:8080/seckill/"+seckillId+"/exposeurl";
    }
    ,
    getSeckillUrl:function(seckillId,md5){
        return "http://127.0.0.1:8080/seckill/"+seckillId+"/"+md5+"/execute";
    },
    getTimeUrl:function(){
      return "http://127.0.0.1:8080/seckill/date";
    }

 },

 executeSeckill:function (id){
     var seckillcookie=$.cookie("seckill");
     //不存在cookie 弹出登陆手机
     if(!seckillcookie){
         $("#login").modal('show');
     }else{
          console.info("cookie 存在");
          //存在cookie 检查事假
          $.ajax({
            type: 'POST',
            url: seckill.url.getExposeUrl(id),

            success: function(data){
               //数据成功返回
               console.info("data"+data["data"]["md5"]);
               if(data["success"]){
                  var result=data["data"];
                  var expose=result["expose"];
                  var starttime=result["startTime"];
                  var endtime=result["endTime"];
                  var md5=result["md5"];

                  console.info("expose"+ expose);
                  if(expose){
                    console.info("在秒杀中");
                    //md5 是什么时候获取呢
                    $("#btn_sekill").one('click',function() {
                        alert("点滴了");
                    })
                  }else{
                     console.info(("秒杀结束或未开启"));
                     //判断是未开启还是结束
                     var timedata=seckill.getCurrentTime();
                     console.info("timedata"+timedata);
                     if(timedata<starttime){
                          $("#btn_sekill").html("秒杀未开启");
                            $("#span_time"). countdown(starttime,function(event){
                                              $("#span_time").html(event.strftime(' %D天 %H小时 %M分%S秒'))
                                             }).on('finish.countdown',function(){
                                                     window.location.reload();
                                                });
                     }else {
                       $("#btn_sekill").html("秒杀已经结束");
                     }
                       $("#btn_sekill").addClass("disabled");
                  }
                  console.info("result"+result["startTime"]);
               }else{
                  alert("请检查网络状态");
                   $("#btn_sekill").model();
               }
            }
          });
     }

 },
 computeTime:function(){

 },
 //正在的秒杀
 seckillProduct:function(){

 },
 getCurrentTime:function (){
   var time;
   $.ajax({
   	type : "get",
   	url : seckill.url.getTimeUrl(),
   	async : false,//取消异步
   	success : function(data){
       time=data["data"];
   	}
   });

   return time;
 },
 commitPhone:function(){
   console.info("验证手机号");
   var killphone=$("#seckillphone").val();
   var isvalidate=seckill.validatePhone(killphone);
   //手机账号
   if(!isvalidate){
   console.info("手机号错误");
     $("#phonetip").html("手机号错误");

   }else{
        $("#phonetip").html("手机号正确");
        $.cookie("seckill", $("#seckillphone").val(),{expires:10,path:"/seckill"});
        $("#login").modal('hide');

   }
 },
 //验证手机
 validatePhone:function(phone){
       console.info("手机号是否正确");
       var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
      if (phone == ""||phone.length!=11||!mobile.test(phone))  return false;
      return true;
 }
 };

