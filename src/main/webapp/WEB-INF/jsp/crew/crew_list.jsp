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

			<main>

				<!-- Main page content-->
				<div class="container-fluid px-4">

				<div class="card mb-4">
                						<div class="card-header">Filter</div>
                						<div class="card-body">
                                            <table>
                                                <tr>
                                                    <td>Status: </td>
                                                    <td>
                                                        <select class="form-select" id="filterStatus" name="filterStatus" aria-label="Default select example">
                                                            <option value="availability">Availability</option>
                                                            <option value="debriefPending">De-Brief Pending</option>
                                                            <option value="newApplication">New Applicant</option>
                                                            <option value="pendingApproval">Pending Approval</option>
                                                            <option value="pendingReview">Pending Review</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                						</div>
                					</div>


					<div class="card mb-4">
						<div class="card-header">Crew List</div>
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
										<td>${crew.fullName}</td>
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
													<a class="dropdown-item" href="/crew/modify?crewId=${crew.id}">
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
