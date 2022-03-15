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
                            <a class="nav-link collapsed" href="/"  aria-expanded="false">
                                <div class="nav-link-icon"><i data-feather="activity"></i></div>
                                Dashboard                                
                            </a>
                            <!-- Sidenav Heading (Custom)-->
                            <div class="sidenav-menu-heading">Crew</div>
                            <!-- Sidenav Accordion (Pages)-->
                            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="nav-link-icon"><i data-feather="grid"></i></div>
                                Crew Management
                                <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" data-bs-parent="#accordionSidenav">
                                <nav class="sidenav-menu-nested nav accordion" id="accordionSidenavPagesMenu">
                                	<a class="nav-link" href="/crew/list">Crew List</a>
                                
                                    <!-- Nested Sidenav Accordion (Pages -> Account)-->
                                    <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAccount" aria-expanded="false" aria-controls="pagesCollapseAccount">
                                        Add New
                                        <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a> 
                                    <div class="collapse" id="pagesCollapseAccount" data-bs-parent="#accordionSidenavPagesMenu">
                                        <nav class="sidenav-menu-nested nav">
                                            <a class="nav-link" href="/crew/add">Add New Crew</a>
                                        </nav>
                                    </div>                                    
                                </nav>
                            </div>
                            <!-- Sidenav Accordion (Applications)-->
                            <div class="sidenav-menu-heading">Vessel</div>
                            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseApps" aria-expanded="false" aria-controls="collapseApps">
                                <div class="nav-link-icon"><i data-feather="globe"></i></div>
                                Vessel Management
                                <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseApps" data-bs-parent="#accordionSidenav">
                                <nav class="sidenav-menu-nested nav accordion" id="accordionSidenavAppsMenu">
                                	<a class="nav-link" href="/vessel/vessel_list">Vessel List</a>
                                	<a class="nav-link" href="/vessel/vessel_owner_list">Vessel Owner List</a>
                                <a class="nav-link" href="/crew/vacancy_list">Vessel Vacancy List</a>
                                
                                    <!-- Nested Sidenav Accordion (Apps -> Knowledge Base)-->
                                    <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#appsCollapseKnowledgeBase" aria-expanded="false" aria-controls="appsCollapseKnowledgeBase">
                                        Add New
                                        <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="appsCollapseKnowledgeBase" data-bs-parent="#accordionSidenavAppsMenu">
                                        <nav class="sidenav-menu-nested nav">
                                        	<a class="nav-link" href="/vessel/add_vessel">Vessel</a>
                                            <a class="nav-link" href="/vessel/add_vessel_owner">Vessel Owner</a>                                            
                                            <a class="nav-link" href="/vessel/add_vessel_vacancy">Vessel Vacancy</a>
                                        </nav>
                                    </div>
                                    <!-- Nested Sidenav Accordion (Apps -> User Management)-->
                                    <!-- <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#appsCollapseUserManagement" aria-expanded="false" aria-controls="appsCollapseUserManagement">
                                        User Management
                                        <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="appsCollapseUserManagement" data-bs-parent="#accordionSidenavAppsMenu">
                                        <nav class="sidenav-menu-nested nav">
                                            <a class="nav-link" href="user-management-list.html">Users List</a>
                                            <a class="nav-link" href="user-management-edit-user.html">Edit User</a>
                                            <a class="nav-link" href="user-management-add-user.html">Add User</a>
                                            <a class="nav-link" href="user-management-groups-list.html">Groups List</a>
                                            <a class="nav-link" href="user-management-org-details.html">Organization Details</a>
                                        </nav>
                                    </div> -->
                                    <!-- Nested Sidenav Accordion (Apps -> Posts Management)-->
                                    <!-- <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#appsCollapsePostsManagement" aria-expanded="false" aria-controls="appsCollapsePostsManagement">
                                        Posts Management
                                        <div class="sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="appsCollapsePostsManagement" data-bs-parent="#accordionSidenavAppsMenu">
                                        <nav class="sidenav-menu-nested nav">
                                            <a class="nav-link" href="blog-management-posts-list.html">Posts List</a>
                                            <a class="nav-link" href="blog-management-create-post.html">Create Post</a>
                                            <a class="nav-link" href="blog-management-edit-post.html">Edit Post</a>
                                            <a class="nav-link" href="blog-management-posts-admin.html">Posts Admin</a>
                                        </nav>
                                    </div> -->
                                </nav>
                            </div>
                            <!-- Sidenav Accordion (Flows)-->
                            <div class="sidenav-menu-heading">Document</div>
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
                            <div class="sidenav-footer-title">Pranav Gangani</div>
                        </div>
                    </div>
                </nav>
            </div>