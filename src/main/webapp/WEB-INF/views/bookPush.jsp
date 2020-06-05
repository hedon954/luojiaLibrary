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
    <jsp:include page="../common/headerPart.jsp"></jsp:include>
    <div class="main">
        <div class="row">
            <div class="middle">
                <div class="mainForm">
                    <div class="mainForm-header">
                        <p>图书归还</p>
                        <hr>
                    </div>
                    <div class="mainForm-body">
                        <div>
                            <div class="firstLine">
                                <div class="readerForm">
                                    <label for="readerBR">读者条形码：</label>
                                    <input type="text" id="readerBR">
                                </div>
                                <div class="confirmBtn">
                                    <button>确定</button>
                                </div>
                            </div>
                            <div class="secondLine">
                                <div>
                                    <label for="readerName">姓名：</label>
                                    <input type="text" id="readerName">
                                </div>
                                <div>
                                    <label for="readerSex">性别：</label>
                                    <input type="text" id="readerSex">
                                </div>
                                <div>
                                    <label for="readerNum">读者编号：</label>
                                    <input type="text" id="readerNum">
                                </div>
                            </div>
                            <div class="thirdLine">
                                <div>
                                    <label for="certificateType">证件类型：</label>
                                    <input type="text" id="certificateType">
                                </div>
                                <div>
                                    <label for="certificateNum">证件号码：</label>
                                    <input type="text" id="certificateNum">
                                </div>
                                <div id="numCombox">
                                    <label for="bookNum">可借数量：</label>
                                    <select id="bookNum">
                                        <option value="0">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                    </select>
                                </div>
                            </div>
                            <div class="forthLine">
                                <div style="float: right">
                                    <div class="confirmBtn completeBtn" id="completeBtn">
                                        <button>完成归还</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="tableClass">
                            <table>
                                <tr>
                                    <th>图书编号</th>
                                    <th>图书名称</th>
                                    <th>借出时间</th>
                                    <th>应还时间</th>
                                    <th>借阅人</th>
                                    <th>归还时间</th>
                                </tr>
                                <tr v-for="item in infoAry">
                                    <td>{{item.index}}</td>
                                    <td>{{item.BRCode}}</td>
                                    <td>{{item.name}}</td>
                                    <td>{{item.type}}</td>
                                    <td>{{item.location}}</td>
                                    <td>{{item.press}}</td>
                                    <td>{{item.writer}}</td>
                                    <td>{{item.borrow}}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <jsp:include page="../common/footerPart.jsp"></jsp:include>
    </div>
</div>

</body>
</html>
