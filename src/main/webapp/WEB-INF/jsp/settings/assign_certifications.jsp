<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Add New Certification</title>

<%@ include file="../includes/header_includes.jsp"%>
</head>

<body class="nav-fixed">
	<%@ include file="../includes/top_nav_bar.jsp"%>


	<div id="layoutSidenav">

		<%@ include file="../includes/sidebar.jsp"%>

		<div id="layoutSidenav_content">
			<main>
				<form method="POST" enctype="multipart/form-data" action="/settings/add_certification">
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
										Assign Certification Requirements to [${rank.name}]
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
	                        <a class="nav-link active ms-0">Certifications</a>
							<a class="nav-link" href="/settings/assign_licenses?rankId=${rank.id}">Licenses</a>
							<a class="nav-link" href="/settings/assign_surveys?rankId=${rank.id}">Surveys</a>
							<a class="nav-link" href="/settings/assign_medicals?rankId=${rank.id}">Medical Tests</a> 
							<a class="nav-link" href="/settings/assign_documents?rankId=${rank.id}">Documents</a>
                        </nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">
                            <div class="col-lg-8">
                                <!-- Email notifications preferences card-->
                                <div class="card card-header-actions mb-4">
                                    <div class="card-header">
                                        Add New Certification                                        
                                    </div>
                                    <div class="card-body">                                        
                                            <div class="row gx-3 mb-3">
											<div class="row gx-3 mb-3">
												<div class="col-md-8">
													<label class="small mb-1" for="certName">Certification Name</label> 
													<input class="form-control" name="certName"
														type="text" placeholder="Enter certification name" value="" />
												</div>
											</div>
											<div class="row gx-3 mb-3">
												<div class="col-md-8">
													<label class="small mb-1" for="certDesc">Certification Description</label>
													<textarea name="certDesc" class="lh-base form-control"
														type="text" placeholder="" rows="4"></textarea>
												</div>
											</div>
											<!-- <div class="row gx-3 mb-3">
												<div class="form-check">
													<input class="form-check-input" id="radioRequiresCert"
														type="radio" name="radioReqCert" checked /> <label
														class="form-check-label" for="radioRequiresCert">Requires
														Certification</label>
												</div>
												<div class="form-check">
													<input class="form-check-input" id="radioRequiresNoCert"
														type="radio" name="radioReqCert" /> <label
														class="form-check-label" for="radioRequiresNoCert">Does
														not require Certification</label>
												</div>
											</div> -->
											 <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="certDuration">Certification Duration</label> 
                                                    <input class="form-control" name="certDuration" type="text" placeholder="Enter certification duration" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="mName">Duration Type</label>
                                                    <select class="form-select" name="durationTypeId" aria-label="Default select example">
															<option selected disabled>Select Duration Type</option>
															<c:forEach var="durationType" items="${durationTypes}">
																<option value="${durationType.id }">${durationType.typeName}</option>
															</c:forEach>
														</select>
                                                </div>
                                            </div>                                          
											<div class="row gx-3 mb-3">
												<div class="form-check mb-2">
                                                    <input class="form-check-input" id="checkRequiresCert" type="checkbox" checked />
                                                    <label class="form-check-label" for="checkRequiresCert">Requires Certification</label><i class="text-muted" data-feather="info"
													data-bs-toggle="tooltip" data-bs-placement="left"
													title="The post preview text shows below the post title, and is the post summary on blog pages."></i>
                                                </div>
                                                <div class="form-check mb-2">
                                                    <input class="form-check-input" id="checkAccountGroups" type="checkbox" checked />
                                                    <label class="form-check-label" for="checkAccountGroups">Requires Physical Training</label><i class="text-muted" data-feather="info"
													data-bs-toggle="tooltip" data-bs-placement="left"
													title="The post preview text shows below the post title, and is the post summary on blog pages."></i>
                                                </div>
                                                <div class="form-check mb-2">
                                                    <input class="form-check-input" id="checkProductUpdates" type="checkbox" checked />
                                                    <label class="form-check-label" for="checkProductUpdates">Paid Certification</label><i class="text-muted" data-feather="info"
													data-bs-toggle="tooltip" data-bs-placement="left"
													title="The post preview text shows below the post title, and is the post summary on blog pages."></i>
                                                </div>
                                                <div class="form-check mb-2">
                                                    <input class="form-check-input" id="checkProductNew" type="checkbox" checked />
                                                    <label class="form-check-label" for="checkProductNew">Company sponsored</label><i class="text-muted" data-feather="info"
													data-bs-toggle="tooltip" data-bs-placement="left"
													title="The post preview text shows below the post title, and is the post summary on blog pages."></i>
                                                </div>
                                                <div class="form-check mb-2">
                                                    <input class="form-check-input" id="checkPromotional" type="checkbox" />
                                                    <label class="form-check-label" for="checkPromotional">The course involves handling of hazardous equipments, study tours ashore and offshore and adventure trips</label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" id="checkSecurity" type="checkbox" checked disabled />
                                                    <label class="form-check-label" for="checkSecurity">Requires Medical Fitness Certificate</label>
                                                </div>
											</div>
										</div>
										
										<div class="row gx-3 mb-3">
												<div class="col-md-8">
													<label class="small mb-1" for="papPoints">PAP
														<i class="text-muted" data-feather="info"
														data-bs-toggle="tooltip" data-bs-placement="left"
														title="Professional Attitude Points"></i>
													</label> 
													
													<input class="form-control" name="papPoints" type="text" placeholder="Enter PAP points" value="" />
												</div>
											</div>
										<!-- Save changes button-->
										<button class="btn btn-primary" type="submit">Add</button>
                                        </form>
                                    </div>
                                </div>                                
                            </div>
                            <div class="col-lg-4">
                                <!-- Notifications preferences card-->
                                <div class="card">
                                    <div class="card-header">For Rank</div>
                                    <div class="card-body">                                        
                                            <!-- Form Group (notification preference checkboxes)-->
											<div class="mb-3">
												<label class="small mb-1" for="rankCategoryId">Rank
													Category</label> <select class="form-select" name="rankCategoryId"
													aria-label="Default select example">
													<option selected disabled>Select a Rank Category:</option>
													<option
														<c:if test="${rank.rankCategory.id==1}">selected</c:if>
														value="1">Deck Department</option>
													<option
														<c:if test="${rank.rankCategory.id==2}">selected</c:if>
														value="2">Engine Department</option>
													<option
														<c:if test="${rank.rankCategory.id==3}">selected</c:if>
														value="3">Galley Department</option>
												</select>
											</div>
											<!-- Form Group (new password)-->
											<div class="mb-3">
												<label class="small mb-1" for="rankSubCategoryId">Rank
													Sub-Category</label> 
													<select class="form-select"
													name="rankSubCategoryId" aria-label="Default select example">
													<option selected disabled>Select a Rank
														Sub-Category:</option>
													<option
														<c:if test="${rank.rankSubCategory.id==1}">selected</c:if>
														value="1">Officers</option>
													<option
														<c:if test="${rank.rankSubCategory.id==2}">selected</c:if>
														value="2">Ratings</option>
													<option
														<c:if test="${rank.rankSubCategory.id==3}">selected</c:if>
														value="3">Engineers</option>
													<option
														<c:if test="${rank.rankSubCategory.id==0}">selected</c:if>
														value="0">Other</option>
												</select>
											</div>
											<div class="mb-3">
												<label class="small mb-1" for="rankSubCategoryId">Rank</label>
												<select class="form-select" name="rankId"
													aria-label="Default select example">
													<option selected disabled>Select a Rank:</option>
													<option value="0">All</option>
													<c:forEach var="optionGroup" items="${rankMap}">
												       <optgroup label="${optionGroup.key}">
												       <c:forEach var="option" items="${optionGroup.value}">
												          <option <c:if test="${rank.id==option.id}">selected</c:if> value="${option.id}">${option.name} (${option.rankSubCategory.name})</option>                             
												       </c:forEach>                                                          
												       </optgroup>
												    </c:forEach>
												</select>
											</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </form>                    
			</main>

			<%@ include file="../includes/copyright.jsp"%>

		</div>
	</div>

	<%@ include file="../includes/bottom_includes.jsp"%>

</body>
</html>
