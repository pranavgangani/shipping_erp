package com.intuitbrains.model.vessel;

import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Port;
import com.intuitbrains.common.Comment;
import com.intuitbrains.model.crew.Crew;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.JOURNEY)
public class Journey {
    @Transient
    public static final String SEQUENCE_NAME = Collection.JOURNEY;

    @Id
    private long id;

    private Port lastPort, nextPort;
    private LocalDateTime eta;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;
    private List<Comment> comments;
    private List<Crew> crews;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Port getLastPort() {
        return lastPort;
    }

    public void setLastPort(Port lastPort) {
        this.lastPort = lastPort;
    }

    public Port getNextPort() {
        return nextPort;
    }

    public void setNextPort(Port nextPort) {
        this.nextPort = nextPort;
    }

    public LocalDateTime getEta() {
        return eta;
    }

    public void setEta(LocalDateTime eta) {
        this.eta = eta;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
    }

    public enum Status {
        NOT_STARTED(1, "Not Started"),
        ONGOING(2, "Ongoing"),
        ENDED(8, "Completed");

        private int id;
        private String desc;

        Status(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public String getDesc() {
            return desc;
        }

        public static Journey.Status createFromId(int typeId) {
            return ((getList().stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0));
        }

        public static List<Journey.Status> getList() {
            return new ArrayList<>(Arrays.asList(values()));
        }
    }
}
