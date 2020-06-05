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
                            <p>图书借阅排行榜</p>
                            <hr>
                        </div>
                        <div class="mainForm-body" style="transform: translateX(3%)">
                            <div id="tableClass">
                                <table id="book_info_table" class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>排名</th>
                                            <th>图书名称</th>
                                            <th>图书类型</th>
                                            <th>作者</th>
                                            <th>出版社</th>
                                            <th>语言</th>
                                            <th>书架</th>
                                            <th>被借阅次数</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>
                            <!--分页-->
                            <div class="row" style="margin-top: 10px">
                                <!--分页信息-->
                                <div class="col-md-6 col-md-offset-1" id="page_info_area">

                                </div>
                                <!--分页条-->
                                <div class="col-md-5" id="page_nav_area">

                                </div>
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

                                                <!--以下是 JS 代码-->
    <script type="text/javascript">
        var currentPage,totalNum;
        $(function () {
            to_page(1);
        });

        function to_page(pn) {
            $.ajax({
                url:"${APP_PATH}/booksWithRank",
                type:"GET",
                data:"pn="+pn,
                success:function (result) {
                    console.log(result);
                    //2. 解析并显示分页信息
                    build_page_info(result);
                    //3. 解析并显示分页条数据
                    build_page_nav(result);
                    //1. 解析并显示图书数据
                    build_book_info_table(result);
                }
            })
        }
        //1. 解析并显示书籍数据
        function build_book_info_table(result){
            var rankIndex = (currentPage-1)*10;
            //1-1 清空table里面的tbody
            $("#book_info_table tbody").empty();
            //1-2 获取请求体中的 books
            var booksData = result.extend.pageInfo.list;
            //1-3 遍历books
            $.each(booksData,function (index,item) {
                rankIndex = rankIndex + 1;
                //① 排名
                var rankTd = $("<td></td>").append(rankIndex);
                //② 书名
                var bookNameTd = $("<td></td>").append(item.bookName);
                //③ 类型
                var bookTypeName = $("<td></td>").append(item.bookType.typeName);
                //④ 作者
                var authorTd = $("<td></td>").append(item.bookAuthor);
                //⑤ 出版社
                var pressId = $("<td></td>").append(item.bookPress);
                //⑥ 语言
                var languageTd = $("<td></td>").append(item.bookLanguage);
                //⑦ 所在书架
                var bookCaseTd = $("<td></td>").append(item.bookcase.bookcaseName);
                //⑧ 被借阅次数
                var borrowedTimes = $("<td></td>").append(item.borrowedTimes);

                //12 一整行
                $("<tr></tr>").append(rankTd)
                    .append(bookNameTd)
                    .append(bookTypeName)
                    .append(authorTd)
                    .append(pressId)
                    .append(languageTd)
                    .append(bookCaseTd)
                    .append(borrowedTimes)
                    .appendTo("#book_info_table tbody")
            })
        }

        //2. 解析并显示分页信息
        function build_page_info(result){
            //2-1 清空页面信息
            $("#page_info_area").empty();
            //2-2 获取分页信息
            $("#page_info_area").append("当前在第 "+result.extend.pageInfo.pageNum+" 页，总共有 "+
                result.extend.pageInfo.pages +" 页，共有 "+result.extend.pageInfo.total+" 条记录");

            currentPage = result.extend.pageInfo.pageNum;
            totalNum = result.extend.pageInfo.total;
        }

        //3. 解析并显示分页条数据
        function build_page_nav(result){
            //3-1 清空分页条
            $("#page_nav_area").empty();
            //3-2 建立分页条

            //① <ul>
            var ul = $("<ul></ul>").addClass("pagination");
            //② 首页
            var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#reader_service_title"));
            //③ 前一页
            var prePageLi = $("<li></li>").append($("<a></a>").append("<span></span>").append("&laquo;").attr("aria-hidden","true")).attr("href","#reader_service_title").attr("aria-label","Previous");

            //如果是在第 1 页，则"首页"和"前一页"失效
            if(result.extend.pageInfo.hasPreviousPage == false){
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            }else{
                firstPageLi.click(function () {
                    to_page(1);
                });
                prePageLi.click(function () {
                    to_page(result.extend.pageInfo.pageNum - 1);
                })
            }

            //④ 末页
            var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#reader_service_title"));
            //⑤ 后一页
            var nextPageLi = $("<li></li>").append($("<a></a>").append("<span></span>").append("&raquo;").attr("aria-hidden","true")).attr("href","#reader_service_title").attr("aria-label","Next");

            //如果是在最后 1 页，则"末页"和"下一页"失效
            if(result.extend.pageInfo.hasNextPage == false){
                lastPageLi.addClass("disabled");
                nextPageLi.addClass("disabled");
            }else{
                lastPageLi.click(function () {
                    to_page(result.extend.pageInfo.pages);
                });
                nextPageLi.click(function () {
                    to_page(result.extend.pageInfo.pageNum + 1);
                })
            }

            //3-3 添加首页和前一页
            ul.append(firstPageLi).append(prePageLi);

            //⑥ 中间页
            $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
                var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#reader_service_title"));
                //如果当前是我们在浏览的页面，则高亮
                if(result.extend.pageInfo.pageNum == item){
                    numLi.addClass("active");
                }
                numLi.click(function () {
                    to_page(item);
                })
                //3-4 添加中间页
                ul.append(numLi);
            })

            //3-5 添加后一页和末页
            ul.append(nextPageLi).append(lastPageLi);
            //3-6 把 ul 放入 nav 中
            var navEle = $("<nav></nav>").append(ul).attr("aria-label","Page navigation");
            //3-7 把 nav 放入到对应的 div 中
            navEle.appendTo($("#page_nav_area"));
        }
    </script>

</body>
</html>
