// global variables
var theNum = 1;
var dvdCatalog = {
    name  : "Pink Floyd",
    id    : "1"
}

var cubeProto = {
    nuber : "1"
}

var CubeModel = function () {
    prototype = cubeProto;
    var cubeme = function () {
        if (incomingNum === 1) {
            return "What are you doing?";
        } else {
            return Math.pow(incomingNum, 3);
        }
    }
    var cubeMsg = function (theNum) {
        var res = cubeme(parseInt(theNum, 10));
        if (isNaN(res)) {
            alert("You should know that 1 to any power is 1");
        } else {
            alert("When cubed, " + theNum + " is " + res);
        }
    }
}

var theCube = new CubeModel();


function popup() {
    alert("hello & goodbye");
}

function doWrite(something) {
    document.write(something);
}

function doWriteLn(something) {
    document.write("<br/>");
    if (something != null) {
        document.write(something);
    }
}

function cubeme(incomingNum) {
    if (incomingNum === 1) {
        return "What are you doing?";
    } else {
        return Math.pow(incomingNum, 3);
    }
}

function updateValues(theValue) {
    theNum = theValue;
}

function cubemeMsg(theNum) {
    if (theNum === "") {
        alert("input number is empty!!!");
        return;
    }
    var res = cubeme(parseInt(theNum, 10));
    if (isNaN(res)) {
        alert("You should know that 1 to any power is 1");
    } else {
        alert("When cubed, " + theNum + " is " + res);
    }
}

function getBrowserInfo() {
    alert(navigator.userAgent);
}

function computeDaysUntilNewYear(dateField) {
    var today = new Date(),
        then = new Date();

    // first day of the next year
    var nextYear = today.getFullYear() + 1;
    then.setFullYear(nextYear, 0, 1);

    var diff = then.getTime() - today.getTime();
    diff = Math.floor(diff / (1000 * 60 * 60 * 24));

    var dateLoc = document.getElementById(dateField);
    if (dateLoc != null) {
        dateLoc.innerHTML = "There are " + diff + " days until " + then.toLocaleDateString()
    }
}