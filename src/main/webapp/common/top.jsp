<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sys-header">
    <div class="header-left">
        图书馆位置预约管理系统
    </div>
    <div class="sys-header-right">
        <div class="userinfo">
            <div id="user-box"></div>
        </div>
        <div class="logout-bt">
            <button class="layui-btn" onclick="logout()" id="logout-bt">退出</button>
        </div>
    </div>
</div>
<script>
    // 等待页面dom都加载完成
    $(document).ready(()=>{
        // 获取本地存储
        let item = localStorage.getItem('user');
        // 如果没有，就跳转登录
        if(!item){
            window.location.href = '<%=GlobalValue.PROJECT_PATH%>login.jsp'
            return;
        }
        const dataInfo = JSON.parse(item);
        console.log(dataInfo.username);
        document.getElementById("user-box").innerHTML = '欢迎【'+dataInfo.username+"】，身份：【管理员】";
        // 退出功能
        <%--$("#logout-bt").click(()=>{--%>
        <%--    localStorage.removeItem('user')--%>
        <%--    window.location.href = '<%=GlobalValue.PROJECT_PATH%>login.jsp'--%>
        <%--})--%>
    })
    // 退出功能
    function logout(){
        localStorage.removeItem('user')
        window.location.href = '<%=GlobalValue.PROJECT_PATH%>login.jsp'
    }
</script>