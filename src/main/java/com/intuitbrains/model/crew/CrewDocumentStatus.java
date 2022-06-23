package com.intuitbrains.model.crew;

import com.intuitbrains.model.common.document.category.DocumentPool;
import com.intuitbrains.model.company.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CrewDocumentStatus {
    private int id;
    private String desc;
    private String icon;

    public static final CrewDocumentStatus DELETED = new CrewDocumentStatus(0, "Deleted", "<div class='badge bg-light text-body'>Deleted</div>");
    public static final CrewDocumentStatus ENTERED = new CrewDocumentStatus(1, "Entered", "<div class='badge bg-primary text-white'>Entered</div>");
    public static final CrewDocumentStatus PENDING_APPROVAL = new CrewDocumentStatus(5, "Pending Approval", "<div class='badge bg-orange text-white'>Pending Approval</div>");
    public static final CrewDocumentStatus APPROVED = new CrewDocumentStatus(10, "Approved", "<div class='badge bg-green text-white'>Approved</div>");
    public static final CrewDocumentStatus UNDER_REVIEW = new CrewDocumentStatus(15, "Under Review", "<div class='badge bg-info text-white'>Under Review</div>");
    public static final CrewDocumentStatus REJECTED = new CrewDocumentStatus(20, "Rejected", "<div class='badge bg-red text-yellow'>Rejected</div>");

    public CrewDocumentStatus(int id, String desc,String icon) {
        this.id = id;
        this.desc = desc;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getIcon() {
        return icon;
    }

    public static CrewDocumentStatus createFromId(long typeId) {
        return (new ArrayList<>(Arrays.asList(DELETED, ENTERED, PENDING_APPROVAL, APPROVED, UNDER_REVIEW, REJECTED)).stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0);
    }
    public static List<CrewDocumentStatus> getList() {
        return new ArrayList<>(Arrays.asList(DELETED, ENTERED, PENDING_APPROVAL, APPROVED, UNDER_REVIEW, REJECTED));
    }


}
