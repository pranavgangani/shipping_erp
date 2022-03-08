<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Crew List</title>

<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<%@ include file="../includes/header_includes.jsp"%>

</head>
<body class="nav-fixed">
	<%@ include file="../includes/top_nav_bar.jsp"%>
	<div id="layoutSidenav">
		<%@ include file="../includes/sidebar.jsp"%>
		<div id="layoutSidenav_content">
			<header
				class="page-header page-header-compact page-header-light border-bottom bg-white mb-4">

				<div class="card card-collapsable">
					<a class="card-header" href="#collapseCardExample"
						data-bs-toggle="collapse" role="button" aria-expanded="false"
						aria-controls="collapseCardExample">Filter Criteria
						<div class="card-collapsable-arrow">
							<i class="fas fa-chevron-down"></i>
						</div>
					</a>
					<div class="collapse show" id="collapseCardExample">
						<div class="card-body">
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body text-left">
									<div class="row gx-3 mb-3">
										<div class="col-md-4">
											<label class="small mb-1" for="inputFirstName">Crew Name</label> 
											<input class="form-control" id="inputFirstName"
												type="text" placeholder="Enter first name" value="" />
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="inputGender">Gender</label> 
											<select class="form-select"
												aria-label="Default select example">
												<option selected disabled>Select a Gender:</option>
												<option value="male">Male</option>
												<option value="female">Female</option>
											</select>
										</div>
										<!-- Form Group (last name)-->
										<div class="col-md-4">
											<label class="small mb-1" for="inputLastName">Rank</label> 
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
									</div>
									<div class="row gx-3 mb-3">
										<div class="col-md-2">
											<label class="small mb-1" for="inputPassport">Passport Number</label> 
											<input class="form-control" id="inputPassport"
												type="text" placeholder="Enter Passport Number" value="" />
										</div>
										<div class="col-md-2">
											<label class="small mb-1" for="inputVisa">Visa Number</label> 
											<input class="form-control" id="inputVisa"
												type="text" placeholder="Enter Visa Number" value="" />
										</div>
										<div class="col-md-4">
											<label class="small mb-1" for="inputManOffice">Manning Office</label> 
											<select class="form-select"
												aria-label="Default select example">
												<option selected disabled>Select a Manning Office:</option>
												<option value="1">Mumbai</option>
												<option value="2">Chennai</option>
											</select>
										</div>
										<!-- Form Group (last name)-->
										<div class="col-md-4">
											<label class="small mb-1" for="inputLastName">Crew Status</label> 
											<select class="form-select"
												aria-label="Default select example">
												<option selected disabled>Select a Status:</option>
												<option value="1">Pending</option>
												<option value="2">Joining</option>
												<option value="3">Bla Bla</option>
											</select>
										</div>
									</div>
									<div class="row gx-3 mb-3">
										<div class="col-md-4">
											<a href="#" class="btn btn-primary btn-icon-split"> <span
												class="text">Filter</span>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</header>
			<main>

				<!-- Main page content-->
				<div class="container-fluid px-4">
					<div class="card mb-4">
						<div class="card-header">Crew List</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>Name</th>
                                        <th>Position</th>
                                        <th>Department</th>
                                        <th>Manning Office</th>
                                        <th>Age</th>
                                        <th>Start date</th>
                                        <th>Wage</th>
                                        <th>Status</th>
                                        <th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Name</th>
										<th>Position</th>
										<th>Department</th>
										<th>Manning Office</th>
										<th>Age</th>
										<th>Start date</th>
										<th>Wage</th>
										<th>Status</th>
										<th>Actions</th>
									</tr>
								</tfoot>
								<tbody>
								
								<c:forEach items="${list}" var="crew">
								    <tr>
										<td>${crew.fName} ${crew.mName} ${crew.lName}</td>
										<td>${crew.rank.name}</td>
										<td>${crew.rank.rankCategory.name}</td>										
										<td>${crew.rank.rankCategory.name}</td>
										<td>${crew.age}</td>
										<td>2011/04/25</td>
										<td>$320,800</td>
										<td>

										<div class="badge bg-primary text-white rounded-pill">Full-time</div></td>
										<td>
										    <button
													class="btn btn-datatable btn-icon btn-transparent-dark me-2"
													id="dropdownMenuButton" type="button"
													data-bs-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i data-feather="more-vertical"></i>
												</button>
											<div class="dropdown-menu">
													<a class="dropdown-item" href="/crew/add_certifications?crewId=${crew.id}">
														<div class="dropdown-item-icon">
															<i data-feather="user"></i>
														</div> Add Certifications
													</a>
													<a class="dropdown-item" href="/crew/add_medicals?crewId=${crew.id}">
														<div class="dropdown-item-icon">
															<i data-feather="settings"></i>
														</div> Add Medical Tests
													</a>													
													<a class="dropdown-item" href="/crew/add_licenses?crewId=${crew.id}">
														<div class="dropdown-item-icon">
															<i data-feather="settings"></i>
														</div> Add Licenses
													</a>
													<a class="dropdown-item" href="/crew/document_list?crewId=${crew.id}">
														<div class="dropdown-item-icon">
															<i data-feather="settings"></i>
														</div> Add Documents
													</a>													
													<div class="dropdown-divider"></div>
													<a class="dropdown-item" href="/crew/edit?crewId=${crew.id}">
														<div class="dropdown-item-icon">
															<i data-feather="log-out"></i>
														</div> Edit
													</a>
													<div class="dropdown-divider"></div>
													<a class="dropdown-item" href="/crew/vacancy_list?crewId=${crew.id}">
														<div class="dropdown-item-icon">
															<i data-feather="log-out"></i>
														</div> Sign-On/Sign-Off
													</a>
												</div>
												<button
												class="btn btn-datatable btn-icon btn-transparent-dark">
												<i data-feather="trash-2"></i>
											</button>
										</td>
									</tr>
								</c:forEach>
									
									
								</tbody>
							</table>
						</div>
					</div>

				</div>
			</main>
			<%@ include file="../includes/copyright.jsp"%>
		</div>

		<%@ include file="../includes/bottom_includes.jsp"%>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="../js/datatables/datatables-simple-demo.js"></script>
</body>
</html>
