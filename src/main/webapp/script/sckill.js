var seckill={
 url:{
    getExposeUrl:function(seckillId){
        return "/seckill/"+seckillId+"/exposeurl";
    }
    ,
    getSeckillUrl:function(seckillId,md5){
        return "/seckill/"+seckillId+"/"+md5+"/execute";
    },
    getTimeUrl:function(){
      return "/seckill/date";
    }

 },
 //执行倒计时
 execurtecountdown:function(starttime){
     $("#span_time"). countdown(starttime,function(event){
                                      $("#span_time").html(event.strftime(' %D天 %H小时 %M分%S秒'))
                                              }).on('finish.countdown',function(){
                                                        window.location.reload();
                                                   });
 },
 //检查秒杀的数据
  executeCheckData:function(data,seckillid){
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
                           seckill.seckillProduct(seckillid,md5);
                      })
                    }else{
                       console.info(("秒杀结束或未开启"));
                       //判断是未开启还是结束
                       var timedata=seckill.getCurrentTime();
                       console.info("timedata"+timedata);
                       if(timedata<starttime){
                            $("#btn_sekill").html("秒杀未开启");
                            seckill.execurtecountdown(starttime);
                       }else {
                         $("#btn_sekill").html("秒杀已经结束");
                       }
                         $("#btn_sekill").addClass("disabled");
                    }
                    console.info("result"+result["startTime"]);
                 }else{
                    alert("请检查网络状态");
                     $("#btn_sekill").modal('hide');
                 }

  },
 //登陆检查
 executeLogin:function (id){
     var seckillcookie=$.cookie("seckill");
     //不存在cookie 弹出登陆手机
     if(!seckillcookie){
         $("#login").modal('show');
     }else{
          console.info("cookie 存在");
          //存在cookie
          $.ajax({
            type: 'POST',
            url: seckill.url.getExposeUrl(id),
            success: function(data){
              seckill.executeCheckData(data,id);
          }});
     }

 },
 //正在的秒杀
 seckillProduct:function(seckillId,md5){


    $.ajax({
      	type : "POST",
      	url : "/seckill/"+seckillId+"/"+md5+"/execute",

      	success : function(data){
      	   var success=data["success"];
      	   var error=data["error"];
      	   if(success){
      	      console.info("成功秒杀");
      	      $("#btn_sekill").html("秒杀成功");
      	      $("#btn_sekill").addClass("disabled");
      	   }else{
      	      console.info("秒杀失败"+error);
             $("#btn_sekill").html(error);
            if(error==="重复秒杀"){
      	           $("#btn_sekill").addClass("disabled");
      	      }
      	      else{
      	           console.info("进入该方法");

                   $("#btn_sekill").one("click",function(){
                      $("#btn_sekill").addClass("disabled");
                   });
      	      }
      	   }

      	}
      });
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

