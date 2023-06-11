<%--
  Created by IntelliJ IDEA.
  User: 李志帅
  Date: 2023/6/11
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@include file="../common/common.jsp"%>
  <style>
    .admin-edit-form{
      display: flex;
      align-items: center;
      flex-direction: column;
    }
  </style>
</head>
<body>
<div>
  <div class="user-edit-form layui-form" lay-filter="editForm">
    <div class="layui-form-item">
      <label class="layui-form-label">用户名</label>
      <div class="layui-input-block">
        <input type="text" name="yonghuming" placeholder="请输入" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">密码</label>
      <div class="layui-input-block">
        <input type="text" name="mima" placeholder="请输入" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">姓名</label>
      <div class="layui-input-block">
        <input type="text" name="xingming" placeholder="请输入" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">性别</label>
      <div class="layui-input-block">
        <input type="text" name="xingbie" placeholder="请输入" autocomplete="off" class="layui-input">
      </div>
    </div>
    <button class="layui-btn" style="display: block; margin: 0 auto;" lay-submit lay-filter="editForm">保存</button>
  </div>
</div>
</body>
<script>
  function queryString(item){
    var svalue = location.search.match(new RegExp("[\?\&]" + item + "=([^\&]*)(\&?)","i"));
    return svalue ? svalue[1] : svalue;
  }
  let id = queryString("id");
  const form = layui.form;
  form.on('submit(editForm)',(data)=>{
    data.field.id = id;
    $.ajax({
      url:"http://localhost:8080/ssmtest1/yonghu/update",
      // 传的参数,解构
      data:JSON.stringify(data.field),
      type:"post",
      dataType:"json",
      headers : {'Content-Type' : 'application/json;charset=utf-8'}, //接口json格式
      success: function (res){
        // 关闭弹窗
        let frameIndex = parent.layer.getFrameIndex(window.name);
        parent.layer.close(frameIndex)
      },
      error:function (err){

      }
    })
    return false;
  })
  $(document).ready(()=>{
    // console.log('iframe 地址:',location.href)
    // console.log("id的值是：",queryString("id"))
    $.ajax({
      url:"<%=GlobalValue.PROJECT_PATH%>yonghu/getById?id="+id,
      type:"get",
      success: function (res){
        // console.log('根据id获取数据：',res);
        // res.data;
        // 设置表单回显
        form.val('editForm',{
          yonghuming:res.data.yonghuming,
          mima:res.data.mima,
          xingming:res.data.xingming,
          xingbie:res.data.xingbie
        })
      },
      error:function (err){
        console.log(err);
      }
    })
  })
</script>
</html>