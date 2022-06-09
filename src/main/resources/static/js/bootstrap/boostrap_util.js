// Create namespace for this file
var Bootstrap_Util = {};


Bootstrap_Util.showPleaseWait = function () {
    if (document.querySelector("#pleaseWaitDialog") == null) {
        var modalLoading = '<div class="modal" tabindex="-1" id="pleaseWaitDialog" data-backdrop="static" data-keyboard="false" role="dialog">\
            <div class="modal-dialog">\
                <div class="modal-content">\
                    <div class="modal-header">\
                        <h4 class="modal-title">Please wait...</h4>\
                    </div>\
                    <div class="modal-body">\
                        <div class="progress">\
                          <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar"\
                          aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%; height: 40px">\
                          </div>\
                        </div>\
                    </div>\
                </div>\
            </div>\
        </div>';
        jQuery(document.body).append(modalLoading);
    }
    jQuery("#pleaseWaitDialog").modal("show");
};

Bootstrap_Util.hidePleaseWait = function () {
    jQuery('.progress').removeClass("active");
    jQuery('#pleaseWaitDialog').modal("hide");
};

Bootstrap_Util.openToastAlert = function (classType, icon, msg) {
    /*<div className="alert alert-"+classType+" alert-dismissible fade show" role="alert">
        <h5 className="alert-heading">Alert Heading</h5>
        This alert example has an alert heading, an alert link, and is dismissible! <a className="alert-link" href="#!">Example
        alert link!</a>
        <button className="btn-close" type="button" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>*/
};

