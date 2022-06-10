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
    <title>Crew Documents :: ${crew.fileNum}</title>

    <%@ include file="../includes/header_includes.jsp" %>
    <script src="../js/crew/crew_documents.js"></script>
    <%@ include file="file_upload_header.jsp" %>

</head>

<body class="nav-fixed">
<%@ include file="../includes/top_nav_bar.jsp" %>

<div id="layoutSidenav">

    <%@ include file="../includes/sidebar.jsp" %>

    <div id="layoutSidenav_content">
        <main>
            <input type="hidden" id="crewId" name="crewId" value="${crew.id}">
            <input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
            <input type="hidden" id="menu" value="${menu}">
            <input type="hidden" id="action" value="${action}">
            <%@ include file="crew_header.jsp" %>
            <!-- Main page content-->
            <div class="container-fluid px-4">
                <%@ include file="add_crew_menu.jsp" %>
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
                                            <th class="border-gray-200" scope="col">Document</th>
                                            <th class="border-gray-200" scope="col">Number</th>
                                            <th class="border-gray-200" scope="col">Issue Date</th>
                                            <th class="border-gray-200" scope="col">Place of Issue</th>
                                            <th class="border-gray-200" scope="col">Expiry Date</th>
                                            <th class="border-gray-200" scope="col">Upload</th>
                                            <th class="border-gray-200" scope="col">Maker</th>
                                            <th class="border-gray-200" scope="col">Reviewer</th>
                                            <th class="border-gray-200" scope="col">Audit</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="doc">
                                            <tr>
                                                <td><label class="small mb-3">${doc.docType.name}</label>
                                                    <c:if test="${doc.file!=null}">
                                                        <a class="dropdown-item"
                                                           href="/crew/document/download?documentId=${doc.id}">
                                                            <div class="page-header-icon"><i data-feather="file"></i>
                                                            </div>
                                                        </a>
                                                    </c:if>
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
                                                    <button class="btn btn-primary" type="button"
                                                            onclick="CrewDocument.openFileUploadModal('${doc.id}','${doc.docName}','${doc.docType.id}');">
                                                        Upload
                                                    </button>
                                                </td>
                                                <td><label class="small mb-3" for="makerBy" data-bs-toggle="tooltip"
                                                           data-bs-placement="top"
                                                           title="${exDoc.fieldStatus.makerDateTime}">${exDoc.fieldStatus.makerBy}</label>
                                                </td>
                                                <td>
                                                    <div class="form-check mb-3">
                                                        <input class="form-check-input" id="checkFirstName"
                                                               type="checkbox"/>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="page-header-icon"><i data-feather="user-plus"></i></div>
                                                    <div class="page-header-icon"><i data-feather="user-plus"></i></div>
                                                    <!-- <span class="badge bg-success">Paid</span> -->
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
<div class="modal fade" id="newDocModal" tabindex="-1" role="dialog" aria-labelledby="newNOKModalLabel"
     style="display: none;" aria-hidden="true">

    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add New Document</h5>
                <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container-xl px-4">
                    <div class="row justify-content-center">
                        <form>
                            <div class="row gx-3 mb-3">
                                <label class="small mb-3" for="documentPool">Select a Pool</label>
                                <select class="form-select" aria-label="Default select example" id="documentPool" name="documentPool">
                                    <option selected disabled>Select Pool:</option>
                                    <c:forEach items="${documentPools}" var="docPool">
                                        <option value="${docPool.name}">${docPool.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="row gx-3 mb-3">
                                <label class="small mb-3" for="documentPool">Select a Flag</label>
                                <select class="form-select" aria-label="Default select example" id="nationalityFlagCode" name="nationalityFlagCode">
                                    <option selected disabled>Select Nationality Flag:</option>
                                    <c:forEach items="${flags}" var="flag">
                                        <option value="${flag.code}">${flag.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="row gx-3 mb-3">
                                <label class="small mb-1" for="docTypeName">Document Type</label>
                                <input class="form-control" name="docTypeName" type="text" placeholder="Enter Doc Type Name" value="" />

                            </div>
                            <div class="row gx-3 mb-3">
                                <label class="small mb-1" for="docTypeDesc">Document Type Description</label>
                                <textarea class="form-control" name="docTypeDesc" type="text" placeholder="Enter Doc Type Description" value="" />
                            </div>
                            <!-- Form Group (username)-->
                            <div class="mb-3">
                                <label class="small mb-1" for="inputUsername">Given Name (how it appears on the document
                                    )</label>
                                <input class="form-control" id="inputUsername" type="text"
                                       placeholder="Enter your username" value="username"/>
                            </div>
                            <!-- Form Row-->
                            <div class="row gx-3 mb-3">
                                <!-- Form Group (first name)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputFirstName">First name</label>
                                    <input class="form-control" id="inputFirstName" type="text"
                                           placeholder="Enter your first name" value="Valerie"/>
                                </div>
                                <!-- Form Group (last name)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputLastName">Last name</label>
                                    <input class="form-control" id="inputLastName" type="text"
                                           placeholder="Enter your last name" value="Luna"/>
                                </div>
                            </div>
                            <!-- Form Row        -->
                            <div class="row gx-3 mb-3">
                                <!-- Form Group (organization name)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputOrgName">Organization name</label>
                                    <input class="form-control" id="inputOrgName" type="text"
                                           placeholder="Enter your organization name" value="Start Bootstrap"/>
                                </div>
                                <!-- Form Group (location)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputLocation">Location</label>
                                    <input class="form-control" id="inputLocation" type="text"
                                           placeholder="Enter your location" value="San Francisco, CA"/>
                                </div>
                            </div>
                            <!-- Form Group (email address)-->
                            <div class="mb-3">
                                <label class="small mb-1" for="inputEmailAddress">Email address</label>
                                <input class="form-control" id="inputEmailAddress" type="email"
                                       placeholder="Enter your email address" value="name@example.com"/>
                            </div>
                            <!-- Form Row-->
                            <div class="row gx-3 mb-3">
                                <!-- Form Group (phone number)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputPhone">Phone number</label>
                                    <input class="form-control" id="inputPhone" type="tel"
                                           placeholder="Enter your phone number" value="555-123-4567"/>
                                </div>
                                <!-- Form Group (birthday)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputBirthday">Birthday</label>
                                    <input class="form-control" id="inputBirthday" type="text" name="birthday"
                                           placeholder="Enter your birthday" value="06/10/1988"/>
                                </div>
                            </div>

                            <div class="row gx-3 mb-3">
                                <h1>Upload any File</h1>
                                <SECTION>
                                    <DIV id="dropzone">
                                        <%--<FORM class="dropzone" class="dropzone" id="my-great-dropzone" action="/crew/addDoc">--%>
                                            <input type="hidden" name="crewId" value="${crew.id}">
                                            <input type="hidden" id="docId" name="docId">
                                            <DIV class="dz-message">
                                                Drop files here or click to upload.
                                            </DIV>
                                        <%--</FORM>--%>
                                    </DIV>
                                </SECTION>

                                <br/>
                                <hr size="3" noshade color="#F00000">

                                <div style="font-size: 0.8em;">
                                </div>
                                <DIV id="preview-template" style="display: none;">
                                    <div class="dz-preview dz-file-preview">
                                        <div class="dz-details">
                                            <div class="dz-filename"><span data-dz-name></span></div>
                                            <div class="dz-size" data-dz-size></div>
                                            <img data-dz-thumbnail/>
                                        </div>
                                        <div class="dz-progress"><span class="dz-upload" data-dz-uploadprogress></span></div>
                                        <div class="dz-success-mark"><span>✔</span></div>
                                        <div class="dz-error-mark"><span>✘</span></div>
                                        <div class="dz-error-message"><span data-dz-errormessage></span></div>
                                    </div>
                                </div>
                            </div>
                            <button class="btn btn-primary" type="button">Add Document</button>
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

<!-- Modal -->
<div class="modal fade" id="fileUploaderModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="fileUploaderModalTitle">Vertically Centered Modal</h5>
                <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h1>Upload any File</h1>
                <SECTION>
                    <DIV id="dropzone">
                        <FORM class="dropzone" class="dropzone" id="my-great-dropzone" action="/crew/addDoc">
                            <input type="hidden" name="crewId" value="${crew.id}">
                            <input type="hidden" id="docId" name="docId">
                            <DIV class="dz-message">
                                Drop files here or click to upload.
                            </DIV>
                        </FORM>
                    </DIV>
                </SECTION>

                <br/>
                <hr size="3" noshade color="#F00000">

                <div style="font-size: 0.8em;">
                </div>
                <DIV id="preview-template" style="display: none;">
                    <div class="dz-preview dz-file-preview">
                        <div class="dz-details">
                            <div class="dz-filename"><span data-dz-name></span></div>
                            <div class="dz-size" data-dz-size></div>
                            <img data-dz-thumbnail/>
                        </div>
                        <div class="dz-progress"><span class="dz-upload" data-dz-uploadprogress></span></div>
                        <div class="dz-success-mark"><span>✔</span></div>
                        <div class="dz-error-mark"><span>✘</span></div>
                        <div class="dz-error-message"><span data-dz-errormessage></span></div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

</body>

</html>
