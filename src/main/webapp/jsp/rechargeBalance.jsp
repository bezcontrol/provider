<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Contact V5</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/lib/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/lib/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/lib/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/lib/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/lib/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/lib/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/lib/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/lib/nouislider.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/balance/util.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/balance/main.css">
    <!--===============================================================================================-->
</head>
<body>
<c:set var="pc" value='PC'/>
<c:set var="tv" value='TV'/>
<c:set var="mobile" value='Mobile'/>
<c:if test="${(sessionScope.userBean eq null) or (sessionScope.userBean.role.name ne 'client')}">
    <c:redirect url="/service?command=allTariffs"/>
</c:if>

<div class="container-contact100">
    <div class="wrap-contact100">
        <form class="contact100-form validate-form" method="post" action="${pageContext.request.contextPath}/client">
            <input type="hidden" name="command" value="rechargeBalance"/>
				<span class="contact100-form-title">
					Contact Us
				</span>

            <div class="wrap-input100 validate-input bg1" data-validate="Please Type Your Name">
                <span class="label-input100">Login *</span>
                <input class="input100" type="text" name="login" placeholder="Your login" value="${sessionScope.userBean.user.login}" readonly>
            </div>

            <div class="wrap-input100 bg1 rs1-wrap-input100">
                <span class="label-input100">Add to balance</span>
                <input class="input100" type="text" name="bill" placeholder="">
            </div>

            <div class="container-contact100-form-btn">
                <button class="contact100-form-btn" type="submit">
						<span>
							Submit
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
						</span>
                </button>
            </div>
        </form>
    </div>
</div>



<!--===============================================================================================-->
<script src="../resources/js/lib/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/popper.js"></script>
<script src="../resources/js/bootstrap/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/select2.min.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/moment.min.js"></script>
<script src="../resources/js/lib/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/nouislider.min.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/balance/main.js"></script>

</body>
</html>
