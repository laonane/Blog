<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${ctx }/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx }/css/amazeui.min.css"/>
    <script src="${ctx }/js/jquery.min.js"></script>
</head>
<body>

<s:debug/>

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加文章
        </strong><small></small></div>
    </div>
    <hr>
    <form id="blog_form" action="#" method=post>
        <div class="edit_content">
            <div class="item1">
                <div>
                    <span>文章标题：</span>
                    <input type="text" class="am-form-field" name="article_title" style="width: 300px">&nbsp;&nbsp;
                </div>
            </div>

            <input type="text" name="article_desc" id="article_desc" style="display: none;">


            <div class="item1">
                <span>所属分类：</span>
                <select id="category_select" name="bclass.cid" style="width: 150px">&nbsp;&nbsp;
                    　
                </select>

                <select id="skill_select" name="skill.sid" style="width: 150px">&nbsp;&nbsp;
                </select>

            </div>

            <div class="item1 update_pic">
                <span>摘要图片：</span>
                <img src="" id="imageview" class="item1_img" style="display: none;">
                <label for="fileupload" id="label_file">上传文件</label>
                <input type="file" name="upload" id="fileupload"/>
            </div>

            <div id="editor" name="article_content" style="width:900px;height:400px;"></div>
            <button class="am-btn am-btn-default" type="button" id="send" style="margin-top: 10px;">
                发布
            </button>
        </div>

    </form>

</div>

<script type="text/javascript">

    $(function () {

        // 发送请求获取分类的数据
        $.post("${pageContext.request.contextPath}/article_getCategory.action", {"parentId": 0}, function (data) {
            console.log(data);
            // 遍历数组 data
            $(data).each(function (i, obj) {
                // console.log(obj.cname);
                $('#category_select').append('<option value=' + obj.cid + '>' + obj.cname + '</option>')
            });
            // 触发 change 事件
            $('#category_select').trigger("change");
        }, "json");

        /**
         * 监听 change 事件
         */
        $('#category_select').on('change', function (data) {
            // 获取 分类 id
            var cid = $('#category_select').val();
            // 发送请求获取分类的数据
            $.post("${pageContext.request.contextPath}/article_getCategory.action", {"parentId": cid}, function (data) {
                // console.log(data);
                $('#skill_select').empty();
                // 遍历数组 data
                $(data).each(function (i, obj) {
                    // console.log(obj.cname);
                    $('#skill_select').append('<option value=' + obj.cid + '>' + obj.cname + '</option>')
                });
            }, "json");
        })

        /**
         * 原理是把本地图片路径："D(盘符):/image/..."转为"http://..."格式路径来进行显示图片
         */
        $("#fileupload").change(function () {
            var $file = $(this);
            var objUrl = $file[0].files[0];
            //获得一个http格式的url路径:mozilla(firefox)||webkit or chrome
            var windowURL = window.URL || window.webkitURL;
            //createObjectURL创建一个指向该参数对象(图片)的URL
            var dataURL;
            dataURL = windowURL.createObjectURL(objUrl);
            $("#imageview").attr("src", dataURL);
            console.log($('#imageview').attr('style'));
            if ($('#imageview').attr('style') === 'display: none;') {
                $('#imageview').attr('style', 'inline');
                $('#imageview').width("300px");
                $('#imageview').height("200px");
                $('.update_pic').attr('style', 'margin-bottom: 80px;');
            }
        });
    });

</script>

</body>
</html>