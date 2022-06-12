package com.intuitbrains.model.vessel;

import com.intuitbrains.common.Collection;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.COMMUNICATION)

public class Communication {
    @Transient
    public static final String SEQUENCE_NAME = Collection.COMMUNICATION;

    @Id
    private long id;

}
