var VesselDetails = {}

$(document).ready(function() {
    $('.form-select').select2();
     //$("#birthDate").datepicker();
/*

    $("#selectCrewModalBtn").click(function(){
        VesselDetails.openSelectCrewModal();
    });
*/


});

VesselDetails.openSelectCrewModal = function(vacancyId) {
    var modal = "#selectCrewModal";
    VesselDetails.getValidCrewToAssignVacancy(vacancyId);
    $(modal).modal('show');

};

VesselDetails.getValidCrewToAssignVacancy = function(vacancyId) {
     var payload = {
          vacancyId : vacancyId
       }

    $.ajax({
        url : "/vessel/assign_vacancy",
        type: "POST",
        data: {
            "vacancyId" : vacancyId
        },
        success: function(data, textStatus, jqXHR)
        {
            //data - response from server
        },
        error: function (jqXHR, textStatus, errorThrown)
        {

        }
    });
};