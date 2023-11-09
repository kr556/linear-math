package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;
import org.liner.main.AbsScalar;
import org.liner.main.Scalar;

import java.nio.*;
import java.util.Objects;

public non-sealed class VScalar<E extends Number> extends AbsScalar<E> implements Vector<E, VScalar<E>>, Scalar<E> {
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
    public E[] get(E[] pointer) {
        pointer[0] = x;
        return pointer;
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
    public boolean equals(@NotNull VScalar<E> value) {
        return Objects.equals(value.x, this.x);
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
    public int dimensional() {
        return 1;
    }

    @Override
    public double distance(VScalar<E> value) {
        if (x instanceof Float) {
            return value.x.floatValue() - x.floatValue();
        } else if (x instanceof Double) {
            return value.x.doubleValue() - x.doubleValue();
        } else if (x instanceof Integer) {
            return value.x.intValue() - x.intValue();
        } else if (x instanceof Long) {
            return value.x.longValue() - x.longValue();
        }

        return Double.NaN;
    }

    @Override
    public double len() {
        return this.x.doubleValue();
    }

    @Override
    public double angle(VScalar<E> value) {
        return 0;
    }

    @Override
    public double dot(VScalar<E> value) {
        return this.len() * value.len();
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
