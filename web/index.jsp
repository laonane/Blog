<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pageStyle.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/template.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/paging.js"></script>
</head>
<style>
    .content_item {
        height: 160px;
        position: relative;
    }

    .content_item img {
        position: absolute;
        right: 10px;
        top: 10px;
        width: 250px;
        height: 140px;
    }

</style>
<!-- 内容区 -->
<section class="layout main-wrap  content">
    <section class='col-main'>

        <article class="mainarea" style="display:block;">
            <div class="blog-tab">

                <div class="tab-content">
                    <%--<div role="tabpanel" class="tab-pane fade in active" id="tab">
                        &lt;%&ndash;分类信息&ndash;%&gt;
                        <div id="lk_blog_two" class="container">
                            <div class="row">
                                <button class="btn-tag">Mysql</button>
                                <button class="btn-tag">面向对象</button>
                                <button class="btn-tag">jdbc</button>
                                <button class="btn-tag">web服务器</button>
                            </div>
                        </div>
                    </div>--%>
                </div>
            </div>
        </article>
        <!--博客社区-->
        <article class="mainarea" style="display:block;">
            <div class="blog-tab">

                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active" id="home">

                        <div id="lk_blog_list" class="container">
                            <div class="row">
                                <ul class="blog-list" id="content">

                                </ul>
                                <div id="page" class="page_div"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
    </section>

</section>
<footer id="lk_footer">
    <div class="container">
        <div class="footer-top">
            <!--分页-->
        </div>
        <div class="footer-bottom col-sm-offset-2 hidden-sm hidden-xs">
            <ul>
                <li><a href="">学科报名</a></li>
                <li><a href="">师资团队</a></li>
                <li><a href="">线上公开课</a></li>
                <li><a href="">联络我们</a></li>
                <li><a href="">支持我们</a></li>
                <li><a href="">粤ICP备 12345678号-1</a></li>
            </ul>
        </div>
    </div>
</footer>
<%-- js 模板 --%>
<script id="article_content" type="text/html">
    {{each list as article}}
    <li class="content_item">
        <div class="blog-list-left" style="float: left;">
            <div class="main-title">
                <a href="detail.jsp">{{article.articleTitle}}</a>
            </div>
            <p class="sub-title">{{article.articleDesc}}</p>
            <div class="meta">
                {{article.articleTime | dateFormat:'yyyy-MM-dd'}}
            </div>
        </div>
        <img src="${pageContext.request.contextPath}/upload/{{article.articlePic}}" alt="" class="img-rounded">
    </li>
    {{/each}}
</script>

<script type="text/javascript">

    //时间戳转换
    template.helper('dateFormat', function (date, format) {

        date = new Date(date);

        var map = {
            "M": date.getMonth() + 1, //月份
            "d": date.getDate(), //日
            "h": date.getHours(), //小时
            "m": date.getMinutes(), //分
            "s": date.getSeconds(), //秒
            "q": Math.floor((date.getMonth() + 3) / 3), //季度
            "S": date.getMilliseconds() //毫秒
        };
        format = format.replace(/([yMdhmsqS])+/g, function (all, t) {
            var v = map[t];
            if (v !== undefined) {
                if (all.length > 1) {
                    v = '0' + v;
                    v = v.substr(v.length - 2);
                }
                return v;
            } else if (t === 'y') {
                return (date.getFullYear() + '').substr(4 - all.length);
            }
            return all;
        });
        return format;
    });


    /*    $(function () {
            $.post('${pageContext.request.contextPath}/web_getPageList.action', function (data) {
            console.log(data);
            var html = template('article_content', {list: data.list});
            // document.getElementById('content').innerHTML = html;
            $('#content').html(html);

            //分页
            $(".page_div").paging({
                pageNo: data.pageNo,
                totalPage: data.totalPage,
                totalSize: data.totalCount,
                callback: function (num) {
                    getPageList(num);
                }
            });
        }, 'json');
    });*/

    // 加载列表分页数据
    getPageList(1);

    function getPageList(currPage) {
        $.post('${pageContext.request.contextPath}/web_getPageList.action', {currPage: currPage}, function (data) {
            console.log(data);
            var html = template('article_content', {list: data.list});
            // document.getElementById('content').innerHTML = html;
            $('#content').html(html);

            //分页
            $(".page_div").paging({
                pageNo: data.currentPage,
                totalPage: data.totalPage,
                totalSize: data.totalCount,
                callback: function (num) {
                    getPageList(num);
                }
            });
        }, 'json');
    }
</script>

</body>
</html>