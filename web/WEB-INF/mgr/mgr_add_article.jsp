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
    <script type="text/javascript" charset="utf-8" src="${ctx }/js/umedit/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx }/js/umedit/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx }/js/umedit/lang/zh-cn/zh-cn.js"></script>
</head>
<body>

<s:debug/>

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加文章
        </strong><small></small></div>
    </div>
    <hr>
    <form id="blog_form" action="${ctx}/article_add.action" method="post" enctype="multipart/form-data">
        <div class="edit_content">
            <div class="item1">
                <div>
                    <span>文章标题：</span>
                    <input type="text" class="am-form-field" name="articleTitle" style="width: 300px">&nbsp;&nbsp;
                </div>
            </div>

            <input type="text" name="articleDesc" id="article_desc" style="display: none;">


            <div class="item1">
                <span>所属分类：</span>
                <select id="category_select" name="categoryParentId" style="width: 150px">&nbsp;&nbsp;
                    　
                </select>

                <select id="skill_select" name="categoryCid" style="width: 150px">&nbsp;&nbsp;
                </select>

            </div>

            <div class="item1 update_pic">
                <span>摘要图片：</span>
                <img src="" id="imageview" class="item1_img" style="display: none;">
                <label for="fileupload" id="label_file">上传文件</label>
                <input type="file" name="upload" id="fileupload"/>
            </div>

            <div id="editor" name="articleContent" style="width:900px;height:400px;"></div>
            <button class="am-btn am-btn-default" type="button" id="send" style="margin-top: 10px;">
                发布
            </button>
        </div>

    </form>

</div>

<script type="text/javascript">

    $(function () {

        /**
         * 初始化富文本编辑器
         * */
        var ue = UE.getEditor('editor');

        // 发送请求获取分类的数据
        $.post("${pageContext.request.contextPath}/article_getCategory.action", {"parentId": 0}, function (data) {
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
            $.post("${pageContext.request.contextPath}/article_getCategory.action", {"parentId": cid }, function (data) {
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
                $('#imageview').height("180px");
                $('.update_pic').attr('style', 'margin-bottom: 150px;');
            }
        });

        $('#send').click(function () {
            // 设置文本描述
            // 获取富文本的正文
            var text = ue.getContentTxt();
            text = text.substring(0, 150) + "...";
            // 填充到描述信息中
            $('#article_desc').val(text);

            // 提交表单
            $('#blog_form').submit();
        });
    });

</script>

</body>
</html>