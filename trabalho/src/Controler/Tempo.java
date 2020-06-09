package Controler;

import java.time.*;

public class Tempo extends Clock {

    private final Instant t0Instant;
    private final LocalDateTime t0LocalDateTime;

    private final ZoneOffset zoneOffset;
    private final Instant whenObjectCreatedInstant;

    public Tempo (LocalDateTime t0, ZoneOffset zoneOffset){
        this.zoneOffset = zoneOffset;
        this.t0LocalDateTime = t0;
        this.t0Instant = t0.toInstant(zoneOffset);
        this.whenObjectCreatedInstant = Instant.now();
    }

     public ZoneId getZone() {
        return zoneOffset;
    }

    /** The caller needs to actually pass a ZoneOffset object here. */
     public Clock withZone(ZoneId zone) {
        return new Tempo( t0LocalDateTime, (ZoneOffset) zone);
    }

     public Instant instant() {
        return nextInstant();
    }

    //PRIVATE

    /** t0 is the moment this clock object was created in Java-land. */

    /**
     Figure out how much time has elapsed between the moment this
     object was created, and the moment when this method is being called.
     Then, apply that diff to t0.
     */
    private Instant nextInstant() {
        Instant now = Instant.now();
        long diff = now.toEpochMilli() - whenObjectCreatedInstant.toEpochMilli();
        return t0Instant.plusMillis(diff);
    }
}
