<%--
  Created by IntelliJ IDEA.
  User: haowei
  Date: 2023/4/1
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书馆位置预约系统</title>
    <script src="layui/layui/layui.js"></script>
    <link rel="stylesheet" href="layui/layui/css/layui.css">
    <style>
        .container{
            /*background: url("/ssmtest1/images/apple.png");*/
            width: 100%;
            height: 100vh;
        }
        .login-form{
            width: 260px;
            position: absolute;
            left: calc(50% - 130px);
            top: 120px;
            background: #ffffff;
            border-radius: 5px;
        }
        .login-form .title-box{
            background: #00f7de;
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
            color: #ffffff;
            height: 50px;
            text-align: center;
            line-height: 50px;
        }
        .my-form{
            padding: 20px;
            box-sizing: border-box;
        }
        .login-bt{
            width: 100%;
        }
    </style>
</head>
<body>
  <div class="container">
      <div class="login-form">
          <div class="title-box">系统登录</div>
          <form class="layui-form my-form">
              <div class="layui-form-item">
                  <input class="layui-input" name="username" placeholder="用户">
              </div>
              <div class="layui-form-item">
                  <input class="layui-input" name="password" placeholder="密码" type="password">
              </div>
              <div class="layui-form-item">
                  <select name="interest" lay-filter="aihao">
                      <option value="0">管理员</option>
                      <option value="1">用户</option>
                  </select>
              </div>
              <div class="layui-form-item">
                  <button class="layui-btn login-bt" lay-submit lay-filter="submitDemo">立即登录</button>
              </div>
          </form>
      </div>
  </div>
</body>
<script>
    const $ = layui.$;
    layui.use('form', function(){
        const form = layui.form;
        //监听提交
        form.on('submit(submitDemo)', function(data){
            console.log(data.field);
            // layer.msg(JSON.stringify(data.field));
            $.ajax({
                url:"http://localhost:8080/ssmtest1/admin/login",
                data:JSON.stringify(data.field),
                type:"post",
                dataType:"json",
                headers : {'Content-Type' : 'application/json;charset=utf-8'}, //接口json格式
                success: function (res){
                    // console.log(data)
                    if (res.code == 0){
                        layer.msg('登录成功', {icon: 1});
                        localStorage.setItem('user',JSON.stringify(res.data));
                        setTimeout(()=>{
                            window.location.href = '/ssmtest1/home.jsp'
                        },2000)
                    }else{
                        layer.msg(res.message, {icon: 5});
                    }
                },
                error:function (err){

                }
            })
            return false;
        });
    });
</script>
</html>
