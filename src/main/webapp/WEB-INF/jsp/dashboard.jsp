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
<title>ShipMon :: Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/litepicker/dist/css/litepicker.css"
	rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<link rel="icon" type="image/x-icon" href="assets/img/favicon.png" />
<script data-search-pseudo-elements defer
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.28.0/feather.min.js"
	crossorigin="anonymous"></script>


</head>
<body class="nav-fixed">
	<%@ include file="includes/top_nav_bar.jsp"%>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<%@ include file="includes/sidebar.jsp"%>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<header
					class="page-header page-header-dark bg-gradient-primary-to-secondary pb-10">
					<div class="container-xl px-4">
						<div class="page-header-content pt-4">
							<div class="row align-items-center justify-content-between">
								<div class="col-auto mt-4">
									<h1 class="page-header-title">
										<div class="page-header-icon">
											<i data-feather="activity"></i>
										</div>
										Dashboard
									</h1>
									<div class="page-header-subtitle">
										<i>ShipMon</i> dashboard overview and content summary
									</div>
								</div>
								<div class="col-12 col-xl-auto mt-4">
									<div class="input-group input-group-joined border-0"
										style="width: 16.5rem">
										<span class="input-group-text"><i class="text-primary"
											data-feather="calendar"></i></span> <input
											class="form-control ps-0 pointer" id="litepickerRangePlugin"
											placeholder="Select date range..." />
									</div>
								</div>
							</div>
						</div>
					</div>
				</header>
				<!-- Main page content-->
				<div class="container-xl px-4 mt-n10">
					<div class="row">
						<div class="col-xxl-4 col-xl-6 mb-4">
							<div class="card card-header-actions h-100">
									<div class="card-header">
										Crew Status
										<a href="#crewList"><button class="btn btn-sm btn-primary" type="button">Check Details</button></a>
									</div>
									<div class="card-body px-0">
										<div
											class="d-flex align-items-center justify-content-between px-4">
											<div class="d-flex align-items-center">
												<div class="ms-4">
													<div class="small">Documents Expiring</div>
													<div class="text-xs text-muted">Number of crews that have docs expiring in 6 months</div>
												</div>
											</div>
											<div class="ms-4 small">
												<div class="badge bg-red text-white me-3">10</div>
											</div>
										</div>
										<hr />
										<div
											class="d-flex align-items-center justify-content-between px-4">
											<div class="d-flex align-items-center">
												<div class="ms-4">
													<div class="small">Pending Review</div>
													<div class="text-xs text-muted">Number of crews that are Pending Review</div>
												</div>
											</div>
											<div class="ms-4 small">
												<div class="badge bg-orange text-white me-3">4</div>
											</div>
										</div>
										<hr />
										<div
												class="d-flex align-items-center justify-content-between px-4">
											<div class="d-flex align-items-center">
												<div class="ms-4">
													<div class="small">New Recruits</div>
													<div class="text-xs text-muted">Number of new recruits added</div>
												</div>
											</div>
											<div class="ms-4 small">
												<div class="badge bg-yellow text-white me-3">3</div>
											</div>
										</div>
										<hr />
										<div
											class="d-flex align-items-center justify-content-between px-4">
											<div class="d-flex align-items-center">
												<div class="ms-4">
													<div class="small">Ready for Sign-off</div>
													<div class="text-xs text-muted">Number of crews that are ready to sign-off</div>
												</div>
											</div>
											<div class="ms-4 small">
												<div class="badge bg-blue text-white me-3">3</div>
											</div>
										</div>
										<hr />
										<div
												class="d-flex align-items-center justify-content-between px-4">
											<div class="d-flex align-items-center">
												<div class="ms-4">
													<div class="small">Ready for Sign-on</div>
													<div class="text-xs text-muted">Number of crews that are ready to on-board</div>
												</div>
											</div>
											<div class="ms-4 small">
												<div class="badge bg-green text-white me-3">3</div>
											</div>
										</div>
									</div>
								
							</div>
						</div>
						<div class="col-xxl-4 col-xl-6 mb-4">
							<div class="card card-header-actions h-100">
								<div class="card-header">
									Recent Activity
									<div class="dropdown no-caret">
										<button
											class="btn btn-transparent-dark btn-icon dropdown-toggle"
											id="dropdownMenuButton" type="button"
											data-bs-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<i class="text-gray-500" data-feather="more-vertical"></i>
										</button>
										<div
											class="dropdown-menu dropdown-menu-end animated--fade-in-up"
											aria-labelledby="dropdownMenuButton">
											<h6 class="dropdown-header">Filter Activity:</h6>
											<a class="dropdown-item" href="#!"><span
												class="badge bg-green-soft text-green my-1">Commerce</span></a>
											<a class="dropdown-item" href="#!"><span
												class="badge bg-blue-soft text-blue my-1">Reporting</span></a> <a
												class="dropdown-item" href="#!"><span
												class="badge bg-yellow-soft text-yellow my-1">Server</span></a>
											<a class="dropdown-item" href="#!"><span
												class="badge bg-purple-soft text-purple my-1">Users</span></a>
										</div>
									</div>
								</div>
								<div class="card-body">
									<div class="timeline timeline-xs">
										<!-- Timeline Item 1-->
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
								</div>
							</div>
						</div>
						<div class="col-xxl-4 col-xl-6 mb-4">
							<div class="card card-header-actions h-100">
								<div class="card-header">
									Progress Tracker
									<div class="dropdown no-caret">
										<button
											class="btn btn-transparent-dark btn-icon dropdown-toggle"
											id="dropdownMenuButton" type="button"
											data-bs-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<i class="text-gray-500" data-feather="more-vertical"></i>
										</button>
										<div
											class="dropdown-menu dropdown-menu-end animated--fade-in-up"
											aria-labelledby="dropdownMenuButton">
											<a class="dropdown-item" href="#!">
												<div class="dropdown-item-icon">
													<i class="text-gray-500" data-feather="list"></i>
												</div> Manage Tasks
											</a> <a class="dropdown-item" href="#!">
												<div class="dropdown-item-icon">
													<i class="text-gray-500" data-feather="plus-circle"></i>
												</div> Add New Task
											</a> <a class="dropdown-item" href="#!">
												<div class="dropdown-item-icon">
													<i class="text-gray-500" data-feather="minus-circle"></i>
												</div> Delete Tasks
											</a>
										</div>
									</div>
								</div>
								<div class="card-body">
									<h4 class="small">
										<a href="/crew/documents?pool=passport&status=pending">Passports Uploaded</a> <span class="float-end fw-bold">20%</span>
									</h4>
									<div class="progress mb-4">
										<div class="progress-bar bg-danger" role="progressbar"
											style="width: 20%" aria-valuenow="20" aria-valuemin="0"
											aria-valuemax="100"></div>
									</div>
									<h4 class="small">
										<a href="/crew/documents?pool=cdc&status=pending">CDC Uploaded</a> <span class="float-end fw-bold">40%</span>
									</h4>
									<div class="progress mb-4">
										<div class="progress-bar bg-warning" role="progressbar"
											style="width: 40%" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100"></div>
									</div>
									<h4 class="small">
										<a href="/crew/documents?pool=visa&status=pending">Visa Uploaded</a> <span class="float-end fw-bold">60%</span>
									</h4>
									<div class="progress mb-4">
										<div class="progress-bar" role="progressbar"
											style="width: 60%" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100"></div>
									</div>
									<h4 class="small">
										<a href="/crew/documents?pool=cert&status=pending">Certificate Uploaded</a> <span class="float-end fw-bold">80%</span>
									</h4>
									<div class="progress mb-4">
										<div class="progress-bar bg-info" role="progressbar"
											style="width: 80%" aria-valuenow="80" aria-valuemin="0"
											aria-valuemax="100"></div>
									</div>
									<h4 class="small">
										Nok Details Added <span class="float-end fw-bold">Complete!</span>
									</h4>
									<div class="progress">
										<div class="progress-bar bg-success" role="progressbar"
											style="width: 100%" aria-valuenow="100" aria-valuemin="0"
											aria-valuemax="100"></div>
									</div>
								</div>
								<div class="card-footer position-relative">
									<div
										class="d-flex align-items-center justify-content-between small text-body">
										<a class="stretched-link text-body" href="#!">Visit Task
											Center</a> <i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Example Colored Cards for Dashboard Demo-->
					<div class="row">
						<div class="col-lg-6 col-xl-3 mb-4">
							<div class="card bg-primary text-white h-100">
								<div class="card-body">
									<div class="d-flex justify-content-between align-items-center">
										<div class="me-3">
											<div class="text-white-75 small">Earnings (Monthly)</div>
											<div class="text-lg fw-bold">$40,000</div>
										</div>
										<i class="feather-xl text-white-50" data-feather="calendar"></i>
									</div>
								</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between small">
									<a class="text-white stretched-link" href="#!">View Report</a>
									<div class="text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-xl-3 mb-4">
							<div class="card bg-warning text-white h-100">
								<div class="card-body">
									<div class="d-flex justify-content-between align-items-center">
										<div class="me-3">
											<div class="text-white-75 small">Earnings (Annual)</div>
											<div class="text-lg fw-bold">$215,000</div>
										</div>
										<i class="feather-xl text-white-50" data-feather="dollar-sign"></i>
									</div>
								</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between small">
									<a class="text-white stretched-link" href="#!">View Report</a>
									<div class="text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-xl-3 mb-4">
							<div class="card bg-success text-white h-100">
								<div class="card-body">
									<div class="d-flex justify-content-between align-items-center">
										<div class="me-3">
											<div class="text-white-75 small">Crew Added</div>
											<div class="text-lg fw-bold">24</div>
										</div>
										<i class="feather-xl text-white-50"
											data-feather="check-square"></i>
									</div>
								</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between small">
									<a class="text-white stretched-link" href="#!">View Tasks</a>
									<div class="text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-xl-3 mb-4">
							<div class="card bg-danger text-white h-100">
								<div class="card-body">
									<div class="d-flex justify-content-between align-items-center">
										<div class="me-3">
											<div class="text-white-75 small">Pending Review</div>
											<div class="text-lg fw-bold">17</div>
										</div>
										<i class="feather-xl text-white-50"
											data-feather="message-circle"></i>
									</div>
								</div>
								<div
									class="card-footer d-flex align-items-center justify-content-between small">
									<a class="text-white stretched-link" href="#!">View
										Requests</a>
									<div class="text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Example Charts for Dashboard Demo-->
					<!-- <div class="row">
						<div class="col-xl-6 mb-4">
							<div class="card card-header-actions h-100">
								<div class="card-header">
									Earnings Breakdown
									<div class="dropdown no-caret">
										<button
											class="btn btn-transparent-dark btn-icon dropdown-toggle"
											id="areaChartDropdownExample" type="button"
											data-bs-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<i class="text-gray-500" data-feather="more-vertical"></i>
										</button>
										<div
											class="dropdown-menu dropdown-menu-end animated--fade-in-up"
											aria-labelledby="areaChartDropdownExample">
											<a class="dropdown-item" href="#!">Last 12 Months</a> <a
												class="dropdown-item" href="#!">Last 30 Days</a> <a
												class="dropdown-item" href="#!">Last 7 Days</a> <a
												class="dropdown-item" href="#!">This Month</a>
											<div class="dropdown-divider"></div>
											<a class="dropdown-item" href="#!">Custom Range</a>
										</div>
									</div>
								</div>
								<div class="card-body">
									<div class="chart-area">
										<canvas id="myAreaChart" width="100%" height="30"></canvas>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-6 mb-4">
							<div class="card card-header-actions h-100">
								<div class="card-header">
									Monthly Revenue
									<div class="dropdown no-caret">
										<button
											class="btn btn-transparent-dark btn-icon dropdown-toggle"
											id="areaChartDropdownExample" type="button"
											data-bs-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<i class="text-gray-500" data-feather="more-vertical"></i>
										</button>
										<div
											class="dropdown-menu dropdown-menu-end animated--fade-in-up"
											aria-labelledby="areaChartDropdownExample">
											<a class="dropdown-item" href="#!">Last 12 Months</a> <a
												class="dropdown-item" href="#!">Last 30 Days</a> <a
												class="dropdown-item" href="#!">Last 7 Days</a> <a
												class="dropdown-item" href="#!">This Month</a>
											<div class="dropdown-divider"></div>
											<a class="dropdown-item" href="#!">Custom Range</a>
										</div>
									</div>
								</div>
								<div class="card-body">
									<div class="chart-bar">
										<canvas id="myBarChart" width="100%" height="30"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
					-->
					<!-- Example DataTable for Dashboard Demo-->
					<div class="card mb-4" id="crewList">
						<div class="card-header">Crew List
							<button class="btn btn-blue btn-icon float-end" type="button" data-bs-toggle="modal"
									data-bs-target="#newCrewModal">
								<i data-feather="plus"></i>
							</button>
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>Name</th>
										<th>Rank</th>
										<th>Gender</th>
										<th>Age</th>
										<th>Passport#</th>
										<th>INDOS#</th>
										<th>Manning Office</th>
										<th>Wage</th>
										<th>Status</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Name</th>
										<th>Rank</th>
										<th>Gender</th>
										<th>Age</th>
										<th>Passport#</th>
										<th>INDOS#</th>
										<th>Manning Office</th>
										<th>Wage</th>
										<th>Status</th>
										<th>Actions</th>
									</tr>
								</tfoot>
								<tbody>
								<c:forEach items="${list}" var="crew">
									<tr>
										<td><a href="/crew/overview?crewId=${crew.id}">${crew.fullName}</a></td>
										<td>${crew.rank.name}</td>
										<td>${crew.gender}</td>
										<td>${crew.age}</td>
										<td>${crew.passportNumber}</td>
										<td>${crew.indosNumber}</td>
										<td>${crew.manningOffice}</td>
										<td>${crew.currentContract.wageCurrency} ${crew.currentContract.monthlyWage}</td>
										<td>${crew.status.desc}</td>
										<td>
											<!--<div class="badge bg-primary text-white rounded-pill">Full-time</div></td>-->
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
													</div>
													Add Certifications
												</a>
												<a class="dropdown-item" href="/crew/add_medicals?crewId=${crew.id}">
													<div class="dropdown-item-icon">
														<i data-feather="settings"></i>
													</div>
													Add Medical Tests
												</a>
												<a class="dropdown-item" href="/crew/add_licenses?crewId=${crew.id}">
													<div class="dropdown-item-icon">
														<i data-feather="settings"></i>
													</div>
													Add Licenses
												</a>
												<a class="dropdown-item" href="/crew/document_list?crewId=${crew.id}">
													<div class="dropdown-item-icon">
														<i data-feather="settings"></i>
													</div>
													Add Documents
												</a>
												<div class="dropdown-divider"></div>
												<a class="dropdown-item"
												   href="/crew/personal?action=modify&crewId=${crew.id}">
													<div class="dropdown-item-icon">
														<i data-feather="log-out"></i>
													</div>
													Edit
												</a>
												<c:if test="${crew.statusId == 4}">
													<a class="dropdown-item"
													   href="/crew/generateContract?crewId=${crew.id}">
														<div class="dropdown-item-icon">
															<i data-feather="briefcase"></i>
														</div>
														Generate Contract
													</a>
												</c:if>
												<div class="dropdown-divider"></div>
												<a class="dropdown-item" href="/crew/vacancy_list?crewId=${crew.id}">
													<div class="dropdown-item-icon">
														<i data-feather="log-out"></i>
													</div>
													Sign-On/Sign-Off
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
			<%@ include file="includes/copyright.jsp"%>
		</div>
	</div>

	<div class="modal fade" id="newCrewModal" tabindex="-1" role="dialog" aria-labelledby="newCrewModalLabel"
		 style="display: none;" aria-hidden="true">

		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Add New Crew</h5>
					<button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="container-xl px-4">
						<div class="row justify-content-center">
							<!-- Create Organization-->
							<div class="col-xl-5 col-lg-6 col-md-8 col-sm-11 mt-4">
								<div class="card text-center h-100">
									<div class="card-body px-5 pt-5 d-flex flex-column">
										<div>
											<div class="h3 text-primary">Manual</div>
											<p class="text-muted mb-4">Manually enter crew details on UI</p>
										</div>
										<div class="icons-org-create align-items-center mx-auto mt-auto">
											<i class="icon-users" data-feather="users"></i>
											<i class="icon-plus fas fa-plus"></i>
										</div>
									</div>
									<div class="card-footer bg-transparent px-5 py-4">
										<div class="small text-center">
											<form role="form" method="GET" action="/crew/personal?menu=personal&action=add">
												<button class="btn btn-primary" type="submit">Add Manually</button>
											</form>
										</div>
									</div>
								</div>
							</div>
							<!-- Join Organization-->
							<div class="col-xl-5 col-lg-6 col-md-8 col-sm-11 mt-4">
								<form role="form" method="POST" enctype="multipart/form-data" action="/crew/upload">
									<div class="card text-center h-100">
										<div class="card-body px-5 pt-5 d-flex flex-column align-items-between">
											<div>
												<div class="h3 text-secondary">Upload</div>
												<p class="text-muted mb-4">Upload crew details via excel upload</p>
											</div>
											<div class="icons-org-join align-items-center mx-auto">
												<i class="icon-user" data-feather="user"></i>
												<i class="icon-arrow fas fa-long-arrow-alt-right"></i>
												<i class="icon-users" data-feather="users"></i>
											</div>
											<div>
												<input type="file" name="file">
											</div>
										</div>
										<div class="card-footer bg-transparent px-5 py-4">
											<div class="small text-center">
												<button class="btn btn-secondary" type="submit">Upload excel</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>


				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="button" data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables/datatables-simple-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/litepicker/dist/bundle.js"
		crossorigin="anonymous"></script>
	<script src="js/litepicker.js"></script>
</body>
</html>
