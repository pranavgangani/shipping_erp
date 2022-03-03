package com.shipping.model.common.document.category;

import com.shipping.util.DateTime;

public abstract class EducationDocument extends Document {
    protected String instituteName, instituteAddress;
    protected DateTime startDate, endDate;

}
