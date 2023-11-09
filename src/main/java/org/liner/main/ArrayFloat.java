package org.liner.main;

public non-sealed interface ArrayFloat extends Array<Float> {
    float[] newArray();
    float[] toArray(float[] pointer);
}
