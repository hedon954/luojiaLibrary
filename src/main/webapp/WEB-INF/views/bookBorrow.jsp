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
                        <!-- 标题 -->
                        <div class="mainForm-header">
                            <p>图书借阅</p>
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
                                <hr>
                                <form>
                                    <div class="row">
                                        <div class="col-lg-2">
                                            <div class="input-group">
                                                <label style="font-size: 1.2em;transform: translateY(20%)">书籍名称：</label>
<%--                                                <select id="search_type_select" style="height: 35px">--%>
<%--                                                    <option value="1">图书类型</option>--%>
<%--                                                    <option value="2">所在书架</option>--%>
<%--                                                    <option value="3" selected>书籍名称</option>--%>
<%--                                                </select>--%>
                                            </div><!-- /input-group -->
                                        </div><!-- /.col-lg-6 -->
                                        <div class="col-lg-3" style="transform: translateX(-40%)">
                                            <div class="input-group">
                                                <input type="text" class="form-control" id="search_book_input" placeholder="Search for...">
                                                <span class="input-group-btn">
                                                     <button id="search_book_button" class="btn btn-default" style="background-color: #6e5772;color: #fdfdfd;" type="button">搜索</button>
                                                </span>
                                            </div><!-- /input-group -->
                                        </div><!-- /.col-lg-6 -->
                                    </div><!-- /.row -->
                                </form>
                            </div>
                            <div id="tableClass" style="width: 98%">
                                <table id="book_info_table" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>书名</th>
                                        <th>类型</th>
                                        <th>作者</th>
                                        <th>出版社</th>
                                        <th>价格</th>
                                        <th>语言</th>
                                        <th>所在书架</th>
                                        <th>修改时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="book_info_table_tbody">
                                    <tr>
                                        <td>100</td>
                                        <td>史记（全三册）</td>
                                        <td>文学/文言文</td>
                                        <td>司马迁</td>
                                        <td>人民教育出版社</td>
                                        <td>￥98</td>
                                        <td>文言文/中文</td>
                                        <td>左-A1</td>
                                        <td>2020-03-05 20:03:56</td>
                                        <td>
                                            <button>借阅</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!--分页-->
                            <div class="row" style="margin-top: 10px">
                                <!--分页信息-->
                                <div class="col-md-6 col-md-offset-1" id="page_info_area">

                                </div>
                                <!--分页条-->
                                <div class="col-md-5" id="page_nav_area" style="transform: translateY(-20%);">

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
       =======================================查寻未接书籍信息===========================================
        */

        $(function () {
            $("#search_book_input").val("");
            to_page(1);
        });

        function to_page(pn) {
            var searchText = $("#search_book_input").val()
            $.ajax({
                url:"${APP_PATH}/searchBookUnBorrowed",
                type:"GET",
                data:"pn="+pn+"&searchText="+searchText,
                success:function (result) {
                    console.log(result);
                    // //1. 解析并显示图书数据
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
                //① 编号
                var idTd = $("<td></td>").append(item.bookId);
                //② 书名
                var bookNameTd = $("<td></td>").append(item.bookName);
                //③ 类型
                var bookTypeName = $("<td></td>").append(item.bookType.typeName);
                //④ 作者
                var authorTd = $("<td></td>").append(item.bookAuthor);
                //⑤ 出版社
                var pressId = $("<td></td>").append(item.bookPress);
                //⑥ 价格
                var priceTd = $("<td></td>").append("￥"+item.bookPrice);
                //⑦ 语言
                var languageTd = $("<td></td>").append(item.bookLanguage);
                //⑧ 所在书架
                var bookCaseTd = $("<td></td>").append(item.bookcase.bookcaseName);
                //⑨ 录入时间
                var bookEntryTimeTd = $("<td></td>").append(item.bookEntryTime);
                //11 操作
                var borrowBtn = $("<a style='margin: 3px'></a>").attr("role","button").addClass("btn btn-primary borrow_book_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-hand-right")).append(" 借阅");
                borrowBtn.attr("borrow-id",item.bookId);
                var btnTd = $("<td></td>").append(borrowBtn);

                //12 一整行
                $("<tr></tr>").append(idTd)
                    .append(bookNameTd)
                    .append(bookTypeName)
                    .append(authorTd)
                    .append(pressId)
                    .append(priceTd)
                    .append(languageTd)
                    .append(bookCaseTd)
                    .append(bookEntryTimeTd)
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

        /*
       =======================================查寻欲借书的读者信息===========================================
        */

        //输入读者条形码 -> 点击"确定按钮" -> 显示读者信息
        $("#get_reader_info_btn").click(function () {
            //1. 判断条形码是否符合规范
            var readerBarCode = $("#readerBR_input").val().trim();
            if(!validate_barCode_not_null(readerBarCode)){
                return false;
            }
            //2. 检查是否存在该读者
            if(!validate_reader_exists(readerBarCode)){
                return false;
            }
            //3. 获取读者信息并显示在界面上
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
       =======================================执行借阅操作===========================================
        */

        //点击"借阅"按钮，借阅图书
        $(document).on("click",".borrow_book_btn",function () {
            //1. 检查读者编号是否为空
            var readerId = $("#readerNum").val();
            if(!validate_readerId_not_null(readerId)){
                add_alert_window_to_button(this,"请先录入读者信息再进行借阅书籍！");
                return false;
            }
            //2. 检查读者剩余可借书籍数目
            var readerName = $("#readerName").val().trim();
            var remainingCount = $("#readerAvailableBorrowNumber").val().trim();
            if(!validate_reader_can_borrow(remainingCount)){
                add_alert_window_to_button(this,"读者 [ "+readerName+" ] 可借书籍为 0，请先归还已借图书再进行借阅！");
                return false;
            }else{
                empty_button_alert_window(this);
            }

            //3. 执行借阅书籍
            var bookId = $(this).attr("borrow-id");
            execute_borrow_book(readerId,bookId);

        });

        //1. 检查读者编号是否为空
        function validate_readerId_not_null(readerId) {
            //去除前后空格
            readerId = readerId.trim();
            if(readerId == null || readerId == "" || null || readerId == undefined){
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
                .attr("title","借阅失败")
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

        //2. 检查读者剩余可借书籍数目
        function validate_reader_can_borrow(count) {
            var remainCount = parseInt(count);
            if(remainCount<=0){
                return false;
            }else{
                return true;
            }
        }
        //3. 执行借阅书籍
        function execute_borrow_book(readerId,bookId) {
            //3-1 创建借阅数据
            //3-2 将书籍可借次数-1
            //3-3 将书籍被借次数+1
            //3-4 将书籍的"所在书架"改为"已出借"
            //3-5 将读者可借书籍数量-1
            //3-6 将读者总借书籍数量+1
            $.ajax({
                url:"${APP_PATH}/borrowBook",
                type:"POST",
                data:"readerId="+readerId+"&bookId="+bookId,
                success:function(result) {
                    console.log(result);
                    //显示提示信息
                    alert(result.message);
                    //更新读者可借次数
                    var countStr = $("#readerAvailableBorrowNumber").val();
                    var countInt = parseInt(countStr)-1;
                    $("#readerAvailableBorrowNumber").val(countInt);
                    //来到本页（刷新表格）
                    to_page(currentPage);
                }
            })
        }

        /*
       =======================================搜索功能===========================================
        */

        //点击"搜索"按钮，执行搜索操作
        $("#search_book_button").click(function () {
            to_page(1);
        })
    </script>

</body>
</html>
