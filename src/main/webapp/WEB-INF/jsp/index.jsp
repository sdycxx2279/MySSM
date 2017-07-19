<%--
  Created by IntelliJ IDEA.
  User: 26096
  Date: 2017/7/15
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    boolean my = (boolean)request.getAttribute("my");
%>
<html>
<head>
    <title>Blog</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <!-- start top_js_button -->
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
                    <li <% if(!my) {%>class="active"<%}%>><a href="/article/allArticles.do">所有文章</a></li>
                    <li <% if(my) {%>class="active"<%}%>><a href="/article/myArticles.do">我的文章</a></li>
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
            <h2><% if(!my) {%>recent blog<% } else{ %>My blog<% } %></h2>
        </div>
    </div>
</div>
<!-- start main -->
<div class="wrap">
    <div class="main">
        <div class="blog">
            <c:forEach items="${articles}" var="article">
                <div class="blog_list">
                    <h2>${article.title}</h2>
                    <h5>
                        <fmt:formatDate value="${article.create_time}" type="date" dateStyle="full"/>,
                        Posted by&nbsp;${article.author}
                        ,Read by ${article.viewed} Person
                    </h5>
                    <div class="blog_para">
                        <p class="para">
                            <c:choose>
                                <c:when test="${fn:length(article.content) > 100}">
                                    <c:out value="${fn:substring(article.content, 0, 100)}......" />
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${article.content}" />
                                </c:otherwise>
                            </c:choose>
                        </p>
                        <div class="read_more">
                            <% if(!my) {%>
                            <a class="btn" href="/article/article/${article.id}.do">详细内容</a>
                            <% } else{ %>
                            <a class="btn" href="/article/articleInfo/${article.id}.do">编辑文章</a>
                            <% } %>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <hr/>
            </c:forEach>
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
            |
            <div class="clear"></div>
        </div>
    </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>