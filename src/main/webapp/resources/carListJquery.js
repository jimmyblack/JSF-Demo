$(document).ready(function() {
    $("tr:odd").css("backgroundColor", "#DDDDDD");

    $(".priceColumn").each(function() {
        if ($(this).text() > 10000 ) {
            $(this).parent().css("font-weight", "bold");
            $(this).css("color", "red");
        }
    })

})

window.onload = function() {

    // get maxId
    var maxId = 0;
    $(".idColumn").each(function() {
        $("#aCarLink").attr("id", "carLink" + $(this).text());

        if (Number($(this).text()) > maxId) {
            maxId = Number($(this).text());
        }
    });

    (function() {
        var flickerAPI = "http://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?";
        $.getJSON( flickerAPI, {
            tags: "racing car",
            tagmode: "any",
            format: "json"
        })
            .done(function( data ) {
                    $.each( data.items, function( i, item ) {

                    // header images
                    if (i << 5) {
                        $("#images").append("<a id = \"a_" + i + "\" href=\"http://www.w3.org\"/>");
                        $( "<img>" ).attr( "src", item.media.m).appendTo("#a_" + i);

                        // ignore click
                        $( "#a_" + i ).click(function( event ) {
                            event.preventDefault();
                            //$( this ).hide();
                        });
                    }

                    // car images
                    $( "<img>" ).attr( "src", item.media.m).appendTo("#carLink" + i);
                    $( "#carLink" + i ).click(function( event ) {
                        event.preventDefault();
                    });

                    if ( i === maxId ) {
                        return false;
                    }
                });
            });
    })();



};