package com.intuitbrains.model.crew;

import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Comment;
import com.intuitbrains.common.Flag;
import com.intuitbrains.dao.common.FieldStatus;
import com.intuitbrains.model.common.DurationType;
import com.intuitbrains.model.common.document.category.DocumentType;
import com.intuitbrains.model.company.Employee;
import org.bson.types.Binary;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW_DOCUMENT)
public class CrewDocument {
    @Transient
    public static final String SEQUENCE_NAME = Collection.CREW_DOCUMENT;

    @org.springframework.data.annotation.Id
    protected long id;
    protected String _type;

    protected long crewId;
    private DocumentType docType;
    private Flag flag;
    private Binary file;

    public CrewDocument() {
    }

    //Doc details
    protected String docName, docDesc;
    private String docTitle;
    private String docNumber;
    private String givenName;
    private String remarks;
    private LocalDate dateOfIssue, dateOfExpiry;
    private String placeOfIssue;
    private int versionId;
    private FieldStatus fieldStatus;

    private int validity;
    private DurationType durationType;
    private CrewDocumentStatus status;

    //Required when storing against Crew
    private List<Comment> comments;

    private Employee enteredBy, updatedBy, deletedBy, approvedBy, rejectedBy, pendingApprovalBy, underReviewBy;
    private LocalDateTime enteredDateTime, updatedDateTime, deletedDateTime, approvedDateTime, rejectedDateTime, pendingApprovalDateTime, underReviewDateTime;

    //Physical File
    private String fileTitle;

    public long getCrewId() {
        return crewId;
    }

    public void setCrewId(long crewId) {
        this.crewId = crewId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocDesc() {
        return docDesc;
    }

    public void setDocDesc(String docDesc) {
        this.docDesc = docDesc;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public DocumentType getDocType() {
        return docType;
    }

    public void setDocType(DocumentType docType) {
        this.docType = docType;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity, DurationType durationType) {
        this.validity = validity;
        this.durationType = durationType;
    }

    public DurationType getDurationType() {
        return durationType;
    }

    public void setDurationType(DurationType durationType) {
        this.durationType = durationType;
    }

    public CrewDocumentStatus getStatus() {
        return status;
    }

    public void setStatus(CrewDocumentStatus status) {
        this.status = status;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public Binary getFile() {
        return file;
    }

    public void setFile(Binary file) {
        this.file = file;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public int getVersionId() {
        return versionId;
    }

    public FieldStatus getFieldStatus() {
        return fieldStatus;
    }

    public void setFieldStatus(FieldStatus fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public boolean isFileUploaded() {
        return this.getFile() != null;
    }

    public Employee getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(Employee enteredBy) {
        this.enteredBy = enteredBy;
    }

    public Employee getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Employee updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getEnteredDateTime() {
        return enteredDateTime;
    }

    public void setEnteredDateTime(LocalDateTime enteredDateTime) {
        this.enteredDateTime = enteredDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Employee getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Employee deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Employee getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Employee getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(Employee rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public Employee getPendingApprovalBy() {
        return pendingApprovalBy;
    }

    public void setPendingApprovalBy(Employee pendingApprovalBy) {
        this.pendingApprovalBy = pendingApprovalBy;
    }

    public Employee getUnderReviewBy() {
        return underReviewBy;
    }

    public void setUnderReviewBy(Employee underReviewBy) {
        this.underReviewBy = underReviewBy;
    }

    public LocalDateTime getDeletedDateTime() {
        return deletedDateTime;
    }

    public void setDeletedDateTime(LocalDateTime deletedDateTime) {
        this.deletedDateTime = deletedDateTime;
    }

    public LocalDateTime getApprovedDateTime() {
        return approvedDateTime;
    }

    public void setApprovedDateTime(LocalDateTime approvedDateTime) {
        this.approvedDateTime = approvedDateTime;
    }

    public LocalDateTime getRejectedDateTime() {
        return rejectedDateTime;
    }

    public void setRejectedDateTime(LocalDateTime rejectedDateTime) {
        this.rejectedDateTime = rejectedDateTime;
    }

    public LocalDateTime getPendingApprovalDateTime() {
        return pendingApprovalDateTime;
    }

    public void setPendingApprovalDateTime(LocalDateTime pendingApprovalDateTime) {
        this.pendingApprovalDateTime = pendingApprovalDateTime;
    }

    public LocalDateTime getUnderReviewDateTime() {
        return underReviewDateTime;
    }

    public void setUnderReviewDateTime(LocalDateTime underReviewDateTime) {
        this.underReviewDateTime = underReviewDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrewDocument document = (CrewDocument) o;
        return id == document.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
