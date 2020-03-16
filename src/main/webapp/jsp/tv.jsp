<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TV</title>
    <link href="../resources/css/services/main.css" rel="stylesheet">
    <%@ include file="../jspf/menu.jspf"%>
</head>
<body>
<c:if test="${not empty tvTypes}">
<div class="centerflipcards">
    <c:forEach items="${requestScope.tvTypes}" var="object">
    <div class="square-flip">
        <div class='square' data-image="../resources/img/tv.png">
            <div class="square-container">
                <div class="align-center"><img src="http://titanicthemes.com/files/flipbox/kallyas2.png" class="boxshadow" alt=""></div>
                <h2 class="textshadow">${object}</h2>
                <h3 class="textshadow"></h3>
            </div>
            <div class="flip-overlay"></div>
        </div>
        <div class='square2' data-image="../resources/img/tv.png">
            <div class="square-container2">
                <div class="align-center"></div>
                <a href="${pageContext.request.contextPath}/service?command=tvTariffs&typeTV=${object}" class="boxshadow kallyas-button">View more</a>
            </div>
            <div class="flip-overlay"></div>
        </div>
    </div>
    </c:forEach>
</div>
</c:if>
<c:if test="${empty tvTypes}">
    <c:redirect url="/service?command=tvTypes"/>
</c:if>



<script src="../resources/js/login/lib/jquery-3.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../resources/js/service/script.js"></script>
</body>
</html>