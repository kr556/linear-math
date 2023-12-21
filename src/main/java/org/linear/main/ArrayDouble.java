package org.linear.main;

import org.liner.annotation.Final;

public non-sealed interface ArrayDouble extends Array<Double> {
    @Final
    double[] toNewArray();

    @Final
    double[] toArray(double[] pointer);
}
