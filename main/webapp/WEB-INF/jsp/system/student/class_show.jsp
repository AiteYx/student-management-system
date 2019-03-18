<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="yxx">
<head>
    <%--固定下面所有地址前缀--%>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!-- Google fonts - Poppins -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
        <!-- 自定义图标字体-->
        <link rel="stylesheet" href="css/fontastic.css">
        <!-- 主题 stylesheet-->
        <link rel="stylesheet" href="css/style.blue.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- 图标-->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="<%=basePath%>vendor/chart.js/Chart.min.js"></script>
</head>
<body>
<div class="page">

    <!--头部-->
    <header class="header">
        <nav class="navbar">
            <div class="container-fluid">
                <div class="navbar-holder d-flex align-items-center justify-content-between">
                    <!-- 头部左上角图标 -->
                    <div class="navbar-header">
                        <!--点击图标链接地址-->
                        <a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                            <div class="brand-text d-none d-lg-inline-block"><span>校园</span><strong>首页</strong></div>
                            <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div>
                        </a>
                        <!--图标旁边按钮-->
                        <a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
                        <script type="text/javascript">
                            $('#toggle-btn').on('click', function (e) {
                                e.preventDefault();
                                $(this).toggleClass('active');

                                $('.side-navbar').toggleClass('shrinked');
                                $('.content-inner').toggleClass('active');
                                $(document).trigger('sidebarChanged');

                                if ($(window).outerWidth() > 1183) {
                                    if ($('#toggle-btn').hasClass('active')) {
                                        $('.navbar-header .brand-small').hide();
                                        $('.navbar-header .brand-big').show();
                                    } else {
                                        $('.navbar-header .brand-small').show();
                                        $('.navbar-header .brand-big').hide();
                                    }
                                }

                                if ($(window).outerWidth() < 1183) {
                                    $('.navbar-header .brand-small').show();
                                }
                            });
                        </script>
                    </div>
                    <!-- 头部右边小菜单 -->
                    <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                        <!-- 消息通知-->
                        <li class="nav-item dropdown"><a id="messages" rel="nofollow" data-target="#" href="#"
                                                         data-toggle="dropdown" aria-haspopup="true"
                                                         aria-expanded="false" class="nav-link"><i
                                class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>
                            <ul aria-labelledby="notifications" class="dropdown-menu">

                                <!--消息项-->
                                <li><a rel="nofollow" href="#" class="dropdown-item d-flex">
                                    <div class="msg-body">
                                        <h3 class="h5">班级消息</h3>
                                        <span>你的班级有一条新消息！</span>
                                    </div>
                                </a></li>
                                <li>
                                    <a rel="nofollow" href="#" class="dropdown-item all-notifications text-center">
                                        <strong>更多消息</strong>
                                    </a></li>
                            </ul>
                        </li>

                        <!-- 退出登录    -->
                        <li class="nav-item"><a href="login.html" class="nav-link logout"> <span
                                class="d-none d-sm-inline">退出登录</span><i class="fa fa-sign-out"></i></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <!--网页主体-->
    <div class="page-content d-flex align-items-stretch">
        <!-- 侧导航栏 -->
        <nav class="side-navbar">
            <!--用户头像-->
            <div class="sidebar-header d-flex align-items-center">
                <div class="avatar"><img src="${user.image}" alt="..." class="img-fluid rounded-circle"></div>
                <div class="title">
                    <h1 class="h4">${user.name}</h1>
                    <p>${claz.name}</p>
                </div>
            </div>
            <!-- 导航栏-->
            <span class="heading">导航栏</span>
            <ul class="list-unstyled">
                <!--导航项-->
                <li><a href="#exampledropdownDropdown1" aria-expanded="false" data-toggle="collapse">
                    <i class="fa fa-bar-chart"></i>信息查看</a>
                    <ul id="exampledropdownDropdown1" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath}/stuPersonalInformation.do">个人信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/stuQueryScore.do">成绩查询</a></li>
                        <li><a href="${pageContext.request.contextPath}/stuSchoolTimetable.do">课程表</a></li>
                    </ul>
                </li>
                <li  class="active"><a href="#exampledropdownDropdown2" aria-expanded="false" data-toggle="collapse">
                    <i class="icon-padnote"></i>班级</a>
                    <ul id="exampledropdownDropdown2" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath}/classFinancial.do">班级财务</a></li>
                        <li><a href="${pageContext.request.contextPath}/classShow.do">班级展示</a></li>
                        <li><a href="${pageContext.request.contextPath}/classViewCheckingIn.do">考勤查看</a></li>
                        <li><a href="${pageContext.request.contextPath}/viewClassMessage.do">消息</a></li>
                    </ul>
                </li>
                <li><a href="#exampledropdownDropdown3" aria-expanded="false" data-toggle="collapse">
                    <i class="icon-interface-windows"></i>班委活动</a>
                    <ul id="exampledropdownDropdown3" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath}/classMessage.do">发布消息</a></li>
                        <li><a href="${pageContext.request.contextPath}/stuAttendance.do">点名</a></li>
                    </ul>
                </li>
                <li><a href="#exampledropdownDropdown4" aria-expanded="false" data-toggle="collapse">
                    <i class="icon-picture"></i>学生活动</a>
                    <ul id="exampledropdownDropdown4" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath}/stuActivityApply.do">申请</a></li>
                        <li><a href="${pageContext.request.contextPath}/stuChangePassword.do">修改密码</a></li>
                        <li><a href="${pageContext.request.contextPath}/stuEvaluation.do">德智测评</a></li>
                    </ul>
                </li>
            </ul>
            <span class="heading">拓展功能</span>
            <ul class="list-unstyled">
                <li><a href="#"> <i class="icon-flask"></i>网上选课</a></li>
                <li><a href="#"> <i class="icon-screen"></i>选座位</a></li>
            </ul>
        </nav>

        <!--页面内容-->
        <div class="content-inner">

            <!--填写内容-->
            <section class="tables">
                <div class="container-fluid">
                    <div class="row">
                        <% int i = 0; %>
                        <%--<!-- 班委 -->
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-close">
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">班委</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-sm">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>姓名</th>
                                                <th>职务</th>
                                                <th>手机号</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%   i = 1; %>
                                            <c:forEach items="${stuList}" varStatus="ss" var="item" >
                                                <c:if test="${not empty item.classLeader && !(item.classLeader eq null)}" >
                                                    <tr>
                                                        <th scope="row"><%=i%></th>
                                                        <td>${item.name}</td>
                                                        <td>${item.classLeader}</td>
                                                        <td>${item.telephone}</td>
                                                    </tr>
                                                    <%  i++; %>
                                                </c:if>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 入党先进分子、党员 -->
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-close">
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">党员</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-sm">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>手机号</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%  i = 1; %>
                                            <c:forEach items="${stuList}" varStatus="ss" var="item" >
                                                <c:if test="${item.politicsStatus eq '党员'}" >
                                                    <tr>
                                                        <th scope="row"><%=i%></th>
                                                        <td>${item.name}</td>
                                                        <td>${item.sex}</td>
                                                        <td>${item.telephone}</td>
                                                    </tr>
                                                    <%  i++; %>
                                                </c:if>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>--%>
                        <!-- 团员 -->
                        <%--<div class="col-lg-12">
                            <div class="card">
                                <div class="card-close">
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">团员</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-sm">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>手机号</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%  i = 1; %>
                                            <c:forEach items="${stuList}" varStatus="ss" var="item" >
                                                <c:if test="${item.politicsStatus eq '团员'}" >
                                                    <tr>
                                                        <th scope="row"><%=i%></th>
                                                        <td>${item.name}</td>
                                                        <td>${item.sex}</td>
                                                        <td>${item.telephone}</td>
                                                    </tr>
                                                    <%  i++; %>
                                                </c:if>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>--%>
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-close">
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">班级信息</h3>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-sm">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>省份</th>
                                                <th>政治面貌</th>
                                                <th>邮箱</th>
                                                <th>手机号</th>
                                                <th>班委</th>
                                                <%--<th>奖学金</th>--%>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%  i = 1; %>
                                            <c:forEach items="${stuList}" varStatus="ss" var="item" >
                                                <%--<c:if test="${item.politicsStatus eq '团员'}" >--%>
                                                    <tr>
                                                        <th scope="row"><%=i%></th>
                                                        <td>${item.name}</td>
                                                        <td>${item.sex}</td>
                                                        <td>${item.province}</td>
                                                        <td>${item.politicsStatus}</td>
                                                        <td>${item.email}</td>
                                                        <td>${item.telephone}</td>
                                                        <td>${item.classLeader}</td>
                                                        <%--<td>${item.classLeader}</td>--%>

                                                    </tr>
                                                    <%  i++; %>
                                                <%--</c:if>--%>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>



                    </div>
                </div>
            </section>

            <!-- Page Footer-->
            <footer class="main-footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <p>By &copy; hbsfdx</p>
                        </div>
                        <div class="col-sm-6 text-right">
                            <p></p>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</div>
</body>
</html>