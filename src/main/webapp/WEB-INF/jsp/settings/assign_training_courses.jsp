<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
											Assign Requirements to [${rank.name}]
										</h1>
									</div>
									<div class="col-12 col-xl-auto mb-3">
										<a class="btn btn-sm btn-light text-primary"
											href="/settings/ranks"> <i class="me-1"
											data-feather="arrow-left"></i> Go to Rank List
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
                            <a class="nav-link active ms-0" href="/settings/rank_category">Training</a>
                            <a class="nav-link" href="/settings/rank_sub_category">Courses</a>
                            <a class="nav-link" href="/settings/rank_sub_category">Licenses</a>
                            <a class="nav-link" href="/settings/rank_sub_category">Surveys</a>
                            <a class="nav-link" href="/settings/rank_sub_category">Medical Tests</a>
                            <a class="nav-link" href="/settings/rank_sub_category">Documents</a>                                                       
                        </nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">                            
                            <div class="col-xl-12">
                            <!-- Change password card-->
                                <div class="card mb-4">
                                    <div class="card-header">Assigning to Rank</div>
                                    <div class="card-body">
                                        <form>
                                            <!-- Form Group (current password)-->
                                            <div class="mb-3">
                                                <label class="small mb-1" for="rankCategoryId">Rank Category</label>
												<select class="form-select" name="rankCategoryId" aria-label="Default select example">
													<option selected disabled>Select a Rank Category:</option>
													<option <c:if test="${rank.rankCategoryId==1}">selected</c:if> value="1">Deck Department</option>
													<option <c:if test="${rank.rankCategoryId==2}">selected</c:if> value="2">Engine Department</option>
													<option <c:if test="${rank.rankCategoryId==3}">selected</c:if> value="3">Galley Department</option>
												</select>
                                            </div>
                                            <!-- Form Group (new password)-->
                                            <div class="mb-3">
                                               <label class="small mb-1" for="rankSubCategoryId">Rank Sub-Category</label>
												<select class="form-select" name="rankSubCategoryId" aria-label="Default select example">
													<option selected disabled>Select a Rank Sub-Category:</option>													
													<option <c:if test="${rank.rankSubCategoryId==1}">selected</c:if> value="1">Officers</option>
													<option <c:if test="${rank.rankSubCategoryId==2}">selected</c:if> value="2">Ratings</option>
													<option <c:if test="${rank.rankSubCategoryId==3}">selected</c:if> value="3">Engineers</option>
													<option <c:if test="${rank.rankSubCategoryId==0}">selected</c:if> value="0">Other</option>
												</select>
                                            </div>                                                                                        
                                            <div class="mb-3">
                                               <label class="small mb-1" for="rankSubCategoryId">Rank</label>
												<select class="form-select" name="rankId" aria-label="Default select example">
													<option selected disabled>Select a Rank:</option>
													<option value="0">All</option>
													<c:forEach items="${list}" var="r">
														<option <c:if test="${rank.id==r.id}">selected</c:if> value="${r.id}">${r.name}</option>
													</c:forEach>
												</select>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                
                                <!-- Account details card-->
                                <div class="card mb-6">
                                    <div class="card-header">Add Training</div>
                                    <div class="card-body">
                                        <form action="/settings/add_training_courses" method="POST">
                                           
										<div class="row gx-3 mb-3">																			
											 <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="trainingName">Training Name</label>
                                                    <input class="form-control" name="trainingName" type="text" placeholder="Enter training name" value="" />
                                                </div>                                                
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="trainingDesc">Training Description</label>
                                                    <textarea name="trainingDesc" class="lh-base form-control" type="text"
													placeholder="" rows="4"></textarea>
                                                </div>                                                
                                            </div>		
                                            <div class="row gx-3 mb-3">
                                            <div class="form-check">
                                                <input class="form-check-input" id="radioRequiresCert" type="radio" name="radioReqCert" checked />
                                                <label class="form-check-label" for="radioRequiresCert">Requires Certification</label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" id="radioRequiresNoCert" type="radio" name="radioReqCert" />
                                                <label class="form-check-label" for="radioRequiresNoCert">Does not require Certification</label>
                                            </div>	
                                             </div> 									
										</div>										
										<!-- Save changes button-->
                                            <button class="btn btn-primary" type="submit">Add</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
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
