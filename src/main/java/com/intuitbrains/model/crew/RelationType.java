package com.intuitbrains.model.crew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RelationType{
    MOTHER("Mother"),
    FATHER("Father"),
    SISTER("Sister"),
    BROTHER("Brother"),
    DAUGHTER("Daughter"),
    SON("Son"),
    WIFE("Wife"),
    HUSBAND("Husband"),
    COUSIN("Cousin"),
    GRANDMOTHER("Grandmother"),
    GRANDFATHER("Grandfather");

    private String relationTypeName;

    RelationType(String relationTypeName) {
        this.relationTypeName = relationTypeName;
    }

    public String getRelationTypeName() {
        return relationTypeName;
    }

    public static void main(String[] args) {
        Arrays.stream(RelationType.values()).forEach(v->System.out.println(v.getRelationTypeName()));
    }
    public static RelationType createFromDesc(String name) {
        return ((Arrays.stream(values()).filter(o->o.getRelationTypeName().equalsIgnoreCase(name)).collect(Collectors.toList())).get(0));
    }
    public static List<RelationType> getList() {
        return new ArrayList<>(Arrays.asList(values()));
    }
}
