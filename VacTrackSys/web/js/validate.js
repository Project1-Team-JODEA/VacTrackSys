/* 
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 
 */

/**
 * @author Elena_Miller 
 * @file validate.js
 * @fileOverview Validation Script
 * @description description
 * 
 */
/**
 * validate input pattern
 * @param {type} id
 * @param {type} type
 * @param {type} e
 * @returns {undefined}
 */
function validateInput(id, type, userType) {
    if (type === 'email') {

    } else if (type === 'password') {
        let val = $(id).val();
        if (userType === 'DOC' || userType === 'ADM') {
            if (val.length < 15) {                
                $("#msg").text('Must be 15 chraracters long');
            }
        }
        if (userType === 'PAT') {

        }
    } else if (type === 'username') {

    }
}

/**
 * Uses Selector
 * 
 * @function
 * @param {String} selector | 
 * @returns 
 */
var $sel = function (selector) {
    return document.querySelector(selector);
};

/**
 * Validating user forms. Submits form if Entries are valid
 * @syntax validateLogin(form_id: String, userType: String)
 * @function 
 * @type void
 * @param {String} form_id Element id of form
 * @param {String} userType Type of user
 * 
 */
function validateLogin(form_id, userType) {
    // alert("Work In Progress");
    let regexUid = "(){}", regexPasswd = "";
    var userid, passwd;
    var msg = "";
    var result = new Array();
    var i = 0;
    if (userType === "MT") {
        userid = document.getElementById("userid").value.trim();
        passwd = document.getElementById("passwd").value.trim();
        //result = passwd.match("(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).{8,}");
        //checks whitespace characters

        result = document.getElementById("passwd").value.match(/([a-z])+([A-Z]?)\d+/g);
        if (document.getElementById("user_id").value.length < 8) {
            // alert();
            msg += "Password is invalid.\n";

        } else {
            // for (i = 0; i < result.length; i++) {
            //     if (result[i] === '0' || result[i] === 0)
            //         alert("password is invalid.");
            //     return;
            // }
        }
        if (document.getElementById("passwd").value.length < 8) {
            msg += "Password"
        }
    }
    if (msg !== "") {
        alert(msg);
        return;
        //        document.getElementById(form_id).
    } else {
        document.getElementById(form_id).submit();
    }
    // window.XMLHttpRequest
}
/**
 * 
 * @param {String} form_id 
 * 
 */
function validateSearch(form_id) {
    var ssn, dob, vacdate, fname, lname, minit,
            v1id, v2id, v3id, v4id;
    ssn = document.getElementById("").value;
    dob = document.getElementById("").value;
    vacdate = document.getElementById("").value;
    fname = document.getElementById("").value;
    lname = document.getElementById("").value;
    minit = document.getElementById("").value;
    v1id = document.getElementById("").value;
    v2id = document.getElementById("").value;
    v3id = document.getElementById("").value;
    v4id = document.getElementById("").value;

}
/**
 * 
 * @param {String} form_id | user Type
 * @param
 * @description checks entries for validation. returns message if entries are invalid 
 */
//const validateUserReg = function (form_id, userType) {
//    //patterns
//    const regexUid = "()[A-Za-z]", regex_passwd = "(?=.*\d )(){6,}";
//    //(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).{8,}
//    const regex_email = ""; var valid = false;
//    var msg = ""; var info = {};
//    var userid, passwd, confpasswd, email, terms, loc; //
//    if (userType === "MT" || userType === "ADM") {
//        // check if entries match patterns
//
//        userid = document.getElementById("uid").value;
//        passwd = document.getElementById("upwd").value.trim();
//        confpasswd = document.getElementById("confpasswd").value.trim();
//        loc = document.getElementById("loc").value.trim();
//        email = document.getElementById("email").value.trim();
//        terms = document.getElementById("terms");
//        // if (document.getElementById("userid"))
//        if (userid.length < 10) {
//            // alert("use");
//            
//        }
//        result = passwd.match(/\d+[A-Z]?/g);
//        if (passwd.length < 15){
//            msg = "Password Must be at least 15 character";
//            
//        }
////        var spaces = passwd.match(/\s/g);
//
////        console.log(result + "\n" + spaces);
//        if (!passwd.match(confpasswd)) {
//            msg += "\n Confirming Password Must Match.";
//            document.getElementById("confpasswd").oninvalid = msg;
//            document.getElementById("confpasswd").setCustomValidity('Password does not match');
//        }
//        // console.log("userid"+);
//    } else if (userType === "CDC" || userType === "PAT") {
//        userid = document.getElementById("uid").value;
//        passwd = document.getElementById("upwd").value;
//        confpasswd = document.getElementById("confpasswd").value;
//
//        email = document.getElementById("email").value;
//        terms = document.getElementById("terms");
//        if (userid < 10) {
//
//        } if (passwd.length < 10) {
//            msg += "password must be at least 8 characters long.";
//        }
//    }
//
//};
/**
 * 
 * @param {String} passwd_id password
 * @param {String} confpwd_id confim password
 */
function validatePasswd(passwd_id, confpwd_id) {
    // document.getElementById(confpwd_id).value;
    if (!document.getElementById(confpwd_id).value.matches(document.getElementById(passwd_id).value)) {
        if (document.getElementById("validc").classList.contains('fa-check')) {
            document.getElementById("validc").classList.replace('fa-check', 'fa-xmark');
            document.getElementById("validc").setAttribute("style", "color: red;");
        }
    } else if ((confpwd_id).value.matches(document.getElementById(passwd_id)).value) {
        if (document.getElementById("validc").classList.contains('fa-xmark')) {
            document.getElementById("validc").classList.replace('fa-xmark', 'fa-check');
            document.getElementById("validc").setAttribute("style", "color: green;");
        } else if (!document.getElementById("validc").classList.contains('fa-xmark')) {

        }

    }
}
/**
 * uses patterns to validate the inpt format.
 * if format is not valid then user cannot 
 * proceed with registration. sets icon element
 * to corresponding 
 * 
 * @param {String} input_id input element
 * @param {String} i_id Icon element
 */
function validatePattern(input_id, i_id) {
    var valid = false;
    var s = "";
    var pattern, msg;
    if (document.getElementById(input_id).getAttribute("type") === "email") {
        var email = document.getElementById(input_id).value;
        // pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        pattern = /^\w+([\.-]?\w+)*@\w+([\.-]) /;
        console.log(pattern.toString());

        const p = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;///[a-zA-Z0-9]+@[a-zA-Z0-9].{3,}$ /g ;
        const pa = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        valid = pa.test(email);//returns true if matched false otherwise

        console.log(valid);
        if (valid === false) {
            msg = "Invalid Email";
        } else {
            msg = "Valid Email";
        }
    }
    // end of validating email 
    else if (document.getElementById(input_id).getAttribute("type") === "text") {
        if (document.getElementById(input_id).id === "uid" || document.getElementById(input_id).id === "userid") {
            let val = document.getElementById(input_id).value;
            if (val.length < 10) {
                valid = false;
                msg = "";
            }
        }
    } else if (document.getElementById(input_id).getAttribute("type") === "password") {
        if (document.getElementById(input_id).value.length < 15) {
            valid = false;
            msg += "password must be at least 15 characters";
        }
    }

// validating password

    else if (document.getElementById(input_id).getAttribute("id") === "upwd") {
        pattern = /.{10,}/g;
        if (document.getElementById(input_id).value.length < 15) {
            valid = false;
            msg = "Password must be at least 15 characters in length.";
        }
//        valid = pattern.test(document.getElementById(input_id).value);

    } else if (document.getElementById(input_id).getAttribute("id") === "confpasswd") {
        if (document.getElementById("confpasswd").value === document.getElementById("upwd").value) {
            valid = true;

        } else {
            valid = false;
            msg = "Passwords Do not Match";
        }
    }
    // set valid appearance
    if (valid === false) {
        // red xmark if pattern is 
        document.getElementById(input_id).setAttribute("oninvalid", "");
        if (!document.getElementById(i_id).classList.contains("fa-check") && !document.getElementById(i_id).classList.contains("fa-xmark")) {
            document.getElementById(i_id).classList.toggle("fa-xmark");
            document.getElementById(i_id).setAttribute("style", "color: red;");
            // if classlist had checkmark but no xmark then replace checkmark
        } else if (document.getElementById(i_id).classList.contains("fa-check") && !document.getElementById(i_id).classList.contains("fa-xmark")) {
            document.getElementById(i_id).classList.replace("fa-check", "fa-xmark");
            document.getElementById(i_id).setAttribute("style", "color: red;");
        }
    } else if (valid === true) {
        //green checkmark
        if (!document.getElementById(i_id).classList.contains("fa-check") && !document.getElementById(i_id).classList.contains("fa-xmark")) {
            document.getElementById(i_id).classList.toggle("fa-check");
            document.getElementById(i_id).setAttribute("style", "color: green;");
            // if claslist has xmark but no checkmark then replace xmark
        } else if (!document.getElementById(i_id).classList.contains("fa-check") && document.getElementById(i_id).classList.contains("fa-xmark")) {
            document.getElementById(i_id).classList.replace("fa-xmark", "fa-check");
            document.getElementById(i_id).setAttribute("style", "color: green;");
        }

    }

}
/**
 * 
 * @param {String} form_id - Element id of Form Element
 * @type void
 * 
 */
const submitForm = function (form_id) {

    // document.querySelector(form_id).submit();
};
