<!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
                <div class="sidebar-brand-icon rotate-n-15">
                    <!-- <i class="fas fa-laugh-wink"></i> -->
                    <i class="fas fa-ship"></i>
                </div>
                <div class="sidebar-brand-text mx-3">SHIP-MAN<sup>1.0</sup></div>                 
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="/">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseCrew"
                    aria-expanded="true" aria-controls="#collapseCrew">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Crew</span>
                </a>
                <div id="collapseCrew" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                    	<h6 class="collapse-header">Administration:</h6>
                        <a class="collapse-item" href="/crew/add_crew">Add New Crew</a>
                        <a class="collapse-item" href="/crew/crew_list">Crew List</a>
                        
                        <h6 class="collapse-header">Recruitment & Operations:</h6>
                        <a class="collapse-item" href="personal_details.html">Course Request</a>
                        <a class="collapse-item" href="/crew/profile">My Profile</a>
                        <a class="collapse-item" href="crew/drug_alcohol_test">Drug & Alcohol Test</a>
                        <a class="collapse-item" href="crew/training_qualifiation">Training & Qualifications</a>
                        
                        <h6 class="collapse-header">Other:</h6>
                        <a class="collapse-item" href="crew/training">Training</a>
                        <a class="collapse-item" href="crew/travel">Travel</a>
                    </div>
                </div>
            </li>

			<!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsTraining"
                    aria-expanded="true" aria-controls="collapsTraining">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Training</span>
                </a> 
                <div id="collapsTraining" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                    	<h6 class="collapse-header">Request:</h6>
	                    <a class="collapse-item" href="utilities-other.html">Course Request</a>
                    
                        <h6 class="collapse-header">Planner:</h6>
                        <a class="collapse-item" href="training/planner?type=batch">Batch Planner</a>
                        <a class="collapse-item" href="training/planner?type=cancelled">Cancelled Planner</a>
                        <a class="collapse-item" href="training/planner?type=course">Course Planner</a>                       
                        <a class="collapse-item" href="training/planner?type=faculty">Faculty Planner</a>                        
                        <a class="collapse-item" href="training/enrollment_details">Enrollment Details</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTravel"
                    aria-expanded="true" aria-controls="collapseTravel">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Travel</span>
                </a> 
                <div id="collapseTravel" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                    	<h6 class="collapse-header">Request:</h6>
                    	<a class="collapse-item" href="travel/request?type=office">Office Travel Request</a>
                    	<a class="collapse-item" href="travel/request?type=hotel">Hotel Request</a>
	                    <a class="collapse-item" href="travel/request?type=visa">Visa Request</a>
	                    <a class="collapse-item" href="travel/request_list">Travel Request List</a>	                    
	                    
                        <h6 class="collapse-header">Other:</h6>
                        <a class="collapse-item" href="travel/hotel_booking_details">Hotel Booking Details</a>
                        <a class="collapse-item" href="travel/local_arrangements">Local Arrangements</a>
                        <a class="collapse-item" href="travel/invoice">Travel Invoice</a>                        
                        <a class="collapse-item" href="travel/expenses">Unallocated Vessel Expenses</a>
                        <a class="collapse-item" href="travel/travel_list">Travel List</a>
                    </div>
                </div>
            </li>
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLicensing"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Licensing</span>
                </a> 
                <div id="collapseLicensing" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Request:</h6>
                    	<a class="collapse-item" href="license/request?type=license">License Request</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Utilities Collapse Menu -->
           <!--  <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseDocuments"
                    aria-expanded="true" aria-controls="collapseDocuments">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Documents</span>
                </a> 
                <div id="collapseDocuments" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Utilities:</h6>
                        <a class="collapse-item" href="utilities-color.html"></a>
                        <a class="collapse-item" href="utilities-border.html">Documents</a>
                        <a class="collapse-item" href="utilities-animation.html">Travel</a>
                        <a class="collapse-item" href="utilities-other.html">License</a>
                        <a class="collapse-item" href="utilities-other.html">Medical</a>
                        <a class="collapse-item" href="utilities-other.html">Courses</a>
                        <a class="collapse-item" href="utilities-other.html">CBT & EPSS</a>
                        <a class="collapse-item" href="utilities-other.html">Academic</a>
                        <a class="collapse-item" href="utilities-other.html">Award</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a>
                    </div>
                </div>
            </li> -->
            
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseRecruitment"
                    aria-expanded="true" aria-controls="collapseRecruitment">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Recruitment</span>
                </a> 
                <div id="collapseRecruitment" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Utilities:</h6>
                        <a class="collapse-item" href="recruit/crew_availability">Crew Availability</a>
                        <a class="collapse-item" href="recruit/recruit_stats">Recruitment Statistics</a>
                        <a class="collapse-item" href="recruit/recruit_summary">Recruitment Summary</a>
                        <a class="collapse-item" href="recruit/short_hand_manning">Short Hand Manning</a>
                        <a class="collapse-item" href="utilities-other.html">Crew Short Contract</a>
                        <a class="collapse-item" href="utilities-other.html">Recruitment Target</a>
                        <a class="collapse-item" href="utilities-other.html">Head Count</a>
                        <a class="collapse-item" href="utilities-other.html">Important Remark Statement</a>
                        <a class="collapse-item" href="utilities-other.html">Crew Relief Planning</a>
                        <a class="collapse-item" href="utilities-other.html">Crew Delayed Relief</a>
                        <a class="collapse-item" href="utilities-other.html">Principal-wise Planner</a>
                        <a class="collapse-item" href="utilities-other.html">Crew Not Received on Time</a>
                        <a class="collapse-item" href="utilities-other.html">Senior Officer Planner</a>
                        <a class="collapse-item" href="utilities-other.html">Seafarers Interaction</a>
                        <a class="collapse-item" href="utilities-other.html">Mentor</a>
                        <a class="collapse-item" href="utilities-other.html">Crew Active/Inactive Statement</a>
                        <a class="collapse-item" href="utilities-other.html">Seafarers Onboard/Onleave list</a>
                        <a class="collapse-item" href="utilities-other.html">Experience Summary</a>
                        <a class="collapse-item" href="utilities-other.html">Address Lables</a>
                        <a class="collapse-item" href="utilities-other.html">PD Form</a>
                        <a class="collapse-item" href="utilities-other.html">Application Form</a>                         
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseMIS"
                    aria-expanded="true" aria-controls="collapseMIS">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>MIS Reports</span>
                </a> 
                <div id="collapseMIS" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Utilities:</h6>
                        <a class="collapse-item" href="report/report">Report 1</a>
						<a class="collapse-item" href="report/report">Report 2</a>                                               
						<a class="collapse-item" href="report/report">Report 3</a>
                    </div>
                </div>
            </li>
            
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Addons
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Pages</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Login Screens:</h6>
                        <a class="collapse-item" href="login.html">Login</a>
                        <a class="collapse-item" href="register.html">Register</a>
                        <a class="collapse-item" href="forgot-password.html">Forgot Password</a>
                        <div class="collapse-divider"></div>
                        <h6 class="collapse-header">Other Pages:</h6>
                        <a class="collapse-item" href="404.html">404 Page</a>
                        <a class="collapse-item" href="blank.html">Blank Page</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Charts</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="tables.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Tables</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            <!-- Sidebar Message -->
            <div class="sidebar-card d-none d-lg-flex">
                <img class="sidebar-card-illustration mb-2" src="img/undraw_rocket.svg" alt="...">
                <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and more!</p>
                <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a>
            </div>

        </ul>
        <!-- End of Sidebar -->

</div>
        