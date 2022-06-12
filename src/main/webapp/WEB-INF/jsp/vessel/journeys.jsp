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
            <input type="hidden" id="vesselId" name="vesselId" value="${vessel.id}">
            <%@ include file="vessel_header.jsp" %>
            <!-- Main page content-->
            <div class="container-fluid px-4">
                <%@ include file="vessel_menu.jsp" %>
                <div class="card mb-4">
                    <div class="card-header">Journeys
                        <button class="btn btn-blue btn-icon float-end" type="button" data-bs-toggle="modal"
                                data-bs-target="#newJourneyModal">
                            <i data-feather="plus"></i>
                        </button>
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Last Port</th>
                                <th>Next Port</th>
                                <th>ETA</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Last Port</th>
                                <th>Next Port</th>
                                <th>ETA</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                            </tfoot>
                            <tbody>

                            <c:forEach items="${vessel.journeys}" var="journey">
                                <tr>
                                    <td><a href="/crew/overview?crewId=${crew.id}">${crew.fullName}</a></td>
                                    <td>${journey.lastPort.name}</td>
                                    <td>${journey.nextPort.name}</td>
                                    <td>${journey.eta}</td>
                                    <td>${journey.status.desc}</td>
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

<div class="modal fade" id="newJourneyModal" tabindex="-1" role="dialog" aria-labelledby="newJourneyModalLabel" style="display: none;" aria-hidden="true">
    <form id="vacancy-fill-form" role="form" method="POST" action="/vessel/add_vacancy">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">New Vacancy</h5>
                    <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="col-md-8 mb-3">
                        <label class="small mb-3" for="vesselId">Start Port</label>
                        <select class="form-select" id="startPort" name="startPort">
                            <option selected disabled>Select Start Port:</option>
                            <c:forEach items="${ports}" var="port">
                                <option value="${port.refcode}">${port.name}, ${port.country} (${port.refcode})</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-8 mb-3">
                        <select class="form-select" id="nextPort" name="startPort">
                            <option selected disabled>Select Next Port:</option>
                            <c:forEach items="${ports}" var="port">
                                <option value="${port.refcode}">${port.name}, ${port.country} (${port.refcode})</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-8 mb-3">
                        <label class="small mb-3" for="eta">ETA</label>
                        <div class="input-group input-group-joined border-1">
                                            <span class="input-group-text"><i class="text-primary"
                                                                              data-feather="calendar"></i></span>
                            <input name="eta" class="form-control dirtycheck"
                                   id="eta"
                                   placeholder="Select ETA" />
                        </div>
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

</body>
</html>
