<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Vacancy List</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <%@ include file="../includes/header_includes.jsp" %>
        <script src="../js/vessel/vessel_details.js"></script>
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
						<div class="card-header">Vacancy List
						    <button class="btn btn-blue btn-icon float-end" type="button" data-bs-toggle="modal" data-bs-target="#newVacancyModal">
                                <i data-feather="plus"></i>
                            </button>
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>Vessel Name</th>
                                        <th>Vessel Type</th>
                                        <th>Min. Gross Tonnage</th>
                                        <th>Min Ranks</th>
                                        <th>No. of open positions</th>
                                        <th>Entered by</th>
                                        <th>Status</th>
                                        <th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Vessel Name</th>
                                        <th>Vessel Type</th>
                                        <th>Min. Gross Tonnage</th>
                                        <th>Min Ranks</th>
                                        <th>No. of open positions</th>
                                        <th>Entered by</th>
                                        <th>Status</th>
                                        <th>Actions</th>
									</tr>
								</tfoot>
								<tbody>

								<c:forEach items="${list}" var="vacancy">
								    <tr>
										<td>${vacancy.vessel.vesselName}</td>
										<td>${vacancy.vessel.vesselSubType.vesselType.desc} - ${vacancy.vessel.vesselSubType.desc}</td>
										<td>${vacancy.vacancyAttributes.minGrossTonnage}</td>
										<td>
										<c:forEach items="${vacancy.vacancyAttributes.minRankList}" var="rank">
										    ${rank.name}
										</c:forEach>
										</td>
										<td>${vacancy.openPositions}</td>
										<td>${vacancy.enteredBy.empId}</td>
										<td>
										    <div class="badge bg-primary text-white rounded-pill">${vacancy.status.desc}</div></td>
										<td>
										<button onclick="VesselDetails.openSelectCrewModal(${vacancy.id})" class="btn btn-datatable btn-icon btn-transparent-dark">
                                            <i data-feather="users"></i>

										    <button
													class="btn btn-datatable btn-icon btn-transparent-dark me-2"
													id="dropdownMenuButton" type="button"
													data-bs-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i data-feather="more-vertical"></i>
												</button>
											<div class="dropdown-menu">
													<div class="dropdown-divider"></div>
													<a class="dropdown-item" href="/vessel/vacancy_details?action=modify&vacancyId=${vacancy.id}">
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

	<div class="modal fade" id="newVacancyModal" tabindex="-1" role="dialog" aria-labelledby="newVacancyModalLabel" style="display: none;" aria-hidden="true">
	    <form id="vacancy-fill-form" role="form" method="POST" action="/vessel/add_vacancy">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">New Vacancy</h5>
                    <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="col-md-8 mb-3">
                        <label class="small mb-3" for="vesselId">Select a Vessel</label>
                        <select class="form-select" id="vesselId" name="vesselId" aria-label="Default select vessel">
                            <option selected disabled>Select a Vessel:</option>
                            <c:forEach items="${vessels}" var="vessel">
                                <option value="${vessel.id}">${vessel.vesselName} (${vessel.vesselSubType.desc})</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-8 mb-3">
                        <select class="form-select" id="rankId" name="rankId" aria-label="Default select rank">
                            <option selected disabled>Select a Rank:</option>
                            <c:forEach var="optionGroup" items="${rankMap}">
                               <optgroup label="${optionGroup.key}">
                               <c:forEach var="option" items="${optionGroup.value}">
                                  <option <c:if test="${crew.rank.id==option.id}">selected</c:if> value="${option.id}">${option.name} (${option.rankSubCategory.name})</option>
                               </c:forEach>
                               </optgroup>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-8 mb-3">
                        <label class="small mb-3" for="openPositions">No. of open positions</label>
                        <input class="small mb-2 form-control" name="openPositions" id="openPositions" type="text" placeholder="Enter No. of open positions" value="1" />
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="button" data-bs-dismiss="modal">Close</button>
                        <button class="btn btn-primary" type="submit">Add</button>
                    </div>
                 </div>
            </div>
        </div>
        </form>
    </div>

    <div class="modal fade" id="selectCrewModal" tabindex="-1" role="dialog" aria-labelledby="selectCrewModalLabel" style="display: none;" aria-hidden="true">
    	    <form id="vacancy-assign-form" role="form" method="POST">
    	   <input type="hidden" id="vacancyId" value="${vacancy.id}">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Select Crew</h5>
                        <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-8 mb-3">
                            <label class="small mb-3" for="vesselId">Select a Vessel</label>
                            <select class="form-select" id="vesselId" name="vesselId" aria-label="Default select vessel">
                                <option selected disabled>Select a Vessel:</option>
                                <c:forEach items="${vessels}" var="vessel">
                                    <option value="${vessel.id}">${vessel.vesselName} (${vessel.vesselSubType.desc})</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-8 mb-3">
                            <select class="form-select" id="rankId" name="rankId" aria-label="Default select rank">
                                <option selected disabled>Select a Rank:</option>
                                <c:forEach var="optionGroup" items="${rankMap}">
                                   <optgroup label="${optionGroup.key}">
                                   <c:forEach var="option" items="${optionGroup.value}">
                                      <option <c:if test="${crew.rank.id==option.id}">selected</c:if> value="${option.id}">${option.name} (${option.rankSubCategory.name})</option>
                                   </c:forEach>
                                   </optgroup>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-8 mb-3">
                            <label class="small mb-3" for="openPositions">No. of open positions</label>
                            <input class="small mb-2 form-control" name="openPositions" id="openPositions" type="text" placeholder="Enter No. of open positions" value="1" />
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="button" data-bs-dismiss="modal">Close</button>
                            <button class="btn btn-primary" type="submit">Add</button>
                        </div>
                     </div>
                </div>
            </div>
            </form>
        </div>

	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="../js/datatables/datatables-simple-demo.js"></script>
				</main>
    			<%@ include file="../includes/copyright.jsp"%>
    		</div>

    		<%@ include file="../includes/bottom_includes.jsp"%>
    	</div>

</body>
</html>
