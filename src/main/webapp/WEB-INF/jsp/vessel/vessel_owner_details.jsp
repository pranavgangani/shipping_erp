<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>${action} Crew</title>

        <%@ include file="../includes/header_includes.jsp" %>
        <script src="../js/vessel/vessel_details.js"></script>
    </head>

    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>


        <div id="layoutSidenav">

        <%@ include file="../includes/sidebar.jsp" %>

            <div id="layoutSidenav_content">
                <main>
                 <c:choose>
                    <c:when test="${vesselOwner!=null && vesselOwner.id > 0}">
                        <form method="POST" enctype="multipart/form-data" action="/vessel/update_vessel_owner">
                    </c:when>
                    <c:otherwise>
                        <form method="POST" enctype="multipart/form-data" action="/vessel/add_vessel_owner">
                    </c:otherwise>
                </c:choose>
                <input type="hidden" name="vesselOwnerId" value="${vesselOwnerId}"/>

                <%@ include file="add_owner_header.jsp" %>

                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation-->
                        <nav class="nav nav-borders">
                            <a class="nav-link active ms-0">Profile</a>
                            <a class="nav-link" href="/vessel/owner_vessel_list?vesselOwnerId=${vesselOwner.id}">Vessels</a>
                            <a class="nav-link" href="/vessel/document_list?action=view&vesselOwnerId=${vesselOwner.id}">Documents</a>
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
											<c:when test="${vesselOwner.photoId>0}">
												<img class="img-account-profile rounded-circle mb-2" alt="img" src="data:image/jpeg;base64,${image}" alt="" id='preview' />
											</c:when>
											<c:otherwise>
											    <input type='file' id='file-input' hidden name="image">
												<img class="img-account-profile rounded-circle mb-2"
													src="../assets/img/illustrations/profiles/logo-1.png"
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
                                        <c:when test="${vessel!=null && vessel.id > 0}">
                                            <button class="btn btn-primary" type="submit">Add</button>
                                        </c:when>
                                        <c:otherwise>
                                           <button class="btn btn-primary" type="submit">Save</button>
                                        </c:otherwise>
                                    </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-10">
                                <!-- Change password card-->
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
		                                                <td><label class="small mb-1" for="ownerName">Vessel Owner Name</label></td>
		                                                <td><input class="form-control" id="ownerName" type="text" placeholder="Enter vessel owner name" value="${vesselOwner.ownerName}" name="ownerName" />
		                                                </td>
		                                                <td><label class="small mb-3" for="fName">${crew.fieldStatus.name.makerBy}</label></td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td>
		                                                	 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                                <!-- <span class="badge bg-success">Paid</span> -->
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-1" for="website">WebSite</label></td>
		                                                <td><div class="col-md-8 mb-3">
                                                            <input class="form-control" id="website" type="text" placeholder="Enter company website address" value="${vesselOwner.website}" name="website"/>
															</div>
		                                                </td>
		                                                <td>${crew.fieldStatus.maritalStatus.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-1" for="emailId">EmailID</label></td>
		                                                <td>
                                                            <input class="form-control" id="emailId" type="text" placeholder="Enter company email ID" value="${vesselOwner.emailId}" name="emailId"/>
		                                                </td>
		                                                <td>${crew.fieldStatus.nationality.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td> <label class="small mb-1" for="primaryFlag">Primary Flag</label></td>
		                                                <td><div class="col-md-8 mb-3">
                                                            <select class="form-select" aria-label="Default select example" name="primaryFlag">
                                                                <option selected disabled>Select a Primary Flag:</option>
                                                                <c:forEach items="${flags}" var="flag">
                                                                    <option <c:if test="${flag.code == vesselOwner.primaryFlagObj.code}">selected="true"</c:if> value="${flag.code}">${flag.name}</option>
                                                                </c:forEach>
                                                            </select>
															</div>
		                                                </td>
		                                                <td>${crew.fieldStatus.rank.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-1" for="regFlag">Registered Flag</label></td>
		                                                <td><div class="col-md-8 mb-3">
                                                            <select class="form-select" aria-label="Default select example" name="regFlag">
                                                                <c:forEach items="${flags}" var="flag">
                                                                       <option <c:if test="${flag.code == vesselOwner.registerdFlagObj.code}">selected="true"</c:if> value="${flag.code}">${flag.name}</option>
                                                                   </c:forEach>
                                                            </select>
															</div>
		                                                </td>
		                                                <td>${crew.fieldStatus.gender.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-1" for="length">Primary Contact</label></td>
		                                                <td><div class="col-md-8 mb-3">
                                                           <input class="form-control" id="length" type="text" placeholder="Enter Primary Contact" value="${vesselOwner.primaryContact}" name="primaryContact"/>
															</div>
		                                                </td>
		                                                <td>${crew.fieldStatus.manningOffice.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-1" for="beam">Secondary Contact</label></td>
		                                                <td>
                                                            <input class="form-control" id="beam" type="text" placeholder="Enter Secondary Contact" value="${vesselOwner.secondaryContact}" name="secondaryContact"/>
		                                                </td>
		                                                <td>${crew.fieldStatus.distinguishingMark.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-1" for="draught">Primary Address</label></td>
		                                                <td>
                                                            <textarea class="lh-base form-control" type="text" name="primaryAddr" placeholder="${vesselOwner.primaryAddress}" rows="4"></textarea>
		                                                </td>
		                                                <td>${crew.fieldStatus.homeAddress.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-1" for="draught">Registered Address</label></td>
		                                                <td><textarea class="lh-base form-control" type="text" name="regAddr" placeholder="${vesselOwner.registerdAddress}" rows="4"></textarea></td>
		                                                <td>${crew.fieldStatus.nearestAirport.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-1" for="yearOfStart">Year of Start</label></td>
		                                                <td><input class="form-control" id="yearOfStart" type="text" placeholder="Enter Operations Start Year" value="${vesselOwner.yearOfStart}" name="yearOfStart"/></td>
		                                                <td>${crew.fieldStatus.emailId.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                        </tbody>
		                                    </table>
		                                </div>
                                    </div>
                                </div>
                                <c:if test="${vesselOwner.id > 0}">
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

