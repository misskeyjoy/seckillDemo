<%--
  Created by IntelliJ IDEA.
  User: misskey
  Date: 16-1-26
  Time: 下午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/jstl.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>秒杀列表</title>
    <!-- Bootstrap -->
    <link href="http://css/bootstrap.min.css" rel="stylesheet">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/css/bootstrap.css">
</head>
<script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/js/bootstrap.js"></script>
<style>

</style>
<body>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<div class="container ">
    <div class="row">
        <table class="table table-striped ">
            <thead class="bg-success">
            <tr>
                <th class="text-center ">编号</th>
                <th class="text-center ">商品数量</th>
                <th class="text-center ">卖家</th>
                <th class="text-center ">起始时间</th>
                <th class="text-center ">结束时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="seckill" items="${seckills}">

                <tr>
                    <td class="text-center">${seckill.seckillId}</td>
                    <td class="text-center">${seckill.secknum}</td>
                    <td class="text-center">${seckill.seckseller}</td>
                    <td class="text-center">
                        <fmt:formatDate value="${seckill.startTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td class="text-center">
                        <fmt:formatDate value="${seckill.endTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td>
                        <a class=" text-center btn btn-sm btn-danger "  href="/seckill/${seckill.seckillId}/detail">详细页面</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

</div>
</body>
</html>
