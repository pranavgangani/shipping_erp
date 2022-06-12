<nav class="nav nav-borders">
    <div class="dropdown">
        <a href="/vessel/overview?menu=overview&action=modify&vesselId=${vesselId}">
            <button class="btn <c:choose><c:when test="${menu == 'overview'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose>" type="button">Overview</button>
        </a>
    </div>
    <div class="dropdown">
        <button class="btn <c:choose><c:when test="${menu == 'details'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose> dropdown-toggle" id="dropdownDetails" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Details
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownDetails">
            <a class="dropdown-item" href="/vessel/details?menu=details&action=modify&vesselId=${vesselId}">Details</a>
            <a class="dropdown-item" href="/vessel/journeys?menu=journeys&action=modify&vesselId=${vesselId}">Journeys</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="btn <c:choose><c:when test="${menu == 'documents'}">btn-primary</c:when><c:otherwise>btn-light</c:otherwise></c:choose> dropdown-toggle" id="dropdownDocuments" type="button"
                data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Documents
        </button>
        <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownDocuments">
            <a class="dropdown-item" href="/vessel/documents?menu=documents&sMenu=documents&vesselId=${vesselId}">Documents</a>
            <a class="dropdown-item" href="/vessel/documents?menu=documents&sMenu=license&type=license&vesselId=${vesselId}">License</a>
            <a class="dropdown-item" href="/vessel/documents?menu=documents&sMenu=license&type=license&vesselId=${vesselId}">Insurance</a>
        </div>
    </div>
   <%--
    <div class="dropdown">
        <a href="/vessel/modify?menu=correspondence&vesselId=${vesselId}">
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
        </div>
    </div>--%>
</nav>