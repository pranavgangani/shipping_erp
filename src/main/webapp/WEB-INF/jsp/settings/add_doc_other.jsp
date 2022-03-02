<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Briefing/Declaration</title>
    
        <%@ include file="../includes/header_includes.jsp" %>
    </head>

    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>
       
       
        <div id="layoutSidenav">
        
        <%@ include file="../includes/sidebar.jsp" %>
            
            <div id="layoutSidenav_content">
                <main>
				<form action="/settings/add_document" method="POST">
					<header
						class="page-header page-header-compact page-header-light border-bottom bg-white mb-4">
						<div class="container-fluid px-4">
							<div class="page-header-content">
								<div class="row align-items-center justify-content-between pt-3">
									<div class="col-auto mb-3">
										<h1 class="page-header-title">
											<div class="page-header-icon">
												<i data-feather="user-plus"></i>
											</div>
											Add New Document
										</h1>
									</div>
									<div class="col-12 col-xl-auto mb-3">
										<a class="btn btn-sm btn-light text-primary"
											href="/crew/crew_list"> <i class="me-1"
											data-feather="arrow-left"></i> Go to Document List
										</a>
									</div>
								</div>
							</div>
						</div>
					</header>


					<!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation-->
                        <nav class="nav nav-borders">
						  <a class="nav-link" href="/settings/add_doc_certification">Training & Courses</a>
						    <a class="nav-link" href="/settings/add_doc_license">License</a>
						    <a class="nav-link" href="/settings/add_doc_declaration">Briefing & Declaration</a>
						    <a class="nav-link" href="/settings/add_doc_passport">Passport</a>
						    <a class="nav-link" href="/settings/add_doc_visa">Visa</a>
						    <a class="nav-link" href="/settings/add_doc_medical">Medical</a>
						    <a class="nav-link active ms-0" href="/settings/add_doc_other">Other</a>                         
						</nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">                            
                            <div class="col-xl-12">
                                <!-- Account details card-->
                                <div class="card mb-6">
                                    <div class="card-header">Add Document</div>
									<div class="card-body">

										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												<label class="small mb-1" for="vesselType">Vessel
													Type</label> <select class="form-select"
													aria-label="Default select example" name="vesselType">
													<option value="0" selected>All</option>
													<c:forEach var="vesselType" items="${vesselTypeList}">
														<option value="${vesselType.id}">${vesselType.desc}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												<label class="small mb-1" for="vesselSubType">Vessel
													Sub Type</label> <select class="form-select"
													aria-label="Default select example" name="vesselSubType">
													<option value="0" selected>All</option>
													<c:forEach var="vesselSubType" items="${vesselSubTypeList}">
														<option value="${vesselSubType.id}">${vesselSubType.desc}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="rankCategory">Rank
												Category Type</label> <select class="form-select"
												aria-label="Default select example" name="rankCategory">
												<option value="0" selected>All</option>
												<c:forEach var="rankCategory" items="${rankCategoryList}">
													<option value="${rankCategory.id}">${rankCategory.name}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="rankSubCategory">Rank
												Sub-Category</label> <select class="form-select"
												name="rankSubCategory" aria-label="Default select example">
												<option value="0" selected>All</option>
												<c:forEach var="rankSubCategory"
													items="${rankSubCategoryList}">
													<option value="${rankSubCategory.id}">${rankSubCategory.name}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="rankSubCategory">Rank</label>
											<select class="form-select" name="rankSubCategory"
												aria-label="Default select example">
												<option value="0" selected>All</option>
												<c:forEach var="rank" items="${rankList}">
													<option value="${rank.id}">${rank.name}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="documentName">Document
												Name</label> <input class="form-control" name="documentName"
												type="text" placeholder="Enter Document Name" value="" />
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="documentType">Training/Course/License/Other</label>
											<select class="form-select" name="documentType"
												aria-label="Default select example">
												<option value="training">Training/Course</option>
												<option value="license">License</option>
												<option value="briefing">Briefing</option>
												<option value="declaration">Declaration</option>
												<option value="passport">Passport</option>
												<option value="visa">Visa</option>
												<option value="contract">Contract</option>
												<option value="medical">Medical</option>
												<option value="other">Other</option>
											</select>
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="isMandatory">Is
												Mandatory?</label> <select class="form-select" name="isMandatory"
												aria-label="Default select example">
												<option value="yes">Yes</option>
												<option value="no">No</option>
											</select>
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="issuingCountry">Issuing
												Country</label> <input class="form-control" name="issuingCountry"
												type="text" placeholder="Enter Issuing Country" value="" />
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="issuingDate">Issuing
												Date</label> <input class="form-control" name="issuingDate"
												type="text" placeholder="Enter Issuing Date" value="" />
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="expiriyDate">Expiry
												Date</label> <input class="form-control" name="expiriyDate"
												type="text" placeholder="Enter Expiry Date" value="" />
										</div>
									</div>
									<!-- Save changes button-->
									<button class="btn btn-primary" type="submit">Add</button>
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
