// Create namespace for this file
var Subscription_Details_Validation = {};


Subscription_Details_Validation.init = function() {
    jQuery('#tradeForm').formValidation({
        framework: 'bootstrap',
        excluded: false,
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
            subscriptionOrigin: { // Name of the validation
                selector: '#subscriptionOrigin', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a Subscription Origin.' // Error message to display
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
                        message: 'Please select an Investor.' // Error message to display
                    }
                }
            },
            newInvestorInClass: { // Name of the validation
                selector: '#newInvestorInClass', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select Yes/No.' // Error message to display
                    }
                }
            },
            shareRegistryInvestorId: { // Name of the validation
                selector: '#shareRegistryInvestorId', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please enter an Entity ID.' // Error message to display
                    }
                }
            },
            investorReference: { // Name of the validation
                selector: '#investorReference', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please enter a Sub-Entity ID.' // Error message to display
                    }
                }
            },
            subscriptionAmount: { // Name of the validation
                selector: '#subscriptionAmount', // Denotes what to run this validator on
                excluded: function($field, validator) {
                    if ($('#subscriptionAmount').is(':disabled')){
                        return true;
                    }else {
                        return false;
                    }
                },
                validators: {
                    /*notEmpty: {
                     message: 'Please enter Amount.' // Error message to display
                     },*/
                    callback:{
                        message: 'Please enter Amount.', // Error message to display
                        callback: function(value, validator, $field) {
                            var transactionTypeId = jQuery('#subscriptionType').val();
                            if (transactionTypeId == 1 || transactionTypeId == 5) {
                                if (jQuery('#subscriptionAmount').val() ===''){
                                    jQuery("#subscriptionAmount").val("0.0");
                                    return true;
                                }else if (jQuery('#subscriptionAmount').val() >= 0){
                                    return true;
                                }else{
                                    jQuery("#subscriptionAmount").val("0.0");
                                    return true;
                                }
                            } else if (transactionTypeId <= 0) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            },
            subscriptionShares: { // Name of the validation
                selector: '#subscriptionShares', // Denotes what to run this validator on
                excluded: function($field, validator) {
                    if ($('#subscriptionShares').is(':disabled')){
                        return true;
                    }else {
                        return false;
                    }
                },
                validators: {
                    /*notEmpty: {
                     message: 'Please enter Shares.' // Error message to display
                     },*/
                    callback:{
                        message: 'Please enter Shares.', // Error message to display
                        callback: function(value, validator, $field) {
                            var transactionTypeId = jQuery('#subscriptionType').val();
                            if (transactionTypeId == 2 || transactionTypeId == 6) {
                                if (jQuery('#subscriptionShares').val() ===''){
                                    jQuery("#subscriptionShares").val("0.0");
                                    return true;
                                }else if (jQuery('#subscriptionShares').val() >= 0){
                                    return true;
                                }else{
                                    jQuery("#subscriptionShares").val("0.0");
                                    return true;
                                }
                            } else if (transactionTypeId <= 0) {
                                return true;
                            } else {
                                return false;
                            }

                        }
                    }
                }
            },
            subscriptionDate: { // Name of the validation
                selector: '#subscriptionDate', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please enter a Trade Date.' // Error message to display
                    },
                    date: {
                        format: "YYYY-MM-DD",
                        message: 'Please enter a date in the format YYYY-MM-DD.'
                    }
                }
            },
            settlementDate: { // Name of the validation
                selector: '#settlementDate', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please enter a Settlement Date.' // Error message to display
                    },
                    date: {
                        format: "YYYY-MM-DD",
                        message: 'Please enter a date in the format YYYY-MM-DD.'
                    }
                }
            },
            dateValidation: { // Name of the validation
                selector: '#creditDateFrom, #creditDateTo', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please enter a Date.' // Error message to display
                    },
                    date: {
                        format: "YYYY-MM-DD",
                        message: 'Please enter a date in the format YYYY-MM-DD.'
                    }
                }
            },
            subscriptionType: { // Name of the validation
                selector: '#subscriptionType', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a Transaction Type.' // Error message to display
                    }
                }
            },
            currencyCode: { // Name of the validation
                selector: '#currencyCode', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a Currency.' // Error message to display
                    }
                }
            },
            /*   ppmMinimumStatusSubscription: { // Name of the validation
             selector: '#ppmMinimumStatusSubscription', // Denotes what to run this validator on
             validators: {
             callback: {
             callback: function (value, validator, $field) {
             // Run custom validation function that returns true/false
             if ( Subscription_Details_Validation.ppmValidation() ) {
             return {
             valid : true,
             message: 'Validated'
             };
             } else {
             return {
             valid : false,
             message: 'Please select a PPM Minimum Satisfied Status.'
             };
             }
             }
             }
             }
             },*/
            investorERISAStatusId: { // Name of the validation
                selector: '#investorERISAStatusId', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a Erisa status.' // Error message to display
                    }
                }
            },
            lookThroughFee: { // Name of the validation
                selector: '#lookThroughFee', // Denotes what to run this validator on
                excluded: function($field, validator) {
                    if (!$('#lookThroughFee').is(':visible')){
                        return true;
                    }else {
                        return false;
                    }
                },
                validators: {
                    callback: {
                        callback: function (value, validator, $field) {
                            // Run custom validation function that returns true/false
                            var result = Subscription_Details_Validation.lookThroughFeeValidation();
                            if ( result == '' ) {
                                return {
                                    valid : true,
                                    message: 'Validated'
                                };
                            } else {
                                return {
                                    valid : false,
                                    message: result
                                };
                            }
                        }
                    }
                }
            },
            investorType: { // Name of the validation
                selector: '#investorType', // Denotes what to run this validator on
                validators: {
                    callback: {
                        callback: function (value, validator, $field) {
                            // Run custom validation function that returns true/false
                            var result = Subscription_Details_Validation.investorTypeValidation();
                            if ( result == '' ) {
                                return {
                                    valid : true,
                                    message: 'Validated'
                                };
                            } else {
                                return {
                                    valid : false,
                                    message: result
                                };
                            }
                        }
                    }
                }
            },
            primaryAddressCountryCode: { // Name of the validation
                selector: '#primaryAddressCountryCode', // Denotes what to run this validator on
                validators: {
                    callback: {
                        callback: function (value, validator, $field) {
                            // Run custom validation function that returns true/false
                            var result = Subscription_Details_Validation.primaryAddressCountryCodeValidation();
                            if ( result == '' ) {
                                return {
                                    valid : true,
                                    message: 'Validated'
                                };
                            } else {
                                return {
                                    valid : false,
                                    message: result
                                };
                            }
                        }
                    }
                }
            },
            incorporationCountryCode: { // Name of the validation
                selector: '#incorporationCountryCode', // Denotes what to run this validator on
                validators: {
                    callback: {
                        callback: function (value, validator, $field) {
                            // Run custom validation function that returns true/false
                            var result = Subscription_Details_Validation.incorporationCountryCodeValidation();
                            if ( result == '' ) {
                                return {
                                    valid : true,
                                    message: 'Validated'
                                };
                            } else {
                                return {
                                    valid : false,
                                    message: result
                                };
                            }
                        }
                    }
                }
            },
            registeredOfficeCountryCode: { // Name of the validation
                selector: '#registeredOfficeCountryCode', // Denotes what to run this validator on
                validators: {
                    callback: {
                        callback: function (value, validator, $field) {
                            // Run custom validation function that returns true/false
                            var result = Subscription_Details_Validation.registeredOfficeCountryCodeValidation();
                            if ( result == '' ) {
                                return {
                                    valid : true,
                                    message: 'Validated'
                                };
                            } else {
                                return {
                                    valid : false,
                                    message: result
                                };
                            }
                        }
                    }
                }
            },
            placeOfBusinessCountryCode: { // Name of the validation
                selector: '#placeOfBusinessCountryCode', // Denotes what to run this validator on
                validators: {
                    callback: {
                        callback: function (value, validator, $field) {
                            // Run custom validation function that returns true/false
                            var result = Subscription_Details_Validation.placeOfBusinessCountryCodeValidation();
                            if ( result == '' ) {
                                return {
                                    valid : true,
                                    message: 'Validated'
                                };
                            } else {
                                return {
                                    valid : false,
                                    message: result
                                };
                            }
                        }
                    }
                }
            },
//            wireOriginCountryCode: { // Name of the validation   commented out
//                selector: '#wireOriginCountryCode', // Denotes what to run this validator on
//                validators: {
//                    callback: {
//                        callback: function (value, validator, $field) {
//                            // Run custom validation function that returns true/false
//                            var result = Subscription_Details_Validation.wireOriginCountryCodeValidation();
//                            if ( result == '' ) {
//                                return {
//                                    valid : true,
//                                    message: 'Validated'
//                                };
//                            } else {     test test
//                                return {
//                                    valid : false,
//                                    message: result
//                                };
//                            }
//                        }
//                    }
//                }
//            },
            isInvestorPEPFlag: { // Name of the validation
                selector: '#isInvestorPEPFlag', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a PEP Status.' // Error message to display
                    }
                }
            },
            isSovereignWealthFundFlag: { // Name of the validation
                selector: '#isSovereignWealthFundFlag', // Denotes what to run this validator on
                validators: {
                    callback: {
                        callback: function (value, validator, $field) {
                            // Run custom validation function that returns true/false
                            var result = Subscription_Details_Validation.isSovereignWealthFundFlagValidation();
                            if ( result == '' ) {
                                return {
                                    valid : true,
                                    message: 'Validated'
                                };
                            } else {
                                return {
                                    valid : false,
                                    message: result
                                };
                            }
                        }
                    }
                }
            },
            amlRelatedRedactedLanguage: { // Name of the validation
                selector: '#amlRelatedRedactedLanguage', // Denotes what to run this validator on
                validators: {
                    notEmpty: {
                        message: 'Please select a ARL Status.' // Error message to display
                    }
      }
    });

    // Checkbox validation
    jQuery('.fieldChecker').on('change', function() {
        Subscription_Details_Validation.checkerValidation(this);
    });

    jQuery('.fieldApprover').on('change', function() {
        Subscription_Details_Validation.approverValidation(this);
    });

    /********** For select2 controls, need to add additional onchange to re-validate when select2 control changes *******/

    jQuery('#shareRegistry').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'shareRegistry');
    });

    jQuery('#subscriptionOrigin').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'subscriptionOrigin');

        // Revalidate other fields when changed
        //jQuery('#tradeForm').formValidation('revalidateField', 'ppmMinimumStatusId');
        jQuery('#tradeForm').formValidation('revalidateField', 'investorType');
        jQuery('#tradeForm').formValidation('revalidateField', 'primaryAddressCountryCode');
        jQuery('#tradeForm').formValidation('revalidateField', 'incorporationCountryCode');
        jQuery('#tradeForm').formValidation('revalidateField', 'registeredOfficeCountryCode');
        jQuery('#tradeForm').formValidation('revalidateField', 'placeOfBusinessCountryCode');
        jQuery('#tradeForm').formValidation('revalidateField', 'isSovereignWealthFundFlag');
    });

    jQuery('#clientId').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'clientId');
    });

    jQuery('#fundId').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'fundId');
    });

    jQuery('#newInvestorInFund').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'newInvestorInFund');
    });

    jQuery('#investorId').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'investorId');
    });

    jQuery('#newInvestorInClass').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'newInvestorInClass');
    });

    jQuery('#subscriptionType').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'subscriptionType');
    });

    jQuery('#currencyCode').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'currencyCode');
    });

    jQuery('#assetVerificationSatisfiedFlag').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'assetVerificationSatisfiedFlag');
    });
    /* jQuery('#ppmMinimumStatusSubscription').on('change', function() {
     jQuery('#tradeForm').formValidation('revalidateField', 'ppmMinimumStatusSubscription');
     });*/

    jQuery('#investorERISAStatusId').on('change', function() {
        jQuery("#lookThroughFeeDisabledFormGroup").hide();
        jQuery("#lookThroughFeeFormGroup").show();
        jQuery('#tradeForm').formValidation('revalidateField', 'investorERISAStatusId');
        // Force revalidation of lookThroughFee
        jQuery('#tradeForm').formValidation('revalidateField', 'lookThroughFee');
    });

    jQuery('#lookThroughFee').on('change', function() {
        // Revalidate Erisa Status
        jQuery('#tradeForm').formValidation('revalidateField', 'investorERISAStatusId');
    });

    jQuery('#investorType').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'investorType');
        // Revalidate other fields when InvestorType is changed
        jQuery('#tradeForm').formValidation('revalidateField', 'primaryAddressCountryCode');
        jQuery('#tradeForm').formValidation('revalidateField', 'incorporationCountryCode');
        jQuery('#tradeForm').formValidation('revalidateField', 'registeredOfficeCountryCode');
        jQuery('#tradeForm').formValidation('revalidateField', 'placeOfBusinessCountryCode');
        jQuery('#tradeForm').formValidation('revalidateField', 'isSovereignWealthFundFlag');
    });

    jQuery('#primaryAddressCountryCode').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'primaryAddressCountryCode');
    });

    jQuery('#incorporationCountryCode').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'incorporationCountryCode');
    });

    jQuery('#registeredOfficeCountryCode').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'registeredOfficeCountryCode');
    });

    jQuery('#placeOfBusinessCountryCode').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'placeOfBusinessCountryCode');
    });

    jQuery('#isSovereignWealthFundFlag').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'isSovereignWealthFundFlag');
    });

    jQuery('#shareRegistryInvestorId').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'shareRegistryInvestorId');
    });

    jQuery('#investorReference').on('change', function() {
        jQuery('#tradeForm').formValidation('revalidateField', 'investorReference');
    });
};

Subscription_Details_Validation.checkerValidation = function (checkbox) {
    var jQueryObject = jQuery(checkbox);
    var fieldName = jQuery(checkbox).data('field');
    var checkBoxId = jQueryObject.attr('id');
	// Check that employeeId is not the same as MakerId for this field
    var makerLabelId = fieldName + 'MakerLabel';
    if(jQueryObject.hasClass('amlCriticalLevel1')){
        var isInvestorPEPFlagMakerId = jQuery('#isInvestorPEPFlagMakerLabel').text();
        var isInvestorPEPFlag = jQuery('#isInvestorPEPFlag').val();

        if ( checkBoxId == 'isInvestorPEPFlagCheckerCheckbox' &&
            isInvestorPEPFlagMakerId == "AUT008" &&
            isInvestorPEPFlag != "false" ){
            if (jQuery('#amlPEPApprover').val() != "true") {
                // if you are not a PEP approver you should not do this}
                jQueryObject.attr('checked', (jQueryObject.is(':checked')) ? false : true); // Force opposite of what was done
                jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
                // Show error message
                Bootstrap_Util.clearToastAlerts();
                Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "You do not have sufficient privileges for this action ");
            }

        }
		// maker checker validation
		var makerId = jQuery('#' + makerLabelId).text();
        var employeeId = jQuery('#employeeId').val();

        if (makerId == employeeId) {
            jQueryObject.attr('checked', false); // Force uncheck
            jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
            // Show error message
			Bootstrap_Util.clearToastAlerts();
			Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Checker cannot also be Maker.");
        }else if(makerId == ""){
			jQueryObject.attr('checked', false); // Force uncheck
            jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
			Bootstrap_Util.clearToastAlerts();
			Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Maker can not be empty.");
		}
    }
    else if (jQuery('#invServicesAuthorizedSignatory').val() != "true" ){
        //check whether user has SRG Access
        // To Do - restrict SRG from reviewing any data points other than the address fields
        var isSRGAccess = jQuery('#hasShareRegistryEntryAccess').val();
        var isDualSrgIsg = jQuery('#dualISGSRG').val();
        if (isSRGAccess == 'true' || isDualSrgIsg == 'true') {
            //SRG user should able to check
            var makerLabelId = fieldName + 'MakerLabel';
            var makerId = jQuery('#' + makerLabelId).text();
            var employeeId = jQuery('#employeeId').val();

            if (makerId == employeeId) {
                jQueryObject.attr('checked', false); // Force uncheck
                jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
                // Show error message
                Bootstrap_Util.clearToastAlerts();
                Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Checker cannot also be Maker.");
            }
        }else{
            // if you are not an authorized signatory you should not do this}
            jQueryObject.attr('checked', (jQueryObject.is(':checked')) ? false : true); // Force opposite of what was done
            jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
            // Show error message
            Bootstrap_Util.clearToastAlerts();
            Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "You do not have sufficient privileges for this action ");
        }
    }
    else if (jQueryObject.is(':checked') ) {
        if ( fieldName == 'accreditedInvestorFlag'
            || fieldName == 'qualifiedPurchaserFlag'
            || fieldName == 'authorizedSignatory'
            || fieldName == 'wireAccountAtRecogFinInstFlag'
            || fieldName == 'wireAccountInInvestorsNameFlag'
            || fieldName == 'sideLetter'
            || fieldName == 'contractNote'
            ) {
            // Make ajax call to test if user is valid to be a checker for this datapoint
            var ajaxCall = Subscription_Details_Validation.isCheckerValid(fieldName);

            jQuery.when( ajaxCall ).done( function( isValidResult ) {
                if (isValidResult != 'true') {
                    jQueryObject.attr('checked', false); // Force uncheck
                    jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
                    // Show error message
                    Bootstrap_Util.clearToastAlerts();
                    Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "You cannot check this field because you have uploaded an attachment ");
                    return false;
                }
            });
        }


        if ( checkBoxId == 'riskCategoryCheckerCheckbox') {
            // Only AML halt approver can approve risk rating
            if ( jQuery('#amlHaltApprover').val() != "true" ) {
                jQueryObject.attr('checked', false); // Force uncheck
                jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
                // Show error message
                Bootstrap_Util.clearToastAlerts();
                Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "You do not have sufficient privileges for this action ");
            }
            // Check if PEP and SWF AML fields are approved before lifting the halt which happens with this action
            if ( (jQuery('#isInvestorPEPFlag').val() == "true" && !(jQuery('#isInvestorPEPFlagApproverCheckbox').is(':checked'))) ||
                (jQuery('#isSovereignWealthFundFlag').val() == "true" && !(jQuery('#isSovereignWealthFundFlagApproverCheckbox').is(':checked')))) {
                jQueryObject.attr('checked', false); // Force uncheck
                jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
                // Show error message
                Bootstrap_Util.clearToastAlerts();
                Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "PEP and SWF status must approved before lifting the halt ");
            }
        }
        else {
            var makerId = jQuery('#' + makerLabelId).text();
            var employeeId = jQuery('#employeeId').val();

            if (makerId == employeeId) {
                jQueryObject.attr('checked', false); // Force uncheck
                jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
                // Show error message
				Bootstrap_Util.clearToastAlerts();
				Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Checker cannot also be Maker.");
            }else if(makerId == ""){
				jQueryObject.attr('checked', false); // Force uncheck
                jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
				Bootstrap_Util.clearToastAlerts();
				Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Maker can not be empty.");
			}
        }
    }
    else {
        if ( checkBoxId == 'riskCategoryCheckerCheckbox') {
            // Only AML halt approver can un-approve risk rating
            if ( jQuery('#amlHaltApprover').val() != "true" ) {
                jQueryObject.attr('checked', false); // Force uncheck
                jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
                // Show error message
                Bootstrap_Util.clearToastAlerts();
                Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "You do not have sufficient privileges for this action ");
                return false;
            }
        }
    }
};

Subscription_Details_Validation.isCheckerValid = function (fieldName) {
    var subscriptionId = jQuery('#subscriptionId').val();

    // Ajax call to add new Subscription
    var ajaxCall = jQuery.ajax({
        url: jQuery('#contextPath').val() + "/subscription/isCheckerValid.ajax",
        method: 'GET',
        data: {
            // Parameters to be sent with the request
            subscriptionId: subscriptionId,
            fieldName: fieldName
        },
        type: "GET",
        cache: false, // Stop IE from caching ajax results!
        async: false,
        success: function (data) {
            return data;
        },
        error: function (data) {
            if (typeof data.responseText != 'undefined') {
                Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Is Checker Valid Error. " + data.responseText);
            } else {
                Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Is Checker Valid Error. " + data);
            }
            return null;
        }
    });

    return ajaxCall;
};

Subscription_Details_Validation.approverValidation = function (checkbox) {
    var jQueryObject = jQuery(checkbox);
    var isApproverEmployee = jQuery('#isApproverEmployee').val();

    if((jQueryObject.hasClass('amlCriticalLevel3')) && jQuery('#investorServices').val() == "true"){
        // if you are an IS person entering subs you can not do this}
        jQueryObject.attr('checked', (jQueryObject.is(':checked')) ? false : 'checked' ); // Force opposite of what was done
        jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
        // Show error message
        Bootstrap_Util.clearToastAlerts();
        Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "You do not have sufficient privileges for this action ");
    }
    else if (jQueryObject.is(':checked') ) {
        // Check that employeeId is not the same as MakerId/CheckerId for this field
        var field = jQueryObject.data('field');
        var makerLabelId = field + 'MakerLabel';
        var makerId = jQuery('#' + makerLabelId).text();

        var checkerLabelId = field + 'CheckerLabel';
        var checkerId = jQuery('#' + checkerLabelId).text();

        var employeeId = jQuery('#employeeId').val();

        if (!(jQuery('#' + field + 'CheckerCheckbox').is(':checked'))) {
            jQueryObject.attr('checked', false); // Force uncheck
            jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
            // Show error message
            Bootstrap_Util.clearToastAlerts();
            Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Field must be reviewed before approving ");
        }
        else if ( !isApproverEmployee ) {
             if(field == "investorType"){
                 //nothing to do
             }else{
            jQueryObject.attr('checked', false); // Force uncheck
            jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
            // Show error message
            Bootstrap_Util.clearToastAlerts();
            Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "AD Approval or higher is required ");
        }
        }
        else if (makerId == employeeId) {
            jQueryObject.attr('checked', false); // Force uncheck
            jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
            // Show error message
            Bootstrap_Util.clearToastAlerts();
            Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Approver cannot also be Maker ");
        }
        else if (checkerId == employeeId) {
            jQueryObject.attr('checked', false); // Force uncheck
            jQueryObject.removeClass('isDirty'); // Remove isDirty class (since essentially this field is unmodified)
            // Show error message
            Bootstrap_Util.clearToastAlerts();
            Bootstrap_Util.openToastAlert("error", "<i class='fa fa-remove'></i>Error", "Approver cannot also be Checker ");
        }

    }
};

/**
 * Validate PPM Minimum Satisfied.
 * Returns false if TransactionOrigin is Reinvestment, Fee Rebate, or Management Fee Rebate
 * and PPM Minimum Satisfied is blank.
 */
Subscription_Details_Validation.ppmValidation = function () {
    var subscriptionOrigin = jQuery('#subscriptionOrigin').val();
    var ppmMinimumStatusSubscription = jQuery('#ppmMinimumStatusSubscription').val();

    if ( subscriptionOrigin == 3 || // Reinvestment
        subscriptionOrigin == 6 || // Fee Rebate
        subscriptionOrigin == 7 ) { // Management Fee Rebate

        if (ppmMinimumStatusSubscription == '') {
            return false;
        }
    }

    return true;
};

/*Subscription_Details_Validation.erisaValidation = function () {
 var investorERISAStatusId = jQuery("#investorERISAStatusId").val();
 var lookThroughFee = jQuery("#lookThroughFee").val();
 var returnValue = "";

 if ( lookThroughFee < 0 ) {
 returnValue = "Please enter a valid ERISA Percent ";
 return returnValue;
 }
 if ( lookThroughFee == 0 ) {
 if (investorERISAStatusId == '') {
 returnValue = "ERISA Status must be supplied ";
 return returnValue;
 }
 }
 return returnValue;
 };*/

/**
 * Validate Look Through Fee
 *
 */
Subscription_Details_Validation.lookThroughFeeValidation = function () {
    var investorERISAStatusId = jQuery("#investorERISAStatusId").val();
    var lookThroughFee = jQuery("#lookThroughFee").val();
    var returnValue = "";
    var newInvestorInFund = jQuery("#newInvestorInFund").val();

	// show current erisa report
	if (investorERISAStatusId != 20 && investorERISAStatusId !=30 && investorERISAStatusId != 60 && investorERISAStatusId != 110){
        jQuery("#currentFundERISAReportNADiv").show();
        jQuery("#currentFundERISAReportAttachmentDiv,  #currentFundERISAReportMakerLabel, #currentFundERISAReportCheckerCheckbox, #currentFundERISAReportCheckerLabel").hide();
    }else{
        jQuery("#currentFundERISAReportNADiv").hide();
        jQuery("#currentFundERISAReportAttachmentDiv,  #currentFundERISAReportMakerLabel, #currentFundERISAReportCheckerCheckbox, #currentFundERISAReportCheckerLabel").show();
    }

    if ( investorERISAStatusId == 110 )