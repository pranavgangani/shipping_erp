var Crew_Details = {};

jQuery(document).ready(function () {
   // jQuery('.form-select').select2();
    jQuery("#birthDate").datepicker();

    // Setup dirty flag checks
    Bootstrap_Validation.initializeOriginalValues('dirtycheck');
    Bootstrap_Validation.setupDirtyFlagEventHandlers('dirtycheck');
    Bootstrap_Validation.confirmBeforePageChange();

    const fileInput = document.querySelector("#file-input");

    fileInput.addEventListener("change", event => {
        const files = event.target.files;
        Crew_Details.uploadPhoto(files[0]);
    });

});

Crew_Details.uploadPhoto = function (file) {

    var data = new FormData();
    data.set("image", file);
    data.append("crewId", jQuery('#crewId').val());

    var ajaxCall = jQuery.ajax({
        url: jQuery('#contextPath').val() + "/crew/photos/upload.ajax",
        method: 'POST',
        data: data,
        type: "POST",
        cache: false, // Stop IE from caching ajax results!
        processData: false,
        contentType: false,
        success: function (data) {
            return data;
        },
        error: function (data) {
            if (typeof data.responseText != 'undefined') {
                // Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Add Subscription Error. " + data.responseText);
            } else {
                // Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Add Subscription Error. " + data);
            }

            return null;
        }
    });
};

Crew_Details.update = function () {
    /*var formValidation = jQuery('#crew-form').data('formValidation');
    var form = jQuery('#crew-form');
    formValidation.validateContainer(form);*/
    var isModified = Bootstrap_Validation.isDirty();
    if (!isModified) {
        //Bootstrap_Util.openToastAlert("warning", "<i class='fa fa-info'></i>Warning", "No modified values to save.", 2000);
       alert("No modified values to save.", 2000);
    } else {
        var isValid = Bootstrap_Validation.isValid();
        if (isValid) {
            Bootstrap_Util.showPleaseWait();
            var modifiedFields = {};

            // Populate modifiedFields
            Crew_Details.getModifiedFields(modifiedFields);

            var json = JSON.stringify(modifiedFields);
            var data = new FormData();
            data.append("modifiedFields", json);
            data.append("crewId", jQuery('#crewId').val());

            var ajaxCall = jQuery.ajax({
                url: jQuery('#contextPath').val() + "/crew/update.ajax",
                method: 'POST',
                data: data,
                type: "POST",
                cache: false, // Stop IE from caching ajax results!
                processData: false,
                contentType: false,
                success: function (data) {
                    return data;
                },
                error: function (data) {
                    if (typeof data.responseText != 'undefined') {
                        // Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Add Subscription Error. " + data.responseText);
                    } else {
                        // Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Add Subscription Error. " + data);
                    }

                    return null;
                }
            });

            //Reinitialize all fields
            Bootstrap_Validation.initializeOriginalValues('dirtycheck');
            Bootstrap_Validation.setupDirtyFlagEventHandlers('dirtycheck');
            Bootstrap_Util.hidePleaseWait();
        }
    }
}

Crew_Details.add = function () {
    /*var formValidation = jQuery('#crew-form').data('formValidation');
    var form = jQuery('#crew-form');
    formValidation.validateContainer(form);*/

    var isModified = Bootstrap_Validation.isDirty();
    if (!isModified) {
        //Bootstrap_Util.openToastAlert("warning", "<i class='fa fa-info'></i>Warning", "No modified values to save.", 2000);
        alert("No modified values to save.", 2000);
    } else {
        var isValid = Bootstrap_Validation.isValid();
        if (isValid) {
            jQuery("#crew-details-form").submit();
        }
    }

}

Crew_Details.getModifiedFields = function (modifiedFields) {
    // Get dirty fields
    var dirtyFields = jQuery('.isDirty');

    // Iterate over modified fields
    jQuery.each(dirtyFields, function () {
        var jQueryObject = jQuery(this);
        var name;
        var value;
        var originalValue;

        /*var fieldStatuses;
        var fieldStatusName;
        var fieldStatusObject;*/

        /*if (jQueryObject.hasClass('fieldChecker') || jQueryObject.hasClass('fieldApprover')) {
            // for fieldStatus elements, use data attributes to create appropriate object
            name = jQueryObject.data("id"); // Get id from data attribute instead (because there will be multiple objects with the same id)
            fieldStatusName = jQueryObject.data('field');
            if (jQueryObject.is(':checked')) {
                value = jQuery('#employeeId').val();
            } else {
                value = '';
            }
            originalValue = jQueryObject.prop('defaultValue');

            // Check if fieldStatuses exists
            fieldStatuses = modifiedFields['fieldStatuses'];

            if (typeof fieldStatuses == 'undefined') {
                // Create new fieldStatuses
                fieldStatuses = {};

                // Add to arrays
                modifiedFields['fieldStatuses'] = fieldStatuses;
            }

            // Check if fieldStatusName exists in fieldStatuses
            fieldStatusObject = fieldStatuses[fieldStatusName];

            if (typeof fieldStatusObject == 'undefined') {
                // Create new object
                fieldStatusObject = {};

                // Set Values
                fieldStatusObject[name] = value;

                // Add to arrays
                fieldStatuses[fieldStatusName] = fieldStatusObject;
            } else {
                // Set Values
                fieldStatusObject[name] = value;
            }
        } else {*/
            // Get id and value
            name = jQueryObject.attr("id");
            value = jQueryObject.val();
            originalValue = jQueryObject.data('originalValue');

            // Add to arrays
            modifiedFields[name] = value;

            // Check if fieldStatuses exists
           /* fieldStatuses = modifiedFields['fieldStatuses'];

            if (typeof fieldStatuses == 'undefined') {
                // Create new fieldStatuses
                fieldStatuses = {};

                // Add to arrays
                modifiedFields['fieldStatuses'] = fieldStatuses;
            }*/

            // Check if fieldStatusName exists in fieldStatuses
            /*fieldStatusObject = fieldStatuses[name];

            if (typeof fieldStatusObject == 'undefined') {
                // Create new object
                fieldStatusObject = {};
                var autoUser = jQuery('#' + name + 'AutoMaker').val();
                // Set Values
                fieldStatusObject['maker'] = typeof autoUser !== 'undefined' ? autoUser : jQuery('#employeeId').val();

                // Add to arrays
                fieldStatuses[name] = fieldStatusObject;
            } else {
                // Set Values
                fieldStatusObject['maker'] = jQuery('#employeeId').val();
            }*/
       // }
    });

};

