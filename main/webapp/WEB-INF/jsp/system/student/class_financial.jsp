<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="yxx">
<head>
    <%--固定下面所有地址前缀--%>
    <base href="<%=basePath%>" >
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
    <script>
        $(document).ready(function () {

            'use strict';

            var legendState = true;
            if ($(window).outerWidth() < 576) {
                legendState = false;
            }

            $.ajax({
                type : "POST",
                url : "classFinancialAjax.do",
                dataType : "JSON",
                async : "true",
                success : function (data) {
                    var datas = data[0];
                    var lab = data[1];

                    var classFinancialChart = $('#classFinancialLineChart');
                    var cFChart = new Chart(classFinancialChart, {
                        type: 'line',
                        options: {
                            scales: {
                                xAxes: [{
                                    display: true,
                                    gridLines: {
                                        display: false
                                    }
                                }],
                                yAxes: [{
                                    display: true,
                                    gridLines: {
                                        display: false
                                    }
                                }]
                            },
                            legend: {
                                display: legendState
                            }
                        },
                        data: {
                            labels: lab,
                            datasets: [
                                {
                                    label: "本学期周次花费",
                                    fill: true,
                                    lineTension: 0,
                                    backgroundColor: "transparent",
                                    borderColor: "#54e69d",
                                    pointHoverBackgroundColor: "#44c384",
                                    borderCapStyle: 'butt',
                                    borderDash: [],
                                    borderDashOffset: 0.0,
                                    borderJoinStyle: 'miter',
                                    borderWidth: 1,
                                    pointBorderColor: "#44c384",
                                    pointBackgroundColor: "#fff",
                                    pointBorderWidth: 1,
                                    pointHoverRadius: 5,
                                    pointHoverBorderColor: "#fff",
                                    pointHoverBorderWidth: 2,
                                    pointRadius: 1,
                                    pointHitRadius: 10,
                                    data: datas,
                                    spanGaps: false
                                }
                            ]
                        }
                    });
                },
                error : function () {
                    alert("失败！");
                }
            });
        });
    </script>
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
                            <!-- 退出登录    -->
                            <li class="nav-item"><a href="${pageContext.request.contextPath}/logout.do" class="nav-link logout"> <span class="d-none d-sm-inline">退出登录</span><i class="fa fa-sign-out"></i></a></li>
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
                    <li> <a href="#"> <i class="icon-flask"></i>网上选课</a></li>
                    <li> <a href="#"> <i class="icon-screen"></i>选座位</a></li>
                </ul>
            </nav>
            <!--页面内容-->
            <div class="content-inner">
                <!--填写内容-->
                <section class="tables">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="card">
                                    <div class="card-close">
                                    </div>
                                    <div class="card-header d-flex align-items-center">
                                        <h3 class="h4">消费记录</h3>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-sm">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>时间</th>
                                                    <th>地点</th>
                                                    <th>花费</th>
                                                    <th>消费说明</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${classExpenditureList}" var="item" varStatus="ss">
                                                    <tr>
                                                        <th scope="row">${ss.count}</th>
                                                        <td><fmt:formatDate  value="${item.updated}" pattern="yyyy-MM-dd"/></td>
                                                        <%--<td>${item.updated}</td>--%>
                                                        <td>${item.location}</td>
                                                        <td>${item.amount}</td>
                                                        <td>${item.reson}</td>
                                                    </tr>
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

                <%--消费线性表--%>
                <section class="dashboard-header">
                    <div class="container-fluid">
                        <div class="row">
                            <!-- Line Chart            -->
                            <div class="chart col-lg-12 col-12">
                                <div class="line-chart bg-white d-flex align-items-center justify-content-center has-shadow">
                                    <canvas id="classFinancialLineChart"></canvas>
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