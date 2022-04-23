/* 
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */

$(document).ready(() => {
    var today = getTodayDate();
    $("#vac_date").attr("max", today);
    $("#dob").attr("max", today);
    $("#msg-btn").attr("onclick", "toggleList('msg-content')");
    $("#help-btn").attr("onclick", "toggleList('help-content')");
    $(".actions button").click(evt => {
        let e = evt.currentTarget;
        if (e.value === "AddPatient"){
            
        }else if (e.value === "SearchPatient"){
            if ($(".sch").css("display") === "none"){
                $(".sch").css("display","block");
            } else if ($(".sch").css("display") === "block")  {
                $(".sch").css("display","none");
            }          
        }else if (e.value === "Edit Vaccine"){
           if ($(".sch").css("display") === "block"){
                $(".sch").css("display","none");
            }  
        }else if (e.value === "Add Vaccine"){
//            window.location = "./VacView.jsp";
            
        }
    });
    $(".sortval").click(evt => {
        let e = evt.currentTarget;
//            let val = ;
        let check = e.getAttribute("checked");
        let eid = "#" + evt.currentTarget.value;
//        let cid = 'tr.'+e.value;
         
        let y = eid+" .pat_info"; let x = '.sortval[value="'+e.value+'"]';
//        console.log("y: "+);
        let id =  eid.substring(0, eid.length-1);
        let e2 = document.getElementById(id);
        if (e.hasAttribute("checked")){
            
            if ($(eid).css("display") === "none"){
                $(eid).css("display", "block");
            }else{
//                 let x = '.sortval input [value="'+e.value+'"]';
                $(x).removeAttr("checked");
//                if ()
                
                $(eid).css("display", "none");
                if (!$(id).hasAttribute("required")){
                   $(id).attr("required", null);
                }
            }
        }else if (!e.hasAttribute("checked")){
            
            if ($(eid).css("display") === "block"){
                $(eid).css("display", "none");
            }else{
               if ($(id).hasAttribute("required")){
                   $(id).removeAttr("required"); 
                }
                $(x).attr("checked", "null");
                $(eid).css("display", "block");
               
                $(id).attr("required", null);
            }
        }
    });
    $(".pat_info").each((index, e)=>{
        let eid = e.id;
        let id = '#'+eid;
        console.log(eid);
        
        switch(eid){
            case "ssn": $(id).attr("oninvalid", ()=>{
                    document.getElementById(eid).setCustomValidity('Social Security Number must be 8 numeric characters.');});
                break;
            case 'fname':$(id).attr("oninvalid", ()=>{
                   document.getElementById(eid).setCustomValidity('');});
                break;
            case 'midinit':$(id).attr("oninvalid", ()=>{
                   document.getElementById(eid).setCustomValidity('');});
                break;
//            case ''
        }
    });
    
    $(".sort li span.details").click(evt => {
        let e = evt.currentTarget;
        let input = $(".sort li span.details").siblings("input");
        console.log (input);
    });

});

