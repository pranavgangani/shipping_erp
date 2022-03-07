var CrewDocument = {}

$(document).ready(function() {
    $('.form-select').select2();
});

CrewDocument.openFileUploadModal = function(docId, docName, docTypeId) {
    var modal = "#fileUploaderModal";
    $("#docId").val(docId);
    $(modal).modal('show');
    $("#fileUploaderModalTitle").text(docName);
}