/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * JODEA 
 * File name: functions.js
 * Author(s): Elena Miller
 * Supporting Files:
 * Note(s): for checking validation
 *
 */


// const Login = {
//     function: 
// }
// const toggleValue(){

// }
/**
 * 
 * @param {String} id 
 * @returns 
 */
var $ = function (id) {
    return document.getElementById(id);
};
var $_ = selector => document.querySelector(selector);
function sendMessage(msg) {
    alert(msg);
}
;
function check() {
    document.querySelector();

}
// function pageAction(action) {
//     var actiontype = document.getElementById("actiontype");
//     actiontype.value = action;

// }

function getTodayDate() {
    var today = new Date();
    var d = today.getDate();
    var m = today.getMonth();
    var y = today.getFullYear();
    // console.log(y.toString());
    if (d < 10) {
        d = "0" + d;
    }
    if (m < 10) {
        m = "0" + m;
    }
   today = y + "-" + m + "-" + d;
    return today;
}
// toggle sort values for sorting 
/**
 * 
 * @param {type} inputid
 * @returns {undefined}
 */
var toggleSortVal = function (inputid) {
    var input = document.getElementById(inputid);
    //    var 
    var ftxt = document.getElementById("sort");
    $("txtsort").value ;
    var ref_val = $(inputid).value;
    if ($(inputid).getAttribute("checked")===null){
        //set atribute and value to textbox
        $(inputid).setAttribute("checked", null);
        // $(inputid).
        
    } else if ($(inputid).getAttribute("checked")!==null){
        $(inputid).removeAttribute("checked");

    }

    if ($("sort").value.contains(input.value)){

    }else if ($("sort").value.contains(input.value)){
        
    }else if ($("sort").value===""){

    }

    if (input.getAttribute("checked") === true) {
        //add value to input filter

        alert('Checked' + input.value);
    } else if (input.checked === false) {

    }
};
/**
 * 
 * @param {String} id 
 */
const toggleList = function (id) {
    const sortList = document.getElementById(id);//document.querySelector("#sortlist");
    const items_cont = $_("#items");
    // let styleSheet = document.styleSheets[];
    if (sortList.style.display === "none") {
        sortList.style.display = "block";
        } else if (sortList.style.display === "block") {
        sortList.style.display = "none";
        
        }
        // sortList.style.display
        

};
// toggles list
//function toggleList(list_class, btnid) {
//    var dropdown = document.getElementById(btnid);
//    var items = document.getElementsByClassName(list_class);
//    document.getElementsByName();
//    var i;
//    for (i = 0; i < items.length; i++) {
//        var openDropdown = items[i];
//        if (openDropdown.classList.contains('show')) {
//            openDropdown.classList.remove('show');
//        }
//    }
//}

/**
 * 
 * @param {type} id
 * @returns {undefined}
 */
function toggleV(id, btn_id){

    if ($(id).getAttribute("type") === "password"){
        $(id).type = "text";
        $(id).setAttribute("type", "text");
        if ($(btn_id).classList.contains("fa-eye")){
            $(btn_id).classList.replace("fa-eye", "fa-eye-slash");
        } 
    } else if ($(id).getAttribute("type") === "text"){
        $(id).setAttribute("type", "password");
        if ($(btn_id).classList.contains("fa-eye-slash")){
            $(btn_id).classList.replace( "fa-eye-slash", "fa-eye");
        }
    }
}
