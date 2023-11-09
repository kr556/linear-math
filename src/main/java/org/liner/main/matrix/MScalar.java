package org.liner.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.liner.main.Scalar;

import java.util.Objects;

public non-sealed class MScalar<E extends Number> extends Number implements Scalar<E>, Matrix<E, MScalar<E>, MScalar<E>> {
    public E x;

    public MScalar(E value) {
        this.x = value;
    }

    @Override
    public E value() {
        return x;
    }

    @Override
    public E set(E value) {
        this.x = value;
        return x;
    }

    @Override
    public E get(int index) {
        if (index == 1) {
            return x;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public E[] toArray() {
        return (E[]) new Number[]{x};
    }

    @Override
    public boolean isScalar() {
        return true;
    }

    @Override
    public boolean equals(@NotNull MScalar<E> value) {
        return Objects.equals(value.x, this.x);
    }

    @Override
    public MScalar<E> transpose() {
        return this;
    }

    @Override
    public MScalar<E> transpose(MScalar<E> pointer) {
        pointer.set(pointer.x);
        return pointer;
    }

    @Override
    public boolean isSquare() {
        return true;
    }

    @Override
    public int rowsSize() {
        return 1;
    }

    @Override
    public int columnsSize() {
        return 1;
    }

    @Override
    public E[] getRow(int index) {
        return (E[]) new Number[]{x};
    }

    @Override
    public E[] getColumn(int index) {
        return (E[]) new Number[]{x};
    }

    @Override
    public void set(int r, int c, E value) {
        if (r == 0 && c == 0) {
            this.x = value;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public int intValue() {
        return x.intValue();
    }

    @Override
    public long longValue() {
        return x.longValue();
    }

    @Override
    public float floatValue() {
        return x.floatValue();
    }

    @Override
    public double doubleValue() {
        return x.doubleValue();
    }
}
