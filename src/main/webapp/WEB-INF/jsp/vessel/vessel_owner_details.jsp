<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Vessel Owner</title>
    
        <%@ include file="../includes/header_includes.jsp" %>
        <script src="../js/vessel/vessel_details.js"></script>
    </head>
    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>
       
       
        <div id="layoutSidenav">
        
        <%@ include file="../includes/sidebar.jsp" %>
            
            <div id="layoutSidenav_content">
                <main>
                <form method="POST" enctype="multipart/form-data" action="/vessel/vessel_vacancy_details">
                <%@ include file="add_owner_header.jsp" %>
                     
                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation--> 
                        <nav class="nav nav-borders">
                            <a class="nav-link active ms-0">Profile</a>
                            <a class="nav-link" href="/vessel/vessel_details?action=list&vesselOwnerId=${vesselOwner.id}">Vessels</a>
                            <a class="nav-link" href="/vessel/document_list?action=view&vesselOwnerId=${vesselOwner.id}">Documents</a>
                        </nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">
                            <div class="col-xl-2">
                                <!-- Profile picture card-->
                                <div class="card mb-2 mb-xl-0">
                                    <div class="card-header">Vessel Owner Picture</div>
                                    <div class="card-body text-center">
										<!-- Profile picture image-->
										 <img class="img-account-profile rounded-circle mb-2"
											src="../assets/img/illustrations/profiles/logo-1.png"
											alt="" id='preview'/> 
											
											<input type='file' id='file-input' hidden name="image">																						
											
										<div id='container'>
											<!-- Profile picture help block-->
											<div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
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
                                        <form>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="ownerName">Vessel Owner Name</label>
                                                    <input class="form-control" id="ownerName" type="text" placeholder="Enter vessel owner name" value="${owner.ownerName}" name="ownerName" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="website">WebSite</label>
                                                    <input class="form-control" id="website" type="text" placeholder="Enter company website address" value="${owner.website}" name="website"/>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="emailId">EmailID</label>
                                                    <input class="form-control" id="emailId" type="text" placeholder="Enter company email ID" value="${owner.emailId}" name="emailId"/>
                                                </div>
                                            </div>
										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												<label class="small mb-1" for="primaryFlag">Primary Flag</label>
												<select class="form-select" aria-label="Default select example" name="primaryFlag">
													<option selected disabled>Select a Primary Flag:</option>
													<c:forEach items="${flags}" var="flag">
                                                        <option value="${flag.code}">${flag.name}</option>
                                                    </c:forEach>
												</select>
											</div>
											<div class="col-md-4">
												<label class="small mb-1" for="regFlag">Registered Flag</label>
												<select class="form-select" aria-label="Default select example" name="regFlag">
													<c:forEach items="${flags}" var="flag">
                                                        <option value="${flag.code}">${flag.name}</option>
                                                    </c:forEach>
												</select>
											</div>																						
										</div>
										<div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="length">Primary Contact</label>
                                                    <input class="form-control" id="length" type="text" placeholder="Enter Primary Contact" value="${owner.primaryContact}" name="primaryContact"/>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="beam">Secondary Contact</label>
                                                    <input class="form-control" id="beam" type="text" placeholder="Enter Secondary Contact" value="${owner.secondaryContact}" name="secondaryContact"/>
                                                </div>                                              
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="draught">Primary Address</label>
                                                    <textarea class="lh-base form-control" type="text" name="primaryAddr" placeholder="${owner.primaryAddress}" rows="4"></textarea>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="draught">Registered Address</label>
                                                    <textarea class="lh-base form-control" type="text" name="regAddr" placeholder="${owner.registerdAddress}" rows="4"></textarea>
                                                </div>                                                
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="yearOfStart">Year of Start</label>
                                                    <input class="form-control" id="yearOfStart" type="text" placeholder="Enter Operations Start Year" value="${owner.yearOfStart}" name="yearOfStart"/>
                                                </div>                                                
                                                
                                            </div>										
										<!-- Save changes button-->
                                            <button class="btn btn-primary" type="submit">Next</button>
                                        </form>
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
