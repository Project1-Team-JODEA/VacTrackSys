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
 * @function $(id)
 * @param {String} id
 * @returns {Element} Element
 */
var $ = function (id) {
    return document.getElementById(id);
};

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
    var userid, passwd; var msg = "";
    var result = new Array(); var i = 0;
    if (userType === "MT") {
        userid = $("userid").value.trim();
        passwd = $("passwd").value.trim();
        //result = passwd.match("(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).{8,}");
        //checks whitespace characters

        result = $("passwd").value.match(/([a-z])+([A-Z]?)\d+/g);
        if ($("user_id").value.length < 8) {
            // alert();
            msg += "Password is invalid.\n";

        } else {
            // for (i = 0; i < result.length; i++) {
            //     if (result[i] === '0' || result[i] === 0)
            //         alert("password is invalid.");
            //     return;
            // }
        }
        if ($("passwd").value.length < 8) {
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
    ssn = $("").value; dob = $("").value; vacdate = $("").value;
    fname = $("").value; lname = $("").value; minit = $("").value;
    v1id = $("").value; v2id = $("").value; v3id = $("").value;
    v4id = $("").value;

}
/**
 * 
 * @param {String} form_id | user Type
 * @param
 * @description checks entries for validation. returns message if entries are invalid 
 */
const validateUserReg = function (form_id, userType) {
    //patterns
    const regexUid = "()[A-Za-z]", regex_passwd = "(?=.*\d )(){6,}";
    //(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).{8,}
    const regex_email = "()"; var valid = false;
    var msg = ""; var info = {};
    var userid, passwd, confpasswd, email, terms, loc; //
    if (userType === "MT" || userType === "ADM") {
        // check if entries match patterns

        userid = $("uid").value;
        passwd = $("upwd").value.trim();
        confpasswd = $("confpasswd").value.trim();
        loc = $("loc").value.trim();
        email = $("email").value.trim();
        terms = $("terms");
        // if ($("userid"))
        if (userid.length < 10) {
            // alert("use");
            
        }
        result = passwd.match(/\d+[A-Z]?/g);
        if (passwd.length < 15){
            msg = "Password Must be at least 15 character";
            
        }
//        var spaces = passwd.match(/\s/g);

//        console.log(result + "\n" + spaces);
        if (!passwd.match(confpasswd)) {
            msg += "\n Confirming Password Must Match.";
            $("confpasswd").oninvalid = msg;
            $("confpasswd").setCustomValidity('Password does not match');
        }
        // console.log("userid"+);
    } else if (userType === "CDC" || userType === "PAT") {
        userid = $("uid").value;
        passwd = $("upwd").value;
        confpasswd = $("confpasswd").value;

        email = $("email").value;
        terms = $("terms");
        if (userid < 10) {

        } if (passwd.length < 10) {
            msg += "password must be at least 8 characters long.";
        }
    }

};
/**
 * 
 * @param {String} passwd_id password
 * @param {String} confpwd_id confim password
 */
function validatePasswd(passwd_id, confpwd_id) {
    // $(confpwd_id).value;
    if (!$(confpwd_id).value.matches($(passwd_id).value)) {
        if ($("validc").classList.contains('fa-check')) {
            $("validc").classList.replace('fa-check', 'fa-xmark');
            $("validc").setAttribute("style", "color: red;");
        }
    } else if ((confpwd_id).value.matches($(passwd_id)).value) {
        if ($("validc").classList.contains('fa-xmark')) {
            $("validc").classList.replace('fa-xmark', 'fa-check');
            $("validc").setAttribute("style", "color: green;");
        } else if (!$("validc").classList.contains('fa-xmark')) {

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
    var valid = false; var s = ""; var pattern, msg;
    if ($(input_id).getAttribute("type") === "email") {
        var email = $(input_id).value;
        // pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
pattern =  /^\w+([\.-]?\w+)*@\w+([\.-]) /;
        console.log(pattern.toString());
        
        const p = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;///[a-zA-Z0-9]+@[a-zA-Z0-9].{3,}$ /g ;
       const pa = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        valid = pa.test(email);//returns true if matched false otherwise

        console.log(valid);
        if (valid === false){
            msg="Invalid Email";
        }else{
            msg="Valid Email";
        }
    } 
    // end of validating email 
    else if ($(input_id).getAttribute("type") ==="text"){
        if ($(input_id).id==="uid" || $(input_id).id==="userid"){
            let val = $(input_id).value;
            if (val.length < 10){
                valid = false;
                msg="";
            }
        }
    } else if ($(input_id).getAttribute("type")=== "password"){
        if ($(input_id).value.length <15){
            valid = false;
        }
    }
    
// validating password
    
   else if ($(input_id).getAttribute("id") === "upwd") {
        pattern = /.{10,}/g;
        if ($(input_id).value.length < 15){
            valid = false;
            msg = "Password must be at least 15 characters in length.";
        }
//        valid = pattern.test($(input_id).value);
        
    }else if ($(input_id).getAttribute("id")==="confpasswd"){
        if ($("confpasswd").value===$("upwd").value){
            valid = true;
            
        }else {
            valid = false;
            msg = "Passwords Do not Match";
        }
    }
    // set valid appearance
    if (valid === false) {
        // red xmark if pattern is 
        $(input_id).setAttribute("title", msg);
        if (!$(i_id).classList.contains("fa-check") && !$(i_id).classList.contains("fa-xmark")) {
            $(i_id).classList.toggle("fa-xmark");
            $(i_id).setAttribute("style", "color: red;");
            // if classlist had checkmark but no xmark then replace checkmark
        } else if ($(i_id).classList.contains("fa-check") && !$(i_id).classList.contains("fa-xmark")) {
            $(i_id).classList.replace("fa-check", "fa-xmark");
            $(i_id).setAttribute("style", "color: red;");
        }
    } else if (valid === true) {
        //green checkmark
        if (!$(i_id).classList.contains("fa-check") && !$(i_id).classList.contains("fa-xmark")) {
            $(i_id).classList.toggle("fa-check");
            $(i_id).setAttribute("style", "color: green;");
            // if claslist has xmark but no checkmark then replace xmark
        } else if (!$(i_id).classList.contains("fa-check") && $(i_id).classList.contains("fa-xmark")) {
            $(i_id).classList.replace("fa-xmark", "fa-check");
            $(i_id).setAttribute("style", "color: green;");
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
