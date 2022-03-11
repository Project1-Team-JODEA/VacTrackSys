/* 
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 
 */

/**
 * @author Elena_Miller 
 * @d
 */

/**
 * 
 * @param {type} id
 * @returns {Element}
 */
var $ = function (id) {
    return document.getElementById(id);
};

/**
 * @function 
 * @type void
 * @returns {undefined}
 */
const validateLogin = function(form_id){
    alert("Work In Progress");
    let regexUid = "", regexPasswd = "";
    var userid = $("userid").value.trim();
    var passwd = $("passwd ").value.trim();
    if (userid===""){
        alert("Please Enter a Valid Username");
    }
};
/**
 * 
 * @param {*} form_id | user Type
 * 
 * @description checks entries for validation. returns message if entries are invalid 
 */
const validateUserReg = function(form_id, userType){
    //patterns
    const regexUid = "()[A-Za-z]", regex_passwd="()" ;
    const regex_email = "()"; var valid = false;
    var userid,passwd,confpasswd,email,terms //
    if ( userType === "MT" || userType==="ADM"){
        // check if entries match patterns
        
        userid = $("uid").value;
        passwd  = $("upwd").value;
       confpasswd = $("confpasswd").value;
       email=$("email").value;
       terms = $("terms");
    }else if (userType === "CDC" ||userType==="PAT"){

    }

};

const submitForm = function(form_id){
    document.querySelector(form_id).submit();
};