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
<title>Certification List</title>
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
				<div class="container-fluid px-4">
					<div class="page-header-content">
						<div class="row align-items-center justify-content-between pt-3">
							<div class="col-auto mb-3">
								<h1 class="page-header-title">
									<!-- <div class="page-header-icon">
							<i data-feather="user-plus"></i>
						</div> -->
									Certification
								</h1>
							</div>
							<div class="col-12 col-xl-auto mb-3">
								<a class="btn btn-sm btn-light text-primary"
									href="/settings/assign_certification"> <i class="me-1"
									data-feather="arrow-right"></i> Add New Certification
								</a>
							</div>
						</div>
					</div>
				</div>
			</header>

			<main>

				<!-- Main page content-->
				<div class="container-fluid px-4">
					<div class="card mb-4">
						<div class="card-header">Rank List</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>Certification Name</th>
										<th>Duration</th>
										<th>Rank Category</th>
										<th>Rank Sub-Category</th>
										<th>Rank</th>																		
										<th>Action</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Certification Name</th>
										<th>Duration</th>
										<th>Rank Category</th>
										<th>Rank Sub-Category</th>
										<th>Rank</th>
										<th>Action</th>
									</tr>
								</tfoot>
								<tbody>

									<c:forEach items="${list}" var="cert">
										<tr>
											<td>${cert.name}</td>
											<td>${cert.validity} ${cert.durationType.typeName}</td>
											<td>${cert.rankCategory.name}</td>
											<td>${cert.rankSubCategory.name}</td>
											<td>${cert.rank.name}</td>
											<td>
												<button
													class="btn btn-datatable btn-icon btn-transparent-dark me-2"
													id="dropdownMenuButton" type="button"
													data-bs-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i data-feather="more-vertical"></i>
												</button>												
												<div class="dropdown-menu">
													<div class="dropdown-divider"></div>
													<a class="dropdown-item" href="/settings/edit_rank?rankId=${cert.rank.id}">
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
