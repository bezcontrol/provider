<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TV</title>
    <link href="../resources/css/services/xxx.css" rel="stylesheet">
    <%@ include file="../jspf/menu.jspf"%>
</head>
<body>
<c:if test="${not empty tariffs}">
    <div class="centerflipcards">
        <c:forEach items="${requestScope.tariffs}" var="object">
            <div class="square-flip">
                <div class='square' data-image="../resources/img/tv.png">
                    <div class="square-container">
                        <div class="align-center"><img src="http://titanicthemes.com/files/flipbox/kallyas2.png" class="boxshadow" alt=""></div>
                        <h3 class="textshadow">${object.tariff.name}</h3>
                        <h2 class="textshadow">${object.tariff.price}$</h2>
                    </div>
                    <div class="flip-overlay"></div>
                </div>
                <div class='square2' data-image="../resources/img/tv.png">
                    <div class="square-container2">
                        <div class="align-center"></div>
                        <a href="" class="boxshadow kallyas-button">View more</a>
                    </div>
                    <div class="flip-overlay"></div>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>
<c:if test="${empty tariffs}">
    <c:redirect url="services.jsp"/>
</c:if>



<script src="../resources/js/login/lib/jquery-3.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../resources/js/service/script.js"></script>
</body>
</html>
</body>
</html>
