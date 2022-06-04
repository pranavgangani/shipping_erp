// Create namespace for this file
var Bootstrap_Form_Demo_Validation = {};

jQuery(document).ready(function() {

    // Setup dirty flag checks
    Bootstrap_Validation.initializeOriginalValues('dirtycheck');
    Bootstrap_Validation.setupDirtyFlagEventHandlers('dirtycheck');
    Bootstrap_Validation.confirmBeforePageChange();

    jQuery('#exampleForm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            shareRegistry: { // Name of the validation
                selector: '#shareRegistry', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a Share Registry.' // Error message to display
                    }
                }
            },
            clientId: { // Name of the validation
                selector: '#clientId', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a Client.' // Error message to display
                    }
                }
            },
            fundId: { // Name of the validation
                selector: '#fundId', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a Fund.' // Error message to display
                    }
                }
            },
            newInvestorInFund: { // Name of the validation
                selector: '#newInvestorInFund', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select Yes/No.' // Error message to display
                    }
                }
            },
            investorId: { // Name of the validation
                selector: '#investorId', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a Investor.' // Error message to display
                    }
                }
            },
            myCustomValidationName: { // Name of the validation
                selector: '#custom', // Denotes what to run this validator on
                validators: {
                    callback: {
                        callback: function (value, validator, $field) {
                            // Run custom validation function that returns true/false
                            if ( Bootstrap_Form_Demo_Validation.customValidation(value, validator, $field) ) {
                                return {
                                    valid : true,
                                    message: 'Validated'
                                };
                            } else {
                                return {
                                    valid : false,
                                    message: 'Please enter a value. This is a custom validation that only appears when New Investor In Fund = Yes'
                                };
                            }
                        }
                    }
                }
            }
        }
    });

    // For select2 controls, need to add additional onchange to re-validate when select2 control changes
    jQuery('#clientId').on('change', function() {
        jQuery('#exampleForm').formValidation('revalidateField', 'clientId');
    });

    jQuery('#fundId').on('change', function() {
        jQuery('#exampleForm').formValidation('revalidateField', 'fundId');
    });

    jQuery('#newInvestorInFund').on('change', function() {
        jQuery('#exampleForm').formValidation('revalidateField', 'newInvestorInFund');
        // ALSO!!!! Force validate custom field which relies on the value from this one
        jQuery('#exampleForm').formValidation('revalidateField', 'myCustomValidationName');
    });

    jQuery('#investorId').on('change', function() {
        jQuery('#exampleForm').formValidation('revalidateField', 'investorId');
    });
});

Bootstrap_Form_Demo_Validation.customValidation = function (value, validator, $field) {
    // Custom Validation
    // Returns false when newInvestorInFund is true and this field has no value.
    if ( jQuery('#newInvestorInFund').val() == "true" && jQuery.trim(jQuery($field).val()) == "" ) {
        return false;
    } else {
        return true;
    }
};