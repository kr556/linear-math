package org.liner.main;

public sealed interface Array<E> permits ArrayDouble, ArrayFloat, ArrayInt, ArrayLong, Scalar {
    E get(int index);
    E[] toArray();
}
