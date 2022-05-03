/* 
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 * https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css
 */
var ajax;

/**
 * Initializes request object
 * @type void
 * @returns {}
 */
function fieldFormatter(field, type) {
    switch (type) {
        case 'ssn':
            const input = document.getElementById('ssn');
            const ssn = input.value.replace(/[^\d]/g, '');
            const slength = input.value.length;
            var fval = ``;
            if (slength < 4)
                fval = ssn;
            if (slength < 6) {
                fval = `${ssn.slice(0, 3)}-${ssn.slice(3)}`;
            } else {
                fval = `${ssn.slice(0, 3)}-${ssn.slice(3, 5)}-${ssn.slice(5, 9)}`;
            }
            input.value = fval;
            ;
            break;
        case '':
    }
}
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
        $(document).ajax({url: 'DBAction?actiontype=SearchPatient', success: function (result) {
                let res = document.getElementById("result");
                $("#result").html(res);
            }});
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
    let maxDate = getTodayDate();
    if (uri.indexOf('CDC') !== -1) {

    } else if (uri.indexOf('DoctorLogin') !== -1) {

    } else if (uri.indexOf('Patient Login') !== -1) {

    }
    $("#resetForm").click(evt => {
        $(".pat_info").each((i, e) => {
            let eid = e.id;
            let id = '#' + eid;
            if ($(id).css("display") === 'block') {
                $(id).css("display", 'none');
            }

        });
        if ($(".sch").css("display") === "block") {
            $(".sch").css("display", "none");
        }
        if ($("#ssn1").css("display") === 'block') {
            $("#ssn1").css("display", 'none');
        }
        if ($("#vac_id1").css("display") === 'block') {
            $("#vac_id1").css("display", "none");
        }
        $(".sortval input").each((index, e) => {
            if (e.hasAttribute("checked")) {
                e.removeAttribute("checked");
            }
        });
    });
    var ty = getTodayDate();
    document.getElementById("dbaction").onsubmit = () => {

    };
    $("#vac_date").attr("max", maxDate);
    $("#dob").attr("max", maxDate);
    $("#msg-btn").attr("onclick", "toggleList('msg-content')");
    $("#help-btn").attr("onclick", "toggleList('help-content')");
    $("#ssn").attr('onkeydown', "fieldFormatter('ssn', 'ssn')");
    $("#ssn").attr('onchange', "fieldFormatter('ssn', 'ssn')");
//                $("tr").each((index, e)=>{
//                    if (e.hasAttribut) 
//                });
//    });
    $(".actions button").click(evt => {
        let e = evt.currentTarget;
        if (e.value === "AddPatient") {
            window.location = "./PatientView.jsp";
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
                $("#action").val('Edit Vaccine');
                $("#actiontype").val("EditVaccine");
                if ($("#vac_id1").css("display") === 'none') {
                    $("#vac_id1").css("display", "block");
                }
            } else if ($(".sch").css("display") === "block") {
                $(".sch").css("display", "none");
                if ($("#ssn1").css("display") === 'block') {
                    $("#ssn1").css("display", 'none');
                }
                if ($("#vac_id1").css("display") === 'block') {
                    $("#vac_id1").css("display", "none");
                }
            }
        } else if (e.value === "EditPatient") {
            $("#action").val('Edit Patient');
            if ($(".sch").css("display") === "block") {
                $(".sch").css("display", "none");
            } else if ($(".sch").css("display") === "none") {
                $(".sch").css("display", "block");
            }
            $("#action").val('Edit Patient');
        } else if (e.value === "AddVaccine") {
            $("#actiontype").val("AddVaccine");
           pageAction("AddVaccine");
        } else if (e.value === 'EditPatient') {
            $("#action").val('Search Patient');
//            let sicon = document.createElement(i);


        } else if (e.value === 'AddPatient') {
            window.location = './PatientView.jsp';
        }
    });
    $("#action").click(evt => {
        let val = $("#action").val();
        if (val === 'Search Patient') {
            document.getElementById("dbaction").setAttribute("method", "get");
        } else {
            document.getElementById("dbaction").setAttribute("method", "post");
        }
        switch (val) {
            case 'Search Patient':
                $("#actiontype").val('SearchPatient');
                pageAction("SearchPatient");
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
                $("#actiontype").val('EditVaccine');
                       pageAction2("EditVaccine", '');
                ;
                break;
            case 'Add Vaccine':
                $("#actiontype").val('AddVaccine');
                  document.getElementById("dbaction").setAttribute("method", "post");
                pageAction("AddVaccine")
                        ;
                break;
            default:
                ;
        }
    });
    $("#Logout").click(() => {
        let c = confirm("Are you Sure you want to logout?");
        if (c === true) {
            pageAction2('Logout');
        }
    });
    $("#ssn").attr("oninput")
    $(".sortval").click(evt => {
        let e = evt.currentTarget;
        let check = e.getAttribute("checked");
        let eid = "#" + evt.currentTarget.value;
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
                $(eid).css("display", "none");
            }
        } else if (!e.hasAttribute("checked")) {

            if ($(eid).css("display") === "block") {
                $(eid).css("display", "none");
            } else {
                $(x).attr("checked", "null");
                $(eid).css("display", "block");
            }
        }
    });
    $('.sch #action').click(evt => {
        pageAction("SearchPatient", "");
        evt.preventDefault();
    });
    document.getElementById("dbaction").onsubmit = evt => {

    };
    $(".pat_info").each((index, e) => {
        let eid = e.id;
        let id = '#' + eid;
//        console.log(eid);

        switch (eid) {
            case "ssn":
                $(id).attr("oninvalid", () => {
                    document.getElementById(eid).setCustomValidity('Social Security Number must be in thie format: 123-45-6789'
                            + ' First 3 digits cannot start with 000, 666 or between 900 and 999.'
                            + ' Next 2 digits should be any digit between 01-99. '
                            + ' Last 4 digits should not be 0000.');
                });
                break;
            case 'fname':
                $(id).attr("oninvalid", () => {
                    document.getElementById(eid).setCustomValidity('First Name must only contain letters.');
                });
                break;
            case 'midinit':
                $(id).attr("oninvalid", () => {
                    document.getElementById(eid).setCustomValidity('Middle Initial must be only 1 letter');
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

