var CrewDocument = {}

$(document).ready(function() {
    $('.form-select').select2();
});

CrewDocument.openFileUploadModal = function(docId, docName, docTypeId) {
   /* $("#docId").val(this.docId);
    console.log("docId = "+$("#docId").val());*/
    $("#fileUploaderModalTitle").text(docName);
    var modal = "#fileUploaderModal";
    $(modal).modal('show');
}
