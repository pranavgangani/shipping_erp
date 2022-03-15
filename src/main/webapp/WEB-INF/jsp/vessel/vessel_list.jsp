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
<title>Vessel List</title>

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
						<div class="card-header">Vessel List</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>Vessel Name</th>
										<th>Vessel Type</th>
										<th>Vessel Owner</th>
										<th>Capacity</th>
										<th>Built Year</th>
										<th>Gross Tonnage</th>
										<th>Dimensions</th>
										<th>IMO</th>
										<th>MMSI</th>
										<th>Call Sign</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Vessel Name</th>
										<th>Vessel Type</th>
										<th>Vessel Owner</th>
										<th>Capacity</th>
										<th>Built Year</th>
										<th>Gross Tonnage</th>
										<th>Dimensions</th>
										<th>IMO</th>
										<th>MMSI</th>
										<th>Call Sign</th>
										<th>Actions</th>
									</tr>
								</tfoot>
								<tbody>
								
								<c:forEach items="${list}" var="vessel">
								    <tr>
										<td>${vessel.vesselName}</td>
										<td>${vessel.vesselSubType.desc} (${vessel.vesselSubType.vesselType.desc})</td>
										<td>${vessel.vesselOwner.ownerName}</td>
										<td>${vessel.capacity}</td>
										<td>${vessel.yearOfBuilt}</td>
										<td>${vessel.grossTonnage}</td>
										<td>${vessel.length}m - ${vessel.beam}m - ${vessel.draught}m</td>
										<td>${vessel.imo}</td>
										<td>${vessel.mmsi}</td>
										<td>${vessel.callSign}</td>
										<!-- <td><div class="badge bg-primary text-white rounded-pill">Full-time</div></td> -->
										<td>
										<button
													class="btn btn-datatable btn-icon btn-transparent-dark me-2"
													id="dropdownMenuButton" type="button"
													data-bs-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i data-feather="more-vertical"></i>
												</button>
											<div class="dropdown-menu">
													<a class="dropdown-item" href="/vessel/add_vessel_doc">
														<div class="dropdown-item-icon">
															<i data-feather="user"></i>
														</div> Add Documents
													</a>
													<div class="dropdown-divider"></div>
													<a class="dropdown-item" href="/vessel/edit?vesselId=${vessel.id}">
                                                        <div class="dropdown-item-icon">
                                                            <i data-feather="settings"></i>
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
