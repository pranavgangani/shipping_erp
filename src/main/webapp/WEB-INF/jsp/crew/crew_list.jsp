<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Crew List</title>

    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <%@ include file="../includes/header_includes.jsp" %>

</head>
<body class="nav-fixed">
<%@ include file="../includes/top_nav_bar.jsp" %>
<div id="layoutSidenav">
    <%@ include file="../includes/sidebar.jsp" %>
    <div id="layoutSidenav_content">

        <main>

            <!-- Main page content-->
            <div class="container-fluid px-4">

                <div class="card mb-4">
                    <div class="card-header">Filter</div>
                    <div class="card-body">
                        <table>
                            <tr>
                                <td>Status:</td>
                                <td>
                                    <select class="form-select" id="filterStatus" name="filterStatus"
                                            aria-label="Default select example">
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
        <%@ include file="../includes/copyright.jsp" %>
    </div>

    <%@ include file="../includes/bottom_includes.jsp" %>
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


<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
        crossorigin="anonymous"></script>
<script src="../js/datatables/datatables-simple-demo.js"></script>

</body>
</html>
