<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Vessel Overview</title>

    <%@ include file="../includes/header_includes.jsp" %>
    <script src="../js/vessel/vessel_details.js"></script>
</head>

<body class="nav-fixed">
<%@ include file="../includes/top_nav_bar.jsp" %>


<div id="layoutSidenav">

    <%@ include file="../includes/sidebar.jsp" %>

    <div id="layoutSidenav_content">
        <main>
            <c:if test="${action == 'add'}">
            <form id="vessel-details-form" role="form" method="POST" enctype="multipart/form-data" action="/vessel/add">
                </c:if>
                <input type="hidden" id="vesselId" name="vesselId" value="${vessel.id}">
                <input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
                <input type="hidden" id="menu" value="${menu}">
                <%@ include file="vessel_header.jsp" %>
                <!-- Main page content-->
                <div class="container-fluid px-4">
                    <%@ include file="vessel_menu.jsp" %>
                    <hr class="mt-0 mb-2"/>
                    <div class="row">
                        <div class="col-lg-2 mb-2">
                            <!-- Billing card 1-->
                            <div class="card mb-2">
                                <div class="card-header">Vessel Picture</div>
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${vessel.photoId>0}">
                                            <img class="img-account-profile rounded mb-2" alt="img"
                                                 src="data:image/jpeg;base64,${image}" alt="" id='preview'/>
                                            <input type='file' id='file-input' hidden name="image">
                                        </c:when>
                                        <c:otherwise>
                                            <img class="img-account-profile rounded-circle mb-2"
                                                 src="../assets/img/illustrations/profiles/ship-1.png"
                                                 alt="" id='preview'/>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 mb-6">
                            <!-- Billing card 2-->
                            <div class="card mb-6">
                                <div class="card-header">Vessel Particulars</div>
                                <div class="card-body">
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Fleet Manager</div>
                                                <div class="text-xs text-muted">${vessel.fleetManager.fullName}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Technical Suptd.</div>
                                                <div class="text-xs text-muted">${vessel.technicalSup.fullName}</div>
                                            </div>
                                        </div>
                                        <%--<div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Vessel Type</div>
                                                <div class="text-xs text-muted">${vessel.vesselSubType.desc}</div>
                                            </div>
                                        </div>--%>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Vessel Name</div>
                                                <div class="text-xs text-muted">${vessel.vesselName}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Vessel Owner</div>
                                                <div class="text-xs text-muted">${vessel.vesselOwner.ownerName}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Vessel Type</div>
                                                <div class="text-xs text-muted">${vessel.vesselSubType.desc}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">CallSign</div>
                                                <div class="text-xs text-muted">${vessel.callSign}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">IMO</div>
                                                <div class="text-xs text-muted">${vessel.imo}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">MMSI</div>
                                                <div class="text-xs text-muted">${vessel.mmsi}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Length</div>
                                                <div class="text-xs text-muted">${vessel.length}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Beam</div>
                                                <div class="text-xs text-muted">${vessel.beam}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Draught</div>
                                                <div class="text-xs text-muted">${vessel.draught}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Capacity</div>
                                                <div class="text-xs text-muted">${vessel.capacity}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Gross Tonnage</div>
                                                <div class="text-xs text-muted">${vessel.grossTonnage}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Year of Built</div>
                                                <div class="text-xs text-muted">${vessel.yearOfBuilt}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Flag</div>
                                                <div class="text-xs text-muted">${vessel.flag.name}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Home Port</div>
                                                <div class="text-xs text-muted">${vessel.homePort.name}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="small">Status</div>
                                            <div class="text-xs text-muted">${vessel.vesselStatus.desc}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr class="mt-0 mb-2"/>
                            <div class="card mb-6">
                                <div class="card-header">Key Details</div>
                                <div class="card-body">
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Master</div>
                                                <div class="text-xs text-muted">Master</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Chief Engineer</div>
                                                <div class="text-xs text-muted">Chief Engineer</div>
                                            </div>
                                        </div>
                                        <%--<div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Vessel Type</div>
                                                <div class="text-xs text-muted">${vessel.vesselSubType.desc}</div>
                                            </div>
                                        </div>--%>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Last Port</div>
                                                <div class="text-xs text-muted">${activeJourney.lastPort.name}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Next Port</div>
                                                <div class="text-xs text-muted">${activeJourney.nextPort.name}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">ETA</div>
                                                <div class="text-xs text-muted">${activeJourney.eta}</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 mb-4">
                            <!-- Billing card 3-->
                            <div class="card mb-4">
                                <div class="card-header">Reports</div>
                                <div class="card-body p-0">
                                    <div class="table-responsive table-billing-history">
                                        <table class="table mb-0">
                                            <tbody>
                                            <c:choose>
                                                <c:when test="${fn:length(documents)>0}">
                                                    <c:forEach items="${documents}" var="doc">
                                                        <tr>
                                                            <td><label
                                                                    class="small mb-3">${doc.docType.name}</label>
                                                            </td>
                                                            <td><label
                                                                    class="small mb-3">${doc.docNumber}</label>
                                                            </td>
                                                            <td><label
                                                                    class="small mb-3">${doc.dateOfIssue.format( DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</label>
                                                            </td>
                                                            <td><label
                                                                    class="small mb-3">${doc.placeOfIssue}</label>
                                                            </td>
                                                            <td><label
                                                                    class="small mb-3">${doc.dateOfExpiry.format( DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</label>
                                                            </td>
                                                            <td>
                                                                <c:if test="${doc.file!=null}">
                                                                    <a class="dropdown-item"
                                                                       href="/vessel/document/download?documentId=${doc.id}">
                                                                        <div class="page-header-icon"><i
                                                                                data-feather="file"></i>
                                                                        </div>
                                                                    </a>
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </c:when>
                                                <c:otherwise>
                                                    <tr>
                                                        <td colspan="6">No reports</td>
                                                    </tr>
                                                </c:otherwise>
                                            </c:choose>

                                            </tbody>
                                        </table>
                                    </div>
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

<script>

    var input = document.querySelector("#file-input");

    document.getElementById("myBtn").addEventListener("click", function () {
        input.click();
    });

    input.addEventListener("change", preview);

    function preview() {
        var fileObject = this.files[0];
        var fileReader = new FileReader();
        fileReader.readAsDataURL(fileObject);
        fileReader.onload = function () {
            var result = fileReader.result;
            var img = document.querySelector("#preview");
            img.setAttribute("src", result);
        };
    }

</script>
</html>
