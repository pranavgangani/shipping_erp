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
                <header class="page-header page-header-compact page-header-light border-bottom bg-white mb-4">
                        <div class="container-xl px-4">
                            <div class="page-header-content">
                                <div class="row align-items-center justify-content-between pt-3">
                                    <div class="col-auto mb-3">
                                        <h1 class="page-header-title">
                                            <div class="page-header-icon"><i data-feather="user-plus"></i></div>
                                            Add Bank Account
                                        </h1>
                                    </div>
                                    <div class="col-12 col-xl-auto mb-3">
                                        <a class="btn btn-sm btn-light text-primary" href="user-management-list.html">
                                            <i class="me-1" data-feather="arrow-left"></i>
                                            Back to Users List
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </header>
                    
                    <!-- Main page content-->
                    <div class="container-xl px-4 mt-4">
                        <!-- Account page navigation-->
                        <nav class="nav nav-borders">
                            <a class="nav-link" href="/crew/add_crew">Profile</a>
                            <a class="nav-link" href="/crew/add_employment">Employment</a>
                            <a class="nav-link" href="/crew/add_education">Education</a>
                            <a class="nav-link" href="/crew/add_passport_visa">Passport/Visa</a>
                            <a class="nav-link" href="/crew/add_medical">Medical</a>
                            <a class="nav-link active ms-0" href="/crew/add_bank_account">Bank Account</a>
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
                                        <img class="img-account-profile rounded-circle mb-2" src="../assets/img/illustrations/profiles/profile-1.png" alt="" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-10">
                                <!-- Account details card-->
                                <div class="card mb-6">
                                    <div class="card-header">Add Bank Account</div>
                                    <div class="card-body">
                                        <form>
                                            <div class="row gx-3 mb-3">
                                                <!-- Form Group (first name)-->
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="inputFirstName">First name</label>
                                                    <input class="form-control" id="inputFirstName" type="text" placeholder="Enter first name" value="" />
                                                </div>
                                                <!-- Form Group (middle name)-->
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="inputMiddleName">Middle name</label>
                                                    <input class="form-control" id="inputMiddleName" type="text" placeholder="Enter middle name" value="" />
                                                </div>
                                                <!-- Form Group (last name)-->
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="inputLastName">Last name</label>
                                                    <input class="form-control" id="inputLastName" type="text" placeholder="Enter last name" value="" />
                                                </div>
                                            </div>
										<div class="row gx-3 mb-3">
											<!-- Form Group (first name)-->
											<div class="col-md-4">
												<label class="small mb-1" for="inputFirstName">Rank</label>
												<select class="form-select"
													aria-label="Default select example">
													<option selected disabled>Select a Rank:</option>
													<option value="1">Captain/Master</option>
													<option value="2">Chief Officer</option>
													<option value="3">Second Officer</option>
													<option value="4">Third Officer</option>
													<option value="5">Deck Cadet (Trainee Officer)</option>
													<option value="6">Bosun</option>
												</select>
											</div>
											<!-- Form Group (gender)-->
											<div class="col-md-4">
												<label class="small mb-1" for="inputMiddleName">Gender</label>
												<div class="form-check">
													<input class="form-check-input" id="male" type="radio"
														name="gender" checked /> <label class="form-check-label"
														for="male">Male</label>
												</div>
												<div class="form-check">
													<input class="form-check-input" id="female" type="radio"
														name="gender" /> <label class="form-check-label"
														for="female">Female</label>
												</div>
											</div>
											<div class="col-md-4">
												<label class="small mb-1" for="inputManningOffice">Manning
													Office</label> <input class="form-control" id="inputManningOffice"
													type="text" placeholder="Enter Office" value="" />
											</div>
										</div>
										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												Distinguishing Mark <i class="text-muted" data-feather="info"
													data-bs-toggle="tooltip" data-bs-placement="left"
													title="The post preview text shows below the post title, and is the post summary on blog pages."></i>
												<textarea class="lh-base form-control" type="text"
													placeholder="" rows="4"></textarea>
											</div>
											<div class="col-md-4">
												<label class="small mb-1" for="inputFirstName">Crew Status</label>
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
                                            <button class="btn btn-primary" type="button">Next</button>
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
</html>
