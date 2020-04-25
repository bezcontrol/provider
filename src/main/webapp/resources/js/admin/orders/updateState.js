$(document).ready(function () {
    // code to read selected table row cell data (values).
    setOnClickEvent();
});

function setOnClickEvent(){
    $(".btnSelect").on('click', function () {
        var currentRow = $(this).closest("tr");
        var contractId = currentRow.find("td:eq(0)").html();
        var userId = currentRow.find("td:eq(1)").html();
        var login = currentRow.find("td:eq(2)").html();
        var tariffId = currentRow.find("td:eq(7)").html();
        var contractConclusionDate = currentRow.find("td:eq(11)").html();
        var contractExpirationDate = currentRow.find("td:eq(12)").html();
        document.getElementById("contractId").value = contractId;
        document.getElementById("userId").value = userId;
        document.getElementById("login").value = login;
        document.getElementById("tariffId").value = tariffId;
        document.getElementById("contractConclusionDate").value = contractConclusionDate;
        document.getElementById("contractExpirationDate").value = contractExpirationDate;
    });
}

$(document).on('click', '.paginate_button', function () {
    setOnClickEvent();
});