<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Crew Offer Letters :: ${crew.fileNum}</title>

    <%@ include file="../includes/header_includes.jsp" %>
    <script src="../js/crew/offer_letter.js"></script>
    <%@ include file="file_upload_header.jsp" %>

</head>

<body class="nav-fixed">
<%@ include file="../includes/top_nav_bar.jsp" %>

<div id="layoutSidenav">

    <%@ include file="../includes/sidebar.jsp" %>

    <div id="layoutSidenav_content">
        <main>
            <input type="hidden" id="crewId" name="crewId" value="${crewId}">
            <input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
            <input type="hidden" id="menu" value="${menu}">
            <input type="hidden" id="action" value="${action}">
            <%@ include file="crew_header.jsp" %>
            <!-- Main page content-->
            <div class="container-fluid px-4">
                <%@ include file="crew_menu.jsp" %>
                <hr class="mt-0 mb-4"/>
                <div class="row">
                    <div class="col-lg-1">
                        <div class="float-left">
                            <button class="btn btn-blue btn-icon float-end" type="button" data-bs-toggle="modal"
                                    data-bs-target="#newDocModal">
                                <i data-feather="plus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="col-lg-10">
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="table-responsive table-billing-history">
                                    <table class="table mb-0">
                                        <thead>
                                        <tr>
                                            <th class="border-gray-200" scope="col">Vessel Name</th>
                                            <th class="border-gray-200" scope="col">Rank</th>
                                            <th class="border-gray-200" scope="col">Agreed Wages</th>
                                            <th class="border-gray-200" scope="col">Contract Period</th>
                                            <th class="border-gray-200" scope="col">Status</th>
                                            <th class="border-gray-200" scope="col">Actions</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="doc">
                                            <tr>
                                                <td><label class="small mb-3">${doc.vesselName}</label></td>
                                                <td><label class="small mb-3">${doc.agreedRank.name}
                                                    (${doc.agreedRank.shortName})</label></td>
                                                <td><label class="small mb-3">${doc.agreedWages}</label></td>
                                                    <%--<td><label class="small mb-3">${doc.dateOfIssue.format( DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</label></td>
                                                    <td><label class="small mb-3">${doc.dateOfExpiry.format( DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</label></td>--%>
                                                <td><label
                                                        class="small mb-3">${doc.contractPeriod.duration} ${doc.contractPeriod.durationType.typeName}</label>
                                                </td>
                                                <td><div class="ms-4">${doc.status.icon}</div></td>
                                                <td>
                                                    <c:if test="${doc.file!=null}">
                                                        <a class="dropdown-item"
                                                           href="/crew/document/download?action=download&documentId=${doc.id}">
                                                            <div class="page-header-icon"><i data-feather="file"></i>
                                                            </div>
                                                        </a>
                                                    </c:if>
                                                    <button class="btn btn-primary"
                                                            onclick="Offer_Letter.approveOfferModal(${doc.id})"
                                                            type="button">Approve/Reject
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
            </div>


        </main>
        <%@ include file="../includes/copyright.jsp" %>
    </div>

</div>

<%@ include file="../includes/bottom_includes.jsp" %>
<div class="modal fade" id="newDocModal" tabindex="-1" role="dialog" aria-labelledby="newDocModalLabel"
     style="display: none;" aria-hidden="true">

    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add New Offer Letter</h5>
                <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container-xl px-4">
                    <div class="row justify-content-center">
                        <form role="form" method="POST" enctype="multipart/form-data" action="/crew/offer/add">
                            <input type="hidden" name="menu" value="${menu}">
                            <input type="hidden" name="sMenu" value="${sMenu}">
                            <input type="hidden" name="crewId" value="${crewId}">
                            <input type="hidden" name="docTypeId" value="${offerLetterDT.id}">
                            <div class="row gx-3 mb-3">
                                <label class="small mb-3" for="vesselId">Select a Vessel</label>
                                <select class="form-select" aria-label="Default select example" id="vesselId"
                                        name="vesselId">
                                    <option selected disabled>Select a Vessel:</option>
                                    <c:forEach items="${vessels}" var="vessel">
                                        <option value="${vessel.id}">${vessel.vesselOwner.ownerName}
                                            - ${vessel.vesselName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="row gx-3 mb-3">
                                <label class="small mb-1" for="rankId">Rank Name</label>
                                <select class="form-select" id="rankId" name="rankId" aria-label="Default select rank">
                                    <option selected disabled>Select a Rank:</option>
                                    <c:forEach var="optionGroup" items="${rankMap}">
                                        <optgroup label="${optionGroup.key}">
                                            <c:forEach var="option" items="${optionGroup.value}">
                                                <option value="${option.id}">${option.name}
                                                    (${option.rankSubCategory.name})
                                                </option>
                                            </c:forEach>
                                        </optgroup>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="row gx-3 mb-3">
                                <label class="small mb-1" for="agreedWages">Wages</label>
                                <input class="form-control" id="agreedWages" name="agreedWages" type="text"
                                       placeholder="Enter Wage"/>
                            </div>
                            <div class="mb-3">
                                <label class="small mb-1" for="durationTypeId">Duration</label>
                                <select class="form-select" aria-label="Default select example" id="durationTypeId"
                                        name="durationTypeId">
                                    <option selected disabled>Select a Duration:</option>
                                    <c:forEach items="${durationTypes}" var="durationType">
                                        <option value="${durationType.id}">${durationType.typeName}</option>
                                    </c:forEach>
                                </select>
                                <input class="form-control" name="durationValue" id="durationValue" type="text"
                                       placeholder="Enter Duration Value"/>
                            </div>
                            <button class="btn btn-primary" type="submit">Add Offer Letter</button>
                        </form>
                    </div>
                </div>


            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="approveOfferModal" tabindex="-1" role="dialog" aria-labelledby="approveOfferModalLabel"
     style="display: none;" aria-hidden="true">

</div>

</body>

</html>
