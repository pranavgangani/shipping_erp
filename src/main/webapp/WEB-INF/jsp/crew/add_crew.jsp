<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Crew</title>
    
        <%@ include file="../includes/header_includes.jsp" %>
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
                            <a class="nav-link active ms-0" href="/crew/add_crew">Profile</a>
                            <a class="nav-link" href="/crew/add_employment">Employment</a>
                            <a class="nav-link" href="/crew/add_education">Education</a>
                            <a class="nav-link" href="/crew/add_passport_visa">Passport/Visa</a>
                            <a class="nav-link" href="/crew/add_medical">Medical</a>
                            <a class="nav-link" href="/crew/add_bank_account">Bank Account</a>
                            <a class="nav-link" href="/crew/add_nominee">Nominee</a>
                            <a class="nav-link" href="/crew/add_other_docs">Other Documents</a>
                        </nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">
                            <div class="col-xl-2">
                                <!-- Profile picture card-->
                                <div class="card mb-2 mb-xl-0">
                                    <div class="card-header">Profile Picture</div>
                                    <div class="card-body text-center">
										<!-- Profile picture image-->
										<input type='file' id='file-input' hidden name="image">																																	
										<div id='container'>
											<!-- Profile picture help block-->
											<c:choose>
												<c:when test="${crew.photoId>0}">
													<img class="img-account-profile rounded-circle mb-2" alt="img" src="data:image/jpeg;base64,${image}" alt="" id='preview' />													
												</c:when>
												<c:otherwise>
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
                                </div>
                            </div>
                            <div class="col-xl-10">
                                <!-- Account details card-->
                                <div class="card mb-6">
                                    <div class="card-header">Add Profile</div>
                                    <div class="card-body">
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="fName">First name</label>
                                                    <input class="form-control" name="fName" type="text" placeholder="Enter first name" value="${crew.fName}" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="mName">Middle name</label>
                                                    <input class="form-control" name="mName" type="text" placeholder="Enter middle name" value="${crew.mName}" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="lName">Last name</label>
                                                    <input class="form-control" name="lName" type="text" placeholder="Enter last name" value="${crew.lName}" />
                                                </div>
                                            </div>
										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												<label class="small mb-1" for="rank">Rank</label>
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
											<div class="col-md-4">
												<label class="small mb-1" for="gender">Gender</label>
												<div class="form-check">
													<input class="form-check-input" id="male" value="male" type="radio" name="gender" checked /> <label class="form-check-label"
														for="male">Male</label>
												</div>
												<div class="form-check">
													<input class="form-check-input" id="female" value="female" type="radio" name="gender" /> <label class="form-check-label"
														for="female">Female</label>
												</div>
											</div>
											<div class="col-md-4">
												<label class="small mb-1" for="manningOffice">Manning Office</label> 
												<input class="form-control" name="manningOffice" type="text" placeholder="Enter Office" value="" />
											</div>
										</div>
										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												Distinguishing Mark
												<textarea name="distinguishMark" class="lh-base form-control" type="text"
													placeholder="" rows="4"></textarea>
											</div>
											<div class="col-md-4">
												<label class="small mb-1" for="crewStatusId">Crew Status</label>
												<select class="form-select"
													aria-label="Default select example">
													<option selected disabled>Select a Status:</option>
													<option value="1">Awaiting Joining</option>
													<option value="2">Pending</option>
													<option value="3">Bla Bla</option>
												</select>
											</div>
										</div>
										<!-- Save changes button-->
                                            <button class="btn btn-primary" type="submit">Next</button>
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
