// Create namespace for this file
var Bootstrap_Validation = {};

/**
 * Setup change events handlers to toggle .isDirty class when fields are changed.
 */
Bootstrap_Validation.setupDirtyFlagEventHandlers = function (dirtyClassName) {
    // On change event. When something is changed, add/remove .isDirty class.
    jQuery('.' + dirtyClassName).on('input propertychange change keyup paste', function() {
        var jQueryObject = jQuery(this);
        console.log("originalValue = "+jQueryObject.prop('defaultValue'));
        if ( jQueryObject.hasClass('select2-container') ) {
            return; // Ignore select2
        }

        if ( jQueryObject.is(':checkbox') || jQueryObject.is(':radio')) {
            if ( jQuery(this).prop('defaultValue') == jQueryObject.is(':checked') ) {
                jQueryObject.removeClass('isDirty');
            } else {
                jQueryObject.addClass('isDirty');
            }
        } else {
            if ( jQueryObject.prop('defaultValue') == jQueryObject.val() ) {
                jQueryObject.removeClass('isDirty');
            } else {
                jQueryObject.addClass('isDirty');
            }
        }
    });

    /*using bind for dirty check of paste value*/
    jQuery('.' + dirtyClassName).bind('paste', function (e) {
        jQuery(e.target).keyup(getInput);
    });
    function getInput(e) {
        jQuery(e.target).unbind('keyup');
        var jQueryObject = jQuery(this);
        if (jQueryObject.hasClass('select2-container')) {
            return; // Ignore select2
        }
        if (jQueryObject.prop('defaultValue') == jQueryObject.val()) {
            jQueryObject.removeClass('isDirty');
        } else {
            jQueryObject.addClass('isDirty');
        }
    }
};

/**
 * Checks for any fields with a dirtyClassName and sets an original value on them.
 * @param dirtyClassName
 */
Bootstrap_Validation.initializeOriginalValues = function (dirtyClassName) {
    // Remove any existing fields with the isDirty class name
    jQuery.each(jQuery('.' + dirtyClassName), function() {
        jQuery(this).removeClass('isDirty');
    });

    // Initialize properties for dirty flag checking
    jQuery.each(jQuery('.' + dirtyClassName), function() {
            var jQueryObject = jQuery(this);
            if ( jQueryObject.hasClass('select2-container') ) {
                return; // Ignore select2
            }

            if ( jQueryObject.is(':checkbox')  || jQueryObject.is(':radio')) {
                jQueryObject.prop('defaultValue', jQueryObject.is(':checked')); // Set true/false of checkbox status
            } else {
                //console.log("jQueryObject.id=" + jQueryObject.attr("id") + " | "+jQueryObject.val());
                jQueryObject.prop('defaultValue', jQueryObject.val()); // Set original value
            }
        }
    );
};

/**
 * Bind to windowunload to prompt the user if there are any changes pending before unloading the page.
 */
Bootstrap_Validation.confirmBeforePageChange = function () {
    // Set window to check for changes before changing page
    jQuery(window).bind('beforeunload', function() {
        var isDirty = Bootstrap_Validation.isDirty();
        if ( !isDirty ) {
            return; // Not dirty, return
        } else {
            // Prevent multiple prompts - seen on Chrome and IE
            if (navigator.userAgent.toLowerCase().match(/msie|chrome/)) {
                if (window.aysHasPrompted) {
                    return;
                }
                window.aysHasPrompted = true;
                window.setTimeout(function() {window.aysHasPrompted = false;}, 900);
            }
            return 'Your unsaved changes will be lost.';
        }
    });
};

/**
 * Returns true/false if there are any fields with the .isDirty flag
 * @return {Boolean}
 */
Bootstrap_Validation.isDirty = function() {
    var dirtyFields = jQuery('.isDirty');

  jQuery(dirtyFields).each(function () {
        console.log(this);
        console.log(jQuery(this));

    });

    if ( dirtyFields.length > 0 ) {
        return true;
    } else {
        return false;
    }
};

/**
 * Checks if page is valid
 */
Bootstrap_Validation.isValid = function() {
    var invalidFields = jQuery('.has-error');
    // Require attachments for some fields
    var invalidAttachments = jQuery('.needs-attachment');

    if ( invalidFields.length > 0 || invalidAttachments.length > 0) {
        return false;
    } else {
        return true;
    }
};

Bootstrap_Validation.errorDetails = function() {
    var field = jQuery('.has-error').first().children('.help-block'), message;
    if (field.length) {
        message = field.text();
        field = field.parent().parent().prev().prev();
        return message;
    }
    else {
        message = jQuery('.needs-attachment').first().data('message');
        return message;
    }
};