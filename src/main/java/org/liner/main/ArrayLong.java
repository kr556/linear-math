package org.liner.main;

public non-sealed interface ArrayLong extends Array<Long> {
    long[] newArray();
    long[] toArray(long[] pointer);
}