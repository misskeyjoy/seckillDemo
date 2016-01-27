<%--
  Created by IntelliJ IDEA.
  User: misskey
  Date: 16-1-26
  Time: 下午11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/jstl.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀详情页</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link href="/css/style.css" rel='stylesheet' type='text/css'/>
    <link rel="stylesheet" href="/css/jquery.countdown.css"/>

</head>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/script/sckill.js"></script>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.js"/>
<script src="/script/jquery.cookie.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="application/javascript">
    $(document).ready(function(){
            console.info("进入");
            seckill.executeSeckill(${seckill.seckillId});
            })
</script>
<body>
<div class=" panel panel-warning center">
    <span class="spantitle">秒杀信息详情</span>
    <div class="title panel">
        <span class="btn btn-sm btn-danger">商品信息 </span>
        <span>${seckill.seckinfo}</span>
    </div>
    <button id="btn_sekill" class="spantitle circle  btn  btn-danger">秒杀吧</button>
    <span class="text-center"  id="span_time"></span>
</div>

</div>


<div id="login" class="login-box modal fade">
    <div class="login-title text-center">
        <h1>
            <small>输入手机号</small>
        </h1>
    </div>

    <div class="login-content ">
        <div class="form">
            <div class="form-group">
                <div class="col-xs-12  ">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                        <input type="text" id="seckillphone" name="username" class="form-control" placeholder="手机号">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-12 ">
                    <span id="phonetip">请输入手机号</span>
                </div>
            </div>
            <div class="form-group form-actions">
                <div class="col-xs-4 col-xs-offset-4 ">
                    <button class="btn btn-sm btn-info" id="phont_btn" onclick="seckill.commitPhone()"><span
                            class="glyphicon glyphicon-off"></span>
                        登录
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div>
    </div>
</div>

</body>

</html>
