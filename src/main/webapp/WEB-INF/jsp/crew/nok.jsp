<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Crew NoK :: ${crew.fileNum}</title>

    <%@ include file="../includes/header_includes.jsp" %>
    <script src="../js/crew/crew_details.js"></script>
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
                                        data-bs-target="#newNOKModal">
                                    <i data-feather="plus"></i>
                                </button>
                        </div>
                    </div>
                    <div class="col-lg-11">
                        <c:forEach items="${list}" var="nok" varStatus="theCount">
                            <form id="crew-details-form" role="form" method="POST" action="/crew/nok/update.ajax">
                                <div class="card mb-4">
                                    <div class="card-header">Nok# ${theCount.index+1}</div>
                                    <div class="card-body">
                                        <div class="row gx-3 mb-3">
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="nomineeName">Name</label>
                                                <input class="form-control dirtycheck" id="nomineeName"
                                                       name="nomineeName"
                                                       type="text"
                                                       placeholder="Enter nomineeName" value="${nok.nomineeName}"/>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="relationType">Relation</label>
                                                <select class="form-select" id="relationType" name="relationType"
                                                        aria-label="Default select example">
                                                    <option selected disabled>Relation:</option>
                                                    <c:forEach items="${relationTypes}" var="rt">
                                                        <option
                                                                <c:if test="${nok.relationType==rt.relationTypeName}">selected</c:if>
                                                                value="${rt.relationTypeName}">${rt.relationTypeName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="dateOfBirth">DoB</label>
                                                <div class="input-group input-group-joined border-1">
                                                    <span class="input-group-text"><i class="text-primary"
                                                                                      data-feather="calendar"></i></span>
                                                    <input name="dateOfBirth" class="form-control dirtycheck"
                                                           id="dateOfBirth"
                                                           placeholder="Select date" value="${nok.dateOfBirth}"/>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="row gx-3 mb-3">
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="nomineeName">Passport</label>
                                                <input class="form-control dirtycheck" id="passport" name="passport"
                                                       type="text"
                                                       placeholder="Enter nomineeName" value="${nok.passport}"/>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="perOfAmount">Share %</label>
                                                <input class="form-control dirtycheck" id="perOfAmount"
                                                       name="perOfAmount"
                                                       type="text"
                                                       placeholder="Enter nomineeName" value="${nok.perOfAmount}"/>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="hasUSVisa">Has US Visa?</label>
                                                <input class="form-control dirtycheck" id="hasUSVisa"
                                                       name="hasUSVisa"
                                                       type="text"
                                                       placeholder="Enter last name" value="${nok.hasUSVisa}"/>
                                            </div>
                                        </div>
                                        <div class="row gx-3 mb-3">
                                            <div class="col-md-12">
                                                <label class="small mb-1" for="address">Address</label>
                                                <textarea name="address" id="address"
                                                          class="lh-base form-control dirtycheck" placeholder=""
                                                          rows="3" cols="3">${nok.address}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </main>


        <%@ include file="../includes/copyright.jsp" %>

    </div>
</div>
<div class="modal fade" id="newNOKModal" tabindex="-1" role="dialog" aria-labelledby="newNOKModalLabel"
     style="display: none;" aria-hidden="true">

    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add New NOK</h5>
                <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container-xl px-4">
                    <div class="row justify-content-center">
                        <form>
                            <!-- Form Group (username)-->
                            <div class="mb-3">
                                <label class="small mb-1" for="inputUsername">Username (how your name will appear to
                                    other users on the site)</label>
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
                            <!-- Save changes button-->
                            <button class="btn btn-primary" type="button">Save changes</button>
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


<%@ include file="../includes/bottom_includes.jsp" %>

</body>

</html>
