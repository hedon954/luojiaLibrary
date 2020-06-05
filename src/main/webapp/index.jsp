<%--
  Created by IntelliJ IDEA.
  User: hedon-
  Date: 2020-05-25
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath()); //以 "/"开始，不以 "/" 结束
        session.removeAttribute("loginName");
    %>
    <meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
    <link rel="icon" href="${APP_PATH}/static/images/Title.png" type="image/x-icon"/>
    <title>珞珈图书馆 登录</title>
    <!-- 引入 jQuery，要在引入 Bootstrap 之前 -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.11.3.js"></script>
    <!-- 引入 Bootstrap 的 js 文件 -->
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <!-- 引入 Bootstrap 的 css 文件 -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入自定义的 css 文件-->
    <link href="${APP_PATH}/static/css/login.css" rel="stylesheet">
</head>
<body>
    <div id = "login" class="bgd">
        <div class="login-window">
            <div id="header">
                <div id="register"></div>
            </div>
            <div id="body">
                <div id="UserPic" class="icon"></div>
                <form class="form-horizontal">
                    <div class="form-group">
                        <div id="user-id" class="icon col-sm-2"></div>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="login-managerName-input" placeholder="Username">
                            <span id="login-managerName-validate-msg" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="user-pswd" class="icon col-sm-2"></div>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="login-managerPwd-input" placeholder="Password">
                            <span id="login-managerPwd-validate-msg" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="save">
                            <a href="#">
                                <img src="${APP_PATH}/static/images/login.png">
                            </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- 模态框 -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">管理员注册</h4>
                </div>
                <!--模态框内容-->
                <div class="modal-body">
                        <form class="form-horizontal">
                            <!-- 1. managerName -->
                            <label for="manager_name_input">名称：</label>
                            <div>
                             <input type="text" class="form-control" id="manager_name_input" name="managerName" placeholder="managerName">
                                <span id="manager-name-validate-msg" class="help-block"></span>
                             </div>
                            <!-- 2. managerPwd -->
                            <label for="manager_password_input">密码：</label>
                            <div>
                                <input type="password" class="form-control" id="manager_password_input" name="managerPwd" placeholder="managerPwd">
                                <span id="manager-validate-msg" class="help-block"></span>
                            </div>
                            <!-- 3. confirmManagerPwd -->
                            <label for="confirm_password_input">确认密码：</label>
                            <div>
                                <input type="password" class="form-control" id="confirm_password_input" name="confirmPwd" placeholder="confirmPwd">
                                <span id="confirm-password-validate-msg" class="help-block"></span>
                            </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="register_manager_btn">注册</button>
                </div>
            </div>
        </div>
    </div>

                                      <!-- 以下是 JS 代码 -->
    <script type="text/javascript">
        var acceptThrough = "";

        //页面加载完成
        $(function () {


        })
        //1. 为登录按钮绑定单击事件
        $("#save").click(function () {
            // alert("hhh");
            //1-1. 检验用户名是否存在
            var managerName = $("#login-managerName-input").val();
            validate_managerName_exists(managerName,"login");
            //1-2. 检验用户名和密码是否对应上
            var managerPwd = $("#login-managerPwd-input").val();
            validate_managerPwd_right(managerName,managerPwd)

        })

        //1-1 检验用户名是否存在
        function validate_managerName_exists(managerName,loginOrRegister) {
            $.ajax({
                async: false,
                url:"${APP_PATH}/checkManagerNameExists",
                data:"managerName="+ managerName,
                type:"POST",
                success:function (result) {
                    if(result.code==100){
                        if(loginOrRegister == "login")
                        {
                            show_validate_msg("#login-managerName-input","success","");
                            acceptThrough = "true";
                        }else{
                            show_validate_msg("#manager_name_input","error",result.extend.va_register_name_msg);
                            acceptThrough = "false";
                        }
                    }else{
                        if(loginOrRegister == "login")
                        {
                            show_validate_msg("#login-managerName-input","error",result.extend.va_login_name_msg);
                            acceptThrough = "false";
                        }else{
                            show_validate_msg("#manager_name_input","success",result.extend.va_register_name_msg);
                            acceptThrough = "true";
                        }
                    }
                }
            });
            if(acceptThrough == "false"){
                return false;
            }else{
                return true;
            }
        }

        //1-2 检查密码是否正确
        function validate_managerPwd_right(managerName,managerPwd){
            $.ajax({
                url:"${APP_PATH}/checkManagerPwd",
                data:"managerName="+managerName+"&managerPwd="+managerPwd,
                type:"GET",
                success:function (result) {
                    if(result.code == 100){
                        show_validate_msg("#login-managerPwd-input","success","");
                        $("#save").prop("ajax-va","success");
                        window.location.href="${APP_PATH}/bookRank";
                    }else{
                        show_validate_msg("#login-managerPwd-input","error",result.extend.va_pwd_msg);
                        $("#save").prop("ajax-va","error");
                    }
                }
            })
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


        //2. 点击注册
        $("#register").click(function () {
            //2-1. 弹出模态框
            $("#registerModal").modal({
                backdrop:"static"
            });

        });

        //3. 确认"注册"按钮
        $("#register_manager_btn").click(function () {
            //3-1. 检验用户名是否符合规范
            var managerName =  $("#manager_name_input").val();
            if(!validate_name_standard(managerName)){
                return false;
            }
            //3-2. 检验用户名是否存在
            if(!validate_managerName_exists(managerName,"register")){
                return false;
            }
            //3-3. 检验密码是否符合规范
            var managerPwd = $("#manager_password_input").val();
            if(!validate_pwd_standard(managerPwd)){
                return false;
            }
            //3-4. 检验两次密码是否相同
            var confirmPwd = $("#confirm_password_input").val();
            if((confirmPwd == managerPwd)&&(confirmPwd != null)){   //相等也不为空
                //3-5. 发送 Ajax 请求添加管理员
                $.ajax({
                    url:"${APP_PATH}/manager",
                    type:"POST",
                    data:$("#registerModal form").serialize(),
                    success:function (result) {
                        if(result.code == 100){
                            console.log(result);
                            alert("注册成功！");
                            $("#registerModal").modal("hide");
                            window.location.href = "index.jsp";
                        }
                    }
                })
            }else{
                show_validate_msg("#confirm_password_input","error","两次密码不相同，请重新输入！");
                return false;
            }
        })


        //3-1 检验用户名是否符合规范
        function validate_name_standard(managerName){
            // //① 获取 managerName
            // var managerName = $("#manager_name_input").val();
            //② 定义正则表达式:5-16个数字和字母组合或3-5个中文
            var managerNameRegex =  /(^[a-zA-Z0-9_-]{5,16}$)|(^[\u2E80-\u9FFF]{3,5}$)/
            //③ 判断
            if(!managerNameRegex.test(managerName)){
                show_validate_msg("#manager_name_input","error","用户名必须是5-16个数字和字母的组合或者3-5个中文");
                return false;
            }else{
                show_validate_msg("#manager_name_input","success","");
                return true;
            }
        }
        //3-3 检验密码是否符合规范
        function validate_pwd_standard(managerPwd){
            // //1. 获取密码
            // var managerPwd = $("#manager_password_input").val();
            //2. 设置正则表达式
            var regExp = /^[a-zA-Z0-9_-]{6,16}$/       //6-16位数字和字母的组合
            //3. 判断是否符合正则表达式
            if(!regExp.test(managerPwd)){
                show_validate_msg("#manager_password_input","error","密码必须是6-16位数字和密码的组合！");
                $("#manager_password_input").attr("through","error");
                return false;
            }else{
                show_validate_msg("#manager_password_input","success","");
                $("#manager_password_input").attr("through","success");
                return true;
            }
        }

    </script>
</body>
</html>
