var Offer_Letter = {}

Offer_Letter.approveOfferModal = function (offerId) {
    Offer_Letter.showModal(offerId);
};


Offer_Letter.showModal = function (offerId) {
    if (document.querySelector("#approveOfferModal") != null) {
        var modalLoading = '<div class="modal-dialog" role="document">\
                                \<input type="hidden" name="offerId" id="offerId" value="' + offerId + '">\
                                        <div class="modal-content">\
                                            <div class="modal-header">\
                                                <h5 class="modal-title" id="exampleModalLabel">Approve Offer Letter</h5>\
                                                <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>\
                                            </div>\
                                            <div class="modal-body">Please Approve or Reject this offer as per the candidate\'s approval.</div>\
                                            <div class="modal-footer">\
                                                <button onclick="Offer_Letter.approveReject(' + offerId + ',\'Rejected\')" class="btn btn-danger" type="button">Rejected</button>\
                                                <button onclick="Offer_Letter.approveReject(' + offerId + ',\'Approved\')" class="btn btn-success" type="button">Accepted</button>\
                                            </div>\
                                        </div>\
                                </div>';

        //jQuery(document.body).append(modalLoading);
        jQuery("#approveOfferModal").html(modalLoading);
    }
    jQuery("#approveOfferModal").modal("show");
};

Offer_Letter.approveReject = function (offerId, action) {

    var data = new FormData();
    data.set("action", action);
    data.append("crewId", jQuery('#crewId').val());
    data.append("offerId", offerId);

    var ajaxCall = jQuery.ajax({
        url: jQuery('#contextPath').val() + "/crew/offer/acceptReject.ajax",
        method: 'POST',
        data: data,
        type: "POST",
        cache: false, // Stop IE from caching ajax results!
        processData: false,
        contentType: false,
        success: function (data) {
            jQuery("#approveOfferModa1l").modal("hide");
            jQuery(location).attr('href', jQuery('#contextPath').val() + "/crew/offer?menu=hist&sMenu=offer&action=list&crewId=" + jQuery('#crewId').val());
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