<%--
  Created by IntelliJ IDEA.
  User: 李志帅
  Date: 2023/6/10
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <%@include file="common/common.jsp" %>
    <style>
        .content{
            margin-left: 210px;
        }
    </style>
</head>
<body>
<%--静态引入--%>
<%@include file="common/top.jsp" %>
<%@include file="common/left-nav.jsp" %>
<div class="content">
    <%--动态引入--%>
    <jsp:include page="common/page_title.jsp">
        <jsp:param name="title" value="用户列表"/>
    </jsp:include>
    <div style="display: flex">
        <input class="layui-input" style="width: 100px" id="keyword" placeholder="账号">
        <button class="layui-btn" id="check-bt"><i class="layui-icon layui-icon-search"></i>查询</button>
    </div>
    <table id="userTable">

    </table>
</div>
</body>
<script>
    const caozuoMoBan = `
        <div class="layui-btn-group">
            <button class="layui-btn layui-btn-sm layui-btn-warm" onclick="handleEdit({{d.id}})"><i class="layui-icon layui-icon-edit"></i></button>
            <button class="layui-btn layui-btn-sm layui-btn-danger" onclick="handleDelete({{d.id}})"><i class="layui-icon layui-icon-delete"></i></button>
        </div>
    `
    // 全局声明一个变量
    let tableIns;
    function handleDelete(id){
        // 确认提示
        layer.confirm('确认要删除吗?', {icon: 3, title:'提示'}, function(index){
            // 点击了确定的按钮执行操作
            console.log('删除提示：',index);
            $.ajax({
                url:"<%=GlobalValue.PROJECT_PATH%>yonghu/removeYonghu?id="+id,
                type:"get",
                success: function (res){
                    tableIns.reload();
                },
                error:function (err){
                    console.log(err);
                }
            })
            layer.close(index);
        });
    }

    // 处理编辑按钮点击事件
    function handleEdit(id){
        // layui iframe 弹窗
        layer.open({
            // 类型 iframe 弹窗
            type: 2,
            // 这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            content: ['<%=GlobalValue.PROJECT_PATH%>layer/user_edit.jsp?id='+id,'no'],
            // 区域 宽 高
            area: ['500px', '300px'],
            end:()=>{
                tableIns.reload();
            }
        });
    }

    layui.use('table',()=>{
        const table = layui.table;
        // 渲染的时候赋值
        tableIns = table.render({
            // 指定table元素
            elem: '#userTable',
            // 高度
            height:500,
            // 是否分页
            page:true,
            limits:[1,10,30],
            // 请求地址
            url:'<%=GlobalValue.PROJECT_PATH%>yonghu/getYonghuList',
            // 请求方式
            method:'post',
            // 内容类型
            contentType:'application/json',
            //表头 二维数组field表示属性名 title在表格里表头展示的名字
            cols:[[
                {field:'id',title:'ID'},
                {field:'yonghuming',title:'用户名'},
                {field:'mima',title:'密码'},
                {field:'xingming',title:'姓名'},
                {field:'xingbie',title:'性别'},
                {title:'操作',templet:caozuoMoBan},
            ]]
        })

        $('#check-bt').click(()=>{
            // 表格重载
            tableIns.reload({
                where:{
                    keyword:$('#keyword')[0].value
                }
            })
        })
    })
</script>
</html>
