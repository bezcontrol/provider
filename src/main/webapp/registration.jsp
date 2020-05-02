<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:set var="title" value="Sign Up" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="resources/img/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap-reboot.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/lib/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/lib/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/lib/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/lib/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/lib/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/lib/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/lib/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/login/custom/util.css">
    <link rel="stylesheet" type="text/css" href="resources/css/login/custom/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100" style="background-image: url('resources/img/bg-01.jpg');">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
            <form class="login100-form validate-form" action="authentication" method="post" name="form">
                <input type="hidden" name="command" value="registration"/>
					<span class="login100-form-title p-b-49">
						<fmt:message key="sign_up.sign_up"/>
					</span>

                <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is required">
                    <span class="label-input100"><fmt:message key="username"/></span>
                    <input class="input100" type="text" name="login" placeholder="Login">
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input m-b-23" data-validate = "Email is required">
                    <span class="label-input100"><fmt:message key="email"/></span>
                    <input class="input100" type="email" name="email" id="email" placeholder="Email"/>
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>


                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <span class="label-input100"><fmt:message key="sign_up.password"/></span>
                    <input class="input100" type="password" name="password" id="password" placeholder="Password">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <span class="label-input100"><fmt:message key="sign_up.password_confirm"/></span>
                    <input class="input100" type="password" name="re_pass" id="confirm_password" placeholder="Confirm your password">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>

                <div class="m-t-15 container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" type="submit" onclick="CheckPassword(document.form.password)">
                            <fmt:message key="sign_up.btn.sign_up"/>
                        </button>
                    </div>
                </div>

                <c:choose>
                    <c:when test="${requestScope.error.length()>0}">
                        <div class="m-t-15  alert alert-danger alert-dismissible">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                ${requestScope.error}
                        </div>
                    </c:when>
                    <c:when test="${requestScope.errorValidation.length()>0}" >
                        <div class="m-t-15 alert alert-danger alert-dismissible">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                ${requestScope.errorValidation}
                        </div>
                    </c:when>
                </c:choose>
                <div class="text-center p-t-8 p-b-31">
                    <a href="jsp/services.jsp">
                        <fmt:message key="sign_up.btn.without_login"/>
                    </a>
                </div>

                <div class="container-login100-form-btn p-t-15">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" onclick="location.href='index.jsp'">
                            <fmt:message key="back"/>
                        </button>
                    </div>
                </div>
            </form>

            <form style="display: inline-block;" action="${pageContext.request.contextPath}/changeLocale.jsp" method="post">
                <input type="hidden" name="locale" value="uk">
                <input type="image" src="resources/img/flag-icons-24px/24px/UA.png"/>
            </form>
            <form style="display: inline-block;" action="${pageContext.request.contextPath}/changeLocale.jsp" method="post">
                <input type="hidden" name="locale" value="ru">
                <input type="image" src="resources/img/flag-icons-24px/24px/RU.png"/>
            </form>
            <form style="display: inline-block;" action="${pageContext.request.contextPath}/changeLocale.jsp" method="post">
                <input type="hidden" name="locale" value="en">
                <input type="image" src="resources/img/flag-icons-24px/24px/GB.png"/>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="resources/js/lib/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="resources/js/lib/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="resources/js/lib/popper.js"></script>
<script src="resources/js/bootstrap/bootstrap.js"></script>
<script src="resources/js/bootstrap/bootstrap.bundle.js"></script>
<!--===============================================================================================-->
<script src="resources/js/lib/select2.min.js"></script>
<!--===============================================================================================-->
<script src="resources/js/lib/moment.min.js"></script>
<script src="resources/js/lib/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="resources/js/lib/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="resources/js/login/custom/main.js"></script>
<script src="resources/js/login/custom/validate_passwords.js"></script>

</body>
</html>