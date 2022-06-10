<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Crew Overview :: <c:choose><c:when
            test="${action=='add'}">Add</c:when><c:otherwise>${crew.fileNum}</c:otherwise></c:choose></title>

    <%@ include file="../includes/header_includes.jsp" %>
    <script src="../js/crew/crew_details.js"></script>
</head>

<body class="nav-fixed">
<%@ include file="../includes/top_nav_bar.jsp" %>


<div id="layoutSidenav">

    <%@ include file="../includes/sidebar.jsp" %>

    <div id="layoutSidenav_content">
        <main>
            <c:if test="${action == 'add'}">
            <form id="crew-details-form" role="form" method="POST" enctype="multipart/form-data" action="/crew/add">
                </c:if>
                <input type="hidden" id="crewId" name="crewId" value="${crew.id}">
                <input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
                <input type="hidden" id="menu" value="${menu}">
                <%@ include file="crew_header.jsp" %>
                <!-- Main page content-->
                <div class="container-fluid px-4">
                    <%@ include file="add_crew_menu.jsp" %>
                    <hr class="mt-0 mb-2"/>
                    <div class="row">
                        <div class="col-lg-2 mb-2">
                            <!-- Billing card 1-->
                            <div class="card mb-2">
                                <div class="card-header">Profile Picture</div>
                                <div class="card-body">
                                    <c:if test="${crew.photoId>0}">
                                        <img class="img-account-profile rounded mb-2" alt="img"
                                             src="data:image/jpeg;base64,${image}" alt="" id='preview'/>
                                        <input type='file' id='file-input' hidden name="image">
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 mb-6">
                            <!-- Billing card 2-->
                            <div class="card mb-6">
                                <div class="card-header">Overview</div>
                                <div class="card-body">
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">First name</div>
                                                <div class="text-xs text-muted">${crew.firstName}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Middle name</div>
                                                <div class="text-xs text-muted">${crew.middleName}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Last name</div>
                                                <div class="text-xs text-muted">${crew.lastName}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Marital Status</div>
                                                <div class="text-xs text-muted">${crew.maritalStatus}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Nationality</div>
                                                <div class="text-xs text-muted">${crew.nationalityFlag.name}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Rank</div>
                                                <div class="text-xs text-muted">${crew.rank.name}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Gender</div>
                                                <div class="text-xs text-muted">${crew.gender}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Distinguishing Mark</div>
                                                <div class="text-xs text-muted">${crew.distinguishingMark}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Nearest Airport</div>
                                                <div class="text-xs text-muted">${crew.nearestAirport}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Permanent Address</div>
                                                <div class="text-xs text-muted">${crew.permAddress}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Present Address</div>
                                                <div class="text-xs text-muted">${crew.presentAddress}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">EmailID</div>
                                                <div class="text-xs text-muted">${crew.emailId}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Contact#1</div>
                                                <div class="text-xs text-muted">${crew.contact1}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Contact#2</div>
                                                <div class="text-xs text-muted">${crew.contact2}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Date of Birth</div>
                                                <div class="text-xs text-muted">${crew.dob}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Height (cms)</div>
                                                <div class="text-xs text-muted">${crew.height}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Weight (kgs)</div>
                                                <div class="text-xs text-muted">${crew.weight}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Available From Date</div>
                                                <div class="text-xs text-muted">${crew.availableFromDate}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Status</div>
                                                <div class="text-xs text-muted">${crew.status.desc}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Manning Office</div>
                                                <div class="text-xs text-muted">${crew.manningOffice}</div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="ms-4">
                                                <div class="small">Passport Number</div>
                                                <div class="text-xs text-muted">${crew.passportNumber}</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 mb-4">
                            <!-- Billing card 3-->
                            <c:if test="${documents!=null}">

                                <div class="card mb-4">
                                    <div class="card-header">Documents</div>
                                    <div class="card-body p-0">
                                        <div class="table-responsive table-billing-history">
                                            <table class="table mb-0">
                                                <thead>
                                                <tr>
                                                    <th class="border-gray-200" scope="col">Document</th>
                                                    <th class="border-gray-200" scope="col">Number</th>
                                                    <th class="border-gray-200" scope="col">Issue Date</th>
                                                    <th class="border-gray-200" scope="col">Issue Place</th>
                                                    <th class="border-gray-200" scope="col">Expiry Date</th>
                                                    <th class="border-gray-200" scope="col">File</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:choose>
                                                    <c:when test="${fn:length(documents)>0}">
                                                        <c:forEach items="${documents}" var="doc">
                                                            <tr>
                                                                <td><label class="small mb-3">${doc.docType.name}</label>
                                                                </td>
                                                                <td><label class="small mb-3">${doc.docNumber}</label></td>
                                                                <td><label
                                                                        class="small mb-3">${doc.dateOfIssue.format( DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</label>
                                                                </td>
                                                                <td><label class="small mb-3">${doc.placeOfIssue}</label></td>
                                                                <td><label
                                                                        class="small mb-3">${doc.dateOfExpiry.format( DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</label>
                                                                </td>
                                                                <td>
                                                                    <c:if test="${doc.file!=null}">
                                                                        <a class="dropdown-item"
                                                                           href="/crew/document/download?documentId=${doc.id}">
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
                                                            <td colspan="6">No documents</td>
                                                        </tr>
                                                    </c:otherwise>
                                                </c:choose>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
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
