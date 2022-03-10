/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Project Name
 * File name: functions.js
 * Author(s): eVmPr
 * Supporting Files:
 * Note(s): for checking validation
 *
 */

var $ = function (id) {
    return document.getElementById(id);
};

function sendMessage(msg) {
    alert(msg);
}
;
function check() {
    document.querySelector();

}
function pageAction(action) {
    var actiontype = document.getElementById("actiontype");
    actiontype.value = action;

}
function checkDBForm() {

}
function setTodayMaxDate(id) {
    var today = new Date();
    var d = today.getDate();
    var m = today.getMonth();
    var y = today.getYear();
    if (d < 10) {
        d = 0 + d;
    }
    if (m < 10) {
        m = 0 + m;
    }
    var input = document.getElementById(id);
   today = y + "-" + m + "-" + d;
    input.setAttribute('max', today );
    if (input.type === "date") {

    }
}
