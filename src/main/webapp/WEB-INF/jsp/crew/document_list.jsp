<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Document List</title>
    
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
                                <form method="POST" enctype="multipart/form-data" action="">

                                <%@ include file="add_crew_header.jsp" %>

                                    <!-- Main page content-->
                                    <div class="container-fluid px-4">
                                        <!-- Account page navigation-->
                                        <nav class="nav nav-borders">
                                            <a class="nav-link">Profile</a>
                                            <a class="nav-link" href="/crew/add_employment">Employment</a>
                                            <a class="nav-link" href="/crew/add_education">Education</a>
                                            <a class="nav-link" href="/crew/add_passport_visa">Passport/Visa</a>
                                            <a class="nav-link" href="/crew/add_medical">Medical</a>
                                            <a class="nav-link" href="/crew/add_bank_account">Bank Account</a>
                                            <a class="nav-link" href="/crew/add_nominee">Next of Kin</a>
                                            <a class="nav-link active ms-0">Other Documents</a>
                                        </nav>
                                        <hr class="mt-0 mb-4" />
                                        <div class="row">
                                        <div class="col-lg-2">
                                            <!-- Two factor authentication card-->
                                            <div class="card mb-4">
                                                <div class="card-header">Profile Picture</div>
                                                <div class="card-body">
                                                    <!-- Profile picture help block-->
                                                    <c:choose>
                                                        <c:when test="${crew.photoId>0}">
                                                            <img class="img-account-profile rounded-circle mb-2" alt="img" src="data:image/jpeg;base64,${image}" alt="" id='preview' />
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img class="img-account-profile rounded-circle mb-2"
                                                                src="../assets/img/illustrations/profiles/profile-1.png"
                                                                alt="" id='preview' />
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                    </div>
                                            </div>
                                            <div class="col-lg-10">
                                                <!-- Change password card-->
                                                <div class="card mb-4">
                                                    <div class="card-body">
                                                        <div class="table-responsive table-billing-history">
                		                                    <table class="table mb-0">
                		                                        <thead>
                		                                            <tr>
                		                                                <th class="border-gray-200" scope="col">Mandatory Docs</th>
                		                                                <th class="border-gray-200" scope="col">Upload</th>
                		                                                <th class="border-gray-200" scope="col">Maker</th>
                		                                                <th class="border-gray-200" scope="col">Reviewer</th>
                		                                                <th class="border-gray-200" scope="col">Audit</th>
                		                                            </tr>
                		                                        </thead>
                		                                        <tbody>
                		                                            <c:forEach items="${list}" var="doc">
                		                                            <tr>
                		                                                <td><label class="small mb-3">${doc.docName}</label></td>
                		                                                <td>
                			                                                <button class="btn btn-primary" type="button" onclick="CrewDocument.openFileUploadModal('${doc.id}','${doc.docName}','${doc.docTypeId}');">Upload</button>

                		                                                </td>
                		                                                <td><label class="small mb-3" for="fName">IND3289</label></td>
                		                                                <td>
                			                                                <div class="form-check mb-3">
                	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" checked />
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
                                                <!-- Security preferences card-->
                                                <div class="card mb-4">
                                                    <div class="card-header">Audit Trail</div>
                                                    <div class="card-body">
                                                        <div class="timeline timeline-xs">
                										<!-- Timeline Item 1-->
                										<div class="timeline-item">
                											<div class="timeline-item-marker">
                												<div class="timeline-item-marker-text">27 min</div>
                												<div class="timeline-item-marker-indicator bg-green"></div>
                											</div>
                											<div class="timeline-item-content">
                												New order placed! <a class="fw-bold text-dark" href="#!">Order
                													#2912</a> has been successfully placed.
                											</div>
                										</div>
                										<!-- Timeline Item 2-->
                										<div class="timeline-item">
                											<div class="timeline-item-marker">
                												<div class="timeline-item-marker-text">58 min</div>
                												<div class="timeline-item-marker-indicator bg-blue"></div>
                											</div>
                											<div class="timeline-item-content">
                												Your <a class="fw-bold text-dark" href="#!">weekly
                													report</a> has been generated and is ready to view.
                											</div>
                										</div>
                										<!-- Timeline Item 3-->
                										<div class="timeline-item">
                											<div class="timeline-item-marker">
                												<div class="timeline-item-marker-text">2 hrs</div>
                												<div class="timeline-item-marker-indicator bg-purple"></div>
                											</div>
                											<div class="timeline-item-content">
                												New user <a class="fw-bold text-dark" href="#!">Valerie
                													Luna</a> has registered
                											</div>
                										</div>
                										<!-- Timeline Item 4-->
                										<div class="timeline-item">
                											<div class="timeline-item-marker">
                												<div class="timeline-item-marker-text">1 day</div>
                												<div class="timeline-item-marker-indicator bg-yellow"></div>
                											</div>
                											<div class="timeline-item-content">Server activity
                												monitor alert</div>
                										</div>
                										<!-- Timeline Item 5-->
                										<div class="timeline-item">
                											<div class="timeline-item-marker">
                												<div class="timeline-item-marker-text">1 day</div>
                												<div class="timeline-item-marker-indicator bg-green"></div>
                											</div>
                											<div class="timeline-item-content">
                												New order placed! <a class="fw-bold text-dark" href="#!">Order
                													#2911</a> has been successfully placed.
                											</div>
                										</div>
                										<!-- Timeline Item 6-->
                										<div class="timeline-item">
                											<div class="timeline-item-marker">
                												<div class="timeline-item-marker-text">1 day</div>
                												<div class="timeline-item-marker-indicator bg-purple"></div>
                											</div>
                											<div class="timeline-item-content">
                												Details for <a class="fw-bold text-dark" href="#!">Marketing
                													and Planning Meeting</a> have been updated.
                											</div>
                										</div>
                										<!-- Timeline Item 7-->
                										<div class="timeline-item">
                											<div class="timeline-item-marker">
                												<div class="timeline-item-marker-text">2 days</div>
                												<div class="timeline-item-marker-indicator bg-green"></div>
                											</div>
                											<div class="timeline-item-content">
                												New order placed! <a class="fw-bold text-dark" href="#!">Order
                													#2910</a> has been successfully placed.
                											</div>
                										</div>
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

<!-- Modal -->
<div class="modal fade" id="fileUploaderModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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
               <FORM class="dropzone" class="dropzone" id="my-great-dropzone"action="/crew/addDoc">
               <input type="hidden" name="crewId" value="29">
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
            		<img data-dz-thumbnail />
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
                <button class="btn btn-primary" type="button">Save changes</button></div>
            </div>
    </div>
</div>
    </body>

</html>
