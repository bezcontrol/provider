<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="../resources/img/single/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
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
    <link rel="stylesheet" type="text/css" href="../resources/css/single/util.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/single/main.css">
    <!--===============================================================================================-->
    <%@ include file="../jspf/menu.jspf" %>
</head>
<body>

<c:set var="pc" value='PC'/>
<c:set var="tv" value='TV'/>
<c:set var="mobile" value='Mobile'/>

<div class="container-contact100">
    <div class="wrap-contact100">
        <c:choose>
            <c:when test="${(requestScope.operation eq 'Update') or (requestScope.operation eq 'Create')}">
                <form class="contact100-form validate-form" action="tariff" method="post">
                    <input type="hidden" name="tariffId" value="${selectedTariff.tariff.id}"/>
                    <input type="hidden" name="serviceType" value="${requestScope.selectedTariff.service.getClass().simpleName}"/>

				<span class="contact100-form-title">
                        ${requestScope.operation}
                </span>
                    <label class="label-input100"
                           for="tariff_name">${applicationScope.textFields.getTariffName()}</label>
                    <div class="wrap-input100 validate-input" data-validate="Required">
                        <input id="tariff_name" class="input100" type="text" placeholder="">
                        <span class="focus-input100"></span>
                    </div>

                    <label class="label-input100" for="tariff_price">${applicationScope.textFields.getTariffPrice()}</label>
                    <div class="wrap-input100 validate-input" data-validate="Required">
                        <input id="tariff_price" class="input100" type="text" placeholder="">
                        <span class="focus-input100"></span>
                    </div>

                    <label class="label-input100"
                           for="tariff_duration">${applicationScope.textFields.getTariffDurationInDays()}</label>
                    <div class="wrap-input100 validate-input" data-validate="Required">
                        <input id="tariff_duration" class="input100" type="text" placeholder="">
                        <span class="focus-input100"></span>
                    </div>

                    <c:if test="${selectedTariff.internet ne null}">
                        <label class="label-input100" for="internet_speed">${applicationScope.textFields.getInternetSpeed()}</label>
                        <div class="wrap-input100 validate-input" data-validate="Required" >
                            <input id="internet_speed" class="input100" type="text" placeholder="">
                            <span class="focus-input100"></span>
                        </div>
                        <label class="label-input100" for="internet_technology">${applicationScope.textFields.getInternetTechnology()}</label>
                        <div class="wrap-input100 validate-input" data-validate="Required">
                            <input id="internet_technology" class="input100" type="text" placeholder="">
                            <span class="focus-input100"></span>
                        </div>
                    </c:if>

                    <c:choose>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq pc}">
                            <label class="label-input100"
                                   for="connectedPC">${applicationScope.textFields.getPcConnectedPC()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="connectedPC" class="input100" type="text" placeholder="">
                                <span class="focus-input100"></span>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq tv}">
                            <label class="label-input100"
                                   for="typeTV">${applicationScope.textFields.getTvType()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="typeTV" class="input100" type="text" placeholder="">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="numOfChannels">${applicationScope.textFields.getTvNumberOfChannels()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="numOfChannels" class="input100" type="text" placeholder="">
                                <span class="focus-input100"></span>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq mobile}">
                            <label class="label-input100"
                                   for="minutesInside">${applicationScope.textFields.getMobileMinutesInside()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="minutesInside" class="input100" type="text" placeholder="">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="minutesOutside">${applicationScope.textFields.getMobileMinutesOutside()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="minutesOutside" class="input100" type="text" placeholder="">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="numOfSMS">${applicationScope.textFields.getMobileNumberOfSMS()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="numOfSMS" class="input100" type="text" placeholder="">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="numOfMbts">${applicationScope.textFields.getMobileNumberOfMbts()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="numOfMbts" class="input100" type="text" placeholder="">
                                <span class="focus-input100"></span>
                            </div>
                        </c:when>
                    </c:choose>

                    <div class="container-contact100-form-btn">
                        <c:choose>
                            <c:when test="${requestScope.operation eq 'Details'}">
                                <button class="contact100-form-btn" type="button" >
                                    Back
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="contact100-form-btn" type="submit" name="command" value="${requestScope.operation}">
                                        ${requestScope.operation}
                                </button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </form>
            </c:when>
            <c:otherwise>
                <form class="contact100-form validate-form" action="tariff" method="post">
                    <input type="hidden" name="tariffId" value="${selectedTariff.tariff.id}"/>
                    <input type="hidden" name="serviceType" value="${requestScope.selectedTariff.service.getClass().simpleName}"/>
				<span class="contact100-form-title">
                        ${requestScope.operation}
                </span>
                    <label class="label-input100"
                           for="tariff_name_na">${applicationScope.textFields.getTariffName()}</label>
                    <div class="wrap-input100">
                        <input id="tariff_name_na" class="input100" type="text"
                               placeholder="${selectedTariff.tariff.name}" disabled="disabled">
                        <span class="focus-input100"></span>
                    </div>

                    <label class="label-input100" for="price_na">${applicationScope.textFields.getTariffPrice()}</label>
                    <div class="wrap-input100">
                        <input id="price_na" class="input100" type="text" placeholder="${selectedTariff.tariff.price}"
                               disabled="disabled">
                        <span class="focus-input100"></span>
                    </div>

                    <label class="label-input100"
                           for="duration_na">${applicationScope.textFields.getTariffDurationInDays()}</label>
                    <div class="wrap-input100">
                        <input id="duration_na" class="input100" type="text"
                               placeholder="${selectedTariff.tariff.durationInDays}" disabled="disabled">
                        <span class="focus-input100"></span>
                    </div>

                    <c:if test="${selectedTariff.internet ne null}">
                        <label class="label-input100" for="speed_na">${applicationScope.textFields.getInternetSpeed()}</label>
                        <div class="wrap-input100">
                            <input id="speed_na" class="input100" type="text" placeholder="${selectedTariff.internet.speed}"
                                   disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                        <label class="label-input100" for="technology_na">${applicationScope.textFields.getInternetTechnology()}</label>
                        <div class="wrap-input100">
                            <input id="technology_na" class="input100" type="text" placeholder="${selectedTariff.internet.technology}"
                                   disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                    </c:if>

                    <c:choose>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq pc}">
                            <label class="label-input100"
                                   for="connectedPC_na">${applicationScope.textFields.getPcConnectedPC()}</label>
                            <div class="wrap-input100">
                                <input id="connectedPC_na" class="input100" type="text"
                                       placeholder="${selectedTariff.service.numOfConnectedPC}" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq tv}">
                            <label class="label-input100"
                                   for="tvType_na">${applicationScope.textFields.getTvType()}</label>
                            <div class="wrap-input100">
                                <input id="tvType_na" class="input100" type="text"
                                       placeholder="${selectedTariff.service.type}" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="numOfChannels_na">${applicationScope.textFields.getTvNumberOfChannels()}</label>
                            <div class="wrap-input100">
                                <input id="numOfChannels_na" class="input100" type="text"
                                       placeholder="${selectedTariff.service.numOfChannels}" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq mobile}">
                            <label class="label-input100"
                                   for="minutesInside_na">${applicationScope.textFields.getMobileMinutesInside()}</label>
                            <div class="wrap-input100">
                                <input id="minutesInside_na" class="input100" type="text"
                                       placeholder="${selectedTariff.service.numOfMinutesInside}" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="minutesOutside_na">${applicationScope.textFields.getMobileMinutesOutside()}</label>
                            <div class="wrap-input100">
                                <input id="minutesOutside_na" class="input100" type="text"
                                       placeholder="${selectedTariff.service.numOfMinutesOutside}" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="numOfSMS_na">${applicationScope.textFields.getMobileNumberOfSMS()}</label>
                            <div class="wrap-input100">
                                <input id="numOfSMS_na" class="input100" type="text"
                                       placeholder="${selectedTariff.service.numOfSMS}" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="numOfMbts-na">${applicationScope.textFields.getMobileNumberOfMbts()}</label>
                            <div class="wrap-input100">
                                <input id="numOfMbts-na" class="input100" type="text"
                                       placeholder="${selectedTariff.service.numOfMbts}" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                        </c:when>
                    </c:choose>

                    <div class="container-contact100-form-btn">
                        <c:choose>
                            <c:when test="${requestScope.operation eq 'Details'}">
                                <button class="contact100-form-btn" type="button" >
                                    Back
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="contact100-form-btn" type="submit" name="command" value="${requestScope.operation}">
                                        ${requestScope.operation}
                                </button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${requestScope.operation eq 'Update'}">
                <div class="contact100-more flex-col-c-m"
                     style="background-image: url('../resources/img/single/bg-01.jpg');">
                    <div class="flex-w size1 p-b-20">

                        <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                Current information about tariff:
                        </span>
                        </div>
                    </div>
                    <div class="flex-w size1 p-b-20">

                        <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getTariffName()}${selectedTariff.tariff.name}
                        </span>
                        </div>
                    </div>
                    <div class="flex-w size1 p-b-20">

                        <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getTariffPrice()}${selectedTariff.tariff.price}
                        </span>
                        </div>
                    </div>
                    <div class="flex-w size1 p-b-20">

                        <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getTariffDurationInDays()}${selectedTariff.tariff.durationInDays}
                        </span>
                        </div>
                    </div>

                    <c:if test="${selectedTariff.internet ne null}">
                        <div class="flex-w size1 p-b-20">

                            <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getInternetSpeed()}${selectedTariff.internet.speed}
                        </span>
                            </div>
                        </div>
                        <div class="flex-w size1 p-b-20">

                            <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getInternetTechnology()}${selectedTariff.internet.technology}
                        </span>
                            </div>
                        </div>
                    </c:if>

                    <c:choose>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq pc}">
                            <div class="flex-w size1 p-b-20">
                                <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getPcConnectedPC()}${selectedTariff.service.numOfConnectedPC}
                        </span>
                                </div>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq tv}">
                            <div class="flex-w size1 p-b-20">
                                <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getTvType()}${selectedTariff.service.type}
                        </span>
                                </div>
                            </div>
                            <div class="flex-w size1 p-b-20">
                                <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getTvNumberOfChannels()}${selectedTariff.service.numOfChannels}
                        </span>
                                </div>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq mobile}">
                            <div class="flex-w size1 p-b-20">
                                <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getMobileMinutesInside()}${selectedTariff.service.numOfMinutesInside}
                        </span>
                                </div>
                            </div>
                            <div class="flex-w size1 p-b-20">
                                <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getMobileMinutesOutside()}${selectedTariff.service.numOfMinutesOutside}
                        </span>
                                </div>
                            </div>
                            <div class="flex-w size1 p-b-20">
                                <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getMobileNumberOfSMS()}${selectedTariff.service.numOfSMS}
                        </span>
                                </div>
                            </div>
                            <div class="flex-w size1 p-b-20">
                                <div class="flex-col size2">
						<span class="txt1 p-b-20">
                                ${applicationScope.textFields.getMobileNumberOfMbts()}${selectedTariff.service.numOfMbts}
                        </span>
                                </div>
                            </div>
                        </c:when>
                    </c:choose>

                </div>
            </c:when>
            <c:otherwise>
                <div class="contact100-more flex-col-c-m"
                     style="background-image: url('../resources/img/single/bg-01.jpg');">
                    <div class="flex-w size1 p-b-20">

                        <div class="flex-col size2">
						<span class="txt1 p-b-20">
                            SOME TEXT
                        </span>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="../resources/js/lib/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/popper.js"></script>
<script src="../resources/js/bootstrap/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/select2.min.js"></script>
<script>
    $(".selection-2").select2({
        minimumResultsForSearch: 20,
        dropdownParent: $('#dropDownSelect1')
    });
</script>
<!--===============================================================================================-->
<script src="../resources/js/lib/moment.min.js"></script>
<script src="../resources/js/lib/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/lib/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="../resources/js/single/main.js"></script>
</body>
</html>
