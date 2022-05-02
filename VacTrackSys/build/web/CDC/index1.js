/* 
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */

$(document).ready(() => {

    $("#v-btn-p").click(evt => {
        toggleV('upwd', 'v-btn-p');
        evt.preventDefault();
    });
    $("#v-btn-c").click(evt => {
        toggleV('confpasswd', 'v-btn-c');
        evt.preventDefault();
    });
    $("#terms").click(evt => {
        var c = document.getElementById("terms");
        if (c.getAttribute("checked") === null) {
            c.setAttribute("checked", null);
            if (!document.getElementById("newacct").getAttribute('disabled') === null) {
                document.getElementById("newacct").removeAttribute("disabled");
            }

        } else {
            c.removeAttribute("checked");
            if (document.getElementById("newacct").getAttribute('disabled') === null) {
                document.getElementById("newacct").setAttribute("disabled", null);
            }

        }
    });
    $("input.input-field").each((index, e) => {
        //let e = evt.currentTarget;
        if (e.type === 'checkbox') {
            e.setAttribute('oninput', '');
        } else {

            if (e.type === 'email') {

            } else if (e.type === 'password') {
                if (e.id === 'confpasswd') {

                    $("#confpasswd").attr('oninput', () => {
                        let cval = $("#confpasswd").val(), pval = $("#upwd").val();
                        cval.trim();
                        pval.trim();

                        if (cval === pval) {
                            $("#msgc").text("Confirm Password is valid!");

                        } else {
                            $("#msgc").text("Confirm Password does not match original.");
                        }
                    });
                } else if (e.id === 'passwd') {

                } else if (e.id === 'upwd') {
                    $("#upwd").attr('onchange', "validateInput('#upwd', 'password', 'DOC')");/* (evt) => {
                     let cval = $("#upwd").val();
                     //                        if 
                     cval.trim();
                     if (cval.length < 15) {
                     let m = cval.length + ' characters long. Must be 15 chraracters';
                     $("#msg").text(m);
                     } else if (cval.length >= 15) {
                     // let m = cval.length + ' characters long. Must be 15 chraracters';
                     $("#msg").text('password is valid');
                     }
                     evt.preventDefault();
                     });*/
                }
            } else if (e.type === 'text') {
                if (e.name === 'userid') {

                } else if (e.name === 'upwd' || e.name === 'passwd') {

                }
            }
        }
    });
    $("select.input-field").change(evt => {
        let v = $("select.input-field").val();
        let ans = document.getElementById("answer");
        if (v !== "") {
            if (ans.hasAttribute('disabled')) {
                $("#answer").removeAttr('disabled');
            } 
        } else if (v === "") {
            if (!ans.hasAttribute('disabled')) {
                $("#answer").attr('disabled', '');
            }
//            else if (!ans.hasAttribute('disabled')) {
//                $("#answer").attr('disabled', '');
//
//            }
        }
    }
    );
    document.getElementById("newacct").onsubmit = () => {
        $("#newacct").disabled = true;
        document.getElementById("newacct").submit();
    };
    //$("#upwd").attr('oninvalid', ev=>{ev.currentTarget.setCustomValidity("password must be at least 15 characters long. (255 characters max)");});
    document.getElementById("upwd").addEventListener('invalid', function (ev) {
        ev.target.setCustomValidity('');
    });
    document.getElementById("passwd").addEventListener('invalid', function (ev) {
        ev.target.setCustomValidity('password must be at least 15 characters long.');
    });
    document.getElementById("userid").addEventListener('invalid', function (ev) {
        ev.target.setCustomValidity('Employee ID must contain only numbers and must be at least 8 characters long.');
    });
    document.getElementById("uid").addEventListener('invalid', function (ev) {
        ev.target.setCustomValidity('Employee ID must contain only numbers and must be at least 8 characters long.');
    });
    document.getElementById("email").addEventListener('invalid', function (ev) {
        ev.target.setCustomValidity('Email Address must have: no special characters(e.g. &,*,(),#,!,$,%, etc.) after @ symbol.\n\
             ');
    });
});

