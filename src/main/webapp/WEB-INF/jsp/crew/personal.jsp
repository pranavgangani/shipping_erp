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
    <script src="../js/crew/crew_details.js"></script>
</head>

<body class="nav-fixed">
<%@ include file="../includes/top_nav_bar.jsp" %>


<div id="layoutSidenav">

    <%@ include file="../includes/sidebar.jsp" %>

    <div id="layoutSidenav_content">
        <main>
            <c:if test="${action == 'add'}"><form id="crew-details-form" role="form" method="POST" enctype="multipart/form-data" action="/crew/add"></c:if>
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
                        <div class="col-lg-2">
                            <div class="card mb-4">
                                <div class="card-header">Profile Picture</div>
                                <div class="card-body">
                                    <!-- Profile picture help block-->
                                    <c:choose>
                                        <c:when test="${crew.photoId>0}">
                                            <img class="img-account-profile rounded mb-2" alt="img"
                                                 src="data:image/jpeg;base64,${image}" alt="" id='preview'/>
                                            <input type='file' id='file-input' hidden name="image">
                                        </c:when>
                                        <c:otherwise>
                                            <input type='file' id='file-input' hidden name="image">
                                            <img class="img-account-profile rounded mb-2"
                                                 src="../assets/img/illustrations/profiles/profile-2.png"
                                                 alt="" id='preview'/>
                                            <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5
                                                MB
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                    <!-- Profile picture upload button-->
                                    <button id="myBtn" class="btn btn-primary" type="button">Upload an image</button>

                                </div>
                            </div>
                            <div class="card mb-4">
                                <div class="card-header">Actions</div>
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${action == 'modify'}"><a href="javascript:void(0);"
                                                                                onclick="Crew_Details.update();">
                                            <button class="btn btn-primary" type="submit">Save</button>
                                        </a></c:when>
                                        <c:otherwise><a href="javascript:void(0);" onclick="Crew_Details.add();">
                                            <button class="btn btn-primary" type="submit">Add</button>
                                        </a></c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-10">
                            <div class="card mb-4">
                                <div class="card-header">Personal</div>
                                <div class="card-body">
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="firstName">First name</label>
                                            <input class="form-control dirtycheck" id="firstName" name="firstName"
                                                   type="text"
                                                   placeholder="Enter first name" value="${crew.firstName}"/>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="middleName">Middle name</label>
                                            <input class="form-control dirtycheck" id="middleName" name="middleName"
                                                   type="text"
                                                   placeholder="Enter middle name" value="${crew.middleName}"/>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="lastName">Last name</label>
                                            <input class="form-control dirtycheck" id="lastName" name="lastName"
                                                   type="text"
                                                   placeholder="Enter last name" value="${crew.lastName}"/>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="maritalStatus">Marital Status</label>
                                            <select class="form-select dirtycheck" id="maritalStatus"
                                                    name="maritalStatus"
                                                    aria-label="Default select example">
                                                <option selected disabled>Marital Status:</option>
                                                <option
                                                        <c:if test="${crew.maritalStatus=='single'}">selected</c:if>
                                                        value="single">Single
                                                </option>
                                                <option
                                                        <c:if test="${crew.maritalStatus=='married'}">selected</c:if>
                                                        value="married">Married
                                                </option>
                                            </select>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="nationalityFlagCode">Nationality</label>
                                            <select class="form-select dirtycheck"
                                                    aria-label="Default select example" id="nationalityFlagCode"
                                                    name="nationalityFlagCode">
                                                <option selected disabled>Select Nationality:</option>
                                                <c:forEach items="${flags}" var="flag">
                                                    <option
                                                            <c:if test="${crew.nationalityFlag.code==flag.code}">selected</c:if>
                                                            value="${flag.code}">${flag.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="rankId">Rank</label>
                                            <select class="form-select dirtycheck" id="rankId" name="rankId"
                                                    aria-label="Default select example">
                                                <option selected disabled>Select a Rank:</option>
                                                <c:forEach var="optionGroup" items="${rankMap}">
                                                    <optgroup label="${optionGroup.key}">
                                                        <c:forEach var="option" items="${optionGroup.value}">
                                                            <option
                                                                    <c:if test="${crew.rank.id==option.id}">selected</c:if>
                                                                    value="${option.id}">${option.name}
                                                                (${option.rankSubCategory.name})
                                                            </option>
                                                        </c:forEach>
                                                    </optgroup>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="gender">Gender</label>
                                            <select class="form-select dirtycheck" id="gender" name="gender"
                                                    aria-label="Default select example">
                                                <option selected disabled>Gender:</option>
                                                <option
                                                        <c:if test="${crew.gender=='Male'}">selected</c:if>
                                                        value="Male">Male
                                                </option>
                                                <option
                                                        <c:if test="${crew.gender=='Female'}">selected</c:if>
                                                        value="Female">Female
                                                </option>
                                            </select>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="distinguishingMark">Distinguishing
                                                Mark</label>
                                            <textarea name="distinguishingMark" id="distinguishingMark"
                                                      class="lh-base form-control dirtycheck" placeholder=""
                                                      rows="3" cols="3">${crew.distinguishingMark}</textarea>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="lastName">Nearest Airport</label>
                                            <input class="form-control dirtycheck"
                                                   id="nearestAirport"
                                                   name="nearestAirport" type="text"
                                                   placeholder="Enter Nearest Airport"
                                                   value="${crew.nearestAirport}"/>
                                        </div>
                                    </div>

                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="permAddress">Permanent Address</label>
                                            <textarea name="permAddress" id="permAddress"
                                                      class="lh-base form-control dirtycheck" placeholder=""
                                                      rows="3" cols="3">${crew.permAddress}</textarea>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="presentAddress">Present Address</label>
                                            <textarea name="presentAddress" id="presentAddress"
                                                      class="lh-base form-control dirtycheck" placeholder=""
                                                      rows="3" cols="3">${crew.presentAddress}</textarea>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="emailId">EmailID</label>
                                            <input class="form-control dirtycheck"
                                                   id="emailId" name="emailId"
                                                   type="text"
                                                   placeholder="Enter Email ID"
                                                   value="${crew.emailId}"/>
                                        </div>
                                    </div>

                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="contact1">Contact#1</label>
                                            <input class="form-control dirtycheck"
                                                   id="contact1" name="contact1"
                                                   type="text"
                                                   placeholder="Enter Contact Number#1"
                                                   value="${crew.contact1}"/>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="contact2">Contact#2</label>
                                            <input class="form-control dirtycheck"
                                                   id="contact2" name="contact2"
                                                   type="text"
                                                   placeholder="Enter Contact Number#2"
                                                   value="${crew.contact2}"/>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="dob">Date of Birth</label>
                                            <div class="input-group input-group-joined border-1">
                                            <span class="input-group-text"><i class="text-primary"
                                                                              data-feather="calendar"></i></span>
                                                <input name="dob" class="form-control dirtycheck"
                                                       id="dob"
                                                       placeholder="Select date" value="${crew.dob}"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="height">Height (cms)</label>
                                            <input class="form-control dirtycheck"
                                                   id="height" name="height"
                                                   type="text"
                                                   placeholder="Enter Height in cms"
                                                   value="${crew.height}"/>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="weight">Weight (kgs)</label>
                                            <input class="form-control dirtycheck"
                                                   id="weight" name="weight"
                                                   type="text"
                                                   placeholder="Enter Weight in kgs"
                                                   value="${crew.weight}"/>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="availableFromDate">Available From
                                                Date</label>
                                            <div class="input-group input-group-joined border-1">
                                        <span class="input-group-text"><i class="text-primary"
                                                                          data-feather="calendar"></i></span>
                                                <input name="availableFromDate" class="form-control dirtycheck"
                                                       id="availableFromDate"
                                                       placeholder="Select date" value="${crew.availableFromDate}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="firstName">Status</label>
                                            <select class="form-select" id="statusId" name="statusId"
                                                    aria-label="Default select example">
                                                <option selected disabled>Status:</option>
                                                <c:forEach items="${statuses}" var="status">
                                                    <option
                                                            <c:if test="${crew.status.id==status.id}">selected</c:if>
                                                            value="${status.id}">${status.desc}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="manningOffice">Manning Office</label>
                                            <input class="form-control dirtycheck" name="manningOffice"
                                                   id="manningOffice" type="text"
                                                   value="${crew.manningOffice}"/>
                                        </div>
                                        <div class="col-md-4">
                                            <label class="small mb-1" for="passportNumber">Passport Number</label>
                                            <input class="form-control dirtycheck" name="passportNumber"
                                                   id="passportNumber" type="text"
                                                   placeholder="Enter Passport Number" value="${crew.passportNumber}"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${action == 'modify'}">
                            <div class="card mb-6">
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
