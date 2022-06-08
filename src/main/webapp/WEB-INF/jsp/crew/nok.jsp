<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>${action} Crew - Medical</title>

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
                <%@ include file="crew_header.jsp" %>

                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation-->
                        <nav class="nav nav-borders">
                            <a class="nav-link" href="/crew/modify?crewId=${crewId}">Profile</a>
                            <a class="nav-link" href="/crew/experience?crewId=${crewId}">Employment</a>
                            <a class="nav-link" href="/crew/education?crewId=${crewId}">Education</a>
                            <a class="nav-link" href="/crew/passport_visa?crewId=${crewId}">Passport/Visa</a>
                            <a class="nav-link" href="/crew/medical?crewId=${crewId}">Medical</a>
                            <a class="nav-link" href="/crew/bank?crewId=${crewId}">Bank Account</a>
                            <a class="nav-link active ms-0" href="/crew/nok?crewId=${crewId}">Next of Kin</a>
                            <a class="nav-link" href="/crew/documents?crewId=${crewId}">Documents</a>
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
                                        <c:when test="${crewId > 0}"><button class="btn btn-primary" type="submit">Save</button></c:when>
                                        <c:otherwise><button class="btn btn-primary" type="submit">Add</button></c:otherwise>
                                    </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-10">
                               <c:forEach items="${list}" var="nok">
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
                                                       <tr>
                                                            <td><label class="small mb-3">Next of Kin Name</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="nomineeName" id="nomineeName" type="text" placeholder="Enter name" value="${nok.nomineeName}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Relation</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="instituteAddress" id="instituteAddress" type="text" placeholder="Enter name" value="${edu.instituteAddress}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Date of Birth</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="educationName" id="educationName" type="text" placeholder="Enter Vessel Name" value="${edu.educationName}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Passport Number</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="percentageGrade" id="percentageGrade" type="text" placeholder="" value="${edu.percentage} ${edu.grade}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Has US Visa?</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="startDate" id="startDate" type="text" placeholder="Enter Start Date" value="${edu.startDate}" /></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><label class="small mb-3">Share %</label></td>
                                                            <td>
                                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="endDate" id="endDate" type="text" placeholder="Enter End Date" value="${edu.endDate}" /></div>
                                                            </td>
                                                        </tr>
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
