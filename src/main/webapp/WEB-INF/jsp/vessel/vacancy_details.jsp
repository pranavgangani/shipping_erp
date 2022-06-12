<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>${action} Vacancy</title>

        <%@ include file="../includes/header_includes.jsp" %>
        <script src="../js/crew/crew_details.js"></script>
    </head>

    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>


        <div id="layoutSidenav">

        <%@ include file="../includes/sidebar.jsp" %>

            <div id="layoutSidenav_content">
                <main>
                <form id="crew-details-form" role="form" method="POST" enctype="multipart/form-data" action="/vessel/vacancy_details?action=update">


                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation-->

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
                                        <button class="btn btn-primary" type="submit">Add</button>
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
		                                                <td><label class="small mb-3">Name</label></td>
		                                                <td>
			                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="fName" id="fName" type="text" placeholder="Enter first name" value="${crew.fName}" /></div>
			                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="mName" id="mName" type="text" placeholder="Enter middle name" value="${crew.mName}" /></div>
		                                                	<div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="lName" id="lName" type="text" placeholder="Enter last name" value="${crew.lName}" /></div>
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
		                                                <td><label class="small mb-3" for="maritalStatus">Marital Status</label></td>
		                                                <td><div class="col-md-8 mb-3">
			                                                <select class="form-select" id="maritalStatus" name="maritalStatus" aria-label="Default select example">
																<option selected disabled>Marital Status:</option>
																<option <c:if test="${crew.maritalStatus=='unmarried'}">selected</c:if> value="unmarried">Unmarried</option>
																<option <c:if test="${crew.maritalStatus=='married'}">selected</c:if> value="married">Married</option>
															</select>
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
		                                                <td><label class="small mb-3" for="nationality">Nationality</label></td>
		                                                <td>
                                                            <select class="form-select" aria-label="Default select example" id="nationalityFlagCode" name="nationalityFlagCode">
                                                                <option selected disabled>Select Nationality Flag:</option>
                                                                <c:forEach items="${flags}" var="flag">
                                                                        <option value="${flag.code}">${flag.name}</option>
                                                                </c:forEach>
                                                            </select>
		                                                <input class="form-control" name="nationality" type="text" placeholder="Enter Nationality" value="${crew.nationality}" />
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
		                                                <td><label class="small mb-3" for="rankId">Rank</label></td>
		                                                <td><div class="col-md-8 mb-3">
			                                                <select class="form-select" id="rankId" name="rankId" aria-label="Default select example">
																<option selected disabled>Select a Rank:</option>
																<c:forEach var="optionGroup" items="${rankMap}">
															       <optgroup label="${optionGroup.key}">
															       <c:forEach var="option" items="${optionGroup.value}">
															          <option <c:if test="${crew.rank.id==option.id}">selected</c:if> value="${option.id}">${option.name} (${option.rankSubCategory.name})</option>
															       </c:forEach>
															       </optgroup>
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
		                                                <td><label class="small mb-3" for="gender">Gender</label></td>
		                                                <td><div class="col-md-8 mb-3">
			                                                <select class="form-select" id="gender" name="gender" aria-label="Default select example">
																<option selected disabled>Gender:</option>
																<option <c:if test="${crew.gender=='male'}">selected</c:if> value="male">Male</option>
																<option <c:if test="${crew.gender=='female'}">selected</c:if> value="female">Female</option>
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
		                                                <td><label class="small mb-3" for="manningOffice">Manning Office</label></td>
		                                                <td><div class="col-md-8 mb-3">
		                                                    <input class="form-control" id="manningOffice" name="manningOffice" type="text" placeholder="Enter Nearest Airport" value="${crew.manningOffice}" />
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
		                                                <td><label class="small mb-3" for="distinguishingMark">Distinguishing Mark</label></td>
		                                                <td>
															<textarea name="distinguishingMark" id="distinguishingMark" class="lh-base form-control" placeholder="" rows="3" cols="3">${crew.distinguishMark}</textarea>
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
		                                                <td><label class="small mb-3" for="homeAddress">Home Address</label></td>
		                                                <td>
															<textarea name="homeAddress" id="homeAddress" class="lh-base form-control" placeholder="" rows="3" cols="3">${crew.permAddress}</textarea>
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
		                                                <td><label class="small mb-3" for="nearestAirport">Nearest Airport</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" id="nearestAirport" name="nearestAirport" type="text" placeholder="Enter Nearest Airport" value="${crew.nearestAirport}" /></div></td>
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
		                                                <td><label class="small mb-3" for="emailId">EmailID</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" id="emailId" name="emailId" type="text" placeholder="Enter Email ID" value="${crew.emailId}" /></div></td>
		                                                <td>${crew.fieldStatus.emailId.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="emailId" type="checkbox"  />
	                                                		</div>
                                                		</td>
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="contact_1">Contact#1</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" id="contact_1" name="contact_1" type="text" placeholder="Enter Contact Number#1" value="${crew.contact1}" /></div></td>
		                                                <td>${crew.fieldStatus.contact1.makerBy}</td>
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
		                                                <td><label class="small mb-3" for="contact_2">Contact#2</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" id="contact_2" name="contact_2" type="text" placeholder="Enter Contact Number#2" value="${crew.contact2}" /></div></td>
		                                                <td>${crew.fieldStatus.contact2.makerBy}</td>
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
		                                                <td><label class="small mb-3" for="dob">Date of Birth</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" id="birthDate" name="birthDate" type="text" placeholder="Enter DOB" value="${crew.dob}" /></div></td>
		                                                <td>${crew.fieldStatus.dob.makerBy}</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox"  />
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
                                <c:if test="${action == 'Edit'}">
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
