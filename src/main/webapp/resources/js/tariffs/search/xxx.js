let minimum_val=0;
let maximum_val=1000;

$(".slider")

    .slider({
        min: 0,
        max: 1000,
        range: true,
        values: [minimum_val, maximum_val],
        slide: function( event, ui ) {
            minimum_val = $(".slider").slider("values",0);
            maximum_val = $(".slider").slider("values",1);

            $( "#lower_price" ).html( minimum_val );
            $( "#upper_price" ).html( maximum_val );

            document.getElementById("lowerPrice").value=minimum_val;
            document.getElementById("upperPrice").value=maximum_val;
        }
    })

    .slider("pips", {
    })

    .slider("float");


document.getElementById("lowerPrice").value=minimum_val;
document.getElementById("upperPrice").value=maximum_val;

