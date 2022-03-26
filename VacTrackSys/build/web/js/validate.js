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
var $sel= function(selector){
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
function validateLogin(form_id , userType) {
    // alert("Work In Progress");
    let regexUid = "(){}", regexPasswd = "";
    var userid, passwd;var msg="";
    var result = new Array(); var i = 0;
    if (userType === "MT") {
        userid = $("userid").value.trim();
        passwd = $("passwd").value.trim();
        //result = passwd.match("(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).{8,}");
        //checks whitespace characters
        
         result = $("passwd").value.match(/([a-z])+([A-Z]?)\d+/g);
        if ($("user_id").value.length < 8){
            // alert();
            msg+="Password is invalid.\n";
            
        } else {
            // for (i = 0; i < result.length; i++) {
            //     if (result[i] === '0' || result[i] === 0)
            //         alert("password is invalid.");
            //     return;
            // }
        }
       if ($("passwd").value.length < 8){
           msg+="Password"
       }
    }
    if (msg !== ""){
        alert(msg);
        return;
//        document.getElementById(form_id).
    } else{
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
    ssn = $("").value; dob = $("").value;vacdate = $("").value;
    fname = $("").value;lname = $("").value; minit = $("").value;
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
        if (userid.length <10){
            // alert("use");

        }
        result = passwd.match(/\d+[A-Z]?/g);

        var spaces = passwd.match(/\s/g);
        
        console.log(result+"\n"+spaces);
        if(passwd !== confpasswd ) {
            msg+= "";
        }
        // console.log("userid"+);
    } else if (userType === "CDC" || userType === "PAT") {
        userid = $("uid").value;
        passwd = $("upwd").value;
        confpasswd = $("confpasswd").value;

        email = $("email").value;
        terms = $("terms");
        if (userid < 10){

        }if (passwd.length < 8){
            msg += "password must be at least 8 characters long. \n";
        }
    }

};
/**
 * 
 * @param {String} passwd_id password
 * @param {String} confpwd_id confim password
 */
function validatePasswd(passwd_id, confpwd_id){
// $(confpwd_id).value;
if(!$(confpwd_id).matches($(passwd_id).value)){
    if ($("validc").classList.contains('fa-check')){
        $("validc").classList.replace('fa-check', 'fa-xmark');
    
    } 
} else if ((confpwd_id).matches($(passwd_id),value)){
    if ($("validc").classList.contains('fa-xmark')){
         $("validc").classList.replace('fa-xmark', 'fa-check');
    } else if (!$("validc").classList.contains('fa-xmark')){

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
