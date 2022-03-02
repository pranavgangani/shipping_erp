<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Crew Documents</title>
    
        <%@ include file="../includes/header_includes.jsp" %>
        <script src="../js/crew/crew_details.js"></script>
    </head>

    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>
       
       
        <div id="layoutSidenav">
        
        <%@ include file="../includes/sidebar.jsp" %>
            
            <div id="layoutSidenav_content">
                <main>
                <form method="POST" enctype="multipart/form-data" action="/crew/add"> 
                
                <%@ include file="add_crew_header.jsp" %>
                    
                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation-->
                        <nav class="nav nav-borders">
                            <a class="nav-link active ms-0" href="/crew/add">Profile</a>
                            <a class="nav-link" href="/crew/add_employment">Employment</a>
                            <a class="nav-link" href="/crew/add_education">Education</a>
                            <a class="nav-link" href="/crew/add_passport_visa">Passport/Visa</a>
                            <a class="nav-link" href="/crew/add_medical">Medical</a>
                            <a class="nav-link" href="/crew/add_bank_account">Bank Account</a>
                            <a class="nav-link" href="/crew/add_nominee">Nominee</a>
                            <a class="nav-link">Other Documents</a>
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
												<img class="img-account-profile rounded-circle mb-2"
													src="../assets/img/illustrations/profiles/profile-1.png"
													alt="" id='preview' />
											</c:otherwise>
										</c:choose>
										<!-- Profile picture upload button-->									
                                    </div>
                                </div>
                                <!-- Delete account card-->
                                <div class="card mb-4">
                                    <div class="card-header">Actions</div>
                                    <div class="card-body">
                                        <button class="btn btn-primary" type="submit">Update</button> 	
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
			                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="fName" type="text" placeholder="Enter first name" value="${crew.fName}" /></div>
			                                                <div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="mName" type="text" placeholder="Enter middle name" value="${crew.mName}" /></div>
		                                                	<div class="col-md-10 mb-3"><input class="small mb-2 form-control" name="lName" type="text" placeholder="Enter last name" value="${crew.lName}" /></div>
		                                                </td>
		                                                <td><label class="small mb-3" for="fName">IND3289</label></td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
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
			                                                <select class="form-select" name="maritalStatus" aria-label="Default select example">
																<option selected disabled>Marital Status:</option>
																<option value="unmarried">Unmarried</option>
																<option value="married">Married</option>
															</select>
															</div>
		                                                </td>
		                                                <td>Maker By</td>	
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>	                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="nationality">Nationality</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" name="nationality" type="text" placeholder="Enter Nationality" value="${crew.lName}" /></div></td>
		                                                <td>Maker By</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>		                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="rankId">Rank</label></td>
		                                                <td><div class="col-md-8 mb-3">
			                                                <select class="form-select" name="rankId" aria-label="Default select example">
																<option selected disabled>Select a Rank:</option>
																<c:forEach var="optionGroup" items="${rankMap}">
															       <optgroup label="${optionGroup.key}">
															       <c:forEach var="option" items="${optionGroup.value}">
															          <option value="${option.id}">${option.name} (${option.rankSubCategory.name})</option>                             
															       </c:forEach>                                                          
															       </optgroup>
															    </c:forEach>
															</select>
															</div>
		                                                </td>
		                                                <td>Maker By</td>	
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>	                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="gender">Gender</label></td>
		                                                <td><div class="col-md-8 mb-3">
			                                                <select class="form-select" name="gender" aria-label="Default select example">
																<option selected disabled>Gender:</option>
																<option value="male">Male</option>
																<option value="female">Female</option>
															</select>
															</div>
		                                                </td>
		                                                <td>Maker By</td>	
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>	                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="manningOffice">Manning Office</label></td>
		                                                <td><div class="col-md-8 mb-3">
			                                                <select class="form-select" name="manningOffice" aria-label="Default select example">
																<option selected disabled>Select Office:</option>
																<c:forEach var="manningOffice" items="${manningOffices}">
															          <option value="${manningOffice.id}">${manningOffice.name} (${manningOffice.name})</option>                             
															    </c:forEach>
															</select>
															</div>
		                                                </td>
		                                                <td>Maker By</td>	
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>	                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="distinguishingMark">Distinguishing Mark</label></td>
		                                                <td>
															<textarea name="distinguishingMark" class="lh-base form-control" placeholder="" rows="3" cols="3"></textarea>
		                                                </td>
		                                                <td>Maker By</td>	
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>	                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="homeAddress">Home Address</label></td>
		                                                <td>
															<textarea name="homeAddress" class="lh-base form-control" placeholder="" rows="3" cols="3"></textarea>
		                                                </td>
		                                                <td>Maker By</td>	
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>	                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="nearestAirport">Nearest Airport</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" name="nearestAirport" type="text" placeholder="Enter Nearest Airport" value="${crew.lName}" /></div></td>
		                                                <td>Maker By</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>		                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="emailId">Email Address</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" name="emailId" type="text" placeholder="Enter Email ID" value="${crew.lName}" /></div></td>
		                                                <td>Maker By</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="emailId" type="checkbox" checked />
	                                                		</div>
                                                		</td>		                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="contact_1">Contact#1</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" name="contact_1" type="text" placeholder="Enter Contact Number#1" value="${crew.lName}" /></div></td>
		                                                <td>Maker By</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>		                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="contact_2">Contact#2</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" name="contact_2" type="text" placeholder="Enter Contact Number#2" value="${crew.lName}" /></div></td>
		                                                <td>Maker By</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
	                                                		</div>
                                                		</td>		                                                
		                                                <td><div class="page-header-icon"><i data-feather="user-plus"></i></div>
		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
														</td>
		                                            </tr>
		                                            <tr>
		                                                <td><label class="small mb-3" for="dob">Date of Birth</label></td>
		                                                <td><div class="col-md-10 mb-3"><input class="form-control" name="dob" type="text" placeholder="Enter DOB" value="${crew.lName}" /></div></td>
		                                                <td>Maker By</td>
		                                                <td>
			                                                <div class="form-check mb-3">
	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
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
                                <!-- Security preferences card-->
                                <div class="card mb-4">
                                    <div class="card-header">Audit Trail</div>
                                    <div class="card-body">
                                        <div class="timeline timeline-xs">
										<!-- Timeline Item 1-->
										<div class="timeline-item">
											<div class="timeline-item-marker">
												<div class="timeline-item-marker-text">27 min</div>
												<div class="timeline-item-marker-indicator bg-green"></div>
											</div>
											<div class="timeline-item-content">
												New order placed! <a class="fw-bold text-dark" href="#!">Order
													#2912</a> has been successfully placed.
											</div>
										</div>
										<!-- Timeline Item 2-->
										<div class="timeline-item">
											<div class="timeline-item-marker">
												<div class="timeline-item-marker-text">58 min</div>
												<div class="timeline-item-marker-indicator bg-blue"></div>
											</div>
											<div class="timeline-item-content">
												Your <a class="fw-bold text-dark" href="#!">weekly
													report</a> has been generated and is ready to view.
											</div>
										</div>
										<!-- Timeline Item 3-->
										<div class="timeline-item">
											<div class="timeline-item-marker">
												<div class="timeline-item-marker-text">2 hrs</div>
												<div class="timeline-item-marker-indicator bg-purple"></div>
											</div>
											<div class="timeline-item-content">
												New user <a class="fw-bold text-dark" href="#!">Valerie
													Luna</a> has registered
											</div>
										</div>
										<!-- Timeline Item 4-->
										<div class="timeline-item">
											<div class="timeline-item-marker">
												<div class="timeline-item-marker-text">1 day</div>
												<div class="timeline-item-marker-indicator bg-yellow"></div>
											</div>
											<div class="timeline-item-content">Server activity
												monitor alert</div>
										</div>
										<!-- Timeline Item 5-->
										<div class="timeline-item">
											<div class="timeline-item-marker">
												<div class="timeline-item-marker-text">1 day</div>
												<div class="timeline-item-marker-indicator bg-green"></div>
											</div>
											<div class="timeline-item-content">
												New order placed! <a class="fw-bold text-dark" href="#!">Order
													#2911</a> has been successfully placed.
											</div>
										</div>
										<!-- Timeline Item 6-->
										<div class="timeline-item">
											<div class="timeline-item-marker">
												<div class="timeline-item-marker-text">1 day</div>
												<div class="timeline-item-marker-indicator bg-purple"></div>
											</div>
											<div class="timeline-item-content">
												Details for <a class="fw-bold text-dark" href="#!">Marketing
													and Planning Meeting</a> have been updated.
											</div>
										</div>
										<!-- Timeline Item 7-->
										<div class="timeline-item">
											<div class="timeline-item-marker">
												<div class="timeline-item-marker-text">2 days</div>
												<div class="timeline-item-marker-indicator bg-green"></div>
											</div>
											<div class="timeline-item-content">
												New order placed! <a class="fw-bold text-dark" href="#!">Order
													#2910</a> has been successfully placed.
											</div>
										</div>
									</div>
                                        
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
