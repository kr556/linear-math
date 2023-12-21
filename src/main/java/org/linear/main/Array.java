package org.linear.main;

import org.liner.annotation.Final;

public sealed interface Array<E> permits ArrayDouble, ArrayFloat, ArrayGeneric, ArrayInt, ArrayLong, Linear, Scalar {
    @Final
    E get(int index);

    @Final
    E[] toArray();

    @Final
    E[] toArray(E[] pointer);
}
