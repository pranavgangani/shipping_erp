var CrewDocument = {}

jQuery(document).ready(function() {
   // jQuery('.form-select').select2();

    jQuery("#pop").on("click", function() {
    console.log("-----------------");
       jQuery('#imagepreview').attr('src', jQuery('#imageresource').attr('src')); // here assign the image to the modal when the user click the enlarge link
       jQuery('#imagemodal').modal('show'); // imagemodal is the id attribute assigned to the bootstrap modal, then i use the show function
    });
});

CrewDocument.openFileUploadModal = function(docId, docName, docTypeId) {
    var modal = "#fileUploaderModal";
    jQuery("#docId").val(docId);
    jQuery(modal).modal('show');
    jQuery("#fileUploaderModalTitle").text(docName);
}


CrewDocument.approveOfferModal = function(vacancyId) {
    var modal = "#approveOfferLetterModal";
    VacancyDetails.getValidCrewToAssignVacancy(vacancyId);
    $(modal).modal('show');

};