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
            <a class="dropdown-item <c:if test="${sMenu == 'personal'}">active</c:if>" href="/crew/personal?menu=personal&sMenu=personal&action=modify&crewId=${crewId}">Personal</a>
            <a class="dropdown-item <c:if test="${sMenu == 'address'}">active</c:if>" href="/crew/address?menu=personal&sMenu=address&action=modify&crewId=${crewId}">Address</a>
            <a class="dropdown-item <c:if test="${sMenu == 'nok'}">active</c:if>" href="/crew/nok?menu=personal&sMenu=nok&action=modify&crewId=${crewId}">NOK</a>
            <%--<a class="dropdown-item" href="#!">Working Gear</a>--%>
            <a class="dropdown-item <c:if test="${sMenu == 'bank'}">active</c:if>" href="/crew/bank?menu=personal&sMenu=bank&action=modify&crewId=${crewId}">Bank Account</a>
            <%--<a class="dropdown-item" href="#!">Status</a>--%>
            <a class="dropdown-item <c:if test="${sMenu == 'insurance'}">active</c:if>" href="/crew/insurance?menu=personal&sMenu=insurance&action=modify&crewId=${crewId}">Insurance</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="btn <c:choose><c:when test="${menu == 'documents'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose> dropdown-toggle" id="dropdownDocuments" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Documents
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownDocuments">
            <a class="dropdown-item <c:if test="${sMenu == 'documents'}">active</c:if>" href="/crew/documents?menu=documents&sMenu=documents&crewId=${crewId}">Documents</a>
            <a class="dropdown-item <c:if test="${sMenu == 'travel'}">active</c:if>" href="/crew/documents?menu=documents&sMenu=travel&type=travel&crewId=${crewId}">Travel</a>
            <a class="dropdown-item <c:if test="${sMenu == 'license'}">active</c:if>" href="/crew/documents?menu=documents&sMenu=license&type=license&crewId=${crewId}">License</a>
            <a class="dropdown-item <c:if test="${sMenu == 'medical'}">active</c:if>" href="/crew/documents?menu=documents&sMenu=medical&type=medical&crewId=${crewId}">Medical</a>
            <a class="dropdown-item <c:if test="${sMenu == 'course'}">active</c:if>" href="/crew/documents?menu=documents&sMenu=course&type=course&crewId=${crewId}">Courses</a>
            <a class="dropdown-item <c:if test="${sMenu == 'cbt'}">active</c:if>" href="/crew/documents?menu=documents&sMenu=cbt&type=cbt&crewId=${crewId}">CBT & EPSS</a>
            <a class="dropdown-item <c:if test="${sMenu == 'academics'}">active</c:if>" href="/crew/documents?menu=documents&sMenu=academics&type=education&crewId=${crewId}">Academic</a>
            <a class="dropdown-item <c:if test="${sMenu == 'award'}">active</c:if>" href="/crew/documents?menu=documents&sMenu=award&type=award&crewId=${crewId}">Award</a>
            <a class="dropdown-item <c:if test="${sMenu == 'other'}">active</c:if>" href="/crew/documents?menu=documents&sMenu=other&type=other&crewId=${crewId}">Other</a>
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
            <%--<a class="dropdown-item" href="#!">Reference</a>
            <a class="dropdown-item" href="#!">Promotion Summary</a>
            <a class="dropdown-item" href="#!">Events</a>
            <a class="dropdown-item" href="#!">About us By</a>
            <a class="dropdown-item" href="#!">Feedback</a>--%>
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
        <button class="btn dropdown-toggle <c:choose><c:when test="${menu == 'hist'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose>" id="dropdownHistory" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">History
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownHistory">
            <a class="dropdown-item <c:if test="${sMenu == 'offer'}">active</c:if>" href="/crew/offer?menu=hist&sMenu=offer&action=list&crewId=${crewId}">Offer Letter</a>
            <a class="dropdown-item <c:if test="${sMenu == 'appt'}">active</c:if>" href="/crew/appoint?menu=hist&sMenu=appt&crewId=${crewId}">App. Letter</a>
            <a class="dropdown-item" href="#!">Medical</a>
            <a class="dropdown-item" href="#!">Activity Log</a>
            <a class="dropdown-item" href="#!">Travel History</a>
<%--            <a class="dropdown-item" href="#!">Proposal History</a>
            <a class="dropdown-item" href="#!">Letter of Intent History</a>--%>
            <a class="dropdown-item" href="#!">Assessment History</a>
            <a class="dropdown-item" href="#!">Waiver History</a>
            <a class="dropdown-item" href="#!">De-Briefing History</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="btn dropdown-toggle <c:choose><c:when test="${menu == 'exp'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose>" id="dropdownExperience" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Experience
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownExperience">
            <a class="dropdown-item <c:if test="${sMenu == 'company'}">active</c:if>" href="/crew/experience?menu=exp&sMenu=company&crewId=${crewId}">Sea Service Company</a>
            <a class="dropdown-item <c:if test="${sMenu == 'other'}">active</c:if>" href="/crew/experience?menu=exp&sMenu=other&crewId=${crewId}">Sea Service Other</a>
            <a class="dropdown-item <c:if test="${sMenu == 'combined'}">active</c:if>" href="/crew/experience?menu=exp&sMenu=combined&crewId=${crewId}">Sea Service combined</a>
            <a class="dropdown-item <c:if test="${sMenu == 'workExp'}">active</c:if>" href="/crew/experience?menu=exp&sMenu=workExp&crewId=${crewId}">Work experience</a>
            <a class="dropdown-item <c:if test="${sMenu == 'summary'}">active</c:if>" href="/crew/experience?menu=exp&sMenu=summary&crewId=${crewId}">Summary</a>
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
            <%--<a class="dropdown-item" href="#!">Action Item</a>--%>
            <a class="dropdown-item" href="#!">Owner</a>
        </div>
    </div>
</nav>