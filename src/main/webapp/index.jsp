<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:set var="title" value="Log In" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="resources/img/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap-reboot.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/login/lib/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/login/lib/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/login/lib/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/login/lib/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/login/lib/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/login/lib/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/login/lib/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="resources/css/login/custom/util.css">
    <link rel="stylesheet" type="text/css" href="resources/css/login/custom/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100" style="background-image: url('resources/img/bg-01.jpg');">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
            <form class="login100-form validate-form" action="authentication" method="post">
                <input type="hidden" name="command" value="login"/>
					<span class="login100-form-title p-b-49">
						Sign in
					</span>

                <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is required">
                    <span class="label-input100">Username</span>
                    <input class="input100" type="text" name="login" placeholder="Login or email">
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <span class="label-input100">Password</span>
                    <input class="input100" type="password" name="password" placeholder="Type your password">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>

                <div class="text-right p-t-8 p-b-31">
                    <a href="#">
                        Forgot password?
                    </a>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" type="submit">
                            Login
                        </button>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${requestScope.error.length()>0}">
                        <div class="m-t-15 alert alert-danger alert-dismissible">
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
            </form>

            <div class="container-login100-form-btn p-t-15">
                <div class="wrap-login100-form-btn">
                    <div class="login100-form-bgbtn"></div>
                    <button class="login100-form-btn" onclick="location.href='registration.jsp'">
                        Sign Up
                    </button>
                </div>
            </div>
            <div class="text-center p-t-8 p-b-31">
                <a href="jsp/services.jsp">
                    Start without authorization
                </a>
            </div>
            <div class="txt1 text-center p-t-10 p-b-20">
						<span>
							Or Sign Up Using
						</span>
            </div>

            <div class="flex-c-m">
                <a href="#" class="login100-social-item bg1">
                    <i class="fa fa-facebook"></i>
                </a>

                <a href="#" class="login100-social-item bg2">
                    <i class="fa fa-twitter"></i>
                </a>

                <a href="#" class="login100-social-item bg3">
                    <i class="fa fa-google"></i>
                </a>
            </div>

        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="resources/js/login/lib/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="resources/js/login/lib/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="resources/js/login/lib/popper.js"></script>
<script src="resources/js/bootstrap/bootstrap.js"></script>
<script src="resources/js/bootstrap/bootstrap.bundle.js"></script>
<!--===============================================================================================-->
<script src="resources/js/login/lib/select2.min.js"></script>
<!--===============================================================================================-->
<script src="resources/js/login/lib/moment.min.js"></script>
<script src="resources/js/login/lib/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="resources/js/login/lib/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="resources/js/login/custom/main.js"></script>

</body>
</html>