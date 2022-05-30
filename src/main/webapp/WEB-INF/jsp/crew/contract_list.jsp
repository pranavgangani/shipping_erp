<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Contract List</title>

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

				<!--<div class="card mb-4">
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
                </div>-->


					<div class="card mb-4">
						<div class="card-header">Contract List</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
									    <th>#</th>
										<th>Name</th>
                                        <th>Rank</th>
                                        <th>Vessel</th>
                                        <th>Vessel Type</th>
                                        <th>Embark Date</th>
                                        <th>Embark Place</th>
                                        <th>Wage</th>
                                        <th>Status</th>
                                        <th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>#</th>
                                        <th>Name</th>
                                        <th>Rank</th>
                                        <th>Vessel</th>
                                        <th>Vessel Type</th>
                                        <th>Embark Date</th>
                                        <th>Embark Place</th>
                                        <th>Wage</th>
                                        <th>Status</th>
                                        <th>Actions</th>
									</tr>
								</tfoot>
								<tbody>
								
								<c:forEach items="${list}" var="contract">
								    <tr>
								        <td>${contract.id}</td>
										<td>${contract.crew.fullName}</td>
										<td>${contract.rank.name}</td>
										<td>${contract.vessel.vesselOwner.ownerName} - ${contract.vessel.vesselName}</td>
										<td>${contract.vessel.vesselSubType.desc}</td>
										<td>${contract.startDate.format( DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</td>
										<td>${contract.embarkPort}</td>
										<td>${contract.wageCurrency} ${contract.monthlyWage}</td>
										<td>${contract.statusId}</td>
										<td>
										    <button
													class="btn btn-datatable btn-icon btn-transparent-dark me-2"
													id="dropdownMenuButton" type="button"
													data-bs-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i data-feather="more-vertical"></i>
												</button>
											<div class="dropdown-menu">
													<a class="dropdown-item" href="/contract/modify?contractId=${contract.id}">
														<div class="dropdown-item-icon">
															<i data-feather="log-out"></i>
														</div> Edit
													</a>
													<!--<c:if test="${contract.statusId == 2}">
                                                        <a class="dropdown-item" href="/crew/generateContract?crewId=${crew.id}">
                                                            <div class="dropdown-item-icon">
                                                                <i data-feather="briefcase"></i>
                                                            </div> Generate Contract
                                                        </a>
                                                    </c:if>-->
													<div class="dropdown-divider"></div>
													<a class="dropdown-item" href="/crew/contract/download?contractId=${contract.id}">
														<div class="dropdown-item-icon">
															<i data-feather="log-out"></i>
														</div> Download Contract
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
