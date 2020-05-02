$(".slider")

    .slider({
        min: 0,
        max: 1000,
        range: true,
        values: [0, 1000],
        slide: function( event, ui ) {
            var minimum_val = $(".slider").slider("values",0);
            var maximum_val = $(".slider").slider("values",1);

            $( "#lower_price" ).html( minimum_val );
            $( "#upper_price" ).html( maximum_val );
        }
    })

    .slider("pips", {
    })

    .slider("float");


$( "#lower_price" ).html(  $(".slider").slider("values",0) );
$( "#upper_price" ).html(  $(".slider").slider("values",1) );
