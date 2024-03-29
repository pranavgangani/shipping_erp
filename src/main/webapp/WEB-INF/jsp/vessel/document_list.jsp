<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Vessel Document List</title>
    
        <%@ include file="../includes/header_includes.jsp" %>
        <script src="../js/vessel/vessel_documents.js"></script>
        <%@ include file="file_upload_header.jsp" %>

    </head>

    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>
       
       
        <div id="layoutSidenav">
        
        <%@ include file="../includes/sidebar.jsp" %>
            
            <div id="layoutSidenav_content">
                <main>


                                <%@ include file="vessel_header.jsp" %>

                                    <!-- Main page content-->
                                    <div class="container-fluid px-4">
                                        <!-- Account page navigation-->
                                        <nav class="nav nav-borders">
                                            <a class="nav-link" href="/vessel/vessel_details?action=modify&vesselId=${vessel.id}">Profile</a>
                                            <a class="nav-link active ms-0">Documents</a>
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
                                                        <c:when test="${vessel.photoId>0}">
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
                		                                            </tr>
                		                                        </thead>
                		                                        <tbody>
                		                                            <c:forEach items="${list}" var="doc">
                		                                            <tr>
                		                                                <td><label class="small mb-3">${doc.docName}</label>
                		                                                    <table class="table mb-0">
                                                                                    <thead>
                                                                                        <tr>
                                                                                            <th class="border-gray-200" scope="col">Versions</th>
                                                                                            <th class="border-gray-200" scope="col">Maker</th>
                                                                                            <th class="border-gray-200" scope="col">Reviewer</th>
                                                                                            <th class="border-gray-200" scope="col">Audit</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                    <c:forEach items="${existingDocuments}" var="exDoc">
                                                                                            <c:if test="${doc.id == exDoc.id}">

                                                                                            <tr>

                                                                                            <td>
                                                                                            <c:if test="${exDoc.fileTitle!=null}">

                                                                                            <a href="#" id="pop">
                                                                                                <img style="width:0px; height:0px;" id="imageresource" src="data:image/jpeg;base64,${exDoc.fileTitle}">
                                                                                               <i data-feather="eye"></i>
                                                                                            </a>

                                                                                                <!-- Creates the bootstrap modal where the image will appear -->
                                                                                                <div class="modal fade" id="imagemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                                                                  <div class="modal-dialog">
                                                                                                    <div class="modal-content">
                                                                                                      <div class="modal-header">
                                                                                                      <h5 class="modal-title" id="fileUploaderModalTitle">${exDoc.docName}</h5>
                                                                                                      <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                                  </div>
                                                                                                  <div class="modal-body">
                                                                                                      </div>
                                                                                                      <div class="modal-body">
                                                                                                       <img src="" id="imagepreview" style="width: 100%;" >
                                                                                                      </div>
                                                                                                      <div class="modal-footer">
                                                                                                        <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                                      </div>
                                                                                                    </div>
                                                                                                  </div>
                                                                                                </div>
                                                                                                 </c:if>
                                                                                             </td>

                                                                 <td><label class="small mb-3" for="makerBy" data-bs-toggle="tooltip" data-bs-placement="top" title="${exDoc.fieldStatus.makerDateTime}">${exDoc.fieldStatus.makerBy}</label>
                            		                                                </td>
                            		                                                <td>
                            			                                                <div class="form-check mb-3">
                            	                                                    		<input class="form-check-input" id="checkFirstName" type="checkbox" />
                            	                                                		</div>
                                                                            		</td>
                            		                                                <td>
                            		                                                	 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
                            		                                               		 <div class="page-header-icon"><i data-feather="user-plus"></i></div>
                            		                                                <!-- <span class="badge bg-success">Paid</span> -->
                            														</td>
                                                                                                    </tr>

                                                                                             </c:if>

                                                                                    </c:forEach>

                                                                                    </tbody>
                                                                                 </table>

                		                                                </td>
                		                                                <td>

                			                                              <button class="btn btn-primary" type="button" onclick="VesselDocument.openFileUploadModal('${doc.id}','${doc.docName}','${doc.docTypeId}');">Upload</button>

                		                                                </td>
                		                                            </tr>
                		                                            </c:forEach>
                		                                        </tbody>
                		                                    </table>
                		                                </div>
                                                    </div>
                                                </div>
                                               <c:if test="${action == 'Edit'}">
                                                   <div class="card mb-4">
                                                       <div class="card-header">Audit Trail</div>
                                                       <div class="card-body">
                                                           <div class="timeline timeline-xs">
                                                               <c:forEach items="${auditTrails}" var="audit">
                                                                   <div class="timeline-item">
                                                                       <div class="timeline-item-marker">
                                                                           <div class="timeline-item-marker-text">${audit.ago}</div>
                                                                           <div class="timeline-item-marker-indicator bg-${audit.colour}"></div>
                                                                       </div>
                                                                       <div class="timeline-item-content">
                                                                           ${audit.text}
                                                                       </div>
                                                                    </div>
                                                              </c:forEach>
                                                       </div>
                                                       </c:if>

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
               <FORM class="dropzone" class="dropzone" id="my-great-dropzone"action="/vessel/document_details">
               <input type="hidden" name="vesselId" value="${vessel.id}">
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
            </div>
        </div>
    </div>

</body>

</html>
