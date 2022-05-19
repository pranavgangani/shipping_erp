<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Document Types</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <%@ include file="../includes/header_includes.jsp" %>
    </head>

    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>


        <div id="layoutSidenav">

        <%@ include file="../includes/sidebar.jsp" %>

            <div id="layoutSidenav_content">
                <main>
                    <div class="card mb-4">
						<div class="card-header">Document Type List
						  <button class="btn btn-blue btn-icon float-end" type="button" data-bs-toggle="modal" data-bs-target="#newDocTypeModal">
                            <i data-feather="plus"></i>
                            </button>
                        </div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>Name</th>
                                        <th>Flag</th>
                                        <th>Category</th>
                                        <th>Pool</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Name</th>
                                        <th>Flag</th>
                                        <th>Category</th>
                                        <th>Pool</th>
									</tr>
								</tfoot>
								<tbody>

								<c:forEach items="${documentTypeList}" var="dt">
								    <tr>
										<td>${dt.name}</td>
										<td>${dt.flagCode}</td>
										<td>${dt.documentCategory.name}</td>
										<td>${dt.documentPool}</td>
									</tr>
								</c:forEach>


								</tbody>
							</table>
						</div>
					</div>
                </main>

                <%@ include file="../includes/copyright.jsp" %>

            </div>
        </div>

        <%@ include file="../includes/bottom_includes.jsp" %>


	<div class="modal fade" id="newDocTypeModal" tabindex="-1" role="dialog" aria-labelledby="newDocTypeModalLabel" style="display: none;" aria-hidden="true">
	    <form id="vacancy-fill-form" role="form" method="POST" action="/vessel/add_vacancy">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">New Vacancy</h5>
                    <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="col-md-8 mb-3">
                        <label class="small mb-3" for="vesselId">Select a Pool</label>
                        <select class="form-select" aria-label="Default select example" id="docCategoryId" name="docCategoryId">
                            <option selected disabled>Select Pool:</option>
                            <c:forEach items="${docPoolList}" var="docPool">
                                    <option value="${docPool.name}">${docPool.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-8 mb-3">
                        <select class="form-select" aria-label="Default select example" id="nationalityFlagCode" name="nationalityFlagCode">
                            <option selected disabled>Select Nationality Flag:</option>
                            <c:forEach items="${flags}" var="flag">
                                    <option value="${flag.code}">${flag.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-8 mb-3">
                         <label class="small mb-1" for="docTypeName">Document Type</label>
                            <input class="form-control" name="docTypeName" type="text" placeholder="Enter Doc Type Name" value="" />

                             <label class="small mb-1" for="docTypeDesc">Document Type Description</label>
                                <input class="form-control" name="docTypeDesc" type="text" placeholder="Enter Doc Type Description" value="" />
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
