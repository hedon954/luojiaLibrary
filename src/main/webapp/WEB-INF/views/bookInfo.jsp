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
                            <p>图书信息管理</p>
                            <hr>
                        </div>
                        <div class="mainForm-body">
                            <div id="purpleBtn">
                                <button id="add_book_info_button">添加图书信息</button>
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
                                            <th>操作者</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="book_info_table_tbody">
                                        <tr>
                                            <td>100</td>
                                            <td>史记（全三册）</td>
                                            <td>文学</td>
                                            <td>司马迁</td>
                                            <td>岳麓书社</td>
                                            <td>￥98</td>
                                            <td>文言文/中文</td>
                                            <td>2020-03-05 20:03:56</td>
                                            <td>左-A1</td>
                                            <td>王佳翰</td>
                                            <td>
                                                <button>编辑</button>
                                                <button>删除</button>
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

                                             <!-- 新增图书模态框  -->
    <div class="modal fade" id="add_book_modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">添加图书</h4>
                </div>
                <div class="modal-body">
                    <form id="add_boo_info_form">
                        <!--1. 书名-->
                        <div class="form-group">
                            <label for="add_book_info_name">☞ 书名：</label>
                            <div>
                                <input type="text" class="form-control" id="add_book_info_name" name="bookName" placeholder="bookName">
                                <span id="add-book-name-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--10. pdf链接-->
                        <div class="form-group">
                            <label for="add_book_info_pdf">☞ PDF 链接(<font color="#6495ed">可为空</font>)：</label>
                            <div>
                                <input type="text" class="form-control" id="add_book_info_pdf" name="bookPdfurl" placeholder="bookPdfUrl">
                                <span id="add-book-pdf-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--2. 类型-->
                        <div class="form-group">
                            <label for="add_book_type_select">☞ 书籍类型(<font color="#6495ed">若无相关书籍类型，请前往"书籍类型管理"添加书籍类型</font>)：</label>
                            <div>
                                <select id="add_book_type_select" name="typeId">

                                </select>
                            </div>
                        </div>
                        <!--3. 作者-->
                        <div class="form-group">
                            <label for="add_book_info_author">☞ 作者：</label>
                            <div>
                                <input type="text" class="form-control" id="add_book_info_author" name="bookAuthor" placeholder="bookAuthor">
                                <span id="add-book-author-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--4. 出版社-->
                        <div class="form-group">
                            <label for="add_book_info_press">☞ 出版社：</label>
                            <div>
                                <input type="text" class="form-control" id="add_book_info_press" name="bookPress" placeholder="bookPress">
                                <span id="add-book-press-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--5. 价格-->
                        <div class="form-group">
                            <label for="add_book_price_input">☞ 价格：</label>
                            <div>
                                <input type="text" class="form-control" id="add_book_price_input" name="bookPrice" placeholder="bookPrice">
                                <span id="add-book-price-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--6. 语言-->
                        <div class="form-group">
                            <label for="add_book_language_select">☞ 语言：</label>
                            <div>
                                <select id="add_book_language_select" name="bookLanguage">
                                    <option value="中文">中文</option>
                                    <option value="英文">英文</option>
                                    <option value="中英双语">中英双语</option>
                                    <option value="文言文">文言文</option>
                                    <option value="法文">法文</option>
                                    <option value="德文">德文</option>
                                    <option value="其他">其他</option>
                                </select>
                            </div>
                        </div>
                        <!--7. 所在书架-->
                        <div class="form-group">
                            <label for="add_book_case_select">☞ 所在书架：</label>
                            <div>
                                <select id="add_book_case_select" name="bookCaseId">

                                </select>
                            </div>
                        </div>
                        <!--8. 录入时间-->
                        <div class="form-group">
                            <label for="add_book_date_input">☞ 修改时间：</label>
                            <div>
                                <input type="text" class="form-control" id="add_book_date_input" name="bookEntryTime" readonly>
                                <span id="add-book-date-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--9. 操作者 -->
                        <div class="form-group">
                            <label for="add_book_manager_select">☞ 操作员：</label>
                            <select id="add_book_manager_select" name="operatorId">
                                <option value="1">王佳翰</option>
                                <option value="2">邱景妍</option>
                                <option value="3">周妍</option>
                                <option value="4">张嘉程</option>
                            </select>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="modal_add_book_info_button">添加</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

                                            <!-- 编辑图书模态框  -->
    <div class="modal fade" id="update_book_modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改图书信息</h4>
                </div>
                <div class="modal-body">
                    <form id="update_boo_info_form">
                        <!--1. 书名-->
                        <div class="form-group">
                            <label for="update_book_info_name">☞ 书名：</label>
                            <div>
                                <input type="text" class="form-control" id="update_book_info_name" name="bookName" placeholder="bookName">
                                <span id="update-book-name-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--10. pdf链接-->
                        <div class="form-group">
                            <label for="update_book_info_pdf">☞ PDF 链接(<font color="#6495ed">可为空</font>)：</label>
                            <div>
                                <input type="text" class="form-control" id="update_book_info_pdf" name="bookPdfurl" placeholder="bookPdfUrl">
                                <span id="update-book-pdf-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--2. 类型-->
                        <div class="form-group">
                            <label for="update_book_type_select">☞ 书籍类型(<font color="#6495ed">若无相关书籍类型，请前往"书籍类型管理"添加书籍类型</font>)：</label>
                            <div>
                                <select id="update_book_type_select" name="typeId">

                                </select>
                            </div>
                        </div>
                        <!--3. 作者-->
                        <div class="form-group">
                            <label for="update_book_info_author">☞ 作者：</label>
                            <div>
                                <input type="text" class="form-control" id="update_book_info_author" name="bookAuthor" placeholder="bookAuthor">
                                <span id="update-book-author-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--4. 出版社-->
                        <div class="form-group">
                            <label for="update_book_info_press">☞ 出版社：</label>
                            <div>
                                <input type="text" class="form-control" id="update_book_info_press" name="bookPress" placeholder="bookPress">
                                <span id="update-book-press-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--5. 价格-->
                        <div class="form-group">
                            <label for="update_book_price_input">☞ 价格：</label>
                            <div>
                                <input type="text" class="form-control" id="update_book_price_input" name="bookPrice" placeholder="bookPrice">
                                <span id="update-book-price-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--6. 语言-->
                        <div class="form-group">
                            <label for="update_book_language_select">☞ 语言：</label>
                            <div>
                                <select id="update_book_language_select" name="bookLanguage">
                                    <option value="中文">中文</option>
                                    <option value="英文">英文</option>
                                    <option value="中英双语">中英双语</option>
                                    <option value="文言文">文言文</option>
                                    <option value="法文">法文</option>
                                    <option value="德文">德文</option>
                                    <option value="其他">其他</option>
                                </select>
                            </div>
                        </div>
                        <!--7. 所在书架-->
                        <div class="form-group">
                            <label for="update_book_case_select">☞ 所在书架：</label>
                            <div>
                                <select id="update_book_case_select" name="bookCaseId">

                                </select>
                            </div>
                        </div>
                        <!--8. 录入时间-->
                        <div class="form-group">
                            <label for="add_book_date_input">☞ 录入时间：</label>
                            <div>
                                <input type="text" class="form-control" id="update_book_date_input" name="bookEntryTime" readonly>
                                <span id="update-book-date-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!--9. 操作者 -->
                        <div class="form-group">
                            <label for="update_book_manager_select">☞ 操作员：</label>
                            <select id="update_book_manager_select" name="operatorId">
                                <option value="1">王佳翰</option>
                                <option value="2">邱景妍</option>
                                <option value="3">周妍</option>
                                <option value="4">张嘉程</option>
                            </select>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="modal_update_book_info_button">更新</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->





                                                <!--以下是JS代码-->
    <script type="text/javascript">
        var currentPage,totalNum;


        /*
       =======================================查===========================================
        */
        $(function () {
            to_page(1);
        });

        function to_page(pn) {
            $.ajax({
                url:"${APP_PATH}/books",
                type:"GET",
                data:"pn="+pn,
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
        //1. 解析并显示读者数据
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
                //⑩ 操作者
                var operatorTd = $("<td></td>").append(item.manager.managerName);
                //11 操作

                    //11-1 编辑
                var editBtn = $("<a style='margin: 2px'></a>").attr("role","button").addClass("btn btn-info  edit_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append(" 编辑");
                    //为按钮绑定id，便于后续操作
                editBtn.attr("edit-id",item.bookId);

                    //11-2 删除
                var deleteBtn = $("<a style='margin: 2px'></a>").attr("role","button").addClass("btn btn-danger  delete_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append(" 删除");
                   //为按钮绑定id，便于后续操作
                deleteBtn.attr("delete-id",item.bookId);

                var btnTd = $("<td></td>").append(editBtn).append(deleteBtn);

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
                    .append(operatorTd)
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
       =======================================增===========================================
        */


        //点击"新增图书"按钮，弹出模态框
        $("#add_book_info_button").click(function () {
            //1. 清空模态框
            reset_form("#add_book_modal form");
            //2. 查询所有书籍类型信息，显示在下拉列表中
            getBookTypes("#add_book_type_select");
            //3. 查询所有书架，显示在下拉列表中
            getAllBookCases("#add_book_case_select");
            //4. 获取当前时间，显示在录入时间input中
            $("#add_book_date_input").val(getFormatDate());
            //5. 打开模态框
            $("#add_book_modal").modal({
                backdrop:"static"
            })
        });

        //1. 重置表单
        function reset_form(ele) {
            //清空内容
            $(ele)[0].reset();
            //清空样式
            $(ele).find("*").removeClass("has-success has-error");
            //清空提示信息
            $(ele).find(".help-block").text("");
        }
        //2. 查询所有书籍类型信息，显示在下拉列表中
        function getBookTypes(ele) {
            $.ajax({
                url:"${APP_PATH}/getBookTypes",
                type:"GET",
                success:function (result) {
                    // console.log(result);
                    var bookTypesData = result.extend.bookTypes;
                    //清空下拉菜单
                    $(ele).empty();
                    //遍历添加下拉菜单
                    $.each(bookTypesData,function (index,item) {
                        $("<option></option>").attr("value",item.typeId).append(item.typeName)
                            .appendTo($(ele));
                    })
                }
            })
        }

        //3. 查询所有书架，显示在下拉列表中
        function getAllBookCases(ele) {
            $.ajax({
                url:"${APP_PATH}/getBookCases",
                type:"GET",
                success:function (result) {
                    // console.log(result);
                    var bookcasesData = result.extend.bookcases;
                    //清空下拉菜单
                    $(ele).empty();
                    //遍历添加下拉菜单
                    $.each(bookcasesData,function (index,item) {
                        $("<option></option>").attr("value",item.bookcaseId).append(item.bookcaseName)
                            .appendTo(ele);
                    })
                }
            })
        }

        //4. 获取当前时间，显示在录入时间input中
        // function getNowTime() {
        //     return new Date();
        // }
        function getFormatDate() {
            var date = new Date();
            var month = date.getMonth()+1;
            var strDate = date.getDate();
            var hour = date.getHours();
            var minute = date.getMinutes();
            var second = date.getSeconds();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            if(hour >=0 && hour<=9){
                hour = "0"+hour;
            }
            if(minute>=0 && minute<=9){
                minute = "0"+minute;
            }
            if(second >=0 && second <= 9){
                second = "0" + second;
            }
            var currentDate = date.getFullYear() + "-" + month + "-" + strDate
                + " " + hour + ":" + minute + ":" + second;
            return currentDate;
        }


        //点击模态框中的"添加"按钮，添加图书信息
        $("#modal_add_book_info_button").click(function () {
            //1. 判断书名是否为空
            var bookName = $("#add_book_info_name").val();
            if(!validate_field_not_null("#add_book_info_name",bookName,"","书名不能为空！")){
                return false;
            }
            //2. 判断作者是否为空
            var bookAuthor = $("#add_book_info_author").val();
            if(!validate_field_not_null("#add_book_info_author",bookAuthor,"","作者名不能为空！")){
                return false;
            }
            //3. 判断出版社是否为空
            var bookPress = $("#add_book_info_press").val();
            if(!validate_field_not_null("#add_book_info_press",bookPress,"","出版社不能为空！")){
                return false;
            }
            //4. 判断价格是否为浮点数或者整数
            var reg = /^\d+(\.\d+)?$/;
            var bookPrice = $("#add_book_price_input").val();
            if (!reg.test(bookPrice)) {
                show_validate_msg("#add_book_price_input","error","价格必须是正浮点数！");
                return false;
            }
            else{
                show_validate_msg("#add_book_price_input","success","");
            }
            //5. 发送 ajax 请求进行保存
            $.ajax({
                url:"${APP_PATH}/book",
                type:"POST",
                data:$("#add_book_modal form").serialize(),
                success:function (result) {
                    if(result.code == 100){
                        //提示信息
                        alert(result.message);
                        //隐藏模态框
                        $("#add_book_modal").modal("hide");
                        //来到添加信息所在的页面
                        to_page(totalNum);
                    }else{
                        alert(result.message);
                    }
                }
            })
            
        });
        

        //1、2 检验是否为空
        function validate_field_not_null(ele,fieldName,successMsg,errorMsg) {
            if(fieldName == null || fieldName == "" || fieldName == undefined){
                show_validate_msg(ele,"error",errorMsg);
                return false;
            }
            else{
                show_validate_msg(ele,"success",successMsg);
                return true;
            }
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
       =======================================删===========================================
        */
        //单击"删除"按钮，执行删除操作
        $(document).on("click",".delete_btn",function () {
            //0. 判断书籍是否已经出借，如果已经出借，则不能编辑
            var bookName = $(this).parents("tr").find("td:eq(1)").text();
            var bookcase = $(this).parents("tr").find("td:eq(7)").text();
            if(bookcase == "已出借"){
                add_alert_window_to_button(this,"删除","书籍 ["+bookName+"] 正处于'在借中'状态，无法删除！");
                return false;
            }else{
                empty_button_alert_window(this);
            }
            //1. 进行删除操作
            var bookId = $(this).attr("delete-id");
            if(confirm("你确定要删除 [ "+bookName+" ] 吗？")){
                $.ajax({
                    url:"${APP_PATH}/book/"+bookId,
                    type:"DELETE",
                    success:function (result) {
                        if(result.code == 100){
                            alert(result.message);
                            to_page(currentPage);
                        }else{
                            alert(result.message);
                        }
                    }
                })
            }
        })

        /*
       =======================================改===========================================
        */
        //点击编辑按钮，弹出模态框
        $(document).on("click",".edit_btn",function () {
            //0. 判断书籍是否已经出借，如果已经出借，则不能编辑
            var bookName = $(this).parents("tr").find("td:eq(1)").text();
            var bookcase = $(this).parents("tr").find("td:eq(7)").text();
            if(bookcase == "已出借"){
                add_alert_window_to_button(this,"编辑","书籍 ["+bookName+"] 正处于'在借中'状态，无法编辑！");
                return false;
            }else{
                empty_button_alert_window(this);
            }

            //1. 清空模态框
            reset_form("#update_book_modal form");
            //2. 查询所有书籍类型信息，显示在下拉列表中
            getBookTypes("#update_book_type_select");
            //3. 查询所有书架，显示在下拉列表中
            getAllBookCases("#update_book_case_select");
            //4. 获取当前时间，显示在录入时间input中
            $("#update_book_date_input").val(getFormatDate());
            //5. 将"edit-id"传到模态框的"更新"按钮上面
            $("#modal_update_book_info_button").attr("edit-id",$(this).attr("edit-id"));
            //6. 解析数据
            var bookId = $(this).attr("edit-id");
            getBookById(bookId);
            //6. 打开模态框
            $("#update_book_modal").modal({
                backdrop:"static"
            })
        });

        //根据Id读取图书信息
        function getBookById(bookId) {
            $.ajax({
                url:"${APP_PATH}/book/"+bookId,
                type:"GET",
                success:function (result) {
                    console.log(result);
                    var bookData = result.extend.book;
                    $("#update_book_info_name").val(bookData.bookName);
                    $("#update_book_info_author").val(bookData.bookAuthor);
                    $("#update_book_info_pdf").val(bookData.bookPdfurl);
                    $("#update_book_type_select").val(bookData.typeId);
                    $("#update_book_info_press").val(bookData.bookPress);
                    $("#update_book_case_select").val(bookData.bookCaseId);
                    $("#update_book_language_select").val(bookData.bookLanguage);
                    $("#update_book_manager_select").val(bookData.operatorId);
                    $("#update_book_price_input").val(bookData.bookPrice);
                }
            })
        }

        //点击"编辑模态框"中的"更新按钮"，更新图书信息数据
        $("#modal_update_book_info_button").click(function () {
            //1. 判断书名是否为空
            var bookName = $("#update_book_info_name").val();
            if(!validate_field_not_null("#update_book_info_name",bookName,"","书名不能为空！")){
                return false;
            }
            //2. 判断作者是否为空
            var bookAuthor = $("#update_book_info_author").val();
            if(!validate_field_not_null("#update_book_info_author",bookAuthor,"","作者名不能为空！")){
                return false;
            }
            //3. 判断出版社是否为空
            var bookPress = $("#update_book_info_press").val();
            if(!validate_field_not_null("#update_book_info_press",bookPress,"","出版社不能为空！")){
                return false;
            }
            //4. 判断价格是否为浮点数或者整数
            var reg = /^\d+(\.\d+)?$/;
            var bookPrice = $("#update_book_price_input").val();
            if (!reg.test(bookPrice)) {
                show_validate_msg("#update_book_price_input","error","价格必须是正浮点数！");
                return false;
            }
            else{
                show_validate_msg("#update_book_price_input","success","");
            }
            //5. 发送 ajax 请求进行保存
            $.ajax({
                url:"${APP_PATH}/book/"+$(this).attr("edit-id"),
                type:"PUT",
                data:$("#update_book_modal form").serialize(),
                success:function (result) {
                    if(result.code == 100){
                        //提示信息
                        alert(result.message);
                        //隐藏模态框
                        $("#update_book_modal").modal("hide");
                        //来到添加信息所在的页面
                        to_page(currentPage);
                    }else{
                        alert(result.message);
                    }
                }
            })
        })



        //为按钮添加提示框
        function add_alert_window_to_button(ele,operator,msg) {
            $(ele).attr("tabindex","0")
                .attr("data-trigger","focus")
                .attr("data-toggle","popover")
                .attr("title",operator+"失败")
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
    </script>
</body>
</html>
