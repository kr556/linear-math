package org.linear.main;

public non-sealed interface ArrayLong extends Array<Long> {
    long[] toNewArray();
    long[] toArray(long[] pointer);
}