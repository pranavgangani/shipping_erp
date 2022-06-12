<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>${action} Crew</title>
    
        <%@ include file="../includes/header_includes.jsp" %>
        <script src="../js/crew/contract_details.js"></script>
    </head>

    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>
       
       
        <div id="layoutSidenav">
        
        <%@ include file="../includes/sidebar.jsp" %>
            
            <div id="layoutSidenav_content">
                <main>
                <form id="crew-details-form" role="form" method="POST" enctype="multipart/form-data" action="/crew/generateContract?crewId=${crewId}">
                <input type="hidden" id="crewId" name="crewId" value="${crew.id}">

                    <!-- Main page content-->
                    <div class="container-fluid px-4">
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
											    <input type='file' id='file-input' hidden name="image">
												<img class="img-account-profile rounded-circle mb-2"
													src="../assets/img/illustrations/profiles/profile-1.png"
													alt="" id='preview' />
												<div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
											</c:otherwise>
										</c:choose>
										<!-- Profile picture upload button-->
										<button id="myBtn" class="btn btn-primary" type="button">Upload an image</button>

                                    </div>
                                </div>
                                <!-- Delete account card-->
                                <div class="card mb-4">
                                    <div class="card-header">Actions</div>
                                    <div class="card-body">
                                    <c:choose>
                                        <c:when test="${action == 'modify'}"><button class="btn btn-primary" type="submit">Save</button></c:when>
                                        <c:otherwise><button class="btn btn-primary" type="submit">Add New Contract</button></c:otherwise>
                                    </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-10">
                                <div class="card mb-4">
                                    <div class="card-header">Contract</div>
                                    <div class="card-body">
                                        <table class="table mb-0">
                                            <tbody>
                                            <tr>
                                                <td><h6 class="mb-1">Name & Registerd Office of Employer</h6></h6></td>
                                                <td><div class="col-md-10 mb-3">dasdjlksajdjaslkdjlksajld</div></td>
                                                <td><h6 class="mb-1">Name & Registerd Office of Shipowner</h6></td>
                                                <td><div class="col-md-10 mb-3">${vessel.vesselOwner.primaryAddress}</div></td>
                                            </tr>
                                            <tr>
                                                <td><h6 class="mb-1">Full name & address of Seafarer</h6></td>
                                                <td><div class="col-md-10 mb-3">${crew.presentAddress}</div></td>
                                                 <td><h6 class="mb-1">Rank</h6></td>
                                                <td><div class="col-md-10 mb-3">${crew.rank.name}</div></td>
                                            </tr>
                                            <tr>
                                                <td><h6 class="mb-1">Name of Vessel</h6></td>
                                                <td><div class="col-md-10 mb-3">${vessel.vesselName}</div></td>
                                                <td><h6 class="mb-1">Vessel Type</h6></td>
                                                <td><div class="col-md-10 mb-3">${vessel.vesselSubType.desc}</div></td>
                                            </tr>
                                            <tr>
                                                <td><h6 class="mb-1">Home Port</h6></td>
                                                <td><div class="col-md-10 mb-3">${vessel.homePort}</div></td>
                                                <td><h6 class="mb-1">IMO Number</h6></td>
                                                <td><div class="col-md-10 mb-3">${vessel.imo}</div></td>
                                            </tr>
                                        <tr>
                                            <td><h6 class="mb-1">Date of Birth</h6></td>
                                            <td>
                                                <div class="col-md-10 mb-3">${crew.dob.format( DateTimeFormatter.ofPattern("dd-MMM-yyyy"))}</div>
                                            </td>
                                            <td><h6 class="mb-1">Nationality</h6></td>
                                            <td>
                                                <div class="col-md-10 mb-3">${crew.nationalityFlag.name}</div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><h6 class="mb-1">Place of Birth</h6></td>
                                            <td>
                                                <div class="col-md-10 mb-3">${crew.placeOfBirth}</div>
                                            </td>
                                            <td><h6 class="mb-1">Marital Status</h6></td>
                                            <td>
                                                <div class="col-md-10 mb-3">${crew.maritalStatus}</div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><h6 class="mb-1">Passport</h6></td>
                                            <td>
                                                <div class="col-md-10 mb-3">${crew.passportNumber}</div>
                                            </td>
                                            <td><h6 class="mb-1">Expiration</h6></td>
                                            <td>
                                                <div class="col-md-10 mb-3">${crew.passportExpirationDate}</div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><h6 class="mb-1">Seamans Book</h6></td>
                                            <td>
                                                <div class="col-md-10 mb-3">${crew.indosNumber}</div>
                                            </td>
                                            <td><h6 class="mb-1">Expiration</h6></td>
                                            <td>
                                                <div class="col-md-10 mb-3">${crew.indosExpirationDate}</div>
                                            </td>
                                        </tr>
                                        <tr>

                                        <tr>
                                             <td colspan="4">
                                                <h6 class="mb-4">Next of Kin(s)</h6>
                                                <div class="col-md-10 mb-3">
                                                <table>
                                                    <c:forEach items="${crew.nextOfKins}" var="nok">
                                                        <tr>
                                                            <td>
                                                               <div class="col-md-10 mb-3">${nok.nomineeName}</div>
                                                           </td>
                                                           <td>
                                                               <div class="col-md-10 mb-3">(${nok.relationType})</div>
                                                           </td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                                </div>
                                             </td>
                                         </tr>
                                         <tr>
                                             <td><h6 class="mb-1">Begin Date</h6></td>
                                             <td>
                                                 <div class="col-md-10 mb-3"><input type="text" id="embarkDate" name="embarkDate"></div>
                                             </td>
                                             <td><h6 class="mb-1">Port Embarkment</h6></td>
                                             <td>
                                                 <div class="col-md-10 mb-3"><input type="text" id="embarkPort" name="embarkPort"></div>
                                             </td>
                                         </tr>
                                         <tr>
                                              <td><h6 class="mb-1">Monthly Wage</h6></td>
                                              <td>
                                                  <div class="col-md-10 mb-3"><input type="text" id="wage" name="wage"></div>
                                              </td>
                                              <td><h6 class="mb-1">Length of Service</h6></td>
                                              <td>
                                                  <div class="col-md-10 mb-3"><input type="text" id="serviceLength" name="serviceLength">
                                                    <select name="serviceLengthType" id="serviceLengthType">
                                                        <option value="day">Days</option>
                                                        <option value="week">Weeks</option>
                                                        <option value="month">Month</option>
                                                        <option value="year">Year</option>
                                                    </select>
                                                  </div>
                                              </td>
                                          </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <c:if test="${action == 'modify'}">
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
