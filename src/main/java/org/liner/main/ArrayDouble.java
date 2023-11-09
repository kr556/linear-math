package org.liner.main;

public non-sealed interface ArrayDouble extends Array<Double> {
    double[] newArray();
    double[] toArray(double[] pointer);
}
