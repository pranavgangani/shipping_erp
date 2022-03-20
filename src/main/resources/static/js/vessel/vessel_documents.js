var VesselDocument = {}

$(document).ready(function() {
    $('.form-select').select2();


    $("#pop").on("click", function() {
    console.log("-----------------");
       $('#imagepreview').attr('src', $('#imageresource').attr('src')); // here asign the image to the modal when the user click the enlarge link
       $('#imagemodal').modal('show'); // imagemodal is the id attribute assigned to the bootstrap modal, then i use the show function
    });
});

VesselDocument.openFileUploadModal = function(docId, docName, docTypeId) {
    var modal = "#fileUploaderModal";
    $("#docId").val(docId);
    $(modal).modal('show');
    $("#fileUploaderModalTitle").text(docName);
}
