<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Rank</title>
    
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
											Add New Rank
										</h1>
									</div>
									<div class="col-12 col-xl-auto mb-3">
										<a class="btn btn-sm btn-light text-primary"
											href="/crew/crew_list"> <i class="me-1"
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
                            <a class="nav-link" href="/settings/rank_category">Rank Category</a>
                            <a class="nav-link" href="/settings/rank_sub_category">Rank Sub-Category</a>
                            <a class="nav-link active ms-0">Rank</a>                            
                        </nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">                            
                            <div class="col-xl-12">
                                <!-- Account details card-->
                                <div class="card mb-6">
                                    <div class="card-header">Add Rank</div>
                                    <div class="card-body">
                                        <form action="/settings/add_rank" method="POST">
                                           
										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												<label class="small mb-1" for="rankCategoryId">Rank Category</label>
												<select class="form-select" name="rankCategoryId" aria-label="Default select example">
													<option selected disabled>Select a Rank Category:</option>
													<option value="1">Deck Department</option>
													<option value="2">Engine Department</option>
													<option value="3">Galley Department</option>
												</select>
											</div>
											<div class="col-md-4">
												<label class="small mb-1" for="rankSubCategoryId">Rank Sub-Category</label>
												<select class="form-select" name="rankSubCategoryId" aria-label="Default select example">
													<option selected disabled>Select a Rank Sub-Category:</option>
													<option value="1">Officers</option>
													<option value="2">Ratings</option>
													<option value="3">Engineers</option>
													<option value="0">Other</option>
												</select>
											</div>
											 <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="rankName">Rank Name</label>
                                                    <input class="form-control" name="rankName" type="text" placeholder="Enter rank name" value="" />
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
