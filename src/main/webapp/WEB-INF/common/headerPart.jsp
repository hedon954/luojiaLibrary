<%--
  Created by IntelliJ IDEA.
  User: hedon-
  Date: 2020-05-26
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!-- 头部 -->
<div class="bgd">
</div>
<div class="nav-container">
    <div class="navigation_class">
        <div class="dropdown_class">
            <a href="#">本馆首页</a>
            <div class="dropdown-content_class" style="z-index:9999">
                <a href="<%=request.getContextPath()%>/bookRank">图书排行</a>
                <a href="<%=request.getContextPath()%>/readerRank">读者排行</a>
            </div>
        </div>
        <div class="dropdown_class">
            <a href="#">系统设置</a>
            <div class="dropdown-content_class" style="z-index:9999">
                <a href="<%=request.getContextPath()%>/homepage">图书馆信息</a>
                <a href="<%=request.getContextPath()%>/adminSettings">管理员设置</a>
            </div>
        </div>
        <div class="dropdown_class">
            <a href="<%=request.getContextPath()%>/readerService">读者服务</a>
        </div>
        <div class="dropdown_class">
            <a href="#">图书管理</a>
            <div class="dropdown-content_class" style="z-index:9999">
                <a href="<%=request.getContextPath()%>/bookInfo">图书信息管理</a>
                <a href="<%=request.getContextPath()%>/bookType">图书类型设置</a>
            </div>
        </div>
        <div class="dropdown_class">
            <a href="#">图书借还</a>
            <div class="dropdown-content_class" style="z-index:9999">
                <a href="<%=request.getContextPath()%>/bookBorrow">图书借阅</a>
                <a href="<%=request.getContextPath()%>/bookRenewAndReturn">续借归还</a>
<%--                <a href="<%=request.getContextPath()%>/bookPush">图书催还</a>--%>
            </div>
        </div>
        <div class="dropdown_class">
            <a href="<%=request.getContextPath()%>/changePwd">修改密码</a>
        </div>
        <div class="dropdown_class">
            <a href="#" onclick="quit()">退出系统</a>
        </div>
    </div>
    <script type="text/javascript">
        function quit() {
            if(confirm("确定要退出系统吗？咱不再考虑考虑？")){
                window.location.href ="index.jsp";
            }
        }
    </script>
</div>