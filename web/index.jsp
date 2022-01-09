<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>老衲维基(blog.laona.wiki)</title>
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

                <div class="tab-content" id="tab_content">
                <%--
                    <div role="tabpanel" class="tab-pane fade in active" id="tab">
                        &lt;%&ndash;分类信息&ndash;%&gt;
                        <div id="lk_blog_two" class="container">
                            <div class="row">
                                <button class="btn-tag">Mysql</button>
                                <button class="btn-tag">面向对象</button>
                                <button class="btn-tag">jdbc</button>
                                <button class="btn-tag">web服务器</button>
                            </div>
                        </div>
                    </div>
                --%>
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
                <a href="detail.jsp?id={{article.articleId}}">{{article.articleTitle}}</a>
            </div>
            <p class="sub-title">{{article.articleDesc}}</p>
            <div class="meta">
                {{article.articleTime | dateFormat:'yyyy-MM-dd'}}
            </div>
        </div>
        <img src='${pageContext.request.contextPath}/upload/{{article.articlePic}}' alt="" class="img-rounded">
    </li>
    {{/each}}
</script>

<script id="tab_content_template" type="text/html">
    <div role="tabpanel" class="tab-pane fade in active" id="tab">
        分类信息
        <div id="lk_blog_two" class="container">
            <div class="row">
                {{each list as tab}}
                <button class="btn-tag category_btn" data-cid="{{tab.cid}}">{{tab.cname}}</button>
                {{/each}}
                <%--
                <button class="btn-tag">面向对象</button>
                <button class="btn-tag">jdbc</button>
                <button class="btn-tag">web服务器</button>--%>
            </div>
        </div>
    </div>
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

    // 获取当前参数
    function getParams(key) {
        var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }

    // 获取 url 的参数
    var parentId = getParams("parentId");
    // 根据 parentId 加载子集
    if (parentId != null) {
        // 发送请求获取分类的数据
        $.post("${pageContext.request.contextPath}/article_getCategory.action", {"parentId": parentId}, function (data) {
            // 遍历数组 data
            /*
                0: {cid: 4, cname: "MySQL", parentid: 1}
                1: {cid: 5, cname: "web服务器", parentid: 1}
                2: {cid: 16, cname: "SSH", parentid: 1}
                3: {cid: 17, cname: "SSM", parentid: 1}
            */
            // console.log("发送请求获取分类的数据", data);
            var html = template('tab_content_template', {list: data});
            // document.getElementById('content').innerHTML = html;
            $('#tab_content').html(html);

            // 加载子集数据
            getPageList(1, parentId, null);

        }, "json");
    } else {
        // 加载列表分页数据
        // console.log("加载列表分页数据");
        getPageList(1, null, null);
    }

    // 这是在顺序执行的时候是直接略过的，需要使用动态代理
    $('body').on("click", ".category_btn", function () {
        var cid = $(this).data('cid');
        getPageList(1, null, cid);
    })

    /**
     * 获取分页数据
     * @param currPage
     * @param parentId
     */
    function getPageList(currPage, parentId, cid) {
        $.post('${pageContext.request.contextPath}/web_getPageList.action', {
            currPage: currPage,
            parentId: parentId,
            cid: cid
        }, function (data) {
            // console.log(data);
            var html = template('article_content', {list: data.list});
            // document.getElementById('content').innerHTML = html;
            $('#content').html(html);

            //分页
            $(".page_div").paging({
                pageNo: data.currentPage,
                totalPage: data.totalPage,
                totalSize: data.totalCount,
                callback: function (num, parentId) {
                    getPageList(num, parentId, cid);
                }
            });
        }, 'json');
    }
</script>