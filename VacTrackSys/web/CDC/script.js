/* 
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */

function pageAction(action) {
    
}
$(document).ready(() => {
    $("#msg-btn").attr("onclick", "toggleList('msg-content')");
    $("#help-btn").attr("onclick", "toggleList('help-content')");
    //$("#dbaction").attr("onsubmit", "toggleList('loading-content')");
    $("#logout").click(evt => {
        let c = confirm("Are you sure you want to logout?");
        if (c === true) {
            document.dbaction.actiontype.value = "Logout";
            document.dbaction.submit();
            
        }
        evt.preventDefault();
    });
    $("#report").click(evt =>{
        $("#dbaction").attr("onsubmit", "toggleList('loading-content')");
   
        document.dbaction.actiontype.value = "CreateReport";
            document.dbaction.submit();
        evt.preventDefault();
    });
});
