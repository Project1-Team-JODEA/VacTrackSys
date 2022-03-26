/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Project Name
 * File name: dbaction.js
 * Author(s): Elena Miller
 * Supporting Files:
 * Note(s):
 *
 */

var ajax;

/**
 * 
 */

// const dbParam = JSON.stringify({});

/**
 * 
 * @param {type} action
 * @param {type} form_id
 * 
 */
function pageAction(action, form_id) {
    var h_request = '';
    $(form_id).actiontype.value = action;
//  $("actiontype").setAttribute("value", action);
    console.log($("actiontype").value);
    // document.form_id.actiontype.value = action;
    switch (ajax && action) {
        case "EditPatient":
            h_request = form_id + '?actiontype=' + action;
            ajax.open('get', h_request);
            ajax.send(null);
            break;
        case 'EditVaccine':
            h_request = form_id + '?actiontype=' + action;
            ajax.open('get', h_request);
            ajax.send(null);
            break;
        case 'AddPatient':
            h_request = form_id + '?actiontype=' + action;
            ajax.open('get', h_request);
            ajax.send(null);
            break;
        case 'AddVaccine':
            h_request = form_id + '?actiontype=' + action;
            ajax.open('get', h_request);
            ajax.send(null);
            break;
        case 'SearchPatient':
            h_request = form_id + '?actiontype=' + action;
            ajax.open('get', h_request);
            ajax.send(null);
            break;
        default:
            $(form_id).submit();
            break;
    }
    // if (ajax && action == 'EditPatient') {
    //   h_request = form_id + '?actiontype=' + action;
    //   ajax.open('get', h_request);
    //   ajax.send(null);
    // } else {
    //   $(form_id).submit();
    // }
}

function init() {

    // Get an XMLHttpRequest object:
    ajax = getXMLHttpRequestObject();

    if (ajax) {
        // Function that handles the response:
        ajax.onreadystatechange = function () {
            handleResponse();
        };
    }
} // End of init() function.
function handleResponse() {

    // Check that the transaction is complete:
    if (ajax.readyState === 4) {

        // Check for a valid HTTP status code:
        if ((ajax.status === 200) || (ajax.status === 304)) {

            // Put the received response in the DOM:
            var results = document.getElementById('results');
            results.innerHTML = ajax.responseText;
        } else { // Bad status code, submit the form normally
            document.getElementById('RecordsSelection').submit();
        }
    } // End of readyState IF.
}


