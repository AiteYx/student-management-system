<%@ page import="java.util.Date" %>
<%@ page import="com.hbsfdx.system.pojo.Student" %>
<%@ page import="javafx.scene.input.DataFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="<%=basePath%>vendor/chart.js/Chart.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
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
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/logout.do" class="nav-link logout"> <span
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
                <li class="active"><a href="#exampledropdownDropdown1" aria-expanded="false" data-toggle="collapse">
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

            <%--三个图标--%>
            <section class="charts" style="padding: 50px 0px 0px 0px">
                <div class="container-fluid">
                    <div class="row">

                        <!-- Pie Chart -->
                        <div class="col-lg-4">
                            <div class="pie-chart-example card">
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">考勤状况</h3>
                                </div>
                                <div class="card-body">
                                    <canvas id="pieChartExample1"></canvas>

                                    <script type="text/javascript">

                                        $.ajax({
                                            type : "post",
                                            url : "stuCheckingInAjax.do",
                                            dataType : "json",
                                            success : function (data) {

                                                var labels = data[0];
                                                var datas = data[1];
                                                var PIECHARTEXMPLE    = $('#pieChartExample1');
                                                var pieChartExample = new Chart(PIECHARTEXMPLE, {
                                                    type: 'pie',
                                                    data: {
                                                        labels: labels,
                                                        datasets: [
                                                            {
                                                                data: datas,
                                                                borderWidth: 0,
                                                                backgroundColor: [
                                                                    '#d71c00',
                                                                    "#e6c708",
                                                                    "#0df202"
                                                                ],
                                                                hoverBackgroundColor: [
                                                                    '#d71c00',
                                                                    "#e6c708",
                                                                    "#0df202"
                                                                ]
                                                            }]
                                                    }
                                                });

                                            },
                                            error : function () {
                                                alert("考勤失败！")
                                            }
                                        });
                                    </script>

                                </div>
                            </div>
                        </div>

                        <!-- Doughnut Chart -->
                        <div class="col-lg-4">
                            <div class="pie-chart-example card">
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">班级最近消费</h3>
                                </div>
                                <div class="card-body">
                                    <canvas id="doughnutChartExample1"></canvas>

                                    <script type="text/javascript">
                                        $.ajax({
                                            type : "post",
                                            url : "classExpenditureAjax.do",
                                            dataType : "json",
                                            success : function (data) {

                                                var labels = data[0];
                                                var datas = data[1];

                                                var DOUGHNUTCHARTEXMPLE  = $('#doughnutChartExample1');
                                                var pieChartExample = new Chart(DOUGHNUTCHARTEXMPLE, {
                                                    type: 'doughnut',
                                                    options: {
                                                        cutoutPercentage: 70,
                                                    },
                                                    data: {
                                                        labels: labels,
                                                        datasets: [
                                                            {
                                                                data: datas,
                                                                borderWidth: 0,
                                                                backgroundColor: [
                                                                    '#0bb514',
                                                                    '#02cdbd',
                                                                    "#065ae6"
                                                                ],
                                                                hoverBackgroundColor: [
                                                                    '#0bb514',
                                                                    '#02cdbd',
                                                                    "#065ae6"
                                                                ]
                                                            }]
                                                    }
                                                });
                                            },
                                            error : function () {
                                                alert("班级消费失败！")
                                            }
                                        });
                                    </script>
                                </div>
                            </div>
                        </div>

                        <!-- Radar Chart-->
                        <div class="col-lg-4">
                            <div class="radar-chart-example card">
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">最近大考成绩</h3>
                                </div>
                                <div class="card-body">
                                    <canvas id="radarChartExample1"></canvas>

                                    <script type="text/javascript">
                                        $.ajax({
                                            type : "post",
                                            url : "lastExamScore.do",
                                            dataType : "json",
                                            success : function (data) {

                                                var labels = data[0];
                                                var datas = data[1];

                                                var RADARCHARTEXMPLE  = $('#radarChartExample1');
                                                var radarChartExample = new Chart(RADARCHARTEXMPLE, {
                                                    type: 'radar',
                                                    data: {
                                                        labels: labels,
                                                        datasets: [
                                                            {
                                                                label: "成绩分布",
                                                                backgroundColor: "rgba(84, 230, 157, 0.4)",
                                                                borderWidth: 1,
                                                                borderColor: "rgba(75, 204, 140, 1)",
                                                                pointBackgroundColor: "rgba(75, 204, 140, 1)",
                                                                pointBorderColor: "#fff",
                                                                pointHoverBackgroundColor: "#fff",
                                                                pointHoverBorderColor: "rgba(75, 204, 140, 1)",
                                                                data: datas
                                                            }
                                                        ]
                                                    }
                                                });
                                            },
                                            error : function () {
                                                alert("查询成绩失败！")
                                            }
                                        });
                                    </script>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </section>

            <!--填写内容-->
            <section class="forms" style="padding: 0px 0px">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-close">

                                </div>
                                <div class="card-header d-flex align-items-center">
                                    <h3 class="h4">信息</h3>
                                </div>
                                <div class="card-body">
                                    <form class="form-horizontal" action="${pageContext.request.contextPath}/stuUpdateInfor.do" method="post" id="form">
                                        <!-- 表单每一项 -->
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="name">姓名</label>
                                                <input type="text" disabled="" class="form-control col-md-6" id="name" placeholder="${user.name}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="studentId">学号</label>
                                                <input type="text" disabled="" class="form-control col-md-6" id="studentId" placeholder="${user.id}">
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="sex">性别</label>
                                                <input type="text" disabled="" class="form-control col-md-6" id="sex" placeholder="${user.sex}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="major">主修</label>
                                                <input type="text" disabled="" class="form-control col-md-6" id="major" placeholder="${user.major}">
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="idCard">身份证</label>
                                                <input type="text" disabled="" class="form-control col-md-6" id="idCard" placeholder="${user.idCard}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="nation">民族</label>
                                                <input type="text" disabled="" class="form-control col-md-6" id="nation" placeholder="${user.nation}">
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="politicsStatus">政治面貌</label>
                                                <input type="text" disabled="" class="form-control col-md-6" id="politicsStatus" placeholder="${user.politicsStatus}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="province">省份</label>
                                                <input type="text" disabled="" class="form-control col-md-6" id="province" placeholder="${user.province}">
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">入学日期</label>
                                            <div class="col-sm-9">
                                                <%
                                                    Student stu = (Student) request.getSession().getAttribute("user");
                                                    Date date = stu.getEnrollment();
                                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                                    request.setAttribute("userEnrollment", simpleDateFormat.format(date));
                                                %>
                                                <input type="text" disabled="" placeholder="${userEnrollment}" class="form-control">
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">邮箱</label>
                                            <div class="col-sm-9">
                                                <input name="user_email" type="email" placeholder="${user.email}" class="form-control">
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">电话</label>
                                            <div class="col-sm-9">
                                                <input name="user_telephone" type="text" placeholder="${user.telephone}" class="form-control">
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <div class="form-group row">
                                            <div class="col-sm-4 offset-sm-3">
                                                <button type="submit" class="btn btn-primary">保存信息</button>
                                            </div>
                                        </div>
                                    </form>
                                    <form>
                                        <div class="line"></div>
                                        <div class="form-group row">
                                            <label for="fileInput" class="col-sm-3 form-control-label">修改头像</label>
                                            <div class="col-sm-8">
                                                <input name="user_image" id="fileInput" type="file" class="form-control-file">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-4 offset-sm-3">
                                                <input type="button" onclick="changeImage()" class="btn btn-primary" value="提交" />
                                                <script>
                                                    function changeImage () {
                                                        var formData = new FormData();
                                                        formData.append("user_image", document.getElementById("fileInput").files[0]);
                                                        $.ajax({
                                                            type : "post",
                                                            url : "changeStuImage.do",
                                                            data : formData,
                                                            dataType : "text",
                                                            cache : false,
                                                            processData : false,
                                                            contentType : false,
                                                            success : function (data) {
                                                                if (data != 1)  {
                                                                    alert("请选择正确文件！")
                                                                }
                                                            },
                                                            error : function () {
                                                            }
                                                        });
                                                    }
                                                </script>
                                            </div>
                                        </div>
                                    </form>
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