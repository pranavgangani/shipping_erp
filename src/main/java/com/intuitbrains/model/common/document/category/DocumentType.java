package com.intuitbrains.model.common.document.category;

import com.intuitbrains.common.Collection;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

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
}
