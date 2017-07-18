<%--
  Created by IntelliJ IDEA.
  User: 26096
  Date: 2017/7/18
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Blog</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- start top_js_button -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
            });
        });
    </script>
</head>
<body>
<!-- start header -->
<div class="header_bg">
    <div class="wrap">
        <div class="header">
            <div class="logo">
                <a href="/article/allArticles.do"><img src="image/logo.png" alt="首页"/> </a>
            </div>
            <div style="text-align: right;color:#FFFFFF">
                欢迎，<a style="color: #FFFF00" href="/userInfo.do">${LoginUser.nickname}</a>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<!-- start header -->
<div class="header_btm">
    <div class="wrap">
        <div class="header_sub">
            <div class="h_menu">
                <ul>
                    <li><a href="/article/allArticles.do">所有文章</a></li>
                    <li><a href="/article/myArticles.do">我的文章</a></li>
                    <li><a href="article.do">上传文章</a></li>

                </ul>
            </div>
            <script type="text/javascript">
                $(".menu,.search").hide();
                $("#menu").click(function(){
                    $(".menu").toggle();
                    $(".search").hide();
                    $("#search").removeClass("active");
                    $("#menu").toggleClass("active");
                });
                $("#search").click(function(){
                    $(".search").toggle();
                    $(".menu").hide();
                    $("#menu").removeClass("active");
                    $("#search").toggleClass("active");
                    $(".text").focus();
                });
            </script>
            <script type="text/javascript" src="js/script.js"></script>
            <div class="clear"></div>

            <div class="clear"></div>
        </div>
    </div>
</div>
<!-- start top_bg -->
<div class="top_bg">
    <div class="wrap">
        <div class="top">
            <h2>My Information</h2>
        </div>
    </div>
</div>
<!-- start main -->
<div class="wrap">
    <div class="main">
        <div class="contact">
            <div style="color:red;font-size: 26px">${message}</div>
            <div class="contact-form">
                <form method="post" action="/user/update.do">
                    <div>
                        <span style="font-size: 26px">用户名：&nbsp${LoginUser.username}</span>
                    </div>
                    <div>
                        <span style="font-size: 26px">
                            昵称:&nbsp
                            <input style="width: 30%" name="nickname" type="text" class="textbox" value="${LoginUser.nickname}"/>
                        </span>
                    </div>
                    <div>
                        <span style="font-size: 26px">
                            密码:&nbsp
                            <input style="width: 30%" name="password" type="password" class="textbox" value="${LoginUser.password}"/>
                        </span>
                    </div>

                    <div style="text-align: center;">
                        <span><input type="submit" value="修改"></span>
                    </div>
                </form>
            </div>
            <div class="clear"> </div>
        </div>
    </div>
</div>

<!-- start footer -->
<div class="footer_bg1">
    <div class="wrap">
        <div class="footer1">
            <!-- scroll_top_btn -->
            <script type="text/javascript">
                $(document).ready(function() {

                    var defaults = {
                        containerID: 'toTop', // fading element id
                        containerHoverID: 'toTopHover', // fading element hover id
                        scrollSpeed: 1200,
                        easingType: 'linear'
                    };


                    $().UItoTop({ easingType: 'easeOutQuart' });

                });
            </script>
            <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
            <!--end scroll_top_btn -->
            <div style="text-align: right;color:#FFFFFF">
                © 2017, made by Xiao Xu  & Yida Zhu.
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

