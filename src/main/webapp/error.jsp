<%--
  Created by IntelliJ IDEA.
  User: hedon-
  Date: 2020-05-26
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>珞珈图书馆</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath()); //以 "/"开始，不以 "/" 结束
    %>
    <link rel="icon" href="${APP_PATH}/static/images/Title.png" type="image/x-icon"/>
    <!-- 引入 jQuery，要在引入 Bootstrap 之前 -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.11.3.js"></script>
    <!-- 引入 Bootstrap 的 js 文件 -->
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <!-- 引入 Bootstrap 的 css 文件 -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入自定义的 css 文件-->
    <link href="${APP_PATH}/static/css/index.css" rel="stylesheet">
</head>
<body>
    <div id="page">
        <jsp:include page="WEB-INF/common/headerPart.jsp"></jsp:include>
        <div class="main">
            <div class="row">
                <div class="middle">
                    <div class="mainForm">
                        <div class="mainForm-header">
                            <p id="library_info_p">错误界面</p>
                            <hr>
                        </div>
                        <div class="mainForm-body row" >
                            <div id="error_area" class="jumbotron col-lg-6 col-md-offset-3" style="
                                                                        height: 30%;
                                                                        background-color: whitesmoke;
                                                                        transform: translateY(5%);
                                                                        font-family: 'Apple Braille';
                                                        ">
                                <h1 align="center">请先登录<span style="transform: translateY(10%)" class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span></h1>
                                <p style="transform: translateY(100%)" align="center">
                                    <a id="go_to_login" class="btn btn-danger btn-lg" href="${APP_PATH}/login"  role="button">
                                    <span  style="transform: translateY(10%)" class="glyphicon glyphicon-log-in" aria-hidden="true"></span>  前去登录</a></p>
                            </div >
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <jsp:include page="/WEB-INF/common/footerPart.jsp"></jsp:include>
        </div>

        <div id="test"></div>
    </div>

    <script type="text/javascript">

    </script>
</body>
</html>
