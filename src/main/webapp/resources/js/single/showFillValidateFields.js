$("#serviceId2").change(function () {
    document.getElementById('serviceType').value = 'PC';
    document.getElementById('internet_speed').value = null;
    document.getElementById('internet_technology').value = null;
    document.getElementById('internetId').value = null;
    val1 = $(this).find(':selected').data('speed');
    val2 = $(this).find(':selected').data('tech');
    val3 = $(this).find(':selected').data('intid');
    document.getElementById('internetId').value = val3;
    if (val1 != 0 && val2 != 'null') {
        document.getElementById('internet_speed').value = val1;
        document.getElementById('internet_technology').value = val2;
    }
    document.getElementById('connectedPC').value = $(this).find(':selected').data('conpc');
});

$("#serviceId3").change(function () {
    document.getElementById('serviceType').value = 'TV';
    document.getElementById('internet_speed').value = null;
    document.getElementById('internet_technology').value = null;
    document.getElementById('internetId').value = null;
    val1 = $(this).find(':selected').data('speed');
    val2 = $(this).find(':selected').data('tech');
    val3 = $(this).find(':selected').data('intid');
    document.getElementById('internetId').value = val3;
    if (val1 != 0 && val2 != 'null') {
        document.getElementById('internet_speed').value = val1;
        document.getElementById('internet_technology').value = val2;
    }
    document.getElementById('typeTV').value = $(this).find(':selected').data('type');
    document.getElementById('numOfChannels').value = $(this).find(':selected').data('numofchannels');

});

$("#serviceId4").change(function () {
    document.getElementById('serviceType').value = 'Mobile';
    document.getElementById('internet_speed').value = null;
    document.getElementById('internet_technology').value = null;
    document.getElementById('internetId').value = null;
    val1 = $(this).find(':selected').data('speed');
    val2 = $(this).find(':selected').data('tech');
    val3 = $(this).find(':selected').data('intid');
    document.getElementById('internetId').value = val3;
    if (val1 != 0 && val2 != 'null') {
        document.getElementById('internet_speed').value = val1;
        document.getElementById('internet_technology').value = val2;

    }
    document.getElementById('minutesInside').value = $(this).find(':selected').data('numofmininside');
    document.getElementById('minutesOutside').value = $(this).find(':selected').data('numofminoutside');
    document.getElementById('numOfSMS').value = $(this).find(':selected').data('numofsms');
    document.getElementById('numOfMbts').value = $(this).find(':selected').data('numofmbts');

});

function yesnoCheck(that) {
    var list = document.getElementsByClassName('tariff_field');
    var n;
    for (n = 0; n < list.length; ++n) {
        list[n].value=null;
    }
    if (that.value == "PC") {
        document.getElementById("ifPC").style.display = "block";
    } else {
        document.getElementById("ifPC").style.display = "none";
    }
    if (that.value == "TV") {
        document.getElementById("ifTV").style.display = "block";
    } else {
        document.getElementById("ifTV").style.display = "none";
    }
    if (that.value == "Mobile") {
        document.getElementById("ifMobile").style.display = "block";
    } else {
        document.getElementById("ifMobile").style.display = "none";
    }
}


