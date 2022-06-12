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
    <title>Crew Personal :: <c:choose><c:when
            test="${action=='add'}">Add</c:when><c:otherwise>${crew.fileNum}</c:otherwise></c:choose></title>

    <%@ include file="../includes/header_includes.jsp" %>
    <script src="../js/vessel/vessel_details.js"></script>
</head>

<body class="nav-fixed">
<%@ include file="../includes/top_nav_bar.jsp" %>
       
       
        <div id="layoutSidenav">
        
        <%@ include file="../includes/sidebar.jsp" %>
            
            <div id="layoutSidenav_content">
                <main>
                <c:choose>
                    <c:when test="${vessel!=null && vessel.id > 0}">
                        <form method="POST" enctype="multipart/form-data" action="/vessel/update_vessel_details">
                    </c:when>
                    <c:otherwise>
                        <form method="POST" enctype="multipart/form-data" action="/vessel/add_vessel">
                    </c:otherwise>
                </c:choose>

                <input type="hidden" name="vesselId" value="${vessel.id}"/>

                <%@ include file="vessel_header.jsp" %>
                    
                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <%@ include file="vessel_menu.jsp" %>
                        <hr class="mt-0 mb-4" />
                        <div class="row">
                            <div class="col-xl-2">
                                <!-- Profile picture card-->
                                <div class="card mb-2 mb-xl-0">
                                    <div class="card-header">Vessel Picture</div>
                                    <div class="card-body text-center">
										<!-- Profile picture image-->
										 <img class="img-account-profile rounded-circle mb-2"
											src="../assets/img/illustrations/profiles/ship-1.png"
											alt="" id='preview'/> 
											
											<input type='file' id='file-input' hidden name="image">																						
											
										<div id='container'>
											<!-- Profile picture help block-->
											<div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
											<!-- Profile picture upload button-->
											<button id="myBtn" class="btn btn-primary" type="button">Upload an image</button>
											
										</div>
									
								</div>
                                </div>
                            </div>
                            <div class="col-xl-10">
                                <!-- Account details card-->
                                <div class="card mb-6">
                                    <div class="card-header">Add Vessel Profile</div>
                                    <div class="card-body">
                                        <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="vesselName">Vessel Name</label>
                                                    <input class="form-control" name="vesselName" type="text" placeholder="Enter vessel name" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="imo">Vessel Owner</label>
                                                    <select class="form-select" aria-label="Default select example" name="vesselOwnerId">
														<option selected disabled>Select Owner of this Vessel:</option>
														<c:forEach items="${vesselOwners}" var="owner">
															<option <c:if test="${vesselOwnerId == owner.id}">selected="true"</c:if> value="${owner.id}">${owner.ownerName}</option>
														</c:forEach>
												</select>
                                                </div>
                                               
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                 <label class="small mb-1" for="callSign">CallSign</label>
                                                 <input class="form-control" name="callSign" type="text" placeholder="Enter call sign" value="" />
                                          		 </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="imo">IMO</label>
                                                    <input class="form-control" name="imo" type="text" placeholder="Enter IMO" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="mmsi">MMSI</label>
                                                    <input class="form-control" name="mmsi" type="text" placeholder="Enter MMSI" value="" />
                                                </div>
                                            </div>
										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												<label class="small mb-1" for="flag">Flag</label>
												<select class="form-select" aria-label="Default select example" name="flag">
													<option selected disabled>Select a Flag:</option>
													<c:forEach items="${flags}" var="flag">
															<option value="${flag.code}">${flag.name}</option>
													</c:forEach>
												</select>
											</div>											
<%-- 											<div class="col-md-4">
												<label class="small mb-1" for="vesselTypeId">Vessel Type</label>
												<select class="form-select" aria-label="Default select example" name="vesselTypeId">
													<option selected disabled>Select a Type:</option>
													<c:forEach items="${vesselTypes}" var="vesselType">
														<option value="${vesselType.typeId}">${vesselType.desc}</option>
													</c:forEach>
												</select>
											</div>
 --%>											<div class="col-md-4">
												<label class="small mb-1" for="vesselSubTypeId">Vessel Type</label>
												<select class="form-select" aria-label="Default select example" name="vesselSubTypeId">
													<option selected disabled>Select a Sub-Type:</option>
													<c:forEach var="optionGroup" items="${vesselSubTypeMap}">
												       <optgroup label="${optionGroup.key}">
												       <c:forEach var="option" items="${optionGroup.value}">
												          <option value="${option.id}">${option.desc}</option>                             
												       </c:forEach>                                                          
												       </optgroup>
												    </c:forEach>
												</select>
											</div>
										</div>
										<div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="length">Length Overall (m)</label>
                                                    <input class="form-control" id="length" name="length" type="text" placeholder="Enter Overall Lenth in meters" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="beam">Beam (m)</label>
                                                    <input class="form-control" id="beam" name="beam" type="text" placeholder="Enter Beam length in meters" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="draught">Draught (m)</label>
                                                    <input class="form-control" id="draught" name="draught" type="text" placeholder="Enter Draught length in meters" value="" />
                                                </div>                                                
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="yearOfBuilt">Year of Built</label>
                                                    <input class="form-control" id="yearOfBuilt" name="yearOfBuilt" type="text" placeholder="Enter Gross Tonnage" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="length">Home-Port</label>
                                                    <select class="form-select" aria-label="Select a Home-Port" name="homeport">
														<option selected disabled>Select a Home-Port</option>
														<c:forEach items="${ports}" var="port">
															<option value="${port.refcode}">${port.name}, ${port.country} (${port.refcode})</option>
														</c:forEach>
													</select>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="grossTon">Gross Tonnage</label>
                                                    <input class="form-control" name="grossTon" type="text" placeholder="Enter vessel name" value="" />
                                                </div>
                                            </div>
										<div class="row gx-3 mb-3">
											
											<div class="col-md-4">
												Vessel Description <i class="text-muted" data-feather="info"
													data-bs-toggle="tooltip" data-bs-placement="left"
													title="The post preview text shows below the post title, and is the post summary on blog pages."></i>
												<textarea class="lh-base form-control" type="text" name="vesselDesc" placeholder="" rows="4"></textarea>
											</div>											
										</div>
										<!-- Save changes button-->
                                            <button class="btn btn-primary" type="submit">Next</button>
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
