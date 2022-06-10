package com.intuitbrains.model.common.document.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DocumentPool {
    PASSPORT(1, "Passport"),
    VISA(2, "Visa"),
    OKTB(3, "OKTB (Ok-To-Board"),
    TICKET(4, "Ticket"),
    RECEIPT(5, "Receipt"),
    INVOICE(6, "Invoice"),
    BILL(7, "Bill"),
    STATEMENT(8, "Statement"),
    CHEQUE(9, "Cheque"),
    BRIEFING(10, "Briefing"),
    CERTIFICATE(11, "Certificate"),
    CONTRACT(12, "Contract"),
    BRIEF(13, "Briefing"),
    DEBRIEF(14, "Debriefing"),
    DRAWING(15, "Drawing"),
    PHOTO(16, "Photo"),
    DECLARATION(17, "Declaration"),
    FEEDBACK(18, "Feedback"),
    LETTER(19, "Letter"),
    MANUAL(20, "Manual"),
    LICENSE(21, "License"),
    LOG(22, "Log"),
    NATIONAL_ID(23, "National ID"),
    NOTE(24, "Note"),
    INSURANCE(25, "Insurance"),
    SLIP(26, "Slip"),
    REPORT(27, "Report"),
    TAX_ID(28, "Tax ID"),
    OTHER(0, "Other");

    private int id;
    private String name;

    DocumentPool(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<DocumentPool> getList(){
        return new ArrayList<>(Arrays.asList(values()));
    }

    public static DocumentPool createFromId(long typeId) {
        return (new ArrayList<>(Arrays.asList(values())).stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0);
    }

    public static List<DocumentPool> getCoreDocPool(){
        return new ArrayList<>(Arrays.asList(PASSPORT, VISA, LICENSE));
    }
}

