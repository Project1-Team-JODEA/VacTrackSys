/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var $ = function(id){
   return document.getElementById(id);
   };
   $("newacct").onclick = ValidateLogin;
   $("logon").onclick = ValidateLogin ;
function ValidateLogin(){
    alert("Validation: To Be Implemented");
    return;
}

function isValidPassword(passwd){
    /* password must  */
    alert("To be Implemented");
    return;
}
function isValidUsername(usr){
    /* Username Must have */
    alert("Username Validation: To Be Implemented.");
    return;
}
