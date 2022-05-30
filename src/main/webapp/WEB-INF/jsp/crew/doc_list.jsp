<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
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
						<div class="card-header">Crew Document List
						    <button class="btn btn-blue btn-icon float-end" type="button" data-bs-toggle="modal" data-bs-target="#newVacancyModal">
                                <i data-feather="plus"></i>
                            </button>
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
									    <th>Given Name</th>
										<th>Doc Name</th>
                                        <th>Doc Type</th>
                                        <th>Doc Number</th>
                                        <th>Issue Date</th>
                                        <th>Expiry Date</th>
                                        <th>Place of Issue</th>
                                        <th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
									    <th>Given Name</th>
										<th>Doc Name</th>
                                        <th>Doc Type</th>
                                        <th>Doc Number</th>
                                        <th>Issue Date</th>
                                        <th>Expiry Date</th>
                                        <th>Place of Issue</th>
                                        <th>Actions</th>
									</tr>
								</tfoot>
								<tbody>

								<c:forEach items="${existingDocuments}" var="doc">
								    <tr>
								        <td>${doc.givenName}</td>
										<td>${doc.docType.name}</td>
										<td>${doc.docType.documentPool}</td>
										<td>${doc.flagCode}</td>
										<td>${doc.docNumber}</td>
										<td>${doc.dateOfIssue}</td>
										<td>${doc.dateOfExpiry}</td>
										<td>${doc.placeOfIssue}</td>
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
