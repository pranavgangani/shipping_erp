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
            var jsonData = JSON.parse(data);

            $("#vacancyIdSpan").text(vacancyId);
            $("#statusText").text(jsonData.vacancy.status);
            $("#openPositionText").text(jsonData.vacancy.openPositions);
            var contentData = "";
            console.log(jsonData.crew);
             $.each(jsonData.crew,function(i,crew){
                contentData += "<tr><td><input type='checkbox' id='"+crew.id+"'></td><td>" + crew.fullName + "</td><td>" + crew.status + "</td></tr>";
            });
            $("#table-select-crew tbody").html(contentData);

        },
        error: function (jqXHR, textStatus, errorThrown)
        {

        }
    });
};