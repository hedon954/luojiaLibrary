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
                        <p>图书续借 | 图书归还</p>
                        <hr>
                    </div>
                    <div class="mainForm-body">
                        <div>
                            <form class="firstLine form-inline" style="margin-bottom: 35px">
                                <div class="readerForm form-group">
                                    <label for="readerBR_input" style="font-size: 1.2em">读者条形码：</label>
                                    <input class="form-control" type="text" id="readerBR_input", style="width: 250px">
                                    <span style="transform: translateX(30%)" class="help-block"></span>
                                </div>
                                <div class="form-group">
                                    <button id="get_reader_info_btn" type="button" class="btn btn-primary" style="width: 100px;margin-left: 10px;background-color: rgba(122, 98, 124, 1);color: #fdfdfd;
    border: 1px solid rgba(121, 121, 121, 1);font-size: 1.0em">确 定</button>
                                </div>
                            </form>
                            <form class="secondLine form-inline" style="margin: 10px">
                                <div class="form-group">
                                    <label for="readerName">姓名：</label>
                                    <input type="text" id="readerName" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="readerDocumentType">证件类型：</label>
                                    <input type="text" id="readerDocumentType" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="readerNum">读者编号：</label>
                                    <input type="text" id="readerNum" readonly>
                                </div>
                            </form>
                            <form class="secondLine form-inline" style="margin: 10px">
                                <div class="form-group">
                                    <label for="readerSex">性别：</label>
                                    <input type="text" id="readerSex" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="readerDocumentNumber">证件号码：</label>
                                    <input type="text" id="readerDocumentNumber" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="readerAvailableBorrowNumber">剩余可借：</label>
                                    <input type="text" id="readerAvailableBorrowNumber" readonly>
                                </div>
                            </form>
                        </div>
                        <div id="tableClass" style="width: 98%">
                            <table id="book_info_table" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>借阅编号</th>
                                    <th>书名</th>
                                    <th>类型</th>
                                    <th>作者</th>
                                    <th>出版社</th>
                                    <th>价格</th>
                                    <th>借阅时间</th>
                                    <th>应还时间</th>
                                    <th>剩余续借次数</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody id="book_info_table_tbody">

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
    </div>
    <div class="footer">
        <jsp:include page="../common/footerPart.jsp"></jsp:include>
    </div>
</div>

                                                <!--以下是 JS 代码-->
<script type="text/javascript">
    var currentPage,totalNum;

    /*
    =======================================查寻欲续借或归还图书的读者信息===========================================
    */

    //输入读者条形码 -> 点击"确定按钮" -> 显示读者信息 -> 显示读者借书信息
    $("#get_reader_info_btn").click(function () {
        //1. 判断条形码是否符合规范
        var readerBarCode = $("#readerBR_input").val().trim();
        if(!validate_barCode_not_null(readerBarCode)){
            return false;
        }
        //2. 检查是否存在该读者
        //3. 获取读者信息并显示在界面上
        if(!validate_reader_exists(readerBarCode)){
            return false;
        }
        //4. 显示读者借书信息
        to_page(1);
        return  false;
    });


    //1. 判断条形码是否符合规范
    function validate_barCode_not_null(barCode) {
        //1-1 定义正则表达式
        var regExp = /^[a-zA-Z0-9]{6,18}$/
        //1-2 检查是否符合正则表达式
        if(!regExp.test(barCode)){
            show_validate_msg("#readerBR_input","error","读者条形码必须是6-18位的数字和字母的组合！");
            empty_reader_info();
            return false;
        }else{
            show_validate_msg("#readerBR_input","success","");
            return true;
        }
    }


    //2. 检查是否存在该读者
    function validate_reader_exists(readerBarCode) {
        var exists = true;
        $.ajax({
            async:false,
            url:"${APP_PATH}/checkReader/"+readerBarCode,
            type:"GET",
            success:function (result) {
                console.log(result);
                if(result.code == 100){
                    show_validate_msg("#readerBR_input","success","");
                    //3-1. 获取读者信息并显示在界面上
                    show_reader_info(result);
                }else{
                    show_validate_msg("#readerBR_input","error",result.extend.checkReader_msg);
                    //3-2 读者不存在的话清空信息
                    empty_reader_info()
                    exists = false;
                }
            }
        });
        return exists;
    }

    //3-1. 获取读者信息并显示在界面上
    function show_reader_info(result) {
        var readerData = result.extend.reader[0];
        $("#readerName").val(readerData.readerName);
        $("#readerDocumentType").val(readerData.readerDocumentType);
        $("#readerNum").val(readerData.readerId);
        $("#readerSex").val(readerData.readerGender);
        $("#readerDocumentNumber").val(readerData.readerDocumentNumber);
        $("#readerAvailableBorrowNumber").val(readerData.remainingBookCount);
    }

    //3-2 清空读者信息
    function empty_reader_info() {
        $("#readerName").val("");
        $("#readerDocumentType").val("");
        $("#readerNum").val("");
        $("#readerSex").val("");
        $("#readerDocumentNumber").val("");
        $("#readerAvailableBorrowNumber").val("");
    }


    //显示检验信息
    function show_validate_msg(ele,status,msg) {
        //情况父元素样式，防止叠加
        $(ele).parent().removeClass("has-error has-success");
        //添加样式
        if(status == "success"){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if(status =="error"){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }

    /*
       =======================================查询该读者的借阅书籍信息===========================================
     */

    //4. 显示读者借书信息
    function to_page(pn) {
        $.ajax({
            url:"${APP_PATH}/readerBorrowedBooks",
            type:"GET",
            data:"pn="+pn+"&readerId="+$("#readerNum").val(),
            success:function (result) {
                console.log(result);
                //1. 解析并显示图书数据
                build_book_info_table(result);
                //2. 解析并显示分页信息
                build_page_info(result);
                //3. 解析并显示分页条数据
                build_page_nav(result);
            }
        })
    }

    // //1. 解析并显示图书数据
    function build_book_info_table(result){
        //1-1 清空table里面的tbody
        $("#book_info_table tbody").empty();
        //1-2 获取请求体中的 books
        var booksData = result.extend.pageInfo.list;
        //1-3 遍历books
        $.each(booksData,function (index,item) {
            //① 借阅编号
            var idTd = $("<td></td>").append(item.bookToborrowId);
            //② 书名
            var bookNameTd = $("<td></td>").append(item.book.bookName);
            //③ 类型
            var bookTypeName = $("<td></td>").append(item.book.bookType.typeName);
            //④ 作者
            var authorTd = $("<td></td>").append(item.book.bookAuthor);
            //⑤ 出版社
            var pressId = $("<td></td>").append(item.book.bookPress);
            //⑥ 价格
            var priceTd = $("<td></td>").append("￥"+item.book.bookPrice);
            //⑦ 借阅时间
            var borrowedDateId = $("<td></td>").append(item.borrowedDate);
            //⑧ 应还时间
            var returnedDateTd = $("<td></td>").append(item.returnedDate);
            //⑨ 剩余借阅次数
            var toborrowTimesTd = $("<td></td>").append(item.book.toborrowTimes);
            //⑩ 操作
                //10-1 续借
            var renewBtn = $("<a style='margin: 3px'></a>").attr("role","button").addClass("btn btn-success renew_book_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-hand-right")).append(" 续借");
            renewBtn.attr("renew-book-id",item.book.bookId).attr("book-toborrow-id",item.bookToborrowId);

                //10-2 归还
            var returnBtn = $("<a style='margin: 3px'></a>").attr("role","button").addClass("btn btn-primary return_book_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-hand-right")).append(" 归还");
            returnBtn.attr("return-book-id",item.book.bookId).attr("book-toborrow-id",item.bookToborrowId);
            var btnTd = $("<td></td>").append(renewBtn).append(returnBtn);

            //11 一整行
            $("<tr></tr>").append(idTd)
                .append(bookNameTd)
                .append(bookTypeName)
                .append(authorTd)
                .append(pressId)
                .append(priceTd)
                .append(borrowedDateId)
                .append(returnedDateTd)
                .append(toborrowTimesTd)
                .append(btnTd)
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
            });
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


    /*
       =======================================续借===========================================
     */

    $(document).on("click",".renew_book_btn",function () {
        //1. 检查可续借次数是否大于0
        var remainingBorrowTimes =  $(this).parents("tr").find("td:eq(8)").text();
        var readerName = $("#readerName").val();
        if(!validate_toBorrowTimes_greater_than_zero(remainingBorrowTimes)){
            add_alert_window_to_button(this,"读者 [ "+readerName+" ] 可续借本图书次数已用尽，请在规定时间内归还本图书！");
            return false;
        }else{
            empty_button_alert_window(this);
        }
        //2. 发送续借请求
            //2-1 将本书应还时间推后一个周期
            //2-2 将本数可续借次数 -1
        $.ajax({
            url:"${APP_PATH}/renewBook",
            type:"POST",
            data:"toBorrowId="+$(this).attr("book-toborrow-id")+"&bookId="+$(this).attr("renew-book-id"),
            success:function (result) {
                alert(result.message);
                to_page(currentPage);
            }
        })
    });


    //检验可续借次数是否大于0
    function validate_toBorrowTimes_greater_than_zero(remainingBorrowTimes) {
        var times = parseInt(remainingBorrowTimes);
        if(times<=0){
            return false;
        }else{
            return true;
        }
    }

    //为按钮添加提示框
    function add_alert_window_to_button(ele,msg) {
        $(ele).attr("tabindex","0")
            .attr("data-trigger","focus")
            .attr("data-toggle","popover")
            .attr("title","续借失败")
            .attr("data-content",msg)
            .attr("data-placement","bottom")
            .attr("data-animation","true");
        //显示出来
        $(ele).popover();
    }
    //清楚按钮数据
    function empty_button_alert_window(ele) {
        $(ele).removeAttr("tabindex")
            .removeAttr("data-trigger")
            .removeAttr("data-toggle")
            .removeAttr("title")
            .removeAttr("data-content")
            .removeAttr("data-original-title")
            .removeAttr("data-placement")
            .removeAttr("data-animation");
    }
    /*
       =======================================归还===========================================
     */

    //点击归还按钮，进行归还图书
    $(document).on("click",".return_book_btn",function () {
        //1. 新建归还数据
        //2. 将图书可续借次数更改为3
        //3. 将图书所在书架更改为"未上架"
        //4. 将读者可借书数+1
        var bookName = $(this).parents("tr").find("td:eq(1)").text();
        if(confirm("确定要归还图书 [ "+bookName+" ] 吗？")){
            $.ajax({
                url:"${APP_PATH}/returnBook",
                type:"POST",
                data:"toBorrowId="+$(this).attr("book-toborrow-id")+"&bookId="+$(this).attr("return-book-id"),
                success:function (result) {
                    alert(result.message);
                    //更新读者可借次数
                    var countStr = $("#readerAvailableBorrowNumber").val();
                    var countInt = parseInt(countStr)+1;
                    $("#readerAvailableBorrowNumber").val(countInt);
                    to_page(currentPage);
                }
            })
        }else {
            return false;
        }

    });
</script>
</body>
</html>
