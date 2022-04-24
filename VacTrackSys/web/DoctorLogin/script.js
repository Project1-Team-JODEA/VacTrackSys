/* 
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 * https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css
 */
function reqAction(action) {

    if (action === "SearchPatient") {
        $.ajax({url: 'DBAction?actiontype=SearchPatient', success: function (result) {
                let res = document.getElementById("result");
                $("#result").html(res);
            }});
//        $.a
    }


}
function actionResponse(url) {

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
            } else if ($(".sch").css("display") === "block") {
                $(".sch").css("display", "none");
                $(".sortval").each((index, e) => {
                    if (e.hasAttribute('style')) {
                        if (e.getAttribute("style")) {
                            console.log("element: is opened");
                        }
                    }
                });
            }
        } else if (e.value === "Edit Vaccine") {
            if ($(".sch").css("display") === "block") {
                $(".sch").css("display", "none");
            }
        } else if (e.value === "Add Vaccine") {
//            window.location = "./VacView.jsp";

        }
    });

//   document.getElementById(".toggle-btn").onclick = ();
//    $("#help-btn").click(evt =>{
//        toggleList('help-content');
//    });
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
    $('.sch input[value="Search"').attr("onclick", "reqAction('SearchPatient');");
    $(".pat_info").each((index, e) => {
        let eid = e.id;
        let id = '#' + eid;
//        console.log(eid);

        switch (eid) {
            case "ssn":
                $(id).attr("oninvalid", () => {
                    document.getElementById(eid).setCustomValidity('Social Security Number must be 9 numeric characters.');
                });
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

});

