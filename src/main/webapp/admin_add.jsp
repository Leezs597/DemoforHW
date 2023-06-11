<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="common/common.jsp" %>
    <style>
        .content{
            margin-left: 210px;
        }
        .my-form{
            width: 400px;
        }
    </style>
</head>
<body>
<%--静态引入--%>
<%@include file="common/top.jsp" %>
<%@include file="common/left-nav.jsp" %>
    <div class="content">
        <jsp:include page="common/page_title.jsp">
            <jsp:param name="title" value="管理员新增"/>
        </jsp:include>
        <div class="layui-form my-form">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="pwd" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-btn" lay-submit lay-filter="submitSave">保存</div>
            </div>
        </div>
    </div>
</body>
<script>
    $(document).ready(()=>{
        const form = layui.form;
        form.on('submit(submitSave)',(data)=>{
            // data.field;
            $.ajax({
                url:"http://localhost:8080/ssmtest1/admin/add",
                // 传的参数,解构
                data:JSON.stringify(data.field),
                type:"post",
                dataType:"json",
                headers : {'Content-Type' : 'application/json;charset=utf-8'}, //接口json格式
                success: function (res){
                    if (res.code == 0){
                        layer.msg('新增成功', {icon: 1});
                        setTimeout(()=>{
                            window.location.href = 'http://localhost:8080/ssmtest1/admin_manager.jsp'
                        },1000)
                    }else{
                        layer.msg(res.message);
                    }
                },
                error:function (err){

                }
            })
        })
    })
</script>
</html>
