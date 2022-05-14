<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>${action} Crew - Experience</title>

        <%@ include file="../includes/header_includes.jsp" %>
        <script src="../js/crew/crew_details.js"></script>
    </head>

    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>


        <div id="layoutSidenav">

        <%@ include file="../includes/sidebar.jsp" %>

            <div id="layoutSidenav_content">
                <main>
                <form id="crew-details-form" role="form" method="POST" enctype="multipart/form-data" action="/crew/${action}">
                <input type="hidden" id="crewId" name="crewId" value="${crew.id}">
                <%@ include file="add_crew_header.jsp" %>

                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation-->
                        <nav class="nav nav-borders">
                            <a class="nav-link" href="/crew/modify?crewId=${crewId}">Profile</a>
                            <a class="nav-link" href="/crew/experience?crewId=${crewId}">Employment</a>
                            <a class="nav-link" href="/crew/education?crewId=${crewId}">Education</a>
                            <a class="nav-link active ms-0" href="/crew/passport_visa?crewId=${crewId}">Passport/Visa</a>
                            <a class="nav-link" href="/crew/medical?crewId=${crewId}">Medical</a>
                            <a class="nav-link" href="/crew/bank?crewId=${crewId}">Bank Account</a>
                            <a class="nav-link" href="/crew/nominee?crewId=${crewId}">Nominee</a>
                            <a class="nav-link" href="/crew/documents?crewId=${crewId}">Other Documents</a>
                            <a class="nav-link" href="/crew/contracts?crewId=${crewId}">Contracts</a>
                        </nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">
                        <div class="col-lg-2">
                                <!-- Two factor authentication card-->
                                <div class="card mb-4">
                                    <div class="card-header">Profile Picture</div>
                                    <div class="card-body">
                                        <!-- Profile picture help block-->
										<c:choose>
											<c:when test="${crew.photoId>0}">
												<img class="img-account-profile rounded-circle mb-2" alt="img" src="data:image/jpeg;base64,${image}" alt="" id='preview' />
											</c:when>
											<c:otherwise>
											    <input type='file' id='file-input' hidden name="image">
												<img class="img-account-profile rounded-circle mb-2"
													src="../assets/img/illustrations/profiles/profile-1.png"
													alt="" id='preview' />
												<div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
											</c:otherwise>
										</c:choose>
										<!-- Profile picture upload button-->
										<button id="myBtn" class="btn btn-primary" type="button">Upload an image</button>

                                    </div>
                                </div>
                                <!-- Delete account card-->
                                <div class="card mb-4">
                                    <div class="card-header">Actions</div>
                                    <div class="card-body">
                                    <c:choose>
                                        <c:when test="${action == 'modify'}"><button class="btn btn-primary" type="submit">Save</button></c:when>
                                        <c:otherwise><button class="btn btn-primary" type="submit">Add</button></c:otherwise>
                                    </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-10">
                               <c:forEach items="${passports}" var="pv">
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <div class="table-responsive table-billing-history">
		                                    <table class="table mb-0">
		                                        <thead>
		                                            <tr>
		                                                <th class="border-gray-200" scope="col">Datapoint</th>
		                                                <th class="border-gray-200" scope="col">Value</th>
		                                                <th class="border-gray-200" scope="col">Maker</th>
		                                                <th class="border-gray-200" scope="col">Reviewer</th>
		                                                <th class="border-gray-200" scope="col">Audit</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
                                                        <c:if test="${pv.docType.documentPool.id == 1}">
                                                        <tr>
                                                            <td><label class="small mb-3">${pv.docType.name}</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3">${pv.docName}</div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">${pv.docType.documentPool.name} Number</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="docNumber" id="docNumber" type="text" placeholder="Enter name" value="${pv.docNumber}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Given Name in ${pv.docType.documentPool.name}</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="givenName" id="givenName" type="text" placeholder="Enter Vessel Name" value="${pv.givenName}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Place of Issue</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="placeOfIssue" id="placeOfIssue" type="text" placeholder="" value="${pv.placeOfIssue}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Date of Expiry</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="dateOfExpiry" id="dateOfExpiry" type="text" placeholder="Enter Start Date" value="${pv.dateOfExpiry}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Date of Issue</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="dateOfIssue" id="dateOfIssue" type="text" placeholder="Enter End Date" value="${pv.dateOfIssue}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">ECNR Required</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3">
                                                                    <select id="ecnrReq" name="ecnrReq">
                                                                        <option value="0" <c:if test="${!pv.isECNRRequired}">selected</c:if>>No</option>
                                                                        <option value="1" <c:if test="${pv.isECNRRequired}">selected</c:if>>Yes</option>
                                                                    </select>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Blank Pages</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="blankPages" id="blankPages" type="text" placeholder="Enter Blank Pages" value="${pv.blankPages}" /></div>
                                                            </td>
                                                        </tr>
                                                        </c:if>
		                                        </tbody>
		                                    </table>
		                                </div>
                                    </div>
                                </div>
                            </c:forEach>

                                <c:if test="${action == 'modify'}">
                                    <div class="card mb-4">
                                        <div class="card-header">Audit Trail</div>
                                        <div class="card-body">
                                            <div class="timeline timeline-xs">
                                                <c:forEach items="${auditTrails}" var="audit">
                                                    <div class="timeline-item">
                                                        <div class="timeline-item-marker">
                                                            <div class="timeline-item-marker-text">${audit.ago}</div>
                                                            <div class="timeline-item-marker-indicator bg-${audit.colour}"></div>
                                                        </div>
                                                        <div class="timeline-item-content">
                                                            ${audit.text}
                                                        </div>
                                                     </div>
                                               </c:forEach>
                                        </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>

                        </div>

                        </div>

                    </form>
                </main>

                <%@ include file="../includes/copyright.jsp" %>

            </div>
        </div>

        <%@ include file="../includes/bottom_includes.jsp" %>

    </body>

<script>

var input = document.querySelector("#file-input");

document.getElementById("myBtn").addEventListener("click", function () {
  input.click();
});

input.addEventListener("change", preview);
function preview() {
  var fileObject = this.files[0];
  var fileReader = new FileReader();
  fileReader.readAsDataURL(fileObject);
  fileReader.onload = function () {
    var result = fileReader.result;
    var img = document.querySelector("#preview");
    img.setAttribute("src", result);
  };
}

</script>
</html>
