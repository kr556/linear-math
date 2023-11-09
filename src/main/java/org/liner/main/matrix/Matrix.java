package org.liner.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.liner.main.Array;
import org.liner.main.Linear;
import org.liner.main.vector.*;

import java.nio.Buffer;

/**
 * @param <E> Elements type.
 * @param <V> Mine type
 * @param <TRNS> Transposed matrix type.
 */
public sealed interface Matrix<E extends Number, V extends Matrix<E, V, TRNS> & Array<E>, TRNS extends Matrix<E, TRNS, V> & Array<E>>
        extends Linear<E, V>, MatrixFunctions<V, TRNS>
        permits AbsMatrix, MScalar, NonVextorMatrix {
    int rowsSize();
    int columnsSize();
    E[] getRow(int index);
    E[] getColumn(int index);
    void set(int r, int c, E value);
    TRNS transpose();
    TRNS transpose(TRNS pointer);
    boolean isSquare();

    private int posToIndex(int r, int c) {
        return r * columnsSize() + c;
    }

    default int elementsSize() {
        return rowsSize() * columnsSize();
    }

    @Override
    default E[] get(E[] pointer) {
        if (pointer == null) return null;

        for (int i = 0; i < elementsSize(); i++) {
            pointer[i] = get(i);
        }

        return pointer;
    }

    @Override
    default Buffer get(Buffer pointer) {
        E[] es = toArray();


        if (this instanceof VectorMatrix<?, ?>) {
            return ((VectorMatrix<E, ?>) this).toVector().get(pointer);
        } else {
            Vector<E, ?> re;

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
        int rows = index / rowsSize();
        set(rows, index - columnsSize() * rows, value);
    }

    default void map(MatrixForEach<E> map) {
        if (map == null) return;

        for (int r = 0; r < rowsSize(); r++) {
            for (int c = 0; c < columnsSize(); c++) {
                set(r, c, map.set(r, c));
            }
        }
    }

    interface MatrixForEach<E> {
        E set(int r, int c);
    }
}
