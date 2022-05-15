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
<title>Vacancy List</title>

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
						<div class="card-header">Vacancy List</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>Vessel Name</th>
                                        <th>Vessel Type</th>
                                        <th>Rank</th>
                                        <th>No of open positions</th>
                                        <th>Status</th>
                                        <th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Vessel Name</th>
                                        <th>Vessel Type</th>
                                        <th>Rank</th>
                                        <th>No of open positions</th>
                                        <th>Status</th>
                                        <th>Actions</th>
									</tr>
								</tfoot>
								<tbody>
								
								<c:forEach items="${vacancies}" var="vacancy">
								    <tr>
										<td>${vacancy.vessel.vesselName}</td>
										<td>${vacancy.vessel.vesselSubType.vesselType.desc} - ${vacancy.vessel.vesselSubType.desc}</td>
										<td>${vacancy.openPositions}</td>
										<td>
										    <div class="badge bg-primary text-white rounded-pill">${vacancy.status.desc}</div></td>
										<td>
										    <button
													class="btn btn-datatable btn-icon btn-transparent-dark me-2"
													id="dropdownMenuButton" type="button"
													data-bs-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i data-feather="more-vertical"></i>
												</button>
											<div class="dropdown-menu">
													<a class="dropdown-item" href="/vessel/assign_crew?vacancyId=${vacancy.id}">
														<div class="dropdown-item-icon">
															<i data-feather="user"></i>
														</div> Assign Crew
													</a>
													<div class="dropdown-divider"></div>
													<a class="dropdown-item" href="/crew/edit?crewId=${crew.id}">
														<div class="dropdown-item-icon">
															<i data-feather="log-out"></i>
														</div> Edit
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
