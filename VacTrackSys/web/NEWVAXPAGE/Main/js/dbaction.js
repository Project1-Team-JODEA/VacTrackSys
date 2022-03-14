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
//  const pageAction = function (action, form_id) {
//     document.RecordsSelection.actiontype.value = action;
//     $("actiontype").value = action;
//     if (ajax && action === 'searchPatient') {
//         ajax.open('get', 'RecordsSelection?actiontype=searchPatient');
//         ajax.send(null);
//     } else if (ajax && action === 'EditVaccine') {
//         ajax.open('get', 'RecordsSelection?actiontype=editVacccine');
//         ajax.send(null);
//     } else if (ajax && action === 'EditPatient'){
//         ajax.open('get', 'RecordsSelection?actiontype=EditPatient');
//         ajax.send(null);
//     }
//     else {
//         document.RecordsSelection.submit();
//     }
// };
/**
 * 
 * @type class
 * @function pageAction
 * @function {void} init 
 * @function handleResponse
 * 
 */
const dbactions = {
    /**
     * 
     * @param {type} action
     * @param {type} form_id
     * @type void
     * 
     */
    pageAction: function (action, form_id) {
      var h_request='';
        $("actiontype").value = action;
        document.form_id.actiontype.value = action;
      if (ajax && action =='EditPatient'){
        h_request = form_id + '?actiontype='+action;
        ajax.open('get',h_request );
        ajax.send(null);
      }else{
        $(form_id).submit();
      }
    },
    /**
     * @type void
     * @returns {undefined}
     */
    init: function() {

        // Get an XMLHttpRequest object:
        ajax = getXMLHttpRequestObject();

        if (ajax) {
            // Function that handles the response:
            ajax.onreadystatechange = function () {
                handleResponse();
            };
        }
    }, // End of init() function.
    /**
     * @type void
     * @returns {undefined}
     */
    handleResponse: function () {

        // Check that the transaction is complete:
        if (ajax.readyState === 4) {

            // Check for a valid HTTP status code:
            if ((ajax.status === 200) || (ajax.status === 304)) {

                // Put the received response in the DOM:
                var results = document.getElementById('results');
                results.innerHTML = ajax.responseText;
            } else { // Bad status code, submit the form normally
                document.getElementById('Records').submit();
            }
        } // End of readyState IF.
    }

};

