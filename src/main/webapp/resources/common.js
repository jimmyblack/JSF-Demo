
// closure function
function celebrityName (theLastName) {
    var nameIntro = "This celebrity is ";

    function lastName (firstName) {
        return nameIntro + firstName + " " + theLastName;
    }

    return lastName;
}

var celebrity = celebrityName("Jackson");

// the closure function
Function.prototype.bind = function (object) {
    var functionToBind = this;
    return function () {
        return functionToBind.apply(object, arguments);
    };
};

// multiple arguments
function doMultipleArguments() {
    doWrite("<br/> MultipleArguments:")
    for(var i = 0, max = arguments.length; i < max; i++) {
        switch (typeof arguments[i]) {
            case "string":
                doWrite("<br/> arguments[" + i + "]: \"" + arguments[i] + "\"");
                break;
            case "number":
                doWrite("<br/> arguments[" + i + "]: " + arguments[i]);
                break;
            case "object":
                if (arguments[i] instanceof Date) {
                    doWrite("<br/> arguments[" + i + "]: " + arguments[i].toLocaleDateString());
                }
                break;
            default:
                doWrite("<br/> arguments[" + i + "]: " + arguments[i]);
        }
    }
}

// anonymous function
var divNums = function (x, y) {
    return x / y;
}

function getName() {
    return this.name;
}

var person1 = {
    "name": "Ana",
    "getName": getName
};

var person2 = {
    "name": "Matei",
    "getName": getName
};

// objects
function Star(constell, type, spectralCls, magnitude) {
    this.constellation = constell;
    this.type = type;
    this.spectralClass = spectralCls;
    this.magnitude = magnitude;


    var thisItem = this;
    this.toString = function () {
        return thisItem.constellation + ", " + thisItem.type + ", " + thisItem.spectralClass + ", " + thisItem.magnitude;
        //return this.constellation + ", " + this.type + ", " + this.spectralClass + ", " + this.magnitude;
    }

}

// timer
var timer = setInterval(function(){updateTimer()},1000);

function updateTimer()
{
    var date = new Date();
    var timeStr = date.toLocaleTimeString();
    document.getElementById("timeCCId").innerHTML = timeStr;
}