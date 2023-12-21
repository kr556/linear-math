package org.linear.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.linear.main.vector.*;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;
import org.linear.main.Linear;

import java.nio.Buffer;

/**
 * @param <E>    Elements type.
 * @param <V>    Mine type
 * @param <TRNS> Transposed matrix type.
 */
public interface Matrix<E extends Number, V extends Matrix<E, V, TRNS>, TRNS extends Matrix<E, TRNS, V>>
        extends Linear<E, V> {
    V create();

    @PropertiesMethod
    int columnDimension();

    @PropertiesMethod
    int rowDimension();

    @Final
    E[] getRow(int index);

    @Final
    E[] getColumn(int index);

    @Final
    void set(int r, int c, E value);

    @PropertiesMethod
    boolean isSquare();

    @PropertiesMethod
    default boolean isVector() {
        return false;
    }

    @PropertiesMethod
    default int elementsSize() {
        return columnDimension() * rowDimension();
    }

    @Final
    @Override
    default E[] toArray(E[] pointer) {
        if (pointer == null) return null;

        for (int i = 0; i < elementsSize(); i++) {
            pointer[i] = get(i);
        }

        return pointer;
    }

    @Final
    @Override
    default Buffer get(Buffer pointer) {
        E[] es = toArray();

        if (this instanceof VectorFunctions<?>) {
            return ((VectorMatrix<E, ?>) this).toVector().get(pointer);
        } else {
            if (es[0] instanceof Float) {
                return ((Vector<E, ?>) new Vectornf((Float[]) es)).get(pointer);

            } else if (es[0] instanceof Double) {
                return ((Vector<E, ?>) new Vectornd((Double[]) es)).get(pointer);

            } else if (es[0] instanceof Integer) {
                return ((Vector<E, ?>) new Vectorni((Integer[]) es)).get(pointer);

            } else if (es[0] instanceof Long) {
                return ((Vector<E, ?>) new Vectornl((Long[]) es)).get(pointer);
            }

            throw new UnsupportedOperationException("Unsupport elements type");
        }
    }

    @Override
    default void set(int index, @NotNull E value) {
        int rows = index / columnDimension();
        set(rows, index - rowDimension() * rows, value);
    }

    default void map(MatrixForEach<E> map) {
        if (map == null) return;

        for (int r = 0; r < columnDimension(); r++) {
            for (int c = 0; c < rowDimension(); c++) {
                set(r, c, map.set(r, c));
            }
        }
    }

    @FunctionalInterface
    interface MatrixForEach<E> {
        E set(int r, int c);
    }
}
