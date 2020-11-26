<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pageStyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <style>
        #modal_content2 {
            padding: 30px 20px;
            width: 400px;
            height: 200px;
            background: white;
            position: fixed;
            left: 50%;
            top: 50%;
            margin-left: -200px;
            margin-top: -100px;
            display: none;
        }

        #close2 {
            position: absolute;
            right: 10px;
            top: 10px;
        }
    </style>
</head>
<body>


<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">分类管理</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 添加分类
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="goods_list" id="account_List">
    <ul class="title_ul">
        <li>父级序号</li>
        <li>分类名称</li>
        <li>修改分类</li>
        <li>删除分类</li>
    </ul>
    <s:iterator value="#categoryList" var="category">
        <ul class="list_goods_ul">
            <li><s:property value="#category.parentId"/></li>
            <li><s:property value="#category.cname"/></li>
            <li>
                <a href="#" class="edit_btn" data-id="<s:property value='#category.cid'/>">
                    <img class="img_icon" src="images/edit_icon.png" alt="">
                </a>
            </li>
            <li>
                <a href="#" class="delete_btn" data-id="<s:property value='#category.cid'/>" >
                    <img class="img_icon"src="images/delete_icon.png" alt="">
                </a>
            </li>
        </ul>
    </s:iterator>
    <s:debug/>
</div>

<div id="modal_view">


</div>

<div id="modal_content2" style="height: 250px; display: none">
    <div id="close2"><img src="images/delete_icon.png" alt=""></div>
    <div class="edit_content">
        <div class="item1">
            <div>
                <span>添加分类：</span>
            </div>
        </div>
        <div class="item1">
            <div>
                <span>parentid：</span>
                <input type="text" class="am-form-field" id="parentid2">&nbsp;&nbsp;
                <br/>
                <span>分类名称：</span>
                <input type="text" class="am-form-field" id="cname2">
                <br/>
                <input type="hidden" id="cid2">
                <button class="am-btn am-btn-default" type="button" id="updatebtn">修改</button>
            </div>
        </div>
    </div>
</div>

<div id="modal_content" style="height: 250px;">
    <div id="close"><img src="${pageContext.request.contextPath}/images/delete_icon.png" alt=""></div>
    <div class="edit_content">

        <div class="item1">
            <div>
                <span>添加分类：</span>
            </div>
        </div>
        <div class="item1">
            <div>
                <span>parentid：</span>
                <input type="text" class="am-form-field" id="parentId">&nbsp;&nbsp;
                <br/>
                <span>分类名称：</span>
                <input type="text" class="am-form-field" id="cname">&nbsp;&nbsp;
                <br/>
                <button class="am-btn am-btn-default" type="button" id="addcategory">添加</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        /**
         * 添加点击事件
         */
        $('#addcategory').click(function () {
            var parentId = $('#parentId').val();
            var cname = $('#cname').val();
            $(window).attr('location',
                '${pageContext.request.contextPath}/category_add.action?cname=' + cname + '&parentId=' + parentId);
        });

        $('#add').click(function () {
            $("#modal_view").fadeIn();
            $("#modal_content").fadeIn();
        });

        $("#close").click(function () {
            $("#modal_view").fadeOut();
            $("#modal_content").fadeOut();
        });

        /**
         * 监听修改按钮的点击事件
         */
        $('.edit_btn').click(function () {
            // 拿到记录 id
            var cid = $(this).data('id');
            $("#modal_view").fadeIn();
            $("#modal_content2").fadeIn();
            /**
             * ajax 查询数据记录（异步请求）
             */
            $.post('${pageContext.request.contextPath}/category_updateUI.action', {'cid': cid}, function (data) {
                /**
                 * 把 json 数据展示到文本框中
                 */
                $('#cname2').val(data[0].cname)
                $('#parentid2').val(data[0].parentId)
                $('#cid2').val(data[0].cid)
            }, 'json');
        });

        $('.delete_btn').click(function () {
            // 获取 cid
            var cid = $(this).data('id');
            $(window).attr('location',
                '${pageContext.request.contextPath}/category_delete.action?cid=' + cid);
        });

        $('#updatebtn').click(function () {
            var cname = $('#cname2').val();
            var parentId = $('#parentid2').val();
            var cid = $('#cid2').val();
            $(window).attr('location',
                '${pageContext.request.contextPath}/category_update.action?cid=' + cid + '&cname=' + cname + '&parentId=' + parentId);
        });

        $("#close2").click(function () {
            $("#modal_view").fadeOut();
            $("#modal_content2").fadeOut();
        });
    });
</script>
</body>
</html>