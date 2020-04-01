<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Orders</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="stylesheet" href="../resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/lib/font-awesome.min.css">
    <link rel="stylesheet" href="../resources/css/admin/themify-icons.css">
    <link rel="stylesheet" href="../resources/css/admin/flag-icon.min.css">
    <link rel="stylesheet" href="../resources/css/admin/cs-skin-elastic.css">
    <link rel="stylesheet" href="../resources/css/admin/jqvmap.min.css">

    <link rel="stylesheet" href="../resources/css/admin/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

</head>

<body>
<%@ include file="../jspf/adminLeftMenu.jspf" %>

<!-- Left Panel -->

<!-- Right Panel -->

<div id="right-panel" class="right-panel">
    <%@ include file="../jspf/adminTopMenu.jspf" %>

    <div class="breadcrumbs">
        <div class="col-sm-4">
            <div class="page-header float-left">
                <div class="page-title">
                    <h1>Dashboard</h1>
                </div>
            </div>
        </div>
    </div>

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
                                        <th>Login</th>
                                        <th>Email</th>
                                        <th>Bill</th>
                                        <th>Role</th>
                                        <th>Status</th>
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
                                            <td>${contract.userBean.user.login}</td>
                                            <td>${contract.userBean.user.email}</td>
                                            <td>${contract.userBean.user.bill}</td>
                                            <td>${contract.userBean.role.name}</td>
                                            <td>${contract.userBean.status.name}</td>
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
<script src="../resources/js/admin/main.js"></script>


<script src="../resources/js/admin/Chart.bundle.min.js"></script>
<script src="../resources/js/admin/dashboard.js"></script>
<script src="../resources/js/admin/widgets.js"></script>
<script src="../resources/js/admin/jquery.vmap.min.js"></script>
<script src="../resources/js/admin/jquery.vmap.sampledata.js"></script>
<script src="../resources/js/admin/jquery.vmap.world.js"></script>

<script src="../resources/js/admin/jquery.dataTables.min.js"></script>
<script src="../resources/js/admin/dataTables.bootstrap4.min.js"></script>
<script src="../resources/js/admin/dataTables.buttons.min.js"></script>
<script src="../resources/js/admin/buttons.bootstrap4.min.js"></script>
<script src="../resources/js/admin/jszip.min.js"></script>
<script src="../resources/js/admin/pdfmake.min.js"></script>
<script src="../resources/js/admin/vfs_fonts.js"></script>
<script src="../resources/js/admin/buttons.html5.min.js"></script>
<script src="../resources/js/admin/buttons.print.min.js"></script>
<script src="../resources/js/admin/buttons.colVis.min.js"></script>
<script src="../resources/js/admin/datatables-init.js"></script>
<script src="../resources/js/menu/modernizr.custom.js"></script>
<script>
    $("#shortModal").on("show.bs.modal", function () {
        var height = $(window).height() - 200;
        $(this).find(".modal-body").css("max-height", height);
    });
</script>


<script>
    $(document).ready(function () {
        // code to read selected table row cell data (values).
        $(".btnSelect").on('click', function () {
            var currentRow = $(this).closest("tr");
            var col1 = currentRow.find("td:eq(0)").html();
            var col2 = currentRow.find("td:eq(1)").html();
            var col3 = currentRow.find("td:eq(2)").html();
            document.getElementById("login").value = col1;
            document.getElementById("email").value = col2;
            document.getElementById("bill").value = col3;
        });
    });
</script>

</body>

</html>