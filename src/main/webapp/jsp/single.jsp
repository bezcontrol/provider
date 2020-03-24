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
<c:if test="${(sessionScope.user eq null) and (requestScope.operation ne 'Details')}">
    <c:redirect url="/service?command=allTariffs"/>
</c:if>

<div class="container-contact100">
    <div class="wrap-contact100">
        <c:choose>

            <c:when test="${(requestScope.operation eq 'Update')}">
                <!-- RIGHT SIDE OF UPDATE COMMAND (FORM) -->
                <form class="contact100-form validate-form" action="tariff" method="post">
                    <input type="hidden" name="tariffId" value="${selectedTariff.tariff.id}"/>
                    <input type="hidden" name="serviceId" value="${requestScope.selectedTariff.service.id}"/>

                    <span class="contact100-form-title">
                            ${requestScope.operation}
                    </span>
                    <label class="label-input100"
                           for="tariff_name">${applicationScope.textFields.getTariffName()}</label>
                    <div class="wrap-input100 validate-input" data-validate="Required">
                        <input id="tariff_name" name="tariff_name" class="input100" type="text" placeholder="">
                        <span class="focus-input100"></span>
                    </div>

                    <!-- Dropdown -->
                    <div class="wrap-input100">
                        <div class="label-input100">Choose service</div>
                        <div style="border: 1px solid #e6e6e6;">
                            <select id="serviceId" name="serviceId" class="js-select2">
                                <option value="">-- Select --</option>
                                <c:forEach items="${servicesList}" var="service">

                                    <c:choose>
                                        <c:when test="${service.service.getClass().simpleName eq pc}">
                                            <option data-speed="${service.internet.speed}"
                                                    data-tech="${service.internet.technology}"
                                                    data-conpc="${service.service.numOfConnectedPC}">
                                                <c:out value="${service.description}"/></option>
                                        </c:when>
                                        <c:when test="${service.service.getClass().simpleName eq tv}">
                                            <option data-speed="${service.internet.speed}"
                                                    data-tech="${service.internet.technology}"
                                                    data-type="${service.service.type}"
                                                    data-numofchannels="${service.service.numOfChannels}">
                                                <c:out value="${service.description}"/></option>
                                        </c:when>
                                        <c:otherwise>
                                            <option data-speed="${service.internet.speed}"
                                                    data-tech="${service.internet.technology}"
                                                    data-numofmininside="${service.service.numOfMinutesInside}"
                                                    data-numofminoutside="${service.service.numOfMinutesOutside}"
                                                    data-numofsms="${service.service.numOfSMS}"
                                                    data-numofmbts="${service.service.numOfMbts}">
                                                <c:out value="${service.description}"/></option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                            <div class="dropDownSelect2"></div>
                        </div>
                        <span class="focus-input100"></span>
                    </div>
                    <!-- End dropdown-->

                    <label class="label-input100"
                           for="tariff_price">${applicationScope.textFields.getTariffPrice()}</label>
                    <div class="wrap-input100 validate-input" data-validate="Required">
                        <input id="tariff_price" name="tariff_price" class="input100" type="text" placeholder="">
                        <span class="focus-input100"></span>
                    </div>

                    <label class="label-input100"
                           for="tariff_duration">${applicationScope.textFields.getTariffDurationInDays()}</label>
                    <div class="wrap-input100 validate-input" data-validate="Required">
                        <input id="tariff_duration" name="tariff_duration" class="input100" type="text" placeholder="">
                        <span class="focus-input100"></span>
                    </div>

                    <c:if test="${selectedTariff.internet ne null}">
                        <label class="label-input100"
                               for="internet_speed">${applicationScope.textFields.getInternetSpeed()}</label>
                        <div class="wrap-input100 validate-input" data-validate="Required">
                            <input id="internet_speed" class="input100" type="text" placeholder="" disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                        <label class="label-input100"
                               for="internet_technology">${applicationScope.textFields.getInternetTechnology()}</label>
                        <div class="wrap-input100 validate-input" data-validate="Required">
                            <input id="internet_technology" class="input100" type="text" placeholder=""
                                   disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                    </c:if>

                    <c:choose>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq pc}">
                            <label class="label-input100"
                                   for="connectedPC">${applicationScope.textFields.getPcConnectedPC()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="connectedPC" class="input100" type="text" placeholder="" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq tv}">
                            <label class="label-input100"
                                   for="typeTV">${applicationScope.textFields.getTvType()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="typeTV" class="input100" type="text" placeholder="" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="numOfChannels">${applicationScope.textFields.getTvNumberOfChannels()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="numOfChannels" class="input100" type="text" placeholder=""
                                       disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.selectedTariff.service.getClass().simpleName eq mobile}">
                            <label class="label-input100"
                                   for="minutesInside">${applicationScope.textFields.getMobileMinutesInside()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="minutesInside" class="input100" type="text" placeholder=""
                                       disabled="disabled">
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
                                <input id="numOfSMS" class="input100" type="text" placeholder="" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                            <label class="label-input100"
                                   for="numOfMbts">${applicationScope.textFields.getMobileNumberOfMbts()}</label>
                            <div class="wrap-input100 validate-input" data-validate="Required">
                                <input id="numOfMbts" class="input100" type="text" placeholder="" disabled="disabled">
                                <span class="focus-input100"></span>
                            </div>
                        </c:when>
                    </c:choose>

                    <div class="container-contact100-form-btn">
                        <button class="contact100-form-btn" type="submit" name="command"
                                value="${requestScope.operation}">
                                ${requestScope.operation}
                        </button>
                    </div>
                </form>
                <!-- END OF RIGHT SIDE OF UPDATE COMMAND (FORM) -->
            </c:when>

            <c:when test="${(requestScope.operation eq 'Create')}">
                <!-- RIGHT SIDE OF CREATE COMMAND (FORM) -->
                <form class="contact100-form validate-form" action="tariff" method="post">

                        <span class="contact100-form-title">
                                ${requestScope.operation}
                        </span>
                    <label class="label-input100"
                           for="tariff_name">${applicationScope.textFields.getTariffName()}</label>
                    <div class="wrap-input100 validate-input" data-validate="Required">
                        <input id="tariff_name" name="tariff_name" class="input100" type="text" placeholder="">
                        <span class="focus-input100"></span>
                    </div>

                    <!-- Dropdown -->
                    <div class="wrap-input100">
                        <div class="label-input100">Type of service</div>
                        <div style="border: 1px solid #e6e6e6;">
                            <select id="type" class="js-select2" onchange="yesnoCheck(this);">
                                <option value="">-- Select --</option>
                                <option value="TV">TV</option>
                                <option value="PC">PC</option>
                                <option value="Mobile">Mobile</option>
                            </select>
                            <div class="dropDownSelect2"></div>
                        </div>
                        <span class="focus-input100"></span>
                    </div>

                    <label class="label-input100"
                           for="tariff_price">${applicationScope.textFields.getTariffPrice()}</label>
                    <div class="wrap-input100 validate-input" data-validate="Required">
                        <input id="tariff_price" name="tariff_price" class="input100" type="text" placeholder="">
                        <span class="focus-input100"></span>
                    </div>

                    <label class="label-input100"
                           for="tariff_duration">${applicationScope.textFields.getTariffDurationInDays()}</label>
                    <div class="wrap-input100 validate-input" data-validate="Required">
                        <input id="tariff_duration" name="tariff_duration" class="input100" type="text"
                               placeholder="">
                        <span class="focus-input100"></span>
                    </div>


                    <div id="ifPC" style="display: none;">

                        <!-- Dropdown -->
                        <div class="wrap-input100">
                            <div class="label-input100">Choose service</div>
                            <div style="border: 1px solid #e6e6e6;">
                                <select id="serviceId2" name="serviceIdPC" class="js-select2">
                                    <option value="">-- Select --</option>
                                    <c:forEach items="${servicesList}" var="service">
                                        <c:if test="${service.service.getClass().simpleName eq pc}">
                                            <option value="${service.service.id}"
                                                    data-speed="${service.internet.speed}"
                                                    data-tech="${service.internet.technology}"
                                                    data-conpc="${service.service.numOfConnectedPC}">
                                                <c:out value="${service.description}"/></option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                                <div class="dropDownSelect2"></div>
                            </div>
                            <span class="focus-input100"></span>
                        </div>
                        <!-- End dropdown-->


                        <label class="label-input100"
                               for="connectedPC">${applicationScope.textFields.getPcConnectedPC()}</label>
                        <div class="wrap-input100">
                            <input id="connectedPC" class="input100" type="text" placeholder="" disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                    </div>

                    <div id="ifTV" style="display: none;">

                        <!-- Dropdown -->
                        <div class="wrap-input100">
                            <div class="label-input100">Choose service</div>
                            <div style="border: 1px solid #e6e6e6;">
                                <select id="serviceId3" name="serviceIdTV" class="js-select2">
                                    <option value="">-- Select --</option>
                                    <c:forEach items="${servicesList}" var="service">
                                        <c:if test="${service.service.getClass().simpleName eq tv}">
                                            <option value="${service.service.id}"
                                                    data-speed="${service.internet.speed}"
                                                    data-tech="${service.internet.technology}"
                                                    data-type="${service.service.type}"
                                                    data-numofchannels="${service.service.numOfChannels}">
                                                <c:out value="${service.description}"/></option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                                <div class="dropDownSelect2"></div>
                            </div>
                            <span class="focus-input100"></span>
                        </div>
                        <!-- End dropdown-->


                        <label class="label-input100"
                               for="typeTV">${applicationScope.textFields.getTvType()}</label>
                        <div class="wrap-input100">
                            <input id="typeTV" class="input100" type="text" placeholder="" disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                        <label class="label-input100"
                               for="numOfChannels">${applicationScope.textFields.getTvNumberOfChannels()}</label>
                        <div class="wrap-input100">
                            <input id="numOfChannels" class="input100" type="text" placeholder=""
                                   disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>

                    </div>

                    <div id="ifMobile" style="display: none;">

                        <!-- Dropdown -->
                        <div class="wrap-input100">
                            <div class="label-input100">Choose service</div>
                            <div style="border: 1px solid #e6e6e6;">
                                <select id="serviceId4" name="serviceIdMobile" class="js-select2">
                                    <option value="">-- Select --</option>
                                    <c:forEach items="${servicesList}" var="service">
                                        <c:if test="${service.service.getClass().simpleName eq mobile}">
                                            <option value="${service.service.id}"
                                                    data-speed="${service.internet.speed}"
                                                    data-tech="${service.internet.technology}"
                                                    data-numofmininside="${service.service.numOfMinutesInside}"
                                                    data-numofminoutside="${service.service.numOfMinutesOutside}"
                                                    data-numofsms="${service.service.numOfSMS}"
                                                    data-numofmbts="${service.service.numOfMbts}">
                                                <c:out value="${service.description}"/></option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                                <div class="dropDownSelect2"></div>
                            </div>
                            <span class="focus-input100"></span>
                        </div>
                        <!-- End dropdown-->


                        <label class="label-input100"
                               for="minutesInside">${applicationScope.textFields.getMobileMinutesInside()}</label>
                        <div class="wrap-input100" >
                            <input id="minutesInside" class="input100" type="text" placeholder=""
                                   disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                        <label class="label-input100"
                               for="minutesOutside">${applicationScope.textFields.getMobileMinutesOutside()}</label>
                        <div class="wrap-input100" >
                            <input id="minutesOutside" class="input100" type="text" placeholder="">
                            <span class="focus-input100"></span>
                        </div>
                        <label class="label-input100"
                               for="numOfSMS">${applicationScope.textFields.getMobileNumberOfSMS()}</label>
                        <div class="wrap-input100">
                            <input id="numOfSMS" class="input100" type="text" placeholder="" disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                        <label class="label-input100"
                               for="numOfMbts">${applicationScope.textFields.getMobileNumberOfMbts()}</label>
                        <div class="wrap-input100">
                            <input id="numOfMbts" class="input100" type="text" placeholder="" disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                    </div>

                    <label class="label-input100"
                           for="internet_speed">${applicationScope.textFields.getInternetSpeed()}</label>
                    <div class="wrap-input100" >
                        <input id="internet_speed" class="input100" type="text" placeholder="" disabled="disabled">
                        <span class="focus-input100"></span>
                    </div>
                    <label class="label-input100"
                           for="internet_technology">${applicationScope.textFields.getInternetTechnology()}</label>
                    <div class="wrap-input100">
                        <input id="internet_technology" class="input100" type="text" placeholder=""
                               disabled="disabled">
                        <span class="focus-input100"></span>
                    </div>
                    <input id="serviceType" type="hidden" name="serviceType" value=""/>
                    <button class="contact100-form-btn" type="submit" name="command"
                            value="${requestScope.operation}">
                            ${requestScope.operation}
                    </button>
                </form>
                <!-- END OF RIGHT SIDE OF CREATE COMMAND (FORM) -->
            </c:when>

            <c:otherwise>
                <!-- RIGHT SIDE OF DETAILS AND DELETE COMMAND (FORM) -->
                <form class="contact100-form validate-form" action="tariff" method="post">
                    <input type="hidden" name="tariffId" value="${selectedTariff.tariff.id}"/>
                    <input type="hidden" name="serviceType"
                           value="${requestScope.selectedTariff.service.getClass().simpleName}"/>
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
                        <label class="label-input100"
                               for="speed_na">${applicationScope.textFields.getInternetSpeed()}</label>
                        <div class="wrap-input100">
                            <input id="speed_na" class="input100" type="text"
                                   placeholder="${selectedTariff.internet.speed}"
                                   disabled="disabled">
                            <span class="focus-input100"></span>
                        </div>
                        <label class="label-input100"
                               for="technology_na">${applicationScope.textFields.getInternetTechnology()}</label>
                        <div class="wrap-input100">
                            <input id="technology_na" class="input100" type="text"
                                   placeholder="${selectedTariff.internet.technology}"
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
                                <button class="contact100-form-btn" type="submit" name="command"
                                        value="${requestScope.operation}">
                                        ${requestScope.operation}
                                </button>
                    </div>
                </form>
                <!-- END OF RIGHT SIDE OF DETAILS AND DELETE COMMAND (FORM) -->
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
    $("#serviceId").change(function () {
        document.getElementById('internet_speed').value = $(this).find(':selected').data('speed');
        document.getElementById('internet_technology').value = $(this).find(':selected').data('tech');
        <c:choose>
        <c:when test="${selectedTariff.service.getClass().simpleName eq pc}">
        document.getElementById('connectedPC').value = $(this).find(':selected').data('conpc');
        </c:when>
        <c:when test="${selectedTariff.service.getClass().simpleName eq tv}">
        document.getElementById('typeTV').value = $(this).find(':selected').data('type');
        document.getElementById('numOfChannels').value = $(this).find(':selected').data('numofchannels');
        </c:when>
        <c:otherwise>
        document.getElementById('minutesInside').value = $(this).find(':selected').data('numofmininside');
        document.getElementById('minutesOutside').value = $(this).find(':selected').data('numofminoutside');
        document.getElementById('numOfSMS').value = $(this).find(':selected').data('numofsms');
        document.getElementById('numOfMbts').value = $(this).find(':selected').data('numofmbts');
        </c:otherwise>
        </c:choose>
    });
</script>

<script>
    $("#serviceId2").change(function () {
        document.getElementById('serviceType').value = 'PC';
        document.getElementById('internet_speed').value = null;
        document.getElementById('internet_technology').value = null;
        val1 = $(this).find(':selected').data('speed');
        val2 = $(this).find(':selected').data('tech');

        if (val1 != 0 && val2 != 'null') {
            document.getElementById('internet_speed').value = val1;
            document.getElementById('internet_technology').value = val2;
        }
        document.getElementById('connectedPC').value = $(this).find(':selected').data('conpc');
    });

    $("#serviceId3").change(function () {
        document.getElementById('serviceType').value = 'TV';
        document.getElementById('internet_speed').value = null;
        document.getElementById('internet_technology').value = null;
        val1 = $(this).find(':selected').data('speed');
        val2 = $(this).find(':selected').data('tech');

        if (val1 != 0 && val2 != 'null') {
            document.getElementById('internet_speed').value = val1;
            document.getElementById('internet_technology').value = val2;
        }

        document.getElementById('typeTV').value = $(this).find(':selected').data('type');
        document.getElementById('numOfChannels').value = $(this).find(':selected').data('numofchannels');

    });

    $("#serviceId4").change(function () {
        document.getElementById('serviceType').value = 'Mobile';
        document.getElementById('internet_speed').value = null;
        document.getElementById('internet_technology').value = null;
        val1 = $(this).find(':selected').data('speed');
        val2 = $(this).find(':selected').data('tech');

        if (val1 != 0 && val2 != 'null') {
            document.getElementById('internet_speed').value = val1;
            document.getElementById('internet_technology').value = val2;
        }
        document.getElementById('minutesInside').value = $(this).find(':selected').data('numofmininside');
        document.getElementById('minutesOutside').value = $(this).find(':selected').data('numofminoutside');
        document.getElementById('numOfSMS').value = $(this).find(':selected').data('numofsms');
        document.getElementById('numOfMbts').value = $(this).find(':selected').data('numofmbts');

    });
</script>


<script>
    function yesnoCheck(that) {
        if (that.value == "PC") {
            document.getElementById("ifPC").style.display = "block";
        } else {
            document.getElementById("ifPC").style.display = "none";
        }
        if (that.value == "TV") {
            document.getElementById("ifTV").style.display = "block";
        } else {
            document.getElementById("ifTV").style.display = "none";
        }
        if (that.value == "Mobile") {
            document.getElementById("ifMobile").style.display = "block";
        } else {
            document.getElementById("ifMobile").style.display = "none";
        }
    }
</script>
<script>

    $(".js-select2").each(function () {
        $(this).select2({
            minimumResultsForSearch: 20,
            dropdownParent: $(this).next('.dropDownSelect2')
        });
    })
    $(".js-select2").each(function () {
        $(this).on('select2:open', function (e) {
            $(this).parent().next().addClass('eff-focus-selection');
        });
    });
    $(".js-select2").each(function () {
        $(this).on('select2:close', function (e) {
            $(this).parent().next().removeClass('eff-focus-selection');
        });
    });

</script>

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
