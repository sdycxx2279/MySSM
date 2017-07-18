<%--
  Created by IntelliJ IDEA.
  User: 26096
  Date: 2017/7/16
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <base href="<%=basePath%>">
    <link rel="apple-touch-icon" sizes="76x76" href="image/apple-icon.png">
    <link rel="icon" type="image/png" href="image/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Blog</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

    <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/material-kit.css" rel="stylesheet"/>

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="css/demo.css" rel="stylesheet" />

</head>
<body>
<div class="section section-full-screen section-signup" style="background-image: url('image/city.jpg'); background-size: cover; background-position: top center; min-height: 700px;">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="card card-signup">
                    <form class="form" method="post" action="/user/register.do">
                        <div class="header header-primary text-center">
                            <h4>注册</h4>
                            <div class="social-line">
                                <a href="#pablo" class="btn btn-simple btn-just-icon">
                                    <i class="fa fa-facebook-square"></i>
                                </a>
                                <a href="#pablo" class="btn btn-simple btn-just-icon">
                                    <i class="fa fa-twitter"></i>
                                </a>
                                <a href="#pablo" class="btn btn-simple btn-just-icon">
                                    <i class="fa fa-google-plus"></i>
                                </a>
                            </div>
                            <div style="text-align: center;color:#F00">
                                ${message}
                            </div>
                        </div>
                        <div class="content">

                            <div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">face</i>
										</span>
                                <input type="text" name="nickname" class="form-control" placeholder="昵称">
                            </div>

                            <div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">email</i>
										</span>
                                <input type="text" name="username" class="form-control" placeholder="账号">
                            </div>

                            <div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
                                <input type="password" name="password" placeholder="密码" class="form-control" />
                            </div>

                            <!-- If you want to add a checkbox to this form, uncomment this code

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="optionsCheckboxes" checked>
                                    Subscribe to newsletter
                                </label>
                            </div> -->
                        </div>
                        <div class="footer text-center">
                            <input class="btn btn-simple btn-primary btn-lg" type="submit" name="submit" value="注册"/>
                            <a href="/login.do" class="btn btn-simple btn-primary btn-lg">已有账号</a>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
<!--   Core JS Files   -->
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/material.min.js"></script>

<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="js/nouislider.min.js" type="text/javascript"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script src="js/bootstrap-datepicker.js" type="text/javascript"></script>

<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="js/material-kit.js" type="text/javascript"></script>

<script type="text/javascript">

    $().ready(function(){
        // the body of this function is in material-kit.js
        materialKit.initSliders();
        window_width = $(window).width();

        if (window_width >= 992){
            big_image = $('.wrapper > .header');

            $(window).on('scroll', materialKitDemo.checkScrollForParallax);
        }

    });
</script>
</html>

