<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TV</title>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>
    <script src="../resources/js/lib/jquery-3.2.1.min.js"></script>
    <script src="../resources/js/lib/popper.min.js"></script>
    <script src="../resources/js/bootstrap/bootstrap.min.js"></script>
    <link href="../resources/css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="../resources/css/tariffs/style.css" rel="stylesheet">


    <script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    <!-- plus a jQuery UI theme, here I use "flick" -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/flick/jquery-ui.css">
    <link rel="stylesheet" href="../resources/css/tariffs/search/slider.css">
    <link rel="stylesheet" href="../resources/css/tariffs/search/search.css">


    <%@ include file="../jspf/menu.jspf" %>
</head>
<body>
<form action="tariff" method="get">
    <div class="container_search">
        <label for="select_search"><fmt:message key="tariffs.search.price"/>:</label>
        <div class="slider"></div>
        <div class="form-group">
            <label for="select_search"><fmt:message key="tariffs.search.sort"/>:</label>
            <select class="form-control" id="select_search" name="select_search">
                <c:forEach items="${sessionScope.sortOperations}" var="object">
                    <option value="${object.name()}">${object.getValue()}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-warning"name="command" value="search"><fmt:message key="tariffs.search.btn.search"/></button>
        <input id="lowerPrice" name="lowerPrice" type="hidden" value="">
        <input id="upperPrice" name="upperPrice" type="hidden" value="">
    </div>
</form>


<c:if test="${not empty requestScope.tariffs}">
    <div id="cards">
        <c:forEach items="${requestScope.tariffs}" var="object">

            <c:set var="pc" value="PC"/>
            <c:set var="tv" value="TV"/>
            <c:set var="mobile" value="Mobile"/>

                <figure class="card card--water">
                    <div class="card__image-container">
                        <img src="https://cdn.bulbagarden.net/upload/thumb/f/fd/134Vaporeon.png/1200px-134Vaporeon.png"
                             alt="Vaporeon" class="card__image">
                    </div>

                    <figcaption class="card__caption">
                        <h1 class="card__name">${applicationScope.textFields.getTariffName()}${object.tariff.name}</h1>

                        <h3 class="card__type">
                            <c:out value="${object.service.getClass().simpleName}"/>
                        </h3>

                        <table class="card__stats">
                            <tbody>
                            <tr>
                                <th>${applicationScope.textFields.getTariffPrice()}</th>
                                <td>${object.tariff.price} $</td>
                            </tr>
                            <c:choose>
                                <c:when test="${object.service.getClass().simpleName eq pc}">
                                    <tr>
                                        <th>${applicationScope.textFields.getPcConnectedPC()}</th>
                                        <td>${object.service.numOfConnectedPC}</td>
                                    </tr>
                                </c:when>
                                <c:when test="${object.service.getClass().simpleName eq tv}">

                                    <tr>
                                        <th>${applicationScope.textFields.getTvNumberOfChannels()}</th>
                                        <td>${object.service.numOfChannels}</td>
                                    </tr>
                                    <tr>
                                        <th>${applicationScope.textFields.getTvType()}</th>
                                        <td>${object.service.type}</td>
                                    </tr>
                                </c:when>
                                <c:when test="${object.service.getClass().simpleName eq mobile}">
                                    <tr>
                                        <th>${applicationScope.textFields.getMobileMinutesInside()}</th>
                                        <td>${object.service.numOfMinutesInside} minutes</td>
                                    </tr>
                                    <tr>
                                        <th>${applicationScope.textFields.getMobileMinutesOutside()}</th>
                                        <td>${object.service.numOfMinutesOutside} minutes</td>
                                    </tr>
                                    <tr>
                                        <th>${applicationScope.textFields.getMobileNumberOfSMS()}</th>
                                        <td>${object.service.numOfSMS}</td>
                                    </tr>
                                    <tr>
                                        <th>${applicationScope.textFields.getMobileNumberOfMbts()}</th>
                                        <td>${object.service.numOfMbts}mbts</td>
                                    </tr>
                                </c:when>
                            </c:choose>

                            </tbody>
                        </table>

                        <div class="card__abilities">
                            <c:choose>
                                <c:when test="${object.internet.speed!=0}">
                                    <h4 class="card__ability">
                                        <span class="card__label">${applicationScope.textFields.getInternetTechnology()}</span>
                                            ${object.internet.technology}
                                    </h4>
                                </c:when>
                                <c:otherwise>
                                    <h4 class="card__ability">
                                        <span class="card__label"></span>
                                    </h4>
                                </c:otherwise>
                            </c:choose>
                        </div>

                    </figcaption>
                    <div class="group_of_buttons">
                        <form action="tariff" method="get">
                            <input type="hidden" name="tariffId" value="${object.tariff.id}"/>
                            <input type="hidden" name="serviceType" value="${object.service.getClass().simpleName}"/>
                            <input type="hidden" name="serviceId" value="${object.service.id}"/>
                        <c:if test="${not empty sessionScope.userBean.user}">
                            <c:choose>
                                <c:when test="${sessionScope.userBean.role.name eq 'admin'}">
                                    <button type="submit"  class="btn btn-danger mybtn" name="operation" value="Update"><fmt:message key="btn.update"/></button>
                                    <button type="submit"  class="btn btn-danger mybtn" name="operation" value="Delete"><fmt:message key="btn.delete"/></button>
                                </c:when>
                            <c:otherwise>
                                <button type="submit" class="btn btn-success" name="operation" value="AddToCart"><fmt:message key="tariffs.card.btn.add_to_cart"/></button>
                            </c:otherwise>
                            </c:choose>
                        </c:if>
                            <button type="submit"  class="btn btn-danger mybtn" name="operation" value="Details"><fmt:message key="btn.details"/></button>
                        </form>
                            <div class="dropdown">
                                <button class="btn btn-success dropdown-toggle download" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <fmt:message key="tariffs.card.btn.download"/>
                                </button>
                                <div class="dropdown-menu" style="width: 100%;">
                                    <form action="tariff" method="post">
                                        <input type="hidden" name="tariffId" value="${object.tariff.id}"/>
                                        <input type="hidden" name="serviceType" value="${object.service.getClass().simpleName}"/>
                                        <input type="hidden" name="serviceId" value="${object.service.id}"/>
                                    <button class="dropdown-item" type="submit" name="command" value="downloadPDF">.pdf</button>
                                    <button class="dropdown-item" type="submit" name="command" value="downloadTXT">.txt</button>
                                    </form>
                                </div>
                            </div>
                    </div>
                </figure>
        </c:forEach>
    </div>
</c:if>
<form action="tariff" method="get">
    <c:if test="${sessionScope.userBean.role.name eq 'admin'}">
        <button type="submit" class="btn btn-danger" name="operation" value="Create"><fmt:message key="btn.create"/></button>
    </c:if>
</form>

<script src="../resources/js/tariffs/search/slider.js"></script>
<script src="../resources/js/tariffs/search/xxx.js"></script>


</body>
</html>


