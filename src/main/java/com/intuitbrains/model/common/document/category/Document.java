package com.intuitbrains.model.common.document.category;

import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Comment;
import com.intuitbrains.dao.common.FieldStatus;
import com.intuitbrains.model.common.DurationType;
import com.intuitbrains.model.crew.DocumentMatrix;
import org.bson.types.Binary;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW_DOCUMENT)
public class Document {
    @Transient
    public static final String SEQUENCE_NAME = Collection.CREW_DOCUMENT;

    @org.springframework.data.annotation.Id
    protected long id;
    protected String _type;
    protected DocumentCategory documentCategory;
    private String flagCode;
    protected List<Integer> forVesselTypes;
    protected List<Integer> forVesselSubTypes;
    protected List<Integer> forRankCategories;
    protected List<Integer> forRankSubCategories;
    protected List<Integer> forRanks;
    private boolean isMandatory, isRequiredBeforeJoining, isRequiredAfterJoining, isRequiredOnBoard, isUploaded;

    public Document() {
    }

    //Doc details
    protected String docName, docDesc;
    private String docTitle;
    private String docNumber;
    private long docTypeId;
    private String givenName;
    private String remarks;
    private LocalDate dateOfIssue, dateOfExpiry;
    private String placeOfIssue;
    private int versionId;
    private FieldStatus fieldStatus;

    private int validity;
    private DurationType durationType;

    //Validity Level
    private DocumentMatrix documentMatrix;

    //Required when storing against Crew
    private List<Comment> comments;

    //Physical File
    private String fileTitle;
    private Binary file;

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

    public DocumentCategory getDocumentCategory() {
        return documentCategory;
    }

    public void setDocumentCategory(DocumentCategory documentCategory) {
        this.documentCategory = documentCategory;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
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

    public long getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(long docTypeId) {
        this.docTypeId = docTypeId;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public DocumentMatrix getDocumentMatrix() {
        return documentMatrix;
    }

    public void setDocumentMatrix(DocumentMatrix documentMatrix) {
        this.documentMatrix = documentMatrix;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
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

    public boolean isRequiredBeforeJoining() {
        return isRequiredBeforeJoining;
    }

    public void setRequiredBeforeJoining(boolean requiredBeforeJoining) {
        isRequiredBeforeJoining = requiredBeforeJoining;
    }

    public boolean isRequiredAfterJoining() {
        return isRequiredAfterJoining;
    }

    public void setRequiredAfterJoining(boolean requiredAfterJoining) {
        isRequiredAfterJoining = requiredAfterJoining;
    }

    public boolean isRequiredOnBoard() {
        return isRequiredOnBoard;
    }

    public void setRequiredOnBoard(boolean requiredOnBoard) {
        isRequiredOnBoard = requiredOnBoard;
    }

    public boolean isUploaded() {
        return isUploaded;
    }

    public void setUploaded(boolean uploaded) {
        isUploaded = uploaded;
    }

    public List<Integer> getForVesselTypes() {
        return forVesselTypes;
    }

    public void setForVesselTypes(List<Integer> forVesselTypes) {
        this.forVesselTypes = forVesselTypes;
    }

    public List<Integer> getForVesselSubTypes() {
        return forVesselSubTypes;
    }

    public void setForVesselSubTypes(List<Integer> forVesselSubTypes) {
        this.forVesselSubTypes = forVesselSubTypes;
    }

    public List<Integer> getForRankCategories() {
        return forRankCategories;
    }

    public void setForRankCategories(List<Integer> forRankCategories) {
        this.forRankCategories = forRankCategories;
    }

    public List<Integer> getForRankSubCategories() {
        return forRankSubCategories;
    }

    public void setForRankSubCategories(List<Integer> forRankSubCategories) {
        this.forRankSubCategories = forRankSubCategories;
    }

    public List<Integer> getForRanks() {
        return forRanks;
    }

    public void setForRanks(List<Integer> forRanks) {
        this.forRanks = forRanks;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id == document.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
