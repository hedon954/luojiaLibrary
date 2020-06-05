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
    <title>修改密码</title>
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
                            <p>修改密码</p>
                            <hr>
                        </div>
                        <div class="mainForm-body">
                                <div id="formContent">
                                    <form id="change-Manger-Pwd-form">
                                        <label for="manager_name_input">管理员名称：</label>
                                        <div>
                                            <input type="text" class="form-control" id="manager_name_input" name="managerName">
                                            <span id="manager-name-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="previous_manager_password_input">原密码：</label>
                                        <div>
                                            <input type="text" class="form-control" id="previous_manager_password_input" name="managerPwd">
                                            <span id="previous-manager-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="new_manager_password_input">新密码：</label>
                                        <div>
                                            <input type="password" class="form-control" id="new_manager_password_input" name="newPwd1st">
                                            <span id="new-manager-validate-msg" class="help-block"></span>
                                        </div>
                                        <label for="confirm_new_password_input">确认新密码：</label>
                                        <div>
                                            <input type="password" class="form-control" id="confirm_new_password_input" name="newPwd2rd">
                                            <span id="confirm-new-password-validate-msg" class="help-block"></span>
                                        </div>
                                        <button id="update_manager_password_btn" >保存</button>
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

</body>
<script type="text/javascript">
    var acceptChange = "error";
    $(function () {
        $("#update_manager_password_btn").click(function () {

            var managerName = $("#manager_name_input").val();
            //1. 检验用户名是否存在
            if(!validate_managerName_exists(managerName)){
                return false;
            }

            var oldPwd = $("#previous_manager_password_input").val();
            //2. 判断原密码是否正确
            if(!validate_managerPwd_right(managerName,oldPwd)){
                return false;
            }

            var newPwd1st = $("#new_manager_password_input").val();
            //3. 判断新密码是否符合规范
            if(!validate_pwd()){
                return false;
            }

            var newPwd2rd = $("#confirm_new_password_input").val();
            //4. 判断双次密码是否相同
            if((newPwd1st != newPwd2rd) && (newPwd2rd !="") &&(newPwd2rd!=null) && (newPwd2rd!=undefined)){
                show_validate_msg("#confirm_new_password_input","error","两次密码不一致！");
                return false;
            }
            else{
                show_validate_msg("#confirm_new_password_input","success","");
                $.ajax({
                    url:"${APP_PATH}/changeManagerPwd",
                    type:"POST",
                    data:"managerName="+managerName+"&newPwd2rd="+newPwd2rd,
                    success:function (result) {
                        if(result.code == 100){
                            alert("更新密码成功！");
                            window.location.href="${APP_PATH}/changePwd";
                        }else{
                            alert("更新密码失败！");
                        }
                    }
                })
            }

        });
    });




    //1-1 检验用户名是否存在
    function validate_managerName_exists(managerName) {
        $.ajax({
            async: false,
            url:"${APP_PATH}/checkManagerNameExists",
            data:"managerName="+ managerName,
            type:"POST",
            success:function (result) {
                if(result.code==100){
                    show_validate_msg("#manager_name_input","success","");
                    $("#update_manager_password_btn").attr("through","success");
                    acceptChange = "success";
                }else{
                    show_validate_msg("#manager_name_input","error",result.extend.va_login_name_msg);
                    $("#update_manager_password_btn").attr("through","error");
                    acceptChange = "error";
                }
            }
        });

        if(acceptChange == "error"){
            return false;
        }else{
            return true;
        }
    }

    //1-2 检查原密码是否正确
    function validate_managerPwd_right(managerName,managerPwd){
        $.ajax({
            async: false,
            url:"${APP_PATH}/checkManagerPwd",
            data:"managerName="+managerName+"&managerPwd="+managerPwd,
            type:"GET",
            success:function (result) {
                if(result.code == 100){
                    show_validate_msg("#previous_manager_password_input","success","");
                    $("#update_manager_password_btn").attr("through","success");
                    acceptChange = "success";
                }else{
                    show_validate_msg("#previous_manager_password_input","error",result.extend.va_pwd_msg);
                    $("#update_manager_password_btn").attr("through","error");
                    acceptChange = "error";
                }
            }
        });
        if(acceptChange == "error"){
            return false;
        }else{
            return true;
        }
    }

    //1-3 检验密码格式是否正确
    function validate_pwd(){
        //1. 获取密码
        var newPwd = $("#new_manager_password_input").val();
        //2. 设置正则表达式
        var regExp = /^[a-zA-Z0-9_-]{6,16}$/       //6-16位数字和字母的组合
        //3. 判断是否符合正则表达式
        if(!regExp.test(newPwd)){
            show_validate_msg("#new_manager_password_input","error","密码必须是6-16位数字和字母的组合！");
            $("#update_manager_password_btn").attr("through","error");
            return false;
        }else{
            show_validate_msg("#new_manager_password_input","success","");
            $("#update_manager_password_btn").attr("through","success");
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
</html>
