$(document).ready(function() {
    $("#braingiaLink").click(function() {
        alert("hello");
    })

    $("#myDiv").click( function() {
        $("#braingiaLink").click();
    } );

    $("#wrapperP").mouseover( function () {
            $("#braingiaLink").hide();
        }
    );

    $("#wrapperP").mouseout( function() {
        $("#braingiaLink").show();
    });

    // animation
    $("#block1").animate({
        left: "150px",
        opacity: .5
    }, {
        duration: 2500
    });
    $("#block2").animate({
        bottom: "50px",
        opacity: .5
    }, {
        duration: 1000,
        opacity: "toggle"
    });
    $("#block3").animate({
        bottom: "50px",
        opacity: .5
    }, {
        duration: 1500,
        opacity: "toggle"
    });
    $("#block4").animate({
        bottom: "50px",
        opacity: .5
    }, {
        duration: 2000,
        opacity: "toggle"
    });
})