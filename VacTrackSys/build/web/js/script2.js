/* 
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */



function validate(id, type) {
    var valid = false, val=null, regex;
    if (type === 'ssn') {

    }
    
    switch (type) {
        case 'ssn':
            val = $(id).val();
            regex = /^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$/;
            if (val.type() === 'undefined'){
                alert("Error: ")
            }
            ;
            break;
        case '':
            ;
            break;
        case '':
            ;
            break;
        case '':
            ;
            break;
    }
}