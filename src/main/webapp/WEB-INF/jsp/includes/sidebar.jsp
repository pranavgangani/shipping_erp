<div id="layoutSidenav_nav">
                <nav class="sidenav shadow-right sidenav-light">
                    <div class="sidenav-menu">
                        <div class="nav accordion" id="accordionSidenav">
                            <!-- Sidenav Menu Heading (Account)-->
                            <!-- * * Note: * * Visible only on and above the sm breakpoint-->
                            <div class="sidenav-menu-heading d-sm-none">Account</div>
                            <!-- Sidenav Link (Alerts)-->
                            <!-- * * Note: * * Visible only on and above the sm breakpoint-->
                            <a class="nav-link d-sm-none" href="#!">
                                <div class="nav-link-icon"><i data-feather="bell"></i></div>
                                Alerts
                                <span class="badge bg-warning-soft text-warning ms-auto">4 New!</span>
                            </a>
                            <!-- Sidenav Link (Messages)-->
                            <!-- * * Note: * * Visible only on and above the sm breakpoint-->
                            <a class="nav-link d-sm-none" href="#!">
                                <div class="nav-link-icon"><i data-feather="mail"></i></div>
                                Messages
                                <span class="badge bg-success-soft text-success ms-auto">2 New!</span>
                            </a>
                            <!-- Sidenav Menu Heading (Core)-->
                            <div class="sidenav-menu-heading">Core</div>
                            <!-- Sidenav Accordion (Dashboard)-->
                            <a class="nav-link collapsed" href="/dashboard"  aria-expanded="false">
                                <div class="nav-link-icon"><i data-feather="activity"></i></div>
                                Dashboard                                
                            </a>
                            <div class="sidenav-menu-heading">List</div>
                            <a class="nav-link collapsed" href="/crew/list"  aria-expanded="false">
                                <div class="nav-link-icon"><i data-feather="users"></i></div>
                                Crew
                            </a>
                            <a class="nav-link collapsed" href="/crew/doc_list"  aria-expanded="false">
                                <div class="nav-link-icon"><i data-feather="briefcase"></i></div>
                                Crew Documents
                            </a>
                            <a class="nav-link collapsed" href="/vessel/vacancy_list"  aria-expanded="false">
                                <div class="nav-link-icon"><i data-feather="target"></i></div>
                                Vacancies
                            </a>
                            <a class="nav-link collapsed" href="/vessel/vessel_list"  aria-expanded="false">
                                <div class="nav-link-icon"><i data-feather="anchor"></i></div>
                                Vessels
                            </a>
                            <a class="nav-link collapsed" href="/vessel/vessel_owner_list"  aria-expanded="false">
                                <div class="nav-link-icon"><i data-feather="user"></i></div>
                                Vessel Owners
                            </a>
                            <a class="nav-link collapsed" href="/crew/travel_request_list"  aria-expanded="false">
                                <div class="nav-link-icon"><i data-feather="globe"></i></div>
                                Travel Requests
                            </a>
                             <!-- Sidenav Heading (Custom)-->
                             <div class="sidenav-menu-heading">Management</div>
                            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseCrew" aria-expanded="false" aria-controls="collapseCrew">
                                <div class="nav-link-icon"><i data-feather="grid"></i></div>
                                Crew
                                <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseCrew" data-bs-parent="#accordionSidenav">
                                <nav class="sidenav-menu-nested nav accordion" id="accordionSidenavPagesMenu">
                                    <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAccount" aria-expanded="false" aria-controls="pagesCollapseAccount">
                                        Add New
                                        <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a> 
                                    <div class="collapse" id="pagesCollapseAccount" data-bs-parent="#accordionSidenavPagesMenu">
                                        <nav class="sidenav-menu-nested nav">
                                            <a class="nav-link" href="/crew/add">Add New Crew</a>
                                        </nav>
                                    </div>
                                    <div class="collapse" id="pagesCollapseAccount" data-bs-parent="#accordionSidenavPagesMenu">
                                        <nav class="sidenav-menu-nested nav">
                                            <a class="nav-link" href="/crew/upload_crew">Upload New Crew</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <!-- Sidenav Accordion (Pages)-->
                            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseVacancies" aria-expanded="false" aria-controls="collapseVacancies">
                                <div class="nav-link-icon"><i data-feather="grid"></i></div>
                                Vacancy
                                <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseVacancies" data-bs-parent="#accordionSidenav">
                                <nav class="sidenav-menu-nested nav accordion" id="accordionSidenavVacancies">

                                    <!-- Nested Sidenav Accordion (Pages -> Account)-->
                                    <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAccount" aria-expanded="false" aria-controls="pagesCollapseAccount">
                                        Add New
                                        <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAccount" data-bs-parent="#accordionSidenavVacancies">
                                        <nav class="sidenav-menu-nested nav">
                                            <a class="nav-link" href="/vacancy/vacancy_details">Add New Vacancy</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <!-- Sidenav Accordion (Applications)-->
                            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseVessel" aria-expanded="false" aria-controls="collapseVessel">
                                <div class="nav-link-icon"><i data-feather="globe"></i></div>
                                Vessel
                                <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseVessel" data-bs-parent="#accordionSidenav">
                                <nav class="sidenav-menu-nested nav accordion" id="accordionSidenavVesselMenu">

                                    <!-- Nested Sidenav Accordion (Apps -> Knowledge Base)-->
                                    <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#appsCollapseKnowledgeBase" aria-expanded="false" aria-controls="appsCollapseKnowledgeBase">
                                        Add New
                                        <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="appsCollapseKnowledgeBase" data-bs-parent="#accordionSidenavVesselMenu">
                                        <nav class="sidenav-menu-nested nav">
                                        	<a class="nav-link" href="/vessel/vessel_details">Vessel</a>
                                            <a class="nav-link" href="/vessel/vessel_owner_details">Vessel Owner</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <!-- Sidenav Accordion (Applications)-->
                                <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseRequest" aria-expanded="false" aria-controls="collapseRequest">
                                    <div class="nav-link-icon"><i data-feather="globe"></i></div>
                                    Request
                                    <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                </a>
                               <div class="collapse" id="collapseFlows" data-bs-parent="#accordionSidenav">
                                   <nav class="sidenav-menu-nested nav">
                                       <a class="nav-link" href="/vessel/mandatory_document_list">Hotel Document List</a>
                                       <a class="nav-link" href="/crew/mandatory_document_list">Crew Document List</a>
                                   </nav>
                               </div>
                            <!-- Sidenav Accordion (Flows)-->
                            <!--<div class="sidenav-menu-heading">Document</div>-->
                            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseFlows" aria-expanded="false" aria-controls="collapseFlows">
                                <div class="nav-link-icon"><i data-feather="repeat"></i></div>
                                Document
                                <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseFlows" data-bs-parent="#accordionSidenav">
                                <nav class="sidenav-menu-nested nav">
                                    <a class="nav-link" href="/vessel/mandatory_document_list">Vessel Document List</a>
                                    <a class="nav-link" href="/crew/mandatory_document_list">Crew Document List</a>
                                </nav>
                            </div>
                            <!-- Sidenav Accordion (Flows)-->
                            <div class="sidenav-menu-heading">Reports</div>
                            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseReports" aria-expanded="false" aria-controls="collapseReports">
                                <div class="nav-link-icon"><i data-feather="repeat"></i></div>
                                Crew Reports
                                <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseReports" data-bs-parent="#accordionSidenav">
                                <nav class="sidenav-menu-nested nav">
                                    <a class="nav-link" href="/crew/active_crew">Active Crews</a>
                                    <a class="nav-link" href="/crew/ready_crew">Ready for Sign-off Crews</a>
                                </nav>
                            </div>
                            <!-- Sidenav Heading (UI Toolkit)-->
                            <div class="sidenav-menu-heading">Admin</div>
                            <!-- Sidenav Accordion (Layout)-->
                            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="nav-link-icon"><i data-feather="tool"></i></div>
                                Settings
                                <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" data-bs-parent="#accordionSidenav">
                                <nav class="sidenav-menu-nested nav accordion" id="accordionSidenavLayout">
                                    <!-- Nested Sidenav Accordion (Layout -> Navigation)-->
                                    <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayoutSidenavVariations" aria-expanded="false" aria-controls="collapseLayoutSidenavVariations">
                                        Manage
                                        <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="collapseLayoutSidenavVariations" data-bs-parent="#accordionSidenavLayout">
                                        <nav class="sidenav-menu-nested nav">
                                            <a class="nav-link" href="/settings/ranks">Rank</a>
                                            <a class="nav-link" href="/settings/document_list">Crew Document List</a>
                                            <a class="nav-link" href="/settings/document_type_list">Document Type List</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>                           
                                                  
                        </div>
                    </div>
                    <!-- Sidenav Footer-->
                    <div class="sidenav-footer">
                        <div class="sidenav-footer-content">
                            <div class="sidenav-footer-subtitle">Logged in as:</div>
                            <div class="sidenav-footer-title">${fullName}</div>
                        </div>
                    </div>
                </nav>
            </div>