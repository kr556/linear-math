package org.liner.main;

public abstract class AbsScalar<E extends Number> extends Number implements Scalar<E> {
    public Class<E> getElementsClass() {
        return null;
    }

    @Override
    public String toString() {
        return value().toString();
    }
}
