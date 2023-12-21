package org.linear.main;

public non-sealed interface ArrayFloat extends Array<Float> {
    float[] toNewArray();
    float[] toArray(float[] pointer);
}
