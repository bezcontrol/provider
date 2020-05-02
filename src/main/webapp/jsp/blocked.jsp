<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Not found 404</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,900" rel="stylesheet">

    <!-- Custom stylesheet -->

    <link rel="stylesheet" type="text/css" media="screen" href="../resources/css/error/style.css"/>


    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<c:if test="${(sessionScope.userBean eq null) or (sessionScope.userBean.role.name ne 'client')}">
    <c:redirect url="/service?command=allTariffs"/>
</c:if>
<div id="notfound">
    <div class="notfound">
        <div class="notfound-404">
            <h1>Oops!</h1>
        </div>
        <h2>423 -  Locked</h2>
        <p>The page you are looking for is unavailable because you have beed blocked by administrator of resource.</p>
    </div>
</div>

</body>

</html>
