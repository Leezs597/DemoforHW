<%--
  Created by IntelliJ IDEA.
  User: haowei
  Date: 2023/3/1
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sys-left-menu">
    <ul class="layui-nav layui-nav-tree" id="leftMenu" lay-filter="leftNav">
        <li class="layui-nav-item w-text">
            <a class="w-text">账号管理</a>
            <dl class="layui-nav-child">
                <dd lay-options="{id: 1,url: 'admin_manager.jsp'}" class="w-text w-hover">
                    <a href="<%=GlobalValue.PROJECT_PATH%>admin_manager.jsp">管理员账号管理</a>
                </dd>
                <dd lay-options="{id: 2}" class="w-text w-hover">
                    <a href="<%=GlobalValue.PROJECT_PATH%>admin_add.jsp">管理员账号添加</a>
                </dd>
                <dd lay-options="{id: 3}" class="w-text w-hover">
                    <a>密码修改</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item w-text">
            <a class="w-text">
                用户管理
            </a>
            <dl class="layui-nav-child">
                <dd lay-options="{id: 4,url: 'user_manager.jsp'}" class="w-text w-hover">
                    <a href="<%=GlobalValue.PROJECT_PATH%>user_manager.jsp">注册用户管理</a>
                </dd>
                <dd lay-options="{id: 5}" class="w-text w-hover">
                    <a href="<%=GlobalValue.PROJECT_PATH%>user_add.jsp">添加新用户</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item w-text">
            <a class="w-text">
                教室管理
            </a>
            <dl class="layui-nav-child">
                <dd lay-options="{id: 6}" class="w-text w-hover">
                    <a>分类添加</a>
                </dd>
                <dd lay-options="{id: 7}" class="w-text w-hover">
                    <a>分类查询</a>
                </dd>
                <dd lay-options="{id: 8}" class="w-text w-hover">
                    <a>教室添加</a>
                </dd>
                <dd lay-options="{id: 9}" class="w-text w-hover">
                    <a>教室查询</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item w-text">
            <a class="w-text">
                预约管理
            </a>
            <dl class="layui-nav-child">
                <dd lay-options="{id: 10}" class="w-text w-hover">
                    <a>预约查询</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item w-text" >
            <a class="w-text">
                审核管理
            </a>
            <dl class="layui-nav-child">
                <dd lay-options="{id: 11}" class="w-text w-hover">
                    <a>审核查询</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item w-text" >
            <a class="w-text">
                完成管理
            </a>
            <dl class="layui-nav-child">
                <dd lay-options="{id: 11}" class="w-text w-hover">
                    <a>使用记录</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item w-text" >
            <a class="w-text">
                取消管理
            </a>
            <dl class="layui-nav-child">
                <dd lay-options="{id: 11}" class="w-text w-hover">
                    <a>取消查询</a>
                </dd>
            </dl>
        </li>
    </ul>
</div>
<script type="text/javascript">
    layui.use('element', () => {
        const element = layui.element;
        element.on('nav(leftNav)', (data) => {
            console.log(data);
            if (data.context.getAttribute("data-url")){
                // console.log('nav(left-nav)',data.context.getAttribute("data-url"));
                <%--let href = '<%=GlobalValue.PROJECT_CONTEXT_PATH%>' + data.context.getAttribute("data-url");--%>
                // console.log(href)
                // window.location.href = href;
            }
        })
    })
</script>
