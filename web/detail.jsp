<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<!-- 内容区 -->
<section class="layout main-wrap  content">
    <section class='col-main'>
        <p class="tips">温馨提示：为了您的体验更佳，请在PC端使用</p>
        <!--博客社区-->
        <article class="mainarea" style="display:block;">
            <div class="blog-tab">

                <div class="tab-content" >
                    <div role="tabpanel" style="margin-left: 100px;" class="tab-pane fade in active" id="home">

                        <div id="lk_blog_list" style="padding-left: 20px; width: 1000px" class="container">
                            <div class="row">
                                <ul class="blog-list" id="article_detail">
                                    <li>
                                        <div class="blog-list-left">
                                            <div class="main-title" id="ar_title">标题</div>
                                            <div style="color: #c2c2c2" id="ar_time">2019-1-1</div>
                                            <hr>
                                            <div id="ar_content">
                                                内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容
                                            </div>
                                        </div>
                                    </li>
                                </ul>
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

        <div class="footer-bottom col-sm-offset-2 hidden-sm hidden-xs">
            <ul>
                <li><a href="">学科报名</a></li>
                <li><a href="">师资团队</a></li>
                <li><a href="">线上公开课</a></li>
                <li><a href="">联络我们</a></li>
                <li><a href="">支持我们</a></li>
                <li><a href="">粤IPC备 123498768-1</a></li>
            </ul>
            <p>Copyright © 2018-2019 Angel Care All Rights Reserved. 老衲维基 版权所有</p>
        </div>
    </div>
</footer>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/template.js"></script>
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

    // 获取当前参数
    function getParams(key) {
        var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }

    var id = getParams('id');
    $.post("${pageContext.request.contextPath}/web_getArticleDetail.action", {"articleId": id}, function (data) {

        $('#ar_title').html(data.articleTitle);
        $('#ar_time').html(new Date(data.articleTime).toLocaleDateString());
        $('#ar_content').html(data.articleContext);
    }, "json");
</script>