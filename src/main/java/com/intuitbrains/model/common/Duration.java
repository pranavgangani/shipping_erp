package com.intuitbrains.model.common;

import java.util.Objects;

public class Duration {
    private DurationType durationType;
    private int duration;

    public Duration(DurationType durationType, int duration) {
        this.durationType = durationType;
        this.duration = duration;
    }

    public DurationType getDurationType() {
        return durationType;
    }

    public void setDurationType(DurationType durationType) {
        this.durationType = durationType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration1 = (Duration) o;
        return duration == duration1.duration && Objects.equals(durationType, duration1.durationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(durationType, duration);
    }
}
