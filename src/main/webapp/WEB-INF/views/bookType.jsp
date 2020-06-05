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
                            <p id="library_type_manage_p">图书类型管理</p>
                            <hr>
                        </div>
                        <div class="mainForm-body">
                            <div id="purpleBtn">
                                <button id="add_book_type_btn">添加图书类型</button>
                            </div>
                            <div id="tableClass">
                                <table id="book_type_table">
                                    <thead>
                                        <tr>
                                            <th>编号</th>
                                            <th>类型名称</th>
                                            <th>可借天数</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>100</td>
                                            <td>文学类</td>
                                            <td>30</td>
                                            <td><button>删除</button></td>
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

                                        <!--    新增图书类型模态框   -->
    <div id="add_book_type_modal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modal_add_book_type_title_label">添加图书类型</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="add_book_type_name_input" class="col-sm-3 control-label">☞ 图书类型名称：</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="add_book_type_name_input" name="typeName" placeholder="book type name ...">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add_book_type_to_borrow_days_input" class="col-sm-3 control-label">☞ 可借天数：</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" id="add_book_type_to_borrow_days_input" name="toborrowDays" placeholder="30">
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="modal_add_book_type_btn">添加</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->





    <!--- 以下是 JS 代码 -->
    <script type="text/javascript">

        var currentPage,totalNum;

        /*
        =======================================查===========================================
         */

        $(function () {
            to_page(1);
        });

        //来到第几页
        function to_page(pn) {
            $.ajax({
                url:"${APP_PATH}/bookTypes",
                type:"GET",
                data:"pn="+pn,
                success:function (result) {
                    console.log(result);
                    //1. 解析显示图书类型数据
                    build_bookType_table(result);
                    //2. 解析显示分页信息
                    build_page_info(result);
                    //3. 解析显示分页条
                    build_page_nav(result)
                }
            })
        }

        //1. 解析显示图书类型数据
        function build_bookType_table(result){
            //1-1 清空table
            $("#book_type_table tbody").empty();
            //1-2 获取数据
            var bookTypes = result.extend.pageInfo.list;
            //1-3 遍历数据，建立表格
            $.each(bookTypes,function (index,item) {
                //① 编号
                var bookTypeIdTd = $("<td></td>").append(item.typeId);
                //② 类型清楚
                var bookTypeNameTd = $("<td></td>").append(item.typeName);
                //③ 可借天数
                var toborrowDaysTd = $("<td></td>").append(item.toborrowDays+" (天)");
                //④ 删除按钮
                var deleteBookTypeBtn = $("<a style='margin: 3px'></a>").attr("role","button").addClass("btn btn-danger btn-sm delete_bookType_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
                deleteBookTypeBtn.attr("delete-id",item.typeId);
                var btnTd = $("<td></td>").append(deleteBookTypeBtn);

                //⑤一整行
                $("<tr></tr>").append(bookTypeIdTd)
                    .append(bookTypeNameTd)
                    .append(toborrowDaysTd)
                    .append(btnTd)
                    .appendTo("#book_type_table tbody");
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
        //点击"添加图书类型"
        $("#add_book_type_btn").click(function () {
            //1. 重置表单内容，不让数据跳过 ajax 校验，也重置表单样式
            reset_form("#add_book_type_modal form");
            //2. 弹出模态框
            $("#add_book_type_modal").modal({
                backdrop:"static"
            });

        });


        //重置表单
        function reset_form(ele) {
            //清空表单内容
            $(ele)[0].reset();
            //清空表单样式
            $(ele).find("*").removeClass("has-error has-success");
            $(ele).find(".help-block").text("");
        }

        //点击"模态框中"的"添加"按钮，添加"图书类型"
        $("#modal_add_book_type_btn").click(function () {
            //1. 检查图书类型名称是否为空
            var bookTypeName = $("#add_book_type_name_input").val();
            if(!validate_book_type_name_not_null(bookTypeName)){
                return false;
            }
            //2. 检查图书类型是否已经存在
            if(!validate_book_type_exists(bookTypeName)){
                return false;
            }
            //3. 检查可借天数是否正数
            var days = $("#add_book_type_to_borrow_days_input").val();
            if(!validate_book_to_borrow_days_positive(days)){
                return false;
            }
            //4. 发送 ajax 请求保存"图书类型"
            $.ajax({
                url:"${APP_PATH}/bookType",
                type:"POST",
                data:$("#add_book_type_modal form").serialize(),
                success:function (result) {
                    if(result.code == 100){
                        //提示成功
                        alert(result.message);
                        //关闭模态框
                        $("#add_book_type_modal").modal("hide");
                        //来到添加的那一页
                        to_page(totalNum);
                    }
                }
            })
        });

        //1. 检查图书类型名称是否为空
        function validate_book_type_name_not_null(name) {
            if(name !="" && name != null){
                show_validate_msg("#add_book_type_name_input","success","");
                return true;
            }else{
                show_validate_msg("#add_book_type_name_input","error","图书类型名称不能为空！");
                return false;
            }
        }
        //2. 检查图书类型是否存在
        function validate_book_type_exists(bookTypeName) {
            var not_exists = true;
            $.ajax({
                async:false,
                url:"${APP_PATH}/checkBookTypeName",
                type:"POST",
                data:"typeName="+bookTypeName,
                success:function (result) {
                    if(result.code == 100){
                        show_validate_msg("#add_book_type_name_input","success","图书类型名可用！");
                        not_exists = true;
                    }else{
                        show_validate_msg("#add_book_type_name_input","error","图书类型名已存在！");
                        not_exists = false;
                    }
                }
            });
            return not_exists;
        }

        //3. 检查可借天数是否正数
        function validate_book_to_borrow_days_positive(days) {
            if(parseInt(days) <= 0){
                show_validate_msg("#add_book_type_to_borrow_days_input","error","可借天数必须大于0！");
                return false;
            }else{
                show_validate_msg("#add_book_type_to_borrow_days_input","success","")
                return true;
            }
        }

        /*
       =======================================删===========================================
       */
        //点击删除按钮
        $(document).on("click",".delete_bookType_btn",function () {
            //1. 获取对应的图书类型信息
            var typeName = $(this).parents("tr").find("td:eq(1)").text();
            var typeId = $(this).attr("delete-id");

            //2. 查看是否有该类型的图书：有则不可删
            var count = validate_whether_book_is_this_type(typeId);
            if(count > 0){
                add_alert_window_to_button(this,count,typeName);
                $(this).popover({
                    placement:"bottom",
                    animation:"true"
                });
                return false;
            }

            //3. 执行删除
            if(confirm("你确定要删除 [ "+ typeName +" ] 吗？")){
                $.ajax({
                    url:"${APP_PATH}/bookType/"+typeId,
                    type:"DELETE",
                    success:function (result) {
                        if(result.code == 100){
                            //提示信息
                            alert(result.message);
                            //返回本页
                            to_page(currentPage);
                        }
                    }
                })
            }
        });


        //2. 查看是否有该类型的图书：有则不可删
        function validate_whether_book_is_this_type(typeId) {
            var count = 0;
            $.ajax({
                url:"${APP_PATH}/getBookCountByType",
                type:"GET",
                data:"typeId="+typeId,
                async:false,
                success:function (result) {
                    console.log(result);
                    count = result.extend.count;
                }
            });
            return count;
        }


        //按钮弹出警告窗口
        /*
        <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Vivamus
            sagittis lacus vel augue laoreet rutrum faucibus.">
            Popover on 底部
            </button>
         */
        function add_alert_window_to_button(ele,count,typeName) {
            $(ele).attr("tabindex","0")
                .attr("data-trigger","focus")
                .attr("data-toggle","popover")
                .attr("title","不可删除")
                .attr("data-content","当前还有 "+count +" 本书是 [ "+ typeName +" ] 类型的，若要删除本类型，请先删除属于本类型的书籍！");
        }

        //展示检验信息
        function show_validate_msg(ele,status,msg){
            $(ele).parent().removeClass("has-success has-error")
            if(status == "success"){
                $(ele).parent().addClass("has-success");
                $(ele).next("span").text(msg);
            }else if(status =="error"){
                $(ele).parent().addClass("has-error");
                $(ele).next("span").text(msg);
            }
        }
        
    </script>

</body>
</html>
