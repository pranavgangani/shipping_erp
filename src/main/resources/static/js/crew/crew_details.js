$(document).ready(function() {
    $('.form-select').select2();
    $("#birthDate").datepicker();

    var dirty = false;
    $("#contact-form").dirty({
        preventLeaving:true,
        leavingMessage:"There are unsaved changes on this page which will be discarded if you continue.",
        onClean:function(){
            alert("Clean");
        }
    });

    var listDirtyFields = $("#contact-form").dirty("showDirtyFields");
    console.log("listDirtyFields = "+listDirtyFields);

/*
     $('#contact-form').validate({
            rules: {
                name: {
                    minlength: 2,
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                message: {
                    minlength: 2,
                    required: true
                }
            },
            highlight: function (element) {
                $(element).closest('.control-group').removeClass('success').addClass('error');
            },
            success: function (element) {
                element.text('OK!').addClass('valid')
                    .closest('.control-group').removeClass('error').addClass('success');
            }
        });*/
});