<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
    <title>Main</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/main/demo.css">
    <link rel="stylesheet" type="text/css" href="resources/css/main/component.css">
</head>

<body>
<!-- navigation -->
<nav class="pages-nav">
    <div class="pages-nav__item"><a class="link link--page" href="#page-home">Home</a></div>
    <div class="pages-nav__item"><a class="link link--page" href="#page-docu">About</a></div>
    <c:choose>

        <c:when test="${sessionScope.user!=null}">
            <div class="pages-nav__item"><a class="link link--page" onclick="location.href='/jsp/cabinet.jsp'">
                Hello, ${sessionScope.user.login}
            </a></div>
        </c:when>
        <c:otherwise>
            <div class="pages-nav__item"><a class="link link--page" onclick="location.href='index.jsp'">
                Login
            </a></div>

        </c:otherwise>
    </c:choose>

    <div class="pages-nav__item"><a class="link link--page" href="#page-software">Personal Computers</a></div>
    <div class="pages-nav__item"><a class="link link--page" href="#page-custom">Television</a></div>
    <div class="pages-nav__item"><a class="link link--page" href="#page-training">Mobile phones</a></div>
    <div class="pages-nav__item pages-nav__item--social">
        <a class="link link--social link--faded" href="#"><i class="fa fa-twitter"></i><span
                class="text-hidden">Twitter</span></a>
        <a class="link link--social link--faded" href="#"><i class="fa fa-linkedin"></i><span class="text-hidden">LinkedIn</span></a>
        <a class="link link--social link--faded" href="#"><i class="fa fa-facebook"></i><span class="text-hidden">Facebook</span></a>
        <a class="link link--social link--faded" href="#"><i class="fa fa-youtube-play"></i><span class="text-hidden">YouTube</span></a>
    </div>
</nav>
<!-- /navigation-->
<!-- pages stack -->
<div class="pages-stack">
    <!-- page -->
    <div class="page" id="page-home">
        <!-- Blueprint header -->
        <header class="bp-header cf">
            <h1 class="bp-header__title">Home</h1>
        </header>
        <img class="poster" src="images/1.jpg" alt="img01"/>
    </div>
    <!-- /page -->
    <div class="page" id="page-docu">
        <header class="bp-header cf">
            <h1 class="bp-header__title">About</h1>
            <p class="info">
                "We cannot have peace among men whose hearts find delight in killing any living creature." &mdash;
                Rachel Carson
            </p>
        </header>
        <img class="poster" src="images/6.jpg" alt="img06"/>
    </div>

    <div class="page" id="page-software">
        <header class="bp-header cf">
            <h1 class="bp-header__title">Personal computers</h1>
            <p class="info">
                "I decided to pick the diet that I thought would maximize my chances of long-term survival." &mdash; Al
                Gore
            </p>
        </header>
        <img class="poster" src="images/3.jpg" alt="img03"/>
    </div>
    <div class="page" id="page-custom">
        <header class="bp-header cf">
            <h1 class="bp-header__title">Television</h1>
            <p class="info">
                "You have to make a conscious decision to change for your own well-being, that of your family and your
                country." &mdash;Bill Clinton
            </p>
        </header>
        <img class="poster" src="images/4.jpg" alt="img04"/>
    </div>
    <div class="page" id="page-training">
        <header class="bp-header cf">
            <h1 class="bp-header__title">Mobile phones</h1>
            <p class="info">
                "The moment I began to understand what was going on with the treatment of animals, it led me more and
                more in the way of the path I am [on] now, which is a complete vegan." &mdash; Bryan Adams
            </p>
        </header>
        <img class="poster" src="images/5.jpg" alt="img05"/>
    </div>
</div>
<!-- /pages-stack -->
<button class="menu-button"><span>Menu</span></button>
<script src="resources/js/main/modernizr.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
<script src="resources/js/main/classie.js"></script>
<script src="resources/js/main/main.js"></script>

</body>

</html>
