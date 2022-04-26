/* 
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 * https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css
 */
var ajax;
window.onload = init;
/**
 * Initializes request object
 * @type void
 * @returns {}
 */
function init() {

    // Get an XMLHttpRequest object:

    if (window.XMLHttpRequest) {
        ajax = new XMLHttpRequest();
    } else if (window.ActiveXObject) { // Older IE browsers

        // Create type Msxml2.XMLHTTP, if possible:
        try {
            ajax = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) { // Create the older type instead:
            try {
                ajax = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
            }
        }

    }
    //ajax = getXMLHttpRequestObject();

    if (ajax) {
        // Function that handles the response:
        ajax.onreadystatechange = handleResponse;

    }
}
function handleResponse() {

    // Check that the transaction is complete:
    if (ajax.readyState === 4) {

        // Check for a valid HTTP status code:
        if ((ajax.status === 200) || (ajax.status === 304)) {

            // Put the received response in the DOM:
            var results = document.getElementById('results');
//            console.log(results);
            results.innerHTML = ajax.responseText;
        } else { // Bad status code, submit the form normally
            document.getElementById('dbaction').submit();
        }
    } // End of readyState IF.
}
function reqAction(action) {
    var ajax = false;
    if (window.XMLHttpRequest) {
        ajax = new XMLHttpRequest();
    }
//    }else if (){
    if (action === "SearchPatient") {
//        $(document).ajax({url: 'DBAction?actiontype=SearchPatient', success: function (result) {
//                let res = document.getElementById("result");
//                $("#result").html(res);
//            }});
//$.post('DBAction', {'actiontype':'SearchPatient'});
        $.post('DBAction', {'actiontype': 'SearchPatient'}, function (data, status) {
            if (status === "success") {
                //        XMLHttpRequest.o
                if (XMLHttpRequest.status === 200 || XMLHttpRequest.status === 304) {
                    let res = XMLHttpRequest.responseText;
                    $("#result").html(res);
                }
            }
        });
//        XML
//        $.get('DBAction?actiontype=SearchPatient', '', function (data, status, xhr) {
//
//            if (status === "success") {
//                //let res = document.getElementById("result");
//
//
//                let res = XMLHttpRequest.responseText;
//                $("#result").html(res);
//            }
//        }, 'html');
//$.ajax
//    $(document).ajax({url: 'DBAction?actiontype=SearchPatient', success});
//       
//        $.a
    } else {
        document.getElementById("dbaction").submit();
    }


}
function actionResponse(url) {

}
function action(action) {

    $("#actiontype").val(action);
    if (ajax && action === 'SearchPatient') {
        $.get("DBAction", function (data, status, xhr) {

        }, dataType = 'html');
    } else {
        $("#actiontype").val(action);
        document.getElementById("dbaction").submit();
    }

}

$(document).ready(() => {
    let uri = document.baseURI;
    let webloc = uri.split('/');
//    if (uri)
    if (uri.indexOf('CDC') !== -1) {

    } else if (uri.indexOf('DoctorLogin') !== -1) {

    } else if (uri.indexOf('Patient Login') !== -1) {

    }
    var today = getTodayDate();
    document.getElementById("dbaction").onsubmit = () => {

    };
    $("#vac_date").attr("max", today);
    $("#dob").attr("max", today);
    $("#msg-btn").attr("onclick", "toggleList('msg-content')");
    $("#help-btn").attr("onclick", "toggleList('help-content')");
    $(".actions button").click(evt => {
        let e = evt.currentTarget;
        if (e.value === "AddPatient") {

        } else if (e.value === "SearchPatient") {
            if ($(".sch").css("display") === "none") {
                $(".sch").css("display", "block");
                $("#action").val('Search Patient');
            } else if ($(".sch").css("display") === "block") {
                $(".sch").css("display", "none");
                $(".sortval").each((index, e) => {
                    if (e.hasAttribute('style')) {
                        if (e.getAttribute("style")) {
// console.log("element: is opened");
                        }
                    }
                });
            }

        } else if (e.value === "EditVaccine") {

            if ($(".sch").css("display") === "none") {
                $(".sch").css("display", "block");
                let sbtn = document.getElementById("#list-btn"),
                        abtn = document.getElementById("action");

//                if ($(".sortbtn"))

                if (!sbtn.hasAttribute("disabled")) {
                    sbtn.setAttribute('disabled', null);
                } else if (sbtn.hasAttribute('disabled')) {
                    sbtn.removeAttribute('disabled');
                }
                $("#action").val('Edit Vaccine');
            } else if ($(".sch").css("display") === "block") {
                $(".sch").css("display", "none");

                if ($("#ssn1").css("display") === 'block') {
                    $("#ssn1").css("display", 'none');
                }
            }
        } else if (e.value === "EditPatient") {
            $("#action").val('Search Patient');
            if ($(".sch").css("display") === "block") {
                $(".sch").css("display", "none");
            } else if ($(".sch").css("display") === "none") {
                $(".sch").css("display", "block");
            }
            $("#action").val('Edit Patient');
        } else if (e.value === "AddVaccine") {
            window.location = "./VacView.jsp";
        } else if (e.value === 'EditPatient') {
            $("#action").val('Search Patient');
        } else if (e.value === 'AddPatient') {
            window.location = './PatientView.jsp';
        }
    });
//   document.getElementById(".toggle-btn").onclick = ();
//    $("#help-btn").click(evt =>{
//        toggleList('help-content');
//    });
    $("#action").click(evt => {
        let val = $("#action").val();
        switch (val) {
            case 'Search Patient':
                $("#actiontype").val('SearchPatient');
                pageAction('SearchPatient')
                        ;
                break;
            case 'Add Patient':
                $("#actiontype").val('AddPatient')
                        ;
                break;
            case 'Edit Patient':
                $("#actiontype").val('EditPatient')
                        ;
                break;
            case 'Search Vaccine':
                $("#actiontype").val('SearchVaccine')
                        ;
                break;
            case 'Edit Vaccine':
                $("#actiontype").val('EditVaccine')
                        ;
                break;
            case 'Add Vaccine':
                $("#actiontype").val('AddVaccine')
                        ;
                break;
            default:
                ;
        }
        if (val === 'Search Patient') {
        }
    });
    $("#logout").hover(evt => {
        let t = document.getElementById("logout");
        if (t.classList.contains('fa-door-closed')) {
            t.classList.replace('fa-door-closed', 'fa-door-open');
        } else if (t.classList.contains('fa-door-open')) {
            t.classList.replace('fa-door-open', 'fa-door-closed');
        }
        evt.preventDefault();
    });
    $("#logout").click(() => {
        let c = confirm("Are you Sure you want to logout?");
        if (c === true) {
            pageAction2('Logout');
        }
    });
    $(".sortval").click(evt => {
        let e = evt.currentTarget;
//            let val = ;
        let check = e.getAttribute("checked");
        let eid = "#" + evt.currentTarget.value;
//        let cid = 'tr.'+e.value;

        let y = eid + " .pat_info";
        let x = '.sortval[value="' + e.value + '"]';
//        console.log("y: "+);
        let id = eid.substring(1, eid.length - 1);
        let e2 = document.getElementById(id);
        if (e.hasAttribute("checked")) {

            if ($(eid).css("display") === "none") {
                $(eid).css("display", "block");
            } else {
//                 let x = '.sortval input [value="'+e.value+'"]';
                $(x).removeAttr("checked");
//                if ()

                $(eid).css("display", "none");
                if (e2.hasAttribute("required")) {
                    e2.removeAttribute("required");
                }
            }
        } else if (!e.hasAttribute("checked")) {

            if ($(eid).css("display") === "block") {
                $(eid).css("display", "none");
            } else {
                if (!e2.hasAttribute("required")) {
                    e2.setAttribute("required", null);
                }
                $(x).attr("checked", "null");
                $(eid).css("display", "block");
            }
        }
    });
    $('.sch #action').click(evt => {
        reqAction('SearchPatient');
    });
    document.getElementById("dbaction").onsubmit = evt => {

    };
    $(".pat_info").each((index, e) => {
        let eid = e.id;
        let id = '#' + eid;
//        console.log(eid);

        switch (eid) {
            case "ssn":
//                $(id).attr("oninvalid", () => {
//                    document.getElementById(eid).setCustomValidity('Social Security Number must be 9 numeric characters.'
//                            + ' First 3 digits cannot start with 000, 666 or between 900 and 999.'
//                            + ' Next 2 digits should be any digit between 01-99. '
//                            + ' Last 4 digits should not be 0000.');
//                });
                break;
            case 'fname':
                $(id).attr("oninvalid", () => {
                    document.getElementById(eid).setCustomValidity('');
                });
                break;
            case 'midinit':
                $(id).attr("oninvalid", () => {
                    document.getElementById(eid).setCustomValidity('');
                });
                break;
//            case ''
        }
    });
    $(".sort li span.details").click(evt => {
        let e = evt.currentTarget;
        let input = $(".sort li span.details").siblings("input");
        console.log(input);
    });
})
        ;

