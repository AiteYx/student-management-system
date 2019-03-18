<%--
  Created by IntelliJ IDEA.
  User: Aite
  Date: 2019/3/10
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>没有选择文件</title>
    <base href="<%=basePath%>" >
    <!--meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="Booster error Page Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

    <!-- //for-mobile-apps -->
    <link href="css/prompt_pages.css" rel="stylesheet" type="text/css" media="all" />
    <link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Dancing+Script:400,700&amp;subset=latin-ext,vietnamese" rel="stylesheet">
</head>
<body>
<div>
    <div class="main-heading">
        <h3>没有选择文件！</h3>
    </div>
    <div class="main">
        <h1>404</h1>
        <div class="more_w3ls">
            <!-- <a href="index.html">返回</a> -->
        </div>
    </div>
</div>
</body>
</html>
