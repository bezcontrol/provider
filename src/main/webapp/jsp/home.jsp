<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:set var="title" value="Home" />
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap/bootstrap.min.css">

</head>
<body>
    <c:choose>
        <c:when test="${user!=null}">
            <jsp:useBean id="user" scope="session" type="ua.kh.baklanov.model.entity.User"/>
            <jsp:useBean id="userRole" scope="session" type="ua.kh.baklanov.model.entity.Role"/>
            <c:choose>

                <c:when test="${userRole.name == 'ADMIN' }">
                    <h3>ADMIN</h3>
                </c:when>
                <c:when test="${userRole.name == 'CLIENT'}">
                    <h3>CLIENT</h3>
                </c:when>

            </c:choose>


            <c:out value="${user.login} ${user.email}"/>

            <c:if test="${not empty userRole}">
                <c:out value="(${userRole.name})"/>
            </c:if>


        </c:when>
        <c:otherwise>
            <c:redirect url="../index.jsp"/>
        </c:otherwise>
    </c:choose>

<script src="../resources/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>
