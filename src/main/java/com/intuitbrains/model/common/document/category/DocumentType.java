package com.intuitbrains.model.common.document.category;

import com.intuitbrains.common.Collection;
import com.intuitbrains.model.crew.DocumentMatrix;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.DOCUMENT_TYPE)
public class DocumentType {
    @Transient
    public static final String SEQUENCE_NAME = Collection.DOCUMENT_TYPE;

    @Id
    private long id;
    private String shortName, name, desc;
    private String flagCode;
    private DocumentCategory documentCategory;
    private DocumentPool documentPool;

    //Validity Level
    private DocumentMatrix documentMatrix;
    private boolean isMandatory, isRequiredBeforeJoining, isRequiredAfterJoining, isRequiredOnBoard;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DocumentCategory getDocumentCategory() {
        return documentCategory;
    }

    public void setDocumentCategory(DocumentCategory documentCategory) {
        this.documentCategory = documentCategory;
    }

    public DocumentPool getDocumentPool() {
        return documentPool;
    }

    public void setDocumentPool(DocumentPool documentPool) {
        this.documentPool = documentPool;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
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
}
