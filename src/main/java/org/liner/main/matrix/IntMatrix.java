package org.liner.main.matrix;

import org.liner.main.ArithmeticInt;
import org.liner.main.Array;
import org.liner.main.ArrayInt;

public abstract class IntMatrix<V extends IntMatrix<V, TRNS> & ArrayInt, TRNS extends IntMatrix<TRNS, V> & ArrayInt>
        extends AbsMatrix<Integer, V, TRNS>
        implements ArithmeticInt<V>, ArrayInt {
    public IntMatrix(V copy) {
        if (copy != null) {
            this.copy(copy);
        }
    }

    public abstract int reduction();

    @Override
    public int[] newArray() {
        return toArray(new int[elementsSize()]);
    }
}
