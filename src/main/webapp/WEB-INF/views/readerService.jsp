<%@ page import="java.util.UUID" %><%--
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
                            <p id="reader_service_title">读者服务</p>
                            <hr>
                        </div>
                        <div class="mainForm-body">
                            <div id="purpleBtn">
                                <button id="add_reader_btn">添加读者</button>
                            </div>
                            <div id="tableClass" style="width: 96%">
                                <table id="readers_table" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>条形码</th>
                                        <th>职业</th>
                                        <th>证件类型</th>
                                        <th>证件号码</th>
                                        <th>电子邮箱</th>
                                        <th>总借数</th>
                                        <th>可借数</th>
                                        <th>登记日期</th>
                                        <th>操作员</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="readers_table_body">
                                        <tr>
                                            <td>100</td>
                                            <td>Hedon</td>
                                            <td>男</td>
                                            <td>abcdefghijk</td>
                                            <td>学生</td>
                                            <td>居民身份证</td>
                                            <td>440583120003033030</td>
                                            <td>ab1eb7a@whu.edu.cn</td>
                                            <td>10</td>
                                            <td>20</td>
                                            <td>2020-05-30</td>
                                            <td>王佳翰</td>
                                            <td>
                                                <button class="btn btn-info btn-xs">编辑</button>
                                                <button class="btn btn-danger btn-xs">删除</button>
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

                                                        <!-- 新增模态框 -->
    <div class="modal fade" id="addReaderModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加读者</h4>
                </div>
                <!--模态框内容-->
                <div class="modal-body">
                    <form class="form-horizontal" id="add_reader_modal_form">
                            <!-- 1. 名称 -->
                            <div>
                                <label for="add_reader_name_input">☞ 名称：</label>
                                <div>
                                    <input type="text" class="form-control" id="add_reader_name_input" name="readerName" placeholder="readerName">
                                    <span id="reader-name-validate-msg" class="help-block"></span>
                                </div>
                            </div>
                            <!-- 2. 性别 -->
                            <div>
                                <label>☞ 性别：</label>
                                <label class="radio-inline">
                                    <input type="radio" name="readerGender" id="reader_gender1_add_input" value="男" checked="checked"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="readerGender" id="reader_gender2_add_input" value="女"> 女
                                </label>
                            </div>
                            <!-- 3. 职业 -->
                            <div>
                                <label for="reader_job_select">☞ 职业：</label>
                                <select class="form-control" id="reader_job_select" name="readerProfession">
                                    <option value="学生">学生</option>
                                    <option value="教师">教师</option>
                                </select>
                            </div>
                            <!-- 4. 证件类型：根据前面选的职业自动确定为：居民身份证还是学生证-->
                            <div>
                                <label for="add_reader_document_type_input">☞ 证件类型：</label>
                                <select class="form-control" id="add_reader_document_type_input" name="readerDocumentType">
                                    <option value="学生证">学生证</option>
                                    <option value="居民身份证">居民身份证</option>
                                </select>
<%--                                <input id="add_reader_document_type_input" name="readerDocumentType" type="text" class="form-control" placeholder="证件类型：根据职业会自动确定...">--%>
                            </div>
                            <!-- 5. 证件号码：根据前面的证件类型来确定号码的位数-->
                            <div>
                                <label for="add_reader_document_number_input">☞ 证件号码：</label>
                                <input id="add_reader_document_number_input" name="readerDocumentNumber" class="form-control" type="text" placeholder="学生证：13位；居民身份证：18位...">
                                <span id="add-reader-document-number-validate-msg" class="help-block"></span>
                            </div>
                            <!-- 6. 电子邮箱-->
                            <div>
                                <label for="add_reader_email_input">☞ 电子邮箱：</label>
                                <input id="add_reader_email_input" name="readerEmail" class="form-control" type="email" placeholder="请输入读者的邮箱......">
                                <span id="add-reader-email-validate-msg" class="help-block"></span>
                            </div>
                            <div>
                                <label for="reader_operator_id_select">☞ 操作员ID：</label>
                                <select class="form-control" id="reader_operator_id_select" name="operatorId">
                                    <option value="1">王佳翰</option>
                                    <option value="2">邱景妍</option>
                                    <option value="3">周妍</option>
                                    <option value="4">张嘉程</option>
                                </select>
                            </div>
                            <!-- 7. 自动生成条形码 -->
                            <div>
                                <label style="margin-bottom: 15px;">◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ 以下内容自动生成 ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇</label>
                            </div>
                            <div>
                                <label for="add_reader_readerBarcode">☞ 条形码：</label>
                                <input style="margin-bottom: 10px" id="add_reader_readerBarcode" class="form-control" type="text" name="readerBarcode" readonly>
                            </div>
                            <div>
                                <label for="add_reader_readerRegisterDate">☞ 登记时间：</label>
                                <input style="margin-bottom: 10px" id="add_reader_readerRegisterDate" class="form-control" type="date" name="readerRegisterDate">
                            </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="modal_add_reader_btn">添加</button>
                </div>
            </div>
        </div>
    </div>

                                                 <!-- 编辑模态框 -->
    <div class="modal fade" id="updateReaderModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myUpdateModalLabel">编辑读者</h4>
                </div>
                <!--模态框内容-->
                <div class="modal-body">
                    <form class="form-horizontal" id="update_reader_modal_form">
                        <!-- 1. 名称 -->
                        <div>
                            <label for="update_reader_name_input">☞ 名称：</label>
                            <div>
                                <input type="text" class="form-control" id="update_reader_name_input" name="readerName" placeholder="readerName">
                                <span id="update-reader-name-validate-msg" class="help-block"></span>
                            </div>
                        </div>
                        <!-- 2. 性别 -->
                        <div>
                            <label>☞ 性别：</label>
                            <label class="radio-inline">
                                <input type="radio" name="readerGender" id="reader_gender1_update_input" value="男" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="readerGender" id="reader_gender2_update_input" value="女"> 女
                            </label>
                        </div>
                        <!-- 3. 职业 -->
                        <div>
                            <label for="update_reader_job_select">☞ 职业：</label>
                            <select class="form-control" id="update_reader_job_select" name="readerProfession">
                                <option value="学生">学生</option>
                                <option value="教师">教师</option>
                            </select>
                        </div>
                        <!-- 4. 证件类型：根据前面选的职业自动确定为：居民身份证还是学生证-->
                        <div>
                            <label for="update_reader_document_type_input">☞ 证件类型：</label>
                            <select class="form-control" id="update_reader_document_type_input" name="readerDocumentType">
                                <option value="学生证">学生证</option>
                                <option value="居民身份证">居民身份证</option>
                            </select>
                        </div>
                        <!-- 5. 证件号码：根据前面的证件类型来确定号码的位数-->
                        <div>
                            <label for="update_reader_document_number_input">☞ 证件号码：</label>
                            <input id="update_reader_document_number_input" name="readerDocumentNumber" class="form-control" type="text" placeholder="学生证：13位；居民身份证：18位...">
                            <span id="update-reader-document-number-validate-msg" class="help-block"></span>
                        </div>
                        <!-- 6. 电子邮箱-->
                        <div>
                            <label for="update_reader_email_input">☞ 电子邮箱：</label>
                            <input id="update_reader_email_input" name="readerEmail" class="form-control" type="email" placeholder="请输入读者的邮箱......">
                            <span id="update-reader-email-validate-msg" class="help-block"></span>
                        </div>
                        <div>
                            <label for="update_reader_operator_id_select">☞ 操作员ID：</label>
                            <select class="form-control" id="update_reader_operator_id_select" name="operatorId">
                                <option value="1">王佳翰</option>
                                <option value="2">邱景妍</option>
                                <option value="3">周妍</option>
                                <option value="4">张嘉程</option>
                            </select>
                        </div>
                        <div>
                            <label for="update_reader_readerRegisterDate">☞ 登记时间：</label>
                            <input style="margin-bottom: 10px" id="update_reader_readerRegisterDate" class="form-control" type="date" name="readerRegisterDate">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="modal_update_reader_btn">保存</button>
                </div>
            </div>
        </div>
    </div>



                                            <!-- 以下是 JS 代码 -->
    <script type="text/javascript">
        var currentPage,totalNum;

        /*
        =======================================查===========================================
         */
        //页面一加载就去第 1 页
        $(function () {
            to_page(1);
        })

        //去往第几页
        function to_page(pn){
            $.ajax({
                url:"${APP_PATH}/readers",
                type:"GET",
                data:"pn="+pn,
                success:function (result) {
                    console.log(result);
                    //1. 解析并显示读者数据
                    build_reader_table(result);
                    //2. 解析并显示分页信息
                    build_page_info(result);
                    //3. 解析并显示分页条数据
                    build_page_nav(result);
                }
            })
        }

        //1. 解析并显示读者数据
        function build_reader_table(result){
            //1-1 清空table
            $("#readers_table tbody").empty();
            //1-2 获取请求体中的 readers
            var readers = result.extend.pageInfo.list;
            //1-3 遍历 readers
            $.each(readers,function (index,item) {
                //① 编号
                var readerIdTd = $("<td></td>").append(item.readerId);
                //② 名称
                var readerNameTd = $("<td></td>").append(item.readerName);
                //③ 性别
                var readerGenderTd = $("<td></td>").append(item.readerGender);
                //④ 条形码
                var readerBarCodeTd = $("<td></td>").append(item.readerBarcode);
                //⑤ 职业
                var readerJobTd = $("<td></td>").append(item.readerProfession);
                //⑥ 证件类型
                var documentTypeTd = $("<td></td>").append(item.readerDocumentType);
                //⑦ 证件号码
                var documentNumberId = $("<td></td>").append(item.readerDocumentNumber);
                //⑧ 电子邮箱
                var readerEmailTd = $("<td></td>").append(item.readerEmail);
                //⑨ 总借数
                var borrowedBookCountTd = $("<td></td>").append(item.borrowedBookCount);
                //⑩ 可借数
                var remainingBookCountTd = $("<td></td>").append(item.remainingBookCount);
                //11 登记日期
                var readerRegisterDateTd = $("<td></td>").append(item.readerRegisterDate);
                //12 操作员
                var opearatorNameTd = $("<td></td>").append(item.manager.managerName);
                //13 两个按钮
                var editBtn = $("<button></button>").addClass("btn btn-info btn-xs edit_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
                        //为按钮绑定id，便于后续操作
                editBtn.attr("edit-id",item.readerId);

                var span = $("<span></span>").append(" ");

                var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-xs delete_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
                        //为按钮绑定id，便于后续操作
                deleteBtn.attr("delete-id",item.readerId);
                var btnTd = $("<td></td>").append(editBtn).append(span).append(deleteBtn);

                //整行
                $("<tr></tr>").append(readerIdTd)
                    .append(readerNameTd)
                    .append(readerGenderTd)
                    .append(readerBarCodeTd)
                    .append(readerJobTd)
                    .append(documentTypeTd)
                    .append(documentNumberId)
                    .append(readerEmailTd)
                    .append(borrowedBookCountTd)
                    .append(remainingBookCountTd)
                    .append(readerRegisterDateTd)
                    .append(opearatorNameTd)
                    .append(btnTd)
                    .appendTo("#readers_table tbody")
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
        =============================================================增================================================
         */

        //点击"添加读者"按钮，弹出模态框
        $("#add_reader_btn").click(function () {
            //重置表单内容，不让数据跳过 ajax 校验，也重置表单样式
            reset_form("#addReaderModal form");

            //弹出模态框
            $("#addReaderModal").modal({
                backdrop:"static"
            });

            //6. 自动生成条形码
            var barCode = randomNumber();
            $("#add_reader_readerBarcode").val(barCode);
            //7. 获取当前时间
            // var now = new Date();
            // $("#add_reader_readerRegisterDate").val(now);
            //8. 获取操作员 ID

        });

        //重置表单
        function reset_form(ele){
            //清空表单内容
            $(ele)[0].reset();
            //清空表单样式
            $(ele).find("*").removeClass("has-error has-success");
            $(ele).find(".help-block").text("");
        }


        //随机生成流水线
        function randomNumber() {
            var words = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"];
            var now = new Date();
            var minutes = now.getMinutes();
            var seconds = now.getSeconds();
            return words[randomRange(0,words.length-1)]+
                words[randomRange(0,words.length-1)]+
                minutes + seconds + (Math.round(Math.random() * 89 + 10)).toString()
        }

        //获得指定范围内的随机数
        function randomRange(myMin, myMax) {
            return Math.floor(Math.random()*(myMax - myMin + 1)) + myMin;
        }

        //点击模态框中的"添加"按钮保存读者
        $("#modal_add_reader_btn").click(function () {
            //1. 检验姓名是否为空
            var name = $("#add_reader_name_input").val();
            if(!validate_name_not_null(name,"#add_reader_name_input")){
                return false;
            }
            //2. 根据职业类型确定证件类型
            //3. 根据证件类型确定证件号码约束
            var document_type = $("#add_reader_document_type_input").find("option:selected").text();
            //4. 检验证件号码是否合格
            var document_number = $("#add_reader_document_number_input").val();
            if(!validate_document_number(document_type,document_number,"#add_reader_document_number_input")){
                return false;
            }
            //5. 检验邮箱是否规范
            var email = $("#add_reader_email_input").val();
            if(!validate_email_standard(email,"#add_reader_email_input")){
                return false;
            }

            //9. 发送 ajax 请求保存读者
            $.ajax({
                url:"${APP_PATH}/reader",
                type:"POST",
                data: $("#addReaderModal form").serialize(),
                success:function (result) {
                    if(result.code == 100){
                        console.log(result);
                        alert("添加读者成功！");
                        //隐藏模态框
                        $("#addReaderModal").modal("hide");
                        //跳转到添加的读者所在的页
                        to_page(totalNum);
                    }
                }
            })
        });

        
        //1. 检验姓名是否为空
        function validate_name_not_null(name,ele) {
            if(name == "" || name == null){
                show_validate_msg(ele,"error","名称不能为用！");
                return false;
            }else{
                show_validate_msg(ele,"success","");
                return true;
            }
        }
        //2. 根据职业类型确定证件类型
        $("#reader_job_select").change(function () {
            //获取选中的值
            var job = $(this).find("option:selected").text();
            if(job == "学生"){
                $("#add_reader_document_type_input").val("学生证");
            }else if(job == "教师"){
                $("#add_reader_document_type_input").val("居民身份证");
            }
        });
        //3. 根据证件类型确定证件号码约束
        //4. 检验证件号码是否合格
        function validate_document_number(document_type,document_number,ele){
            if(document_type == "学生证")
            {
                var regExp1 = /^[0-9]{13}$/
                if(!regExp1.test(document_number)){
                    show_validate_msg(ele,"error","请输入13位的纯数字学生证号！");
                    return false;
                }else{
                    show_validate_msg(ele,"success","");
                    return true;
                }
            }else if(document_type == "居民身份证"){
                var regExp2 = /^[a-zA-Z0-9]{18}$/
                if(!regExp2.test(document_number)){
                    show_validate_msg(ele,"error","请输入18位的由数字和字母组合的居民身份证号！");
                    return false;
                }else{
                    show_validate_msg(ele,"success","");
                    return true;
                }
            }
        }
        //5. 检验邮箱是否规范
        function validate_email_standard(email,ele){
            var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
            if(!regEmail.test(email)){
                show_validate_msg(ele,"error","邮箱格式错误！")
                return false;
            }else{
                show_validate_msg(ele,"success","")
                return true;
            }
        }
        //7. 获取当前时间
        //8. 发送 ajax 请求保存读者
        
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


        //点击删除按钮，删除对应的读者
        $(document).on("click",".delete_btn",function () {
            var readerName = $(this).parents("tr").find("td:eq(1)").text();
            var readerId = $(this).attr("delete-id");
            if(confirm("你确定要删除 [ "+ readerName +" ] 吗？")){
                $.ajax({
                    url:"${APP_PATH}/reader/" + readerId,
                    type:"DELETE",
                    success:function (result) {
                        alert(result.message);
                        //返回本页
                        to_page(currentPage);
                    }
                })
            }
        })

        /*
        =======================================改===========================================
         */
        // 点击"编辑按钮"，弹出模态框
        $(document).on("click",".edit_btn",function () {
            //0. 重置表单
            reset_form("#updateReaderModal form");
            //1. 读取数据
            var readerId = $(this).attr("edit-id");
            getReaderById(readerId);
            //2. 弹出模态框
            $("#updateReaderModal").modal({
                backdrop:"static"
            })
            //3. 把员工ID传给模态框中的"保存"按钮
            $("#modal_update_reader_btn").attr("edit-id",$(this).attr("edit-id"));
        })

        
        //查出读者信息
        function getReaderById(id) {
            $.ajax({
                url:"${APP_PATH}/reader/"+id,
                type:"GET",
                success:function (result) {
                    console.log(result);
                    var readerData = result.extend.reader;
                    $("#update_reader_name_input").val(readerData.readerName);
                    $("#updateReaderModal input[name=readerGender]").val([readerData.readerGender]);
                    $("#update_reader_job_select").val(readerData.readerProfession);
                    $("#update_reader_document_type_input").val(readerData.readerDocumentType);
                    $("#update_reader_document_number_input").val(readerData.readerDocumentNumber);
                    $("#update_reader_email_input").val(readerData.readerEmail);
                    $("#update_reader_operator_id_select").val(readerData.operatorId);
                    $("#update_reader_readerRegisterDate").val(readerData.readerRegisterDate);
                }
            })
        }

        //2. 根据职业类型确定证件类型
        $("#update_reader_job_select").change(function () {
            //获取选中的值
            var job = $(this).find("option:selected").text();
            if(job == "学生"){
                $("#update_reader_document_type_input").val("学生证");
            }else if(job == "教师"){
                $("#update_reader_document_type_input").val("居民身份证");
            }
        });
        
        //点击"编辑模态框"中的"保存"按钮，更新读者信息
        $("#modal_update_reader_btn").click(function () {
            //1. 检查姓名是否为空
            var updateName = $("#update_reader_name_input").val();
            if(!validate_name_not_null(updateName,"#update_reader_name_input")){
                return false;
            }
            //2. 检查证件号码是否规范
            var updateDocumentType = $("#update_reader_document_type_input").find("option:selected").text();
            var updateDocumentNumber = $("#update_reader_document_number_input").val();
            if(!validate_document_number(updateDocumentType,updateDocumentNumber,"#update_reader_document_number_input")){
                return false;
            }
            //3. 检查邮箱是否合法
            var updateEmail = $("#update_reader_email_input").val();
            if(!validate_email_standard(updateEmail,"#update_reader_email_input")){
                return false;
            }
            //4. 发送 ajax 请求更新读者
            $.ajax({
                url:"${APP_PATH}/reader/"+$(this).attr("edit-id"),
                type:"PUT",
                data:$("#updateReaderModal form").serialize(),
                success:function (result) {
                    alert(result.message);
                    // 关闭模态框
                    $("#updateReaderModal").modal("hide");
                    // 来到更改的数据所在的页面
                    to_page(currentPage);
                }
            })
        })
    </script>
</body>
</html>
