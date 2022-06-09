<nav class="nav nav-borders">
    <div class="dropdown">
        <a href="/crew/overview?menu=overview&action=modify&crewId=${crewId}">
            <button class="btn <c:choose><c:when test="${menu == 'overview'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose>" type="button">Overview</button>
        </a>
    </div>
    <div class="dropdown">
        <button class="btn <c:choose><c:when test="${menu == 'personal'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose> dropdown-toggle" id="dropdownPersonal" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Personal
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownPersonal">
            <a class="dropdown-item" href="/crew/personal?menu=personal&action=modify&crewId=${crewId}">Personal</a>
            <a class="dropdown-item" href="/crew/personal?menu=personal&action=modify&crewId=${crewId}">Address</a>
            <a class="dropdown-item" href="/crew/personal?menu=personal&action=modify&crewId=${crewId}">NOK</a>
            <%--<a class="dropdown-item" href="#!">Working Gear</a>--%>
            <a class="dropdown-item" href="/crew/bank?menu=personal&action=modify&crewId=${crewId}">Bank Account</a>
            <%--<a class="dropdown-item" href="#!">Status</a>--%>
            <a class="dropdown-item" href="/crew/insurance?menu=personal&action=modify&crewId=${crewId}">Insurance</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="btn <c:choose><c:when test="${menu == 'documents'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose> dropdown-toggle" id="dropdownDocuments" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Documents
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownDocuments">
            <a class="dropdown-item" href="/crew/documents?menu=documents&sMenu=documents&crewId=${crewId}">Documents</a>
            <a class="dropdown-item" href="/crew/travel?menu=documents&sMenu=documents&crewId=${crewId}">Travel</a>
            <a class="dropdown-item" href="/crew/license?menu=documents&sMenu=documents&crewId=${crewId}">License</a>
            <a class="dropdown-item" href="/crew/medical?menu=documents&sMenu=documents&crewId=${crewId}">Medical</a>
            <a class="dropdown-item" href="/crew/courses?menu=documents&sMenu=documents&crewId=${crewId}">Courses</a>
            <a class="dropdown-item" href="/crew/cbt?menu=documents&sMenu=documents&crewId=${crewId}">CBT & EPSS</a>
            <a class="dropdown-item" href="/crew/epss?menu=documents&sMenu=documents&crewId=${crewId}">EPSS</a>
            <a class="dropdown-item" href="/crew/academic?menu=documents&sMenu=documents&crewId=${crewId}">Academic</a>
            <a class="dropdown-item" href="/crew/award?menu=documents&sMenu=documents&crewId=${crewId}">Award</a>
            <a class="dropdown-item" href="/crew/other?menu=documents&sMenu=documents&crewId=${crewId}">Other</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="btn btn-light dropdown-toggle" id="dropdownEvaluation" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Evaluation
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownEvaluation">
            <a class="dropdown-item" href="#!">Appraisals</a>
            <a class="dropdown-item" href="#!">Superintendent Evaluation</a>
            <a class="dropdown-item" href="#!">Briefing</a>
            <a class="dropdown-item" href="#!">Assessment</a>
            <a class="dropdown-item" href="#!">Reference</a>
            <a class="dropdown-item" href="#!">Promotion Summary</a>
            <a class="dropdown-item" href="#!">Events</a>
            <a class="dropdown-item" href="#!">About us By</a>
            <a class="dropdown-item" href="#!">Feedback</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="btn btn-light dropdown-toggle" id="dropdownTraining" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Training
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownTraining">
            <a class="dropdown-item" href="#!">Pending/Completed Training</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="btn btn-light dropdown-toggle" id="dropdownHistory" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">History
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownHistory">
            <a class="dropdown-item" href="#!">Offer Letter</a>
            <a class="dropdown-item" href="#!">App. Letter</a>
            <a class="dropdown-item" href="#!">Medical</a>
            <a class="dropdown-item" href="#!">Activity Log</a>
            <a class="dropdown-item" href="#!">Travel History</a>
            <a class="dropdown-item" href="#!">Proposal History</a>
            <a class="dropdown-item" href="#!">Letter of Intent History</a>
            <a class="dropdown-item" href="#!">Assessment History</a>
            <a class="dropdown-item" href="#!">Waiver History</a>
            <a class="dropdown-item" href="#!">De-Briefing History</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="btn btn-light dropdown-toggle" id="dropdownExperience" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Experience
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownExperience">
            <a class="dropdown-item" href="#!">Sea Service Company</a>
            <a class="dropdown-item" href="#!">Sea Service Other</a>
            <a class="dropdown-item" href="#!">Sea Service combined</a>
            <a class="dropdown-item" href="#!">Work experience</a>
            <a class="dropdown-item" href="#!">Summary</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="btn btn-light dropdown-toggle" id="dropdownActivities" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Activities
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownActivities">
            <a class="dropdown-item" href="#!">Propose</a>
            <a class="dropdown-item" href="#!">Activities</a>
            <a class="dropdown-item" href="#!">Proposals</a>
            <a class="dropdown-item" href="#!">Unallocated Exp</a>
        </div>
    </div>
    <div class="dropdown">
        <a href="/crew/modify?menu=correspondence&crewId=${crewId}">
            <button class="btn <c:choose><c:when test="${menu == 'correspondence'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose>" type="button">Correspondence</button>
        </a>
    </div>
    <div class="dropdown">
        <button class="btn btn-light dropdown-toggle" id="dropdownRemarks" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Remarks
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownRemarks">
            <a class="dropdown-item" href="#!">General</a>
            <a class="dropdown-item" href="#!">Action Item</a>
            <a class="dropdown-item" href="#!">Owner</a>
        </div>
    </div>
</nav>