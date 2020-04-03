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
    <h3 id="header_cart">YOUR CABINET</h3>
</div>

<div id="table_container">
    <div class="content mt-3">
        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Data Table</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table-export" class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th style="display:none">User id</th>
                                        <th>Login</th>
                                        <th>Email</th>
                                        <th style="display:none">Tariff id</th>
                                        <th>Tariff name</th>
                                        <th>Price</th>
                                        <th>Duration</th>
                                        <th>Contract conclusion date</th>
                                        <th>Contract expiration date</th>
                                        <th>State</th>
                                        <th>Operations</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${sessionScope.contracts}" var="contract">
                                        <tr>
                                            <td>${contract.contract.id}</td>
                                            <td style="display:none">${contract.userBean.user.id}</td>
                                            <td>${contract.userBean.user.login}</td>
                                            <td>${contract.userBean.user.email}</td>
                                            <td style="display:none">${contract.tariff.id}</td>
                                            <td>${contract.tariff.name}</td>
                                            <td>${contract.tariff.price}</td>
                                            <td>${contract.tariff.durationInDays}</td>
                                            <td>${contract.contract.contractConclusionDate}</td>
                                            <td>${contract.contract.contractExpirationDate}</td>
                                            <td>${contract.contractState.name}</td>
                                            <td>
                                                <a href="#shortModal" data-toggle="modal">
                                                    <button class="btnSelect btn btn-primary">Update</button>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- .animated -->
        </div>
    </div>
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

<script>
    $("#shortModal").on("show.bs.modal", function() {
        var height = $(window).height() - 200;
        $(this).find(".modal-body").css("max-height", height);
    });
</script>

<script>
    $(document).ready(function(){
        // code to read selected table row cell data (values).
        $(".btnSelect").on('click',function(){
            var currentRow=$(this).closest("tr");
            var col1=currentRow.find("td:eq(0)").html();
            var col2=currentRow.find("td:eq(1)").html();
            document.getElementById("tariffId").value=col1;
            document.getElementById("name").value=col2;
        });
    });
</script>
</body>
</html>