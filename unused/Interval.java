package com.admir.demiraj.springbootfuultutorial2.unused;

import java.time.Instant;

public class Interval {

    /** This instance is the only instance of an empty interval */
    public static final Interval EMPTY = new Interval(null, null);

    public final Instant from;
    public final Instant to;

    public Interval(Instant from, Instant to) {
        this.from = from;
        this.to = to;
    }

    /** Is this interval empty? */
    public boolean isEmpty() {
        return this == EMPTY;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "(empty)";
        if (from == null && to == null) return "(unbounded)";
        return "[" + (from != null ? from : "") + "," + (to != null ? to : "") + "]";
    }
}