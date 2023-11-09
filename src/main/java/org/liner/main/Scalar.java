package org.liner.main;

public non-sealed interface Scalar<E extends Number> extends Array<E> {
    E value();
    E set(E value);
}
