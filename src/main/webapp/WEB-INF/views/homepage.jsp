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
                            <p id="library_info_p">图书馆信息</p>
                            <hr>
                        </div>
                        <div class="mainForm-body" >
                                <div id="formContent">
                                    <form class="form-horizontal" id="homepage_form">
                                        <label for="libraryName">图书馆名称：</label>
                                        <div>
                                            <input type="text" id="libraryName" name="libraryName" readonly>
                                            <span id="library-name-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="libraryCurator">馆长：</label>
                                        <div>
                                            <input type="text" id="libraryCurator" name="libraryCurator">
                                            <span id="library-curator-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="library_telnumber">联系电话：</label>
                                        <div>
                                            <input type="text" id="library_telnumber" name="libraryTelnumber">
                                            <span id="library-telnumber-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="library_address">联系地址：</label>
                                        <div>
                                            <input type="text" id="library_address" name="libraryAddress">
                                            <span id="library-address-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="library_email">联系邮箱：</label>
                                        <div>
                                            <input type="text" id="library_email" name="libraryEmail">
                                            <span id="library-email-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="library_URL">图书馆网址：</label>
                                        <div>
                                            <input type="text" id="library_URL" name="libraryURL" readonly>
                                            <span id="library-URL-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="library_Building_date">建馆时间：</label>
                                        <div>
                                            <input type="text" id="library_Building_date" name="libraryBuildingDate" readonly>
                                            <span id="library-Building-date-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="library_info">图书馆简介：</label>
                                        <div>
                                            <textarea id="library_info" name="libraryInfo" class="form-control" rows="5" ></textarea>
                                            <span id="library-info-date-validate-msg" class="help-block"></span>
                                        </div>
                                        <button id="update_library_info_btn" href="#library_info_p">保存</button>
                                    </form>
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

    <script type="text/javascript">
        //页面一加载就执行 —— 读取信息
        $(function () {
            $.ajax({
                url:"${APP_PATH}/library",
                type:"GET",
                data:"libraryName="+"珞珈数字图书馆",
                success:function (result) {
                    // console.log(result);
                    $("#libraryName").val(result.extend.lib.libraryName);
                    $("#libraryCurator").val(result.extend.lib.libraryCurator);
                    $("#library_telnumber").val(result.extend.lib.libraryTelnumber);
                    $("#library_address").val(result.extend.lib.libraryAddress);
                    $("#library_email").val(result.extend.lib.libraryEmail);
                    $("#library_URL").val(result.extend.lib.libraryUrl);
                    $("#library_Building_date").val(result.extend.lib.libraryBuildingDate);
                    $("#library_info").val(result.extend.lib.libraryInfo);
                }
            })
        })
        
        
        //更改图书馆基本信息
        $("#update_library_info_btn").click(function () {
            //0. 检验馆长
            var curator = $("#libraryCurator").val();
            var curatorRegx = /(^[a-zA-Z0-9_-]{5,16}$)|(^[\u2E80-\u9FFF]{3,5}$)/
            if(!validate_standard("#libraryCurator",curator,curatorRegx,"","馆长名称必须为5-16个数字和字母的组合或者3-5位中文")){
                return false;
            };
            //1. 检验电话
            var phone = $("#library_telnumber").val();
            var phoneRegx = /^[0-9]{11,16}$/
            if(!validate_standard("#library_telnumber",phone,phoneRegx,"","请输入11-16位纯数字的电话号码！")){
                return false;
            }
            //2. 检验地址
            var address = $("#library_address").val();
            var addressRegx = /\S/
            if(!validate_standard("#library_address",address,addressRegx,"","地址不能为空！")){
                return false;
            }
            //3. 检验邮箱
            var email = $("#library_email").val();
            var emailRegx = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
            if(!validate_standard("#library_email",email,emailRegx,"","邮箱格式不正确!")){
                return false;
            }
            //4. 检验简介
            var descp = $("#library_info").val();
            var descpRegx = /\S/;
            if(!validate_standard("#library_info",descp,descpRegx,"","简介不能为空！")){
                return false;
            }
            //5. 发送 ajax 请求
            $.ajax({
                url:"${APP_PATH}/library/"+$("#libraryName").val(),
                type:"PUT",
                data:$("#formContent form").serialize(),
                success:function (result) {
                    if(result.code == 100){
                        alert("修改成功！");
                        window.location.href="${APP_PATH}/homepage";
                    }else{
                        alert("修改失败！");
                    }

                }
            })
        })


        //检验信息的合法性
        function validate_standard(ele,info,regExpm,success_msg,error_msg){
            if(!regExpm.test(info)){
                show_validate_msg(ele,"error",error_msg);
                return false;
            }
            else{
                show_validate_msg(ele,"error",success_msg);
                return true;
            }
        }

        //显示检验信息
        function show_validate_msg(ele,status,msg) {
            //清楚父元素样式，防止叠加
            $(ele).parent().removeClass("has-success has-error")
            //判断状态
            if(status == "success"){
                $(ele).parent().addClass("has-success")
                $(ele).next("span").text(msg);
            }else if(status == "error"){
                $(ele).parent().addClass("has-error")
                $(ele).next("span").text(msg);
            }
        }
    </script>
</body>
</html>
