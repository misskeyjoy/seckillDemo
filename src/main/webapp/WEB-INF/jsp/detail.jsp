<%@ page import="com.sohu.tv.cn.enity.Seckill" %><%--
  Created by IntelliJ IDEA.
  User: misskey
  Date: 16-1-26
  Time: 下午11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/jstl.jsp" %>
<html>
<head>
    <title>秒杀详情页</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">


</head>
<style>
    .center {
        width: 60%;
        height: 80%;
        display: table;
        margin-left: auto;
        margin-right: auto;
        background: moccasin;
    }

    .title {
        width: 60%;
        height: 80%;
        padding-top: 8px;
        display: table;
        margin-left: auto;
        margin-right: auto;
        background: moccasin;
    }

    .spantitle {
        width: 100%;
        height: 8%;
        padding-top: 8px;
        display: table;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
        background: #9BCD9B;
    }

    .spancenter {
        display: table;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
    }

    .box {
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
        background-image: linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
        background-image: -o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
        background-image: -moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
        background-image: -webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
        background-image: -ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);

        margin: 0 auto;
        position: relative;
        width: 100%;
        height: 100%;
    }

    .login-box {
        width: 100%;
        max-width: 500px;
        height: 400px;
        position: absolute;
        top: 20%;
        margin-top: -110px;
        /*设置负值，为要定位子盒子的一半高度*/

    }

    @media screen and (min-width: 500px) {
        .login-box {
            left: 50%;
            /*设置负值，为要定位子盒子的一半宽度*/
            margin-left: -250px;
        }
    }

    .form {
        width: 100%;
        max-width: 500px;
        height: 250px;
        margin: 25px auto 0px auto;
        padding-top: 25px;
    }

    .login-content {
        height: 200px;
        width: 100%;
        max-width: 500px;
        background-color: rgba(255, 250, 2550, .6);
        float: left;
    }

    .input-group {
        margin: 0px 0px 30px 0px !important;
    }

    .form-control,
    .input-group {
        height: 40px;
    }

    .form-group {
        margin-bottom: 0px !important;
    }

    .login-title {
        padding: 20px 10px;
        background-color: rgba(0, 0, 0, .6);
    }

    .login-title h1 {
        margin-top: 10px !important;
    }

    .login-title small {
        color: #fff;
    }

    .link p {
        line-height: 20px;
        margin-top: 30px;
    }

    .btn-sm {
        padding: 8px 24px !important;
        font-size: 16px !important;
    }

</style>
<body>
<div class=" panel panel-warning center">
    <span class="spantitle">秒杀信息详情</span>
    <div class="title">
        <span class="btn btn-sm btn-danger">商品信息 </span>
        <span>${seckill.seckinfo}</span>
    </div>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="/script/sckill.js"></script>
<script src="http:/cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

<script type="application/javascript">
    $(document).ready(function(){
            console.info("进入");
            seckill.executeSeckill();
            })
</script>


<div id="login" class="login-box modal fade">
    <div class="login-title text-center">
        <h1>
            <small>登录</small>
        </h1>
    </div>
    <div class="login-content ">
        <div class="form">
            <form action="#" method="post">
                <div class="form-group">
                    <div class="col-xs-12  ">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" id="username" name="username" class="form-control" placeholder="手机号">
                        </div>
                    </div>
                </div>
                <div class="form-group form-actions">
                    <div class="col-xs-4 col-xs-offset-4 ">
                        <button type="submit" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span>
                            登录
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>

</html>
