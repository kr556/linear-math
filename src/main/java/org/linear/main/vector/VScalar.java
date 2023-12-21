package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;
import org.liner.annotation.PropertiesMethod;
import org.linear.main.AbsScalar;
import org.linear.main.Scalar;

import java.nio.*;
import java.util.Objects;

public final class VScalar<E extends Number> extends AbsScalar<E> implements Vector<E, VScalar<E>>, Scalar<E> {
    public E x;

    public VScalar(E value) {
        this.x = value;
    }

    @Override
    public Buffer get(Buffer pointer) {
        if (x == null) {
            return null;
        } else if (x instanceof Float) {
            ((FloatBuffer) pointer).put(0, (Float) x);
        } else if (x instanceof Double) {
            ((DoubleBuffer) pointer).put(0, (Double) x);
        } else if (x instanceof Byte) {
            ((ByteBuffer) pointer).put(0, (Byte) x);
        } else if (x instanceof Integer) {
            ((IntBuffer) pointer).put(0, (Integer) x);
        } else {
            throw new UnsupportedOperationException("This type is unsupported.");
        }
        return pointer;
    }

    @Override
    public E[] toArray(E[] pointer) {
        pointer[0] = x;
        return pointer;
    }

    @Override
    public E[] toArray() {
        return (E[]) new Number[]{x};
    }

    @PropertiesMethod
    @Override
    public final boolean isScalar() {
        return true;
    }

    @Override
    public boolean equals(@NotNull VScalar<E> value) {
        return Objects.equals(value.x, this.x);
    }

    // TODO: 2023/11/24
    @Override
    public final boolean isNaN() {
        return false;
    }

    @Override
    public E get(int index) {
        if (index == 1) {
            return x;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void set(int index, @NotNull E value) {
        if (index == 0) {
            this.x = value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public final int dimension() {
        return 1;
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
