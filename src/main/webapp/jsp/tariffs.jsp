<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TV</title>

    <%--    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>

    <link href="../resources/css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="../resources/css/tariffs/style.css" rel="stylesheet">
    <%@ include file="../jspf/menu.jspf" %>
</head>
<body>
<c:if test="${not empty tariffs}">
    <div id="cards">
        <c:forEach items="${requestScope.tariffs}" var="object">
            <c:set var="pc" value="PC"/>
            <c:set var="tv" value="TV"/>
            <c:set var="mobile" value="Mobile"/>

            <a href="">
                <figure class="card card--water">
                    <div class="card__image-container">
                        <img src="https://cdn.bulbagarden.net/upload/thumb/f/fd/134Vaporeon.png/1200px-134Vaporeon.png"
                             alt="Vaporeon" class="card__image">
                    </div>

                    <figcaption class="card__caption">
                        <h1 class="card__name">${object.tariff.name}</h1>

                        <h3 class="card__type">
                            <c:out value="${object.service.getClass().simpleName}"/>
                        </h3>

                        <table class="card__stats">
                            <tbody>
                            <tr>
                                <th>Price</th>
                                <td>${object.tariff.price} $</td>
                            </tr>
                            <tr>
                                <th>Duration</th>
                                <td>${object.tariff.durationInDays} days</td>
                            </tr>
                            <c:choose>
                                <c:when test="${object.service.getClass().simpleName eq pc}">
                                    <tr>
                                        <th>Number of computers</th>
                                        <td>${object.service.numOfConnectedPC}</td>
                                    </tr>
                                </c:when>
                                <c:when test="${object.service.getClass().simpleName eq tv}">

                                    <tr>
                                        <th>Channels</th>
                                        <td>${object.service.numOfChannels}</td>
                                    </tr>
                                    <tr>
                                        <th>Type</th>
                                        <td>${object.service.type}</td>
                                    </tr>
                                </c:when>
                                <c:when test="${object.service.getClass().simpleName eq mobile}">
                                    <tr>
                                        <th>Inside country</th>
                                        <td>${object.service.numOfMinutesInside} minutes</td>
                                    </tr>
                                    <tr>
                                        <th>Outside country</th>
                                        <td>${object.service.numOfMinutesOutside} minutes</td>
                                    </tr>
                                    <tr>
                                        <th>SMS</th>
                                        <td>${object.service.numOfSMS}</td>
                                    </tr>
                                    <tr>
                                        <th>Internet</th>
                                        <td>${object.service.numOfMbts} mbts</td>
                                    </tr>
                                </c:when>
                            </c:choose>

                            </tbody>
                        </table>

                        <div class="card__abilities">
                            <c:choose>
                                <c:when test="${object.internet.speed!=0}">
                                    <h4 class="card__ability">
                                        <span class="card__label">Internet Speed</span>
                                            ${object.internet.speed/8} Mbps
                                    </h4>
                                    <h4 class="card__ability">
                                        <span class="card__label">Technology</span>
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
                        <button type="button" class="btn btn-danger">Create</button>
                        <button type="button"  class="btn btn-danger">Update</button>
                        <button type="button"  class="btn btn-danger">Delete</button>
                        <button type="button"  class="btn btn-danger">Details</button>
                    </div>
                </figure>
            </a>
        </c:forEach>

    </div>
</c:if>
</body>
</html>


