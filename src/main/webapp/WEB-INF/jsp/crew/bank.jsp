<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Crew Bank :: ${crew.fileNum}</title>

    <%@ include file="../includes/header_includes.jsp" %>
    <script src="../js/crew/bank_details.js"></script>
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
                <%@ include file="crew_menu.jsp" %>
                <hr class="mt-0 mb-4"/>
                <div class="row">
                    <div class="col-lg-1">
                        <div class="float-left">
                            <button class="btn btn-blue btn-icon float-end" type="button" data-bs-toggle="modal"
                                    data-bs-target="#newBankModal">
                                <i data-feather="plus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <c:forEach items="${list}" var="bank" varStatus="theCount">
                            <form role="form" method="POST" action="/crew/bank/update.ajax">
                                <input type="hidden" name="menu" value="${menu}">
                                <input type="hidden" name="sMenu" value="${sMenu}">
                                <input type="hidden" name="crewId" value="${crewId}">
                                <input type="hidden" name="bankId" value="${bank.id}">
                                <div class="card mb-6">
                                    <div class="card-header">Bank# ${theCount.index+1}</div>
                                    <div class="card-body">
                                        <div class="row gx-3 mb-3">
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="bankName">Name</label>
                                                <input class="form-control dirtycheck" id="bankName"
                                                       name="nomineeName"
                                                       type="text"
                                                       placeholder="Enter Bank Name" value="${bank.bankName}"/>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="accountNumber">Account Number</label>
                                                <input class="form-control dirtycheck" id="accountNumber"
                                                       name="accountNumber"
                                                       type="text"
                                                       placeholder="Enter Account Number"
                                                       value="${bank.accountNumber}"/>
                                            </div>

                                        </div>
                                        <div class="row gx-3 mb-3">
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="swiftCode">SWIFT Code</label>
                                                <input class="form-control dirtycheck" id="swiftCode"
                                                       name="swiftCode"
                                                       type="text"
                                                       placeholder="Enter SWIFT" value="${bank.swiftCode}"/>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="ifscCode">IFSC Code</label>
                                                <input class="form-control dirtycheck" id="ifscCode"
                                                       name="ifscCode"
                                                       type="text"
                                                       placeholder="Enter IFSC" value="${bank.ifscCode}"/>
                                            </div>
                                        </div>
                                        <div class="row gx-3 mb-3">
                                            <div class="col-md-4">
                                                <label class="small mb-1" for="branchAddress">Branch Address</label>
                                                <textarea name="branchAddress" id="branchAddress"
                                                          class="lh-base form-control dirtycheck"
                                                          placeholder="Enter Branch Address"
                                                          rows="3" cols="3">${bank.branchAddress}</textarea>
                                            </div>
                                            <div class="col-md-4">
                                                <button class="btn btn-primary" type="button" data-bs-dismiss="modal">
                                                    Update
                                                </button>
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
<div class="modal fade" id="newBankModal" tabindex="-1" role="dialog" aria-labelledby="newBankModalLabel"
     style="display: none;" aria-hidden="true">

    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add New Bank Account</h5>
                <button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container-xl px-4">
                    <div class="row justify-content-center">
                        <form role="form" method="POST" action="/crew/bank/add">
                            <input type="hidden" name="menu" value="${menu}">
                            <input type="hidden" name="sMenu" value="${sMenu}">
                            <input type="hidden" name="crewId" value="${crewId}">
                            <div class="row gx-3 mb-3">
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputBankName">Bank Name</label>
                                    <input class="form-control" id="inputBankName" name="inputBankName" type="text"
                                           placeholder="Enter your Bank Name"/>
                                </div>
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputAccountNumber">Account Number</label>
                                    <input class="form-control" id="inputAccountNumber" name="inputAccountNumber"
                                           type="text"
                                           placeholder="Enter your Account Number"/>
                                </div>
                            </div>
                            <div class="row gx-3 mb-3">
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputSWIFT">SWIFT Code</label>
                                    <input class="form-control" id="inputSWIFT" name="inputSWIFT" type="text"
                                           placeholder="Enter SWIFT Code of Bank"/>
                                </div>
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputIFSC">IFSC Code</label>
                                    <input class="form-control" id="inputIFSC" name="inputIFSC" type="text"
                                           placeholder="Enter IFSC Code of Bank"/>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label class="small mb-1" for="inputBranchAddress">Branch Address</label>
                                <textarea name="inputBranchAddress" id="inputBranchAddress" name="inputBranchAddress"
                                          class="lh-base form-control dirtycheck" placeholder="Enter Branch Address"
                                          rows="3" cols="3"></textarea>
                            </div>
                            <button class="btn btn-primary" type="submit">Save changes</button>
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
