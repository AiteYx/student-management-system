<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- 自定义图标字体-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- 主题 stylesheet-->
    <link rel="stylesheet" href="css/style.blue.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- 图标-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
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


                            </ul>
                        </li>

                        <!-- 退出登录    -->
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/logout.do"
                                                class="nav-link logout"> <span class="d-none d-sm-inline">退出登录</span><i
                                class="fa fa-sign-out"></i></a></li>
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
                <li class="active"><a href="${pageContext.request.contextPath}/stuIndex.do"> <i class="icon-home"></i>消息</a>
                </li>
                <li><a href="#exampledropdownDropdown1" aria-expanded="false" data-toggle="collapse">
                    <i class="fa fa-bar-chart"></i>信息查看</a>
                    <ul id="exampledropdownDropdown1" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath}/stuQueryScore.do">成绩查询</a></li>
                        <li><a href="${pageContext.request.contextPath}/stuSchoolTimetable.do">课程表</a></li>
                        <li><a href="${pageContext.request.contextPath}/stuPersonalInformation.do">个人信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/changeStuPassword.do">修改密码</a></li>
                    </ul>
                </li>
                <li><a href="#exampledropdownDropdown2" aria-expanded="false" data-toggle="collapse">
                    <i class="icon-padnote"></i>班级</a>
                    <ul id="exampledropdownDropdown2" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath}/ClassFinancial.do">班级财务</a></li>
                        <li><a href="${pageContext.request.contextPath}/ClassShow.do">班级展示</a></li>
                    </ul>
                </li>
                <li><a href="#exampledropdownDropdown3" aria-expanded="false" data-toggle="collapse">
                    <i class="icon-interface-windows"></i>班委活动</a>
                    <ul id="exampledropdownDropdown3" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath}/ClassMessage.do">发布消息</a></li>
                        <li><a href="${pageContext.request.contextPath}/stuAttendance.do">上课考勤</a></li>
                    </ul>
                </li>
                <li><a href="#exampledropdownDropdown4" aria-expanded="false" data-toggle="collapse">
                    <i class="icon-picture"></i>学生活动</a>
                    <ul id="exampledropdownDropdown4" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath}/stuActivityApply.do">申请</a></li>
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

            <section class="forms">
                <div class="container-fluid">
                    <div class="col-lg-12 row">
                        <div class="card col-md-12">


                            <div class="card-header row">
                                <div class="jumbotron jumbotron-fluid col-md-12" style="margin: 0px 0px">
                                    <div class="container">
                                        <h1 class="display-4">亲爱的同学</h1>
                                        <p class="lead">
                                            不断地提高教学质量，是您和我们共同的期待。对同学进行客观、公正的评价，将有关信息反馈到学校有关部门和院系。因此，请您给学生按照下列标准评分。</p>
                                        <p class="lead">
                                            思想道德20分、文明行为20分、学习态度15分、身心健康15分、集体观念15分、劳动卫生15分，每项成绩评定最低0分。其中，获满分者不应超过全班学生的20%。</p>
                                        <p class="lead">最终成绩取每个人所有成绩的和，再除去班级参加测评的人。</p>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body row">
                                <form class="col-lg-12" action="${pageContext.request.contextPath}/stuSubmitEvaluation.do" method="post">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th scope="col">姓名</th>
                                            <th scope="col">劳动卫生</th><!--A1 -->
                                            <th scope="col">学生态度</th><!--A2 -->
                                            <th scope="col">身心健康</th><!--A3 -->
                                            <th scope="col">集体观念</th><!--A4 -->
                                            <th scope="col">文明行为</th><!--A5 -->
                                            <th scope="col">思想品德</th><!--A6 -->
                                        </tr>
                                        </thead>
                                        <%--<tbody>
                                        <tr>
                                            <th scope="row" class="col-lg-1">余兴兴</th>
                                            <td><input type="text" class="col-lg-12" name=""></td>
                                            <td><input type="text" class="col-lg-12" name=""></td>
                                            <td><input type="text" class="col-lg-12" name=""></td>
                                            <td><input type="text" class="col-lg-12" name=""></td>
                                            <td><input type="text" class="col-lg-12" name=""></td>
                                            <td><input type="text" class="col-lg-12" name=""></td>
                                        </tr>
                                        </tbody>--%>
                                        <c:forEach items="${list}" var="stu" varStatus="i">
                                            <tbody>
                                            <tr>
                                                <%--<th scope="row" class="col-lg-1">${stu.name}</th>--%>
                                                <td><input type="text" class="col-lg-12" disabled="" value="${stu.name}"></td>
                                                <input type="hidden" name="user" value="${stu.id}-${stu.classId}">
                                                <td><input type="text" class="col-lg-12" name="A1"></td>
                                                <td><input type="text" class="col-lg-12" name="A2"></td>
                                                <td><input type="text" class="col-lg-12" name="A3"></td>
                                                <td><input type="text" class="col-lg-12" name="A4"></td>
                                                <td><input type="text" class="col-lg-12" name="A5"></td>
                                                <td><input type="text" class="col-lg-12" name="A6"></td>
                                            </tr>
                                            </tbody>
                                        </c:forEach>
                                    </table>

                                    <div class="line"></div>
                                    <button type="submit" class="btn btn-primary">提交意见</button>
                                </form>
                            </div>


                        </div>
                    </div>
                </div>
            </section>

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
</div>
</body>
</html>