<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Crew</title>
    
        <%@ include file="../includes/header_includes.jsp" %>
    </head>
    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>
       
       
        <div id="layoutSidenav">
        
        <%@ include file="../includes/sidebar.jsp" %>
            
            <div id="layoutSidenav_content">
                <main>
               <%@ include file="add_crew_header.jsp" %>
                    
                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation-->
                        <nav class="nav nav-borders">
                           <a class="nav-link" href="/crew/add_crew">Profile</a>
                            <a class="nav-link" href="/crew/add_employment">Employment</a>
                            <a class="nav-link" href="/crew/add_education">Education</a>
                            <a class="nav-link" href="/crew/add_passport_visa">Passport/Visa</a>
                            <a class="nav-link" href="/crew/add_medical">Medical</a>
                            <a class="nav-link" href="/crew/add_bank_account">Bank Account</a>
                            <a class="nav-link" href="/crew/add_nominee">Nominee</a>
                            <a class="nav-link active ms-0" href="/crew/add_other_docs">Other Documents</a>
                        </nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">
                            <div class="col-xl-2">
                                <!-- Profile picture card-->
                                <div class="card mb-2 mb-xl-0">
                                    <div class="card-header">Profile Picture</div>
                                    <div class="card-body text-center">
                                        <!-- Profile picture image-->
                                        <img class="img-account-profile rounded-circle mb-2" src="../assets/img/illustrations/profiles/profile-1.png" alt="" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-10">
                                <!-- Account details card-->
		                        <div class="card mb-4">
		                            <div class="card-header">Crew Certification List</div>
		                            <div class="card-body p-0">
		                                <!-- Billing history table-->
		                                <div class="table-responsive table-billing-history">
		                                    <table class="table mb-0">
		                                        <thead>
		                                            <tr>
		                                                <th class="border-gray-200" scope="col">Cert Name</th>
		                                                <th class="border-gray-200" scope="col">Validity</th>
		                                                <th class="border-gray-200" scope="col">Maker</th>
		                                                <th class="border-gray-200" scope="col">Checker</th>
		                                                <th class="border-gray-200" scope="col">Status</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <tr>
		                                                <td>#39201</td>
		                                                <td>06/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-light text-dark">Pending</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38594</td>
		                                                <td>05/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38223</td>
		                                                <td>04/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38125</td>
		                                                <td>03/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                        </tbody>
		                                    </table>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        
		                        <div class="card mb-4">
		                            <div class="card-header">Crew Medical List</div>
		                            <div class="card-body p-0">
		                                <!-- Billing history table-->
		                                <div class="table-responsive table-billing-history">
		                                    <table class="table mb-0">
		                                        <thead>
		                                            <tr>
		                                                <th class="border-gray-200" scope="col">Medical Name</th>
		                                                <th class="border-gray-200" scope="col">Validity</th>
		                                                <th class="border-gray-200" scope="col">Maker</th>
		                                                <th class="border-gray-200" scope="col">Checker</th>
		                                                <th class="border-gray-200" scope="col">Status</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <tr>
		                                                <td>#39201</td>
		                                                <td>06/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-light text-dark">Pending</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38594</td>
		                                                <td>05/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38223</td>
		                                                <td>04/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38125</td>
		                                                <td>03/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                        </tbody>
		                                    </table>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        
		                        <div class="card mb-4">
		                            <div class="card-header">License List</div>
		                            <div class="card-body p-0">
		                                <!-- Billing history table-->
		                                <div class="table-responsive table-billing-history">
		                                    <table class="table mb-0">
		                                        <thead>
		                                            <tr>
		                                                <th class="border-gray-200" scope="col">License Name</th>
		                                                <th class="border-gray-200" scope="col">Validity</th>
		                                                <th class="border-gray-200" scope="col">Maker</th>
		                                                <th class="border-gray-200" scope="col">Checker</th>
		                                                <th class="border-gray-200" scope="col">Status</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <tr>
		                                                <td>#39201</td>
		                                                <td>06/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-light text-dark">Pending</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38594</td>
		                                                <td>05/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38223</td>
		                                                <td>04/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38125</td>
		                                                <td>03/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                        </tbody>
		                                    </table>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="card mb-4">
		                            <div class="card-header">Other Doc List</div>
		                            <div class="card-body p-0">
		                                <!-- Billing history table-->
		                                <div class="table-responsive table-billing-history">
		                                    <table class="table mb-0">
		                                        <thead>
		                                            <tr>
		                                                <th class="border-gray-200" scope="col">Doc Name</th>
		                                                <th class="border-gray-200" scope="col">Doc Type</th>
		                                                <th class="border-gray-200" scope="col">Validity</th>
		                                                <th class="border-gray-200" scope="col">Maker</th>
		                                                <th class="border-gray-200" scope="col">Checker</th>
		                                                <th class="border-gray-200" scope="col">Status</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <tr>
		                                                <td>#39201</td>
		                                                <td>06/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-light text-dark">Pending</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38594</td>
		                                                <td>05/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38223</td>
		                                                <td>04/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
		                                            <tr>
		                                                <td>#38125</td>
		                                                <td>03/15/2021</td>
		                                                <td>$29.99</td>
		                                                <td><span class="badge bg-success">Paid</span></td>
		                                            </tr>
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
        
    </body>
</html>
