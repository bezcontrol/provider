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
    <%@ include file="../jspf/menu.jspf" %>
</head>
<body>
<c:if test="${not empty tariffs}">
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
                        <form action="tariff" method="post">
                            <input type="hidden" name="tariffId" value="${object.tariff.id}"/>

                        <c:if test="${not empty sessionScope.user}">
                            <c:choose>
                                <c:when test="${sessionScope.userRole.getName() eq 'admin'}">
                                    <button type="submit" class="btn btn-danger" name="command" value="create">Create</button>
                                    <button type="submit"  class="btn btn-danger" name="command" value="edit">Update</button>
                                    <button type="submit"  class="btn btn-danger" name="command" value="delete">Delete</button>
                                </c:when>
                            <c:otherwise>
                                <button type="submit" class="btn btn-success">Make order</button>
                            </c:otherwise>
                            </c:choose>

                        </c:if>
                            <button type="submit"  class="btn btn-danger" name="command" value="details">Details</button>

                            <div class="dropdown">
                                <button class="btn btn-success dropdown-toggle download" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Download
                                </button>
                                <div class="dropdown-menu" style="width: 100%;">
                                    <button class="dropdown-item" type="submit" name="command" value="downloadPDF">.pdf</button>
                                    <button class="dropdown-item" type="submit" name="command" value="downloadTXT">.txt</button>
                                </div>
                            </div>
<%--                        <button type="submit" class="btn btn-success download" name="command" value="download">Download</button>--%>
                        </form>
                    </div>
                </figure>
        </c:forEach>

    </div>
</c:if>

</body>
</html>


