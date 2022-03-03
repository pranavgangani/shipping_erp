package com.shipping.model.common.document.category;

import com.shipping.common.Collection;
import com.shipping.common.Comment;
import com.shipping.common.Flag;
import com.shipping.model.crew.DocumentCategory;
import com.shipping.model.crew.DocumentMatrix;
import com.shipping.util.DateTime;

import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW_DOCUMENT)
public abstract class Document {
    @org.springframework.data.annotation.Id
    protected long Id;
    protected String _type;
    protected DocumentCategory documentCategory;
    private Flag flag;
    private boolean isMandatory;

    //Doc details
    protected String docName, docDesc;
    private String docTitle;
    private String docNumber;
    private String docType;
    private String givenName;
    private String remarks;
    private DateTime dateOfIssue, dateOfExpiry;

    //Validity Level
    private DocumentMatrix documentMatrix;

    //Required when storing against Crew
    private List<Comment> comments;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
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

    public DateTime getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(DateTime dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public DateTime getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(DateTime dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}