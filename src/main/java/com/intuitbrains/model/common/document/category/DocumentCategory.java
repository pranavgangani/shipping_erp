package com.intuitbrains.model.common.document.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

public class DocumentCategory {
    public final static DocumentCategory TRAVEL = new DocumentCategory(1, "Travel");
    public final static DocumentCategory EDUCATION = new DocumentCategory(2, "Education");
    public final static DocumentCategory TRAINING = new DocumentCategory(3, "Training");
    public final static DocumentCategory MEDICAL = new DocumentCategory(4, "Medical");
    public final static DocumentCategory FINANCIAL = new DocumentCategory(5, "Financial");
    public final static DocumentCategory INFORMATION = new DocumentCategory(6, "Information");
    public final static DocumentCategory EMPLOYMENT = new DocumentCategory(7, "Employment");
    public final static DocumentCategory LEGAL = new DocumentCategory(8, "Legal");
    public final static DocumentCategory IDENTIFICATION = new DocumentCategory(9, "Identification");
    public final static DocumentCategory MISC = new DocumentCategory(0, "Miscellaneous");

    @Id
    private int id;
    private String name;

    public DocumentCategory() {
    }

    public DocumentCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DocumentCategory other = (DocumentCategory) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RankCategory [id=" + id + ", name=" + name + "]";
    }

    public static List<DocumentCategory> getList() {
        return new ArrayList<>(Arrays.asList(TRAVEL, EMPLOYMENT, TRAINING, MEDICAL, MISC, EDUCATION, IDENTIFICATION, INFORMATION, FINANCIAL, LEGAL));
    }

    public static DocumentCategory createFromId(int typeId) {
        return ((getList().stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0));
    }

    public static DocumentCategory createFromName(String name) {
        for (DocumentCategory cat : getList()) {
            if (cat.getName().equalsIgnoreCase(name)) {
                return cat;
            }
        }
        return null;
    }
}
