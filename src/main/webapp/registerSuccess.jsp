<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,user-scalable=no,minimal-ui">
    <title>激活账户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/elementui/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/elementui/index.js"/>
</head>
<style>
    .box {
        position: relative;
        border-radius: 3px;
        background: #ffffff;
        border-top: 3px solid #3c8dbc;
        margin-bottom: 20px;
        width: 100%;
        height: 500px;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
    }

    .min {
        margin: 0 400px;
    }

    span a {
        width: 110px;
        text-align: center;
        text-decoration: none;
        margin-top: 80px;
        margin-left: 200px;
        display: inline-block;
        border: 1px solid #44a9ff;
        background-color: #44a9ff;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        border-radius: 4px;
        color: #fff;
        padding: 10px 6px;
    }

    span a:hover {
        background-color: #1385e5;
        border-color: #1385e5 !important;
    }
</style>
<body>
<el-container>
    <el-header>
        <h1 style="text-align: center;margin-top:40px;">恭喜您注册成功，请赶快前往注册邮箱激活您的帐户</h1>
    </el-header>
    <el-main>
        <div class="box">
            <div class="min">
                <span><a href="http://mail.163.com/">网易163邮箱</a></span>&nbsp;&nbsp;&nbsp;
                <span><a href="http://mail.126.com/">网易126邮箱</a></span>&nbsp;&nbsp;&nbsp;
                <span><a href="https://mail.qq.com/cgi-bin/loginpage">腾讯QQ邮箱</a></span>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </el-main>
</el-container>
</body>
</html>