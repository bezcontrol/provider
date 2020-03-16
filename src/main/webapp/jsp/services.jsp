<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Services</title>
    <link href="../resources/css/services/main.css" rel="stylesheet">
    <%@ include file="../jspf/menu.jspf"%>
</head>
<body>
<div class="centerflipcards">
    <div class="square-flip">
        <div class='square' data-image="../resources/img/tv.png">
            <div class="square-container">
                <div class="align-center"><img src="http://titanicthemes.com/files/flipbox/kallyas2.png" class="boxshadow" alt=""></div>
                <h2 class="textshadow">TELEVISION</h2>
                <h3 class="textshadow">You can choose Smart-TV, IP-TV or another types of your television!</h3>
            </div>
            <div class="flip-overlay"></div>
        </div>
        <div class='square2' data-image="../resources/img/tv.png">
            <div class="square-container2">
                <div class="align-center"></div>
                <a href="${pageContext.request.contextPath}/service?command=tvTypes" class="boxshadow kallyas-button">View more</a>
            </div>
            <div class="flip-overlay"></div>
        </div>
    </div>

    <div class="square-flip">
        <div class='square' data-image="../resources/img/pc.png">
            <div class="square-container">
                <div class="align-center"><img src="http://titanicthemes.com/files/flipbox/kallyas.png" class="boxshadow" alt=""></div>
                <h2 class="textshadow">COMPUTERS</h2>
                <h3 class="textshadow">The #1 Selling internet tatiffs for personal computers!</h3>
            </div>
            <div class="flip-overlay"></div>
        </div>
        <div class='square2' data-image="../resources/img/pc.png">
            <div class="square-container2">
                <div class="align-center"></div>
                <a href="${pageContext.request.contextPath}/service?command=pcTariffs" class="boxshadow kallyas-button">View more</a>
            </div>
            <div class="flip-overlay"></div>
        </div>
    </div>

    <div class="square-flip">
        <div class='square' data-image="../resources/img/mobile.png">
            <div class="square-container">
                <div class="align-center"><img src="http://titanicthemes.com/files/flipbox/kallyas.png" class="boxshadow" alt=""></div>
                <h2 class="textshadow">PHONES</h2>
                <h3 class="textshadow">The #1 Selling internet tatiffs for mobile phones!</h3>
            </div>
            <div class="flip-overlay"></div>
        </div>
        <div class='square2' data-image="../resources/img/mobile.png">
            <div class="square-container2">
                <div class="align-center"></div>
                <a href="${pageContext.request.contextPath}/service?command=mobileTariffs" class="boxshadow kallyas-button">View more</a>
            </div>
            <div class="flip-overlay"></div>
        </div>
    </div>
    <br/>
    <br/>

</div>



<script src="../resources/js/login/lib/jquery-3.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../resources/js/service/script.js"></script>
</body>
</html>