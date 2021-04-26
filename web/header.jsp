<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>老衲的大清(blog.laona.wiki)</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/lkblog.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/blog_con.css">
    <link rel="stylesheet" href="${ctx }/css/pageStyle.css">
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/paging.js"></script>
</head>

<body>
<div id="top_bar" class="container hidden-xs hidden-sm">
    <div class="row">
        <div class="col-md-offset-1 col-md-7">
            <ul class="top-bar-left">
                <li style="margin-right: 20px;">
                    <a href="#" target="_blank">
                        <span class="icon-tel"></span>
                        欢迎来到：老衲的大清
                    </a>
                </li>
                <li>
                    <a href="http://blog.laona.wiki" target="_blank">
                        <span class="icon-email" style="color: brown;"></span>
                        blog.laona.wiki
                    </a>
                </li>
            </ul>
        </div>
        <div class="col-md-offset-3">
            <span class="top-bar-right pull-right">喜欢编程, 就来<span style="color: red">老衲的大清</span> (blog.<span
                    style="color: red">laona</span>.wiki)</span>
        </div>
    </div>
</div>
<!--导航-->
<nav class="navbar navbar-default navbar-lk">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <a class="navbar-brand" href="index.jsp" style="justify-content: space-around">
                <img src="${pageContext.request.contextPath}/images/laonadedaqing.png" alt="Logo" width="220px">
            </a>

            <ul class="nav navbar-nav" id="nav" style="font-size: 20px">
                <li class="active"><a href="index.jsp">博客首页</a></li>
                <%--                <li class="active"><a href="index.jsp">Java</a></li>--%>
                <%--                <li class="active"><a href="index.jsp">Python</a></li>--%>
                <%--                <li class="active"><a href="index.jsp">Web前端</a></li>--%>
            </ul>
            <a href="${ctx}/mgr_login.jsp" style="line-height:95px; height: 95px;font-size: 18px; color: #0a628f">
                发布文章
            </a>
        </div>
    </div>
</nav>
<!--banner-->
<section id="lk_blog_one">
    <img src="${pageContext.request.contextPath}/images/about_java.png" alt="" class="one-img" width="280px">
    <div class="one-right">
        <h1>技术专栏</h1>
        <span>喜欢编程,就来老衲的大清吧!</span>
        <div style="position: relative;" class="one-bottom">
            <button>关注我们</button>
            <img src="${pageContext.request.contextPath}/images/ewm2.png" alt="" width="100px" class="one-ewm">
        </div>
    </div>
</section>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">

    $(function () {

        // 发送请求获取分类的数据
        $.post("${pageContext.request.contextPath}/article_getCategory.action", {"parentId": 0}, function (data) {
            // 遍历数组 data
            $(data).each(function (i, obj) {
                // console.log(obj.cname);
                // console.log(obj);
                $('.nav').append("<li class='active'><a href='index.jsp?parentId=" + obj.cid + "'>" + obj.cname + "</a></li>");
            });
        }, "json");
    });

</script>
