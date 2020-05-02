<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setBundle basename="messages"/>

<html>
<head>
    <title>PhraseApp - i18n</title>
</head>
<body>
    <%-- set the locale --%>
<fmt:setLocale value="${param.locale}" scope="session"/>

<%-- load the bundle (by locale) --%>
<fmt:setBundle basename="resources"/>
    <h2>
        <fmt:message key="index_jsp.link.settings" />
    </h2>
    <form action="changeLocale.jsp" method="post">
        <input type="hidden" name="locale" value="uk">
        <input type="image" src="resources/img/flag-icons-24px/24px/UA.png"/>

    </form>
    <form action="changeLocale.jsp" method="post">
        <input type="hidden" name="locale" value="ru">
        <input type="image" src="resources/img/flag-icons-24px/24px/RU.png"/>

    </form>
    <form action="changeLocale.jsp" method="post">
        <input type="hidden" name="locale" value="en">
        <input type="image" src="resources/img/flag-icons-24px/24px/GB.png"/>
    </form>
</body>
</html>