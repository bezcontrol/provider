<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cabinet</title>
    <link rel="stylesheet" href="../resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/lib/font-awesome.min.css">
    <link rel="stylesheet" href="../resources/css/admin/themify-icons.css">
    <link rel="stylesheet" href="../resources/css/admin/flag-icon.min.css">
    <link rel="stylesheet" href="../resources/css/admin/cs-skin-elastic.css">
    <link rel="stylesheet" href="../resources/css/admin/jqvmap.min.css">

    <link rel="stylesheet" href="../resources/css/admin/style.css">
    <link rel="stylesheet" href="../resources/css/cabinet/main.css">

</head>
<body>
<%@ include file="../jspf/menu.jspf" %>
<c:set var="pc" value='PC'/>
<c:set var="tv" value='TV'/>
<c:set var="mobile" value='Mobile'/>
<c:if test="${(sessionScope.userBean eq null) or (sessionScope.userBean.role.name ne 'client')}">
    <c:redirect url="/service?command=allTariffs"/>
</c:if>

<div id="container_header_cart">
    <h3 id="header_cart">YOUR CART</h3>
</div>

<div id="table_container">
    <div class="content mt-3">
        <div class="animated fadeIn">
            <div class="row">

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Tariffs for tv</strong>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Duration</th>
                                    <th>Type</th>
                                    <th>Channels</th>
                                    <th>Internet speed</th>
                                    <th>Internet technology</th>
                                    <th>Operations</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.cart}" var="item">
                                    <c:if test="${item.service.getClass().simpleName eq tv}">
                                        <tr>
                                            <td>${item.tariff.name}</td>
                                            <td>${item.tariff.price}$</td>
                                            <td>${item.tariff.durationInDays}</td>
                                            <td>${item.service.type}</td>
                                            <td>${item.service.numOfChannels}</td>
                                            <td>${item.internet.speed/8}</td>
                                            <td>${item.internet.technology}</td>
                                            <td>
                                                <a href="#shortModal" data-toggle="modal">
                                                    <button class="btnSelect btn btn-danger">Delete</button>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="content mt-3">
        <div class="animated fadeIn">
            <div class="row">

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Tariffs for pc</strong>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Duration</th>
                                    <th>Connected PC</th>
                                    <th>Internet speed</th>
                                    <th>Internet technology</th>
                                    <th>Operations</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.cart}" var="item">
                                    <c:if test="${item.service.getClass().simpleName eq pc}">
                                        <tr>
                                            <td>${item.tariff.name}</td>
                                            <td>${item.tariff.price}$</td>
                                            <td>${item.tariff.durationInDays}</td>
                                            <td>${item.service.numOfConnectedPC}</td>
                                            <td>${item.internet.speed/8}</td>
                                            <td>${item.internet.technology}</td>
                                            <td>
                                                <a href="#shortModal" data-toggle="modal">
                                                    <button class="btnSelect btn btn-danger">Delete</button>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="content mt-3">
        <div class="animated fadeIn">
            <div class="row">

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Tariffs for mobile</strong>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Duration</th>
                                    <th>Minutes inside country</th>
                                    <th>Minutes outside country</th>
                                    <th>SMS</th>
                                    <th>Mbts internet</th>
                                    <th>Internet speed</th>
                                    <th>Internet technology</th>
                                    <th>Operations</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.cart}" var="item">
                                    <c:if test="${item.service.getClass().simpleName eq mobile}">
                                        <tr>
                                            <td>${item.tariff.name}</td>
                                            <td>${item.tariff.price}$</td>
                                            <td>${item.tariff.durationInDays}</td>
                                            <td>${item.service.numOfMinutesInside}</td>
                                            <td>${item.service.numOfMinutesOutside}</td>
                                            <td>${item.service.numOfSMS}</td>
                                            <td>${item.service.numOfMbts}</td>
                                            <td>${item.internet.speed/8}</td>
                                            <td>${item.internet.technology}</td>
                                            <td>
                                                <a href="#shortModal" data-toggle="modal">
                                                    <button class="btnSelect btn btn-danger">Delete</button>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="btn_submit_order">
    <button class="btnSelect btn btn-success" style="font-size: 20px;">Submit</button>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../resources/js/lib/jquery-3.2.1.min.js"></script>
<script src="../resources/js/lib/popper.min.js"></script>
<script src="../resources/js/bootstrap/bootstrap.min.js"></script>

<script src="../resources/js/admin/jquery.dataTables.min.js"></script>
<script src="../resources/js/admin/dataTables.bootstrap4.min.js"></script>
<script src="../resources/js/admin/dataTables.buttons.min.js"></script>
<script src="../resources/js/admin/buttons.bootstrap4.min.js"></script>

<script src="../resources/js/admin/buttons.html5.min.js"></script>
<script src="../resources/js/admin/buttons.print.min.js"></script>
<script src="../resources/js/admin/buttons.colVis.min.js"></script>
<script src="../resources/js/admin/datatables-init.js"></script>
<script src="../resources/js/menu/modernizr.custom.js"></script>
</body>
</html>