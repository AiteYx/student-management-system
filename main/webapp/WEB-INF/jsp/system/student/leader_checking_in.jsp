<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/3/9
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>点名</title>
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
                            <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div></a>
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
                        <li class="nav-item dropdown"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>
                            <ul aria-labelledby="notifications" class="dropdown-menu">

                                <!--消息项-->
                                <li><a rel="nofollow" href="#" class="dropdown-item d-flex">
                                    <div class="msg-body">
                                        <h3 class="h5">班级消息</h3>
                                        <span>你的班级有一条新消息！</span>
                                    </div></a></li>
                                <li>
                                    <a rel="nofollow" href="#" class="dropdown-item all-notifications text-center">
                                        <strong>更多消息</strong>
                                    </a></li>
                            </ul>
                        </li>

                        <!-- 退出登录    -->
                        <li class="nav-item"><a href="login.html" class="nav-link logout"> <span class="d-none d-sm-inline">退出登录</span><i class="fa fa-sign-out"></i></a></li>
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
                <li><a href="#exampledropdownDropdown2" aria-expanded="false" data-toggle="collapse">
                    <i class="icon-padnote"></i>班级</a>
                    <ul id="exampledropdownDropdown2" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath}/classFinancial.do">班级财务</a></li>
                        <li><a href="${pageContext.request.contextPath}/classShow.do">班级展示</a></li>
                        <li><a href="${pageContext.request.contextPath}/classViewCheckingIn.do">考勤查看</a></li>
                        <li><a href="${pageContext.request.contextPath}/viewClassMessage.do">消息</a></li>
                    </ul>
                </li>
                <li class="active"><a href="#exampledropdownDropdown3" aria-expanded="false" data-toggle="collapse">
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
        </section>
        <div class="content-inner">
            <!-- Breadcrumb-->
            <section class="tables">
                <div class="container-fluid">
                    <div >
                        <div >
                            <div class="card">
                                <div class="card-close">
                                    <div class="dropdown">
                                        <div aria-labelledby="closeCard1" class="dropdown-menu dropdown-menu-right has-shadow"></div>
                                    </div>
                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4" id="skqk">上课考勤情况</h3>
                                </div>
                                <!-- 表单开始 -->
                                <form action="${pageContext.request.contextPath}/submitClassAttendance.do" method="post">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-2 mb-3">
                                                <input id="week_times" type="text" class="form-control"  placeholder="周次（填写数字如：15）" name="week_times" required>
                                            </div>
                                            <div class="form-group" style="margin: 0px 10px">
                                                <select class="custom-select" name="week" required id="week">
                                                    <option value="">礼拜</option>
                                                    <option value="1">周一</option>
                                                    <option value="2">周二</option>
                                                    <option value="3">周三</option>
                                                    <option value="4">周四</option>
                                                    <option value="5">周五</option>
                                                </select>
                                            </div>
                                            <div class="form-group" style="margin: 0px 10px">
                                                <select class="custom-select" name="term" required>
                                                    <option value="">学期</option>
                                                    <option value="大一上">大一上</option>
                                                    <option value="大一下">大一下</option>
                                                    <option value="大二上">大二上</option>
                                                    <option value="大二下">大二下</option>
                                                    <option value="大三上">大三上</option>
                                                    <option value="大三下">大三下</option>
                                                    <option value="大四上">大四上</option>
                                                    <option value="大四下">大四下</option>
                                                </select>
                                            </div>
                                            <div class="form-group" style="margin: 0px 10px">
                                                <select class="custom-select" name="cur_times" id="kj" required>
                                                    <option value="">课节</option>
                                                    <option value="am1">am1</option>
                                                    <option value="am2">am2</option>
                                                    <option value="pm1">pm1</option>
                                                    <option value="pm2">pm2</option>
                                                </select>
                                                <script type="text/javascript">

                                                    $("select#kj").change(function () {

                                                        var weekEle = document.getElementById("week") ;
                                                        var indx = weekEle.selectedIndex;
                                                        var week = weekEle.options[indx].value;

                                                        var curEle = document.getElementById("kj")
                                                        var curIndx = curEle.selectedIndex;
                                                        var cur_times = curEle.options[curIndx].value;

                                                        var week_times = document.getElementById("week_times").value;
                                                        var clazId = ${claz.id};

                                                        $.ajax({
                                                            url : "leaderCheckingInAjax.do",
                                                            type : "POST",
                                                            dataType : "json",
                                                            data : {
                                                                week_times : week_times,
                                                                week : week,
                                                                cur_times : cur_times,
                                                                clazId : clazId
                                                            },
                                                            success : function (data) {

                                                                document.getElementById("skqk").innerHTML = data;
                                                            },
                                                            error : function () {
                                                                alert("错误！！")
                                                            }
                                                        });
                                                    });
                                                </script>
                                            </div>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>序号</th>
                                                    <th>姓名</th>
                                                    <th>考勤状况</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="stu" items="${stuList}" varStatus="i">
                                                <tr>
                                                    <th scope="row">${i.count}</th>
                                                    <td>${stu.name}</td>
                                                    <td>
                                                        <input type="radio" name="activ${i.count}" value="${stu.id}-${stu.classId}-late"> 迟到 </input>
                                                        <input type="radio" name="activ${i.count}" value="${stu.id}-${stu.classId}-leave"> 请假 </input>
                                                        <input type="radio" name="activ${i.count}" value="${stu.id}-${stu.classId}-absence"> 旷课 </input>
                                                    </td>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                            <div>
                                                <p style="float: right;"><input type="submit" value="提交"></p>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <!-- 表单结束 -->
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