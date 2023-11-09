package org.liner.main;

public non-sealed interface ArrayInt extends Array<Integer> {
    int[] newArray();
    int[] toArray(int[] pointer);
}
