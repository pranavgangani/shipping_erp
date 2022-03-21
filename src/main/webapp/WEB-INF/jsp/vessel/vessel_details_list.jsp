<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Vessel List</title>

        <%@ include file="../includes/header_includes.jsp" %>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <script src="../js/vessel/vessel_details.js"></script>
    </head>
    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>


        <div id="layoutSidenav">

        <%@ include file="../includes/sidebar.jsp" %>

            <div id="layoutSidenav_content">
                <main>
                <form method="POST" enctype="multipart/form-data" action="/vessel/vessel_vacancy_details">
                <%@ include file="add_owner_header.jsp" %>

                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation-->
                        <nav class="nav nav-borders">
                            <a class="nav-link"  href="/vessel/vessel_owner_details?vesselOwnerId=${vesselOwner.id}">Profile</a>
                            <a class="nav-link active ms-0">Vessels</a>
                            <a class="nav-link" href="/vessel/document_list?action=view&vesselOwnerId=${vesselOwner.id}">Documents</a>
                        </nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">
                            <div class="col-xl-2">
                                <!-- Two factor authentication card-->
                                   <div class="card mb-4">
                                       <div class="card-header">Profile Picture</div>
                                       <div class="card-body">
                                           <!-- Profile picture help block-->
                                        <c:choose>
                                            <c:when test="${vesselOwner.photoId>0}">
                                                <img class="img-account-profile rounded-circle mb-2" alt="img" src="data:image/jpeg;base64,${image}" alt="" id='preview' />
                                            </c:when>
                                            <c:otherwise>
                                                <input type='file' id='file-input' hidden name="image">
                                                <img class="img-account-profile rounded-circle mb-2"
                                                    src="../assets/img/illustrations/profiles/logo-1.png"
                                                    alt="" id='preview' />
                                                <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                                            </c:otherwise>
                                        </c:choose>
                                        <!-- Profile picture upload button-->
                                        <button id="myBtn" class="btn btn-primary" type="button">Upload an image</button>

                                       </div>
                                   </div>
                            <div class="col-xl-10">
                                <!-- Account details card-->
                                <div class="card mb-6">
                                    <div class="card-header">Managed Vessels</div>
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
                                                                <a class="dropdown-item" href="/vessel/document_list?action=add">
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
                        </div>
                    </div>

                    </form>
                </main>
                
                <%@ include file="../includes/copyright.jsp" %>
                
            </div>
        </div>
        
        <%@ include file="../includes/bottom_includes.jsp" %>
       
</body>

<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
<script src="../js/datatables/datatables-simple-demo.js"></script>
</html>
