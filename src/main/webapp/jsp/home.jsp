<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<tr>
    <td id="header">


<c:choose><c:when test="${user!=null}">
    <jsp:useBean id="user" scope="session" type="ua.kh.baklanov.model.entity.User"/>
    <jsp:useBean id="userRole" scope="session" type="ua.kh.baklanov.model.entity.Role"/>
    <%--===========================================================================
           This is the user menu.
           ===========================================================================--%>
    <div id="leftHeader">
        <c:choose>

            <%--===========================================================================
            This way we define the ADMIN MENU.
            ===========================================================================--%>

            <c:when test="${userRole.name == 'ADMIN' }">
                <h3>ADMIN</h3>
            </c:when>


            <%--===========================================================================
            This way we define the USER MENU.
            ===========================================================================--%>
            <c:when test="${userRole.name == 'CLIENT'}">
                <h3>CLIENT</h3>
            </c:when>
        </c:choose>


    </div>

    <%--===========================================================================
    This way we define the menu located at the right of header.
    ===========================================================================--%>
    <div id="rightHeader" >

            <%--===========================================================================
            Type user name if the user object is presented in the current session.
            ===========================================================================--%>
        <c:out value="${user.login} ${user.email}"/>

            <%--===========================================================================
            Type user role name if the user object is presented in the current session.
            ===========================================================================--%>
        <c:if test="${not empty userRole}">
            <c:out value="(${userRole.name})"/>
        </c:if>
    </div>
</c:when>
<c:otherwise>
    <c:redirect url="../index.jsp"/>
</c:otherwise>
</c:choose>

    </td>
</tr>
</body>
</html>
